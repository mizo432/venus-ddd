package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.entity.AbstractEntityBuilder;
import org.venuspj.ddd.model.values.buisiness.name.Name;

import static org.venuspj.util.objects2.Objects2.isNull;

public class AbstractOoAza<C extends AbstractOoAza<C>> extends AbstractEntity<C, OoAzaIdentifier> {

    private OoAzaCode ooAzaCode = OoAzaCode.empty();
    private Name name = Name.empty();
    private Name kanaName = Name.empty();


    public AbstractOoAza() {
        super(OoAzaIdentifier.empty());

    }

    protected AbstractOoAza(OoAzaIdentifier aOoAzaIdentifier, OoAzaCode aOoAzaCode,
                            Name aName,
                            Name aKanaName) {
        super(aOoAzaIdentifier);
        ooAzaCode = aOoAzaCode;
        name = aName;
        kanaName = aKanaName;

    }

    /**
     * @param <O>
     * @param <B>
     */
    public static abstract class AbstractOoAzaBuilder
            <O extends AbstractOoAza<O>,
                    B extends AbstractOoAzaBuilder<O, B>>
            extends AbstractEntityBuilder<O, OoAzaIdentifier, B> {
        protected OoAzaCode ooAzaCode = OoAzaCode.empty();
        protected Name name = Name.empty();
        protected Name kanaName = Name.empty();

        @Override
        protected void apply(O vo, B builder) {
            builder.withIdentifier(vo.getIdentifier());
            builder.withCityCode(vo.ooAzaCode());
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

        public B withCityCode(OoAzaCode anOoAzaCode) {
            if (isNull(anOoAzaCode)) return getThis();
            addConfigurator(builder -> builder.ooAzaCode = anOoAzaCode);
            return getThis();

        }

    }

    public Name kanaName() {
        return kanaName;

    }

    public Name name() {
        return name;

    }

    public OoAzaCode ooAzaCode() {
        return ooAzaCode;
    }

}
