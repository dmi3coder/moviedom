package io.github.dmi3coder.moviemo.description;

import android.content.Context;
import android.content.Intent;
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

    public static void start(Context context,Movie movie){
        Intent intent = new Intent(context,DescriptionActivity.class);
        intent.putExtra(EXTRA_MOVIE,movie);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        findViewById(R.id.toolbar).setPadding(0,getStatusBarHeight(),0,0);
        movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        posterImage = (ImageView) findViewById(R.id.image);
        adultText = (TextView) findViewById(R.id.text_adult);
        overviewText = (TextView) findViewById(R.id.text_overview);
        rateText = (TextView) findViewById(R.id.rate);

        toolbar.setTitle(movie.getTitle());
        Glide.with(this).load("http://image.tmdb.org/t/p/w500/"+movie.getPosterPath()).into(posterImage);
        if(!movie.getAdult()) adultText.setVisibility(View.GONE);
        overviewText.setText(movie.getOverview()+movie.getOverview()+movie.getOverview()+movie.getOverview());
        rateText.setText(String.format("%s",movie.getVoteAverage()));


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
