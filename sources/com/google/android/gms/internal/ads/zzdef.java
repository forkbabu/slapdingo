package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdef implements zzddz<Bundle> {
    private final boolean zzdsx;
    private final boolean zzdsy;
    private final String zzdta;
    private final boolean zzdtb;
    private final boolean zzdtc;
    private final boolean zzdtd;
    private final String zzdtg;
    private final String zzdth;
    private final String zzdti;
    private final boolean zzdtv;
    private final ArrayList<String> zzgup;
    private final String zzguq;
    private final String zzgur;
    private final long zzgus;

    public zzdef(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, ArrayList<String> arrayList, @Nullable String str3, @Nullable String str4, String str5, boolean z6, String str6, long j) {
        this.zzdsx = z;
        this.zzdsy = z2;
        this.zzdta = str;
        this.zzdtb = z3;
        this.zzdtc = z4;
        this.zzdtd = z5;
        this.zzdtg = str2;
        this.zzgup = arrayList;
        this.zzdth = str3;
        this.zzdti = str4;
        this.zzguq = str5;
        this.zzdtv = z6;
        this.zzgur = str6;
        this.zzgus = j;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putBoolean("cog", this.zzdsx);
        bundle2.putBoolean("coh", this.zzdsy);
        bundle2.putString("gl", this.zzdta);
        bundle2.putBoolean("simulator", this.zzdtb);
        bundle2.putBoolean("is_latchsky", this.zzdtc);
        bundle2.putBoolean("is_sidewinder", this.zzdtd);
        bundle2.putString("hl", this.zzdtg);
        if (!this.zzgup.isEmpty()) {
            bundle2.putStringArrayList("hl_list", this.zzgup);
        }
        bundle2.putString("mv", this.zzdth);
        bundle2.putString("submodel", this.zzgur);
        Bundle zza = zzdlf.zza(bundle2, "device");
        bundle2.putBundle("device", zza);
        zza.putString("build", this.zzguq);
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcra)).booleanValue()) {
            zza.putLong("remaining_data_partition_space", this.zzgus);
        }
        Bundle zza2 = zzdlf.zza(zza, "browser");
        zza.putBundle("browser", zza2);
        zza2.putBoolean("is_browser_custom_tabs_capable", this.zzdtv);
        if (!TextUtils.isEmpty(this.zzdti)) {
            Bundle zza3 = zzdlf.zza(zza, "play_store");
            zza.putBundle("play_store", zza3);
            zza3.putString("package_version", this.zzdti);
        }
    }
}
