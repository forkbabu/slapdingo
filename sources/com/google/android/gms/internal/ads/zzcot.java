package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcot implements zzduh {
    private final zzasm zzfsc;

    zzcot(zzasm zzasm) {
        this.zzfsc = zzasm;
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf zzf(Object obj) {
        zzasm zzasm = this.zzfsc;
        zzasm.zzdsu = new String(zzdtp.toByteArray((InputStream) obj), zzdrv.UTF_8);
        return zzdux.zzaf(zzasm);
    }
}
