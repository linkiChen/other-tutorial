package com.jacky.mockito.asserts;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;

public class NumberComparator<T extends Number> extends BaseMatcher<T> {

    final private T value;
    final private boolean greatThan;

    public NumberComparator(T value, boolean greatThan) {
        this.value = value;
        this.greatThan = greatThan;
    }

    @Override
    public boolean matches(Object item) {
        Class<?> clazz = item.getClass();
        if (clazz == Integer.class) {
            return greatThan ? (Integer) item > (Integer) value : (Integer) item < (Integer) value;
        } else if (clazz == Short.class) {
            return greatThan ? (Short) item > (Short) value : (Short) item < (Short) value;
        } else if (clazz == Byte.class) {
            return greatThan ? (Byte) item > (Byte) value : (Byte) item < (Byte) value;
        } else if (clazz == Double.class) {
            return greatThan ? (Double) item > (Double) value : (Double) item < (Double) value;
        } else if (clazz == Float.class) {
            return greatThan ? (Float) item > (Float) value : (Float) item < (Float) value;
        } else if (clazz == Long.class) {
            return greatThan ? (Long) item > (Long) value : (Long) item < (Long) value;
        } else {
            throw new AssertionError("The number type '" + clazz + "' unSupported");
        }
    }

    @Factory
    public static <T extends Number> NumberComparator<T> gt(T value) {
        return new NumberComparator<>(value, true);
    }

    @Factory
    public static <T extends Number> NumberComparator<T> lt(T value) {
        return new NumberComparator<>(value, false);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("compare two number fail");
    }
}
