package io.github.dmi3coder.moviedom.data.source;

import android.support.annotation.NonNull;

import io.github.dmi3coder.moviedom.data.Genre;
import io.github.dmi3coder.moviedom.data.Movie;
import io.github.dmi3coder.moviedom.data.source.api.RemoteMovieRepository;
import okhttp3.Request;
import okhttp3.Response;

public interface MovieRepository {

    public interface LoadMoviesCallback extends BaseCallback{
        void onMoviesLoaded(RemoteMovieRepository.MovieList movies, Response response);
    }

    public interface MovieCallback extends BaseCallback{

        void onMovieLoaded(Movie movie);
    }

    void getPopularMovies(int page,@NonNull LoadMoviesCallback callback);

    void getMoviesByGenre(Genre genre, @NonNull LoadMoviesCallback callback);

    void getMoviesByQuery(String query, @NonNull LoadMoviesCallback callback);

    void getMovie(String id, @NonNull MovieCallback callback);

    void getNextPage(Request request, LoadMoviesCallback callback);


}
