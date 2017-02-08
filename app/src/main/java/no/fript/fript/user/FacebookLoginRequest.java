package no.fript.fript.user;

import retrofit2.Callback;

public final class FacebookLoginRequest {

    private final String loginToken;
    private final String userId;
    private final Callback<User> userCallback;

    FacebookLoginRequest(final String loginToken,
                         final String userId,
                         final Callback<User> userCallback) {
        this.loginToken = loginToken;
        this.userId = userId;
        this.userCallback = userCallback;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public String getUserId() {
        return userId;
    }

    public Callback<User> getUserCallback() {
        return userCallback;
    }
}
