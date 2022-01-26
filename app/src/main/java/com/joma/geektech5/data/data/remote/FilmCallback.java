package com.joma.geektech5.data.data.remote;

import com.joma.geektech5.data.data.models.Film;

import java.util.List;

public interface FilmCallback {
    void success(List<Film> films);
    void failure(String msg);
}
