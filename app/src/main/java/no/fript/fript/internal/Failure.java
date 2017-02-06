package no.fript.fript.internal;

final class Failure<T> extends Try<T> {

    private final Throwable throwable;

    Failure(final Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    boolean isSuccess() {
        return false;
    }

    @Override
    boolean isFailure() {
        return true;
    }
}
