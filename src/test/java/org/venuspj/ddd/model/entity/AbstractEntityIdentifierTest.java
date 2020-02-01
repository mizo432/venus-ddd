package org.venuspj.ddd.model.entity;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.forTest.model.concrete.ConcreteEntityIdentifier;
import org.venuspj.tests.constants.TestSize;

import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class AbstractEntityIdentifierTest {

    @Test
    @Tag(TestSize.SMALL)
    public void test01() {
        ConcreteEntityIdentifier target = ConcreteEntityIdentifier.of(1L);
        System.out.println(toStringHelper(target).defaultConfig().toString());
    }

}
