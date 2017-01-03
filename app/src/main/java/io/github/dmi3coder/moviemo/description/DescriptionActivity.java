package io.github.dmi3coder.moviemo.description;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import io.github.dmi3coder.moviemo.R;
import io.github.dmi3coder.moviemo.data.Movie;

public class DescriptionActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "io.github.dmi3coder.moviemo.EXTRA_MOVIE";

    private Movie movie;

    private Toolbar toolbar;
    private ImageView posterImage;
    private TextView adultText;
    private TextView overviewText;
    private TextView rateText;
    private TextView budgetText;
    private TextView languageText;
    private TextView genreText;

    public static void start(Context context,Movie movie){
        Intent intent = new Intent(context,DescriptionActivity.class);
        intent.putExtra(EXTRA_MOVIE,movie);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        posterImage = (ImageView) findViewById(R.id.image);
        adultText = (TextView) findViewById(R.id.text_adult);
        overviewText = (TextView) findViewById(R.id.text_overview);
        rateText = (TextView) findViewById(R.id.rate);
        budgetText = (TextView) findViewById(R.id.budget);
        languageText = (TextView) findViewById(R.id.language);
        genreText = (TextView) findViewById(R.id.genre);
        try {
            genreText.setText(movie.getGenres().get(0).getName());
        }catch (Exception e){

        }

        toolbar.setTitle(movie.getTitle());
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Glide.with(this).load("http://image.tmdb.org/t/p/w500/"+movie.getPosterPath()).into(posterImage);
        if(movie.getAdult()) adultText.setVisibility(View.VISIBLE);
        overviewText.setText(movie.getOverview());
        rateText.setText(movie.getVoteAverage().toString());
        budgetText.setText("Budget: "+movie.getBudget());
        languageText.setText("Original language: "+movie.getOriginalLanguage());


    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
