package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcsl implements zzcam {
    private final zzbbd zzbov;
    private final zzdkk zzfxi;
    private final zzdvf<zzbzl> zzglp;
    private final zzbfn zzglq;
    private final Context zzvr;

    private zzcsl(Context context, zzbbd zzbbd, zzdvf<zzbzl> zzdvf, zzdkk zzdkk, zzbfn zzbfn) {
        this.zzvr = context;
        this.zzbov = zzbbd;
        this.zzglp = zzdvf;
        this.zzfxi = zzdkk;
        this.zzglq = zzbfn;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zza(boolean z, Context context) {
        this.zzglq.zzax(true);
        zzq.zzkw();
        zzg zzg = new zzg(false, zzaye.zzbd(this.zzvr), false, 0.0f, -1, z, this.zzfxi.zzfmx, false);
        zzq.zzkv();
        zzn.zza(context, new AdOverlayInfoParcel((zzuu) null, ((zzbzl) zzdux.zzb(this.zzglp)).zzafy(), (zzt) null, this.zzglq, this.zzfxi.zzgzz, this.zzbov, this.zzfxi.zzdrk, zzg, this.zzfxi.zzgzr.zzdof, this.zzfxi.zzgzr.zzdoh), true);
    }
}
