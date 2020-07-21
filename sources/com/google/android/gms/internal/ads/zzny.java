package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzny extends zzoe {
    private int zzahx = 0;
    private final SparseArray<Map<zznr, zzoa>> zzbhf = new SparseArray<>();
    private final SparseBooleanArray zzbhg = new SparseBooleanArray();
    private zzob zzbhh;

    /* access modifiers changed from: protected */
    public abstract zzod[] zza(zzhy[] zzhyArr, zznr[] zznrArr, int[][][] iArr) throws zzhb;

    public final void zzf(int i, boolean z) {
        if (this.zzbhg.get(i) != z) {
            this.zzbhg.put(i, z);
            invalidate();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoe
    public final zzog zza(zzhy[] zzhyArr, zznr zznr) throws zzhb {
        int[] iArr;
        int[] iArr2 = new int[(zzhyArr.length + 1)];
        int length = zzhyArr.length + 1;
        zzno[][] zznoArr = new zzno[length][];
        int[][][] iArr3 = new int[(zzhyArr.length + 1)][][];
        for (int i = 0; i < length; i++) {
            zznoArr[i] = new zzno[zznr.length];
            iArr3[i] = new int[zznr.length][];
        }
        int length2 = zzhyArr.length;
        int[] iArr4 = new int[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            iArr4[i2] = zzhyArr[i2].zzef();
        }
        for (int i3 = 0; i3 < zznr.length; i3++) {
            zzno zzbd = zznr.zzbd(i3);
            int length3 = zzhyArr.length;
            int i4 = 0;
            for (int i5 = 0; i5 < zzhyArr.length; i5++) {
                zzhy zzhy = zzhyArr[i5];
                for (int i6 = 0; i6 < zzbd.length; i6++) {
                    int zza = zzhy.zza(zzbd.zzbc(i6)) & 3;
                    if (zza > i4) {
                        length3 = i5;
                        if (zza == 3) {
                            break;
                        }
                        i4 = zza;
                    }
                }
            }
            if (length3 == zzhyArr.length) {
                iArr = new int[zzbd.length];
            } else {
                zzhy zzhy2 = zzhyArr[length3];
                int[] iArr5 = new int[zzbd.length];
                for (int i7 = 0; i7 < zzbd.length; i7++) {
                    iArr5[i7] = zzhy2.zza(zzbd.zzbc(i7));
                }
                iArr = iArr5;
            }
            int i8 = iArr2[length3];
            zznoArr[length3][i8] = zzbd;
            iArr3[length3][i8] = iArr;
            iArr2[length3] = iArr2[length3] + 1;
        }
        zznr[] zznrArr = new zznr[zzhyArr.length];
        int[] iArr6 = new int[zzhyArr.length];
        for (int i9 = 0; i9 < zzhyArr.length; i9++) {
            int i10 = iArr2[i9];
            zznrArr[i9] = new zznr((zzno[]) Arrays.copyOf(zznoArr[i9], i10));
            iArr3[i9] = (int[][]) Arrays.copyOf(iArr3[i9], i10);
            iArr6[i9] = zzhyArr[i9].getTrackType();
        }
        zznr zznr2 = new zznr((zzno[]) Arrays.copyOf(zznoArr[zzhyArr.length], iArr2[zzhyArr.length]));
        zzod[] zza2 = zza(zzhyArr, zznrArr, iArr3);
        int i11 = 0;
        while (true) {
            zzoa zzoa = null;
            if (i11 < zzhyArr.length) {
                if (this.zzbhg.get(i11)) {
                    zza2[i11] = null;
                } else {
                    zznr zznr3 = zznrArr[i11];
                    Map<zznr, zzoa> map = this.zzbhf.get(i11);
                    if (map != null) {
                        zzoa = map.get(zznr3);
                    }
                    if (zzoa != null) {
                        throw new NoSuchMethodError();
                    }
                }
                i11++;
            } else {
                zzob zzob = new zzob(iArr6, zznrArr, iArr4, iArr3, zznr2);
                zzhx[] zzhxArr = new zzhx[zzhyArr.length];
                for (int i12 = 0; i12 < zzhyArr.length; i12++) {
                    zzhxArr[i12] = zza2[i12] != null ? zzhx.zzahw : null;
                }
                return new zzog(zznr, new zzof(zza2), zzob, zzhxArr);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoe
    public final void zzd(Object obj) {
        this.zzbhh = (zzob) obj;
    }
}
