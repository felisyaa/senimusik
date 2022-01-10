package com.example.senimusik.view.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.senimusik.model.materi1;
import com.example.senimusik.repositories.materi1Repositories;

public class materi1ViewViewModel extends AndroidViewModel {

    private materi1Repositories repositories;

    public materi1ViewViewModel(@NonNull Application application) {
        super(application);
        repositories = materi1Repositories.getInstance();
    }

    //materi1 id
    private MutableLiveData<materi1> resultGetMateri1ById = new MutableLiveData<>();
    public void getMateri1ById(String Materi1Id){
        resultGetMateri1ById = repositories.getMateri1(Materi1Id);
    }

    public LiveData<materi1> getResultgetMateri1ById(){return resultGetMateri1ById; }
    //end

    //
}
