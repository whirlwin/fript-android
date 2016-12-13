package no.fript.fript.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitConfig {

    public Retrofit configureRetrofit() {
       return new Retrofit.Builder()
               .baseUrl(ApiConstants.BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
    }
}
