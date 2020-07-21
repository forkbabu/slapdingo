package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
abstract class zzdub<InputT, OutputT> extends zzdue<OutputT> {
    private static final Logger logger = Logger.getLogger(zzdub.class.getName());
    /* access modifiers changed from: private */
    @NullableDecl
    public zzdsr<? extends zzdvf<? extends InputT>> zzhnt;
    private final boolean zzhnu;
    private final boolean zzhnv;

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    enum zza {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    zzdub(zzdsr<? extends zzdvf<? extends InputT>> zzdsr, boolean z, boolean z2) {
        super(zzdsr.size());
        this.zzhnt = (zzdsr) zzdsh.checkNotNull(zzdsr);
        this.zzhnu = z;
        this.zzhnv = z2;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzawx();

    /* access modifiers changed from: package-private */
    public abstract void zzb(int i, @NullableDecl InputT inputt);

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void afterDone() {
        super.afterDone();
        zzdsr<? extends zzdvf<? extends InputT>> zzdsr = this.zzhnt;
        zza(zza.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (zzdsr != null)) {
            boolean wasInterrupted = wasInterrupted();
            zzdtn zzdtn = (zzdtn) zzdsr.iterator();
            while (zzdtn.hasNext()) {
                ((Future) zzdtn.next()).cancel(wasInterrupted);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdtu
    public final String pendingToString() {
        zzdsr<? extends zzdvf<? extends InputT>> zzdsr = this.zzhnt;
        if (zzdsr == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(zzdsr);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("futures=");
        sb.append(valueOf);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zzaww() {
        if (this.zzhnt.isEmpty()) {
            zzawx();
        } else if (this.zzhnu) {
            int i = 0;
            zzdtn zzdtn = (zzdtn) this.zzhnt.iterator();
            while (zzdtn.hasNext()) {
                zzdvf zzdvf = (zzdvf) zzdtn.next();
                zzdvf.addListener(new zzdua(this, zzdvf, i), zzdum.INSTANCE);
                i++;
            }
        } else {
            zzduc zzduc = new zzduc(this, this.zzhnv ? this.zzhnt : null);
            zzdtn zzdtn2 = (zzdtn) this.zzhnt.iterator();
            while (zzdtn2.hasNext()) {
                ((zzdvf) zzdtn2.next()).addListener(zzduc, zzdum.INSTANCE);
            }
        }
    }

    private final void zzj(Throwable th) {
        zzdsh.checkNotNull(th);
        if (this.zzhnu && !setException(th) && zza(zzawy(), th)) {
            zzk(th);
        } else if (th instanceof Error) {
            zzk(th);
        }
    }

    private static void zzk(Throwable th) {
        logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdue
    public final void zzh(Set<Throwable> set) {
        zzdsh.checkNotNull(set);
        if (!isCancelled()) {
            zza(set, zzawt());
        }
    }

    /* access modifiers changed from: private */
    public final void zza(int i, Future<? extends InputT> future) {
        try {
            zzb(i, zzdux.zza(future));
        } catch (ExecutionException e) {
            zzj(e.getCause());
        } catch (Throwable th) {
            zzj(th);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(@NullableDecl zzdsr<? extends Future<? extends InputT>> zzdsr) {
        int zzawz = zzawz();
        int i = 0;
        if (!(zzawz >= 0)) {
            throw new IllegalStateException("Less than 0 remaining futures");
        } else if (zzawz == 0) {
            if (zzdsr != null) {
                zzdtn zzdtn = (zzdtn) zzdsr.iterator();
                while (zzdtn.hasNext()) {
                    Future<? extends InputT> future = (Future) zzdtn.next();
                    if (!future.isCancelled()) {
                        zza(i, future);
                    }
                    i++;
                }
            }
            zzaxa();
            zzawx();
            zza(zza.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zza zza2) {
        zzdsh.checkNotNull(zza2);
        this.zzhnt = null;
    }

    private static boolean zza(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }
}
