package io.github.dmi3coder.moviemo.movies;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import io.github.dmi3coder.moviemo.R;

public class MovieActivity extends AppCompatActivity {
    MoviePresenter presenter;
    FloatingActionButton searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MovieListFragment fragment = new MovieListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_movie,fragment,"tag").commit();
        presenter = new MoviePresenter(fragment);
        searchButton = ((FloatingActionButton) findViewById(R.id.fab_search));
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText input = new EditText(MovieActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                AlertDialog dialog = new AlertDialog.Builder(MovieActivity.this,android.R.style.Theme_Material_Light_Dialog_NoActionBar_MinWidth)
                        .setView(input)
                        .setPositiveButton("Search", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                presenter.searchByTitle(input.getText().toString());
                            }
                        })
                        .setTitle("Search movies")
                        .create();
                dialog.show();
            }
        });
        presenter.start();
    }


}
