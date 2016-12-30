package io.github.dmi3coder.moviemo.movies;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import io.github.dmi3coder.moviemo.data.Genre;
import io.github.dmi3coder.moviemo.data.Movie;
import io.github.dmi3coder.moviemo.data.source.MovieRepository;
import io.github.dmi3coder.moviemo.data.source.api.RemoteMovieRepository;
import okhttp3.Request;
import retrofit2.Response;

public class MoviePresenter implements MovieContract.Presenter {
    private static final String TAG = "MoviePresenter";
    private MovieRepository repository;
    private MovieContract.View view;
    protected okhttp3.Response currentResponse;

    public MoviePresenter(@NonNull MovieContract.View view) {
        this.view = view;
        repository = RemoteMovieRepository.getInstance();
        view.setPresenter(this);
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadMore() {
        repository.getNextPage(currentResponse.request(), new MovieRepository.LoadMovieCallback() {
            @Override
            public void onMovieLoaded(RemoteMovieRepository.MovieList movies, okhttp3.Response response) {
                view.addMoreMovies(movies.getResults());
                currentResponse = response;
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void loadMovies() {
        repository.getPopularMovies(1, new MovieRepository.LoadMovieCallback() {
            @Override
            public void onMovieLoaded(RemoteMovieRepository.MovieList movies, okhttp3.Response response) {
                view.showMovies(movies.getResults());
                currentResponse = response;
            }

            @Override
            public void onError() {

            }
        });
    }



    @Override
    public void loadMovies(Genre genre) {

    }

    @Override
    public void start() {
        loadMovies();
    }

}
