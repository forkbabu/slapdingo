package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeet implements Comparator<zzeer> {
    zzeet() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzeer zzeer, zzeer zzeer2) {
        zzeer zzeer3 = zzeer;
        zzeer zzeer4 = zzeer2;
        zzeew zzeew = (zzeew) zzeer3.iterator();
        zzeew zzeew2 = (zzeew) zzeer4.iterator();
        while (zzeew.hasNext() && zzeew2.hasNext()) {
            int compare = Integer.compare(zzeer.zzb(zzeew.nextByte()), zzeer.zzb(zzeew2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzeer3.size(), zzeer4.size());
    }
}
