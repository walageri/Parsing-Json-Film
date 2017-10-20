package com.ahmadbaihaqi.jsonfilm.retrofit;

import com.ahmadbaihaqi.jsonfilm.respons.DataFromJSON;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ahmad-baihaqi on 17/09/2017.
 */

public interface APIService {
    // https://api.themoviedb.org/3/search/         digunakan pada kelas InstalasiLibrary sebagai baseURL
    // movie?                                       digunakan pada interface APIService sebagai endURL
    // api_key=873338d9ddae0acc77e331b844c7309f     digunakan pada interface APIService sebagai query 1
    // &language=en-US                              digunakan pada interface APIService sebagai query 2
    // &query=Minions                               digunakan pada interface APIService sebagai query 3
    @GET("movie")
    Call<DataFromJSON> panggilDataFromJSON(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("query") String query
    );

}
