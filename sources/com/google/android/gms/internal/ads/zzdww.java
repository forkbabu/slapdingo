package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzehl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdww<PrimitiveT, KeyProtoT extends zzehl, PublicKeyProtoT extends zzehl> extends zzdwh<PrimitiveT, KeyProtoT> implements zzdwi<PrimitiveT> {
    private final zzdwv<KeyProtoT, PublicKeyProtoT> zzhqa;
    private final zzdwj<PublicKeyProtoT> zzhqb;

    public zzdww(zzdwv<KeyProtoT, PublicKeyProtoT> zzdwv, zzdwj<PublicKeyProtoT> zzdwj, Class<PrimitiveT> cls) {
        super(zzdwv, cls);
        this.zzhqa = zzdwv;
        this.zzhqb = zzdwj;
    }
}
