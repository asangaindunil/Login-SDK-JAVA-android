package com.example.asangaindunil.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    dbConnect dbConnects;
    Button add;
    Button update;
    Button view;
    Button delete;
    EditText username ,password;
    String users, pass;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.add);
        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText3);
        dbConnects = new dbConnect(this);



     //   Toast.makeText(this, dbConnects.users.get(0), Toast.LENGTH_SHORT).show();


    }
    public void adduser(View view){
        users = username.getText().toString();
        pass = password.getText().toString();

        if (users.isEmpty() || pass.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please Insert Values", Toast.LENGTH_SHORT).show();
        }
        else
        {
            long val = dbConnects.add(users,pass);

            if(val>0){
                Toast.makeText(getApplicationContext(),"Insert Success",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"Insert Unsuccess Full", Toast.LENGTH_SHORT).show();
            }

        }



    }
    public void viewUser(View view){
     //   Toast.makeText(this, usersList.get(0), Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(this,ViewUsers.class);
        startActivity(intent);
    }

}
