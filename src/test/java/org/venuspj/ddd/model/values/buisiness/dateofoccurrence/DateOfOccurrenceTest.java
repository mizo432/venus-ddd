package org.venuspj.ddd.model.values.buisiness.dateofoccurrence;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;
import org.venuspj.util.dateProvider.DateProvider;
import org.venuspj.util.dateProvider.StaticDateProvider;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class DateOfOccurrenceTest {

    @Test
    @Tag(TestSize.SMALL)
    public void now() {
        // given
        StaticDateProvider.initialize(LocalDate.of(2010, 1, 15));

        // when
        DateOfOccurrence target = DateOfOccurrence.now();

        //then
        assertThat(target.asDate())
                .isEqualTo(LocalDate.of(2010, 1, 15));

        DateProvider.initialize();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        // given
        LocalDate anArg = LocalDate.of(2010, 1, 15);

        // when
        DateOfOccurrence target = DateOfOccurrence.of(anArg);

        //then
        assertThat(target.asDate())
                .isEqualTo(LocalDate.of(2010, 1, 15));

    }
}
