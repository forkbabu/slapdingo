package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbjj implements zzdhf {
    private final /* synthetic */ zzbiz zzeto;
    private Context zzfep;
    private String zzfeq;

    private zzbjj(zzbiz zzbiz) {
        this.zzeto = zzbiz;
    }

    @Override // com.google.android.gms.internal.ads.zzdhf
    public final zzdhg zzafh() {
        zzelg.zza(this.zzfep, Context.class);
        zzelg.zza(this.zzfeq, String.class);
        return new zzbjm(this.zzeto, this.zzfep, this.zzfeq);
    }

    @Override // com.google.android.gms.internal.ads.zzdhf
    public final /* synthetic */ zzdhf zzfu(String str) {
        this.zzfeq = (String) zzelg.checkNotNull(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdhf
    public final /* synthetic */ zzdhf zzby(Context context) {
        this.zzfep = (Context) zzelg.checkNotNull(context);
        return this;
    }
}
