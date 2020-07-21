package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzblp {
    /* access modifiers changed from: private */
    public final Executor executor;
    private final String zzbpm;
    private final zzalw zzfle;
    /* access modifiers changed from: private */
    public zzblu zzflf;
    private final zzahc<Object> zzflg = new zzblo(this);
    private final zzahc<Object> zzflh = new zzblq(this);

    public zzblp(String str, zzalw zzalw, Executor executor2) {
        this.zzbpm = str;
        this.zzfle = zzalw;
        this.executor = executor2;
    }

    public final void zza(zzblu zzblu) {
        this.zzfle.zzc("/updateActiveView", this.zzflg);
        this.zzfle.zzc("/untrackActiveViewUnit", this.zzflh);
        this.zzflf = zzblu;
    }

    public final void zzd(zzbfn zzbfn) {
        zzbfn.zza("/updateActiveView", this.zzflg);
        zzbfn.zza("/untrackActiveViewUnit", this.zzflh);
    }

    public final void zze(zzbfn zzbfn) {
        zzbfn.zzb("/updateActiveView", this.zzflg);
        zzbfn.zzb("/untrackActiveViewUnit", this.zzflh);
    }

    public final void zzags() {
        this.zzfle.zzd("/updateActiveView", this.zzflg);
        this.zzfle.zzd("/untrackActiveViewUnit", this.zzflh);
    }

    /* access modifiers changed from: private */
    public final boolean zzm(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        if (TextUtils.isEmpty(str) || !str.equals(this.zzbpm)) {
            return false;
        }
        return true;
    }
}
