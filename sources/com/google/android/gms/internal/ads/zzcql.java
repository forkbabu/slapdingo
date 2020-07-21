package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzty;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcql implements zzduu<Bundle> {
    private final /* synthetic */ boolean zzgjz;
    final /* synthetic */ zzcqi zzgka;

    zzcql(zzcqi zzcqi, boolean z) {
        this.zzgka = zzcqi;
        this.zzgjz = z;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        zzaxv.zzfb("Failed to get signals bundle");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(Bundle bundle) {
        Bundle bundle2 = bundle;
        ArrayList zza = zzcqi.zzm(bundle2);
        zzty.zzo.zzc zzb = zzcqi.zzl(bundle2);
        this.zzgka.zzgjr.zza(new zzcqk(this, this.zzgjz, zza, this.zzgka.zzk(bundle2), zzb));
    }
}
