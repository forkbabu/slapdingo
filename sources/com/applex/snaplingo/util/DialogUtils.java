package com.applex.snaplingo.util;

import android.app.Activity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.applex.snaplingo.R;

public class DialogUtils {
    private DialogUtils() {
    }

    private static class SingletonHolder {
        static final DialogUtils INSTANCE = new DialogUtils();

        private SingletonHolder() {
        }
    }

    public static DialogUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public MaterialDialog createAnimationDialog(Activity activity) {
        return new MaterialDialog.Builder(activity).customView(R.layout.lottie_anim_dialog, false).build();
    }

    public MaterialDialog createAnimationDialog2(Activity activity) {
        return new MaterialDialog.Builder(activity).customView(R.layout.lottie_anim_dialog2, false).build();
    }
}
