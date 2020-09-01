package com.example.multiplefab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton add, call, shopping, share;
    Animation rotate, back, open, close;
    boolean isOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.fab_add);
        call = findViewById(R.id.fab_call);
        shopping = findViewById(R.id.fab_shop);
        share = findViewById(R.id.fab_share);

        //Animations----->
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        back = AnimationUtils.loadAnimation(this, R.anim.rotate_back);
        open = AnimationUtils.loadAnimation(this, R.anim.open);
        close = AnimationUtils.loadAnimation(this, R.anim.close);



        //FAB click listener------>
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
            }
        });
    }




    private void animateFab() {

        if (isOpen) {
            share.startAnimation(open);
            share.setVisibility(View.VISIBLE);
            share.setClickable(true);
            shopping.startAnimation(open);
            shopping.setVisibility(View.VISIBLE);
            shopping.setClickable(true);
            call.startAnimation(open);
            call.setVisibility(View.VISIBLE);
            call.setClickable(true);


            add.startAnimation(rotate);
            isOpen = false;
        } else {
            share.startAnimation(close);
            share.setVisibility(View.INVISIBLE);
            share.setClickable(false);
            shopping.startAnimation(close);
            shopping.setVisibility(View.INVISIBLE);
            shopping.setClickable(false);
            call.startAnimation(close);
            call.setVisibility(View.INVISIBLE);
            call.setClickable(false);


            add.startAnimation(back);
            isOpen = true;
        }
    }
}
