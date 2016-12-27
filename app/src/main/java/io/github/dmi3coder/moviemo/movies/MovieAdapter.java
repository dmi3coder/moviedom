package io.github.dmi3coder.moviemo.movies;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
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


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    LayoutInflater inflater;

    public MovieAdapter(List<PreviewMovie> movies) {
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_movie, parent, false);
        return new MovieHolder(v);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load("https://upload.wikimedia.org/wikipedia/en/2/29/Movie_poster_for_%22Scary_Movie%22.jpg")
                .asBitmap()
                .into(new BitmapImageViewTarget(holder.image) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getView().getResources(),resource);
                        drawable.setCornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,8,getView().getResources().getDisplayMetrics()));
                        setDrawable(drawable);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return 20;
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
