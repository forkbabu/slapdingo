package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzari extends zzarc {
    private final /* synthetic */ UpdateClickUrlCallback zzdoy;

    zzari(zzarg zzarg, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zzdoy = updateClickUrlCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzaqz
    public final void onSuccess(List<Uri> list) {
        this.zzdoy.onSuccess(list.get(0));
    }

    @Override // com.google.android.gms.internal.ads.zzaqz
    public final void onError(String str) {
        this.zzdoy.onFailure(str);
    }
}
