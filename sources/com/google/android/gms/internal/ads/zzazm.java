package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzazm {
    private final String[] zzeaw;
    private final double[] zzeax;
    private final double[] zzeay;
    private final int[] zzeaz;
    private int zzeba;

    private zzazm(zzazn zzazn) {
        int size = zzazn.zzebc.size();
        this.zzeaw = (String[]) zzazn.zzebb.toArray(new String[size]);
        this.zzeax = zzg(zzazn.zzebc);
        this.zzeay = zzg(zzazn.zzebd);
        this.zzeaz = new int[size];
        this.zzeba = 0;
    }

    private static double[] zzg(List<Double> list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d) {
        this.zzeba++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzeay;
            if (i < dArr.length) {
                if (dArr[i] <= d && d < this.zzeax[i]) {
                    int[] iArr = this.zzeaz;
                    iArr[i] = iArr[i] + 1;
                }
                if (d >= this.zzeay[i]) {
                    i++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final List<zzazo> zzxy() {
        ArrayList arrayList = new ArrayList(this.zzeaw.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zzeaw;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d = this.zzeay[i];
            double d2 = this.zzeax[i];
            int[] iArr = this.zzeaz;
            arrayList.add(new zzazo(str, d, d2, ((double) iArr[i]) / ((double) this.zzeba), iArr[i]));
            i++;
        }
    }
}
