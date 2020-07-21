package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcbw implements zzela<zzqn> {
    private final zzelj<zzbbd> zzfmh;
    private final zzelj<String> zzfmi;

    public zzcbw(zzelj<zzbbd> zzelj, zzelj<String> zzelj2) {
        this.zzfmh = zzelj;
        this.zzfmi = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        zzq.zzkw();
        return (zzqn) zzelg.zza(new zzqn(zzaye.zzxj(), this.zzfmh.get(), this.zzfmi.get(), new JSONObject(), false, true), "Cannot return null from a non-@Nullable @Provides method");
    }
}
