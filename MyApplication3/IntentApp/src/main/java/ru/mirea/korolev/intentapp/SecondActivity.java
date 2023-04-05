package ru.mirea.korolev.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("message").toString();
        TextView textView = new TextView(this);
        textView.setText(name);
        setContentView(textView);
    }
}