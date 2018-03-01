package com.example.android.popularmovies;

import android.os.Parcelable;
import android.os.Parcel;


/**
 * Created by casab on 23/02/2018.
 */

// Users on StackOverFlow suggested to make an object Parceable to make easier the intents
//from the main activity to the details activity
// https://stackoverflow.com/questions/7791998/how-to-define-parcelable-of-interface-type-in-aidl-file

public class Movie implements Parcelable {

    String movieImagePath;
    String movieOriginalTitle;
    String movieSynopsis;
    String movieRating;
    String movieReleaseDate;

    //Path for the dimension suggested by the project guidelines
    private String TMDB_IMAGE_URL_BASE = "https://image.tmdb.org/t/p/w185";

    //Constructor of the array
    public Movie() {
    }

    //Methods to SET/GET variables from the Class Movie

    public void setImagePath(String image) {
        movieImagePath = image;
    }

    public String getImage() {
        return TMDB_IMAGE_URL_BASE + movieImagePath;
    }

    public void setOriginalTitle(String originalTitle) {
        movieOriginalTitle = originalTitle;
    }

    public String getOrginalTitle() {
        return movieOriginalTitle;
    }

    public void setSynopsis(String overview) {
        movieSynopsis = overview;
    }

    public String getSynopsis() {
        return movieSynopsis;
    }

    public void setRating(String rating) {
        movieRating = rating;
    }

    public String getRating() {
        return movieRating;
    }

    public void setMovieReleaseDate(String releaseDate) {
        movieReleaseDate = releaseDate;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    // To implement Parceable these following methods must be overrided
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movieOriginalTitle);
        dest.writeString(movieImagePath);
        dest.writeString(movieSynopsis);
        dest.writeString(movieRating);
        dest.writeString(movieReleaseDate);
    }

    private Movie(Parcel in) {
        movieOriginalTitle = in.readString();
        movieImagePath = in.readString();
        movieSynopsis = in.readString();
        movieRating = in.readString();
        movieReleaseDate = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        public Movie[] newArray(int i) {
            return new Movie[i];
        }
    };
}
