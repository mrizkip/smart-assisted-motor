package com.hanyasoftware.android.smartassistedmotor.repository.datasource.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.hanyasoftware.android.smartassistedmotor.SAMApplication;

import javax.inject.Inject;

public class SharedPrefsRepository {

    public static final String APP_SHARED_PREFS = "APP_SHARED_PREFS";

    private static final String USER_LOGGED_IN = "USER_LOGGED_IN";
    private static final String JARAK_BEFORE_TARGET = "JARAK_BEFORE_TARGET";
    private static final String RINGTONE_URI = "RINGTONE_URI";
    private static final String RINGTONE_NAME = "RINGTONE_NAME";

    private static final String UNAVAILABLE_VALUE = "Unavailable";
    private static final int DEFAULT_JARAK = 10;

    private final Context context;
    private final SharedPreferences sharedPrefs;
    private final SharedPreferences.Editor editor;

    @Inject
    public SharedPrefsRepository() {
        context = SAMApplication.getApplicationComponent().getApplicationContext();
        sharedPrefs = context.getSharedPreferences(APP_SHARED_PREFS, Context.MODE_PRIVATE);
        editor = sharedPrefs.edit();
    }

    public void saveUserToPrefs(String username) {
        editor.putString(USER_LOGGED_IN, username);
        editor.apply();
    }

    public String getUserFromPrefs() {
        String username = sharedPrefs.getString(USER_LOGGED_IN, UNAVAILABLE_VALUE);
        if (username.equalsIgnoreCase(UNAVAILABLE_VALUE)) {
            return null;
        }
        return username;
    }

    public void unsetUserFromPrefs() {
        editor.remove(USER_LOGGED_IN);
        editor.apply();
    }

    public void saveJarakToPrefs(int jarak) {
        editor.putInt(JARAK_BEFORE_TARGET, jarak);
        editor.apply();
    }

    public int getJarakFromPrefs() {
        return sharedPrefs.getInt(JARAK_BEFORE_TARGET, DEFAULT_JARAK);
    }

    public void saveRingtoneToPrefs(String uri, String name) {
        editor.putString(RINGTONE_URI, uri);
        editor.putString(RINGTONE_NAME, name);
        editor.apply();
    }

    public String getRingtoneUriFromPrefs() {
        String uri = sharedPrefs.getString(RINGTONE_URI, UNAVAILABLE_VALUE);
        if (uri.equalsIgnoreCase(UNAVAILABLE_VALUE)) {
            return null;
        }
        return uri;
    }

    public String getRingtoneNameFromPrefs() {
        String name = sharedPrefs.getString(RINGTONE_NAME, UNAVAILABLE_VALUE);
        if (name.equalsIgnoreCase(UNAVAILABLE_VALUE)) {
            return null;
        }
        return name;
    }

}
