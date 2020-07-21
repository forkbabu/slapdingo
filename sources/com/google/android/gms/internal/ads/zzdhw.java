package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdhw<R> implements zzdnk {
    public final Executor executor;
    public final String zzbum;
    public final zzve zzdpj;
    public final zzvo zzgsb;
    public final zzdin<R> zzgxu;
    public final zzdiq zzgxv;
    @Nullable
    private final zzdmv zzgxw;

    public zzdhw(zzdin<R> zzdin, zzdiq zzdiq, zzve zzve, String str, Executor executor2, zzvo zzvo, @Nullable zzdmv zzdmv) {
        this.zzgxu = zzdin;
        this.zzgxv = zzdiq;
        this.zzdpj = zzve;
        this.zzbum = str;
        this.executor = executor2;
        this.zzgsb = zzvo;
        this.zzgxw = zzdmv;
    }

    @Override // com.google.android.gms.internal.ads.zzdnk
    public final Executor getExecutor() {
        return this.executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdnk
    @Nullable
    public final zzdmv zzary() {
        return this.zzgxw;
    }

    @Override // com.google.android.gms.internal.ads.zzdnk
    public final zzdnk zzarz() {
        return new zzdhw(this.zzgxu, this.zzgxv, this.zzdpj, this.zzbum, this.executor, this.zzgsb, this.zzgxw);
    }
}
