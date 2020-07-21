package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdua implements Runnable {
    private final /* synthetic */ zzdvf zzhnq;
    private final /* synthetic */ int zzhnr;
    private final /* synthetic */ zzdub zzhns;

    zzdua(zzdub zzdub, zzdvf zzdvf, int i) {
        this.zzhns = zzdub;
        this.zzhnq = zzdvf;
        this.zzhnr = i;
    }

    public final void run() {
        try {
            if (this.zzhnq.isCancelled()) {
                zzdsr unused = this.zzhns.zzhnt = null;
                this.zzhns.cancel(false);
            } else {
                this.zzhns.zza(this.zzhnr, this.zzhnq);
            }
        } finally {
            this.zzhns.zza((zzdsr) null);
        }
    }
}
