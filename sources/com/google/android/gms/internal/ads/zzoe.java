package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzoe {
    private zzoh zzbhn;

    public abstract zzog zza(zzhy[] zzhyArr, zznr zznr) throws zzhb;

    public abstract void zzd(Object obj);

    public final void zza(zzoh zzoh) {
        this.zzbhn = zzoh;
    }

    /* access modifiers changed from: protected */
    public final void invalidate() {
        zzoh zzoh = this.zzbhn;
        if (zzoh != null) {
            zzoh.zzeo();
        }
    }
}
