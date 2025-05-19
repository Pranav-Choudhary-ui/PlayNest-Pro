package com.apcstudios.playnest.serviceapi;

import com.apcstudios.playnest.model.APIResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("movie/popular")
    Call<APIResult> getPopularMovies(@Query("api_key") String apiKey);
}
