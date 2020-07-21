package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzayi implements zzbar {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzeab;

    zzayi(zzaye zzaye, Context context, String str) {
        this.val$context = context;
        this.zzeab = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbar
    public final void zzer(String str) {
        zzq.zzkw();
        zzaye.zzb(this.val$context, this.zzeab, str);
    }
}
