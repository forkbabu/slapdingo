package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcmg extends zzaih {
    private final /* synthetic */ zzclx zzgfv;
    private final /* synthetic */ Object zzgfw;
    private final /* synthetic */ String zzgfx;
    private final /* synthetic */ long zzgfy;
    private final /* synthetic */ zzbbn zzgfz;

    zzcmg(zzclx zzclx, Object obj, String str, long j, zzbbn zzbbn) {
        this.zzgfv = zzclx;
        this.zzgfw = obj;
        this.zzgfx = str;
        this.zzgfy = j;
        this.zzgfz = zzbbn;
    }

    @Override // com.google.android.gms.internal.ads.zzaie
    public final void onInitializationSucceeded() {
        synchronized (this.zzgfw) {
            this.zzgfv.zza(this.zzgfx, true, "", (int) (zzq.zzld().elapsedRealtime() - this.zzgfy));
            this.zzgfv.zzgfn.zzgj(this.zzgfx);
            this.zzgfz.set(true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaie
    public final void onInitializationFailed(String str) {
        synchronized (this.zzgfw) {
            this.zzgfv.zza(this.zzgfx, false, str, (int) (zzq.zzld().elapsedRealtime() - this.zzgfy));
            this.zzgfv.zzgfn.zzr(this.zzgfx, "error");
            this.zzgfz.set(false);
        }
    }
}
