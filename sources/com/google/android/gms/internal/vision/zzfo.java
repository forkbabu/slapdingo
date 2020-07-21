package com.google.android.gms.internal.vision;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzfo implements Comparator<zzfm> {
    zzfo() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzfm zzfm, zzfm zzfm2) {
        zzfm zzfm3 = zzfm;
        zzfm zzfm4 = zzfm2;
        zzfv zzfv = (zzfv) zzfm3.iterator();
        zzfv zzfv2 = (zzfv) zzfm4.iterator();
        while (zzfv.hasNext() && zzfv2.hasNext()) {
            int compare = Integer.compare(zzfm.zza(zzfv.nextByte()), zzfm.zza(zzfv2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzfm3.size(), zzfm4.size());
    }
}
