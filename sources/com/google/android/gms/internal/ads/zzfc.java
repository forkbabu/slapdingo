package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzfc implements Runnable {
    private final /* synthetic */ zzex zzzj;
    private final /* synthetic */ int zzzm;
    private final /* synthetic */ boolean zzzn;

    zzfc(zzex zzex, int i, boolean z) {
        this.zzzj = zzex;
        this.zzzm = i;
        this.zzzn = z;
    }

    public final void run() {
        zzcf.zza zzb = this.zzzj.zzb(this.zzzm, this.zzzn);
        zzcf.zza unused = this.zzzj.zzza = zzb;
        if (zzex.zza(this.zzzm, zzb)) {
            this.zzzj.zza(this.zzzm + 1, this.zzzn);
        }
    }
}
