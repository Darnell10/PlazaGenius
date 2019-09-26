package com.example.plazagenius.networking;

public class ApiUtil {

    private static final String BASE_URL = "https://reqres.in/api/";

    public static PlazaService getApiService() {

        return RetrofitClient.getRetrofit(BASE_URL).create(PlazaService.class);
    }
}
