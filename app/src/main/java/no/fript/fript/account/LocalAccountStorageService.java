package no.fript.fript.account;

public final class LocalAccountStorageService {

    private static LocalAccountStorageService instance;

    private final AccountApiClient accountApiClient;

    private LocalAccountStorageService() {
        accountApiClient = AccountApiClient.getInstance();
    }

    public void loadUserAccount() {

    }

    public static LocalAccountStorageService getInstance() {
        if (instance == null) {
            instance = new LocalAccountStorageService();
        }
        return instance;
    }
}
