package org.venuspj.ddd.model.values.primitives;

import org.venuspj.util.exception.VRuntimeException;

public class ItemNotFoundRuntimeException extends VRuntimeException {
    public ItemNotFoundRuntimeException() {
        super("EVA00001", new Object[0]);
    }

    public ItemNotFoundRuntimeException(String messageCode, Object[] args) {
        super(messageCode, args);
    }
}
