package com.example.novostok;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.view.View;
import android.media.MediaPlayer;

public class MainActivity extends Activity implements View.OnClickListener {
    Button startButton;
    MediaPlayer mp;
    AutoCompleteTextView trackTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(this);

        String[] trackList = getResources().getStringArray(R.array.traklist);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.dropdown_item, trackList);
        trackTitle = findViewById(R.id.trackTitle);
        trackTitle.setAdapter(adapter);
    }
    @Override
    public void onClick(View v) {
        String currentTrack = trackTitle.getEditableText().toString();
        switch(currentTrack) {
            case ("Биография"):
                mp = MediaPlayer.create(this, R.raw.bio);
                break;
            case ("Вишенка"):
                mp = MediaPlayer.create(this, R.raw.cherry);
                break;
            case ("Чебурашка"):
                mp = MediaPlayer.create(this, R.raw.cheburashka);
                break;
        }
        mp.start();
    }
}