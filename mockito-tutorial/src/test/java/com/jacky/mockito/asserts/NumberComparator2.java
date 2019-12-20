package com.jacky.mockito.asserts;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;

public class NumberComparator2<T extends Number> extends BaseMatcher<T> {

    private final T value;
    private final boolean greatThan;
    private final Compare<T> compare;

    public NumberComparator2(T value, boolean greatThan) {
        this.value = value;
        this.greatThan = greatThan;
        this.compare = new DefaultNumberCompare(greatThan);
    }

    @Override
    public boolean matches(Object item) {
        return compare.compare(value, (T) item);
    }

    @Factory
    public static <T extends Number> NumberComparator2<T> gt(T value) {
        return new NumberComparator2<>(value, true);
    }

    @Factory
    public static <T extends Number> NumberComparator2<T> lt(T value) {
        return new NumberComparator2<T>(value, false);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("compare two number fail");
    }
}
