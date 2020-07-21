package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdbm implements zzddz<Bundle> {
    private final String zzdqz;
    private final String zzgsz;
    private final Bundle zzgta;

    private zzdbm(String str, String str2, Bundle bundle) {
        this.zzdqz = str;
        this.zzgsz = str2;
        this.zzgta = bundle;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("consent_string", this.zzdqz);
        bundle2.putString("fc_consent", this.zzgsz);
        bundle2.putBundle("iab_consent_info", this.zzgta);
    }
}
