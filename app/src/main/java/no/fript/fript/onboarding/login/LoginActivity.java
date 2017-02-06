package no.fript.fript.onboarding.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import javax.inject.Inject;

import no.fript.fript.Components;
import no.fript.fript.FriptApp;
import no.fript.fript.R;

public final class LoginActivity extends AppCompatActivity {

    private static final String FB_EMAIL_PERMISSION = "email";

    @Inject
    LoginService loginService;

    @Inject
    CallbackManager callbackManager;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Components.netComponent.inject(this);
        initializeLoginButton();
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void initializeLoginButton() {
        final LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(FB_EMAIL_PERMISSION);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(final LoginResult loginResult) {
                loginService.handleLogin(loginResult);
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
