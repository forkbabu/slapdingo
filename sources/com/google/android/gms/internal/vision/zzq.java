package com.google.android.gms.internal.vision;

import android.content.Context;
import android.util.Log;
import com.itextpdf.text.html.HtmlTags;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzq {
    public static boolean zza(Context context, String str, String str2) {
        String zzk = zzda.zzk(str2);
        if (HtmlTags.FACE.equals(str) || "ica".equals(str) || "ocr".equals(str) || "barcode".equals(str)) {
            int lastIndexOf = zzk.lastIndexOf(".so");
            if (lastIndexOf == zzk.length() - 3) {
                zzk = zzk.substring(0, lastIndexOf);
            }
            if (zzk.indexOf("lib") == 0) {
                zzk = zzk.substring(3);
            }
            boolean zza = zzr.zza(str, zzk);
            if (!zza) {
                Log.d("NativeLibraryLoader", String.format("%s engine not loaded with %s.", str, zzk));
            }
            return zza;
        }
        Log.e("NativeLibraryLoader", String.format("Unrecognized engine: %s", str));
        return false;
    }
}
