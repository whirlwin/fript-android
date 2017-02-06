package no.fript.fript.user;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import no.fript.fript.api.ApiClient;

@Module
public class UserModule {

    @Provides
    @Singleton
    UserStorageService userStorageService(final ApiClient apiClient) {
        return new UserStorageService(apiClient);
    }

    @Provides
    @Singleton
    UserMapper userMapper() {
        return new UserMapper();
    }
}
