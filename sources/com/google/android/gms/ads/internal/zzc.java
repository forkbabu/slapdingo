package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzarx;
import com.google.android.gms.internal.ads.zzavr;
import com.google.android.gms.internal.ads.zzaye;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzc {
    private boolean zzboe;
    private zzavr zzbof;
    private zzarx zzbog = null;
    private final Context zzvr;

    public zzc(Context context, zzavr zzavr, zzarx zzarx) {
        this.zzvr = context;
        this.zzbof = zzavr;
        if (0 == 0) {
            this.zzbog = new zzarx();
        }
    }

    private final boolean zzjx() {
        zzavr zzavr = this.zzbof;
        return (zzavr != null && zzavr.zzvi().zzdvz) || this.zzbog.zzdsj;
    }

    public final void recordClick() {
        this.zzboe = true;
    }

    public final boolean zzjy() {
        return !zzjx() || this.zzboe;
    }

    public final void zzbn(String str) {
        if (zzjx()) {
            if (str == null) {
                str = "";
            }
            zzavr zzavr = this.zzbof;
            if (zzavr != null) {
                zzavr.zza(str, null, 3);
            } else if (this.zzbog.zzdsj && this.zzbog.zzdsk != null) {
                for (String str2 : this.zzbog.zzdsk) {
                    if (!TextUtils.isEmpty(str2)) {
                        String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzq.zzkw();
                        zzaye.zzb(this.zzvr, "", replace);
                    }
                }
            }
        }
    }
}
