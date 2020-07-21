package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzalr {
    private static final zzazj<zzaju> zzdhi = new zzalq();
    private static final zzazj<zzaju> zzdhj = new zzalt();
    private final zzakh zzdhk;

    public zzalr(Context context, zzbbd zzbbd, String str) {
        this.zzdhk = new zzakh(context, zzbbd, str, zzdhi, zzdhj);
    }

    public final <I, O> zzalj<I, O> zza(String str, zzalk<I> zzalk, zzall<O> zzall) {
        return new zzals(this.zzdhk, str, zzalk, zzall);
    }

    public final zzalw zztg() {
        return new zzalw(this.zzdhk);
    }
}
