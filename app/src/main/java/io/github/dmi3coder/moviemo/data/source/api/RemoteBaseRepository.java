package io.github.dmi3coder.moviemo.data.source.api;

import com.google.gson.Gson;

import io.github.dmi3coder.moviemo.Moviemo;
import retrofit2.Retrofit;

public abstract class RemoteBaseRepository {
    protected Gson gson;
    protected Retrofit retrofit;

    protected RemoteBaseRepository() {
        gson = Moviemo.getGson();
        retrofit = Moviemo.getRetrofit();
    }
}
