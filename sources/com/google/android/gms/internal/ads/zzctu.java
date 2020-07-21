package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctu {
    private final zzckx zzfmz;
    private final zzcis zzgdc;
    private final zzdli zzged;

    public zzctu(zzdli zzdli, zzcis zzcis, zzckx zzckx) {
        this.zzged = zzdli;
        this.zzgdc = zzcis;
        this.zzfmz = zzckx;
    }

    public final void zza(zzdkm zzdkm, zzdkk zzdkk, int i, @Nullable zzcqx zzcqx, long j) {
        zzcit zzcit;
        zzckw zzq = this.zzfmz.zzaok().zza(zzdkm).zzd(zzdkk).zzq("action", "adapter_status").zzq("adapter_l", String.valueOf(j));
        zzq.zzq("sc", Integer.toString(i));
        if (zzcqx != null) {
            zzq.zzq("arec", Integer.toString(zzcqx.zzapo()));
            String zzgt = this.zzged.zzgt(zzcqx.getMessage());
            if (zzgt != null) {
                zzq.zzq("areec", zzgt);
            }
        }
        zzcis zzcis = this.zzgdc;
        Iterator<String> it2 = zzdkk.zzgzs.iterator();
        while (true) {
            if (!it2.hasNext()) {
                zzcit = null;
                break;
            }
            zzcit = zzcis.zzgf(it2.next());
            if (zzcit != null) {
                break;
            }
        }
        if (zzcit != null) {
            zzq.zzq("ancn", zzcit.zzder);
            if (zzcit.zzgcz != null) {
                zzq.zzq("adapter_v", zzcit.zzgcz.toString());
            }
            if (zzcit.zzgda != null) {
                zzq.zzq("adapter_sv", zzcit.zzgda.toString());
            }
        }
        zzq.zzaoi();
    }
}
