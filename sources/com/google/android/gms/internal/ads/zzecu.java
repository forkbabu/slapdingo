package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzecu extends zzect {
    public zzecu(byte[] bArr) throws InvalidKeyException {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzect
    public final zzecr zze(byte[] bArr, int i) throws InvalidKeyException {
        return new zzecs(bArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdwc, com.google.android.gms.internal.ads.zzect
    public final /* bridge */ /* synthetic */ byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return super.zzc(bArr, bArr2);
    }
}
