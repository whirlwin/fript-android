package no.fript.fript;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import javax.inject.Inject;

import no.fript.fript.user.UserStorageService;

public final class FriptApp extends Application {

    public FriptApp() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Components.netComponent = DaggerNetComponent
                .builder()
                .build();

        FacebookSdk.sdkInitialize(getApplicationContext());

        AppEventsLogger.activateApp(this);
    }
}
