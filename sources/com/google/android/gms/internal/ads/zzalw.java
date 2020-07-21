package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzalw {
    private zzakh zzdhr;
    private zzdvf<zzalf> zzdhs;

    zzalw(zzakh zzakh) {
        this.zzdhr = zzakh;
    }

    private final void zzth() {
        if (this.zzdhs == null) {
            zzbbn zzbbn = new zzbbn();
            this.zzdhs = zzbbn;
            this.zzdhr.zzb((zzeg) null).zza(new zzalz(zzbbn), new zzaly(zzbbn));
        }
    }

    public final <I, O> zzamd<I, O> zzb(String str, zzalk<I> zzalk, zzall<O> zzall) {
        zzth();
        return new zzamd<>(this.zzdhs, str, zzalk, zzall);
    }

    public final void zzc(String str, zzahc<? super zzalf> zzahc) {
        zzth();
        this.zzdhs = zzdux.zzb(this.zzdhs, new zzamb(str, zzahc), zzbbf.zzedm);
    }

    public final void zzd(String str, zzahc<? super zzalf> zzahc) {
        this.zzdhs = zzdux.zzb(this.zzdhs, new zzama(str, zzahc), zzbbf.zzedm);
    }
}
