package no.fript.fript;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;

public final class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isLoggedIn()) {
            proceedToMainMap();
        } else {
            proceedToStartMenu();
        }
    }

    private boolean isLoggedIn() {
        return AccessToken.getCurrentAccessToken() != null;
    }

    private void proceedToStartMenu() {
        final Intent intent = new Intent(this, StartMenuActivity.class);
        startActivity(intent);
    }

    private void proceedToMainMap() {
        final Intent intent = new Intent(this, MainMapActivity.class);
        startActivity(intent);
    }
}
