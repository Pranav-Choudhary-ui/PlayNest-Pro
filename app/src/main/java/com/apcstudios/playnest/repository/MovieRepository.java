package com.apcstudios.playnest.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.apcstudios.playnest.R;
import com.apcstudios.playnest.model.APIResult;
import com.apcstudios.playnest.model.Movie;
import com.apcstudios.playnest.serviceapi.MovieApiService;
import com.apcstudios.playnest.serviceapi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository { // This file is used to define all the database operations at a single place

    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        MovieApiService movieApiService = RetrofitInstance.getService();

        Call<APIResult> call = movieApiService.
                getPopularMovies(application.getApplicationContext().getString(R.string.api_key));

        // perform network request in the background thread and
        // handle the response on the main (UI) thread
        call.enqueue(new Callback<APIResult>() {
            @Override
            public void onResponse(Call<APIResult> call, Response<APIResult> response) {
                // Success
                APIResult apiResult = response.body();

                if (apiResult != null && apiResult.getResults() != null) {
                    movies = (ArrayList<Movie>) apiResult.getResults();
                    mutableLiveData.setValue(movies);
                }

            }

            @Override
            public void onFailure(Call<APIResult> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
