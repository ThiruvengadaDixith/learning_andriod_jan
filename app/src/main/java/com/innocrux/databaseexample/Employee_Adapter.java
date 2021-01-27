package com.innocrux.databaseexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Employee_Adapter extends ArrayAdapter {

    Context context;
    int resource;
    List<Employee> employeeList;
    ListAdapter listAdapter;
    SQLiteDatabase mDatabase;

    public Employee_Adapter(@NonNull Context context, int resource, @NonNull List<Employee> employeeList) {
        super(context, resource, employeeList);
        this.context=context;
        this.resource=resource;
        this.employeeList=employeeList;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater;
        inflater = LayoutInflater.from(context);

        View view =inflater.inflate(resource, null);
        TextView textViewname = view.findViewById(R.id.textViewName);
        TextView textviewDept = view.findViewById(R.id.textViewDepartment);
        TextView textViewSalary = view.findViewById(R.id.textViewSalary);
        TextView textViewJoinDate = view.findViewById(R.id.textViewJoiningDate);

        Employee employee = employeeList.get(position);
         textViewname.setText(employee.getName());
         textviewDept.setText(employee.getDept());
         textViewSalary.setText(String.valueOf(employee.getSalary()));
         textViewJoinDate.setText(employee.getJoiningdate());
         return view;
    }
}


