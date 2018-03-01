package com.example.android.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by casab on 24/02/2018.
 */

public class MovieDetails extends AppCompatActivity {

    private int POSTERSIZE = 185;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviedetails);
        //Bonding class variables to views
        TextView OriginalTitleTV = (TextView) findViewById(R.id.originalTitle);
        ImageView ImageIV = (ImageView) findViewById(R.id.movieImage);
        TextView SynopsysTV = (TextView) findViewById(R.id.synopsis);
        TextView RatingTV = (TextView) findViewById(R.id.userRating);
        TextView ReleaseDateTV = (TextView) findViewById(R.id.releaseDate);

        //Some scholarship mate suggested me to user Parcelable, but as first project I preferred to
        // get more practise with simple intents

        Intent intent = getIntent();
        String movie_parcel = "movie_parcel";
        Movie movie = intent.getParcelableExtra(getResources().getString(R.string.intent_movie));

        // The movie object as Parceable from the intent contains the information to be used
        // to populate the UI of Details
        // Setting the Image using the URL of the image with Picasso as suggested on the Project guide

        Picasso.with(this)
                .load(movie.getImage())
                .resize(POSTERSIZE, POSTERSIZE)
                .into(ImageIV);

//TODO On project Stage 2 add some control as is not sure the array has always the information to populate this UI
        OriginalTitleTV.setText(movie.getOrginalTitle());
        SynopsysTV.setText(movie.getSynopsis());
        RatingTV.setText(movie.getRating());
        ReleaseDateTV.setText(movie.getMovieReleaseDate());
    }
}