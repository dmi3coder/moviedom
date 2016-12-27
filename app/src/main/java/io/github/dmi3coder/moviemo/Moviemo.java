package io.github.dmi3coder.moviemo;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Moviemo extends Application {
    public static final String API_KEY = "d713f705e425274fbb576076c15be337";
    public static final String API_KEY_QUERY = "?api_key="+API_KEY;
    public static final String API_VERSION = "3";
    public static final String API_URL = String.format("https://api.themoviedb.org/%s/",API_VERSION);


    private static Gson gson;
    private static Retrofit retrofit;


    @Override
    public void onCreate() {
        super.onCreate();
        gson = new GsonBuilder().create();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(API_URL)
                .build();
    }


    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static Gson getGson(){
        return gson;
    }

}
