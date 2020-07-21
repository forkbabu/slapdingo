package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbjp {
    private zzbkb zzerh;
    private zzbie zzeri;
    private zzdpb zzfhc;
    private zzbkk zzfhd;
    private zzdlr zzfhe;

    private zzbjp() {
    }

    public final zzbjp zzc(zzbie zzbie) {
        this.zzeri = (zzbie) zzelg.checkNotNull(zzbie);
        return this;
    }

    public final zzbjp zza(zzbkb zzbkb) {
        this.zzerh = (zzbkb) zzelg.checkNotNull(zzbkb);
        return this;
    }

    public final zzbif zzafs() {
        zzelg.zza(this.zzeri, zzbie.class);
        zzelg.zza(this.zzerh, zzbkb.class);
        if (this.zzfhc == null) {
            this.zzfhc = new zzdpb();
        }
        if (this.zzfhd == null) {
            this.zzfhd = new zzbkk();
        }
        if (this.zzfhe == null) {
            this.zzfhe = new zzdlr();
        }
        return new zzbiz(this.zzeri, this.zzerh, this.zzfhc, this.zzfhd, this.zzfhe);
    }
}
