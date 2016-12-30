package io.github.dmi3coder.moviemo.movies;

import java.util.List;

import io.github.dmi3coder.moviemo.BasePresenter;
import io.github.dmi3coder.moviemo.BaseView;
import io.github.dmi3coder.moviemo.data.Genre;
import io.github.dmi3coder.moviemo.data.Movie;

public interface MovieContract {

    interface View extends BaseView<Presenter>{
        void setTitle(String title);
        void showMovies(List<Movie> movies);
        void showSearch();

        void save();
        boolean isActive();
        void addMoreMovies(List<Movie> moviesToAdd);
    }

    interface Presenter extends BasePresenter{

        void result(int requestCode, int resultCode);

        void loadMore();

        void loadMovies();

        void loadMovies(Genre genre);
    }
}
