package io.github.dmi3coder.moviemo.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import io.github.dmi3coder.moviemo.data.Genre;

public interface GenreRepository {

    interface LoadGenreCallback extends BaseCallback{
        void onGenresLoaded(List<Genre> genres);
    }

    List<Genre> getGenres();

}
