package io.github.dmi3coder.moviemo.data.source.api;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.dmi3coder.moviemo.Moviemo;
import io.github.dmi3coder.moviemo.data.Genre;
import io.github.dmi3coder.moviemo.data.source.GenreRepository;
import retrofit2.Call;
import retrofit2.http.GET;

public class RemoteGenreRepository implements GenreRepository {

    private interface GenreService{
        @GET("/genre/movie/list"+ Moviemo.API_KEY_QUERY)
        Call<GenreList> loadGenres();
    }

    private static RemoteGenreRepository instance = null;
    private List<Genre> genres = null;
    private GenreService service;

    private RemoteGenreRepository(){
        instance.genres = new ArrayList<>();
        service = Moviemo.getRetrofit().create(GenreService.class);
    }

    @Override
    public void getGenres(@NonNull LoadGenreCallback callback) {
        if(genres!=null && genres.size()>0) callback.onGenresLoaded(genres);
        Call<GenreList> request = service.loadGenres();

        try {
            genres = request.execute().body().genres;
            callback.onGenresLoaded(genres);
        } catch (IOException e){
            callback.onGenresError();
            e.printStackTrace();
        }
    }


    public static RemoteGenreRepository getInstance() {
        if(instance == null){
            instance = new RemoteGenreRepository();

        }
        return instance;
    }

    private class GenreList{

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
