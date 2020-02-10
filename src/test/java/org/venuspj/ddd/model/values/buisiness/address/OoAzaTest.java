package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.Name;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class OoAzaTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        OoAza target = OoAza.empty();
        assertThat(target)
                .isNotNull();

        System.out.println(true);
    }

    @Test
    @Tag(TestSize.SMALL)
    public void getAzaInformation() {
        OoAza target = OoAza.of(OoAzaIdentifier.empty(), OoAzaInformation.empty());
        assertThat(target.getAzaInformation())
                .isNotNull();

        System.out.println(true);
    }

    public static class AzaMock {
        public static OoAza empty() {
            return OoAza.empty();
        }

        public static OoAza one() {
            return new OoAza(OoAzaIdentifier.of(1L),
                    OoAzaInformation.of(Name.of("本町")));
        }

        public static OoAza two() {
            return new OoAza(OoAzaIdentifier.of(2L),
                    OoAzaInformation.of(Name.of("要町")));
        }

        public static OoAza full() {
            return new OoAza(OoAzaIdentifier.of(1L),
                    OoAzaInformation.of(Name.of("本町")));

        }
    }

}
