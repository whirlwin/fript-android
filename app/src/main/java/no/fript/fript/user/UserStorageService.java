package no.fript.fript.user;

import android.util.Log;

import com.facebook.AccessToken;
import com.google.common.base.Optional;

import java.io.IOException;

import javax.inject.Inject;

import no.fript.fript.Components;
import no.fript.fript.FriptApp;
import no.fript.fript.LogConstants;
import no.fript.fript.api.ApiClient;

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
            final AccessToken accessToken = maybeAccessToken.get();
            try {
                final FacebookLoginRequest facebookLoginRequest =
                        new FacebookLoginRequest(accessToken.getToken(), accessToken.getUserId());
                this.apiClient.logIn(facebookLoginRequest);
            } catch (final IOException e) {
                Log.e(LogConstants.LOG_IN, "Failed to load user into storage", e);
            }
        }
    }

    public Optional<User> getCurrentUserAccount() {
        return currentUser;
    }
}
