package com.assignmentapps.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Android Dev on 7/27/2017.
 */

public class Preference {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;
    private static final String PREFERENCE_NAME = "login_info";
    private static final String EMAIL = "EMAIL";
    private static final String PASSWORD = "PASSWORD";


//    public Preference(Context context) {
//        this.context = context;
//        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//
//    }

    public void saveUserData(String email,String password) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(EMAIL, email);
        editor.putString(PASSWORD, password);
        editor.commit();

    }

    public void getUserData() {
//        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//        String email = sharedPreferences.getString(EMAIL, "Default name");
//        String password=sharedPreferences.getString(PASSWORD,"Default password");
//

    }
}



