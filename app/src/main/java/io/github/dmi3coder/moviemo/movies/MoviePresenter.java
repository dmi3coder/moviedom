package io.github.dmi3coder.moviemo.movies;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

import io.github.dmi3coder.moviemo.data.Genre;
import io.github.dmi3coder.moviemo.data.Movie;
import io.github.dmi3coder.moviemo.data.source.MovieRepository;
import io.github.dmi3coder.moviemo.data.source.api.RemoteMovieRepository;

public class MoviePresenter implements MovieContract.Presenter {

    private MovieRepository repository;
    private MovieContract.View view;

    public MoviePresenter(@NonNull MovieContract.View view) {
        this.view = view;
        repository = RemoteMovieRepository.getInstance();
        view.setPresenter(this);
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadMovies() {
        repository.getPopularMovies(1, new MovieRepository.LoadMovieCallback() {
            @Override
            public void onMovieLoaded(List<Movie> movies, int page) {
                view.showMovies(movies);
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
