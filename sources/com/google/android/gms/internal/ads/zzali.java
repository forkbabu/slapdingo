package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzali {
    private final Object zzdhb = new Object();
    private final Object zzdhc = new Object();
    private zzalr zzdhd;
    private zzalr zzdhe;

    public final zzalr zza(Context context, zzbbd zzbbd) {
        zzalr zzalr;
        synchronized (this.zzdhc) {
            if (this.zzdhe == null) {
                this.zzdhe = new zzalr(zzl(context), zzbbd, zzact.zzdbf.get());
            }
            zzalr = this.zzdhe;
        }
        return zzalr;
    }

    public final zzalr zzb(Context context, zzbbd zzbbd) {
        zzalr zzalr;
        synchronized (this.zzdhb) {
            if (this.zzdhd == null) {
                this.zzdhd = new zzalr(zzl(context), zzbbd, (String) zzwg.zzpw().zzd(zzaav.zzclg));
            }
            zzalr = this.zzdhd;
        }
        return zzalr;
    }

    private static Context zzl(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
