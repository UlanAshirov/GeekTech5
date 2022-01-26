package com.joma.geektech5.FilmInfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joma.geektech5.App;
import com.joma.geektech5.data.data.models.Film;
import com.joma.geektech5.databinding.FragmentFilmInfoBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmInfoFragment extends Fragment {
    private FragmentFilmInfoBinding binding;
    private FilmInfoAdapter adapter;
    private Film film ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmInfoBinding.inflate(inflater);
        adapter = new FilmInfoAdapter();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            film = (Film) getArguments().getSerializable("model");
            filmInfo();
        }
    }

    private void filmInfo() {
       binding.rvFilmInfo.setAdapter(adapter);
        App.api.getFilmAbout(film.getId()).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setFilm(film);
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });
    }

    }