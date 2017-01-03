package io.github.dmi3coder.moviemo.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Collection implements Parcelable {

    private String id;

    private String backdrop_path;

    private String name;

    private String poster_path;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getBackdrop_path ()
    {
        return backdrop_path;
    }

    public void setBackdrop_path (String backdrop_path)
    {
        this.backdrop_path = backdrop_path;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPoster_path ()
    {
        return poster_path;
    }

    public void setPoster_path (String poster_path)
    {
        this.poster_path = poster_path;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", backdrop_path = "+backdrop_path+", name = "+name+", poster_path = "+poster_path+"]";
    }

    protected Collection(Parcel in) {
        id = in.readString();
        backdrop_path = in.readString();
        name = in.readString();
        poster_path = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(backdrop_path);
        dest.writeString(name);
        dest.writeString(poster_path);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Collection> CREATOR = new Parcelable.Creator<Collection>() {
        @Override
        public Collection createFromParcel(Parcel in) {
            return new Collection(in);
        }

        @Override
        public Collection[] newArray(int size) {
            return new Collection[size];
        }
    };
}
