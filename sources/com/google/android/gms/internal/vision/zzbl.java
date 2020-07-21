package com.google.android.gms.internal.vision;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzbl extends zzbj<Long> {
    zzbl(zzbp zzbp, String str, Long l, boolean z) {
        super(zzbp, str, l, z, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final Long zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zzad = super.zzad();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzad).length() + 25 + String.valueOf(valueOf).length());
        sb.append("Invalid long value for ");
        sb.append(zzad);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
