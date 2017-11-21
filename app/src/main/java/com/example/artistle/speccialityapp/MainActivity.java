package com.example.artistle.speccialityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.artistle.speccialityapp.Adapter.RecyclerAdapter;
import com.example.artistle.speccialityapp.Model.SpecialityModel;
import com.example.artistle.speccialityapp.Retrofit.SpecialityApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "http://gitlab.65apps.com/65gb/static/raw/master/";
    private CompositeDisposable compositeDisposable;
    private ArrayList<SpecialityModel.Response> listModels;
    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listModels = new ArrayList<SpecialityModel.Response>();
        compositeDisposable = new CompositeDisposable();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        //adapter = new RecyclerAdapter();

        LoadJson();
    }

    private void LoadJson() {
        SpecialityApi userRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(SpecialityApi.class);

        compositeDisposable.add(userRetrofit.getApi()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));
    }


    private void handleError(Throwable throwable) {
        Toast.makeText(this, "error 404" + throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        Log.d("TAG", throwable.getLocalizedMessage());
    }


    private void handleResponse(List<SpecialityModel.Response> userList) {
        listModels = new ArrayList<SpecialityModel.Response>();
        adapter = new RecyclerAdapter(listModels);
        recyclerView.setAdapter(adapter);
        listModels.addAll(userList);

        Collections.sort(listModels, new Comparator<SpecialityModel.Response>() {
            @Override
            public int compare(SpecialityModel.Response o1, SpecialityModel.Response o2) {
                return o1.fName.compareTo(o2.lName);
            }
        });
    }
}
