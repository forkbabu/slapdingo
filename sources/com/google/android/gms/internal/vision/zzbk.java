package com.google.android.gms.internal.vision;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzbk extends zzbj<Boolean> {
    zzbk(zzbp zzbp, String str, Boolean bool, boolean z) {
        super(zzbp, str, bool, z, null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzbj
    public final /* synthetic */ Boolean zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzaq.zzfc.matcher(str).matches()) {
                return true;
            }
            if (zzaq.zzfd.matcher(str).matches()) {
                return false;
            }
        }
        String zzad = super.zzad();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzad).length() + 28 + String.valueOf(valueOf).length());
        sb.append("Invalid boolean value for ");
        sb.append(zzad);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
