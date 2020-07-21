package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcmc implements Runnable {
    private final String zzems;
    private final zzclx zzgff;
    private final zzdlm zzgfs;
    private final zzaie zzgft;
    private final List zzgfu;

    zzcmc(zzclx zzclx, zzdlm zzdlm, zzaie zzaie, List list, String str) {
        this.zzgff = zzclx;
        this.zzgfs = zzdlm;
        this.zzgft = zzaie;
        this.zzgfu = list;
        this.zzems = str;
    }

    public final void run() {
        this.zzgff.zza(this.zzgfs, this.zzgft, this.zzgfu, this.zzems);
    }
}
