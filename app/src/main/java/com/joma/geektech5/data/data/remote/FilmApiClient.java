package com.joma.geektech5.data.data.remote;

import com.joma.geektech5.App;
import com.joma.geektech5.data.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmApiClient {
    public void getFilms(FilmCallback callback) {
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.success(response.body());
                } else {
                    callback.failure(response.message());
                }
            }
            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                callback.failure(t.getLocalizedMessage());
            }
        });
    }
}
