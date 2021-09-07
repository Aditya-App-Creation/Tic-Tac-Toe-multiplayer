package com.fire.firebase;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DualmodeActivity extends AppCompatActivity {
    int gameState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dualmode);

        gameState = 1; // 1-can Play  2-GameOver  3-Draw


    }


    public void started(View view) {
        ImageView selectedImage = (ImageView) view;

        int selectedBlock = 0;
        switch ((selectedImage.getId())) {
            case R.id.iv_11:
                selectedBlock = 1;
                break;
            case R.id.iv_12:
                selectedBlock = 2;
                break;
            case R.id.iv_13:
                selectedBlock = 3;
                break;

            case R.id.iv_21:
                selectedBlock = 4;
                break;
            case R.id.iv_22:
                selectedBlock = 5;
                break;
            case R.id.iv_23:
                selectedBlock = 6;
                break;

            case R.id.iv_31:
                selectedBlock = 7;
                break;
            case R.id.iv_32:
                selectedBlock = 8;
                break;
            case R.id.iv_33:
                selectedBlock = 9;
                break;
        }

        PlayGame(selectedBlock, selectedImage);
    }


    int activePlayer = 1;
    ArrayList<Integer> Player1 = new ArrayList<Integer>();
    ArrayList<Integer> Player2 = new ArrayList<Integer>();

    void PlayGame(int selectedBlock, ImageView selectedImage) {
        if (gameState == 1) {
            if (activePlayer == 1) {
                selectedImage.setImageResource(R.drawable.img_3);
                Player1.add(selectedBlock);
                activePlayer = 2;
            } else if (activePlayer == 2) {
                selectedImage.setImageResource(R.drawable.img_4);
                Player2.add(selectedBlock);
                activePlayer = 1;
            }

            selectedImage.setEnabled(false);
            CheckWinner();
        }
    }

    void CheckWinner(){
        int winner = 0;

        /********* for Player 1 *********/
        if(Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){ winner = 1; }
        if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){ winner = 1; }
        if(Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){ winner = 1; }

        if(Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){ winner = 1; }
        if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){ winner = 1; }
        if(Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){ winner = 1; }

        if(Player1.contains(1) && Player1.contains(5) && Player1.contains(9)){ winner = 1; }
        if(Player1.contains(3) && Player1.contains(5) && Player1.contains(7)){ winner = 1; }


        /********* for Player 2 *********/
        if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){ winner = 2; }
        if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){ winner = 2; }
        if(Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){ winner = 2; }

        if(Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){ winner = 2; }
        if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){ winner = 2; }
        if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){ winner = 2; }

        if(Player2.contains(1) && Player2.contains(5) && Player2.contains(9)){ winner = 2; }
        if(Player2.contains(3) && Player2.contains(5) && Player2.contains(7)){ winner = 2; }



        if(winner != 0 && gameState == 1){
            if(winner == 1){
                ShowAlert("Player 1 is winner");
            }else if(winner == 2){
                ShowAlert("Player 2 is winner");
            }
            gameState = 2;
        }
    }

    void ShowAlert(String Title){
        AlertDialog.Builder b = new AlertDialog.Builder(this, R.style.TransparentDialog);
        b.setTitle(Title)
                .setMessage("Start a new game?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ResetGame();
                    }
                })
                .setNegativeButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), MenuActivity2.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setIcon(R.drawable.img_5)
                .show();
    }


    void ResetGame(){
        gameState = 1;
        activePlayer = 1;
        Player1 = new ArrayList<Integer>();
        Player2 = new ArrayList<Integer>();

        ImageView iv;
        iv = (ImageView) findViewById(R.id.iv_11); iv.setImageResource(0); iv.setEnabled(true);
        iv = (ImageView) findViewById(R.id.iv_12); iv.setImageResource(0); iv.setEnabled(true);
        iv = (ImageView) findViewById(R.id.iv_13); iv.setImageResource(0); iv.setEnabled(true);

        iv = (ImageView) findViewById(R.id.iv_21); iv.setImageResource(0); iv.setEnabled(true);
        iv = (ImageView) findViewById(R.id.iv_22); iv.setImageResource(0); iv.setEnabled(true);
        iv = (ImageView) findViewById(R.id.iv_23); iv.setImageResource(0); iv.setEnabled(true);

        iv = (ImageView) findViewById(R.id.iv_31); iv.setImageResource(0); iv.setEnabled(true);
        iv = (ImageView) findViewById(R.id.iv_32); iv.setImageResource(0); iv.setEnabled(true);
        iv = (ImageView) findViewById(R.id.iv_33); iv.setImageResource(0); iv.setEnabled(true);

    }
}