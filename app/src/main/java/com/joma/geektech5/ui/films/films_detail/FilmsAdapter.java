package com.joma.geektech5.ui.films.films_detail;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joma.geektech5.data.data.models.Film;
import com.joma.geektech5.databinding.ItemFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class

FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {
    private ItemFilmBinding binding;
    private List<Film> films = new ArrayList<>();
    private ClickFilm click;

    public FilmsAdapter(ClickFilm click) {
        this.click = click;
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmsViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsAdapter.FilmsViewHolder holder, int position) {
        holder.onBind(films.get(position));
        holder.itemView.setOnClickListener(view -> {
            Log.e("ABOBA", films + "");
            click.click(holder.getAdapterPosition(), films.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    public class FilmsViewHolder extends RecyclerView.ViewHolder {
        public FilmsViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(Film film) {
            binding.tvTitle.setText(film.getTitle());
            binding.tvDescription.setText(film.getDescription());

        }
    }
    interface ClickFilm {
        void click(int position , Film film);
    }
}
