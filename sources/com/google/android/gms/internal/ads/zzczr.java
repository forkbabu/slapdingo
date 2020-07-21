package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczr implements zzdec<zzczp> {
    private final String zzdpm;
    private final zzcix zzgfm;
    private final zzdvi zzgri;

    public zzczr(String str, zzdvi zzdvi, zzcix zzcix) {
        this.zzdpm = str;
        this.zzgri = zzdvi;
        this.zzgfm = zzcix;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzczp> zzaqm() {
        if (new BigInteger(this.zzdpm).equals(BigInteger.ONE)) {
            if (!zzdsi.zzar((String) zzwg.zzpw().zzd(zzaav.zzcpn))) {
                return this.zzgri.zze(new zzczu(this));
            }
        }
        return zzdux.zzaf(new zzczp(new Bundle()));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|(1:4)|5|6|(1:8)|9) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0018 */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e A[Catch:{ zzdlg -> 0x002b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.os.Bundle zzb(com.google.android.gms.internal.ads.zzdlm r3) {
        /*
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            com.google.android.gms.internal.ads.zzapl r1 = r3.zzts()     // Catch:{ zzdlg -> 0x0018 }
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = "sdk_version"
            com.google.android.gms.internal.ads.zzapl r2 = r3.zzts()     // Catch:{ zzdlg -> 0x0018 }
            java.lang.String r2 = r2.toString()     // Catch:{ zzdlg -> 0x0018 }
            r0.putString(r1, r2)     // Catch:{ zzdlg -> 0x0018 }
        L_0x0018:
            com.google.android.gms.internal.ads.zzapl r1 = r3.zztr()     // Catch:{ zzdlg -> 0x002b }
            if (r1 == 0) goto L_0x002b
            java.lang.String r1 = "adapter_version"
            com.google.android.gms.internal.ads.zzapl r3 = r3.zztr()     // Catch:{ zzdlg -> 0x002b }
            java.lang.String r3 = r3.toString()     // Catch:{ zzdlg -> 0x002b }
            r0.putString(r1, r3)     // Catch:{ zzdlg -> 0x002b }
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzczr.zzb(com.google.android.gms.internal.ads.zzdlm):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzczp zzaqo() throws Exception {
        List<String> asList = Arrays.asList(((String) zzwg.zzpw().zzd(zzaav.zzcpn)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : asList) {
            try {
                bundle.putBundle(str, zzb(this.zzgfm.zzd(str, new JSONObject())));
            } catch (zzdlg unused) {
            }
        }
        return new zzczp(bundle);
    }
}
