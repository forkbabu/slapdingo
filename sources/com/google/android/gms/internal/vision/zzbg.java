package com.google.android.gms.internal.vision;

import android.net.Uri;
import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzbg {
    private static final ArrayMap<String, Uri> zzgc = new ArrayMap<>();

    public static synchronized Uri getContentProviderUri(String str) {
        Uri uri;
        synchronized (zzbg.class) {
            uri = zzgc.get(str);
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode(str));
                uri = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                zzgc.put(str, uri);
            }
        }
        return uri;
    }
}
