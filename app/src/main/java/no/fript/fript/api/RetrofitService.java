package no.fript.fript.api;

import javax.inject.Inject;

public final class RetrofitService {

    private final RetrofitConfig retrofitConfig;

    @Inject
    RetrofitService(final RetrofitConfig retrofitConfig) {
        this.retrofitConfig = retrofitConfig;
    }

    UserApiService getUserApiService() {
        return null;
    }
}
