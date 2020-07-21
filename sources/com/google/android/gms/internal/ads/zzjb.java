package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzjb implements zziw {
    private final /* synthetic */ zziz zzamo;

    private zzjb(zziz zziz) {
        this.zzamo = zziz;
    }

    @Override // com.google.android.gms.internal.ads.zziw
    public final void zzx(int i) {
        this.zzamo.zzame.zzw(i);
        zziz.zzx(i);
    }

    @Override // com.google.android.gms.internal.ads.zziw
    public final void zzej() {
        zziz.zzgc();
        boolean unused = this.zzamo.zzamk = true;
    }

    @Override // com.google.android.gms.internal.ads.zziw
    public final void zzc(int i, long j, long j2) {
        this.zzamo.zzame.zza(i, j, j2);
        zziz.zzb(i, j, j2);
    }
}
