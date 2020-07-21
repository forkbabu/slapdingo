package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zziu implements zzif {
    private final int flags;
    private final String info;
    private final Object[] zzzk;
    private final zzih zzzn;

    zziu(zzih zzih, String str, Object[] objArr) {
        this.zzzn = zzih;
        this.info = str;
        this.zzzk = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzhq() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzhr() {
        return this.zzzk;
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final zzih zzhl() {
        return this.zzzn;
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final int zzhj() {
        return (this.flags & 1) == 1 ? zzgx.zzf.zzxi : zzgx.zzf.zzxj;
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final boolean zzhk() {
        return (this.flags & 2) == 2;
    }
}
