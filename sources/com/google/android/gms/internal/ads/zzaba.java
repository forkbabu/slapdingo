package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaba {
    public static void zza(zzaay zzaay, zzaaz zzaaz) {
        if (zzaaz.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzaaz.zzks())) {
            zzaay.zza(zzaaz.getContext(), zzaaz.zzks(), zzaaz.zzrj(), zzaaz.zzrk());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
