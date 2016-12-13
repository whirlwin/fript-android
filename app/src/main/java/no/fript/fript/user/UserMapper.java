package no.fript.fript.user;

import org.json.JSONObject;

public final class UserMapper {

    User mapToUserAccount(final JSONObject json) {
        return new User(
                123,
                false
        );
    }
}
