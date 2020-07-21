package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczj implements zzdec<zzczk> {
    private final zzaxh zzbpz;
    private final zzdla zzfpv;
    private final zzdec<zzdef> zzgrp;
    private final Context zzvr;

    public zzczj(zzday<zzdef> zzday, zzdla zzdla, Context context, zzaxh zzaxh) {
        this.zzgrp = zzday;
        this.zzfpv = zzdla;
        this.zzvr = context;
        this.zzbpz = zzaxh;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzczk> zzaqm() {
        return zzdux.zzb(this.zzgrp.zzaqm(), new zzczm(this), zzbbf.zzedm);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzczk zza(zzdef zzdef) {
        boolean z;
        String str;
        int i;
        int i2;
        float f;
        String str2;
        int i3;
        int i4;
        int i5;
        DisplayMetrics displayMetrics;
        zzvh zzvh = this.zzfpv.zzboz;
        if (zzvh.zzchj != null) {
            zzvh[] zzvhArr = zzvh.zzchj;
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzvh zzvh2 : zzvhArr) {
                if (!zzvh2.zzchk && !z2) {
                    str = zzvh2.zzacv;
                    z2 = true;
                }
                if (zzvh2.zzchk && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzvh.zzacv;
            z = zzvh.zzchk;
        }
        Resources resources = this.zzvr.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i2 = 0;
            i = 0;
        } else {
            float f2 = displayMetrics.density;
            int i6 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
            str2 = this.zzbpz.zzwe().zzxf();
            i2 = i6;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        if (zzvh.zzchj != null) {
            zzvh[] zzvhArr2 = zzvh.zzchj;
            boolean z4 = false;
            for (zzvh zzvh3 : zzvhArr2) {
                if (zzvh3.zzchk) {
                    z4 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    if (zzvh3.width != -1 || f == 0.0f) {
                        i4 = zzvh3.width;
                    } else {
                        i4 = (int) (((float) zzvh3.widthPixels) / f);
                    }
                    sb.append(i4);
                    sb.append("x");
                    if (zzvh3.height == -2) {
                        if (f != 0.0f) {
                            i5 = (int) (((float) zzvh3.heightPixels) / f);
                            sb.append(i5);
                        }
                    }
                    i5 = zzvh3.height;
                    sb.append(i5);
                }
            }
            if (z4) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzczk(zzvh, str, z, sb.toString(), f, i2, i, str2, this.zzfpv.zzgrs);
    }
}
