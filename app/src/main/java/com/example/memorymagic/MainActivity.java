package com.example.memorymagic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.game_title)).setTypeface(Typeface.createFromAsset(findViewById(R.id.game_title).getContext().getAssets(),"Fonts/digital.ttf"));
        ((Button)findViewById(R.id.game_start)).setTypeface(Typeface.createFromAsset(findViewById(R.id.game_start).getContext().getAssets(),"Fonts/Elgethy Est Square.ttf"));
        ((Button)findViewById(R.id.game_quit)).setTypeface(Typeface.createFromAsset(findViewById(R.id.game_start).getContext().getAssets(),"Fonts/Elgethy Est Square.ttf"));
    }

    public void startClick(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, GameActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void quitClick(View view) {
        MainActivity.this.finish();
    }
}
