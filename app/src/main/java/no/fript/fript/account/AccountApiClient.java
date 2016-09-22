package no.fript.fript.account;

import com.android.volley.RequestQueue;

import no.fript.fript.api.RequestQueueProvider;

public final class AccountApiClient {

    private static AccountApiClient instance;

    private final RequestQueue queue;

    private AccountApiClient() {
        this.queue = RequestQueueProvider.getQueue();
    }

    public void getAccount() {

    }

    public static AccountApiClient getInstance() {
        if (instance == null) {
            instance = new AccountApiClient();
        }
        return instance;
    }
}
