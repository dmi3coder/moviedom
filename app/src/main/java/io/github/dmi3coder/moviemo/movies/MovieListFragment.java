package io.github.dmi3coder.moviemo.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.dmi3coder.moviemo.R;
import io.github.dmi3coder.moviemo.data.Movie;

public class MovieListFragment extends Fragment implements MovieContract.View{
    RecyclerView recyclerView;
    private MovieAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MovieAdapter(new ArrayList<Movie>());
        recyclerView.setAdapter(adapter);
        // TODO: 12/28/16 show empty view/loading
        return recyclerView;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void showMovies(List<Movie> movies) {
        adapter.movies = movies;
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showSearch() {

    }

    @Override
    public void save() {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void addMoreMovies(List<Movie> moviesToAdd) {
        adapter.movies.addAll(moviesToAdd);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(MovieContract.Presenter presenter) {

    }
}
