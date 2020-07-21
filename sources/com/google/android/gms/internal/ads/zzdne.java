package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpb;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdne<AdT extends zzbpb> {
    /* access modifiers changed from: private */
    public final zzdml zzgxz;
    private final zzdmi zzhek;
    /* access modifiers changed from: private */
    public zzdnk zzhel;
    /* access modifiers changed from: private */
    public zzdvq<zzdmw<AdT>> zzhem;
    private zzdvf<zzdmw<AdT>> zzhen;
    /* access modifiers changed from: private */
    public int zzheo = zzdmu.zzhdy;
    /* access modifiers changed from: private */
    public final zzdnh<AdT> zzhep;
    private final LinkedList<zzdnk> zzheq;
    private final zzduu<zzdmw<AdT>> zzher = new zzdnf(this);

    public zzdne(zzdml zzdml, zzdmi zzdmi, zzdnh<AdT> zzdnh) {
        this.zzgxz = zzdml;
        this.zzhek = zzdmi;
        this.zzhep = zzdnh;
        this.zzheq = new LinkedList<>();
        this.zzhek.zza(new zzdng(this));
    }

    public final void zzb(zzdnk zzdnk) {
        this.zzheq.add(zzdnk);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzdvf<com.google.android.gms.internal.ads.zzdni<AdT>> zzc(com.google.android.gms.internal.ads.zzdnk r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzats()     // Catch:{ all -> 0x0044 }
            r1 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r3)
            return r1
        L_0x000a:
            int r0 = com.google.android.gms.internal.ads.zzdmu.zzhea
            r3.zzheo = r0
            com.google.android.gms.internal.ads.zzdnk r0 = r3.zzhel
            com.google.android.gms.internal.ads.zzdmv r0 = r0.zzary()
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzdmv r0 = r4.zzary()
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzdnk r0 = r3.zzhel
            com.google.android.gms.internal.ads.zzdmv r0 = r0.zzary()
            com.google.android.gms.internal.ads.zzdmv r2 = r4.zzary()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x002d
            goto L_0x0042
        L_0x002d:
            int r0 = com.google.android.gms.internal.ads.zzdmu.zzhdz
            r3.zzheo = r0
            com.google.android.gms.internal.ads.zzdvq<com.google.android.gms.internal.ads.zzdmw<AdT>> r0 = r3.zzhem
            com.google.android.gms.internal.ads.zzdnd r1 = new com.google.android.gms.internal.ads.zzdnd
            r1.<init>(r3)
            java.util.concurrent.Executor r4 = r4.getExecutor()
            com.google.android.gms.internal.ads.zzdvf r4 = com.google.android.gms.internal.ads.zzdux.zzb(r0, r1, r4)
            monitor-exit(r3)
            return r4
        L_0x0042:
            monitor-exit(r3)
            return r1
        L_0x0044:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdne.zzc(com.google.android.gms.internal.ads.zzdnk):com.google.android.gms.internal.ads.zzdvf");
    }

    /* access modifiers changed from: private */
    public final void zzd(zzdnk zzdnk) {
        while (zzats()) {
            if (zzdnk != null || !this.zzheq.isEmpty()) {
                if (zzdnk == null) {
                    zzdnk = this.zzheq.remove();
                }
                if (zzdnk.zzary() == null || !this.zzgxz.zzb(zzdnk.zzary())) {
                    zzdnk = null;
                } else {
                    this.zzhel = zzdnk.zzarz();
                    this.zzhem = zzdvq.zzaxg();
                    zzdvf<zzdmw<AdT>> zza = this.zzhep.zza(this.zzhel);
                    this.zzhen = zza;
                    zzdux.zza(zza, this.zzher, zzdnk.getExecutor());
                    return;
                }
            } else {
                return;
            }
        }
        if (zzdnk != null) {
            this.zzheq.add(zzdnk);
        }
    }

    private final boolean zzats() {
        zzdvf<zzdmw<AdT>> zzdvf = this.zzhen;
        return zzdvf == null || zzdvf.isDone();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzatt() {
        synchronized (this) {
            zzd(this.zzhel);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzc(zzdmw zzdmw) throws Exception {
        zzdvf zzaf;
        synchronized (this) {
            zzaf = zzdux.zzaf(new zzdni(zzdmw, this.zzhel));
        }
        return zzaf;
    }
}
