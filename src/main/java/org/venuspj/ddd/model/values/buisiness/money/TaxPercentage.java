package org.venuspj.ddd.model.values.buisiness.money;

import org.venuspj.ddd.model.values.buisiness.Percentage;

import java.math.BigDecimal;

public class TaxPercentage extends Percentage {
    protected TaxPercentage(BigDecimal aValue) {
        super(aValue);

    }

    public static TaxPercentage zero() {
        return valueOf(BigDecimal.ZERO);

    }

    public static TaxPercentage sum(TaxPercentage... anyTaxPercentages) {
        return TaxPercentage.valueOf(Percentage.sum(anyTaxPercentages).getValue());

    }

    public static TaxPercentage valueOf(BigDecimal aValue) {
        return new TaxPercentage(aValue);

    }

    public static TaxPercentage all() {
        return new TaxPercentage(Percentage.full().getValue());

    }

}
