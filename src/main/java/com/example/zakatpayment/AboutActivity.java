package com.example.zakatpayment;

import androidx.appcompat.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView

import android.os.Bundle;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setupHyperlink();
    }
    
    private void setupHyperlink(){
        TextView linkTextView = findViewById(R.id);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
