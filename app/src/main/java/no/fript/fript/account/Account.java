package no.fript.fript.account;

public final class Account {

    private final long accountId;

    public Account(final long accountId) {
        this.accountId = accountId;
    }

    public long getAccountId() {
        return accountId;
    }
}
