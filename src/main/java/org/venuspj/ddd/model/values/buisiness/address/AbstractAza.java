package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.entity.AbstractEntityBuilder;
import org.venuspj.ddd.model.values.buisiness.name.Name;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

public class AbstractAza<C extends AbstractAza<C>> extends AbstractEntity<C, AzaIdentifier> {

    private AzaCode azaCode = AzaCode.empty();
    private Name name = Name.empty();
    private Name kanaName = Name.empty();


    public AbstractAza() {
        super(AzaIdentifier.empty());

    }

    protected AbstractAza(AzaIdentifier aOoAzaIdentifier, AzaCode anAzaCode,
                          Name aName,
                          Name aKanaName) {
        super(aOoAzaIdentifier);
        azaCode = anAzaCode;
        name = aName;
        kanaName = aKanaName;

    }

    public Name kanaName() {
        return kanaName;

    }

    public Name name() {
        return name;

    }

    public AzaCode azaCode() {
        return azaCode;

    }

    @Override
    public boolean sameValueAs(C other) {
        if (this == other) return true;
        if (isNull(other)) return false;
        if (!super.sameValueAs(other)) return false;
        AbstractAza<?> that = other;
        return equal(azaCode, that.azaCode) &&
                equal(name, that.name) &&
                equal(kanaName, that.kanaName);
    }

    /**
     * @param <O>
     * @param <B>
     */
    public static abstract class AbstractAzaBuilder
            <O extends AbstractAza<O>,
                    B extends AbstractAzaBuilder<O, B>>
            extends AbstractEntityBuilder<O, AzaIdentifier, B> {
        protected AzaCode azaCode = AzaCode.empty();
        protected Name name = Name.empty();
        protected Name kanaName = Name.empty();

        @Override
        protected void apply(O vo, B builder) {
            builder.withIdentifier(vo.getIdentifier());
            builder.withAzaCode(vo.azaCode());
            builder.withName(vo.name());
            builder.withKanaName(vo.kanaName());

        }

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

        public B withAzaCode(AzaCode anAzaCode) {
            if (isNull(anAzaCode)) return getThis();
            addConfigurator(builder -> builder.azaCode = anAzaCode);
            return getThis();

        }

    }


}
