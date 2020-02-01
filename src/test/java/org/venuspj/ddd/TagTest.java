package org.venuspj.ddd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.venuspj.tests.TagAssert;
import org.venuspj.tests.TestPackage;
import org.venuspj.tests.constants.TestSize;
import org.venuspj.util.beans.BeanDesc;
import org.venuspj.util.beans.MethodDesc;
import org.venuspj.util.beans.factory.BeanDescFactory;
import org.venuspj.util.lang.ClassPath;
import org.venuspj.util.objects2.Objects2;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.venuspj.util.objects2.Objects2.isNull;
import static org.venuspj.util.objects2.Objects2.nonNull;

public class TagTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TagTest.class);

    /**
     * 学習テスト
     */
    @Test
    @Tag(TestSize.SMALL)
    @DisplayName("Tagを付けていないテストメソッドをエラーとする")
    public void test1() {
        Set<Class<?>> result = ClassPath.listRecursiveClasses(this.getClass());

        List<Class<?>> testClasses = result
                .stream()
                .filter(c -> getClass().getCanonicalName().endsWith("Test"))
                .filter(Objects2::nonNull)
                .collect(Collectors.toList());
        for (Class<?> clazz : testClasses) {
            BeanDesc bd = BeanDescFactory.getBeanDesc(clazz);
            String[] anyMethodNames = bd.getMethodNames();
            for (String methodName : anyMethodNames) {
                MethodDesc md = bd.getMethodDescNoException(methodName);
                if (nonNull(md)) {
                    Method method = md.getMethod();
                    Test testAnnotation = method.getAnnotation(Test.class);
                    Tag tagAnnotation = method.getAnnotation(Tag.class);
                    if (nonNull(testAnnotation) && isNull(tagAnnotation))
                        LOGGER.error(clazz.getCanonicalName() + "#" + md.getMethodName() + "() " + "はテストメソッドにTagアノテーションを付与してください");

                }
            }
        }

    }

    /**
     * 学習テスト
     */
    @Test
    @Tag(TestSize.SMALL)
    @DisplayName("Tagを付けていないテストメソッドをエラーとする")
    public void test2() {
        TagAssert.assertThat(TestPackage.of("org.venuspj.ddd"))
                .hasTagOnAllTestMethod();

    }
}
