package com.example.calmshperef1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class read_articles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.read_articles);

            ImageButton backButton = findViewById(R.id.backbutton);
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle the button click
                    Intent intent = new Intent(read_articles.this, home.class);
                    startActivity(intent);
                }
            });
//        WebView webView = findViewById(R.id.webview1);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("https://www.nccih.nih.gov/health/meditation-and/-mindfulness-what-you-need-to-know");



        }

    }

