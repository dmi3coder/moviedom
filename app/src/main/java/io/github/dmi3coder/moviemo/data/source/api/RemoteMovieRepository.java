package io.github.dmi3coder.moviemo.data.source.api;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import io.github.dmi3coder.moviemo.Moviemo;
import io.github.dmi3coder.moviemo.data.Genre;
import io.github.dmi3coder.moviemo.data.Movie;
import io.github.dmi3coder.moviemo.data.source.MovieRepository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RemoteMovieRepository extends RemoteBaseRepository implements MovieRepository {
    private static RemoteMovieRepository instance;
    private MovieService service;
    private static final String TAG = "RemoteMovieRepository";
    private interface MovieService {
        @GET("movie/popular" + Moviemo.API_KEY_QUERY)
        Call<MovieList> getPopularMovies(@Query("page") Integer page);

    }


    public static RemoteMovieRepository getInstance() {
        if (instance == null) {
            instance = new RemoteMovieRepository();
        }
        return instance;
    }


    private RemoteMovieRepository() {
        super();
        service = retrofit.create(MovieService.class);
    }


    @Override
    public void getPopularMovies(int page, @NonNull LoadMovieCallback callback) {
        Call<MovieList> request = service.getPopularMovies(page);
        try{
            Response<MovieList> response = request.execute();
            Log.d(TAG, "getPopularMovies: "+request.request().url().toString());

        }catch (IOException e){
            callback.onError();
        }
    }

    @Override
    public void getMoviesByGenre(Genre genre, @NonNull LoadMovieCallback callback) {

    }

    public class MovieList {
        private Integer page;
        private List<Movie> results;

        public MovieList() {
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public List<Movie> getResults() {
            return results;
        }

        public void setResults(List<Movie> results) {
            this.results = results;
        }
    }


}
