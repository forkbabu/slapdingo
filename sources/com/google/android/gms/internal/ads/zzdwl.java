package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzdwl<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> zzhpm;

    public zzdwl(Class<PrimitiveT> cls) {
        this.zzhpm = cls;
    }

    public abstract PrimitiveT zzag(KeyT keyt) throws GeneralSecurityException;

    /* access modifiers changed from: package-private */
    public final Class<PrimitiveT> zzaxi() {
        return this.zzhpm;
    }
}
