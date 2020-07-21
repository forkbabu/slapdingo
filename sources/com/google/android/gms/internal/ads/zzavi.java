package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzejv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzavi implements zzavr {
    /* access modifiers changed from: private */
    public static List<Future<Void>> zzdvf = Collections.synchronizedList(new ArrayList());
    private final Object lock = new Object();
    private final zzavq zzdrz;
    private final zzejv.zzb.zza zzdvg;
    private final LinkedHashMap<String, zzejv.zzb.zzh.C0016zzb> zzdvh;
    private final List<String> zzdvi = new ArrayList();
    private final List<String> zzdvj = new ArrayList();
    private final zzavt zzdvk;
    private boolean zzdvl;
    private final zzavw zzdvm;
    private HashSet<String> zzdvn = new HashSet<>();
    private boolean zzdvo = false;
    private boolean zzdvp = false;
    private boolean zzdvq = false;
    private final Context zzvr;

    public zzavi(Context context, zzbbd zzbbd, zzavq zzavq, String str, zzavt zzavt) {
        Preconditions.checkNotNull(zzavq, "SafeBrowsing config is not present.");
        this.zzvr = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdvh = new LinkedHashMap<>();
        this.zzdvk = zzavt;
        this.zzdrz = zzavq;
        for (String str2 : zzavq.zzdvy) {
            this.zzdvn.add(str2.toLowerCase(Locale.ENGLISH));
        }
        this.zzdvn.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzejv.zzb.zza zzbij = zzejv.zzb.zzbij();
        zzbij.zza(zzejv.zzb.zzg.OCTAGON_AD);
        zzbij.zzhw(str);
        zzbij.zzhx(str);
        zzejv.zzb.C0012zzb.zza zzbil = zzejv.zzb.C0012zzb.zzbil();
        if (this.zzdrz.zzdvu != null) {
            zzbil.zzia(this.zzdrz.zzdvu);
        }
        zzbij.zza((zzejv.zzb.C0012zzb) ((zzegb) zzbil.zzbfq()));
        zzejv.zzb.zzi.zza zzbx = zzejv.zzb.zzi.zzbiz().zzbx(Wrappers.packageManager(this.zzvr).isCallerInstantApp());
        if (zzbbd.zzbpn != null) {
            zzbx.zzih(zzbbd.zzbpn);
        }
        long apkVersion = (long) GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzvr);
        if (apkVersion > 0) {
            zzbx.zzfu(apkVersion);
        }
        zzbij.zza((zzejv.zzb.zzi) ((zzegb) zzbx.zzbfq()));
        this.zzdvg = zzbij;
        this.zzdvm = new zzavw(this.zzvr, this.zzdrz.zzdwb, this);
    }

    static final /* synthetic */ Void zzed(String str) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final zzavq zzvi() {
        return this.zzdrz;
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zzdz(String str) {
        synchronized (this.lock) {
            if (str == null) {
                this.zzdvg.zzbih();
            } else {
                this.zzdvg.zzhy(str);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final boolean zzvj() {
        return PlatformVersion.isAtLeastKitKat() && this.zzdrz.zzdvw && !this.zzdvp;
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zzl(View view) {
        if (this.zzdrz.zzdvw && !this.zzdvp) {
            zzq.zzkw();
            Bitmap zzn = zzaye.zzn(view);
            if (zzn == null) {
                zzavs.zzee("Failed to capture the webview bitmap.");
                return;
            }
            this.zzdvp = true;
            zzaye.zzc(new zzavh(this, zzn));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return;
     */
    @Override // com.google.android.gms.internal.ads.zzavr
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            r1 = 3
            if (r9 != r1) goto L_0x0009
            r2 = 1
            r6.zzdvq = r2     // Catch:{ all -> 0x00bd }
        L_0x0009:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzejv$zzb$zzh$zzb> r2 = r6.zzdvh     // Catch:{ all -> 0x00bd }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x0024
            if (r9 != r1) goto L_0x0022
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzejv$zzb$zzh$zzb> r8 = r6.zzdvh     // Catch:{ all -> 0x00bd }
            java.lang.Object r7 = r8.get(r7)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzejv$zzb$zzh$zzb r7 = (com.google.android.gms.internal.ads.zzejv.zzb.zzh.C0016zzb) r7     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzejv$zzb$zzh$zza r8 = com.google.android.gms.internal.ads.zzejv.zzb.zzh.zza.zzhv(r9)     // Catch:{ all -> 0x00bd }
            r7.zzb(r8)     // Catch:{ all -> 0x00bd }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            return
        L_0x0024:
            com.google.android.gms.internal.ads.zzejv$zzb$zzh$zzb r1 = com.google.android.gms.internal.ads.zzejv.zzb.zzh.zzbix()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzejv$zzb$zzh$zza r9 = com.google.android.gms.internal.ads.zzejv.zzb.zzh.zza.zzhv(r9)     // Catch:{ all -> 0x00bd }
            if (r9 == 0) goto L_0x0031
            r1.zzb(r9)     // Catch:{ all -> 0x00bd }
        L_0x0031:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzejv$zzb$zzh$zzb> r9 = r6.zzdvh     // Catch:{ all -> 0x00bd }
            int r9 = r9.size()     // Catch:{ all -> 0x00bd }
            r1.zzhw(r9)     // Catch:{ all -> 0x00bd }
            r1.zzif(r7)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzejv$zzb$zzd$zza r9 = com.google.android.gms.internal.ads.zzejv.zzb.zzd.zzbip()     // Catch:{ all -> 0x00bd }
            java.util.HashSet<java.lang.String> r2 = r6.zzdvn     // Catch:{ all -> 0x00bd }
            int r2 = r2.size()     // Catch:{ all -> 0x00bd }
            if (r2 <= 0) goto L_0x00ab
            if (r8 == 0) goto L_0x00ab
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x00bd }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00bd }
        L_0x0053:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x00ab
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x00bd }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00bd }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00bd }
            if (r3 == 0) goto L_0x006c
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00bd }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00bd }
            goto L_0x006e
        L_0x006c:
            java.lang.String r3 = ""
        L_0x006e:
            java.lang.Object r4 = r2.getValue()     // Catch:{ all -> 0x00bd }
            if (r4 == 0) goto L_0x007b
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00bd }
            goto L_0x007d
        L_0x007b:
            java.lang.String r2 = ""
        L_0x007d:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = r3.toLowerCase(r4)     // Catch:{ all -> 0x00bd }
            java.util.HashSet<java.lang.String> r5 = r6.zzdvn     // Catch:{ all -> 0x00bd }
            boolean r4 = r5.contains(r4)     // Catch:{ all -> 0x00bd }
            if (r4 == 0) goto L_0x0053
            com.google.android.gms.internal.ads.zzejv$zzb$zzc$zza r4 = com.google.android.gms.internal.ads.zzejv.zzb.zzc.zzbin()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeer r3 = com.google.android.gms.internal.ads.zzeer.zzhs(r3)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzejv$zzb$zzc$zza r3 = r4.zzan(r3)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeer r2 = com.google.android.gms.internal.ads.zzeer.zzhs(r2)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzejv$zzb$zzc$zza r2 = r3.zzao(r2)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzehl r2 = r2.zzbfq()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzegb r2 = (com.google.android.gms.internal.ads.zzegb) r2     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzejv$zzb$zzc r2 = (com.google.android.gms.internal.ads.zzejv.zzb.zzc) r2     // Catch:{ all -> 0x00bd }
            r9.zza(r2)     // Catch:{ all -> 0x00bd }
            goto L_0x0053
        L_0x00ab:
            com.google.android.gms.internal.ads.zzehl r8 = r9.zzbfq()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzegb r8 = (com.google.android.gms.internal.ads.zzegb) r8     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzejv$zzb$zzd r8 = (com.google.android.gms.internal.ads.zzejv.zzb.zzd) r8     // Catch:{ all -> 0x00bd }
            r1.zzb(r8)     // Catch:{ all -> 0x00bd }
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzejv$zzb$zzh$zzb> r8 = r6.zzdvh     // Catch:{ all -> 0x00bd }
            r8.put(r7, r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            return
        L_0x00bd:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavi.zza(java.lang.String, java.util.Map, int):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzea(String str) {
        synchronized (this.lock) {
            this.zzdvi.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzeb(String str) {
        synchronized (this.lock) {
            this.zzdvj.add(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final String[] zza(String[] strArr) {
        return (String[]) this.zzdvm.zzb(strArr).toArray(new String[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zzvk() {
        this.zzdvo = true;
    }

    private final zzejv.zzb.zzh.C0016zzb zzec(String str) {
        zzejv.zzb.zzh.C0016zzb zzb;
        synchronized (this.lock) {
            zzb = this.zzdvh.get(str);
        }
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zzvl() {
        synchronized (this.lock) {
            zzdvf zzb = zzdux.zzb(this.zzdvk.zza(this.zzvr, this.zzdvh.keySet()), new zzavk(this), zzbbf.zzedm);
            zzdvf zza = zzdux.zza(zzb, 10, TimeUnit.SECONDS, zzbbf.zzedk);
            zzdux.zza(zzb, new zzavl(this, zza), zzbbf.zzedm);
            zzdvf.add(zza);
        }
    }

    private final zzdvf<Void> zzvm() {
        zzdvf<Void> zzb;
        if (!((this.zzdvl && this.zzdrz.zzdwa) || (this.zzdvq && this.zzdrz.zzdvz) || (!this.zzdvl && this.zzdrz.zzdvx))) {
            return zzdux.zzaf(null);
        }
        synchronized (this.lock) {
            for (zzejv.zzb.zzh.C0016zzb zzb2 : this.zzdvh.values()) {
                this.zzdvg.zza((zzejv.zzb.zzh) ((zzegb) zzb2.zzbfq()));
            }
            this.zzdvg.zzm(this.zzdvi);
            this.zzdvg.zzn(this.zzdvj);
            if (zzavs.isEnabled()) {
                String url = this.zzdvg.getUrl();
                String zzbig = this.zzdvg.zzbig();
                StringBuilder sb = new StringBuilder(String.valueOf(url).length() + 53 + String.valueOf(zzbig).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(url);
                sb.append("\n  clickUrl: ");
                sb.append(zzbig);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzejv.zzb.zzh zzh : this.zzdvg.zzbif()) {
                    sb2.append("    [");
                    sb2.append(zzh.zzbiw());
                    sb2.append("] ");
                    sb2.append(zzh.getUrl());
                }
                zzavs.zzee(sb2.toString());
            }
            zzdvf<String> zza = new zzazq(this.zzvr).zza(1, this.zzdrz.zzdvv, null, ((zzejv.zzb) ((zzegb) this.zzdvg.zzbfq())).toByteArray());
            if (zzavs.isEnabled()) {
                zza.addListener(zzavj.zzdvr, zzbbf.zzedh);
            }
            zzb = zzdux.zzb(zza, zzavm.zzdvt, zzbbf.zzedm);
        }
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzi(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.lock) {
                            int length = optJSONArray.length();
                            zzejv.zzb.zzh.C0016zzb zzec = zzec(str);
                            if (zzec == null) {
                                String valueOf = String.valueOf(str);
                                zzavs.zzee(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                boolean z = false;
                                for (int i = 0; i < length; i++) {
                                    zzec.zzig(optJSONArray.getJSONObject(i).getString("threat_type"));
                                }
                                boolean z2 = this.zzdvl;
                                if (length > 0) {
                                    z = true;
                                }
                                this.zzdvl = z | z2;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (zzacr.zzdbc.get().booleanValue()) {
                    zzaxv.zzb("Failed to get SafeBrowsing metadata", e);
                }
                return zzdux.immediateFailedFuture(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zzdvl) {
            synchronized (this.lock) {
                this.zzdvg.zza(zzejv.zzb.zzg.OCTAGON_AD_SB_MATCH);
            }
        }
        return zzvm();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Bitmap bitmap) {
        zzefa zzbdf = zzeer.zzbdf();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzbdf);
        synchronized (this.lock) {
            this.zzdvg.zza((zzejv.zzb.zzf) ((zzegb) zzejv.zzb.zzf.zzbiu().zzaq(zzbdf.zzbct()).zzic("image/png").zza(zzejv.zzb.zzf.C0015zzb.TYPE_CREATIVE).zzbfq()));
        }
    }
}
