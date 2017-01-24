package no.fript.fript;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import no.fript.fript.user.UserStorageService;

public final class FriptApp extends Application {

    private final UserStorageService userStorageService;
    private NetComponent netComponent;

    public FriptApp() {
        this.userStorageService = new UserStorageService();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("foobar"))
                .build();
        Components.netComponent = this.netComponent;

        FacebookSdk.sdkInitialize(getApplicationContext());

        AppEventsLogger.activateApp(this);

        this.userStorageService.loadUserIntoStorage();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
