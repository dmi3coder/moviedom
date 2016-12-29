package io.github.dmi3coder.moviemo.movies;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.github.dmi3coder.moviemo.R;

public class MovieActivity extends AppCompatActivity {
    MoviePresenter presenter;
    FloatingActionButton searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchButton = ((FloatingActionButton) findViewById(R.id.fab_search));
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 12/29/16 add search action
            }
        });
        MovieListFragment fragment = new MovieListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_movie,fragment,"tag").commit();
        presenter = new MoviePresenter(fragment);
        presenter.start();
    }

}
