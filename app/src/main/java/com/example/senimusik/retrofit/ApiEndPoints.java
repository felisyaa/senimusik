package com.example.senimusik.retrofit;

import com.example.senimusik.model.materi1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiEndPoints {



    @GET("materi1")
    Call<materi1> getMateri1();

}
