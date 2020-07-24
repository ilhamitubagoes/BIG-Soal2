package com.ilhambagoest.soal2.data;

import android.content.SharedPreferences;

public class SessionManager {

    private static final String IS_LOGIN        = "is_login";
    private static final String USER_ID         = "user_id";
    private static final String USER_NAME       = "user_name";
    private static final String USER_POSITION   = "user_position";
    private static final String USER_BIRTH_DATE = "user_birth_date";
    private static final String USER_URL_PHOTO  = "user_url_photo";
    private static final String NUMBER_MEDIC    = "number_medic";
    private static final String ADDRESS         = "address";
    private static final String EMAIL           = "email";

    private final SharedPreferences preferences;

    public SessionManager(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public Boolean isLogin() {
        return preferences.getBoolean(IS_LOGIN, false);
    }

    public void setIsLogin() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_LOGIN, true);
        editor.apply();
    }

    public Integer getUserId() {
        return preferences.getInt(USER_ID, 0);
    }

    public void setUserId(Integer userID) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(USER_ID, userID);
        editor.apply();
    }

    public String getUserName() {
        return preferences.getString(USER_NAME, "");
    }

    public void setUserName(String userName) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_NAME, userName);
        editor.apply();
    }

    public String getUserPosition() {
        return preferences.getString(USER_POSITION, "");
    }

    public void setUserPosition(String position) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_POSITION, position);
        editor.apply();
    }

    public String getUserBirthDate() {
        return preferences.getString(USER_BIRTH_DATE, "");
    }

    public void setUserBirthDate(String birthDate) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_BIRTH_DATE, birthDate);
        editor.apply();
    }

    public String getUserUrlPhoto() {
        return preferences.getString(USER_URL_PHOTO, "");
    }

    public void setUserUrlPhoto(String urlPhoto) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_URL_PHOTO, urlPhoto);
        editor.apply();
    }

    public String getNumberMedic() {
        return preferences.getString(NUMBER_MEDIC, "");
    }

    public void setNumberMedic(String numberMedic) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(NUMBER_MEDIC, numberMedic);
        editor.apply();
    }

    public String getAddress() {
        return preferences.getString(ADDRESS, "");
    }

    public void setAddress(String address) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(ADDRESS, address);
        editor.apply();
    }

    public String getEmail() {
        return preferences.getString(EMAIL, "");
    }

    public void setEmail(String email) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(EMAIL, email);
        editor.apply();
    }

    public void clearData() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(IS_LOGIN);
        editor.remove(USER_ID);
        editor.remove(USER_NAME);
        editor.remove(USER_POSITION);
        editor.remove(USER_BIRTH_DATE);
        editor.remove(USER_URL_PHOTO);
        editor.remove(NUMBER_MEDIC);
        editor.remove(ADDRESS);
        editor.remove(EMAIL);
        editor.apply();
    }
}
