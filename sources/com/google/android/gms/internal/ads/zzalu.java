package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzalu implements zzbbp {
    private final /* synthetic */ zzbbn zzdej;
    private final /* synthetic */ zzaku zzdho;

    zzalu(zzals zzals, zzbbn zzbbn, zzaku zzaku) {
        this.zzdej = zzbbn;
        this.zzdho = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.zzbbp
    public final void run() {
        this.zzdej.setException(new zzalg("Unable to obtain a JavascriptEngine."));
        this.zzdho.release();
    }
}
