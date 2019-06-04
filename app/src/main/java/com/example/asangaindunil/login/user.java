package com.example.asangaindunil.login;

import android.provider.BaseColumns;

public final class user {
    private user() {}

    public static class acc implements BaseColumns{
    public static final String TABLE_NAME = "USERS";
    public static final String COLOMN_NAME_USERNAME = "USERNAME";
    public static final String COLOMN_NAME_PASSWORD = "PASSWORD";


    }


}
