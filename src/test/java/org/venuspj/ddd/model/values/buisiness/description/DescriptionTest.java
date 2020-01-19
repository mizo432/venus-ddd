package org.venuspj.ddd.model.values.buisiness.description;

import org.junit.Test;
import org.venuspj.ddd.model.values.buisiness.line.Line;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class DescriptionTest {

    @Test
    public void of() {
        Description target = Description.of(
                newArrayList(
                        Line.of("data1"),
                        Line.of("data2")));
        System.out.println(target.toString());
        assertThat(target.toString())
                .isEqualTo("Description[\n" +
                        "  Line{\"data1\"},\n" +
                        "  Line{\"data2\"}\n" +
                        "]");


    }

}