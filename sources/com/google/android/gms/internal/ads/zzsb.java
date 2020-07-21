package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzsb implements Comparator<zzrp> {
    public zzsb(zzry zzry) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzrp zzrp, zzrp zzrp2) {
        zzrp zzrp3 = zzrp;
        zzrp zzrp4 = zzrp2;
        if (zzrp3.zzmo() < zzrp4.zzmo()) {
            return -1;
        }
        if (zzrp3.zzmo() > zzrp4.zzmo()) {
            return 1;
        }
        if (zzrp3.zzmn() < zzrp4.zzmn()) {
            return -1;
        }
        if (zzrp3.zzmn() > zzrp4.zzmn()) {
            return 1;
        }
        float zzmq = (zzrp3.zzmq() - zzrp3.zzmo()) * (zzrp3.zzmp() - zzrp3.zzmn());
        float zzmq2 = (zzrp4.zzmq() - zzrp4.zzmo()) * (zzrp4.zzmp() - zzrp4.zzmn());
        if (zzmq > zzmq2) {
            return -1;
        }
        if (zzmq < zzmq2) {
            return 1;
        }
        return 0;
    }
}
