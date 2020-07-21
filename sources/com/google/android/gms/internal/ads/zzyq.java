package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzyq {
    private final int zzadg;
    private final int zzadh;
    private final String zzadi;
    private final boolean zzbnr;
    private final int zzcgt;
    private final String zzcgw;
    private final String zzcgy;
    private final Bundle zzcha;
    private final String zzchc;
    private final boolean zzche;
    private final List<String> zzchf;
    private final Bundle zzciz;
    private final AdInfo zzcjd;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzcje;
    private final SearchAdRequest zzcjf;
    private final Set<String> zzcjg;
    private final Set<String> zzcjh;
    private final Date zzmx;
    private final Set<String> zzmz;
    private final Location zznb;

    public zzyq(zzyp zzyp) {
        this(zzyp, null);
    }

    public zzyq(zzyp zzyp, SearchAdRequest searchAdRequest) {
        this.zzmx = zzyp.zzmx;
        this.zzcgy = zzyp.zzcgy;
        this.zzchf = zzyp.zzchf;
        this.zzcgt = zzyp.zzcgt;
        this.zzmz = Collections.unmodifiableSet(zzyp.zzciy);
        this.zznb = zzyp.zznb;
        this.zzbnr = zzyp.zzbnr;
        this.zzciz = zzyp.zzciz;
        this.zzcje = Collections.unmodifiableMap(zzyp.zzcja);
        this.zzcgw = zzyp.zzcgw;
        this.zzchc = zzyp.zzchc;
        this.zzcjf = searchAdRequest;
        this.zzadg = zzyp.zzadg;
        this.zzcjg = Collections.unmodifiableSet(zzyp.zzcjb);
        this.zzcha = zzyp.zzcha;
        this.zzcjh = Collections.unmodifiableSet(zzyp.zzcjc);
        this.zzche = zzyp.zzche;
        this.zzcjd = zzyp.zzcjd;
        this.zzadh = zzyp.zzadh;
        this.zzadi = zzyp.zzadi;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzmx;
    }

    public final String getContentUrl() {
        return this.zzcgy;
    }

    public final List<String> zzqj() {
        return new ArrayList(this.zzchf);
    }

    @Deprecated
    public final int getGender() {
        return this.zzcgt;
    }

    public final Set<String> getKeywords() {
        return this.zzmz;
    }

    public final Location getLocation() {
        return this.zznb;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbnr;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zzcje.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls) {
        return this.zzciz.getBundle(cls.getName());
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzciz.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final String getPublisherProvidedId() {
        return this.zzcgw;
    }

    public final String zzqk() {
        return this.zzchc;
    }

    public final SearchAdRequest zzql() {
        return this.zzcjf;
    }

    public final boolean isTestDevice(Context context) {
        RequestConfiguration requestConfiguration = zzyt.zzqs().getRequestConfiguration();
        zzwg.zzps();
        String zzbn = zzbaq.zzbn(context);
        return this.zzcjg.contains(zzbn) || requestConfiguration.getTestDeviceIds().contains(zzbn);
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzqm() {
        return this.zzcje;
    }

    public final Bundle zzqn() {
        return this.zzciz;
    }

    public final int zzqo() {
        return this.zzadg;
    }

    public final Bundle getCustomTargeting() {
        return this.zzcha;
    }

    public final Set<String> zzqp() {
        return this.zzcjh;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzche;
    }

    public final AdInfo zzqq() {
        return this.zzcjd;
    }

    public final int zzqr() {
        return this.zzadh;
    }

    public final String getMaxAdContentRating() {
        return this.zzadi;
    }
}
