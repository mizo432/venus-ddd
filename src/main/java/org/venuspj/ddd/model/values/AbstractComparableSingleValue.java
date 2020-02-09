package org.venuspj.ddd.model.values;

import org.venuspj.util.collect.ComparisonChain;

public class AbstractComparableSingleValue<T extends Comparable<T>, ACSV extends AbstractComparableSingleValue<T, ACSV>> extends AbstractSingleValue<T, ACSV> {

    protected AbstractComparableSingleValue() {

    }

    protected AbstractComparableSingleValue(T value) {
        super(value);

    }

    @Override
    public int compareTo(ACSV o) {
        return ComparisonChain
                .start()
                .compare(value, o.value)
                .result();
    }


}
