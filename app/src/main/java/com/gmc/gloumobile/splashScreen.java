package com.gmc.gloumobile;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity {

    private boolean backbtnpress;
    private Handler m_Handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        m_Handler = new Handler();

        m_Handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();

                if(!backbtnpress){
                    Intent m_Intent = new Intent(splashScreen.this, MainActivity.class);
                    startActivity(m_Intent);
                }
            }
        }, 5000);
    }
}
