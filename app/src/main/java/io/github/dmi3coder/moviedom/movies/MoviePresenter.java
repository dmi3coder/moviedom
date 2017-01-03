package io.github.dmi3coder.moviedom.movies;

import android.support.annotation.NonNull;

import io.github.dmi3coder.moviedom.data.Genre;
import io.github.dmi3coder.moviedom.data.Movie;
import io.github.dmi3coder.moviedom.data.source.MovieRepository;
import io.github.dmi3coder.moviedom.data.source.api.RemoteMovieRepository;

public class MoviePresenter implements MovieContract.Presenter {
    private static final String TAG = "MoviePresenter";
    private MovieRepository repository;
    private MovieContract.View view;
    private okhttp3.Response currentResponse;

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
        repository.getNextPage(currentResponse.request(), new MovieRepository.LoadMoviesCallback() {
            @Override
            public void onMoviesLoaded(RemoteMovieRepository.MovieList movies, okhttp3.Response response) {
                view.addMoreMovies(movies.getResults());
                currentResponse = response;
            }

            @Override
            public void onError() {
                view.setError("Can't load more");
            }
        });
    }

    @Override
    public void loadMovies() {
        repository.getPopularMovies(1, new MovieRepository.LoadMoviesCallback() {
            @Override
            public void onMoviesLoaded(RemoteMovieRepository.MovieList movies, okhttp3.Response response) {
                view.showMovies(movies.getResults());
                currentResponse = response;
            }

            @Override
            public void onError() {
                view.setEmpty();
            }
        });
    }

    @Override
    public void searchByTitle(final String title) {
        repository.getMoviesByQuery(title, new MovieRepository.LoadMoviesCallback() {
            @Override
            public void onMoviesLoaded(RemoteMovieRepository.MovieList movies, okhttp3.Response response) {
                view.showMovies(movies.getResults());
                view.setTitle(title);
                currentResponse = response;
            }

            @Override
            public void onError() {
                view.setEmpty();
            }
        });
    }

    @Override
    public void loadMovie(String movieId) {
        repository.getMovie(movieId, new MovieRepository.MovieCallback() {
            @Override
            public void onMovieLoaded(Movie movie) {
                view.showMovie(movie);
            }

            @Override
            public void onError() {
                view.setError("No video found");
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
