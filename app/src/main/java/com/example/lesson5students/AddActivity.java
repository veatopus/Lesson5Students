package com.example.lesson5students;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class AddActivity extends AppCompatActivity {

    String name;
    String surname;
    String groupNumber;
    Date dateOfBirth;
    TextView dateTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        dateTV = findViewById(R.id.tv_add_year);
        EditText nameET = findViewById(R.id.et_add_name);
        EditText surnameET = findViewById(R.id.et_add_surname);
        EditText groupNumberET = findViewById(R.id.et_add_group_number);

        groupNumberET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                groupNumber = s.toString();
            }
        });

        surnameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                surname = s.toString();
            }
        });

        nameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                name = s.toString();
            }
        });

        Button chooseDateOfBirth = findViewById(R.id.btn_add_year);
        chooseDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        AddActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                dateTV.setText(dayOfMonth + "." + (month + 1) + "." + year);
                                AddActivity.this.dateOfBirth = new Date(year, month, dayOfMonth);
                            }
                        },
                        year, month, day
                );
                dialog.show();
            }
        });

        Button save = findViewById(R.id.btn_add_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Students students = new Students();
                students.name = name;
                students.surname = surname;
                students.groupNumber = groupNumber;
                students.year = dateOfBirth;

                Intent intent = new Intent();
                intent.putExtra("students", students);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}