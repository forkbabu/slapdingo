package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    private final String zzadi;
    private final int zzdjw;
    private final String zzdla;
    private final String zzepm;
    private final Bundle zzepn;
    private final Bundle zzepo;
    private final int zzepp;
    private final boolean zzna;
    private final Location zznb;
    private final Context zzvr;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, Location location, int i, int i2, String str2, String str3) {
        this.zzepm = str;
        this.zzepn = bundle;
        this.zzepo = bundle2;
        this.zzvr = context;
        this.zzna = z;
        this.zznb = location;
        this.zzdjw = i;
        this.zzepp = i2;
        this.zzadi = str2;
        this.zzdla = str3;
    }

    public String getBidResponse() {
        return this.zzepm;
    }

    public Bundle getServerParameters() {
        return this.zzepn;
    }

    public Bundle getMediationExtras() {
        return this.zzepo;
    }

    public Context getContext() {
        return this.zzvr;
    }

    public Location getLocation() {
        return this.zznb;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzdjw;
    }

    public boolean isTestRequest() {
        return this.zzna;
    }

    public int taggedForUnderAgeTreatment() {
        return this.zzepp;
    }

    public String getMaxAdContentRating() {
        return this.zzadi;
    }

    public String getWatermark() {
        return this.zzdla;
    }
}
