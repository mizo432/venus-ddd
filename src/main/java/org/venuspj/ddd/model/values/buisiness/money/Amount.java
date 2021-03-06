package org.venuspj.ddd.model.values.buisiness.money;

import org.venuspj.ddd.model.values.buisiness.Percentage;
import org.venuspj.ddd.model.values.buisiness.quantity.QuantityDecimal;
import org.venuspj.ddd.model.values.primitives.AbstractLongValue;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import static org.venuspj.util.objects2.Objects2.isNull;

/**
 * 金額
 */
public class Amount extends AbstractLongValue<Amount> {

    Amount(Long aValue) {
        super(aValue);
    }

    public Amount() {

    }

    public static Amount zeroYen() {
        return new Amount(0L);

    }

    public static Amount yen(Long aValue) {
        return new Amount(aValue);

    }

    public static Amount sum(Amount... anyAmounts) {
        return sum(Arrays.asList(anyAmounts));

    }

    public static Amount sum(Collection<Amount> anyAmounts) {
        Long result = 0L;
        for (Amount aAmount : anyAmounts) {
            result = result + aAmount.getValue();
        }
        return Amount.yen(result);

    }

    public static Amount empty() {
        return new Amount();

    }

    public Amount multiply(QuantityDecimal aQuantityDecimal) {
        return Amount
                .yen(aQuantityDecimal
                        .getValue()
                        .multiply(BigDecimal
                                .valueOf(value))
                        .longValue());

    }

    public String asText() {
        if (isNull(value))
            return null;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        return formatter.format(value);

    }

    public Amount multiply(Percentage aPercentage) {
        return Amount
                .yen(
                        aPercentage
                                .getValue()
                                .multiply(
                                        BigDecimal
                                                .valueOf(value)
                                                .divide(BigDecimal.valueOf(100))
                                )
                                .longValue()
                );

    }
}
