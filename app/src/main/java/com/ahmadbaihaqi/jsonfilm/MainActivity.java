package com.ahmadbaihaqi.jsonfilm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ahmadbaihaqi.jsonfilm.respons.DataFromJSON;
import com.ahmadbaihaqi.jsonfilm.respons.Result;
import com.ahmadbaihaqi.jsonfilm.retrofit.APIService;
import com.ahmadbaihaqi.jsonfilm.retrofit.InstalasiLibrary;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.PeriodicTask;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Result> hasilResult;
    RecyclerView recyclerViewMain;
    RecyclerView.LayoutManager layoutManager;
    EditText editTextSearch;
    ImageButton imageButtonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewMain = (RecyclerView) findViewById(R.id.recycle_view_main);
        layoutManager = new LinearLayoutManager(this);
        editTextSearch = (EditText) findViewById(R.id.edit_text_search);
        imageButtonSearch = (ImageButton) findViewById(R.id.image_button_search);

        recyclerViewMain.setLayoutManager(layoutManager);
        getResult("fast furious");

        imageButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getResult(editTextSearch.getText().toString());
            }
        });




    }


    private void getResult(String query) {
        APIService apiService = InstalasiLibrary.getInstance();
        Call<DataFromJSON> call = apiService.panggilDataFromJSON("873338d9ddae0acc77e331b844c7309f", "en-US", "" + query);
        call.enqueue(new Callback<DataFromJSON>() {
            @Override
            public void onResponse(Call<DataFromJSON> call, Response<DataFromJSON> response) {
                if (response.isSuccessful()) {
                    try {
                        Log.d("DATA DITERIMA", response.body().getResults().get(0).getTitle());
                    } catch (IndexOutOfBoundsException a) {
                        Toast.makeText(MainActivity.this, "FILM TIDAK DITEMUKAN", Toast.LENGTH_LONG).show();
                    }


                    hasilResult = response.body().getResults();
                    tampilRecycler();


                }
            }

            @Override
            public void onFailure(Call<DataFromJSON> call, Throwable t) {
                Toast.makeText(MainActivity.this, "BUTUH KONEKSI INTERNET ", Toast.LENGTH_LONG).show();
            }
        });
    }

    void tampilRecycler() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, hasilResult);
        recyclerViewMain.setAdapter(adapter);
    }






}
