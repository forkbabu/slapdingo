package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcdw {
    private final zzcgr zzfyt;
    private final zzchw zzfyz;
    private ViewTreeObserver.OnScrollChangedListener zzfzc = null;
    private int zzfzd = ((Integer) zzwg.zzpw().zzd(zzaav.zzcxe)).intValue();
    private int zzfze = ((Integer) zzwg.zzpw().zzd(zzaav.zzcxf)).intValue();
    private float zzfzf = ((Float) zzwg.zzpw().zzd(zzaav.zzcxg)).floatValue();

    public zzcdw(zzchw zzchw, zzcgr zzcgr) {
        this.zzfyz = zzchw;
        this.zzfyt = zzcgr;
    }

    public final View zza(zzdkk zzdkk, View view, WindowManager windowManager) throws zzbfz {
        zzbfn zza = this.zzfyz.zza(zzvh.zzph(), false);
        zza.getView().setVisibility(4);
        zza.getView().setContentDescription("policy_validator");
        zza.zza("/sendMessageToSdk", new zzcdz(this));
        zza.zza("/hideValidatorOverlay", new zzcdy(this, windowManager, view));
        zza.zza("/open", new zzahg(null, null));
        this.zzfyt.zza(new WeakReference(zza), "/loadNativeAdPolicyViolations", new zzceb(this, view, windowManager, zzdkk));
        this.zzfyt.zza(new WeakReference(zza), "/showValidatorOverlay", zzcea.zzded);
        return zza.getView();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(android.view.View r17, android.view.WindowManager r18, com.google.android.gms.internal.ads.zzdkk r19, com.google.android.gms.internal.ads.zzbfn r20, java.util.Map r21) {
        /*
            r16 = this;
            r0 = r16
            r8 = r20
            r9 = r21
            com.google.android.gms.internal.ads.zzbgz r1 = r20.zzaaz()
            com.google.android.gms.internal.ads.zzcec r2 = new com.google.android.gms.internal.ads.zzcec
            r2.<init>(r0, r9)
            r1.zza(r2)
            android.content.Context r1 = r17.getContext()
            java.lang.String r10 = "scale"
            java.lang.Object r2 = r9.get(r10)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0032
            java.lang.Object r2 = r9.get(r10)     // Catch:{ NumberFormatException -> 0x0031 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NumberFormatException -> 0x0031 }
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0031 }
            r0.zzfzf = r2     // Catch:{ NumberFormatException -> 0x0031 }
            goto L_0x0032
        L_0x0031:
        L_0x0032:
            java.lang.String r2 = "overlay_width"
            java.lang.Object r3 = r9.get(r2)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r4 = "buffer"
            if (r3 != 0) goto L_0x0077
            java.lang.Object r3 = r9.get(r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0077
            com.google.android.gms.internal.ads.zzwg.zzps()     // Catch:{ NumberFormatException -> 0x0076 }
            java.lang.Object r2 = r9.get(r2)     // Catch:{ NumberFormatException -> 0x0076 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NumberFormatException -> 0x0076 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0076 }
            java.lang.Object r3 = r9.get(r4)     // Catch:{ NumberFormatException -> 0x0076 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NumberFormatException -> 0x0076 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0076 }
            int r2 = r2 + r3
            int r2 = com.google.android.gms.internal.ads.zzbaq.zzc(r1, r2)     // Catch:{ NumberFormatException -> 0x0076 }
            float r2 = (float) r2     // Catch:{ NumberFormatException -> 0x0076 }
            float r3 = r0.zzfzf     // Catch:{ NumberFormatException -> 0x0076 }
            float r2 = r2 * r3
            int r2 = java.lang.Math.round(r2)     // Catch:{ NumberFormatException -> 0x0076 }
            r0.zzfzd = r2     // Catch:{ NumberFormatException -> 0x0076 }
            goto L_0x0077
        L_0x0076:
        L_0x0077:
            java.lang.String r2 = "overlay_height"
            java.lang.Object r3 = r9.get(r2)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00b8
            java.lang.Object r3 = r9.get(r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00b8
            com.google.android.gms.internal.ads.zzwg.zzps()     // Catch:{ NumberFormatException -> 0x00b8 }
            java.lang.Object r2 = r9.get(r2)     // Catch:{ NumberFormatException -> 0x00b8 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NumberFormatException -> 0x00b8 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x00b8 }
            java.lang.Object r3 = r9.get(r4)     // Catch:{ NumberFormatException -> 0x00b8 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NumberFormatException -> 0x00b8 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x00b8 }
            int r2 = r2 + r3
            int r2 = com.google.android.gms.internal.ads.zzbaq.zzc(r1, r2)     // Catch:{ NumberFormatException -> 0x00b8 }
            float r2 = (float) r2     // Catch:{ NumberFormatException -> 0x00b8 }
            float r3 = r0.zzfzf     // Catch:{ NumberFormatException -> 0x00b8 }
            float r2 = r2 * r3
            int r2 = java.lang.Math.round(r2)     // Catch:{ NumberFormatException -> 0x00b8 }
            r0.zzfze = r2     // Catch:{ NumberFormatException -> 0x00b8 }
        L_0x00b8:
            int r2 = r0.zzfzd
            int r3 = r0.zzfze
            com.google.android.gms.internal.ads.zzbhg r2 = com.google.android.gms.internal.ads.zzbhg.zzq(r2, r3)
            r8.zza(r2)
            android.webkit.WebView r2 = r20.getWebView()     // Catch:{ NullPointerException -> 0x00fa }
            android.webkit.WebSettings r2 = r2.getSettings()     // Catch:{ NullPointerException -> 0x00fa }
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzaav.zzcxh     // Catch:{ NullPointerException -> 0x00fa }
            com.google.android.gms.internal.ads.zzaar r4 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ NullPointerException -> 0x00fa }
            java.lang.Object r3 = r4.zzd(r3)     // Catch:{ NullPointerException -> 0x00fa }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ NullPointerException -> 0x00fa }
            boolean r3 = r3.booleanValue()     // Catch:{ NullPointerException -> 0x00fa }
            r2.setUseWideViewPort(r3)     // Catch:{ NullPointerException -> 0x00fa }
            android.webkit.WebView r2 = r20.getWebView()     // Catch:{ NullPointerException -> 0x00fa }
            android.webkit.WebSettings r2 = r2.getSettings()     // Catch:{ NullPointerException -> 0x00fa }
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzaav.zzcxi     // Catch:{ NullPointerException -> 0x00fa }
            com.google.android.gms.internal.ads.zzaar r4 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ NullPointerException -> 0x00fa }
            java.lang.Object r3 = r4.zzd(r3)     // Catch:{ NullPointerException -> 0x00fa }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ NullPointerException -> 0x00fa }
            boolean r3 = r3.booleanValue()     // Catch:{ NullPointerException -> 0x00fa }
            r2.setLoadWithOverviewMode(r3)     // Catch:{ NullPointerException -> 0x00fa }
            goto L_0x00fb
        L_0x00fa:
        L_0x00fb:
            java.lang.String r11 = "orientation"
            java.lang.Object r2 = r9.get(r11)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            com.google.android.gms.ads.internal.zzq.zzkw()
            android.util.DisplayMetrics r2 = com.google.android.gms.internal.ads.zzaye.zzas(r1)
            int r3 = r2.widthPixels
            int r2 = r2.heightPixels
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            r12 = r17
            boolean r6 = r12.getGlobalVisibleRect(r5)
            if (r6 == 0) goto L_0x01f2
            com.google.android.gms.internal.ads.zzaag<java.lang.Integer> r6 = com.google.android.gms.internal.ads.zzaav.zzcxd
            com.google.android.gms.internal.ads.zzaar r7 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r6 = r7.zzd(r6)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            int r7 = r5.left
            int r13 = r0.zzfzd
            int r3 = r3 - r13
            int r3 = java.lang.Math.min(r7, r3)
            int r3 = java.lang.Math.max(r6, r3)
            int r13 = r4.hashCode()
            java.lang.String r15 = "2"
            java.lang.String r7 = "1"
            r14 = 2
            switch(r13) {
                case 49: goto L_0x016c;
                case 50: goto L_0x0164;
                case 51: goto L_0x015a;
                case 52: goto L_0x0150;
                case 53: goto L_0x0146;
                default: goto L_0x0145;
            }
        L_0x0145:
            goto L_0x0174
        L_0x0146:
            java.lang.String r13 = "5"
            boolean r13 = r4.equals(r13)
            if (r13 == 0) goto L_0x0174
            r13 = 4
            goto L_0x0175
        L_0x0150:
            java.lang.String r13 = "4"
            boolean r13 = r4.equals(r13)
            if (r13 == 0) goto L_0x0174
            r13 = 3
            goto L_0x0175
        L_0x015a:
            java.lang.String r13 = "3"
            boolean r13 = r4.equals(r13)
            if (r13 == 0) goto L_0x0174
            r13 = 2
            goto L_0x0175
        L_0x0164:
            boolean r13 = r4.equals(r15)
            if (r13 == 0) goto L_0x0174
            r13 = 1
            goto L_0x0175
        L_0x016c:
            boolean r13 = r4.equals(r7)
            if (r13 == 0) goto L_0x0174
            r13 = 0
            goto L_0x0175
        L_0x0174:
            r13 = -1
        L_0x0175:
            if (r13 == 0) goto L_0x01a1
            r12 = 1
            if (r13 == r12) goto L_0x01a1
            if (r13 == r14) goto L_0x019a
            r12 = 3
            if (r13 == r12) goto L_0x019a
            r12 = 4
            if (r13 == r12) goto L_0x0184
            r14 = 0
            goto L_0x01ac
        L_0x0184:
            int r12 = r5.bottom
            int r12 = r2 - r12
            int r13 = r0.zzfze
            if (r12 <= r13) goto L_0x0196
            int r2 = r5.bottom
            com.google.android.gms.internal.ads.zzwg.zzps()
            int r1 = com.google.android.gms.internal.ads.zzbaq.zzc(r1, r6)
            goto L_0x01aa
        L_0x0196:
            int r2 = r2 - r13
            int r14 = r2 / 2
            goto L_0x01ac
        L_0x019a:
            int r1 = r5.top
            int r2 = r0.zzfze
            int r14 = r1 - r2
            goto L_0x01ac
        L_0x01a1:
            int r2 = r5.bottom
            com.google.android.gms.internal.ads.zzwg.zzps()
            int r1 = com.google.android.gms.internal.ads.zzbaq.zzc(r1, r6)
        L_0x01aa:
            int r14 = r2 - r1
        L_0x01ac:
            android.view.WindowManager$LayoutParams r6 = com.google.android.gms.internal.ads.zzbae.zzyb()
            r6.x = r3
            r6.y = r14
            android.view.View r1 = r20.getView()
            r12 = r18
            r12.updateViewLayout(r1, r6)
            boolean r1 = r7.equals(r4)
            if (r1 != 0) goto L_0x01cd
            boolean r1 = r15.equals(r4)
            if (r1 == 0) goto L_0x01ca
            goto L_0x01cd
        L_0x01ca:
            int r1 = r5.top
            goto L_0x01cf
        L_0x01cd:
            int r1 = r5.bottom
        L_0x01cf:
            int r1 = r1 - r14
            r7 = r1
            com.google.android.gms.internal.ads.zzced r13 = new com.google.android.gms.internal.ads.zzced
            r1 = r13
            r2 = r17
            r3 = r20
            r5 = r6
            r6 = r7
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r0.zzfzc = r13
            android.view.ViewTreeObserver r1 = r17.getViewTreeObserver()
            if (r1 == 0) goto L_0x01f2
            boolean r2 = r1.isAlive()
            if (r2 == 0) goto L_0x01f2
            android.view.ViewTreeObserver$OnScrollChangedListener r2 = r0.zzfzc
            r1.addOnScrollChangedListener(r2)
        L_0x01f2:
            r1 = r19
            java.lang.String r1 = r1.zzhah
            android.net.Uri r1 = android.net.Uri.parse(r1)
            android.net.Uri$Builder r1 = r1.buildUpon()
            java.lang.String r2 = "violations"
            java.lang.Object r3 = r9.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r1 = r1.appendQueryParameter(r2, r3)
            java.lang.Object r2 = r9.get(r11)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r1 = r1.appendQueryParameter(r11, r2)
            java.lang.String r2 = "title"
            java.lang.Object r3 = r9.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r1 = r1.appendQueryParameter(r2, r3)
            java.lang.Object r2 = r9.get(r10)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r1 = r1.appendQueryParameter(r10, r2)
            android.net.Uri r1 = r1.build()
            java.lang.String r1 = r1.toString()
            r8.loadUrl(r1)
            return
            switch-data {49->0x016c, 50->0x0164, 51->0x015a, 52->0x0150, 53->0x0146, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdw.zza(android.view.View, android.view.WindowManager, com.google.android.gms.internal.ads.zzdkk, com.google.android.gms.internal.ads.zzbfn, java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzfyt.zza("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(WindowManager windowManager, View view, zzbfn zzbfn, Map map) {
        zzaxv.zzee("Hide native ad policy validator overlay.");
        zzbfn.getView().setVisibility(8);
        if (zzbfn.getView().getWindowToken() != null) {
            windowManager.removeView(zzbfn.getView());
        }
        zzbfn.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzfzc != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzfzc);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbfn zzbfn, Map map) {
        this.zzfyt.zza("sendMessageToNativeJs", map);
    }
}
