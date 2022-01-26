package com.joma.geektech5.ui.films.films_detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.joma.geektech5.App;
import com.joma.geektech5.R;
import com.joma.geektech5.data.data.models.Film;
import com.joma.geektech5.data.data.remote.FilmCallback;
import com.joma.geektech5.databinding.FragmentFilmsBinding;

import java.util.ArrayList;
import java.util.List;

public class FilmsFragment extends Fragment implements FilmsAdapter.ClickFilm {
    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;
    private NavController controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater);
        adapter = new FilmsAdapter(this);
        controller = Navigation.findNavController(container);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.rvFilms.setAdapter(adapter);
        App.apiClient.getFilms(new FilmCallback() {
            @Override
            public void success(List<Film> films) {
                adapter.setFilms(films);
            }

            @Override
            public void failure(String msg) {
                Snackbar.make(binding.getRoot(), msg, BaseTransientBottomBar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void click(int position, Film film) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", position);
        bundle.putSerializable("model",film);
        controller.navigate(R.id.filmInfo, bundle);
    }
}