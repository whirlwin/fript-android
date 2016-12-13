package no.fript.fript.user;

public final class User {

    private final long accountId;
    private final boolean hasBeenOnboarded;

    User(final long accountId,
         final boolean hasBeenOnboarded) {
        this.accountId = accountId;
        this.hasBeenOnboarded = hasBeenOnboarded;
    }

    public long getAccountId() {
        return accountId;
    }

    public boolean hasBeenOnboarded() {
        return hasBeenOnboarded;
    }
}
