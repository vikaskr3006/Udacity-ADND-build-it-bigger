package com.example.udacity.vikaskumar.jokesandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Funny Joke");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView tvJoke = (TextView) findViewById(R.id.tv_joke);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_JOKE)) {
            String joke = intent.getStringExtra(EXTRA_JOKE);
            tvJoke.setText(joke);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
