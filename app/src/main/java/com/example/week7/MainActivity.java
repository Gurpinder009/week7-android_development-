package com.example.week7;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    MediaPlayer drum;
    MediaPlayer guitar;

//
//    Button btn1;
//    Button btn2;
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        btn1 = findViewById(R.id.drum);
//        btn2 = findViewById(R.id.guitar);

        drum =MediaPlayer.create(this,R.raw.drums);
        guitar =MediaPlayer.create(this,R.raw.ukulele);




    }





    public void playDrums(View view){
        if(guitar.isPlaying()){
            guitar.stop();
        }
        if(!drum.isPlaying()){
            drum .start();
        }else{
            drum.pause();
        }


    }




    public void playGuitar(View view){
        if(drum.isPlaying()){
            drum.stop();
        }
        if(!guitar.isPlaying() ){
            guitar .start();
        }else{
            guitar.pause();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        drum.release();
        guitar.release();
    }
}