package no.fript.fript;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Optional;

public final class CreateGymTypePreference {

    private final long gymTypeId;

    public CreateGymTypePreference(final long gymTypeId) {
        this.gymTypeId = gymTypeId;
    }

    public JSONObject toJSONObject() throws JSONException {
        final JSONObject json = new JSONObject();
        json.put("gymTypeId", gymTypeId);
        return json;
    }
}
