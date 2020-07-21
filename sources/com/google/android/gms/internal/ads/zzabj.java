package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzabj {
    private final Map<String, zzabg> zzcyi = new HashMap();
    private final zzabi zzcyj;

    public zzabj(zzabi zzabi) {
        this.zzcyj = zzabi;
    }

    public final void zza(String str, zzabg zzabg) {
        this.zzcyi.put(str, zzabg);
    }

    public final void zzb(String str, String str2, long j) {
        zzabg zzabg;
        zzabi zzabi = this.zzcyj;
        zzabg zzabg2 = this.zzcyi.get(str2);
        String[] strArr = {str};
        if (!(zzabi == null || zzabg2 == null)) {
            zzabi.zza(zzabg2, j, strArr);
        }
        Map<String, zzabg> map = this.zzcyi;
        zzabi zzabi2 = this.zzcyj;
        if (zzabi2 == null) {
            zzabg = null;
        } else {
            zzabg = zzabi2.zzex(j);
        }
        map.put(str, zzabg);
    }

    public final zzabi zzrp() {
        return this.zzcyj;
    }
}
