package no.fript.fript;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public final class FriptApp extends Application {

    private FriptConfig config;

    @Override
    public void onCreate() {
        super.onCreate();

        config = new FriptConfig(getApplicationContext());
        config.configure();

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }
}
