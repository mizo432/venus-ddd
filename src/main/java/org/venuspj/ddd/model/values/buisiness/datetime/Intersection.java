package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.util.builder.ObjectBuilder;

import java.time.temporal.Temporal;
import java.util.Objects;

import static org.venuspj.util.objects2.Objects2.isNull;

/**
 * インターバルをキーにした交差エンティティ
 *
 * @param <T>
 * @param <I1> 交差エンティティの最初の値の型
 * @param <I2> 交差エンティティの二番目値の型
 */
public class Intersection<T extends Temporal, I1 extends Value<I1>, I2 extends Value<I2>>
        extends AbstractValue<Intersection<T, I1, I2>> {
    private Interval<T> interval;
    private I1 firstValue;
    private I2 secondValue;


    public Intersection() {

    }

    public Interval getInterval() {
        return interval;

    }

    public I1 getFirstValue() {
        return firstValue;

    }

    public I2 getSecondValue() {
        return secondValue;

    }

    private Intersection(Interval<T> anInterval
            , I1 aFirstValue
            , I2 aSecondValue) {
        interval = anInterval;
        firstValue = aFirstValue;
        secondValue = aSecondValue;


    }

    public static <T extends Temporal, V1 extends Value<V1>, V2 extends Value<V2>>
    Intersection<T, V1, V2> createFrom(
            Moment<T> aStartMoment,
            Moment<T> anEndMoment,
            V1 aFirstValue,
            V2 aSecondValue) {
        return new Intersection<>(Interval.createFrom(aStartMoment, anEndMoment), aFirstValue, aSecondValue);


    }

    public static <T extends Temporal, V1 extends Value<V1>, V2 extends Value<V2>> Intersection<T, V1, V2> createFrom(
            Moment<T> aStartMoment,
            V1 aFirstValue,
            V2 aSecondValue) {
        return new Intersection<>(Interval.createFrom(aStartMoment), aFirstValue, aSecondValue);

    }

    @Override
    public boolean sameValueAs(Intersection<T, I1, I2> other) {
        return equals(other);

    }

    @Override
    public boolean isEmpty() {
        return interval.isEmpty() &&
                firstValue.isEmpty() &&
                secondValue.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intersection<?, ?, ?> that = (Intersection<?, ?, ?>) o;
        return Objects.equals(interval, that.interval) &&
                Objects.equals(firstValue, that.firstValue) &&
                Objects.equals(secondValue, that.secondValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interval, firstValue, secondValue);

    }

    public static class IntersectionBuilder<T extends Temporal, V1 extends Value<V1>, V2 extends Value<V2>>
            extends ObjectBuilder<Intersection<T, V1, V2>, IntersectionBuilder<T, V1, V2>> {
        private Moment<T> startMoment;
        private Moment<T> endMoment;
        private V1 firstValue;
        private V2 secondValue;

        @Override
        protected void apply(Intersection<T, V1, V2> vo, IntersectionBuilder<T, V1, V2> builder) {
            builder.withStartMoment(vo.interval.startMoment());
            builder.withEndMoment(vo.interval.endMoment());
            builder.withFirstValue(vo.firstValue());
            builder.withSecondValue(vo.secondValue());


        }

        private IntersectionBuilder<T, V1, V2> withSecondValue(V2 secondValue) {
            if (isNull(startMoment)) return getThis();
            addConfigurator(builder -> builder.startMoment = startMoment);
            return getThis();

        }

        private IntersectionBuilder<T, V1, V2> withFirstValue(V1 firstValue) {
            if (isNull(startMoment)) return getThis();
            addConfigurator(builder -> builder.startMoment = startMoment);
            return getThis();

        }

        public IntersectionBuilder<T, V1, V2> withStartMoment(Moment<T> aStartMoment) {
            if (isNull(startMoment)) return getThis();
            addConfigurator(builder -> builder.startMoment = startMoment);
            return getThis();

        }

        public IntersectionBuilder<T, V1, V2> withEndMoment(Moment<T> anEndMoment) {
            if (isNull(anEndMoment)) return getThis();
            addConfigurator(builder -> builder.endMoment = anEndMoment);
            return getThis();

        }

        @Override
        protected Intersection<T, V1, V2> createValueObject() {
            if (isNull(endMoment))
                return Intersection.createFrom(startMoment, firstValue, secondValue);

            return Intersection.createFrom(startMoment, endMoment, firstValue, secondValue);
        }

        @Override
        protected IntersectionBuilder<T, V1, V2> getThis() {
            return this;

        }

        @Override
        protected IntersectionBuilder<T, V1, V2> newInstance() {
            return new IntersectionBuilder<>();

        }
    }

    public I1 firstValue() {
        return firstValue;

    }

    private I2 secondValue() {
        return secondValue;

    }


}
