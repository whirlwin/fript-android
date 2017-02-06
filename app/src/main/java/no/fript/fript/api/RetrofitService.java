package no.fript.fript.api;

import javax.inject.Inject;

import retrofit2.Retrofit;

public final class RetrofitService {

    private final UserApiService userApiService;

    @Inject
    public RetrofitService(final RetrofitConfig retrofitConfig) {
        final Retrofit retrofit = retrofitConfig.configureRetrofit();
        this.userApiService = retrofit.create(UserApiService.class);
    }

    UserApiService getUserApiService() {
        return this.userApiService;
    }
}
