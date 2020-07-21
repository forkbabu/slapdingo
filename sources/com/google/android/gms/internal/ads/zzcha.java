package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcha<T> implements zzahc<Object> {
    private final WeakReference<T> zzgbz;
    private final String zzgca;
    private final zzahc<T> zzgcb;
    private final /* synthetic */ zzcgr zzgcc;

    private zzcha(zzcgr zzcgr, WeakReference<T> weakReference, String str, zzahc<T> zzahc) {
        this.zzgcc = zzcgr;
        this.zzgbz = weakReference;
        this.zzgca = str;
        this.zzgcb = zzahc;
    }

    @Override // com.google.android.gms.internal.ads.zzahc
    public final void zza(Object obj, Map<String, String> map) {
        T t = this.zzgbz.get();
        if (t == null) {
            this.zzgcc.zzb(this.zzgca, this);
        } else {
            this.zzgcb.zza(t, map);
        }
    }

    /* synthetic */ zzcha(zzcgr zzcgr, WeakReference weakReference, String str, zzahc zzahc, zzcgs zzcgs) {
        this(zzcgr, weakReference, str, zzahc);
    }
}
