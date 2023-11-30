package net.penguincoders.doit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000; // Time in milliseconds
    private final Handler splashHandler = new Handler();
    private final Intent mainIntent;
    private final Runnable startActivityRunnable = new Runnable() {
        @Override
        public void run() {
            startMainActivity();
        }
    };

    public SplashActivity() {
        mainIntent = new Intent(SplashActivity.this, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        hideActionBar();
        scheduleSplashScreen();
    }

    private void hideActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    private void scheduleSplashScreen() {
        splashHandler.postDelayed(startActivityRunnable, SPLASH_DELAY);
    }

    private void startMainActivity() {
        startActivity(mainIntent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashHandler.removeCallbacks(startActivityRunnable);
    }
}
