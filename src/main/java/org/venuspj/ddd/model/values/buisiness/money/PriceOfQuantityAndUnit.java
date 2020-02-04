package org.venuspj.ddd.model.values.buisiness.money;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.quantity.QuantityAndUnit;
import org.venuspj.util.objects2.Objects2;

public class PriceOfQuantityAndUnit implements Value<PriceOfQuantityAndUnit> {
    private Amount amount = Amount.empty();
    private QuantityAndUnit quantityAndUnit = QuantityAndUnit.empty();

    PriceOfQuantityAndUnit(Amount anAmount, QuantityAndUnit aQuantityAndUnit) {
        amount = anAmount;
        quantityAndUnit = aQuantityAndUnit;

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
                Objects2.equal(quantityAndUnit, that.quantityAndUnit);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(amount, quantityAndUnit);

    }

    public boolean isEmpty() {
        return amount.isEmpty()
                && quantityAndUnit.isEmpty();

    }

    public static PriceOfQuantityAndUnit empty() {
        return new PriceOfQuantityAndUnit();
    }

    public static PriceOfQuantityAndUnit of(Amount anAmount, QuantityAndUnit aQuantityAndUnit) {
        return new PriceOfQuantityAndUnit(anAmount, aQuantityAndUnit);

    }


}
