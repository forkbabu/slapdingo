package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzgm implements Callable {
    private final String TAG = getClass().getSimpleName();
    private final String className;
    protected final zzcf.zza.C0006zza zzabb;
    private final String zzabj;
    protected Method zzabl;
    private final int zzabp;
    private final int zzabq;
    protected final zzex zzwf;

    public zzgm(zzex zzex, String str, String str2, zzcf.zza.C0006zza zza, int i, int i2) {
        this.zzwf = zzex;
        this.className = str;
        this.zzabj = str2;
        this.zzabb = zza;
        this.zzabp = i;
        this.zzabq = i2;
    }

    /* access modifiers changed from: protected */
    public abstract void zzcx() throws IllegalAccessException, InvocationTargetException;

    /* renamed from: zzcz */
    public Void call() throws Exception {
        try {
            long nanoTime = System.nanoTime();
            Method zza = this.zzwf.zza(this.className, this.zzabj);
            this.zzabl = zza;
            if (zza == null) {
                return null;
            }
            zzcx();
            zzdu zzcm = this.zzwf.zzcm();
            if (!(zzcm == null || this.zzabp == Integer.MIN_VALUE)) {
                zzcm.zza(this.zzabq, this.zzabp, (System.nanoTime() - nanoTime) / 1000);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
