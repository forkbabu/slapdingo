package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzq implements zzan {
    private int zzac;
    private int zzad;
    private final int zzae;
    private final float zzaf;

    public zzq() {
        this(2500, 1, 1.0f);
    }

    private zzq(int i, int i2, float f) {
        this.zzac = 2500;
        this.zzae = 1;
        this.zzaf = 1.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzan
    public final int zzb() {
        return this.zzac;
    }

    @Override // com.google.android.gms.internal.ads.zzan
    public final int zzc() {
        return this.zzad;
    }

    @Override // com.google.android.gms.internal.ads.zzan
    public final void zza(zzao zzao) throws zzao {
        boolean z = true;
        int i = this.zzad + 1;
        this.zzad = i;
        int i2 = this.zzac;
        this.zzac = i2 + ((int) (((float) i2) * this.zzaf));
        if (i > this.zzae) {
            z = false;
        }
        if (!z) {
            throw zzao;
        }
    }
}
