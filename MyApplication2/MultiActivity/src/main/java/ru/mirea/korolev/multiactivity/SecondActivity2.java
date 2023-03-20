package ru.mirea.korolev.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity2 extends AppCompatActivity {

    private TextView NewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        String text = (String) getIntent().getSerializableExtra("key");
        NewText = findViewById(R.id.textView);
        NewText.setText(text);
    }
}