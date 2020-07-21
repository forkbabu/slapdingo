package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzazq {
    private static zzae zzebh;
    private static final Object zzebi = new Object();
    @Deprecated
    private static final zzazu<Void> zzebj = new zzazp();

    public zzazq(Context context) {
        zzbl(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    public static zzdvf<zzy> zzeu(String str) {
        zzbbn zzbbn = new zzbbn();
        zzebh.zze(new zzazw(str, zzbbn));
        return zzbbn;
    }

    public final zzdvf<String> zza(int i, String str, Map<String, String> map, byte[] bArr) {
        zzazt zzazt = new zzazt(null);
        zzazs zzazs = new zzazs(this, str, zzazt);
        zzbau zzbau = new zzbau(null);
        zzazr zzazr = new zzazr(this, i, str, zzazt, zzazs, bArr, map, zzbau);
        if (zzbau.isEnabled()) {
            try {
                zzbau.zza(str, "GET", zzazr.getHeaders(), zzazr.zzg());
            } catch (zzl e) {
                zzaxv.zzfd(e.getMessage());
            }
        }
        zzebh.zze(zzazr);
        return zzazt;
    }

    public final zzdvf<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzae zzbl(android.content.Context r3) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzazq.zzebi
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzae r1 = com.google.android.gms.internal.ads.zzazq.zzebh     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzaav.initialize(r3)     // Catch:{ all -> 0x0036 }
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzaav.zzcso     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.ads.zzaar r2 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ all -> 0x0036 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x0036 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0036 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0024
            r1 = 1
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            if (r1 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.internal.ads.zzazf.zzbk(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x0030
        L_0x002c:
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.internal.ads.zzbk.zza(r3)     // Catch:{ all -> 0x0036 }
        L_0x0030:
            com.google.android.gms.internal.ads.zzazq.zzebh = r3     // Catch:{ all -> 0x0036 }
        L_0x0032:
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.internal.ads.zzazq.zzebh     // Catch:{ all -> 0x0036 }
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            return r3
        L_0x0036:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazq.zzbl(android.content.Context):com.google.android.gms.internal.ads.zzae");
    }
}
