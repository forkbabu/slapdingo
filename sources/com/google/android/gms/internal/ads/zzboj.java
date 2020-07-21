package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzboj implements zzela<Boolean> {
    private final zzelj<zzdla> zzfnz;

    public zzboj(zzelj<zzdla> zzelj) {
        this.zzfnz = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        boolean z;
        if (this.zzfnz.get().zzasj() != null) {
            z = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcoq)).booleanValue();
        } else {
            z = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcuh)).booleanValue();
        }
        return Boolean.valueOf(z);
    }
}
