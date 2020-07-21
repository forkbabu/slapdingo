package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzabh extends zzabc {
    zzabh() {
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final String zzg(String str, String str2) {
        String zzcv = zzcv(str);
        String zzcv2 = zzcv(str2);
        if (TextUtils.isEmpty(zzcv)) {
            return zzcv2;
        }
        if (TextUtils.isEmpty(zzcv2)) {
            return zzcv;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(zzcv).length() + 1 + String.valueOf(zzcv2).length());
        sb.append(zzcv);
        sb.append(",");
        sb.append(zzcv2);
        return sb.toString();
    }

    private static String zzcv(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i) {
            return null;
        }
        if (i == 0 && length == str.length()) {
            return str;
        }
        return str.substring(i, length);
    }
}
