package com.example.asangaindunil.login;

import android.content.Context;

public class Adapter {
    dbConnect dbConnects;
    public Adapter(Context context){
        dbConnects = new dbConnect(context);
    }
}
