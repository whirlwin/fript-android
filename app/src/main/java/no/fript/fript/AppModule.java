package no.fript.fript;

import com.facebook.CallbackManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import no.fript.fript.onboarding.login.LoginService;

@Module
public class AppModule {

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
}
