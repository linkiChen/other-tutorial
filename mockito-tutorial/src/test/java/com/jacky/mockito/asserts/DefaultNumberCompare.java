package com.jacky.mockito.asserts;

public class DefaultNumberCompare<T extends Number> implements Compare<T> {

    private final boolean greatThan;

    public DefaultNumberCompare(boolean greatThan) {
        this.greatThan = greatThan;
    }

    @Override
    public boolean compare(T expect, T actual) {
        Class<?> clazz = actual.getClass();
        if (clazz == Integer.class) {
            return greatThan ? (Integer) actual > (Integer) expect : (Integer) actual < (Integer) expect;
        } else if (clazz == Short.class) {
            return greatThan ? (Short) actual > (Short) expect : (Short) actual < (Short) expect;
        } else if (clazz == Byte.class) {
            return greatThan ? (Byte) actual > (Byte) expect : (Byte) actual < (Byte) expect;
        } else if (clazz == Double.class) {
            return greatThan ? (Double) actual > (Double) expect : (Double) actual < (Double) expect;
        } else if (clazz == Float.class) {
            return greatThan ? (Float) actual > (Float) expect : (Float) actual < (Float) expect;
        } else if (clazz == Long.class) {
            return greatThan ? (Long) actual > (Long) expect : (Long) actual < (Long) expect;
        } else {
            throw new AssertionError("The number type '" + clazz + "' unSupported");
        }
    }
}
