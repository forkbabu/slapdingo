package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpb;
import com.google.android.gms.internal.ads.zzbrv;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdht<R extends zzbrv<AdT>, AdT extends zzbpb> implements zzdnh<AdT> {
    private final zzdil<R, zzdmw<AdT>> zzgxr;

    public zzdht(zzdil<R, zzdmw<AdT>> zzdil) {
        this.zzgxr = zzdil;
    }

    @Override // com.google.android.gms.internal.ads.zzdnh
    public final void zzb(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzdnh
    public final zzdvf<zzdmw<AdT>> zza(zzdnk zzdnk) {
        zzdhw zzdhw = (zzdhw) zzdnk;
        return this.zzgxr.zza(zzdhw.zzgxv, zzdhw.zzgxu);
    }

    @Override // com.google.android.gms.internal.ads.zzdnh
    public final void zza(zzdmw<AdT> zzdmw) {
        zzdmw.zzhec = this.zzgxr.zzarv().zzaex();
    }
}
