package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbad extends zzaxr {
    private final String url;
    private final zzbbe zzebx;

    public zzbad(Context context, String str, String str2) {
        this(str2, zzq.zzkw().zzs(context, str));
    }

    private zzbad(String str, String str2) {
        this.zzebx = new zzbbe(str2);
        this.url = str;
    }

    @Override // com.google.android.gms.internal.ads.zzaxr
    public final void zzut() {
        this.zzebx.zzer(this.url);
    }
}
