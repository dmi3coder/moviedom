package io.github.dmi3coder.moviemo.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.dmi3coder.moviemo.R;
import io.github.dmi3coder.moviemo.data.Movie;

public class MovieListFragment extends Fragment implements MovieContract.View{
    private static final String TAG = "MovieListFragment";
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private MovieAdapter adapter;
    private boolean loading = false;
    private int pastVisiblesItems, visibleItemCount, totalItemCount;
    private MovieContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        recyclerView = new RecyclerView(getContext());

        manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        adapter = new MovieAdapter(new ArrayList<Movie>());
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dy > 0)
                {
                   int  visibleItemCount = manager.getChildCount();

                    totalItemCount = manager.getItemCount();
                    pastVisiblesItems = manager.findFirstVisibleItemPosition();
                    Log.d(TAG, "onScrolled: "+pastVisiblesItems);
                    if (!loading)
                    {
                        if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount)
                        {
                            loading = true;
                            presenter.loadMore();
                            Toast.makeText(getContext(), "loading new ;)", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
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
        loading = false;
    }

    @Override
    public void setPresenter(MovieContract.Presenter presenter) {

        this.presenter = presenter;
    }
}
