package com.example.asangaindunil.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewUsers extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    List<String> usersList;
    dbConnect dbConnects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);
        listView = findViewById(R.id.li);
        dbConnects = new dbConnect(this);
        usersList = dbConnects.read();

        adapter = new ArrayAdapter<>(this,R.layout.textview,usersList);


        listView.setAdapter(adapter);

    }
}
