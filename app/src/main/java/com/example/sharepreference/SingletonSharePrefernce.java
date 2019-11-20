package com.example.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;

public class SingletonSharePrefernce {

    private static SingletonSharePrefernce singletonSharePrefernce;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private SingletonSharePrefernce(Context context) {
        sharedPreferences = context.getSharedPreferences("InfoApp",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public static SingletonSharePrefernce getInstance(Context context){
        if (singletonSharePrefernce == null){
            singletonSharePrefernce = new SingletonSharePrefernce(context);
        }
        return singletonSharePrefernce;
    }
    public void setValue(String key , String kytu){
        editor.putString(key , kytu);
        editor.commit();
    }
    public String getValue(String key ){
        return sharedPreferences.getString(key , "");
    }

}
