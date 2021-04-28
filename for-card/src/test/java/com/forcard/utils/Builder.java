package com.forcard.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;

public class Builder<T> {

    private T instance;

    private Builder(Class<T> clazz) {
        try {
            instance = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("No default constructor found for " + clazz.getName(), e);
        }
    }

    public static <T> Builder<T> anObject(Class<T> clazz) {
        return new Builder<>(clazz);
    }

    public Builder<T> with(Consumer<T> setter) {
        setter.accept(instance);
        return this;
    }

    public T build() {
        return instance;
    }

}
