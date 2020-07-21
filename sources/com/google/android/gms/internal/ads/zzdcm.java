package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdcm implements zzdec<zzdcj> {
    private final zzdvi zzgri;
    private final Set<String> zzgrw;
    private final Context zzvr;

    public zzdcm(zzdvi zzdvi, Context context, Set<String> set) {
        this.zzgri = zzdvi;
        this.zzvr = context;
        this.zzgrw = set;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdcj> zzaqm() {
        return this.zzgri.zze(new zzdcl(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdcj zzaqv() throws Exception {
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzctk)).booleanValue() || !zzdcj.zze(this.zzgrw)) {
            return new zzdcj(null);
        }
        return new zzdcj(zzq.zzll().getVersion(this.zzvr));
    }
}
