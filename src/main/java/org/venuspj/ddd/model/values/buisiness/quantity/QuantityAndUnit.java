package org.venuspj.ddd.model.values.buisiness.quantity;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.Unit;
import org.venuspj.util.objects2.Objects2;

import java.math.BigDecimal;

public class QuantityAndUnit implements Value<QuantityAndUnit> {
    private Quantity quantity;
    private Unit unit;

    public QuantityAndUnit(Quantity aQuantity, Unit aUnit) {
        quantity = aQuantity;
        unit = aUnit;

    }

    public static QuantityAndUnit of(BigDecimal aValue, String aUnit) {
        return new QuantityAndUnit(Quantity.of(aValue), Unit.of(aUnit));

    }

    public static QuantityAndUnit empty() {
        return new QuantityAndUnit(Quantity.empty(), Unit.empty());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityAndUnit that = (QuantityAndUnit) o;
        return Objects2.equal(quantity, that.quantity) &&
                Objects2.equal(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(quantity, unit);
    }

    @Override
    public boolean sameValueAs(QuantityAndUnit other) {
        return equals(other);
    }
}
