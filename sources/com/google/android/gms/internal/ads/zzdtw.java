package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
abstract class zzdtw<I, O, F, T> extends zzdur<O> implements Runnable {
    @NullableDecl
    private zzdvf<? extends I> zzhmy;
    @NullableDecl
    private F zzhnp;

    static <I, O> zzdvf<O> zza(zzdvf<I> zzdvf, zzduh<? super I, ? extends O> zzduh, Executor executor) {
        zzdsh.checkNotNull(executor);
        zzdtz zzdtz = new zzdtz(zzdvf, zzduh);
        zzdvf.addListener(zzdtz, zzdvh.zza(executor, zzdtz));
        return zzdtz;
    }

    /* access modifiers changed from: package-private */
    public abstract void setResult(@NullableDecl T t);

    /* access modifiers changed from: package-private */
    @NullableDecl
    public abstract T zzd(F f, @NullableDecl I i) throws Exception;

    static <I, O> zzdvf<O> zza(zzdvf<I> zzdvf, zzdrx<? super I, ? extends O> zzdrx, Executor executor) {
        zzdsh.checkNotNull(zzdrx);
        zzdty zzdty = new zzdty(zzdvf, zzdrx);
        zzdvf.addListener(zzdty, zzdvh.zza(executor, zzdty));
        return zzdty;
    }

    zzdtw(zzdvf<? extends I> zzdvf, F f) {
        this.zzhmy = (zzdvf) zzdsh.checkNotNull(zzdvf);
        this.zzhnp = zzdsh.checkNotNull(f);
    }

    public final void run() {
        zzdvf<? extends I> zzdvf = this.zzhmy;
        F f = this.zzhnp;
        boolean z = true;
        boolean isCancelled = isCancelled() | (zzdvf == null);
        if (f != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.zzhmy = null;
            if (zzdvf.isCancelled()) {
                setFuture(zzdvf);
                return;
            }
            try {
                try {
                    T zzd = zzd(f, zzdux.zza(zzdvf));
                    this.zzhnp = null;
                    setResult(zzd);
                } catch (Throwable th) {
                    this.zzhnp = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                setException(e.getCause());
            } catch (RuntimeException e2) {
                setException(e2);
            } catch (Error e3) {
                setException(e3);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzhmy);
        this.zzhmy = null;
        this.zzhnp = null;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdtu
    public final String pendingToString() {
        String str;
        zzdvf<? extends I> zzdvf = this.zzhmy;
        F f = this.zzhnp;
        String pendingToString = super.pendingToString();
        if (zzdvf != null) {
            String valueOf = String.valueOf(zzdvf);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("], ");
            str = sb.toString();
        } else {
            str = "";
        }
        if (f != null) {
            String valueOf2 = String.valueOf(f);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(valueOf2).length());
            sb2.append(str);
            sb2.append("function=[");
            sb2.append(valueOf2);
            sb2.append("]");
            return sb2.toString();
        } else if (pendingToString == null) {
            return null;
        } else {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf(pendingToString);
            return valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        }
    }
}
