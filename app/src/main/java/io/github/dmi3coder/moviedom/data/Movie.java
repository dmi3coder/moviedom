package io.github.dmi3coder.moviedom.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Parcelable {

    private Integer budget;

    @SerializedName("vote_average")
    private Double voteAverage;

    @SerializedName("backdrop_path")
    private String backdropPath;

    private List<Genre> genres;

    private String status;

    private Integer runtime;

    @SerializedName("spoken_languages")
    private List<SpokenLanguage> spokenLanguages;

    private Boolean adult;

    private String homepage;

    private Integer id;

    @SerializedName("production_countries")
    private List<ProductionCountry> productionCountries;

    private String title;

    @SerializedName("original_language")
    private String originalLanguage;

    private String overview;
    @SerializedName("production_companies")
    private List<ProductionCompany> productionCompanies;

    @SerializedName("belongs_to_collection")
    private Collection collection;

    private String imdb_id;

    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("vote_count")
    private Integer voteCount;
    @SerializedName("poster_path")
    private String posterPath;

    private Boolean video;

    private String tagline;

    private Integer revenue;

    private Double popularity;

    public Movie() {
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    protected Movie(Parcel in) {
        budget = in.readByte() == 0x00 ? null : in.readInt();
        voteAverage = in.readByte() == 0x00 ? null : in.readDouble();
        backdropPath = in.readString();
        if (in.readByte() == 0x01) {
            genres = new ArrayList<Genre>();
            in.readList(genres, Genre.class.getClassLoader());
        } else {
            genres = null;
        }
        status = in.readString();
        runtime = in.readByte() == 0x00 ? null : in.readInt();
        if (in.readByte() == 0x01) {
            spokenLanguages = new ArrayList<SpokenLanguage>();
            in.readList(spokenLanguages, SpokenLanguage.class.getClassLoader());
        } else {
            spokenLanguages = null;
        }
        byte adultVal = in.readByte();
        adult = adultVal == 0x02 ? null : adultVal != 0x00;
        homepage = in.readString();
        id = in.readByte() == 0x00 ? null : in.readInt();
        if (in.readByte() == 0x01) {
            productionCountries = new ArrayList<ProductionCountry>();
            in.readList(productionCountries, ProductionCountry.class.getClassLoader());
        } else {
            productionCountries = null;
        }
        title = in.readString();
        originalLanguage = in.readString();
        overview = in.readString();
        if (in.readByte() == 0x01) {
            productionCompanies = new ArrayList<ProductionCompany>();
            in.readList(productionCompanies, ProductionCompany.class.getClassLoader());
        } else {
            productionCompanies = null;
        }
        collection = (Collection) in.readValue(Collection.class.getClassLoader());
        imdb_id = in.readString();
        releaseDate = in.readString();
        originalTitle = in.readString();
        voteCount = in.readByte() == 0x00 ? null : in.readInt();
        posterPath = in.readString();
        byte videoVal = in.readByte();
        video = videoVal == 0x02 ? null : videoVal != 0x00;
        tagline = in.readString();
        revenue = in.readByte() == 0x00 ? null : in.readInt();
        popularity = in.readByte() == 0x00 ? null : in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (budget == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(budget);
        }
        if (voteAverage == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(voteAverage);
        }
        dest.writeString(backdropPath);
        if (genres == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(genres);
        }
        dest.writeString(status);
        if (runtime == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(runtime);
        }
        if (spokenLanguages == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(spokenLanguages);
        }
        if (adult == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (adult ? 0x01 : 0x00));
        }
        dest.writeString(homepage);
        if (id == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(id);
        }
        if (productionCountries == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(productionCountries);
        }
        dest.writeString(title);
        dest.writeString(originalLanguage);
        dest.writeString(overview);
        if (productionCompanies == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(productionCompanies);
        }
        dest.writeValue(collection);
        dest.writeString(imdb_id);
        dest.writeString(releaseDate);
        dest.writeString(originalTitle);
        if (voteCount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(voteCount);
        }
        dest.writeString(posterPath);
        if (video == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (video ? 0x01 : 0x00));
        }
        dest.writeString(tagline);
        if (revenue == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(revenue);
        }
        if (popularity == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(popularity);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}