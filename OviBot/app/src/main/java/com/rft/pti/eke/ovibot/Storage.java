package com.rft.pti.eke.ovibot;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by demeteradi on 2016. 11. 28..
 */

public class Storage {
    private static final String PREF_NAME = "com.rft.pti.eke.ovibot.prefs";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_NAME = "name";
    private static final String KEY_TOKEN = "token";

    private SharedPreferences preferences;

    public Storage(Context ctx){
        preferences = ctx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public String getEmail(){
        return preferences.getString(KEY_EMAIL, null);
    }

    public void setEmail(String email){
        preferences.edit().putString(KEY_EMAIL, email).commit();
    }

    public String getName(){
        return preferences.getString(KEY_NAME, null);
    }

    public void setName(String name){
        preferences.edit().putString(KEY_NAME, name).commit();
    }

    public String getToken(){
        return preferences.getString(KEY_TOKEN, null);
    }

    public void setToken(String token){
        preferences.edit().putString(KEY_TOKEN, token).commit();
    }

    public void clear(){
        preferences.edit().clear().commit();
    }
}
