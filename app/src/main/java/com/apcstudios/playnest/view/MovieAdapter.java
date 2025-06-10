package com.apcstudios.playnest.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.apcstudios.playnest.R;
import com.apcstudios.playnest.databinding.MovieItemBinding;
import com.apcstudios.playnest.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{ // This adapter file is the bridge between Data Source and UI Components

    private Context context;
    private ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieItemBinding binding = DataBindingUtil
                .inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.movie_item,
                        parent,
                        false
                );
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieArrayList.get(position);
        holder.movieItemBinding.setMovie(movie);
        holder.movieItemBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }


    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        private final MovieItemBinding movieItemBinding;

        public MovieViewHolder(MovieItemBinding movieItemBinding) {
            super(movieItemBinding.getRoot());
            this.movieItemBinding = movieItemBinding;

            movieItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();

                }
            });
        }
    }

}
