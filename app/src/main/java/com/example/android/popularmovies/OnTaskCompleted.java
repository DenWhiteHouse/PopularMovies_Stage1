package com.example.android.popularmovies;

/**
 * Created by casab on 24/02/2018.
 */

// Way to callback from AsyncTask answered on StackOverFlow by Dmitry Zaytsev Android Developer

interface OnTaskCompleted {
    void onUtilsAsyncTaskCompleted(Movie[] movies);
}
