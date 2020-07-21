package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzaaw {
    static List<String> zzrg() {
        ArrayList arrayList = new ArrayList();
        zza(arrayList, zzabx.zzi("gad:dynamite_module:experiment_id", ""));
        zza(arrayList, zzacj.zzczy);
        zza(arrayList, zzacj.zzczz);
        zza(arrayList, zzacj.zzdaa);
        zza(arrayList, zzacj.zzdab);
        zza(arrayList, zzacj.zzdac);
        zza(arrayList, zzacj.zzdai);
        zza(arrayList, zzacj.zzdad);
        zza(arrayList, zzacj.zzdae);
        zza(arrayList, zzacj.zzdaf);
        zza(arrayList, zzacj.zzdag);
        zza(arrayList, zzacj.zzdah);
        return arrayList;
    }

    static List<String> zzrh() {
        ArrayList arrayList = new ArrayList();
        zza(arrayList, zzacs.zzdbd);
        return arrayList;
    }

    private static void zza(List<String> list, zzabx<String> zzabx) {
        String str = zzabx.get();
        if (!TextUtils.isEmpty(str)) {
            list.add(str);
        }
    }
}
