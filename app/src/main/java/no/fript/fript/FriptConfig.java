package no.fript.fript;

import android.content.Context;

import no.fript.fript.api.RequestQueueProvider;

public final class FriptConfig {

    private final Context context;

    private RequestQueueProvider requestQueueProvider;

    public FriptConfig(final Context context) {
        this.context = context;
    }

    public void configure() {
        this.requestQueueProvider = new RequestQueueProvider(context);
    }
}
