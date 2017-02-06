package no.fript.fript.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Provides
    @Singleton
    ApiClient apiClient(final RetrofitService retrofitService) {
        return new ApiClient(retrofitService);
    }

    @Provides
    @Singleton
    RetrofitService retrofitService(final RetrofitConfig retrofitConfig) {
        return new RetrofitService(retrofitConfig);
    }

    @Provides
    @Singleton
    RetrofitConfig retrofitConfig() {
        return new RetrofitConfig();
    }
}
