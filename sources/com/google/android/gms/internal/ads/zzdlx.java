package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdlx {
    private final Context zzaah;
    private final zzbbd zzbov;
    private final zzaxh zzbpz;
    private final Map<String, zzdlz> zzhbz = new HashMap();

    public zzdlx(Context context, zzbbd zzbbd, zzaxh zzaxh) {
        this.zzaah = context;
        this.zzbov = zzbbd;
        this.zzbpz = zzaxh;
    }

    public final zzdlz zzgu(String str) {
        if (str == null) {
            return zzasv();
        }
        if (this.zzhbz.containsKey(str)) {
            return this.zzhbz.get(str);
        }
        zzdlz zzgv = zzgv(str);
        this.zzhbz.put(str, zzgv);
        return zzgv;
    }

    private final zzdlz zzasv() {
        return new zzdlz(this.zzaah, this.zzbpz.zzwe(), this.zzbpz.zzwg());
    }

    private final zzdlz zzgv(String str) {
        zzatd zzaa = zzatd.zzaa(this.zzaah);
        try {
            zzaa.setAppPackageName(str);
            zzaya zzaya = new zzaya();
            zzaya.zza(this.zzaah, str, false);
            zzayb zzayb = new zzayb(this.zzbpz.zzwe(), zzaya);
            return new zzdlz(zzaa, zzayb, new zzaxs(zzbaq.zzyj(), zzayb));
        } catch (PackageManager.NameNotFoundException unused) {
            return zzasv();
        }
    }
}
