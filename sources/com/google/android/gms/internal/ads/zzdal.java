package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdal implements zzddz<Bundle> {
    private final float zzdpz;
    private final int zzdsw;
    private final boolean zzdte;
    private final boolean zzdtf;
    private final int zzdtj;
    private final int zzdtn;
    private final int zzdto;
    private final boolean zzgsl;

    public zzdal(int i, boolean z, boolean z2, int i2, int i3, int i4, float f, boolean z3) {
        this.zzdsw = i;
        this.zzdte = z;
        this.zzdtf = z2;
        this.zzdtj = i2;
        this.zzdtn = i3;
        this.zzdto = i4;
        this.zzdpz = f;
        this.zzgsl = z3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putInt("am", this.zzdsw);
        bundle2.putBoolean("ma", this.zzdte);
        bundle2.putBoolean("sp", this.zzdtf);
        bundle2.putInt("muv", this.zzdtj);
        bundle2.putInt("rm", this.zzdtn);
        bundle2.putInt("riv", this.zzdto);
        bundle2.putFloat("android_app_volume", this.zzdpz);
        bundle2.putBoolean("android_app_muted", this.zzgsl);
    }
}
