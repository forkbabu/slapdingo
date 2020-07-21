package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcma implements Runnable {
    private final Object zzdhw;
    private final String zzgdk;
    private final zzclx zzgff;
    private final zzbbn zzgfq;
    private final long zzgfr;

    zzcma(zzclx zzclx, Object obj, zzbbn zzbbn, String str, long j) {
        this.zzgff = zzclx;
        this.zzdhw = obj;
        this.zzgfq = zzbbn;
        this.zzgdk = str;
        this.zzgfr = j;
    }

    public final void run() {
        this.zzgff.zza(this.zzdhw, this.zzgfq, this.zzgdk, this.zzgfr);
    }
}
