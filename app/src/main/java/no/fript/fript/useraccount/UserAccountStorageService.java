package no.fript.fript.useraccount;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.facebook.AccessToken;
import com.google.common.base.Optional;

import org.json.JSONObject;

import no.fript.fript.LogConstants;

public final class UserAccountStorageService {

    private static UserAccountStorageService instance;
    private static Optional<UserAccount> currentUserAccount;

    private final UserAccountApiClient userAccountApiClient;
    private final UserAccountMapper userAccountMapper;

    static {
        currentUserAccount = Optional.absent();
    }

    private UserAccountStorageService() {
        this.userAccountApiClient = UserAccountApiClient.getInstance();
        this.userAccountMapper = UserAccountMapper.getInstance();
    }

    public void loadUserAccount() {
        final AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if (accessToken != null) {
            userAccountApiClient.getAccount(accessToken, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(final JSONObject response) {
                    final UserAccount maybeUserAccount = userAccountMapper.mapToUserAccount(response);
                    currentUserAccount = Optional.of(maybeUserAccount);
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
    }

    public Optional<UserAccount> getCurrentUserAccount() {
        return currentUserAccount;
    }

    public static UserAccountStorageService getInstance() {
        if (instance == null) {
            instance = new UserAccountStorageService();
        }
        return instance;
    }
}
