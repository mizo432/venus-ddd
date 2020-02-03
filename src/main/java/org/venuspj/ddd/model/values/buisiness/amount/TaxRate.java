package org.venuspj.ddd.model.values.buisiness.amount;

import org.venuspj.ddd.model.values.buisiness.percentage.Percentage;
import org.venuspj.ddd.model.values.buisiness.rate.Rate;

import java.math.BigDecimal;

public class TaxRate extends Rate {
    protected TaxRate(BigDecimal aValue) {
        super(aValue);

    }

    public static TaxRate zero() {
        return valueOf(BigDecimal.ZERO);

    }

    public static TaxRate sum(Rate... anyTaxRates) {
        return TaxRate.valueOf(Rate.sum(anyTaxRates).getValue());

    }

    public static TaxRate valueOf(BigDecimal aValue) {
        return new TaxRate(aValue);

    }

    public static TaxRate all() {
        return new TaxRate(Rate.all().getValue());

    }

    public Percentage toPercentage() {
        return Percentage.valueOf(value.multiply(BigDecimal.valueOf(100)));

    }

}
