package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcmv implements zzela<zzdvf<String>> {
    private final zzelj<Context> zzere;
    private final zzelj<zzdou> zzfoc;

    private zzcmv(zzelj<zzdou> zzelj, zzelj<Context> zzelj2) {
        this.zzfoc = zzelj;
        this.zzere = zzelj2;
    }

    public static zzcmv zzap(zzelj<zzdou> zzelj, zzelj<Context> zzelj2) {
        return new zzcmv(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzdvf) zzelg.zza(this.zzfoc.get().zzu(zzdor.WEBVIEW_COOKIE).zzc(new zzcmr(zzq.zzky().zzbh(this.zzere.get()))).zza(1, TimeUnit.SECONDS).zza(Exception.class, zzcmq.zzggm).zzaus(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
