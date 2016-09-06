package no.fript.fript.api;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public final class RequestQueueProvider {

    private static RequestQueue queue;

    public RequestQueueProvider(final Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public static RequestQueue getQueue() {
        return queue;
    }
}
