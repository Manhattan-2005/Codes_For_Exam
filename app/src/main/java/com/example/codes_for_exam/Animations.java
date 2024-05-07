package com.example.codes_for_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Animations extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);

        imageView = findViewById(R.id.imageView);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.zoomIn) {

                    Animation anim = AnimationUtils.loadAnimation(Animations.this, R.anim.zoom_in);
                    imageView.startAnimation(anim);

                } else if(v.getId() == R.id.zoomOut) {

                    Animation anim = AnimationUtils.loadAnimation(Animations.this, R.anim.zoom_out);
                    imageView.startAnimation(anim);

                } else if(v.getId() == R.id.fadeIn) {

                    Animation anim = AnimationUtils.loadAnimation(Animations.this, R.anim.fade_in);
                    imageView.startAnimation(anim);

                } else if(v.getId() == R.id.fadeOut) {

                    Animation anim = AnimationUtils.loadAnimation(Animations.this, R.anim.fade_out);
                    imageView.startAnimation(anim);

                } else if(v.getId() == R.id.rotateClockwise) {

                    Animation anim = AnimationUtils.loadAnimation(Animations.this, R.anim.rotate_clockwise);
                    imageView.startAnimation(anim);

                } else if(v.getId() == R.id.rotateAntiClockwise) {

                    Animation anim = AnimationUtils.loadAnimation(Animations.this, R.anim.rotate_anticlockwise);
                    imageView.startAnimation(anim);

                } else if(v.getId() == R.id.stopAnimation) {

                    imageView.clearAnimation();

                }
            }
        };

        ((Button) findViewById(R.id.zoomIn)).setOnClickListener(listener);
        ((Button) findViewById(R.id.zoomOut)).setOnClickListener(listener);
        ((Button) findViewById(R.id.fadeIn)).setOnClickListener(listener);
        ((Button) findViewById(R.id.fadeOut)).setOnClickListener(listener);
        ((Button) findViewById(R.id.rotateClockwise)).setOnClickListener(listener);
        ((Button) findViewById(R.id.rotateAntiClockwise)).setOnClickListener(listener);
        ((Button) findViewById(R.id.stopAnimation)).setOnClickListener(listener);

    }
}