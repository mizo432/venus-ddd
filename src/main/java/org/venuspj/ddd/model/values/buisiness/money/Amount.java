package org.venuspj.ddd.model.values.buisiness.money;

import org.venuspj.ddd.model.values.buisiness.quantity.Quantity;
import org.venuspj.ddd.model.values.buisiness.rate.Rate;
import org.venuspj.ddd.model.values.primitives.AbstractLongValue;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Locale;

import static org.venuspj.util.objects2.Objects2.isNull;

/**
 * 金額
 */
public class Amount extends AbstractLongValue<Amount> {

    public Amount(Long aValue) {
        super(aValue);
    }

    public static Amount zeroYen() {
        return new Amount(Long.valueOf(0));

    }

    public static Amount yen(Long aValue) {
        return new Amount(aValue);

    }

    public static Amount sum(Amount... anyAmounts) {
        Long result = 0L;
        for (Amount aAmount : anyAmounts) {
            result = result + aAmount.getValue();
        }
        return Amount.yen(result);

    }

    public static Amount sum(Collection<Amount> anyAmounts) {
        Long result = 0L;
        for (Amount aAmount : anyAmounts) {
            result = result + aAmount.getValue();
        }
        return Amount.yen(result);

    }

    public Amount multiply(Quantity aQuantity) {
        return Amount.yen(aQuantity.getValue().multiply(BigDecimal.valueOf(value)).longValue());
    }

    public String asText() {
        if (isNull(value))
            return null;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        return formatter.format(value);

    }

    public Amount multiply(Rate aRate) {
        return Amount
                .yen(
                        aRate
                                .getValue()
                                .multiply(
                                        BigDecimal.valueOf(value)
                                )
                                .longValue()
                );
    }
}
