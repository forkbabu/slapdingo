package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdee implements Runnable {
    private final zzdec zzgun;
    private final long zzguo;

    zzdee(zzdec zzdec, long j) {
        this.zzgun = zzdec;
        this.zzguo = j;
    }

    public final void run() {
        zzdec zzdec = this.zzgun;
        long j = this.zzguo;
        String canonicalName = zzdec.getClass().getCanonicalName();
        long elapsedRealtime = zzq.zzld().elapsedRealtime() - j;
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
        sb.append("Signal runtime : ");
        sb.append(canonicalName);
        sb.append(" = ");
        sb.append(elapsedRealtime);
        zzaxv.zzeh(sb.toString());
    }
}
