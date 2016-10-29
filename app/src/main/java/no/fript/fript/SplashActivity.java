package no.fript.fript;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.google.common.base.Optional;

import no.fript.fript.useraccount.UserAccount;
import no.fript.fript.useraccount.UserAccountStorageService;
import no.fript.fript.onboarding.login.LoginActivity;

public final class SplashActivity extends AppCompatActivity {

    private final UserAccountStorageService userAccountStorageService;

    public SplashActivity() {
        userAccountStorageService = UserAccountStorageService.getInstance();
    }

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
        final Optional<UserAccount> currentUserAccount = userAccountStorageService.getCurrentUserAccount();
        return currentUserAccount.isPresent() && currentUserAccount.get().hasBeenOnboarded();
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
