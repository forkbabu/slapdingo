package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzakq implements zzbbr<zzaju> {
    private final /* synthetic */ zzakh zzdgj;
    private final /* synthetic */ zzaky zzdgn;

    zzakq(zzakh zzakh, zzaky zzaky) {
        this.zzdgj = zzakh;
        this.zzdgn = zzaky;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbbr
    public final /* synthetic */ void zzh(zzaju zzaju) {
        synchronized (this.zzdgj.lock) {
            int unused = this.zzdgj.status = 0;
            if (!(this.zzdgj.zzdgd == null || this.zzdgn == this.zzdgj.zzdgd)) {
                zzaxv.zzeh("New JS engine is loaded, marking previous one as destroyable.");
                this.zzdgj.zzdgd.zztd();
            }
            zzaky unused2 = this.zzdgj.zzdgd = this.zzdgn;
        }
    }
}
