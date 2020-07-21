package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzehl;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdwk<KeyFormatProtoT extends zzehl, KeyProtoT extends zzehl> {
    private final zzdwm<KeyFormatProtoT, KeyProtoT> zzhpp;

    zzdwk(zzdwm<KeyFormatProtoT, KeyProtoT> zzdwm) {
        this.zzhpp = zzdwm;
    }

    /* access modifiers changed from: package-private */
    public final KeyProtoT zzq(zzeer zzeer) throws GeneralSecurityException, zzegl {
        KeyFormatProtoT zzr = this.zzhpp.zzr(zzeer);
        this.zzhpp.zzd(zzr);
        return this.zzhpp.zze(zzr);
    }
}
