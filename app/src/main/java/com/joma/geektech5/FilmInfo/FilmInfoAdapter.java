package com.joma.geektech5.FilmInfo;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.joma.geektech5.data.data.models.Film;
import com.joma.geektech5.databinding.ItemFilmInfoBinding;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import retrofit2.http.Url;

public class FilmInfoAdapter extends RecyclerView.Adapter<FilmInfoAdapter.FilmInfoViewHolder> {
    private ItemFilmInfoBinding binding;
    private List<Film> film = new ArrayList<>();

    public void setFilm(Film film) {
        this.film.add(film);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemFilmInfoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmInfoViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull FilmInfoAdapter.FilmInfoViewHolder holder, int position) {
        holder.onBind(film.get(position));
    }

    @Override
    public int getItemCount() {
        return film.size();
    }

    public class FilmInfoViewHolder extends RecyclerView.ViewHolder {
        public FilmInfoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void onBind(Film film) {
            binding.filmItemTitle.setText(film.getTitle());
            binding.filmItemOriginalTitle.setText(film.getOriginalTitle());
            binding.filmItemTitleRomanised.setText(film.getOriginalTitleRomanised());
            Glide.with(binding.imgFilm).load(film.getImage()).into(binding.imgFilm);
            binding.filmItemDirectory.setText(film.getDirector());
            binding.filmItemProducer.setText(film.getProducer());
            binding.filmItemReleaseDate.setText(film.getReleaseDate());
        }
    }
}
