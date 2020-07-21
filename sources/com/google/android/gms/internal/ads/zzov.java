package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzov {
    /* access modifiers changed from: private */
    public final ExecutorService zzbiz;
    /* access modifiers changed from: private */
    public zzox<? extends zzow> zzbja;
    /* access modifiers changed from: private */
    public IOException zzbjb;

    public zzov(String str) {
        this.zzbiz = zzpo.zzbh(str);
    }

    public final <T extends zzow> long zza(T t, zzou<T> zzou, int i) {
        Looper myLooper = Looper.myLooper();
        zzpb.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzox(this, myLooper, t, zzou, i, elapsedRealtime).zzek(0);
        return elapsedRealtime;
    }

    public final boolean isLoading() {
        return this.zzbja != null;
    }

    public final void zzis() {
        this.zzbja.zzl(false);
    }

    public final void zza(Runnable runnable) {
        zzox<? extends zzow> zzox = this.zzbja;
        if (zzox != null) {
            zzox.zzl(true);
        }
        this.zzbiz.execute(runnable);
        this.zzbiz.shutdown();
    }

    public final void zzbi(int i) throws IOException {
        IOException iOException = this.zzbjb;
        if (iOException == null) {
            zzox<? extends zzow> zzox = this.zzbja;
            if (zzox != null) {
                zzox.zzbi(zzox.zzbje);
                return;
            }
            return;
        }
        throw iOException;
    }
}
