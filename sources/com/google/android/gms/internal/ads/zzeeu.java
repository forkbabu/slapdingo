package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeeu extends zzefb {
    private final int zzhzy;
    private final int zzhzz;

    zzeeu(byte[] bArr, int i, int i2) {
        super(bArr);
        zzi(i, i + i2, bArr.length);
        this.zzhzy = i;
        this.zzhzz = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzeer, com.google.android.gms.internal.ads.zzefb
    public final byte zzft(int i) {
        zzaa(i, size());
        return this.zziag[this.zzhzy + i];
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeer, com.google.android.gms.internal.ads.zzefb
    public final byte zzfu(int i) {
        return this.zziag[this.zzhzy + i];
    }

    @Override // com.google.android.gms.internal.ads.zzeer, com.google.android.gms.internal.ads.zzefb
    public final int size() {
        return this.zzhzz;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzefb
    public final int zzbdj() {
        return this.zzhzy;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeer, com.google.android.gms.internal.ads.zzefb
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zziag, zzbdj() + i, bArr, i2, i3);
    }
}
