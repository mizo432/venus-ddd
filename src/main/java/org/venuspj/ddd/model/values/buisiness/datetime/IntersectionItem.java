package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.util.builder.ObjectBuilder;

import java.time.temporal.Temporal;
import java.util.Objects;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

/**
 * インターバルをキーにした交差エンティティ
 *
 * @param <T>  履歴の瞬間を表すクラス(Year,YearMonth,LocalDate,LocalDateTimeのいずれか)
 * @param <I1> 交差エンティティの最初の値の型
 * @param <I2> 交差エンティティの二番目値の型
 */
public class IntersectionItem<T extends Temporal, I1 extends Value<I1>, I2 extends Value<I2>>
        extends AbstractValue<IntersectionItem<T, I1, I2>> {
    private Interval<T> interval;
    private I1 firstValue;
    private I2 secondValue;


    public IntersectionItem() {

    }

    public Interval<T> getInterval() {
        return interval;

    }

    public I1 getFirstValue() {
        return firstValue;

    }

    public I2 getSecondValue() {
        return secondValue;

    }

    private IntersectionItem(Interval<T> anInterval
            , I1 aFirstValue
            , I2 aSecondValue) {
        interval = anInterval;
        firstValue = aFirstValue;
        secondValue = aSecondValue;


    }

    public static <T extends Temporal, V1 extends Value<V1>, V2 extends Value<V2>>
    IntersectionItem<T, V1, V2> createFrom(
            Moment<T> aStartMoment,
            Moment<T> anEndMoment,
            V1 aFirstValue,
            V2 aSecondValue) {
        return new IntersectionItem<>(Interval.createFrom(aStartMoment, anEndMoment), aFirstValue, aSecondValue);


    }

    public static <T extends Temporal, V1 extends Value<V1>, V2 extends Value<V2>> IntersectionItem<T, V1, V2> createFrom(
            Moment<T> aStartMoment,
            V1 aFirstValue,
            V2 aSecondValue) {
        return new IntersectionItem<>(Interval.createFrom(aStartMoment), aFirstValue, aSecondValue);

    }

    @Override
    public boolean sameValueAs(IntersectionItem<T, I1, I2> other) {
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
        IntersectionItem<?, ?, ?> that = (IntersectionItem<?, ?, ?>) o;
        return Objects.equals(interval, that.interval) &&
                Objects.equals(firstValue, that.firstValue) &&
                Objects.equals(secondValue, that.secondValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interval, firstValue, secondValue);

    }

    public boolean sameItemAs(IntersectionItem<T, I1, I2> other) {
        return equal(this.firstValue, other.firstValue) &&
                equal(this.secondValue, other.secondValue);

    }

    public boolean isContinuous(IntersectionItem<T, I1, I2> other) {
        return interval.isContinuousTo(other.getInterval());

    }

    public IntersectionItem<T, I1, I2> merge(IntersectionItem<T, I1, I2> other) {
        Interval<T> resultInterval = Interval.createFrom(interval.startMoment, other.interval.endMoment);
        return IntersectionItem
                .createFrom(resultInterval
                        , firstValue
                        , secondValue);

    }

    public static <I1 extends Value<I1>, T extends Temporal, I2 extends Value<I2>>
    IntersectionItem<T, I1, I2> createFrom(Interval<T> anInterval, I1 aFirstValue, I2 aSecondValue) {
        return new IntersectionItem<>(anInterval, aFirstValue, aSecondValue);

    }

    public boolean isOverlap(IntersectionItem<T, I1, I2> other) {
        return interval.isOverlap(other.interval);

    }

    public static class IntersectionBuilder<T extends Temporal, V1 extends Value<V1>, V2 extends Value<V2>>
            extends ObjectBuilder<IntersectionItem<T, V1, V2>, IntersectionBuilder<T, V1, V2>> {
        private Moment<T> startMoment;
        private Moment<T> endMoment;
        private V1 firstValue;
        private V2 secondValue;

        @Override
        protected void apply(IntersectionItem<T, V1, V2> vo, IntersectionBuilder<T, V1, V2> builder) {
            builder.withStartMoment(vo.interval.startMoment());
            builder.withEndMoment(vo.interval.endMoment());
            builder.withFirstValue(vo.getFirstValue());
            builder.withSecondValue(vo.getSecondValue());


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
        protected IntersectionItem<T, V1, V2> createValueObject() {
            if (isNull(endMoment))
                return IntersectionItem.createFrom(startMoment, this.firstValue, this.secondValue);

            return IntersectionItem.createFrom(startMoment, endMoment, this.firstValue, this.secondValue);
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

}
