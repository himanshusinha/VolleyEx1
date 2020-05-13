package com.freehindiofflineapps.recyclerviewvolley2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<Movie> movies;
    private RecyclerView recyclerView;

    public Adapter(Context context, List<Movie> movies) {
        this.layoutInflater = LayoutInflater.from(context);
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.title.setText(movie.getTitle());
        holder.rating.setText(String.valueOf(movie.getRating()));
        holder.releaseyear.setText(String.valueOf(movie.getYear()));
        Picasso.get().load(movie.getThumbnailUrl()).into(holder.image);

        String genreStr = "";
        for (String str : movie.getGenre()) {
            genreStr += str + ", ";
        }
        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                genreStr.length() - 2) : genreStr;
        holder.genre.setText(genreStr);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, rating, releaseyear, genre;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.songTitle);
            rating = (TextView) itemView.findViewById(R.id.songRating);
            releaseyear = (TextView) itemView.findViewById(R.id.songReleaseYear);
            image = (ImageView) itemView.findViewById(R.id.coverImage);
            genre = (TextView) itemView.findViewById(R.id.songGenre);

        }
    }
}
