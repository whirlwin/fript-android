package no.fript.fript;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public final class Config {

    private static Config instance;

    private Config() {
    }

    public void initialize(final Activity activity) {
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
}
