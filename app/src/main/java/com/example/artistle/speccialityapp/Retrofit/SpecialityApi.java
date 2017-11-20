package com.example.artistle.speccialityapp.Retrofit;

import com.example.artistle.speccialityapp.Model.SpecialityModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SpecialityApi {
    @GET("testTask.json")
    Observable<List<SpecialityModel>> getApi();
}
