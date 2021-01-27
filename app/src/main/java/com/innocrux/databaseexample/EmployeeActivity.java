package com.innocrux.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {

    SQLiteDatabase mDatabase;
    List<Employee> employeeList;
    ListView listView;
    Employee_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        mDatabase= openOrCreateDatabase(MainActivity.DATABASE_NAME,MODE_PRIVATE,null);

        listView =(ListView) findViewById(R.id.list_view);

        employeeList=new ArrayList<>();
        loadEmployeeFromDatabase();
    }

    private void loadEmployeeFromDatabase(){
        String loadSql="SELECT * FROM employees";

        Cursor cursor = mDatabase.rawQuery(loadSql,null);
        if(cursor.isFirst()){
       do {
               employeeList.add(new Employee(
                       cursor.getInt(0),
                       cursor.getString(1),
                       cursor.getString(2),
                       cursor.getString(3),
                       cursor.getDouble(4)
               ) );
       }while (cursor.moveToNext());

       Employee_Adapter adapter= new Employee_Adapter(this,R.layout.list_layout_employees,employeeList);
         listView.setAdapter(adapter);

        }


    }
}