    package com.innocrux.databaseexample;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.database.sqlite.SQLiteDatabase;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.EditText;
    import android.widget.Spinner;
    import android.widget.TextView;
    import android.widget.Toast;


    import java.text.SimpleDateFormat;
    import java.util.Calendar;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        public static final String DATABASE_NAME="employee_db";
        SQLiteDatabase mDatabase;

        TextView editTextName,editTextSalary;
        Spinner spinnerDept;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mDatabase= openOrCreateDatabase("DATABASE_NAME",MODE_PRIVATE,null);

                 createTable();
            //intialising all widgets

            editTextName = (EditText) findViewById(R.id.edittext_employeename);
            editTextSalary= (EditText) findViewById((R.id.edittext_employeesalary));
            spinnerDept= (Spinner) findViewById(R.id.spinner);

            findViewById(R.id.button_addemployee).setOnClickListener(this);
            findViewById(R.id.textView_viewemployee).setOnClickListener(this);
           
        }

              // method to create table with create sql query
        public void createTable(){

            String createtablesql=" \n" +
                    "CREATE TABLE IF NOT EXISTS employees (\n" +
                    "    id INTEGER NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n" +
                    "    name varchar(200) NOT NULL,\n" +
                    "    department varchar(200) NOT NULL,\n" +
                    "    joiningdate datetime NOT NULL,\n" +
                    "    salary double NOT NULL\n" +
                    ");";
            mDatabase.execSQL(createtablesql);
        }

            private void addEmployee() {
              String name=editTextName.getText().toString().trim();
              String salary=editTextSalary.getText().toString().trim();
              String dept=spinnerDept.getSelectedItem().toString();

               if(name.isEmpty()){
                   editTextName.setError("Name Cant be Empty");
                   //editTextName.requestFocus();
                   return;
               }

               if (salary.isEmpty()){
                   editTextSalary.setError("Salary cant be Empty");
                   //editTextSalary.requestFocus();
                   return;
               }

                Calendar cal= Calendar.getInstance();
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                String joiningdate = simpleDateFormat.format(cal.getTime());

              String insert_sql="INSERT INTO employees(name, department, joiningdate, salary)"+"VALUES(?,?,?,?)";

               mDatabase.execSQL(insert_sql,new String[]{name,dept,joiningdate,salary});
                Toast.makeText(this,"Employee Added",Toast.LENGTH_LONG).show();
                }

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.button_addemployee:
                    addEmployee();
                    break;
                case R.id.textView_viewemployee:
                    startActivity(new Intent(this,EmployeeActivity.class));
                    break;
            }

        }


    }