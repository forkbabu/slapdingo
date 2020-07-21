package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdmm {
    private final int maxEntries;
    private final LinkedList<zzdmw<?>> zzhcm = new LinkedList<>();
    private final int zzhcn;
    private final zzdnj zzhco;

    public zzdmm(int i, int i2) {
        this.maxEntries = i;
        this.zzhcn = i2;
        this.zzhco = new zzdnj();
    }

    public final boolean zzb(zzdmw<?> zzdmw) {
        this.zzhco.zzatu();
        zzate();
        if (this.zzhcm.size() == this.maxEntries) {
            return false;
        }
        this.zzhcm.add(zzdmw);
        return true;
    }

    public final zzdmw<?> zzasz() {
        this.zzhco.zzatu();
        zzate();
        if (this.zzhcm.isEmpty()) {
            return null;
        }
        zzdmw<?> remove = this.zzhcm.remove();
        if (remove != null) {
            this.zzhco.zzatv();
        }
        return remove;
    }

    public final int size() {
        zzate();
        return this.zzhcm.size();
    }

    public final long getCreationTimeMillis() {
        return this.zzhco.getCreationTimeMillis();
    }

    public final long zzata() {
        return this.zzhco.zzata();
    }

    public final int zzatb() {
        return this.zzhco.zzatb();
    }

    public final String zzatc() {
        return this.zzhco.zzatm();
    }

    public final zzdnm zzatd() {
        return this.zzhco.zzatx();
    }

    private final void zzate() {
        while (!this.zzhcm.isEmpty()) {
            if (zzq.zzld().currentTimeMillis() - this.zzhcm.getFirst().zzhee >= ((long) this.zzhcn)) {
                this.zzhco.zzatw();
                this.zzhcm.remove();
            } else {
                return;
            }
        }
    }
}
