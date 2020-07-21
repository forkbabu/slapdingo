package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzazn {
    /* access modifiers changed from: private */
    public final List<String> zzebb = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzebc = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzebd = new ArrayList();

    public final zzazn zza(String str, double d, double d2) {
        int i = 0;
        while (i < this.zzebb.size()) {
            double doubleValue = this.zzebd.get(i).doubleValue();
            double doubleValue2 = this.zzebc.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.zzebb.add(i, str);
        this.zzebd.add(i, Double.valueOf(d));
        this.zzebc.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzazm zzxz() {
        return new zzazm(this);
    }
}
