package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbem extends zzbm {
    static final zzbem zzekb = new zzbem();

    zzbem() {
    }

    @Override // com.google.android.gms.internal.ads.zzbm
    public final zzbp zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbr();
        }
        if ("mvhd".equals(str)) {
            return new zzbu();
        }
        return new zzbt(str);
    }
}
