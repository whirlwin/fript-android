package no.fript.fript;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import no.fript.fript.useraccount.UserAccountStorageService;

public final class FriptApp extends Application {

    private final UserAccountStorageService userAccountStorageService;

    public FriptApp() {
        this.userAccountStorageService = UserAccountStorageService.getInstance();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        final FriptConfig config = new FriptConfig(getApplicationContext());
        config.configure();

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        userAccountStorageService.loadUserAccount();
    }
}
