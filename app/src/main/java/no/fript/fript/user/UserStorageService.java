package no.fript.fript.user;

import android.util.Log;

import com.facebook.AccessToken;
import com.google.common.base.Optional;

import java.io.IOException;

import javax.inject.Inject;

import no.fript.fript.LogConstants;
import no.fript.fript.api.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserStorageService {

    private final ApiClient apiClient;

    private static Optional<User> currentUser;

    static {
        currentUser = Optional.absent();
    }

    @Inject
    public UserStorageService(final ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public void loadUserIntoStorage() {
        final Optional<AccessToken> maybeAccessToken =
                Optional.fromNullable(AccessToken.getCurrentAccessToken());
        if (maybeAccessToken.isPresent()) {
            final AccessToken token = maybeAccessToken.get();
            new FacebookLoginRequest(token.getToken(), token.getUserId(), new Callback<User>() {

                @Override
                public void onResponse(final Call<User> call, final Response<User> response) {
                    handleLogInResultSuccess(response);
                }

                @Override
                public void onFailure(final Call<User> call, final Throwable t) {
                    Log.e(LogConstants.LOG_IN, "Failed to load user into storage", t);
                }
            });
        }
    }

    private void handleLogInResultSuccess(final Response<User> response) {
        if (response.isSuccessful()) {
            response.body();
        } else {
            Log.e(LogConstants.LOG_IN,
                    "Failed to load user into storage: " + response.errorBody().toString());
        }
    }

    public Optional<User> getCurrentUserAccount() {
        return currentUser;
    }
}
