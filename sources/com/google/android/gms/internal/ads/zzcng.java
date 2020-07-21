package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzcng implements zzduh<zzasm, zzdkw> {
    /* access modifiers changed from: private */
    public final zzbuv zzggv;

    public zzcng(zzbuv zzbuv) {
        this.zzggv = zzbuv;
    }

    /* access modifiers changed from: protected */
    public abstract zzdvf<zzdkw> zzb(zzasm zzasm) throws zzcmi;

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdvf' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduh
    public final /* synthetic */ zzdvf<zzdkw> zzf(zzasm zzasm) throws Exception {
        zzasm zzasm2 = zzasm;
        this.zzggv.zzd(zzasm2);
        zzdvf<zzdkw> zzb = zzb(zzasm2);
        zzdux.zza(zzb, new zzcnj(this), zzbbf.zzedm);
        return zzb;
    }
}
