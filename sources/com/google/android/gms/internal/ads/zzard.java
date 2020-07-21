package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzard extends zzawp {
    private final /* synthetic */ QueryInfoGenerationCallback zzdos;

    zzard(zzare zzare, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zzdos = queryInfoGenerationCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzawq
    public final void zzk(String str, String str2) {
        QueryInfo queryInfo = new QueryInfo(new zzzd(str, null));
        zzwg.zzqa().put(queryInfo, str2);
        this.zzdos.onSuccess(queryInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzawq
    public final void onError(String str) {
        this.zzdos.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzawq
    public final void zza(String str, String str2, Bundle bundle) {
        QueryInfo queryInfo = new QueryInfo(new zzzd(str, bundle));
        zzwg.zzqa().put(queryInfo, str2);
        this.zzdos.onSuccess(queryInfo);
    }
}
