package io.github.dmi3coder.moviemo;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.github.dmi3coder.moviemo.data.Movie;
import io.github.dmi3coder.moviemo.data.source.MovieRepository;
import io.github.dmi3coder.moviemo.data.source.api.RemoteMovieRepository;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Moviemo extends Application {
    public static final String API_KEY = "d713f705e425274fbb576076c15be337";
    public static final String API_KEY_QUERY = "?api_key="+API_KEY;
    public static final String API_VERSION = "3";
    public static final String API_URL = "http://api.themoviedb.org/3/";


    private static Gson gson;
    private static Retrofit retrofit;
    private static OkHttpClient client;

    private static final String TAG = "Moviemo";

    @Override
    public void onCreate() {
        super.onCreate();
        gson = new GsonBuilder().create();
        client = new OkHttpClient();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(API_URL)
                .client(client)
                .build();
    }


    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static Gson getGson(){
        return gson;
    }

    public static OkHttpClient getClient() {
        return client;
    }
}
