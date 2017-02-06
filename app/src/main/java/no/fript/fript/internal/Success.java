package no.fript.fript.internal;

class Success<T> extends Try<T> {

    private final T value;

    Success(final T value) {
        this.value = value;
    }

    @Override
    boolean isSuccess() {
        return true;
    }

    @Override
    boolean isFailure() {
        return false;
    }
}
