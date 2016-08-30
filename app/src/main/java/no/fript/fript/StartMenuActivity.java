package no.fript.fript;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public final class StartMenuActivity extends AppCompatActivity {

    private static final String FB_EMAIL_PERMISSION = "email";

    private CallbackManager callbackManager = CallbackManager.Factory.create();

    @Override
    protected void onCreate(final @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        callbackManager = CallbackManager.Factory.create();

        final LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(FB_EMAIL_PERMISSION);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(final LoginResult loginResult) {
                proceedToMainMapActivity();
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

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void proceedToMainMapActivity() {
        final Intent intent = new Intent(this, MainMapActivity.class);
        startActivity(intent);
    }
}
