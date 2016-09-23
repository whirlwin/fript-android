package no.fript.fript.useraccount;

import org.json.JSONObject;

final class UserAccountMapper {

    private static UserAccountMapper instance;

    UserAccount mapToUserAccount(final JSONObject json) {
        return new UserAccount(
                123,
                false
        );
    }

    static UserAccountMapper getInstance() {
        if (instance == null) {
            instance = new UserAccountMapper();
        }
        return instance;
    }
}
