package no.fript.fript;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import no.fript.fript.user.UserStorageService;

public final class FriptApp extends Application {

    private final DaggerConfig daggerConfig;
    private final UserStorageService userStorageService;

    public FriptApp() {
        this.daggerConfig = new DaggerConfig();
        this.userStorageService = new UserStorageService();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.daggerConfig.configure(this);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        this.userStorageService.loadUserIntoStorage();
    }
}
