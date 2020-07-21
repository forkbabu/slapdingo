package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzehl;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzdwm<KeyFormatProtoT extends zzehl, KeyT> {
    private final Class<KeyFormatProtoT> zzhpm;

    public zzdwm(Class<KeyFormatProtoT> cls) {
        this.zzhpm = cls;
    }

    public abstract void zzd(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public abstract KeyT zze(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public abstract KeyFormatProtoT zzr(zzeer zzeer) throws zzegl;

    public final Class<KeyFormatProtoT> zzaxp() {
        return this.zzhpm;
    }
}
