package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcnn implements zzduu<zzdkw> {
    private final /* synthetic */ zzcni zzghb;

    zzcnn(zzcni zzcni) {
        this.zzghb = zzcni;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcvp)).booleanValue()) {
            Matcher matcher = zzcni.zzggy.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zzghb.zzggx.zzdx(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(zzdkw zzdkw) {
        zzdkw zzdkw2 = zzdkw;
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcvp)).booleanValue()) {
            this.zzghb.zzggx.zzdx(zzdkw2.zzhau.zzhar.responseCode);
            this.zzghb.zzggx.zzeq(zzdkw2.zzhau.zzhar.zzgix);
        }
    }
}
