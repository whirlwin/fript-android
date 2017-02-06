package no.fript.fript.api;

import com.google.common.base.Supplier;

import java.io.IOException;

import javax.inject.Inject;

import no.fript.fript.internal.Try;
import no.fript.fript.user.FacebookLoginRequest;
import no.fript.fript.user.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class ApiClient {

    private final RetrofitService retrofitService;

    @Inject
    public ApiClient(final RetrofitService retrofitService) {
        this.retrofitService = retrofitService;
    }

    public User logIn(final FacebookLoginRequest facebookLoginRequest) throws IOException {
        return this.retrofitService.getUserApiService().logIn(facebookLoginRequest)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                })
                .body();
    }

    public String test() {
        return "foobar";
    }
}
