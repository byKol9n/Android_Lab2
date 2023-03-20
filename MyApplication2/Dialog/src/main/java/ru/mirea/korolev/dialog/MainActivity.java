package ru.mirea.korolev.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private TextView tvDateandTime;
    private Button btPickDate;

    private Button pickTimeBtn;

    private Button ProgressBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDateandTime = findViewById(R.id.tvDate);
        btPickDate = findViewById(R.id.btPickDate);
        pickTimeBtn = findViewById(R.id.idBtnPickTime);
        ProgressBtn = findViewById(R.id.ProgressBtn);
        btPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ru.mirea.korolev.dialog.MyDateDialogFragment mDatePickerDialogFragment;
                mDatePickerDialogFragment = new ru.mirea.korolev.dialog.MyDateDialogFragment();
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");
                Snackbar.make(v, "Вы выбрали ДАТУ", Snackbar.LENGTH_LONG)
                        .show();
            }
        });
        pickTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                tvDateandTime.setText(hourOfDay + ":" + minute);
                            }
                        }, hour, minute, false);
                timePickerDialog.show();
                Snackbar.make(v, "Вы выбрали ВРЕМЯ", Snackbar.LENGTH_LONG)
                        .show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
        tvDateandTime.setText(selectedDate);
    }

    public void onClickShowDialog(View view) {
        ADialog dialogFragment = new ADialog();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }

    public void onClickProgressDialog(View view) {
        MyProgressDialogFragment Progress = new MyProgressDialogFragment();
        Progress.showDialog(MainActivity.this, "Загрузка");
        Snackbar.make(view, "Вы выбрали ПРОГРЕСС", Snackbar.LENGTH_LONG)
                .show();
    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }

    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }

    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }
}

