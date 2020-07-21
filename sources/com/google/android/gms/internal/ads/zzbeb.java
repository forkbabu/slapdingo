package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbeb implements zzon {
    private final byte[] zzdsp;
    private final zzon zzejt;

    zzbeb(zzon zzon, byte[] bArr) {
        this.zzejt = zzon;
        this.zzdsp = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final zzok zzio() {
        zzon zzon = this.zzejt;
        byte[] bArr = this.zzdsp;
        return new zzbei(new zzol(bArr), bArr.length, zzon.zzio());
    }
}
