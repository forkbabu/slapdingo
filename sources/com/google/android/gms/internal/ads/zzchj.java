package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzchj extends zzbpb {
    private final zzaud zzduw;
    private final WeakReference<zzbfn> zzftp;
    private final zzbxx zzftq;
    private final zzbpv zzfts;
    private final zzdpx zzftt;
    private final zzbss zzftu;
    private final zzcam zzftw;
    private boolean zzgbj = false;
    private final zzbtz zzgbx;
    private final Context zzvr;

    zzchj(zzbpa zzbpa, Context context, zzbfn zzbfn, zzcam zzcam, zzbxx zzbxx, zzbss zzbss, zzbtz zzbtz, zzbpv zzbpv, zzdkk zzdkk, zzdpx zzdpx) {
        super(zzbpa);
        this.zzvr = context;
        this.zzftw = zzcam;
        this.zzftp = new WeakReference<>(zzbfn);
        this.zzftq = zzbxx;
        this.zzftu = zzbss;
        this.zzgbx = zzbtz;
        this.zzfts = zzbpv;
        this.zzftt = zzdpx;
        this.zzduw = new zzave(zzdkk.zzdru);
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.content.Context] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(boolean r5, android.app.Activity r6) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaav.zzcnn
            com.google.android.gms.internal.ads.zzaar r1 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0048
            com.google.android.gms.ads.internal.zzq.zzkw()
            android.content.Context r0 = r4.zzvr
            boolean r0 = com.google.android.gms.internal.ads.zzaye.zzaw(r0)
            if (r0 == 0) goto L_0x0048
            java.lang.String r5 = "Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.internal.ads.zzaxv.zzfd(r5)
            com.google.android.gms.internal.ads.zzbss r5 = r4.zzftu
            r5.zzaja()
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zzaav.zzcno
            com.google.android.gms.internal.ads.zzaar r6 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r5 = r6.zzd(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzdpx r5 = r4.zzftt
            com.google.android.gms.internal.ads.zzdkw r6 = r4.zzfkn
            com.google.android.gms.internal.ads.zzdku r6 = r6.zzhau
            com.google.android.gms.internal.ads.zzdkm r6 = r6.zzhar
            java.lang.String r6 = r6.zzdrt
            r5.zzhb(r6)
        L_0x0047:
            return r1
        L_0x0048:
            boolean r0 = r4.zzgbj
            r2 = 1
            if (r0 == 0) goto L_0x0061
            java.lang.String r5 = "The rewarded ad have been showed."
            com.google.android.gms.internal.ads.zzaxv.zzfd(r5)
            com.google.android.gms.internal.ads.zzbss r5 = r4.zzftu
            com.google.android.gms.internal.ads.zzuy r6 = new com.google.android.gms.internal.ads.zzuy
            java.lang.String r0 = "The ad has already been shown."
            java.lang.String r3 = "com.google.android.gms.ads"
            r6.<init>(r2, r0, r3)
            r5.zzc(r6)
            return r1
        L_0x0061:
            r4.zzgbj = r2
            com.google.android.gms.internal.ads.zzbxx r0 = r4.zzftq
            r0.zzajx()
            if (r6 != 0) goto L_0x006c
            android.content.Context r6 = r4.zzvr
        L_0x006c:
            com.google.android.gms.internal.ads.zzcam r0 = r4.zzftw     // Catch:{ zzcap -> 0x0072 }
            r0.zza(r5, r6)     // Catch:{ zzcap -> 0x0072 }
            return r2
        L_0x0072:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzbss r6 = r4.zzftu
            r6.zza(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchj.zzb(boolean, android.app.Activity):boolean");
    }

    public final boolean zzana() {
        return this.zzgbj;
    }

    public final zzaud zzqv() {
        return this.zzduw;
    }

    public final boolean isClosed() {
        return this.zzfts.isClosed();
    }

    public final boolean zzqw() {
        zzbfn zzbfn = this.zzftp.get();
        return zzbfn != null && !zzbfn.zzabo();
    }

    public final Bundle getAdMetadata() {
        return this.zzgbx.getAdMetadata();
    }

    public final void finalize() throws Throwable {
        try {
            zzbfn zzbfn = this.zzftp.get();
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcwo)).booleanValue()) {
                if (!this.zzgbj && zzbfn != null) {
                    zzdvi zzdvi = zzbbf.zzedl;
                    zzbfn.getClass();
                    zzdvi.execute(zzchi.zzh(zzbfn));
                }
            } else if (zzbfn != null) {
                zzbfn.destroy();
            }
        } finally {
            super.finalize();
        }
    }
}
