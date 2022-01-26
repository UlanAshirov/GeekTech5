package com.joma.geektech5;

import android.app.Application;

import com.joma.geektech5.data.data.remote.FilmApi;
import com.joma.geektech5.data.data.remote.FilmApiClient;
import com.joma.geektech5.data.data.remote.RetrofitClient;

public class App extends Application {
    private RetrofitClient retrofitClient;
    public static FilmApi api;
    public static FilmApiClient apiClient;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.providerApi();
        apiClient = new FilmApiClient();
    }
}

