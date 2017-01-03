package io.github.dmi3coder.moviedom.data.source;

import java.util.List;

import io.github.dmi3coder.moviedom.data.Genre;

public interface GenreRepository {

    interface LoadGenreCallback extends BaseCallback{
        void onGenresLoaded(List<Genre> genres);
    }

    List<Genre> getGenres();

}
