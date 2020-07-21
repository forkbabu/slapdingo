package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzks extends zzkt {
    public final long zzasm;
    public final List<zzkv> zzasn = new ArrayList();
    public final List<zzks> zzaso = new ArrayList();

    public zzks(int i, long j) {
        super(i);
        this.zzasm = j;
    }

    public final void zza(zzkv zzkv) {
        this.zzasn.add(zzkv);
    }

    public final void zza(zzks zzks) {
        this.zzaso.add(zzks);
    }

    public final zzkv zzaq(int i) {
        int size = this.zzasn.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzkv zzkv = this.zzasn.get(i2);
            if (zzkv.type == i) {
                return zzkv;
            }
        }
        return null;
    }

    public final zzks zzar(int i) {
        int size = this.zzaso.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzks zzks = this.zzaso.get(i2);
            if (zzks.type == i) {
                return zzks;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzkt
    public final String toString() {
        String zzau = zzau(this.type);
        String arrays = Arrays.toString(this.zzasn.toArray());
        String arrays2 = Arrays.toString(this.zzaso.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(zzau).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(zzau);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }
}
