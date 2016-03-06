package com.example.android.popmovies;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieInfo mb1 = getIntent().getParcelableExtra("movie");
        Log.e("TITLE1", mb1.title);
        setContentView(R.layout.activity_detail);
        TextView tv = (TextView)findViewById(R.id.title);
        tv.setText(mb1.title);

        ImageView iv = (ImageView)findViewById(R.id.poster);
        String baseImageUrl = "http://image.tmdb.org/t/p/w185/";
        baseImageUrl += mb1.poster;
        Picasso.with(getApplicationContext()).load(baseImageUrl).into(iv);

        tv = (TextView)findViewById(R.id.plot);
        tv.setText(mb1.overview);

        String userLabel = "USER RATING: ";
        tv = (TextView)findViewById(R.id.user_rating);
        tv.setText(userLabel + mb1.vote_average);

        String releaseLabel = "RELEASE DATE: ";
        tv = (TextView)findViewById(R.id.release_date);
        tv.setText(releaseLabel + mb1.release_date);

    }

}
