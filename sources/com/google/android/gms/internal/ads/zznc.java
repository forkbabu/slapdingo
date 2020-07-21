package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zznc implements zznb {
    private final zzib zzaen = new zzib();
    private final zznb[] zzbeq;
    private final ArrayList<zznb> zzber;
    private zzna zzbes;
    private zzia zzbet;
    private Object zzbeu;
    private int zzbev = -1;
    private zzne zzbew;

    public zznc(zznb... zznbArr) {
        this.zzbeq = zznbArr;
        this.zzber = new ArrayList<>(Arrays.asList(zznbArr));
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final void zza(zzhe zzhe, boolean z, zzna zzna) {
        this.zzbes = zzna;
        int i = 0;
        while (true) {
            zznb[] zznbArr = this.zzbeq;
            if (i < zznbArr.length) {
                zznbArr[i].zza(zzhe, false, new zznf(this, i));
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final void zzhy() throws IOException {
        zzne zzne = this.zzbew;
        if (zzne == null) {
            for (zznb zznb : this.zzbeq) {
                zznb.zzhy();
            }
            return;
        }
        throw zzne;
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final zzmz zza(int i, zzoi zzoi) {
        int length = this.zzbeq.length;
        zzmz[] zzmzArr = new zzmz[length];
        for (int i2 = 0; i2 < length; i2++) {
            zzmzArr[i2] = this.zzbeq[i2].zza(i, zzoi);
        }
        return new zznd(zzmzArr);
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final void zzb(zzmz zzmz) {
        zznd zznd = (zznd) zzmz;
        int i = 0;
        while (true) {
            zznb[] zznbArr = this.zzbeq;
            if (i < zznbArr.length) {
                zznbArr[i].zzb(zznd.zzbex[i]);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final void zzhz() {
        for (zznb zznb : this.zzbeq) {
            zznb.zzhz();
        }
    }

    /* access modifiers changed from: private */
    public final void zza(int i, zzia zzia, Object obj) {
        zzne zzne;
        if (this.zzbew == null) {
            int zzfe = zzia.zzfe();
            int i2 = 0;
            while (true) {
                if (i2 >= zzfe) {
                    if (this.zzbev == -1) {
                        this.zzbev = zzia.zzff();
                    } else if (zzia.zzff() != this.zzbev) {
                        zzne = new zzne(1);
                    }
                    zzne = null;
                } else if (zzia.zza(i2, this.zzaen, false).zzaid) {
                    zzne = new zzne(0);
                    break;
                } else {
                    i2++;
                }
            }
            this.zzbew = zzne;
        }
        if (this.zzbew == null) {
            this.zzber.remove(this.zzbeq[i]);
            if (i == 0) {
                this.zzbet = zzia;
                this.zzbeu = obj;
            }
            if (this.zzber.isEmpty()) {
                this.zzbes.zzb(this.zzbet, this.zzbeu);
            }
        }
    }
}
