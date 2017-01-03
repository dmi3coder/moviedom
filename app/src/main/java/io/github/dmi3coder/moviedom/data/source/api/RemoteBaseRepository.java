package io.github.dmi3coder.moviedom.data.source.api;

import com.google.gson.Gson;

import io.github.dmi3coder.moviedom.Moviemo;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public abstract class RemoteBaseRepository {
    protected Gson gson;
    protected Retrofit retrofit;
    protected OkHttpClient client;

    protected RemoteBaseRepository() {
        gson = Moviemo.getGson();
        retrofit = Moviemo.getRetrofit();
        client = Moviemo.getClient();
    }
}
