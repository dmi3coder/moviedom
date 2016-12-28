package io.github.dmi3coder.moviemo.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.dmi3coder.moviemo.R;

public class MovieActivity extends AppCompatActivity {
    MoviePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MovieListFragment fragment = new MovieListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_movie,fragment,"tag").commit();
        presenter = new MoviePresenter(fragment);
        presenter.start();
    }

}
