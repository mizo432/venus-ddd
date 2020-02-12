package org.venuspj.basic.model.domain.relashonshipManagement.party.person;

import org.venuspj.ddd.model.values.primitives.code.AbstractStringCodeValue;

/**
 * 性別.
 * <pre>
 * ISO 5218 Codes for the representation of human sexes
 * Genderではなく生物的な性別を示す
 * </pre>
 */
public class SexCode extends AbstractStringCodeValue<SexCode> {

    SexCode(String aValue) {
        super(aValue);

    }

    public static SexCode of(String aValue) {
        return new SexCode(aValue);
    }
}
