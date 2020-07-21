package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdiy implements zzdie {
    private final String zzdfg;
    private final String zzdia;
    private final zzatg zzfrv;

    zzdiy(zzatg zzatg, String str, String str2) {
        this.zzfrv = zzatg;
        this.zzdfg = str;
        this.zzdia = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzdie
    public final void zzq(Object obj) {
        zzatg zzatg = this.zzfrv;
        ((zzaur) obj).zza(new zzave(zzatg.getType(), zzatg.getAmount()), this.zzdfg, this.zzdia);
    }
}
