package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcdo {
    private final zzccs zzfvy;
    private final zzcgr zzfyt;
    private final zzchw zzfyz;
    private final zzbmh zzfza;

    public zzcdo(zzchw zzchw, zzcgr zzcgr, zzbmh zzbmh, zzccs zzccs) {
        this.zzfyz = zzchw;
        this.zzfyt = zzcgr;
        this.zzfza = zzbmh;
        this.zzfvy = zzccs;
    }

    public final View zzamr() throws zzbfz {
        zzbfn zza = this.zzfyz.zza(zzvh.zzph(), false);
        zza.getView().setVisibility(8);
        zza.zza("/sendMessageToSdk", new zzcdr(this));
        zza.zza("/adMuted", new zzcdq(this));
        this.zzfyt.zza(new WeakReference(zza), "/loadHtml", new zzcdt(this));
        this.zzfyt.zza(new WeakReference(zza), "/showOverlay", new zzcds(this));
        this.zzfyt.zza(new WeakReference(zza), "/hideOverlay", new zzcdv(this));
        return zza.getView();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbfn zzbfn, Map map) {
        zzaxv.zzfc("Hiding native ads overlay.");
        zzbfn.getView().setVisibility(8);
        this.zzfza.zzbf(false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbfn zzbfn, Map map) {
        zzaxv.zzfc("Showing native ads overlay.");
        zzbfn.getView().setVisibility(0);
        this.zzfza.zzbf(true);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzfyt.zza("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbfn zzbfn, Map map) {
        this.zzfvy.zzakw();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzbfn zzbfn, Map map) {
        this.zzfyt.zza("sendMessageToNativeJs", map);
    }
}
