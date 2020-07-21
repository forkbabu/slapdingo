package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzecs extends zzecr {
    zzecs(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzecr
    public final int zzbcl() {
        return 12;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzecr
    public final int[] zzb(int[] iArr, int i) {
        if (iArr.length == 3) {
            int[] iArr2 = new int[16];
            zzecr.zza(iArr2, this.zzhxf);
            iArr2[12] = i;
            System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
    }
}
