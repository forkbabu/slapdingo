package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzrq implements Comparator<zzrw> {
    zzrq(zzrr zzrr) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzrw zzrw, zzrw zzrw2) {
        zzrw zzrw3 = zzrw;
        zzrw zzrw4 = zzrw2;
        int i = zzrw3.zzbtt - zzrw4.zzbtt;
        if (i != 0) {
            return i;
        }
        return (int) (zzrw3.value - zzrw4.value);
    }
}
