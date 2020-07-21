package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.WeakHashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzqp {
    private final Object lock = new Object();
    private final Context zzaah;
    private final zzbbd zzboy;
    private final WeakHashMap<Object, Object> zzbrg = new WeakHashMap<>();
    private final ArrayList<Object> zzbrh = new ArrayList<>();
    private final zzakh zzbri;

    public zzqp(Context context, zzbbd zzbbd) {
        this.zzaah = context.getApplicationContext();
        this.zzboy = zzbbd;
        this.zzbri = new zzakh(context.getApplicationContext(), zzbbd, (String) zzwg.zzpw().zzd(zzaav.zzclh));
    }
}
