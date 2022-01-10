package com.example.senimusik.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.senimusik.model.materi1;
import com.example.senimusik.retrofit.ApiService;
import com.example.senimusik.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class materi1Repositories {
    private static materi1Repositories materi1Repo;
    private RetrofitService apiService;
    private static final String TAG = "materi1Repositories";

    //kayaknya yang ini gausah de
//    private materi1Repositories(String token){
//        if (materi1Repositories == null){
//            materi1Repositories = new materi1Repositories(token);
//        }
//        return materi1Repositories;
//    }

    public static materi1Repositories getInstance(){
        if (materi1Repo == null){
            materi1Repo = new materi1Repositories();
        }
        return materi1Repo;
    }

    public MutableLiveData<materi1> getMateri1(String materi1Id){
        final MutableLiveData<materi1> listMateri1 = new MutableLiveData<>();
                ApiService.endPoints().getMateri1().enqueue(new Callback<materi1>() {
                    @Override
                    public void onResponse(Call<materi1> call, Response<materi1> response) {
                        Log.d(TAG, "onResponse: "+response.code());
                        if (response.isSuccessful()){
                            if (response.body() != null){
                                Log.d(TAG, "onResponse" +response.body().getMateri1s().size());
                                listMateri1.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<materi1> call, Throwable t) {

                        Log.e(TAG, "onFailure: " + t.getMessage() );
                    }
                });
        return listMateri1;
    }
}
