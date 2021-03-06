package org.venuspj.values.model.domain.relashonshipManagement.party.person;

import org.venuspj.ddd.model.values.buisiness.name.Name;

/**
 * 性別.
 * <pre>
 * ISO 5218 Codes for the representation of human sexes
 * Genderではなく生物的な性別を示す
 * </pre>
 */
public enum Sex {
    不明(0, SexCode.of("0"), Name.of("not known"), Name.of("不明")),
    男性(1, SexCode.of("1"), Name.of("male"), Name.of("男性")),
    女性(2, SexCode.of("2"), Name.of("female"), Name.of("女性")),
    適用不能(9, SexCode.of("9"), Name.of("not applicable"), Name.of("適用不能"));

    private final int id;

    public int getId() {
        return id;
    }

    public SexCode getSexCode() {
        return sexCode;
    }

    public Name getName() {
        return name;
    }

    public Name getJapaneseName() {
        return japaneseName;
    }

    private final SexCode sexCode;
    private final Name name;
    private final Name japaneseName;

    Sex(int anId, SexCode aSexCode, Name aName, Name aJapaneseName) {
        id = anId;
        sexCode = aSexCode;
        name = aName;
        japaneseName = aJapaneseName;

    }
}
