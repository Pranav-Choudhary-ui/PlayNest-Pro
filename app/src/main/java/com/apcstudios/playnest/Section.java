package com.apcstudios.playnest;

import com.apcstudios.playnest.model.Movie;

import java.util.List;

public class Section {
    String title;
    List<Movie> movies;

    public Section(String title, List<Movie> movies) {
        this.title = title;
        this.movies = movies;
    }

    public String getTitle() {
        return title;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}

