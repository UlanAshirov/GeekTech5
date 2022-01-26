package com.joma.geektech5.data.data.remote;

import com.joma.geektech5.data.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmApi {
    @GET("/films")
    Call<List<Film>> getFilms();
    @GET("/films/{id}")
    Call<Film> getFilmAbout(@Path("id") String id);
}
