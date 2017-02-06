package no.fript.fript;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.common.base.Optional;

import javax.inject.Inject;

import no.fript.fript.user.User;
import no.fript.fript.user.UserStorageService;
import no.fript.fript.onboarding.login.LoginActivity;

public final class SplashActivity extends AppCompatActivity {

    @Inject
    UserStorageService userStorageService;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Components.netComponent.inject(this);

        this.userStorageService.loadUserIntoStorage();

        if (hasBeenOnboarded()) {
            proceedToMainMap();
        } else {
            proceedToOnboarding();
        }
    }

    private boolean hasBeenOnboarded() {
        final Optional<User> currentUserAccount = userStorageService.getCurrentUserAccount();
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
