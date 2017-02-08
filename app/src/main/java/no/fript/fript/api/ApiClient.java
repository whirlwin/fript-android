package no.fript.fript.api;

import javax.inject.Inject;

import no.fript.fript.user.FacebookLoginRequest;

public final class ApiClient {

    private final RetrofitService retrofitService;

    @Inject
    public ApiClient(final RetrofitService retrofitService) {
        this.retrofitService = retrofitService;
    }

    public void logIn(final FacebookLoginRequest facebookLoginRequest) {
        this.retrofitService.getUserApiService()
                .logIn(facebookLoginRequest)
                .enqueue(facebookLoginRequest.getUserCallback());
    }

    public String test() {
        return "foobar";
    }
}
