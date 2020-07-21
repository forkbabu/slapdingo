package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzns implements zzod {
    private final int length;
    private int zzahp;
    private final zzhq[] zzbfj;
    private final zzno zzbgp;
    private final int[] zzbgq;
    private final long[] zzbgr;

    public zzns(zzno zzno, int... iArr) {
        int i = 0;
        zzpb.checkState(iArr.length > 0);
        this.zzbgp = (zzno) zzpb.checkNotNull(zzno);
        int length2 = iArr.length;
        this.length = length2;
        this.zzbfj = new zzhq[length2];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.zzbfj[i2] = zzno.zzbc(iArr[i2]);
        }
        Arrays.sort(this.zzbfj, new zznu());
        this.zzbgq = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (i < i3) {
                this.zzbgq[i] = zzno.zzh(this.zzbfj[i]);
                i++;
            } else {
                this.zzbgr = new long[i3];
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzod
    public final zzno zzik() {
        return this.zzbgp;
    }

    @Override // com.google.android.gms.internal.ads.zzod
    public final int length() {
        return this.zzbgq.length;
    }

    @Override // com.google.android.gms.internal.ads.zzod
    public final zzhq zzbc(int i) {
        return this.zzbfj[i];
    }

    @Override // com.google.android.gms.internal.ads.zzod
    public final int zzbe(int i) {
        return this.zzbgq[0];
    }

    public int hashCode() {
        if (this.zzahp == 0) {
            this.zzahp = (System.identityHashCode(this.zzbgp) * 31) + Arrays.hashCode(this.zzbgq);
        }
        return this.zzahp;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzns zzns = (zzns) obj;
            return this.zzbgp == zzns.zzbgp && Arrays.equals(this.zzbgq, zzns.zzbgq);
        }
    }
}
