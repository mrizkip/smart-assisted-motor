package com.hanyasoftware.android.smartassistedmotor.repository.datasource.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.hanyasoftware.android.smartassistedmotor.SAMApplication;
import com.hanyasoftware.android.smartassistedmotor.repository.entity.local.User;

import javax.inject.Inject;

public class SharedPrefsRepository {

    public static final String APP_SHARED_PREFS = "APP_SHARED_PREFS";

    private static final String USER_ID = "USER_ID";

    private static final String SWITCH_STATE = "SWITCH_STATE";
    private static final String JARAK_BEFORE_TARGET = "JARAK_BEFORE_TARGET";
    private static final String RINGTONE_URI = "RINGTONE_URI";
    private static final String RINGTONE_NAME = "RINGTONE_NAME";

    private static final String UNAVAILABLE_VALUE = "UNAVAILABLE";
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

    public void saveUserToPrefs(User user) {
        editor.putString(USER_ID, user.getUsr_id());
        editor.apply();
    }

    public User getUserFromPrefs() {
        String userId = sharedPrefs.getString(USER_ID, UNAVAILABLE_VALUE);
        if (USER_ID.equalsIgnoreCase(UNAVAILABLE_VALUE)) {
            return null;
        }
        User user = new User();
        user.setUsr_id(userId);
        return user;
    }

    public void unsetUserFromPrefs() {
        editor.remove(USER_ID);
        editor.apply();
    }

    public void saveSwitchState(boolean state) {
        editor.putBoolean(SWITCH_STATE, state);
        editor.apply();
    }

    public boolean getSwitchState() {
        return sharedPrefs.getBoolean(SWITCH_STATE, false);
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
