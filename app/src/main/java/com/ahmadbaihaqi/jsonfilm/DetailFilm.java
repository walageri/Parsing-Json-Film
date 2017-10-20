package com.ahmadbaihaqi.jsonfilm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailFilm extends AppCompatActivity {
    ImageView imageViewPoster;
    TextView textViewPopularity;
    TextView textViewOriginalTitle;
    TextView textViewLanguage;
    TextView textViewTitle;
    TextView textViewOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);
        imageViewPoster = (ImageView)findViewById(R.id.image_view_poster);
        textViewPopularity = (TextView) findViewById(R.id.tv_popularity);
        textViewOriginalTitle = (TextView) findViewById(R.id.tv_original_title);
        textViewLanguage = (TextView) findViewById(R.id.tv_language);
        textViewTitle = (TextView) findViewById(R.id.tv_title);
        textViewOverview = (TextView) findViewById(R.id.tv_overview);


        Picasso.with(this).load(getIntent().getStringExtra("posterpath")).into(imageViewPoster);
        textViewPopularity.setText(getIntent().getStringExtra("popularity"));
        textViewOriginalTitle.setText(getIntent().getStringExtra("originaltitle"));
        textViewLanguage.setText(getIntent().getStringExtra("originallanguage"));
        textViewTitle.setText(getIntent().getStringExtra("title"));
        textViewOverview.setText(getIntent().getStringExtra("overview"));


    }
}
