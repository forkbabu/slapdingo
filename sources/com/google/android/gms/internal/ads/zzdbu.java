package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdbu implements Callable {
    static final Callable zzgtd = new zzdbu();

    private zzdbu() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return new zzdbs(zzq.zzlg().zzxw(), zzq.zzlg().zzxx());
    }
}
