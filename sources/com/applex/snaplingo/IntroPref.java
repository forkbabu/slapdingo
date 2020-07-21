package com.applex.snaplingo;

import android.content.Context;
import android.content.SharedPreferences;

public class IntroPref {
    private static final String IS_FIRST_TIME_LAUNCH = "firstTime";
    private static final String PREF_NAME = "com.applex.snaplingo.users";
    private int PRIVATE_MODE = 0;
    private Context context;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    public IntroPref(Context context2) {
        this.context = context2;
        if (context2 != null) {
            this.preferences = context2.getSharedPreferences(PREF_NAME, 0);
        }
        this.editor = this.preferences.edit();
    }

    /* access modifiers changed from: package-private */
    public void setIsFirstTimeLaunch(boolean z) {
        this.editor.putBoolean(IS_FIRST_TIME_LAUNCH, z);
        this.editor.commit();
    }

    /* access modifiers changed from: package-private */
    public boolean isFirstTimeLaunch() {
        return this.preferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
