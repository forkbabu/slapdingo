package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaxq {
    private String zzdpm = "0";
    private BigInteger zzdyq = BigInteger.ONE;

    public final synchronized String zzwo() {
        String bigInteger;
        bigInteger = this.zzdyq.toString();
        this.zzdyq = this.zzdyq.add(BigInteger.ONE);
        this.zzdpm = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzwp() {
        return this.zzdpm;
    }
}
