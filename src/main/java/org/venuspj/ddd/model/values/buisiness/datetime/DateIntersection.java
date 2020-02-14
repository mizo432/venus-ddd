package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.DateValue;
import org.venuspj.ddd.model.values.primitives.momentinterval.DateInterval;
import org.venuspj.util.builder.ObjectBuilder;

import java.util.Objects;

import static org.venuspj.util.objects2.Objects2.isNull;

/**
 * 日付をキーにした交差エンティティ
 *
 * @param <T1> 交差エンティティの最初の値の型
 * @param <T2> 交差エンティティの二番目値の型
 */
public class DateIntersection<T1 extends Value<T1>, T2 extends Value<T2>>
        extends AbstractValue<DateIntersection<T1, T2>> {
    private DateInterval dateInterval;
    private T1 firstValue;
    private T2 secondValue;

    public DateInterval getDateInterval() {
        return dateInterval;
    }

    public T1 getFirstValue() {
        return firstValue;
    }

    public T2 getSecondValue() {
        return secondValue;
    }

    private DateIntersection(DateInterval dateInterval
            , Value<T1> firstValue
            , Value<T2> secondValue) {

    }

    public static <T1 extends Value<T1>, T2 extends Value<T2>> DateIntersection<T1, T2> createFrom(
            DateValue<?> aStartDate,
            DateValue<?> anEndDate,
            Value<T1> aFirstValue,
            Value<T2> aSecondValue) {
        return new DateIntersection<>(DateInterval.createFrom(aStartDate, anEndDate), aFirstValue, aSecondValue);

    }

    public static <T1 extends Value<T1>, T2 extends Value<T2>> DateIntersection<T1, T2> createFrom(
            DateValue<?> aStartDate,
            Value<T1> aFirstValue,
            Value<T2> aSecondValue) {
        return new DateIntersection<>(DateInterval.createFrom(aStartDate), aFirstValue, aSecondValue);

    }

    @Override
    public boolean sameValueAs(DateIntersection<T1, T2> other) {
        return equals(other);

    }

    @Override
    public boolean isEmpty() {
        return dateInterval.isEmpty() &&
                firstValue.isEmpty() &&
                secondValue.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateIntersection<?, ?> that = (DateIntersection<?, ?>) o;
        return Objects.equals(dateInterval, that.dateInterval) &&
                Objects.equals(firstValue, that.firstValue) &&
                Objects.equals(secondValue, that.secondValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateInterval, firstValue, secondValue);

    }

    public static class DateIntersectionBuilder<T1 extends Value<T1>, T2 extends Value<T2>>
            extends ObjectBuilder<DateIntersection<T1, T2>, DateIntersectionBuilder<T1, T2>> {
        DateValue<?> startMoment;
        DateValue<?> endMoment;
        private Value<T1> firstValue;
        private Value<T2> secondValue;

        @Override
        protected void apply(DateIntersection<T1, T2> vo, DateIntersectionBuilder<T1, T2> builder) {
            builder.withStartMoment(vo.dateInterval.startMoment());
            builder.withEndMoment(vo.dateInterval.endMoment());
            builder.withFirstValue(vo.firstValue);
            builder.withSecondValue(vo.secondValue);


        }

        private DateIntersectionBuilder<T1, T2> withSecondValue(Value<T2> secondValue) {
            if (isNull(startMoment)) return getThis();
            addConfigurator(builder -> builder.startMoment = startMoment);
            return getThis();

        }

        private DateIntersectionBuilder<T1, T2> withFirstValue(Value<T1> firstValue) {
            if (isNull(startMoment)) return getThis();
            addConfigurator(builder -> builder.startMoment = startMoment);
            return getThis();

        }

        public DateIntersectionBuilder<T1, T2> withStartMoment(DateValue<?> aStartMoment) {
            if (isNull(startMoment)) return getThis();
            addConfigurator(builder -> builder.startMoment = startMoment);
            return getThis();

        }

        public DateIntersectionBuilder<T1, T2> withEndMoment(DateValue<?> anEndMoment) {
            if (isNull(anEndMoment)) return getThis();
            addConfigurator(builder -> builder.endMoment = anEndMoment);
            return getThis();

        }

        @Override
        protected DateIntersection<T1, T2> createValueObject() {
            if (isNull(endMoment))
                return DateIntersection.createFrom(startMoment, firstValue, secondValue);

            return DateIntersection.createFrom(startMoment, endMoment, firstValue, secondValue);
        }

        @Override
        protected DateIntersectionBuilder<T1, T2> getThis() {
            return null;
        }

        @Override
        protected DateIntersectionBuilder<T1, T2> newInstance() {
            return null;
        }
    }

}
