package no.fript.fript.onboarding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import no.fript.fript.R;

public final class LoginActivity extends AppCompatActivity {

    private static final String FB_EMAIL_PERMISSION = "email";

    private CallbackManager callbackManager = CallbackManager.Factory.create();

    public LoginActivity() {
        initializeLoginButton();
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void initializeLoginButton() {
        callbackManager = CallbackManager.Factory.create();

        final LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(FB_EMAIL_PERMISSION);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(final LoginResult loginResult) {
            }

            @Override
            public void onCancel() {
                int i = 0;
            }

            @Override
            public void onError(final FacebookException exception) {
                int i = 0;
            }
        });
    }
}
