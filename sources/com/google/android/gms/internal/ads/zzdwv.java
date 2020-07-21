package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzehl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzdwv<KeyProtoT extends zzehl, PublicKeyProtoT extends zzehl> extends zzdwj<KeyProtoT> {
    private final Class<PublicKeyProtoT> zzhpz;

    @SafeVarargs
    protected zzdwv(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, zzdwl<?, KeyProtoT>... zzdwlArr) {
        super(cls, zzdwlArr);
        this.zzhpz = cls2;
    }
}
