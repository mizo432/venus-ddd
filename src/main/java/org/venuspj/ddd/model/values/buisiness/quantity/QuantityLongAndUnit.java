package org.venuspj.ddd.model.values.buisiness.quantity;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.Unit;
import org.venuspj.util.objects2.Objects2;

public class QuantityLongAndUnit implements Value<QuantityLongAndUnit> {
    private QuantityLong quantity;
    private Unit unit = Unit.empty();

    public QuantityLongAndUnit(QuantityLong aQuantity, Unit aUnit) {
        quantity = aQuantity;
        unit = aUnit;

    }

    public static QuantityLongAndUnit of(Long aValue, String aUnit) {
        return new QuantityLongAndUnit(QuantityLong.of(aValue), Unit.of(aUnit));

    }

    public static QuantityLongAndUnit empty() {
        return new QuantityLongAndUnit(QuantityLong.empty(), Unit.empty());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityLongAndUnit that = (QuantityLongAndUnit) o;
        return Objects2.equal(quantity, that.quantity) &&
                Objects2.equal(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(quantity, unit);

    }

    @Override
    public boolean sameValueAs(QuantityLongAndUnit other) {
        return equals(other);

    }

    public boolean isEmpty() {
        return quantity.isEmpty()
                && unit.isEmpty();
    }

}
