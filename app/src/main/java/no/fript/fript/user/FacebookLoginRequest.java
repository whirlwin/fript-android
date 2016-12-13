package no.fript.fript.user;

public final class FacebookLoginRequest {

    private final String loginToken;
    private final String userId;

    public FacebookLoginRequest(final String loginToken, final String userId) {
        this.loginToken = loginToken;
        this.userId = userId;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public String getUserId() {
        return userId;
    }
}
