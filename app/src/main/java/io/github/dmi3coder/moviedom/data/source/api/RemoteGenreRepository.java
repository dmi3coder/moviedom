package io.github.dmi3coder.moviedom.data.source.api;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.github.dmi3coder.moviedom.data.Genre;
import io.github.dmi3coder.moviedom.data.source.GenreRepository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public class RemoteGenreRepository extends RemoteBaseRepository implements GenreRepository {
    private static final String TAG = "RemoteGenreRepository";

    private interface GenreService{
        @GET("genre/movie/list")
        Call<GenreList> loadGenres();
    }

    private static RemoteGenreRepository instance = null;
    private static List<Genre> genres;
    private GenreService service;

    private RemoteGenreRepository(){
        super();
        genres = new ArrayList<>();
        service = retrofit.create(GenreService.class);
    }

    @Override
    public List<Genre> getGenres() {
        Call<GenreList> request = service.loadGenres();
        try {
            Log.d(TAG, "getGenres: "+request.request().url());
            Response<GenreList> response = request.execute();
            Log.d(TAG, "doInBackground: "+response.raw().toString());
            genres = response.body().genres;
            return genres;
        } catch (Exception e){
            Log.d(TAG, "getGenres: "+e);
            return null;
        }
    }


    public static RemoteGenreRepository getInstance() {
        if(instance == null){
            instance = new RemoteGenreRepository();
        }
        return instance;
    }

    public class GenreList{

        private List<Genre> genres;

        public GenreList() {
        }

        public List<Genre> getGenres() {
            return genres;
        }

        public void setGenres(List<Genre> genres) {
            this.genres = genres;
        }
    }


}
