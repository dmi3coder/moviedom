package io.github.dmi3coder.moviemo.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import io.github.dmi3coder.moviemo.data.Genre;
import io.github.dmi3coder.moviemo.data.Movie;

public interface MovieRepository {

    public interface LoadMovieCallback extends BaseCallback{
        void onMovieLoaded(List<Movie> movies, int page);
    }

    void getPopularMovies(int page,@NonNull LoadMovieCallback callback);

    void getMoviesByGenre(Genre genre, @NonNull LoadMovieCallback callback);


}
