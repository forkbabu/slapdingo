package com.google.android.gms.internal.vision;

import android.util.Base64;
import android.util.Log;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzbn extends zzbj<T> {
    private final /* synthetic */ zzbm zzgq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbn(zzbp zzbp, String str, Object obj, boolean z, zzbm zzbm) {
        super(zzbp, str, obj, z, null);
        this.zzgq = zzbm;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzbj
    public final T zza(Object obj) {
        if (obj instanceof String) {
            try {
                return this.zzgq.zzb(Base64.decode((String) obj, 3));
            } catch (IOException | IllegalArgumentException unused) {
            }
        }
        String zzad = super.zzad();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzad).length() + 27 + String.valueOf(valueOf).length());
        sb.append("Invalid byte[] value for ");
        sb.append(zzad);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
