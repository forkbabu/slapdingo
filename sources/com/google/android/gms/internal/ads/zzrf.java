package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzrf {
    private final Object lock = new Object();
    private int zzbso;
    private List<zzrc> zzbsp = new LinkedList();

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzrc zzo(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.lock
            monitor-enter(r0)
            java.util.List<com.google.android.gms.internal.ads.zzrc> r1 = r7.zzbsp     // Catch:{ all -> 0x005a }
            int r1 = r1.size()     // Catch:{ all -> 0x005a }
            r2 = 0
            if (r1 != 0) goto L_0x0013
            java.lang.String r8 = "Queue empty"
            com.google.android.gms.internal.ads.zzaxv.zzee(r8)     // Catch:{ all -> 0x005a }
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return r2
        L_0x0013:
            java.util.List<com.google.android.gms.internal.ads.zzrc> r1 = r7.zzbsp     // Catch:{ all -> 0x005a }
            int r1 = r1.size()     // Catch:{ all -> 0x005a }
            r3 = 2
            r4 = 0
            if (r1 < r3) goto L_0x0045
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            java.util.List<com.google.android.gms.internal.ads.zzrc> r1 = r7.zzbsp     // Catch:{ all -> 0x005a }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x005a }
            r3 = 0
        L_0x0026:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x005a }
            if (r5 == 0) goto L_0x003e
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x005a }
            com.google.android.gms.internal.ads.zzrc r5 = (com.google.android.gms.internal.ads.zzrc) r5     // Catch:{ all -> 0x005a }
            int r6 = r5.getScore()     // Catch:{ all -> 0x005a }
            if (r6 <= r8) goto L_0x003b
            r4 = r3
            r2 = r5
            r8 = r6
        L_0x003b:
            int r3 = r3 + 1
            goto L_0x0026
        L_0x003e:
            java.util.List<com.google.android.gms.internal.ads.zzrc> r8 = r7.zzbsp     // Catch:{ all -> 0x005a }
            r8.remove(r4)     // Catch:{ all -> 0x005a }
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return r2
        L_0x0045:
            java.util.List<com.google.android.gms.internal.ads.zzrc> r1 = r7.zzbsp     // Catch:{ all -> 0x005a }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x005a }
            com.google.android.gms.internal.ads.zzrc r1 = (com.google.android.gms.internal.ads.zzrc) r1     // Catch:{ all -> 0x005a }
            if (r8 == 0) goto L_0x0055
            java.util.List<com.google.android.gms.internal.ads.zzrc> r8 = r7.zzbsp     // Catch:{ all -> 0x005a }
            r8.remove(r4)     // Catch:{ all -> 0x005a }
            goto L_0x0058
        L_0x0055:
            r1.zzmb()     // Catch:{ all -> 0x005a }
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return r1
        L_0x005a:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrf.zzo(boolean):com.google.android.gms.internal.ads.zzrc");
    }

    public final boolean zza(zzrc zzrc) {
        synchronized (this.lock) {
            if (this.zzbsp.contains(zzrc)) {
                return true;
            }
            return false;
        }
    }

    public final boolean zzb(zzrc zzrc) {
        synchronized (this.lock) {
            Iterator<zzrc> it2 = this.zzbsp.iterator();
            while (it2.hasNext()) {
                zzrc next = it2.next();
                if (!zzq.zzla().zzwe().zzwt()) {
                    if (zzrc != next && next.zzly().equals(zzrc.zzly())) {
                        it2.remove();
                        return true;
                    }
                } else if (!zzq.zzla().zzwe().zzwv() && zzrc != next && next.zzma().equals(zzrc.zzma())) {
                    it2.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzrc zzrc) {
        synchronized (this.lock) {
            if (this.zzbsp.size() >= 10) {
                int size = this.zzbsp.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzaxv.zzee(sb.toString());
                this.zzbsp.remove(0);
            }
            int i = this.zzbso;
            this.zzbso = i + 1;
            zzrc.zzbv(i);
            zzrc.zzme();
            this.zzbsp.add(zzrc);
        }
    }
}
