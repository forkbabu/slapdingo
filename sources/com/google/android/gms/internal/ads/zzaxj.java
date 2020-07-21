package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzaxj extends zzaxr {
    private final /* synthetic */ zzaxh zzdxz;

    zzaxj(zzaxh zzaxh) {
        this.zzdxz = zzaxh;
    }

    @Override // com.google.android.gms.internal.ads.zzaxr
    public final void zzut() {
        zzaaz zzaaz = new zzaaz(this.zzdxz.zzvr, this.zzdxz.zzboy.zzbpn);
        synchronized (this.zzdxz.lock) {
            try {
                zzq.zzlf();
                zzaba.zza(this.zzdxz.zzdxm, zzaaz);
            } catch (IllegalArgumentException e) {
                zzaxv.zzd("Cannot config CSI reporter.", e);
            }
        }
    }
}
