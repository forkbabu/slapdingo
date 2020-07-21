package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrx;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcbl implements zzela<zzbpc<zzbnc>> {
    private final zzelj<zzbus> zzfqt;
    private final zzelj<zzbif> zzfvj;
    private final zzelj<zzbrx.zza> zzfvk;
    private final zzelj<zzbxa> zzfvl;
    private final zzelj<zzcay> zzfvm;

    public zzcbl(zzelj<zzbif> zzelj, zzelj<zzbrx.zza> zzelj2, zzelj<zzbxa> zzelj3, zzelj<zzcay> zzelj4, zzelj<zzbus> zzelj5) {
        this.zzfvj = zzelj;
        this.zzfvk = zzelj2;
        this.zzfvl = zzelj3;
        this.zzfvm = zzelj4;
        this.zzfqt = zzelj5;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbpc) zzelg.zza(this.zzfvj.get().zzadl().zzc(this.zzfvk.get().zzaiz()).zzc(this.zzfvl.get()).zzb(this.zzfvm.get()).zza(new zzcvw(null)).zza(new zzbou(this.zzfqt.get())).zzb(new zzbnb(null)).zzafk().zzafr(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
