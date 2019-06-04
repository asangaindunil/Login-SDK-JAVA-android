package com.example.asangaindunil.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class dbConnect extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "login.db";
//    public static final String TABLE_NAME = "loginTable";
//    public static final String COL_1 = "UserName";
//    public static final String COL_2 = "Password";

    List<String> users;




    public dbConnect(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL = "CREATE TABLE " + user.acc.TABLE_NAME +" ("
        +user.acc._ID+" INTEGER PRIMARY KEY, "+
                user.acc.COLOMN_NAME_USERNAME +" TEXT, "+
                user.acc.COLOMN_NAME_PASSWORD +" TEXT )";
    sqLiteDatabase.execSQL(SQL);


    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public long add(String username, String password)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(user.acc.COLOMN_NAME_USERNAME,username);
        values.put(user.acc.COLOMN_NAME_PASSWORD,password);

        long newRowId = sqLiteDatabase.insert(user.acc.TABLE_NAME,null, values);
        return newRowId;
    }

    public List<String> read(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        //StringBuffer buffer= new StringBuffer();

        String[] projection ={
                user.acc._ID,
                user.acc.COLOMN_NAME_USERNAME,
                user.acc.COLOMN_NAME_PASSWORD
        };

        String sort = user.acc.COLOMN_NAME_USERNAME+" DESC";
        Cursor cursor = sqLiteDatabase.query(
                user.acc.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sort,
                null

        );
        //List userName = new ArrayList<>();
        //List gpassword = new ArrayList<>();
        users = new ArrayList();
        while (cursor.moveToNext()){

            String username = cursor.getString(cursor.getColumnIndex(user.acc.COLOMN_NAME_USERNAME));
            String password = cursor.getString(cursor.getColumnIndex(user.acc.COLOMN_NAME_PASSWORD));
            //userName.add(username);
            //gpassword.add(password);
            String var = ( username + "   " + password +" \n");
            users.add(var);
        }
        return users;
    }

    public void delete(String username){
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        String selection = user.acc.COLOMN_NAME_USERNAME + "LIKE ?";
        String[] selectionArgs = { username };
        sqLiteDatabase.delete(user.acc.TABLE_NAME,selection,selectionArgs);

    }

    public void updateInfo(String username, String password){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(user.acc.COLOMN_NAME_PASSWORD,password);

        String selection = user.acc.COLOMN_NAME_USERNAME + "Like ?";
        String[] selectionArgs = {username};

        int count = sqLiteDatabase.update(
                user.acc.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );
    }


}
