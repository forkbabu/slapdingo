package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzddo implements zzddz<Bundle> {
    private final String zzbpn;
    private final int zzdqa;
    private final boolean zzdqx;
    private final boolean zzedg;
    private final boolean zzgtz;
    private final int zzgua;
    private final int zzgub;

    public zzddo(boolean z, boolean z2, String str, boolean z3, int i, int i2, int i3) {
        this.zzgtz = z;
        this.zzedg = z2;
        this.zzbpn = str;
        this.zzdqx = z3;
        this.zzdqa = i;
        this.zzgua = i2;
        this.zzgub = i3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("js", this.zzbpn);
        bundle2.putBoolean("is_nonagon", true);
        bundle2.putString("extra_caps", (String) zzwg.zzpw().zzd(zzaav.zzcrc));
        bundle2.putInt("target_api", this.zzdqa);
        bundle2.putInt("dv", this.zzgua);
        bundle2.putInt("lv", this.zzgub);
        Bundle zza = zzdlf.zza(bundle2, "sdk_env");
        zza.putBoolean("mf", zzacl.zzdak.get().booleanValue());
        zza.putBoolean("instant_app", this.zzgtz);
        zza.putBoolean("lite", this.zzedg);
        zza.putBoolean("is_privileged_process", this.zzdqx);
        bundle2.putBundle("sdk_env", zza);
        Bundle zza2 = zzdlf.zza(zza, "build_meta");
        zza2.putString("cl", "312401170");
        zza2.putString("rapid_rc", "dev");
        zza2.putString("rapid_rollup", "HEAD");
        zza.putBundle("build_meta", zza2);
    }
}
