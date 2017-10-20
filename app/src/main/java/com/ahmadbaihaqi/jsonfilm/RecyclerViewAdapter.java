package com.ahmadbaihaqi.jsonfilm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadbaihaqi.jsonfilm.respons.DataFromJSON;
import com.ahmadbaihaqi.jsonfilm.respons.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by ahmad-baihaqi on 17/09/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.MyHolder>{
    Context context ;
    List<Result> hasilResult ;

    public RecyclerViewAdapter(Context context, List<Result> hasilResult) {
        this.context = context;
        this.hasilResult = hasilResult;
    }



    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        MyHolder holder = new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.juduFilm.setText(hasilResult.get(position).getTitle().toString());
        holder.genreFilm.setText(hasilResult.get(position).getPopularity().toString());
        Picasso.with(context).load("http://image.tmdb.org/t/p/w185/"+hasilResult.get(position).getPosterPath())
                .placeholder(R.drawable.defaultgambar)
                .error(R.drawable.defaultgambar)
                .into(holder.imageView);

        holder.cardViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailFilm.class);
                intent.putExtra("posterpath","http://image.tmdb.org/t/p/w780/"+hasilResult.get(position).getPosterPath().toString());
                intent.putExtra("title",hasilResult.get(position).getTitle().toString());
                intent.putExtra("popularity",hasilResult.get(position).getPopularity().toString());
                intent.putExtra("overview",hasilResult.get(position).getOverview().toString());
                intent.putExtra("originaltitle",hasilResult.get(position).getOriginalTitle().toString());
                intent.putExtra("originallanguage",hasilResult.get(position).getOriginalLanguage().toString());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return hasilResult.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView juduFilm;
        TextView genreFilm;
        CardView cardViewList;
        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image_view_movie);
            juduFilm = (TextView) itemView.findViewById(R.id.textview_judul_film);
            genreFilm = (TextView) itemView.findViewById(R.id.textview_genre_film);
            cardViewList = (CardView) itemView.findViewById(R.id.card_view_list);




        }
    }
}
