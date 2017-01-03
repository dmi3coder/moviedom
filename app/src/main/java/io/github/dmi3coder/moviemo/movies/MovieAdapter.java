package io.github.dmi3coder.moviemo.movies;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

import io.github.dmi3coder.moviemo.R;
import io.github.dmi3coder.moviemo.data.Movie;
import io.github.dmi3coder.moviemo.data.source.PreviewMovie;
import io.github.dmi3coder.moviemo.description.DescriptionActivity;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    LayoutInflater inflater;
    public List<Movie> movies;
    private static final String TAG = "MovieAdapter";
    private MovieContract.Presenter presenter;

    public MovieAdapter(List<Movie> movies, MovieContract.Presenter presenter) {
        this.movies = movies;
        this.presenter = presenter;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_movie, parent, false);
        return new MovieHolder(v);
    }

    @Override
    public void onBindViewHolder(final MovieHolder holder, final int position) {
        final Context context = holder.itemView.getContext();
        final Movie movie = movies.get(position);
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w185/"+movie.getPosterPath())
                .asBitmap()
                .into(new BitmapImageViewTarget(holder.image) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getView().getResources(),resource);
                        drawable.setCornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,8,getView().getResources().getDisplayMetrics()));
                        setDrawable(drawable);
                    }
                });
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getVoteAverage().toString());
        holder.moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadMovie(movie.getId()+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView genre;
        private TextView title;
        private Button moreButton;
        private ImageView shareButton;
        private ImageView likeButton;

        public MovieHolder(View v) {
            super(v);
            image = ((ImageView) v.findViewById(R.id.image));
            genre = ((TextView) v.findViewById(R.id.genre));
            title = ((TextView) v.findViewById(R.id.title));
            moreButton = ((Button) v.findViewById(R.id.button));
        }
    }
}
