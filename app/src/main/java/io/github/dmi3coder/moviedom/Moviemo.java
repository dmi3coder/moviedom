package io.github.dmi3coder.moviedom;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
    private static Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder requestBuilder = chain.request().newBuilder();
            HttpUrl.Builder url = chain.request().url().newBuilder();
            url.addQueryParameter("api_key",API_KEY);
            return chain.proceed(requestBuilder.url(url.build()).build());
        }
    };

    private static final String TAG = "Moviemo";

    @Override
    public void onCreate() {
        super.onCreate();
        gson = new GsonBuilder().create();
        client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
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
