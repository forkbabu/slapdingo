package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzakt implements zzbbp {
    private final /* synthetic */ zzakh zzdgj;
    private final /* synthetic */ zzaky zzdgn;

    zzakt(zzakh zzakh, zzaky zzaky) {
        this.zzdgj = zzakh;
        this.zzdgn = zzaky;
    }

    @Override // com.google.android.gms.internal.ads.zzbbp
    public final void run() {
        synchronized (this.zzdgj.lock) {
            int unused = this.zzdgj.status = 1;
            zzaxv.zzeh("Failed loading new engine. Marking new engine destroyable.");
            this.zzdgn.zztd();
        }
    }
}
