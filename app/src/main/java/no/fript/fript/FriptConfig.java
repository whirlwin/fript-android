package no.fript.fript;

import android.content.Context;

import no.fript.fript.api.RequestQueueProvider;

public final class FriptConfig {

    private final RequestQueueProvider requestQueueProvider;

    public FriptConfig(final Context context) {
        this.requestQueueProvider = new RequestQueueProvider(context);
    }

    public void configure() {
    }
}
