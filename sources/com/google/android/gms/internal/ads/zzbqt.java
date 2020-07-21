package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbqt implements zzela<zzbpa> {
    private final zzelj<zzbtf> zzeug;
    private final zzelj<zzbuz> zzeuh;
    private final zzelj<zzbtv> zzevq;
    private final zzelj<zzdkw> zzfkw;
    private final zzelj<zzdkk> zzfos;
    private final zzelj<zzdim> zzfql;
    private final zzelj<zzbsg> zzfqm;

    private zzbqt(zzelj<zzdkw> zzelj, zzelj<zzdkk> zzelj2, zzelj<zzbtf> zzelj3, zzelj<zzbtv> zzelj4, zzelj<zzdim> zzelj5, zzelj<zzbsg> zzelj6, zzelj<zzbuz> zzelj7) {
        this.zzfkw = zzelj;
        this.zzfos = zzelj2;
        this.zzeug = zzelj3;
        this.zzevq = zzelj4;
        this.zzfql = zzelj5;
        this.zzfqm = zzelj6;
        this.zzeuh = zzelj7;
    }

    public static zzbqt zza(zzelj<zzdkw> zzelj, zzelj<zzdkk> zzelj2, zzelj<zzbtf> zzelj3, zzelj<zzbtv> zzelj4, zzelj<zzdim> zzelj5, zzelj<zzbsg> zzelj6, zzelj<zzbuz> zzelj7) {
        return new zzbqt(zzelj, zzelj2, zzelj3, zzelj4, zzelj5, zzelj6, zzelj7);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbpa(this.zzfkw.get(), this.zzfos.get(), this.zzeug.get(), this.zzevq.get(), this.zzfql.get(), this.zzfqm.get(), this.zzeuh.get());
    }
}
