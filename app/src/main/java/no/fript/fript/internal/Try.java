package no.fript.fript.internal;

import com.google.common.base.Supplier;

public abstract class Try<T> {

    public static <T> Try<T> success(final T t) {
        return new Success<>(t);
    }

    public static <T> Try<T> failure(final Throwable throwable) {
        return new Failure<>(throwable);
    }

    abstract boolean isSuccess();

    abstract boolean isFailure();
}
