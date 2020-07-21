package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzclh {
    private List<Map<String, String>> zzgey = new ArrayList();
    private boolean zzgez = false;
    private boolean zzgfa = false;
    private String zzgfb;
    private zzclc zzgfc;

    public zzclh(String str, zzclc zzclc) {
        this.zzgfb = str;
        this.zzgfc = zzclc;
    }

    public final synchronized void zzgi(String str) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcpx)).booleanValue()) {
            Map<String, String> zzaop = zzaop();
            zzaop.put("action", "adapter_init_started");
            zzaop.put("ancn", str);
            this.zzgey.add(zzaop);
        }
    }

    public final synchronized void zzgj(String str) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcpx)).booleanValue()) {
            Map<String, String> zzaop = zzaop();
            zzaop.put("action", "adapter_init_finished");
            zzaop.put("ancn", str);
            this.zzgey.add(zzaop);
        }
    }

    public final synchronized void zzr(String str, String str2) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcpx)).booleanValue()) {
            Map<String, String> zzaop = zzaop();
            zzaop.put("action", "adapter_init_finished");
            zzaop.put("ancn", str);
            zzaop.put("rqe", str2);
            this.zzgey.add(zzaop);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzaon() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaav.zzcpx     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzaar r1 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ all -> 0x002e }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x002e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r3)
            return
        L_0x0015:
            boolean r0 = r3.zzgez
            if (r0 != 0) goto L_0x002c
            java.util.Map r0 = r3.zzaop()
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_started"
            r0.put(r1, r2)
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r1 = r3.zzgey
            r1.add(r0)
            r0 = 1
            r3.zzgez = r0
        L_0x002c:
            monitor-exit(r3)
            return
        L_0x002e:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclh.zzaon():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzaoo() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaav.zzcpx     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzaar r1 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0046 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0046 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r3)
            return
        L_0x0015:
            boolean r0 = r3.zzgfa
            if (r0 != 0) goto L_0x0044
            java.util.Map r0 = r3.zzaop()
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_finished"
            r0.put(r1, r2)
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r1 = r3.zzgey
            r1.add(r0)
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r0 = r3.zzgey
            java.util.Iterator r0 = r0.iterator()
        L_0x002f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0041
            java.lang.Object r1 = r0.next()
            java.util.Map r1 = (java.util.Map) r1
            com.google.android.gms.internal.ads.zzclc r2 = r3.zzgfc
            r2.zzn(r1)
            goto L_0x002f
        L_0x0041:
            r0 = 1
            r3.zzgfa = r0
        L_0x0044:
            monitor-exit(r3)
            return
        L_0x0046:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclh.zzaoo():void");
    }

    private final Map<String, String> zzaop() {
        Map<String, String> zzaol = this.zzgfc.zzaol();
        zzaol.put("tms", Long.toString(zzq.zzld().elapsedRealtime(), 10));
        zzaol.put("tid", this.zzgfb);
        return zzaol;
    }
}
