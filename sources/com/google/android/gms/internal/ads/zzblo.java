package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzblo implements zzahc<Object> {
    final /* synthetic */ zzblp zzfld;

    zzblo(zzblp zzblp) {
        this.zzfld = zzblp;
    }

    @Override // com.google.android.gms.internal.ads.zzahc
    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzfld.zzm(map)) {
            this.zzfld.executor.execute(new zzblr(this));
        }
    }
}
