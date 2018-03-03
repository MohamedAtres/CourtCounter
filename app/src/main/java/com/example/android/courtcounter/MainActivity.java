package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //set an initial score variable for each player
    int progressA = 100 ;
    int progressB = 100 ;

    //make a global variables for progress bar as HP Bar
    ProgressBar playerBHp;
    ProgressBar playerAHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //get the views of progress bars from xml
        playerBHp = (ProgressBar) findViewById(R.id.progressBar2);
        playerAHp = (ProgressBar) findViewById(R.id.progressBar);


    }

    /**
     * make a combo hit for player B
     */
    public void addComboB(View view){

        //update progress of player B
        playerBHp.setProgress(progressB = progressB-6);

        //check state of each player and set the suitable image
        changeState(progressA , progressB);

    }

    /**
     * make a damage hit for player B.
     */
    public void addDamageB(View view){

        //update progress of player B
        playerBHp.setProgress(progressB = progressB-4);

        //check state of each player and set the suitable image
        changeState(progressA , progressB);
    }

    /**
     * make a normal hit for player B.
     */
    public void addKickB(View view){

        //update progress of player B
        playerBHp.setProgress(progressB = progressB-2);

        //check state of each player and set the suitable image
        changeState(progressA , progressB);
    }

    /**
     * make a combo hit for player A.
     */
    public void addComboA(View view){

        //update progress of player A
        playerAHp.setProgress(progressA=progressA-6);

        //check state of each player and set the suitable image
        changeState(progressA , progressB);

    }

    /**
     * make a damage hit for player A.
     */

    public void addDamageA(View view){

        //update progress of player A
        playerAHp.setProgress(progressA=progressA-4);

        //check state of each player and set the suitable image
        changeState(progressA , progressB);
    }

    /**
     * make a normal hit for player A.
     */
    public void addKickA(View view){

        //update progress of player A
        playerAHp.setProgress(progressA=progressA-2);

        //check state of each player and set the suitable image
        changeState(progressA , progressB);
    }

    /**
     * reset the score of team A and team B.
     */
    public void resetButton(View view){

        //reset progress for each player
        playerAHp.setProgress(100);
        playerBHp.setProgress(100);

        //reset counter for each player
        progressA = 100;
        progressB = 100;

        //reset normal states for each image
        changeState(progressA , progressB);


    }

    //this method to change image view depend on state of player A
    public void changeState(int stateA , int stateB){

        //check condition of state
        ImageView firstCharacter = (ImageView) findViewById(R.id.first_character);
        ImageView secondCharacter = (ImageView) findViewById(R.id.second_character);


        //get the buttons from xml to change its state duo to conditions
        Button addComboB = (Button) findViewById(R.id.addComboB);
        Button addDamageB = (Button) findViewById(R.id.addDamageB);
        Button addKickB = (Button) findViewById(R.id.addKickB);
        Button addComboA = (Button) findViewById(R.id.addComboA);
        Button addDamageA = (Button) findViewById(R.id.addDamageA);
        Button addKickA = (Button) findViewById(R.id.addKickA);

        //get the result text view to add a result to app
        TextView resultText = (TextView) findViewById(R.id.result_text);

        /**
         * check conditions of each player by using their score.
         * and set the suitable image for each view .
         * set the suitable result for each condition .
         */

        if(stateA <= 0 && stateB > 0){

                firstCharacter.setImageResource(R.drawable.naruto_lose);
                secondCharacter.setImageResource(R.drawable.sasuke_win);

                //disable buttons of player A
                addComboB.setEnabled(false);
                addDamageB.setEnabled(false);
                addKickB.setEnabled(false);

                resultText.setText("Sasuke Win");
        }
         else if(stateA > 0 && stateB <= 0){

            firstCharacter.setImageResource(R.drawable.naruto_win);
            secondCharacter.setImageResource(R.drawable.sasuke_lose);

            //disable buttons of player B
            addComboA.setEnabled(false);
            addDamageA.setEnabled(false);
            addKickA.setEnabled(false);

            resultText.setText("Naruto Win");

        }else{

            firstCharacter.setImageResource(R.drawable.naruto_ready);
            secondCharacter.setImageResource(R.drawable.sasuke_ready);

            //the normal state
            addComboB.setEnabled(true);
            addDamageB.setEnabled(true);
            addKickB.setEnabled(true);
            addComboA.setEnabled(true);
            addDamageA.setEnabled(true);
            addKickA.setEnabled(true);

            resultText.setText("");

        }


    }


}
