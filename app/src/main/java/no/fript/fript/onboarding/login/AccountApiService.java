package no.fript.fript.onboarding.login;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AccountApiService {

    @GET("/account")
    Call<Account> getAccount();
}
