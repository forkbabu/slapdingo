package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzclx {
    private boolean enabled = true;
    /* access modifiers changed from: private */
    public final Executor executor;
    private final zzbbd zzbov;
    private final Context zzclc;
    private final Executor zzflp;
    private final ScheduledExecutorService zzfmo;
    private boolean zzgfh = false;
    /* access modifiers changed from: private */
    public boolean zzgfi = false;
    /* access modifiers changed from: private */
    public final long zzgfj;
    /* access modifiers changed from: private */
    public final zzbbn<Boolean> zzgfk = new zzbbn<>();
    private final WeakReference<Context> zzgfl;
    private final zzcix zzgfm;
    /* access modifiers changed from: private */
    public final zzclh zzgfn;
    private Map<String, zzaic> zzgfo = new ConcurrentHashMap();

    public zzclx(Executor executor2, Context context, WeakReference<Context> weakReference, Executor executor3, zzcix zzcix, ScheduledExecutorService scheduledExecutorService, zzclh zzclh, zzbbd zzbbd) {
        this.zzgfm = zzcix;
        this.zzclc = context;
        this.zzgfl = weakReference;
        this.executor = executor3;
        this.zzfmo = scheduledExecutorService;
        this.zzflp = executor2;
        this.zzgfn = zzclh;
        this.zzbov = zzbbd;
        this.zzgfj = zzq.zzld().elapsedRealtime();
        zza("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public final void disable() {
        this.enabled = false;
    }

    public final void zzb(zzaij zzaij) {
        this.zzgfk.addListener(new zzclw(this, zzaij), this.zzflp);
    }

    public final void zzaoq() {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcpt)).booleanValue() && !zzacm.zzdam.get().booleanValue()) {
            if (this.zzbov.zzede >= ((Integer) zzwg.zzpw().zzd(zzaav.zzcpu)).intValue() && this.enabled) {
                if (!this.zzgfh) {
                    synchronized (this) {
                        if (!this.zzgfh) {
                            this.zzgfn.zzaon();
                            this.zzgfk.addListener(new zzclz(this), this.executor);
                            this.zzgfh = true;
                            zzdvf<String> zzaos = zzaos();
                            this.zzfmo.schedule(new zzcmb(this), ((Long) zzwg.zzpw().zzd(zzaav.zzcpw)).longValue(), TimeUnit.SECONDS);
                            zzdux.zza(zzaos, new zzcme(this), this.executor);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.zzgfh) {
            zza("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zzgfk.set(false);
            this.zzgfh = true;
        }
    }

    public final List<zzaic> zzaor() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzgfo.keySet()) {
            zzaic zzaic = this.zzgfo.get(str);
            arrayList.add(new zzaic(str, zzaic.zzdes, zzaic.zzdet, zzaic.description));
        }
        return arrayList;
    }

    private final synchronized zzdvf<String> zzaos() {
        String zzwk = zzq.zzla().zzwe().zzwz().zzwk();
        if (!TextUtils.isEmpty(zzwk)) {
            return zzdux.zzaf(zzwk);
        }
        zzbbn zzbbn = new zzbbn();
        zzq.zzla().zzwe().zzb(new zzcly(this, zzbbn));
        return zzbbn;
    }

    /* access modifiers changed from: private */
    public final void zzgk(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            for (Iterator<String> keys = jSONObject.keys(); keys.hasNext(); keys = keys) {
                String next = keys.next();
                Object obj = new Object();
                zzbbn zzbbn = new zzbbn();
                zzdvf zza = zzdux.zza(zzbbn, ((Long) zzwg.zzpw().zzd(zzaav.zzcpv)).longValue(), TimeUnit.SECONDS, this.zzfmo);
                this.zzgfn.zzgi(next);
                long elapsedRealtime = zzq.zzld().elapsedRealtime();
                zza.addListener(new zzcma(this, obj, zzbbn, next, elapsedRealtime), this.executor);
                arrayList.add(zza);
                zzcmg zzcmg = new zzcmg(this, obj, next, elapsedRealtime, zzbbn);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString(DublinCoreProperties.FORMAT, "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzaim(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zza(next, false, "", 0);
                try {
                    this.zzflp.execute(new zzcmc(this, this.zzgfm.zzd(next, new JSONObject()), zzcmg, arrayList2, next));
                } catch (zzdlg unused2) {
                    try {
                        zzcmg.onInitializationFailed("Failed to create Adapter.");
                    } catch (RemoteException e) {
                        zzbba.zzc("", e);
                    }
                }
            }
            zzdux.zzj(arrayList).zza(new zzcmd(this), this.executor);
        } catch (JSONException e2) {
            zzaxv.zza("Malformed CLD response", e2);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(String str, boolean z, String str2, int i) {
        this.zzgfo.put(str, new zzaic(str, z, i, str2));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        com.google.android.gms.internal.ads.zzbba.zzc("", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 74);
        r4.append("Failed to initialize adapter. ");
        r4.append(r5);
        r4.append(" does not implement the initialize() method.");
        r3.onInitializationFailed(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzdlm r2, com.google.android.gms.internal.ads.zzaie r3, java.util.List r4, java.lang.String r5) {
        /*
            r1 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.zzgfl     // Catch:{ zzdlg -> 0x0011 }
            java.lang.Object r0 = r0.get()     // Catch:{ zzdlg -> 0x0011 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ zzdlg -> 0x0011 }
            if (r0 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            android.content.Context r0 = r1.zzclc     // Catch:{ zzdlg -> 0x0011 }
        L_0x000d:
            r2.zza(r0, r3, r4)     // Catch:{ zzdlg -> 0x0011 }
            return
        L_0x0011:
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2.length()     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2 + 74
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0035 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = "Failed to initialize adapter. "
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            r4.append(r5)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = " does not implement the initialize() method."
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = r4.toString()     // Catch:{ RemoteException -> 0x0035 }
            r3.onInitializationFailed(r2)     // Catch:{ RemoteException -> 0x0035 }
            return
        L_0x0035:
            r2 = move-exception
            java.lang.String r3 = ""
            com.google.android.gms.internal.ads.zzbba.zzc(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclx.zza(com.google.android.gms.internal.ads.zzdlm, com.google.android.gms.internal.ads.zzaie, java.util.List, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzaot() throws Exception {
        this.zzgfk.set(true);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzbbn zzbbn, String str, long j) {
        synchronized (obj) {
            if (!zzbbn.isDone()) {
                zza(str, false, "Timeout.", (int) (zzq.zzld().elapsedRealtime() - j));
                this.zzgfn.zzr(str, "timeout");
                zzbbn.set(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaou() {
        synchronized (this) {
            if (!this.zzgfi) {
                zza("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzq.zzld().elapsedRealtime() - this.zzgfj));
                this.zzgfk.setException(new Exception());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbbn zzbbn) {
        this.executor.execute(new zzcmf(this, zzbbn));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaov() {
        this.zzgfn.zzaoo();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzaij zzaij) {
        try {
            zzaij.zze(zzaor());
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }
}
