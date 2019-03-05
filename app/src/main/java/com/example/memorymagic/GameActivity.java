package com.example.memorymagic;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private static final int N = 12;
    static Random rand = new Random();
    int animal[] = {R.drawable.bear,
            R.drawable.cat,
            R.drawable.elephant,
            R.drawable.giraffe,
            R.drawable.hypo,
            R.drawable.kangaroo,
            R.drawable.leo,
            R.drawable.lion,
            R.drawable.pig,
            R.drawable.rhino,
            R.drawable.tiger,
            R.drawable.wolf};

    int curr = 0;
    int flag = 0;
    int score = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        curr=0;
        flag=0;
        score=0;
    }

    public void turnClick(View view) {
        flag++;
        if(flag<=11){
            int ran = animal[rand.nextInt(N)];
            changeImg((ImageView)findViewById(view.getId()), ran);
            score++;
            //Log.d("GameActivity", Integer.toString(curr)+"///"+Integer.toString(ran));
            if(ran==curr){
                score+=3;
                Toast.makeText(this, "combo!   score + 3", Toast.LENGTH_SHORT).show();
            }
            curr=ran;
            ((TextView) findViewById(R.id.textView)).setText(Integer.toString(score));
            view.setClickable(false);
        }
        else if(flag == 12){
            int ran = animal[rand.nextInt(N)];
            changeImg((ImageView)findViewById(view.getId()), ran);
            score++;
            //Log.d("GameActivity", Integer.toString(curr)+"///"+Integer.toString(ran));
            if(ran==curr){
                score+=3;
                Toast.makeText(this, "combo!   score + 3", Toast.LENGTH_SHORT).show();
            }
            curr=ran;
            ((TextView) findViewById(R.id.textView)).setText(Integer.toString(score));
            view.setClickable(false);
            AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
            builder.setTitle("Congratulations!");
            builder.setMessage("Your score is "+Integer.toString(score));
            builder.setCancelable(false);
            builder.setPositiveButton("Return to main interface", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            SystemClock.sleep(500);
            builder.show();
        }

        //Toast.makeText(this, "you click on"+view.getId(), Toast.LENGTH_SHORT).show();
    }

    public void changeImg(ImageView img, int pic) {
        img.setImageDrawable(getResources().getDrawable(pic));
    }
}
