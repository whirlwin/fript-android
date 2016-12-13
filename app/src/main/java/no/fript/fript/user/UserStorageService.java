package no.fript.fript.user;

import com.facebook.AccessToken;
import com.google.common.base.Optional;

import javax.inject.Inject;

public final class UserStorageService {

    private static Optional<User> currentUser;

    static {
        currentUser = Optional.absent();
    }

    public void loadUserIntoStorage() {
        final Optional<AccessToken> maybeAccessToken = Optional.fromNullable(AccessToken.getCurrentAccessToken());
        if (maybeAccessToken.isPresent()) {

        } else {

        }
        /*
        final AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if (accessToken != null) {
            userAccountApiClient.getAccount(accessToken, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(final JSONObject response) {
                    final User maybeUser = userMapper.mapToUserAccount(response);
                    currentUser = Optional.of(maybeUser);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    final String errMsg = "Failed to get account for FB userId "
                            + accessToken.getUserId();
                    Log.e(LogConstants.ACCOUNT, errMsg, error);
                }
            });
        }
        */
    }

    public Optional<User> getCurrentUserAccount() {
        return currentUser;
    }
}
