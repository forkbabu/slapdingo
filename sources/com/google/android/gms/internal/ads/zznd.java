package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zznd implements zzmy, zzmz {
    private zznr zzaex;
    private zzmy zzbdq;
    public final zzmz[] zzbex;
    private final IdentityHashMap<zznk, Integer> zzbey = new IdentityHashMap<>();
    private int zzbez;
    private zzmz[] zzbfa;
    private zznn zzbfb;

    public zznd(zzmz... zzmzArr) {
        this.zzbex = zzmzArr;
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zza(zzmy zzmy, long j) {
        this.zzbdq = zzmy;
        zzmz[] zzmzArr = this.zzbex;
        this.zzbez = zzmzArr.length;
        for (zzmz zzmz : zzmzArr) {
            zzmz.zza(this, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzhn() throws IOException {
        for (zzmz zzmz : this.zzbex) {
            zzmz.zzhn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final zznr zzho() {
        return this.zzaex;
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final long zza(zzod[] zzodArr, boolean[] zArr, zznk[] zznkArr, boolean[] zArr2, long j) {
        int i;
        zznk[] zznkArr2 = zznkArr;
        int[] iArr = new int[zzodArr.length];
        int[] iArr2 = new int[zzodArr.length];
        for (int i2 = 0; i2 < zzodArr.length; i2++) {
            if (zznkArr2[i2] == null) {
                i = -1;
            } else {
                i = this.zzbey.get(zznkArr2[i2]).intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            if (zzodArr[i2] != null) {
                zzno zzik = zzodArr[i2].zzik();
                int i3 = 0;
                while (true) {
                    zzmz[] zzmzArr = this.zzbex;
                    if (i3 >= zzmzArr.length) {
                        break;
                    } else if (zzmzArr[i3].zzho().zza(zzik) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this.zzbey.clear();
        int length = zzodArr.length;
        zznk[] zznkArr3 = new zznk[length];
        zznk[] zznkArr4 = new zznk[zzodArr.length];
        zzod[] zzodArr2 = new zzod[zzodArr.length];
        ArrayList arrayList = new ArrayList(this.zzbex.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.zzbex.length) {
            for (int i5 = 0; i5 < zzodArr.length; i5++) {
                zzod zzod = null;
                zznkArr4[i5] = iArr[i5] == i4 ? zznkArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    zzod = zzodArr[i5];
                }
                zzodArr2[i5] = zzod;
            }
            long zza = this.zzbex[i4].zza(zzodArr2, zArr, zznkArr4, zArr2, j2);
            if (i4 == 0) {
                j2 = zza;
            } else if (zza != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i6 = 0; i6 < zzodArr.length; i6++) {
                boolean z2 = true;
                if (iArr2[i6] == i4) {
                    zzpb.checkState(zznkArr4[i6] != null);
                    zznkArr3[i6] = zznkArr4[i6];
                    this.zzbey.put(zznkArr4[i6], Integer.valueOf(i4));
                    z = true;
                } else if (iArr[i6] == i4) {
                    if (zznkArr4[i6] != null) {
                        z2 = false;
                    }
                    zzpb.checkState(z2);
                }
            }
            if (z) {
                arrayList.add(this.zzbex[i4]);
            }
            i4++;
            arrayList = arrayList;
            zzodArr2 = zzodArr2;
            zznkArr2 = zznkArr;
        }
        System.arraycopy(zznkArr3, 0, zznkArr2, 0, length);
        zzmz[] zzmzArr2 = new zzmz[arrayList.size()];
        this.zzbfa = zzmzArr2;
        arrayList.toArray(zzmzArr2);
        this.zzbfb = new zzmm(this.zzbfa);
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzef(long j) {
        for (zzmz zzmz : this.zzbfa) {
            zzmz.zzef(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznn, com.google.android.gms.internal.ads.zzmz
    public final boolean zzee(long j) {
        return this.zzbfb.zzee(j);
    }

    @Override // com.google.android.gms.internal.ads.zznn, com.google.android.gms.internal.ads.zzmz
    public final long zzhm() {
        return this.zzbfb.zzhm();
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final long zzhp() {
        long zzhp = this.zzbex[0].zzhp();
        int i = 1;
        while (true) {
            zzmz[] zzmzArr = this.zzbex;
            if (i >= zzmzArr.length) {
                if (zzhp != -9223372036854775807L) {
                    zzmz[] zzmzArr2 = this.zzbfa;
                    int length = zzmzArr2.length;
                    int i2 = 0;
                    while (i2 < length) {
                        zzmz zzmz = zzmzArr2[i2];
                        if (zzmz == this.zzbex[0] || zzmz.zzeg(zzhp) == zzhp) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzhp;
            } else if (zzmzArr[i].zzhp() == -9223372036854775807L) {
                i++;
            } else {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final long zzhq() {
        long j = Long.MAX_VALUE;
        for (zzmz zzmz : this.zzbfa) {
            long zzhq = zzmz.zzhq();
            if (zzhq != Long.MIN_VALUE) {
                j = Math.min(j, zzhq);
            }
        }
        if (j == LongCompanionObject.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final long zzeg(long j) {
        long zzeg = this.zzbfa[0].zzeg(j);
        int i = 1;
        while (true) {
            zzmz[] zzmzArr = this.zzbfa;
            if (i >= zzmzArr.length) {
                return zzeg;
            }
            if (zzmzArr[i].zzeg(zzeg) == zzeg) {
                i++;
            } else {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final void zza(zzmz zzmz) {
        int i = this.zzbez - 1;
        this.zzbez = i;
        if (i <= 0) {
            int i2 = 0;
            for (zzmz zzmz2 : this.zzbex) {
                i2 += zzmz2.zzho().length;
            }
            zzno[] zznoArr = new zzno[i2];
            int i3 = 0;
            for (zzmz zzmz3 : this.zzbex) {
                zznr zzho = zzmz3.zzho();
                int i4 = zzho.length;
                int i5 = 0;
                while (i5 < i4) {
                    zznoArr[i3] = zzho.zzbd(i5);
                    i5++;
                    i3++;
                }
            }
            this.zzaex = new zznr(zznoArr);
            this.zzbdq.zza((zzmz) this);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zznn] */
    @Override // com.google.android.gms.internal.ads.zznm
    public final /* synthetic */ void zza(zzmz zzmz) {
        if (this.zzaex != null) {
            this.zzbdq.zza((zznn) this);
        }
    }
}
