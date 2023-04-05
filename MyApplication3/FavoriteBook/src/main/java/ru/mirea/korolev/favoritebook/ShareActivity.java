package ru.mirea.korolev.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    private TextView BookText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        Bundle extras = getIntent().getExtras();
        BookText = findViewById(R.id.editTextTextPersonName);
        if (extras != null) {
            TextView ageView = findViewById(R.id.textViewBook);
            String university = extras.getString(MainActivity.KEY);
            ageView.setText(String.format("Мой любимая книга: %s", university));
        }
    }
    public void ClickSharer1(View view) {
        String text = "Ваша любимая книга: " + BookText.getText();
        Intent data = new Intent();
        data.putExtra(MainActivity.USER_MESSAGE, text);
        setResult(Activity.RESULT_OK, data);
        finish();
    }

}