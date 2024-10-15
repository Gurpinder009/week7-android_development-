package com.example.week7;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    MediaPlayer  drums;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        drums = new MediaPlayer();
        drums = MediaPlayer.create(this, R.raw.drums);
        drums.start();


        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
                drums.stop();

            }
        };

        Timer timer = new Timer();
        timer.schedule(task,5000);









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}