package com.app.skurtle.ui.activity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.app.skurtle.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by brando on 8/17/16.
 */
public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.splashlogo)
    ImageView splashLogo;

    Runnable launchLogin;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(splashLogo,
                PropertyValuesHolder.ofFloat("scaleX", 1.2f),
                PropertyValuesHolder.ofFloat("scaleY", 1.2f));
        scaleDown.setDuration(310);

        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);

        scaleDown.start();
        launchLogin = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        handler.postDelayed(launchLogin, 1500);
    }
}
