package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzvf {
    public static final zzvf zzchh = new zzvf();

    protected zzvf() {
    }

    public static zzve zza(Context context, zzyq zzyq) {
        List list;
        Context context2;
        zzuw zzuw;
        String str;
        Date birthday = zzyq.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = zzyq.getContentUrl();
        int gender = zzyq.getGender();
        Set<String> keywords = zzyq.getKeywords();
        if (!keywords.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(keywords));
            context2 = context;
        } else {
            context2 = context;
            list = null;
        }
        boolean isTestDevice = zzyq.isTestDevice(context2);
        Location location = zzyq.getLocation();
        Bundle networkExtrasBundle = zzyq.getNetworkExtrasBundle(AdMobAdapter.class);
        if (zzyq.zzqq() != null) {
            zzuw = new zzuw(zzyq.zzqq().getAdString(), zzwg.zzqa().containsKey(zzyq.zzqq().getQueryInfo()) ? zzwg.zzqa().get(zzyq.zzqq().getQueryInfo()) : "");
        } else {
            zzuw = null;
        }
        boolean manualImpressionsEnabled = zzyq.getManualImpressionsEnabled();
        String publisherProvidedId = zzyq.getPublisherProvidedId();
        SearchAdRequest zzql = zzyq.zzql();
        zzzw zzzw = zzql != null ? new zzzw(zzql) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzwg.zzps();
            str = zzbaq.zza(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean isDesignedForFamilies = zzyq.isDesignedForFamilies();
        RequestConfiguration requestConfiguration = zzyt.zzqs().getRequestConfiguration();
        return new zzve(8, time, networkExtrasBundle, gender, list, isTestDevice, Math.max(zzyq.zzqo(), requestConfiguration.getTagForChildDirectedTreatment()), manualImpressionsEnabled, publisherProvidedId, zzzw, location, contentUrl, zzyq.zzqn(), zzyq.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzyq.zzqp())), zzyq.zzqk(), str, isDesignedForFamilies, zzuw, Math.max(zzyq.zzqr(), requestConfiguration.getTagForUnderAgeOfConsent()), (String) Collections.max(Arrays.asList(zzyq.getMaxAdContentRating(), requestConfiguration.getMaxAdContentRating()), zzvi.zzchq), zzyq.zzqj());
    }

    public static zzatw zza(Context context, zzyq zzyq, String str) {
        return new zzatw(zza(context, zzyq), str);
    }

    static final /* synthetic */ int zzd(String str, String str2) {
        return RequestConfiguration.zzadk.indexOf(str) - RequestConfiguration.zzadk.indexOf(str2);
    }
}
