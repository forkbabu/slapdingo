package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
abstract class zzjy {
    zzjy() {
    }

    /* access modifiers changed from: package-private */
    public abstract int zzb(int i, byte[] bArr, int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract int zzb(CharSequence charSequence, byte[] bArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract String zzh(byte[] bArr, int i, int i2) throws zzhh;

    /* access modifiers changed from: package-private */
    public final boolean zzf(byte[] bArr, int i, int i2) {
        return zzb(0, bArr, i, i2) == 0;
    }
}
