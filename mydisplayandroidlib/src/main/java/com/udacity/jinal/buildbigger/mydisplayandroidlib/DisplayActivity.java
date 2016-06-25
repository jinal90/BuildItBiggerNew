package com.udacity.jinal.buildbigger.mydisplayandroidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private TextView tvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvJoke = (TextView) findViewById(R.id.tvJoke);

        if(getIntent() != null && getIntent().hasExtra("jokeToDisplay")){
            String joke = getIntent().getStringExtra("jokeToDisplay");
            if(!TextUtils.isEmpty(joke))
            {
                tvJoke.setText("Joke of the day: "+joke);
            }else{
                tvJoke.setText("Error: Joke empty.");
            }
        }else{
            tvJoke.setText("Error: Intent Empty.");
        }
    }

    public void showJoke(String joke){

    }
}
