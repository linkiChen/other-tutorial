package com.jacky.mockito.asserts;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;

public class GreatThan<T extends Number> extends BaseMatcher<T> {

    private final T value;

    public GreatThan(T value) {
        this.value = value;
    }

    @Override
    public boolean matches(Object item) {
        Class<?> clazz = item.getClass();
        if (clazz == Integer.class) {
            return (Integer) item > (Integer) value;
        } else if (clazz == Short.class) {
            return (Short) item > (Short) value;
        } else if (clazz == Byte.class) {
            return (Byte) item > (Byte) value;
        } else if (clazz == Double.class) {
            return (Double) item > (Double) value;
        } else if (clazz == Float.class) {
            return (Float) item > (Float) value;
        } else if (clazz == Long.class) {
            return (Long) item > (Long) value;
        } else {
            throw new AssertionError("The number type '" + clazz + "' unSupported");
        }
    }

    @Factory
    public static <T extends Number> GreatThan<T> gt(T value) {
        return new GreatThan<>(value);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("compare two number fail");
    }
}
