package com.example.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //1=red 0=yellow
    int flag=1;
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int winner;
    boolean gameF=false;
    boolean gameD=false;
    public void drop(View view){
        ImageView counter=(ImageView) view;

        int tCounter=Integer.parseInt(counter.getTag().toString());
        if(gameState[tCounter]==2 && gameF==false)
        {
            counter.setTranslationY(-1500);
        gameState[tCounter]=flag;
        if(flag==1) {
            counter.setImageResource(R.drawable.red);
            flag = 0;
        }
        else
        {
            counter.setImageResource(R.drawable.yellow);
            flag=1;
        }
        counter.animate().translationYBy(1500);
        for(int i=0;i<8;i++)
        {
            if(gameState[winningPositions[i][0]]!=2 && gameState[winningPositions[i][0]]==gameState[winningPositions[i][1]] && gameState[winningPositions[i][1]]==gameState[winningPositions[i][2]])
            {
               winner=gameState[winningPositions[i][0]];
               gameF=true;
               break;
            }
        }
        gameD=false;
        for(int i=0;i<8;i++)
        {
            if(gameState[i]==2)
            {
                gameD = true;
            }
        }
        if(gameD==false)
        {
            Button play = (Button) findViewById(R.id.play);
            play.setAlpha(1);
        }
        if(gameF==true ) {
            TextView last = (TextView) findViewById(R.id.last);
            if (winner == 1)
                last.setText("RED HAS WON!");
            else
                last.setText("YELLOW HAS WON!");
            Button play = (Button) findViewById(R.id.play);
            play.setAlpha(1);
            last.setAlpha(1);
        }
        }

    }
    public void reset(View view){

        recreate();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
