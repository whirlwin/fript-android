package no.fript.fript.api;

import javax.inject.Inject;

public final class ApiClient {

    private final RetrofitService retrofitService;

    @Inject
    public ApiClient(final RetrofitService retrofitService) {
        this.retrofitService = retrofitService;
    }

    public String test() {
        return "foobar";
    }
}
