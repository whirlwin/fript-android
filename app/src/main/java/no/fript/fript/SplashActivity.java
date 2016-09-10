package no.fript.fript;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;

import no.fript.fript.onboarding.login.LoginActivity;

public final class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (hasBeenOnboarded()) {
            proceedToMainMap();
        } else {
            proceedToOnboarding();
        }
    }

    private boolean hasBeenOnboarded() {
        // TODO: Handle logic for onboarding
        if (true) return false;
        return AccessToken.getCurrentAccessToken() != null;
    }

    private void proceedToOnboarding() {
        final Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void proceedToMainMap() {
        final Intent intent = new Intent(this, MainMapActivity.class);
        startActivity(intent);
    }
}
