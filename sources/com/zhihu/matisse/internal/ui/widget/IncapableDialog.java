package com.zhihu.matisse.internal.ui.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.zhihu.matisse.R;

public class IncapableDialog extends DialogFragment {
    public static final String EXTRA_MESSAGE = "extra_message";
    public static final String EXTRA_TITLE = "extra_title";

    public static IncapableDialog newInstance(String str, String str2) {
        IncapableDialog incapableDialog = new IncapableDialog();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TITLE, str);
        bundle.putString(EXTRA_MESSAGE, str2);
        incapableDialog.setArguments(bundle);
        return incapableDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string = getArguments().getString(EXTRA_TITLE);
        String string2 = getArguments().getString(EXTRA_MESSAGE);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (!TextUtils.isEmpty(string)) {
            builder.setTitle(string);
        }
        if (!TextUtils.isEmpty(string2)) {
            builder.setMessage(string2);
        }
        builder.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
            /* class com.zhihu.matisse.internal.ui.widget.IncapableDialog.AnonymousClass1 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        return builder.create();
    }
}
