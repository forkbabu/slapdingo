package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdvr<V> implements Runnable {
    @NullableDecl
    private zzdvp<V> zzhpe;

    zzdvr(zzdvp<V> zzdvp) {
        this.zzhpe = zzdvp;
    }

    public final void run() {
        zzdvf<? extends V> zza;
        zzdvp<V> zzdvp = this.zzhpe;
        if (zzdvp != null && (zza = ((zzdvp) zzdvp).zzhpc) != null) {
            this.zzhpe = null;
            if (zza.isDone()) {
                zzdvp.setFuture(zza);
                return;
            }
            try {
                ScheduledFuture zzb = ((zzdvp) zzdvp).zzhpd;
                ScheduledFuture unused = ((zzdvp) zzdvp).zzhpd = null;
                String str = "Timed out";
                if (zzb != null) {
                    try {
                        long abs = Math.abs(zzb.getDelay(TimeUnit.MILLISECONDS));
                        if (abs > 10) {
                            StringBuilder sb = new StringBuilder(str.length() + 66);
                            sb.append(str);
                            sb.append(" (timeout delayed by ");
                            sb.append(abs);
                            sb.append(" ms after scheduled time)");
                            str = sb.toString();
                        }
                    } catch (Throwable th) {
                        zzdvp.setException(new zzdvu(str));
                        throw th;
                    }
                }
                String valueOf = String.valueOf(str);
                String valueOf2 = String.valueOf(zza);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 2 + String.valueOf(valueOf2).length());
                sb2.append(valueOf);
                sb2.append(": ");
                sb2.append(valueOf2);
                zzdvp.setException(new zzdvu(sb2.toString()));
            } finally {
                zza.cancel(true);
            }
        }
    }
}
