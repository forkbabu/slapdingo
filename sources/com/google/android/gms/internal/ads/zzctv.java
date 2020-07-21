package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzctv implements zzduu<T> {
    private final /* synthetic */ String zzgmk;
    private final /* synthetic */ long zzgml;
    private final /* synthetic */ zzdkk zzgmm;
    private final /* synthetic */ zzdkm zzgmn;
    private final /* synthetic */ zzcts zzgmo;

    zzctv(zzcts zzcts, String str, long j, zzdkk zzdkk, zzdkm zzdkm) {
        this.zzgmo = zzcts;
        this.zzgmk = str;
        this.zzgml = j;
        this.zzgmm = zzdkk;
        this.zzgmn = zzdkm;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void onSuccess(T t) {
        long elapsedRealtime = this.zzgmo.zzbqd.elapsedRealtime();
        this.zzgmo.zza(this.zzgmk, 0, elapsedRealtime - this.zzgml, this.zzgmm.zzhag);
        if (this.zzgmo.zzgmj) {
            this.zzgmo.zzgmh.zza(this.zzgmn, this.zzgmm, 0, null, elapsedRealtime - this.zzgml);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        long elapsedRealtime = this.zzgmo.zzbqd.elapsedRealtime();
        int i = 6;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (th instanceof zzcti) {
            i = 3;
        } else if (th instanceof CancellationException) {
            i = 4;
        } else if (th instanceof zzdlg) {
            i = 5;
        } else if ((th instanceof zzcmi) && ((zzcmi) th).zzaow().errorCode == 3) {
            i = 1;
        }
        this.zzgmo.zza(this.zzgmk, i, elapsedRealtime - this.zzgml, this.zzgmm.zzhag);
        if (this.zzgmo.zzgmj) {
            this.zzgmo.zzgmh.zza(this.zzgmn, this.zzgmm, i, th instanceof zzcqx ? (zzcqx) th : null, elapsedRealtime - this.zzgml);
        }
    }
}
