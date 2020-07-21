package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbzj extends zzbpb {
    private final WeakReference<zzbfn> zzftp;
    private final zzbxx zzftq;
    private final zzcam zzftr;
    private final zzbpv zzfts;
    private final zzdpx zzftt;
    private final zzbss zzftu;
    private boolean zzftv = false;
    private final Context zzvr;

    zzbzj(zzbpa zzbpa, Context context, @Nullable zzbfn zzbfn, zzbxx zzbxx, zzcam zzcam, zzbpv zzbpv, zzdpx zzdpx, zzbss zzbss) {
        super(zzbpa);
        this.zzvr = context;
        this.zzftp = new WeakReference<>(zzbfn);
        this.zzftq = zzbxx;
        this.zzftr = zzcam;
        this.zzfts = zzbpv;
        this.zzftt = zzdpx;
        this.zzftu = zzbss;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbi(boolean r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaav.zzcnn
            com.google.android.gms.internal.ads.zzaar r1 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0049
            com.google.android.gms.ads.internal.zzq.zzkw()
            android.content.Context r0 = r4.zzvr
            boolean r0 = com.google.android.gms.internal.ads.zzaye.zzaw(r0)
            if (r0 == 0) goto L_0x0049
            java.lang.String r0 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.internal.ads.zzaxv.zzfd(r0)
            com.google.android.gms.internal.ads.zzbss r0 = r4.zzftu
            r0.zzaja()
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaav.zzcno
            com.google.android.gms.internal.ads.zzaar r3 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzdpx r0 = r4.zzftt
            com.google.android.gms.internal.ads.zzdkw r3 = r4.zzfkn
            com.google.android.gms.internal.ads.zzdku r3 = r3.zzhau
            com.google.android.gms.internal.ads.zzdkm r3 = r3.zzhar
            java.lang.String r3 = r3.zzdrt
            r0.zzhb(r3)
            goto L_0x004f
        L_0x0049:
            boolean r0 = r4.zzftv
            if (r0 != 0) goto L_0x004f
            r0 = 1
            goto L_0x0050
        L_0x004f:
            r0 = 0
        L_0x0050:
            if (r0 != 0) goto L_0x0053
            return r2
        L_0x0053:
            com.google.android.gms.internal.ads.zzbxx r0 = r4.zzftq
            r0.zzajx()
            com.google.android.gms.internal.ads.zzcam r0 = r4.zzftr     // Catch:{ zzcap -> 0x0062 }
            android.content.Context r3 = r4.zzvr     // Catch:{ zzcap -> 0x0062 }
            r0.zza(r5, r3)     // Catch:{ zzcap -> 0x0062 }
            r4.zzftv = r1
            return r1
        L_0x0062:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzbss r0 = r4.zzftu
            r0.zza(r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzj.zzbi(boolean):boolean");
    }

    public final boolean isClosed() {
        return this.zzfts.isClosed();
    }

    public final void finalize() throws Throwable {
        try {
            zzbfn zzbfn = this.zzftp.get();
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcwo)).booleanValue()) {
                if (!this.zzftv && zzbfn != null) {
                    zzdvi zzdvi = zzbbf.zzedl;
                    zzbfn.getClass();
                    zzdvi.execute(zzbzi.zzh(zzbfn));
                }
            } else if (zzbfn != null) {
                zzbfn.destroy();
            }
        } finally {
            super.finalize();
        }
    }
}
