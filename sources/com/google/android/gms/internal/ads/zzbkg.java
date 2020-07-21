package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbkg extends zzxl {
    private final zzbbd zzboy;
    private final zzavy zzbqt;
    private final zzcix zzfjr;
    private final zzcqu<zzdlm, zzcsc> zzfjs;
    private final zzcwj zzfjt;
    private final zzclx zzfju;
    private final zzciz zzfjv;
    private final Context zzvr;
    private boolean zzzg = false;

    zzbkg(Context context, zzbbd zzbbd, zzcix zzcix, zzcqu<zzdlm, zzcsc> zzcqu, zzcwj zzcwj, zzclx zzclx, zzavy zzavy, zzciz zzciz) {
        this.zzvr = context;
        this.zzboy = zzbbd;
        this.zzfjr = zzcix;
        this.zzfjs = zzcqu;
        this.zzfjt = zzcwj;
        this.zzfju = zzclx;
        this.zzbqt = zzavy;
        this.zzfjv = zzciz;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005c, code lost:
        return;
     */
    @Override // com.google.android.gms.internal.ads.zzxm
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void initialize() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzzg     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "Mobile ads is initialized already."
            com.google.android.gms.internal.ads.zzaxv.zzfd(r0)     // Catch:{ all -> 0x005d }
            monitor-exit(r3)
            return
        L_0x000c:
            android.content.Context r0 = r3.zzvr
            com.google.android.gms.internal.ads.zzaav.initialize(r0)
            com.google.android.gms.internal.ads.zzaxh r0 = com.google.android.gms.ads.internal.zzq.zzla()
            android.content.Context r1 = r3.zzvr
            com.google.android.gms.internal.ads.zzbbd r2 = r3.zzboy
            r0.zzd(r1, r2)
            com.google.android.gms.internal.ads.zzsq r0 = com.google.android.gms.ads.internal.zzq.zzlc()
            android.content.Context r1 = r3.zzvr
            r0.initialize(r1)
            r0 = 1
            r3.zzzg = r0
            com.google.android.gms.internal.ads.zzclx r0 = r3.zzfju
            r0.zzaoq()
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaav.zzcpq
            com.google.android.gms.internal.ads.zzaar r1 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzcwj r0 = r3.zzfjt
            r0.zzann()
        L_0x0044:
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaav.zzcrz
            com.google.android.gms.internal.ads.zzaar r1 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzciz r0 = r3.zzfjv
            r0.zzann()
        L_0x005b:
            monitor-exit(r3)
            return
        L_0x005d:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbkg.initialize():void");
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final synchronized void setAppVolume(float f) {
        zzq.zzlb().setAppVolume(f);
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final synchronized float zzqc() {
        return zzq.zzlb().zzqc();
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final synchronized void setAppMuted(boolean z) {
        zzq.zzlb().setAppMuted(z);
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final synchronized boolean zzqd() {
        return zzq.zzlb().zzqd();
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final synchronized void zzcg(String str) {
        zzaav.initialize(this.zzvr);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcry)).booleanValue()) {
                zzq.zzle().zza(this.zzvr, this.zzboy, str, (Runnable) null);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzaxv.zzfb("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzaxv.zzfb("Context is null. Failed to open debug menu.");
            return;
        }
        zzayv zzayv = new zzayv(context);
        zzayv.setAdUnitId(str);
        zzayv.zzad(this.zzboy.zzbpn);
        zzayv.showDialog();
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zza(String str, IObjectWrapper iObjectWrapper) {
        String str2;
        zzaav.initialize(this.zzvr);
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcsa)).booleanValue()) {
            zzq.zzkw();
            str2 = zzaye.zzbe(this.zzvr);
        } else {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            boolean booleanValue = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcry)).booleanValue() | ((Boolean) zzwg.zzpw().zzd(zzaav.zzcny)).booleanValue();
            zzbkj zzbkj = null;
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcny)).booleanValue()) {
                booleanValue = true;
                zzbkj = new zzbkj(this, (Runnable) ObjectWrapper.unwrap(iObjectWrapper));
            }
            if (booleanValue) {
                zzq.zzle().zza(this.zzvr, this.zzboy, str, zzbkj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final String getVersionString() {
        return this.zzboy.zzbpn;
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzch(String str) {
        this.zzfjt.zzgp(str);
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zza(zzamr zzamr) throws RemoteException {
        this.zzfjr.zzb(zzamr);
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zza(zzaij zzaij) throws RemoteException {
        this.zzfju.zzb(zzaij);
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final List<zzaic> zzqe() throws RemoteException {
        return this.zzfju.zzaor();
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zza(zzzu zzzu) throws RemoteException {
        this.zzbqt.zza(this.zzvr, zzzu);
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzqf() {
        this.zzfju.disable();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzamm> zzwm = zzq.zzla().zzwe().zzwz().zzwm();
        if (zzwm != null && !zzwm.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzaxv.zzd("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzfjr.zzanl()) {
                HashMap hashMap = new HashMap();
                for (zzamm zzamm : zzwm.values()) {
                    for (zzamn zzamn : zzamm.zzdid) {
                        String str = zzamn.zzdji;
                        for (String str2 : zzamn.zzdja) {
                            if (!hashMap.containsKey(str2)) {
                                hashMap.put(str2, new ArrayList());
                            }
                            if (str != null) {
                                ((Collection) hashMap.get(str2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str3 = (String) entry.getKey();
                    try {
                        zzcqv<zzdlm, zzcsc> zzf = this.zzfjs.zzf(str3, jSONObject);
                        if (zzf != null) {
                            AdapterT adaptert = zzf.zzdka;
                            if (!adaptert.isInitialized()) {
                                if (adaptert.zzto()) {
                                    adaptert.zza(this.zzvr, zzf.zzgki, (List) entry.getValue());
                                    String valueOf = String.valueOf(str3);
                                    zzaxv.zzee(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                                }
                            }
                        }
                    } catch (zzdlg e) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 56);
                        sb.append("Failed to initialize rewarded video mediation adapter \"");
                        sb.append(str3);
                        sb.append("\"");
                        zzaxv.zzd(sb.toString(), e);
                    }
                }
            }
        }
    }
}
