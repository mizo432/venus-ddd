package org.venuspj.ddd.model.values.buisiness.money;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.quantity.QuantityDecimalAndUnit;
import org.venuspj.util.objects2.Objects2;

public class PriceOfQuantityAndUnit implements Value<PriceOfQuantityAndUnit> {
    private Amount amount = Amount.empty();
    private QuantityDecimalAndUnit quantityDecimalAndUnit = QuantityDecimalAndUnit.empty();

    PriceOfQuantityAndUnit(Amount anAmount, QuantityDecimalAndUnit aQuantityDecimalAndUnit) {
        amount = anAmount;
        quantityDecimalAndUnit = aQuantityDecimalAndUnit;

    }

    public PriceOfQuantityAndUnit() {

    }


    @Override
    public boolean sameValueAs(PriceOfQuantityAndUnit other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceOfQuantityAndUnit that = (PriceOfQuantityAndUnit) o;
        return Objects2.equal(amount, that.amount) &&
                Objects2.equal(quantityDecimalAndUnit, that.quantityDecimalAndUnit);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(amount, quantityDecimalAndUnit);

    }

    public boolean isEmpty() {
        return amount.isEmpty()
                && quantityDecimalAndUnit.isEmpty();

    }

    public static PriceOfQuantityAndUnit empty() {
        return new PriceOfQuantityAndUnit();
    }

    public static PriceOfQuantityAndUnit of(Amount anAmount, QuantityDecimalAndUnit aQuantityDecimalAndUnit) {
        return new PriceOfQuantityAndUnit(anAmount, aQuantityDecimalAndUnit);

    }


}
