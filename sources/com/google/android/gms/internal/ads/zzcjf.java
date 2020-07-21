package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzty;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcjf implements zztp {
    private final String zzdfg;
    private final zzty.zza.C0018zza zzgdi;
    private final zzty.zzu zzgdj;
    private final String zzgdk;

    zzcjf(zzty.zza.C0018zza zza, String str, zzty.zzu zzu, String str2) {
        this.zzgdi = zza;
        this.zzdfg = str;
        this.zzgdj = zzu;
        this.zzgdk = str2;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final void zza(zzty.zzi.zza zza) {
        zzty.zza.C0018zza zza2 = this.zzgdi;
        String str = this.zzdfg;
        zzty.zzu zzu = this.zzgdj;
        zza.zza(((zzty.zza.zzb) zza.zzny().zzbfd()).zzb(zza2)).zza(((zzty.zzg.zza) zza.zznx().zzbfd()).zzbz(str).zzb(zzu)).zzcb(this.zzgdk);
    }
}
