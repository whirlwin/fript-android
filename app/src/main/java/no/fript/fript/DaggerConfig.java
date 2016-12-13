package no.fript.fript;

import android.app.Application;

public final class DaggerConfig {

    public void configure(final Application application) {
        Components.netComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(application)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule())
                .build();
    }
}
