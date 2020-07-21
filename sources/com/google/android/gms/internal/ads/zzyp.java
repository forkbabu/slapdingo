package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzyp {
    /* access modifiers changed from: private */
    public int zzadg = -1;
    /* access modifiers changed from: private */
    public int zzadh = -1;
    /* access modifiers changed from: private */
    public String zzadi;
    /* access modifiers changed from: private */
    public boolean zzbnr = false;
    /* access modifiers changed from: private */
    public int zzcgt = -1;
    /* access modifiers changed from: private */
    public String zzcgw;
    /* access modifiers changed from: private */
    public String zzcgy;
    /* access modifiers changed from: private */
    public final Bundle zzcha = new Bundle();
    /* access modifiers changed from: private */
    public String zzchc;
    /* access modifiers changed from: private */
    public boolean zzche;
    /* access modifiers changed from: private */
    public final List<String> zzchf = new ArrayList();
    /* access modifiers changed from: private */
    public final HashSet<String> zzciy = new HashSet<>();
    /* access modifiers changed from: private */
    public final Bundle zzciz = new Bundle();
    /* access modifiers changed from: private */
    public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzcja = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzcjb = new HashSet<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzcjc = new HashSet<>();
    /* access modifiers changed from: private */
    public AdInfo zzcjd;
    /* access modifiers changed from: private */
    public Date zzmx;
    /* access modifiers changed from: private */
    public Location zznb;

    public final void zzci(String str) {
        this.zzciy.add(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.util.HashMap<java.lang.Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Class<?>} */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzcja.put(networkExtras.getClass(), networkExtras);
        }
    }

    public final void zza(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.zzciz.putBundle(cls.getName(), bundle);
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzciz.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzciz.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.zzciz.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzcj(String str) {
        this.zzcjb.add(str);
    }

    public final void zzck(String str) {
        this.zzcjb.remove(str);
    }

    @Deprecated
    public final void zza(Date date) {
        this.zzmx = date;
    }

    public final void zzcl(String str) {
        this.zzcgy = str;
    }

    public final void zzc(List<String> list) {
        this.zzchf.clear();
        for (String str : list) {
            if (TextUtils.isEmpty(str)) {
                zzbba.zzfd("neighboring content URL should not be null or empty");
            } else {
                this.zzchf.add(str);
            }
        }
    }

    @Deprecated
    public final void zzcy(int i) {
        this.zzcgt = i;
    }

    public final void zza(Location location) {
        this.zznb = location;
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbnr = z;
    }

    public final void zzcm(String str) {
        this.zzcgw = str;
    }

    public final void zzcn(String str) {
        this.zzchc = str;
    }

    @Deprecated
    public final void zzz(boolean z) {
        this.zzadg = z ? 1 : 0;
    }

    public final void zze(String str, String str2) {
        this.zzcha.putString(str, str2);
    }

    public final void zzco(String str) {
        this.zzcjc.add(str);
    }

    @Deprecated
    public final void zzaa(boolean z) {
        this.zzche = z;
    }

    public final void zza(AdInfo adInfo) {
        this.zzcjd = adInfo;
    }

    @Deprecated
    public final void zzcz(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.zzadh = i;
        }
    }

    @Deprecated
    public final void zzcp(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.zzadi = str;
        }
    }
}
