package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzecz {
    private final zzedq zzhxq;
    private final zzedq zzhxr;

    public zzecz(byte[] bArr, byte[] bArr2) {
        this.zzhxq = zzedq.zzs(bArr);
        this.zzhxr = zzedq.zzs(bArr2);
    }

    public final byte[] zzbcm() {
        zzedq zzedq = this.zzhxq;
        if (zzedq == null) {
            return null;
        }
        return zzedq.getBytes();
    }

    public final byte[] zzbcn() {
        zzedq zzedq = this.zzhxr;
        if (zzedq == null) {
            return null;
        }
        return zzedq.getBytes();
    }
}
