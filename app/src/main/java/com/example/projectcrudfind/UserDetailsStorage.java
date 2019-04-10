package com.example.projectcrudfind;

import android.content.Context;
import android.content.SharedPreferences;

public class UserDetailsStorage {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDB;

    public UserDetailsStorage(Context context){

        userLocalDB = context.getSharedPreferences(SP_NAME, 0);


    }

    public void storeUserData(User user){

        SharedPreferences.Editor spEditor = userLocalDB.edit();
        spEditor.putString("name", user.name);
        spEditor.putString("username", user.username);
        spEditor.putString("password", user.password);
        spEditor.commit();
    }
    public User getLoggedInUser(){
        String name = userLocalDB.getString("name", "");
        String username = userLocalDB.getString("username", "");
        String password = userLocalDB.getString("password", "");

        User storedUser = new User(name, username, password);

        return storedUser;

    }

    public void setLoggedInUser(boolean loggedIn){

        SharedPreferences.Editor spEditor = userLocalDB.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){

        if (userLocalDB.getBoolean("loggedIn", false) == true){

            return true;
        }
        else {

            return false;
        }
    }

    public void clearUserData(){

        SharedPreferences.Editor spEditor = userLocalDB.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
