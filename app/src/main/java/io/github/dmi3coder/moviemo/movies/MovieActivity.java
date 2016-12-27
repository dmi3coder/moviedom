package io.github.dmi3coder.moviemo.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.dmi3coder.moviemo.R;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_movie,new MovieListFragment(),"tag").commit();

    }

}
