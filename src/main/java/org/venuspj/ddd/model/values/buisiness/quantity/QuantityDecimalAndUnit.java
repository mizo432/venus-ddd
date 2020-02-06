package org.venuspj.ddd.model.values.buisiness.quantity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.Unit;
import org.venuspj.util.objects2.Objects2;

import java.math.BigDecimal;

import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class QuantityDecimalAndUnit implements Value<QuantityDecimalAndUnit> {
    private QuantityDecimal quantity = QuantityDecimal.empty();
    private Unit unit = Unit.empty();

    QuantityDecimalAndUnit(QuantityDecimal aQuantity, Unit aUnit) {
        quantity = aQuantity;
        unit = aUnit;

    }

    public QuantityDecimal getQuantity() {
        return quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public QuantityDecimalAndUnit() {

    }

    public static QuantityDecimalAndUnit of(BigDecimal aValue, String aUnit) {
        return new QuantityDecimalAndUnit(QuantityDecimal.of(aValue), Unit.of(aUnit));

    }

    public static QuantityDecimalAndUnit of(QuantityDecimal aQuantityDecimal, Unit aUnit) {
        return new QuantityDecimalAndUnit(aQuantityDecimal, aUnit);

    }

    public static QuantityDecimalAndUnit empty() {
        return new QuantityDecimalAndUnit();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityDecimalAndUnit that = (QuantityDecimalAndUnit) o;
        return Objects2.equal(quantity, that.quantity) &&
                Objects2.equal(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(quantity, unit);

    }

    @Override
    public boolean sameValueAs(QuantityDecimalAndUnit other) {
        return equals(other);

    }

    @JsonIgnore
    public boolean isEmpty() {
        return quantity.isEmpty()
                && unit.isEmpty();
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();
    }

}
