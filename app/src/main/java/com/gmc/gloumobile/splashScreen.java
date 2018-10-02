package com.gmc.gloumobile;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();

                Intent m_Intent = new Intent(splashScreen.this, MainActivity.class);
                startActivity(m_Intent);
            }
        }, 5000);
    }
}
