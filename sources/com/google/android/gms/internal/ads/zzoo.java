package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzoo implements zzoi {
    private final boolean zzbhv;
    private final int zzbhw;
    private final byte[] zzbhx;
    private final zzoj[] zzbhy;
    private int zzbhz;
    private int zzbia;
    private int zzbib;
    private zzoj[] zzbic;

    public zzoo(boolean z, int i) {
        this(true, 65536, 0);
    }

    private zzoo(boolean z, int i, int i2) {
        zzpb.checkArgument(true);
        zzpb.checkArgument(true);
        this.zzbhv = true;
        this.zzbhw = 65536;
        this.zzbib = 0;
        this.zzbic = new zzoj[100];
        this.zzbhx = null;
        this.zzbhy = new zzoj[1];
    }

    public final synchronized void reset() {
        if (this.zzbhv) {
            zzbh(0);
        }
    }

    public final synchronized void zzbh(int i) {
        boolean z = i < this.zzbhz;
        this.zzbhz = i;
        if (z) {
            zzn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoi
    public final synchronized zzoj zzim() {
        zzoj zzoj;
        this.zzbia++;
        if (this.zzbib > 0) {
            zzoj[] zzojArr = this.zzbic;
            int i = this.zzbib - 1;
            this.zzbib = i;
            zzoj = zzojArr[i];
            this.zzbic[i] = null;
        } else {
            zzoj = new zzoj(new byte[this.zzbhw], 0);
        }
        return zzoj;
    }

    @Override // com.google.android.gms.internal.ads.zzoi
    public final synchronized void zza(zzoj zzoj) {
        this.zzbhy[0] = zzoj;
        zza(this.zzbhy);
    }

    @Override // com.google.android.gms.internal.ads.zzoi
    public final synchronized void zza(zzoj[] zzojArr) {
        boolean z;
        if (this.zzbib + zzojArr.length >= this.zzbic.length) {
            this.zzbic = (zzoj[]) Arrays.copyOf(this.zzbic, Math.max(this.zzbic.length << 1, this.zzbib + zzojArr.length));
        }
        for (zzoj zzoj : zzojArr) {
            if (zzoj.data != null) {
                if (zzoj.data.length != this.zzbhw) {
                    z = false;
                    zzpb.checkArgument(z);
                    zzoj[] zzojArr2 = this.zzbic;
                    int i = this.zzbib;
                    this.zzbib = i + 1;
                    zzojArr2[i] = zzoj;
                }
            }
            z = true;
            zzpb.checkArgument(z);
            zzoj[] zzojArr22 = this.zzbic;
            int i2 = this.zzbib;
            this.zzbib = i2 + 1;
            zzojArr22[i2] = zzoj;
        }
        this.zzbia -= zzojArr.length;
        notifyAll();
    }

    @Override // com.google.android.gms.internal.ads.zzoi
    public final synchronized void zzn() {
        int max = Math.max(0, zzpo.zzf(this.zzbhz, this.zzbhw) - this.zzbia);
        if (max < this.zzbib) {
            Arrays.fill(this.zzbic, max, this.zzbib, (Object) null);
            this.zzbib = max;
        }
    }

    public final synchronized int zzip() {
        return this.zzbia * this.zzbhw;
    }

    @Override // com.google.android.gms.internal.ads.zzoi
    public final int zzin() {
        return this.zzbhw;
    }
}
