package io.github.dmi3coder.moviedom.movies;

import java.util.List;

import io.github.dmi3coder.moviedom.BasePresenter;
import io.github.dmi3coder.moviedom.BaseView;
import io.github.dmi3coder.moviedom.data.Genre;
import io.github.dmi3coder.moviedom.data.Movie;

public interface MovieContract {

    interface View extends BaseView<Presenter>{
        void setTitle(String title);
        void showMovies(List<Movie> movies);
        void showSearch();

        void setEmpty();
        void setError(String error);
        void showMovie(Movie movie);

        void save();
        boolean isActive();
        void addMoreMovies(List<Movie> moviesToAdd);
    }

    interface Presenter extends BasePresenter{

        void result(int requestCode, int resultCode);

        void loadMore();

        void loadMovies();

        void searchByTitle(String title);
        void loadMovie(String movieId);

        void loadMovies(Genre genre);
    }
}
