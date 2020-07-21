package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdbq implements Callable {
    private final zzdbn zzgtc;

    zzdbq(zzdbn zzdbn) {
        this.zzgtc = zzdbn;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        String str2;
        String str3;
        zzq.zzkw();
        zzri zzws = zzq.zzla().zzwe().zzws();
        Bundle bundle = null;
        if (!(zzws == null || zzws == null || (zzq.zzla().zzwe().zzwt() && zzq.zzla().zzwe().zzwv()))) {
            if (zzws.zzml()) {
                zzws.wakeup();
            }
            zzrc zzmj = zzws.zzmj();
            if (zzmj != null) {
                str2 = zzmj.zzly();
                str = zzmj.zzlz();
                str3 = zzmj.zzma();
                if (str2 != null) {
                    zzq.zzla().zzwe().zzei(str2);
                }
                if (str3 != null) {
                    zzq.zzla().zzwe().zzej(str3);
                }
            } else {
                str2 = zzq.zzla().zzwe().zzwu();
                str3 = zzq.zzla().zzwe().zzww();
                str = null;
            }
            Bundle bundle2 = new Bundle(1);
            if (!zzq.zzla().zzwe().zzwv()) {
                if (str3 == null || TextUtils.isEmpty(str3)) {
                    bundle2.putString("v_fp_vertical", "no_hash");
                } else {
                    bundle2.putString("v_fp_vertical", str3);
                }
            }
            if (str2 != null && !zzq.zzla().zzwe().zzwt()) {
                bundle2.putString("fingerprint", str2);
                if (!str2.equals(str)) {
                    bundle2.putString("v_fp", str);
                }
            }
            if (!bundle2.isEmpty()) {
                bundle = bundle2;
            }
        }
        return new zzdbo(bundle);
    }
}
