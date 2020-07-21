package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcts {
    /* access modifiers changed from: private */
    public final Clock zzbqd;
    /* access modifiers changed from: private */
    public final zzctu zzgmh;
    private final List<String> zzgmi = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public final boolean zzgmj;

    public zzcts(Clock clock, zzctu zzctu) {
        this.zzbqd = clock;
        this.zzgmh = zzctu;
        this.zzgmj = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcws)).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final <T> zzdvf<T> zza(zzdkm zzdkm, zzdkk zzdkk, zzdvf<T> zzdvf) {
        long elapsedRealtime = this.zzbqd.elapsedRealtime();
        String str = zzdkk.zzdjb;
        if (str != null) {
            zzdux.zza(zzdvf, new zzctv(this, str, elapsedRealtime, zzdkk, zzdkm), zzbbf.zzedm);
        }
        return zzdvf;
    }

    /* access modifiers changed from: private */
    public final void zza(String str, int i, long j, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(j);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 1 + String.valueOf(str2).length());
            sb3.append(sb2);
            sb3.append(".");
            sb3.append(str2);
            sb2 = sb3.toString();
        }
        this.zzgmi.add(sb2);
    }

    public final String zzapp() {
        return TextUtils.join("_", this.zzgmi);
    }
}
