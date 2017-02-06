package no.fript.fript;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import no.fript.fript.api.ApiClient;
import no.fript.fript.api.ApiModule;
import no.fript.fript.onboarding.login.LoginActivity;
import no.fript.fript.onboarding.login.LoginService;
import no.fript.fript.user.UserModule;
import no.fript.fript.user.UserStorageService;

@Singleton
@Component(modules = { ApiModule.class, UserModule.class, AppModule.class })
public interface NetComponent {

    void inject(final SplashActivity splashActivity);
    void inject(final UserStorageService userStorageService);
    void inject(final LoginActivity loginActivity);
    void inject(final FriptApp friptApp);
}
