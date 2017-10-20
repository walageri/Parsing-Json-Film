package com.ahmadbaihaqi.jsonfilm.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ahmad-baihaqi on 17/09/2017.
 */

public class InstalasiLibrary {

    public static Retrofit setRetrofit(){
        return new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static APIService getInstance (){
        return setRetrofit().create(APIService.class);
    }


}
