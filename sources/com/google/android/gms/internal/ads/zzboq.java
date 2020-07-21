package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzboq implements zzbtd, zzbua {
    private final zzbbd zzboy;
    private final zzbfn zzdfp;
    private final zzdkk zzfol;
    private IObjectWrapper zzfom;
    private boolean zzfon;
    private final Context zzvr;

    public zzboq(Context context, zzbfn zzbfn, zzdkk zzdkk, zzbbd zzbbd) {
        this.zzvr = context;
        this.zzdfp = zzbfn;
        this.zzfol = zzdkk;
        this.zzboy = zzbbd;
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final synchronized void onAdLoaded() {
        if (!this.zzfon) {
            zzaid();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtd
    public final synchronized void onAdImpression() {
        if (!this.zzfon) {
            zzaid();
        }
        if (!(!this.zzfol.zzdse || this.zzfom == null || this.zzdfp == null)) {
            this.zzdfp.zza("onSdkImpression", new ArrayMap());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzaid() {
        /*
            r10 = this;
            monitor-enter(r10)
            com.google.android.gms.internal.ads.zzdkk r0 = r10.zzfol     // Catch:{ all -> 0x008b }
            boolean r0 = r0.zzdse     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r10)
            return
        L_0x0009:
            com.google.android.gms.internal.ads.zzbfn r0 = r10.zzdfp
            if (r0 != 0) goto L_0x000f
            monitor-exit(r10)
            return
        L_0x000f:
            com.google.android.gms.internal.ads.zzaqf r0 = com.google.android.gms.ads.internal.zzq.zzll()
            android.content.Context r1 = r10.zzvr
            boolean r0 = r0.zzp(r1)
            if (r0 != 0) goto L_0x001d
            monitor-exit(r10)
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzbbd r0 = r10.zzboy
            int r0 = r0.zzedd
            com.google.android.gms.internal.ads.zzbbd r1 = r10.zzboy
            int r1 = r1.zzede
            r2 = 23
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r0)
            java.lang.String r0 = "."
            r3.append(r0)
            r3.append(r1)
            java.lang.String r5 = r3.toString()
            com.google.android.gms.internal.ads.zzdkk r0 = r10.zzfol
            org.json.JSONObject r0 = r0.zzhab
            java.lang.String r1 = "media_type"
            r2 = -1
            int r0 = r0.optInt(r1, r2)
            if (r0 != 0) goto L_0x004a
            r0 = 0
            goto L_0x004c
        L_0x004a:
            java.lang.String r0 = "javascript"
        L_0x004c:
            r9 = r0
            com.google.android.gms.internal.ads.zzaqf r4 = com.google.android.gms.ads.internal.zzq.zzll()
            com.google.android.gms.internal.ads.zzbfn r0 = r10.zzdfp
            android.webkit.WebView r6 = r0.getWebView()
            java.lang.String r7 = ""
            java.lang.String r8 = "javascript"
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zza(r5, r6, r7, r8, r9)
            r10.zzfom = r0
            com.google.android.gms.internal.ads.zzbfn r0 = r10.zzdfp
            android.view.View r0 = r0.getView()
            com.google.android.gms.dynamic.IObjectWrapper r1 = r10.zzfom
            if (r1 == 0) goto L_0x0089
            if (r0 == 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzaqf r1 = com.google.android.gms.ads.internal.zzq.zzll()
            com.google.android.gms.dynamic.IObjectWrapper r2 = r10.zzfom
            r1.zza(r2, r0)
            com.google.android.gms.internal.ads.zzbfn r0 = r10.zzdfp
            com.google.android.gms.dynamic.IObjectWrapper r1 = r10.zzfom
            r0.zzap(r1)
            com.google.android.gms.internal.ads.zzaqf r0 = com.google.android.gms.ads.internal.zzq.zzll()
            com.google.android.gms.dynamic.IObjectWrapper r1 = r10.zzfom
            r0.zzab(r1)
            r0 = 1
            r10.zzfon = r0
        L_0x0089:
            monitor-exit(r10)
            return
        L_0x008b:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzboq.zzaid():void");
    }
}
