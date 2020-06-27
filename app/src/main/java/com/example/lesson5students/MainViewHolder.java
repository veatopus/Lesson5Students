package com.example.lesson5students;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class MainViewHolder extends RecyclerView.ViewHolder {

    TextView nameTV;
    TextView surnameTV;
    TextView groupNumberTV;
    TextView yearTV;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTV = itemView.findViewById(R.id.tv_vh_name);
        surnameTV = itemView.findViewById(R.id.tv_vh_surname);
        groupNumberTV = itemView.findViewById(R.id.tv_vh_group_number);
        yearTV = itemView.findViewById(R.id.tv_vh_year);

    }

    public void onBind(Students students) {
        nameTV.setText(students.name);
        surnameTV.setText(students.surname);
        groupNumberTV.setText(students.groupNumber);
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        yearTV.setText(format.format(students.year));
    }
}