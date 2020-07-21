package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzekl extends zzeks {
    private String name;

    public zzekl(String str) {
        this.name = str;
    }

    @Override // com.google.android.gms.internal.ads.zzeks
    public final void zzii(String str) {
        String str2 = this.name;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
