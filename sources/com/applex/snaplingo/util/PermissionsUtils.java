package com.applex.snaplingo.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class PermissionsUtils {

    private static class SingletonHolder {
        static final PermissionsUtils INSTANCE = new PermissionsUtils();

        private SingletonHolder() {
        }
    }

    public static PermissionsUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public boolean checkRuntimePermissions(Object obj, String[] strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(retrieveContext(obj), str) != 0) {
                return false;
            }
        }
        return true;
    }

    public void requestRuntimePermissions(Object obj, String[] strArr, int i) {
        if (obj instanceof Activity) {
            ActivityCompat.requestPermissions((AppCompatActivity) obj, strArr, i);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).requestPermissions(strArr, i);
        }
    }

    private Context retrieveContext(Object obj) {
        if (obj instanceof AppCompatActivity) {
            return ((AppCompatActivity) obj).getApplicationContext();
        }
        return ((Fragment) obj).requireActivity();
    }
}
