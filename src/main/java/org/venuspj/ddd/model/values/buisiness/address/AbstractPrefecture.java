package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.entity.AbstractEntityBuilder;
import org.venuspj.ddd.model.values.buisiness.Name;

import static org.venuspj.util.objects2.Objects2.isNull;


public abstract class AbstractPrefecture<P extends AbstractPrefecture<P>> extends AbstractEntity<P, PrefectureIdentifier> {

    private PrefectureCode prefectureCode = PrefectureCode.empty();
    private Name name = Name.empty();
    private Name kanaName = Name.empty();

    protected AbstractPrefecture() {
        super(PrefectureIdentifier.empty());
    }

    protected AbstractPrefecture(PrefectureIdentifier anIdentifier,
                                 PrefectureCode aPrefectureCode,
                                 Name aName,
                                 Name aKanaName) {
        super(anIdentifier);
        prefectureCode = aPrefectureCode;
        name = aName;
        kanaName = aKanaName;

    }

    protected Name kanaName() {
        return kanaName;
    }

    protected Name name() {
        return name;
    }

    protected PrefectureCode prefectureCode() {
        return prefectureCode;

    }

    @JsonIgnore
    public boolean isEmpty() {
        return getIdentifier().isEmpty() &&
                prefectureCode.isEmpty() &&
                name.isEmpty() &&
                kanaName.isEmpty();

    }

    /**
     * @param <O>
     * @param <B>
     */
    public static abstract class AbstractPrefectureBuilder
            <O extends AbstractPrefecture<O>,
                    B extends AbstractPrefectureBuilder<O, B>>
            extends AbstractEntityBuilder<O, PrefectureIdentifier, B> {
        protected PrefectureCode prefectureCode = PrefectureCode.empty();
        protected Name name = Name.empty();
        protected Name kanaName = Name.empty();

        public B withKanaName(Name aKanaName) {
            if (isNull(aKanaName)) return getThis();
            addConfigurator(builder -> builder.kanaName = aKanaName);
            return getThis();

        }

        public B withName(Name aName) {
            if (isNull(aName)) return getThis();
            addConfigurator(builder -> builder.name = aName);
            return getThis();

        }

        public B withPrefectureCode(PrefectureCode aPrefectureCode) {
            if (isNull(aPrefectureCode)) return getThis();
            addConfigurator(builder -> builder.prefectureCode = aPrefectureCode);
            return getThis();

        }

    }


}
