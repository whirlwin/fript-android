package no.fript.fript;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public final class PreferencesService {

    private static PreferencesService instance;

    private PreferencesService() {
    }

    public static PreferencesService getInstance() {
        if (instance == null) {
            instance = new PreferencesService();
        }
        return instance;
    }
}
