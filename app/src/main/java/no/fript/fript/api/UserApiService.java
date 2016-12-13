package no.fript.fript.api;

import no.fript.fript.user.FacebookLoginRequest;
import no.fript.fript.user.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

interface UserApiService {

    @POST("user/login")
    Call<User> logIn(@Body final FacebookLoginRequest facebookLoginRequest);
}
