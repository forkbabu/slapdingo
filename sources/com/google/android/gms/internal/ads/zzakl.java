package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzakl implements zzajx {
    private final zzakh zzdfx;
    private final zzaky zzdgf;
    private final zzaju zzdgg;

    zzakl(zzakh zzakh, zzaky zzaky, zzaju zzaju) {
        this.zzdfx = zzakh;
        this.zzdgf = zzaky;
        this.zzdgg = zzaju;
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final void zzsz() {
        zzaye.zzdzw.postDelayed(new zzakk(this.zzdfx, this.zzdgf, this.zzdgg), (long) zzaks.zzdgp);
    }
}
