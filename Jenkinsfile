pipeline {
    agent any
    // 定数や変数を定義する
    environment {
        reportDir = 'build/reports'
        javaDir = 'src/main/java'
        resourcesDir = 'src/main/resources'
        testReportDir = 'build/test-results/test'
        jacocoReportDir = 'build/jacoco'
        javadocDir = 'build/docs/javadoc'
        libsDir = 'build/libs'
        appName = 'studio-web'
        appVersion = '1.0.0-SNAPSHOT'
    }

    // stagesブロック中に一つ以上のstageを定義する
    stages {
        stage('Preparation') {
            // 実際の処理はstepsブロック中に定義する
            steps {
                deleteDir()
                // このJobをトリガーしてきたGithubのプロジェクトをチェックアウト
                checkout scm
                // ジョブ失敗の原因調査用にJenkinsfileとbuild.gradleは最初に保存する
                archiveArtifacts "Jenkinsfile"
                archiveArtifacts "build.gradle"
                archiveArtifacts "settings.gradle"
                // scriptブロックを使うと従来のScripted Pipelinesの記法も使える
                script {
                    // Permission deniedで怒られないために実行権限を付与する
                    if(isUnix()) {
                        sh 'chmod +x gradlew'
                    }
                }
                gradlew 'clean'
            }
        }


        stage('Compile') {
            steps {
                gradlew 'classes testClasses'
            }
            post {
                // alwaysブロックはstepsブロックの処理が失敗しても成功しても必ず実行される
                always {

                    // JavaDoc生成時に実行するとJavaDocの警告も含まれてしまうので
                    // Javaコンパイル時の警告はコンパイル直後に収集する
                    recordIssues(enabledForFailure: true, tools: [java()])
                }
            }
        }
        stage('analysis') {
            steps {
                // 並列処理の場合はparallelメソッドを使う
                parallel(
                    'static analysis' : {
                        gradlew 'check -x test'
                    },
                    'task-scan': {
                        recordIssues(tools: [taskScanner(highTags: 'FIXME', ignoreCase: true, includePattern: '**/src/main/java/**/*.java', lowTags: 'XXX', normalTags: 'TODO')])
                    },
                    'step count': {
                        // レポート作成
                        stepcounter outputFile: "./build/stepCount.xls", outputFormat: 'excel', settings: [
                            [key: 'Java', filePattern: "**/${javaDir}/**/*.java"],
                            [key: 'SQL', filePattern: "**/${resourcesDir}/**/*.sql"],
                            [key: 'Propety', filePattern: "**/${resourcesDir}/**/*.properties"],
                            [key: 'HTML', filePattern: "**/${resourcesDir}/**/*.html"],
                            [key: 'JS', filePattern: "**/${resourcesDir}/**/*.js"],
                            [key: 'CSS', filePattern: "**/${resourcesDir}/**/*.css"]
                        ]
                    }
                )
            }
            post {
                always {
                    recordIssues enabledForFailure: true, tools: [spotBugs(pattern: '**/build/reports/spotbugs/main.xml')]
                    archiveArtifacts "**/spotbugs/*.xml"
                    // 一応エクセルファイルも成果物として保存する
                    archiveArtifacts allowEmptyArchive: true, artifacts: "**/build/stepCount.xls"
                }
            }

        }
        stage('small test') {
            when {
                not {
                    branch 'PR-*'
                }
            }
            steps {
                gradlew 'test jacocoTestReport -x classes -x testClasses'
                junit allowEmptyResults: true, testResults: "**/${testReportDir}/*.xml"
                archiveArtifacts allowEmptyArchive: true, artifacts: "**/${testReportDir}/*.xml"
                // カバレッジレポートを生成（テストクラスを除外）
                echo 'JacocoReportアーカイブ 開始'
                jacoco exclusionPattern: '**/*Test*.class,**/*Mock*.class,**/forTest/**/*.class'
                echo 'JacocoReportアーカイブ 終了'
            }
        }
        stage('full test') {
            when {
                branch 'PR-*'
            }
            steps {
                gradlew 'testSlow jacocoTestReport -x classes -x testClasses'
                junit allowEmptyResults: true, testResults: "**/${testReportDir}/*.xml"
                archiveArtifacts allowEmptyArchive: true, artifacts: "**/${testReportDir}/*.xml"
                // カバレッジレポートを生成（テストクラスを除外）
                echo 'JacocoReportアーカイブ 開始'
                jacoco exclusionPattern: '**/*Test*.class,**/*Mock*.class,**/forTest/**/*.class'
                echo 'JacocoReportアーカイブ 終了'
            }
        }
    /*
        stage('lib release') {
            when {
                branch 'master'
            }
            steps {
                gradlew 'release -x test -Prelease.useAutomaticVersion=true'
            }
        }
    */

    }
    post {
        always {
                deleteDir()
        }
    }
}

// Gradlewコマンドを実行する
def gradlew(command) {
    if(isUnix()) {
            sh "./gradlew ${command} --stacktrace --daemon --warning-mode all"
        } else {
            bat "./gradlew.bat ${command} --stacktrace  --daemon --warning-mode all"
    }
}