package no.fript.fript;

import com.facebook.CallbackManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import no.fript.fript.api.ApiClient;
import no.fript.fript.api.RetrofitService;
import no.fript.fript.onboarding.login.LoginService;
import no.fript.fript.user.UserMapper;
import no.fript.fript.user.UserStorageService;

@Module
public class NetModule {

    String baseUrl;

    public NetModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    UserStorageService providesUserStorageService() {
        return new UserStorageService();
    }

    @Provides
    @Singleton
    UserMapper providesUserMapper() {
        return new UserMapper();
    }

    @Provides
    @Singleton
    LoginService providesLoginService() {
        return new LoginService();
    }

    @Provides
    @Singleton
    CallbackManager providesCallbackManager() {
        return CallbackManager.Factory.create();
    }

    @Provides
    @Singleton
    ApiClient providesApiClient(RetrofitService retrofitService) {
        return new ApiClient(retrofitService);
    }
}
