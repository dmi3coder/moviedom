package io.github.dmi3coder.moviemo.data.source;

import android.support.annotation.NonNull;
import android.support.annotation.StringDef;

import java.util.List;

import io.github.dmi3coder.moviemo.data.Genre;
import io.github.dmi3coder.moviemo.data.Movie;
import io.github.dmi3coder.moviemo.data.source.api.RemoteMovieRepository;
import okhttp3.Request;
import okhttp3.Response;

public interface MovieRepository {

    public interface LoadMovieCallback extends BaseCallback{
        void onMovieLoaded(RemoteMovieRepository.MovieList movies,Response response);
    }

    void getPopularMovies(int page,@NonNull LoadMovieCallback callback);

    void getMoviesByGenre(Genre genre, @NonNull LoadMovieCallback callback);

    void getMoviesByQuery(String query, @NonNull LoadMovieCallback callback);

    void getNextPage(Request request, LoadMovieCallback callback);


}
