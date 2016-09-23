package no.fript.fript.useraccount;

public final class UserAccount {

    private final long accountId;
    private final boolean hasBeenOnboarded;

    UserAccount(final long accountId,
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
