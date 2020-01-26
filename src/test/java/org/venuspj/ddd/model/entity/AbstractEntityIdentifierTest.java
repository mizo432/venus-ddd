package org.venuspj.ddd.model.entity;

import org.junit.jupiter.api.Test;

import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class AbstractEntityIdentifierTest {

    @Test
    public void test01() {
        ConcreteEntityIdentifier target = ConcreteEntityIdentifier.of(1L);
        System.out.println(toStringHelper(target).defaultConfig().toString());
    }

}
