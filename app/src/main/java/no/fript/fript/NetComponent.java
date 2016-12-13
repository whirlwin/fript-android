package no.fript.fript;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import no.fript.fript.onboarding.login.LoginActivity;

@Singleton
@Component(modules = { AppModule.class, NetModule.class })
public interface NetComponent {

    void inject(final SplashActivity splashActivity);
    void inject(final LoginActivity loginActivity);
    void inject(final Application application);
}
