package com.apcstudios.playnest.model;

import android.graphics.Movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import kotlin.jvm.internal.SerializedIr;

public class APIResult{
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResuts;
    @SerializedName("results")
    @Expose
    private List<Movie> results = null;

}
