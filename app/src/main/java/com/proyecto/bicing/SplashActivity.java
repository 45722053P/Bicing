package com.proyecto.bicing;

/**
 * Created by alex on 14/02/2017.
 */

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    // Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Obligamos a que la pantalla esté en portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_splash);

        // Referenciamos nuestra imagen
        ImageView icon = (ImageView) findViewById(R.id.logoSplash);

        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);// Creamos la nueva animación haciendo referencia al xml
        icon.startAnimation(myFadeInAnimation); // Y se la damos a nuestra imagen

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Start the next activity
                Intent mainIntent = new Intent().setClass(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Intent mainIntent = new Intent().setClass(SplashActivity.this, MainActivity.class);
        startActivity(mainIntent);
        return super.onTouchEvent(event);


    }

}

