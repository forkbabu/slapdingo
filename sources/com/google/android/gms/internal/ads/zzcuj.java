package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzcuj extends zzcvl {
    private zzbyq zzgmv;

    public zzcuj(zzbsk zzbsk, zzbtc zzbtc, zzbtl zzbtl, zzbtv zzbtv, zzbss zzbss, zzbwj zzbwj, zzbyz zzbyz, zzbui zzbui, zzbyq zzbyq, zzbwg zzbwg) {
        super(zzbsk, zzbtc, zzbtl, zzbtv, zzbwj, zzbui, zzbyz, zzbwg, zzbss);
        this.zzgmv = zzbyq;
    }

    @Override // com.google.android.gms.internal.ads.zzcvl, com.google.android.gms.internal.ads.zzamx
    public final void zztt() {
        this.zzgmv.zzsq();
    }

    @Override // com.google.android.gms.internal.ads.zzcvl, com.google.android.gms.internal.ads.zzamx
    public final void zztu() throws RemoteException {
        this.zzgmv.zzsr();
    }

    @Override // com.google.android.gms.internal.ads.zzcvl, com.google.android.gms.internal.ads.zzamx
    public final void zza(zzaud zzaud) throws RemoteException {
        super.zza(zzaud);
        this.zzgmv.zza(new zzaub(zzaud.getType(), zzaud.getAmount()));
    }

    @Override // com.google.android.gms.internal.ads.zzcvl, com.google.android.gms.internal.ads.zzamx
    public final void zzb(zzaub zzaub) {
        super.zzb(zzaub);
        this.zzgmv.zza(zzaub);
    }

    @Override // com.google.android.gms.internal.ads.zzcvl, com.google.android.gms.internal.ads.zzamx
    public final void onVideoEnd() {
        this.zzgmv.zzsr();
    }
}
