package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzlq {
    public final int[] zzaom;
    public final long[] zzaon;
    public final int zzawu;
    public final int zzayb;
    public final int[] zzayd;
    public final long[] zzbaf;

    public zzlq(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = true;
        zzpb.checkArgument(iArr.length == jArr2.length);
        zzpb.checkArgument(jArr.length == jArr2.length);
        zzpb.checkArgument(iArr2.length != jArr2.length ? false : z);
        this.zzaon = jArr;
        this.zzaom = iArr;
        this.zzayb = i;
        this.zzbaf = jArr2;
        this.zzayd = iArr2;
        this.zzawu = jArr.length;
    }

    public final int zzec(long j) {
        for (int zza = zzpo.zza(this.zzbaf, j, true, false); zza >= 0; zza--) {
            if ((this.zzayd[zza] & 1) != 0) {
                return zza;
            }
        }
        return -1;
    }

    public final int zzed(long j) {
        for (int zzb = zzpo.zzb(this.zzbaf, j, true, false); zzb < this.zzbaf.length; zzb++) {
            if ((this.zzayd[zzb] & 1) != 0) {
                return zzb;
            }
        }
        return -1;
    }
}
