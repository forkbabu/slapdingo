package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzoq extends IOException {
    private final int type;
    private final zzop zzbif;

    public zzoq(String str, zzop zzop, int i) {
        super(str);
        this.zzbif = zzop;
        this.type = 1;
    }

    public zzoq(IOException iOException, zzop zzop, int i) {
        super(iOException);
        this.zzbif = zzop;
        this.type = i;
    }

    public zzoq(String str, IOException iOException, zzop zzop, int i) {
        super(str, iOException);
        this.zzbif = zzop;
        this.type = 1;
    }
}
