package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import com.itextpdf.text.html.HtmlTags;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzapt extends zzaqd {
    private static final Set<String> zzdlv = CollectionUtils.setOf("top-left", "top-right", "top-center", HtmlTags.ALIGN_CENTER, "bottom-left", "bottom-right", "bottom-center");
    private int height = -1;
    private final Object lock = new Object();
    private int width = -1;
    private zzaqc zzdeg;
    private final zzbfn zzdfp;
    private final Activity zzdll;
    private String zzdlw = "top-right";
    private boolean zzdlx = true;
    private int zzdly = 0;
    private int zzdlz = 0;
    private int zzdma = 0;
    private int zzdmb = 0;
    private zzbhg zzdmc;
    private ImageView zzdmd;
    private LinearLayout zzdme;
    private PopupWindow zzdmf;
    private RelativeLayout zzdmg;
    private ViewGroup zzdmh;

    public zzapt(zzbfn zzbfn, zzaqc zzaqc) {
        super(zzbfn, "resize");
        this.zzdfp = zzbfn;
        this.zzdll = zzbfn.zzzl();
        this.zzdeg = zzaqc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.Object r2 = r1.lock
            monitor-enter(r2)
            android.app.Activity r3 = r1.zzdll     // Catch:{ all -> 0x04bb }
            if (r3 != 0) goto L_0x0012
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzdw(r0)     // Catch:{ all -> 0x04bb }
            monitor-exit(r2)     // Catch:{ all -> 0x04bb }
            return
        L_0x0012:
            com.google.android.gms.internal.ads.zzbfn r3 = r1.zzdfp     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzbhg r3 = r3.zzaax()     // Catch:{ all -> 0x04bb }
            if (r3 != 0) goto L_0x0021
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzdw(r0)     // Catch:{ all -> 0x04bb }
            monitor-exit(r2)     // Catch:{ all -> 0x04bb }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzbfn r3 = r1.zzdfp     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzbhg r3 = r3.zzaax()     // Catch:{ all -> 0x04bb }
            boolean r3 = r3.zzacs()     // Catch:{ all -> 0x04bb }
            if (r3 == 0) goto L_0x0034
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzdw(r0)     // Catch:{ all -> 0x04bb }
            monitor-exit(r2)     // Catch:{ all -> 0x04bb }
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzbfn r3 = r1.zzdfp     // Catch:{ all -> 0x04bb }
            boolean r3 = r3.zzabe()     // Catch:{ all -> 0x04bb }
            if (r3 == 0) goto L_0x0043
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzdw(r0)     // Catch:{ all -> 0x04bb }
            monitor-exit(r2)     // Catch:{ all -> 0x04bb }
            return
        L_0x0043:
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bb }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04bb }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04bb }
            if (r3 != 0) goto L_0x0062
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04bb }
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bb }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04bb }
            int r3 = com.google.android.gms.internal.ads.zzaye.zzem(r3)     // Catch:{ all -> 0x04bb }
            r1.width = r3     // Catch:{ all -> 0x04bb }
        L_0x0062:
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bb }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04bb }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04bb }
            if (r3 != 0) goto L_0x0081
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04bb }
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bb }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04bb }
            int r3 = com.google.android.gms.internal.ads.zzaye.zzem(r3)     // Catch:{ all -> 0x04bb }
            r1.height = r3     // Catch:{ all -> 0x04bb }
        L_0x0081:
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bb }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04bb }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04bb }
            if (r3 != 0) goto L_0x00a0
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04bb }
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bb }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04bb }
            int r3 = com.google.android.gms.internal.ads.zzaye.zzem(r3)     // Catch:{ all -> 0x04bb }
            r1.zzdma = r3     // Catch:{ all -> 0x04bb }
        L_0x00a0:
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bb }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04bb }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04bb }
            if (r3 != 0) goto L_0x00bf
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04bb }
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bb }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04bb }
            int r3 = com.google.android.gms.internal.ads.zzaye.zzem(r3)     // Catch:{ all -> 0x04bb }
            r1.zzdmb = r3     // Catch:{ all -> 0x04bb }
        L_0x00bf:
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bb }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04bb }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04bb }
            if (r3 != 0) goto L_0x00db
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bb }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04bb }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ all -> 0x04bb }
            r1.zzdlx = r3     // Catch:{ all -> 0x04bb }
        L_0x00db:
            java.lang.String r3 = "customClosePosition"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x04bb }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x04bb }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x04bb }
            if (r3 != 0) goto L_0x00eb
            r1.zzdlw = r0     // Catch:{ all -> 0x04bb }
        L_0x00eb:
            int r0 = r1.width     // Catch:{ all -> 0x04bb }
            r3 = 1
            r4 = 0
            if (r0 < 0) goto L_0x00f7
            int r0 = r1.height     // Catch:{ all -> 0x04bb }
            if (r0 < 0) goto L_0x00f7
            r0 = 1
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            if (r0 != 0) goto L_0x0101
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzdw(r0)     // Catch:{ all -> 0x04bb }
            monitor-exit(r2)     // Catch:{ all -> 0x04bb }
            return
        L_0x0101:
            android.app.Activity r0 = r1.zzdll     // Catch:{ all -> 0x04bb }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x04bb }
            if (r0 == 0) goto L_0x04b4
            android.view.View r5 = r0.getDecorView()     // Catch:{ all -> 0x04bb }
            if (r5 != 0) goto L_0x0111
            goto L_0x04b4
        L_0x0111:
            com.google.android.gms.internal.ads.zzaye r5 = com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04bb }
            android.app.Activity r6 = r1.zzdll     // Catch:{ all -> 0x04bb }
            int[] r5 = r5.zze(r6)     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzaye r6 = com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04bb }
            android.app.Activity r7 = r1.zzdll     // Catch:{ all -> 0x04bb }
            int[] r6 = r6.zzf(r7)     // Catch:{ all -> 0x04bb }
            r7 = r5[r4]     // Catch:{ all -> 0x04bb }
            r5 = r5[r3]     // Catch:{ all -> 0x04bb }
            int r8 = r1.width     // Catch:{ all -> 0x04bb }
            r9 = 5
            r10 = 4
            r11 = 3
            r12 = -1
            r13 = 2
            r14 = 50
            if (r8 < r14) goto L_0x0233
            int r8 = r1.width     // Catch:{ all -> 0x04bb }
            if (r8 <= r7) goto L_0x013a
            goto L_0x0233
        L_0x013a:
            int r8 = r1.height     // Catch:{ all -> 0x04bb }
            if (r8 < r14) goto L_0x022d
            int r8 = r1.height     // Catch:{ all -> 0x04bb }
            if (r8 <= r5) goto L_0x0144
            goto L_0x022d
        L_0x0144:
            int r8 = r1.height     // Catch:{ all -> 0x04bb }
            if (r8 != r5) goto L_0x0153
            int r5 = r1.width     // Catch:{ all -> 0x04bb }
            if (r5 != r7) goto L_0x0153
            java.lang.String r5 = "Cannot resize to a full-screen ad."
            com.google.android.gms.internal.ads.zzaxv.zzfd(r5)     // Catch:{ all -> 0x04bb }
            goto L_0x0238
        L_0x0153:
            boolean r5 = r1.zzdlx     // Catch:{ all -> 0x04bb }
            if (r5 == 0) goto L_0x022b
            java.lang.String r5 = r1.zzdlw     // Catch:{ all -> 0x04bb }
            int r8 = r5.hashCode()     // Catch:{ all -> 0x04bb }
            switch(r8) {
                case -1364013995: goto L_0x0193;
                case -1012429441: goto L_0x0189;
                case -655373719: goto L_0x017f;
                case 1163912186: goto L_0x0175;
                case 1288627767: goto L_0x016b;
                case 1755462605: goto L_0x0161;
                default: goto L_0x0160;
            }     // Catch:{ all -> 0x04bb }
        L_0x0160:
            goto L_0x019d
        L_0x0161:
            java.lang.String r8 = "top-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04bb }
            if (r5 == 0) goto L_0x019d
            r5 = 1
            goto L_0x019e
        L_0x016b:
            java.lang.String r8 = "bottom-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04bb }
            if (r5 == 0) goto L_0x019d
            r5 = 4
            goto L_0x019e
        L_0x0175:
            java.lang.String r8 = "bottom-right"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04bb }
            if (r5 == 0) goto L_0x019d
            r5 = 5
            goto L_0x019e
        L_0x017f:
            java.lang.String r8 = "bottom-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04bb }
            if (r5 == 0) goto L_0x019d
            r5 = 3
            goto L_0x019e
        L_0x0189:
            java.lang.String r8 = "top-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04bb }
            if (r5 == 0) goto L_0x019d
            r5 = 0
            goto L_0x019e
        L_0x0193:
            java.lang.String r8 = "center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04bb }
            if (r5 == 0) goto L_0x019d
            r5 = 2
            goto L_0x019e
        L_0x019d:
            r5 = -1
        L_0x019e:
            if (r5 == 0) goto L_0x0212
            if (r5 == r3) goto L_0x0202
            if (r5 == r13) goto L_0x01eb
            if (r5 == r11) goto L_0x01dc
            if (r5 == r10) goto L_0x01c9
            if (r5 == r9) goto L_0x01b8
            int r5 = r1.zzdly     // Catch:{ all -> 0x04bb }
            int r8 = r1.zzdma     // Catch:{ all -> 0x04bb }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04bb }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.zzdlz     // Catch:{ all -> 0x04bb }
            int r15 = r1.zzdmb     // Catch:{ all -> 0x04bb }
            goto L_0x021b
        L_0x01b8:
            int r5 = r1.zzdly     // Catch:{ all -> 0x04bb }
            int r8 = r1.zzdma     // Catch:{ all -> 0x04bb }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04bb }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.zzdlz     // Catch:{ all -> 0x04bb }
            int r15 = r1.zzdmb     // Catch:{ all -> 0x04bb }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04bb }
            goto L_0x01e8
        L_0x01c9:
            int r5 = r1.zzdly     // Catch:{ all -> 0x04bb }
            int r8 = r1.zzdma     // Catch:{ all -> 0x04bb }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04bb }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdlz     // Catch:{ all -> 0x04bb }
            int r15 = r1.zzdmb     // Catch:{ all -> 0x04bb }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04bb }
            goto L_0x01e8
        L_0x01dc:
            int r5 = r1.zzdly     // Catch:{ all -> 0x04bb }
            int r8 = r1.zzdma     // Catch:{ all -> 0x04bb }
            int r5 = r5 + r8
            int r8 = r1.zzdlz     // Catch:{ all -> 0x04bb }
            int r15 = r1.zzdmb     // Catch:{ all -> 0x04bb }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04bb }
        L_0x01e8:
            int r8 = r8 + r15
            int r8 = r8 - r14
            goto L_0x021c
        L_0x01eb:
            int r5 = r1.zzdly     // Catch:{ all -> 0x04bb }
            int r8 = r1.zzdma     // Catch:{ all -> 0x04bb }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04bb }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdlz     // Catch:{ all -> 0x04bb }
            int r15 = r1.zzdmb     // Catch:{ all -> 0x04bb }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04bb }
            int r15 = r15 / r13
            int r8 = r8 + r15
            int r8 = r8 + -25
            goto L_0x021c
        L_0x0202:
            int r5 = r1.zzdly     // Catch:{ all -> 0x04bb }
            int r8 = r1.zzdma     // Catch:{ all -> 0x04bb }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04bb }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdlz     // Catch:{ all -> 0x04bb }
            int r15 = r1.zzdmb     // Catch:{ all -> 0x04bb }
            goto L_0x021b
        L_0x0212:
            int r5 = r1.zzdly     // Catch:{ all -> 0x04bb }
            int r8 = r1.zzdma     // Catch:{ all -> 0x04bb }
            int r5 = r5 + r8
            int r8 = r1.zzdlz     // Catch:{ all -> 0x04bb }
            int r15 = r1.zzdmb     // Catch:{ all -> 0x04bb }
        L_0x021b:
            int r8 = r8 + r15
        L_0x021c:
            if (r5 < 0) goto L_0x0238
            int r5 = r5 + r14
            if (r5 > r7) goto L_0x0238
            r5 = r6[r4]     // Catch:{ all -> 0x04bb }
            if (r8 < r5) goto L_0x0238
            int r8 = r8 + r14
            r5 = r6[r3]     // Catch:{ all -> 0x04bb }
            if (r8 <= r5) goto L_0x022b
            goto L_0x0238
        L_0x022b:
            r5 = 1
            goto L_0x0239
        L_0x022d:
            java.lang.String r5 = "Height is too small or too large."
            com.google.android.gms.internal.ads.zzaxv.zzfd(r5)     // Catch:{ all -> 0x04bb }
            goto L_0x0238
        L_0x0233:
            java.lang.String r5 = "Width is too small or too large."
            com.google.android.gms.internal.ads.zzaxv.zzfd(r5)     // Catch:{ all -> 0x04bb }
        L_0x0238:
            r5 = 0
        L_0x0239:
            if (r5 != 0) goto L_0x023d
            r5 = 0
            goto L_0x0299
        L_0x023d:
            boolean r5 = r1.zzdlx     // Catch:{ all -> 0x04bb }
            if (r5 == 0) goto L_0x0252
            int[] r5 = new int[r13]     // Catch:{ all -> 0x04bb }
            int r6 = r1.zzdly     // Catch:{ all -> 0x04bb }
            int r7 = r1.zzdma     // Catch:{ all -> 0x04bb }
            int r6 = r6 + r7
            r5[r4] = r6     // Catch:{ all -> 0x04bb }
            int r6 = r1.zzdlz     // Catch:{ all -> 0x04bb }
            int r7 = r1.zzdmb     // Catch:{ all -> 0x04bb }
            int r6 = r6 + r7
            r5[r3] = r6     // Catch:{ all -> 0x04bb }
            goto L_0x0299
        L_0x0252:
            com.google.android.gms.internal.ads.zzaye r5 = com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04bb }
            android.app.Activity r6 = r1.zzdll     // Catch:{ all -> 0x04bb }
            int[] r5 = r5.zze(r6)     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzaye r6 = com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04bb }
            android.app.Activity r7 = r1.zzdll     // Catch:{ all -> 0x04bb }
            int[] r6 = r6.zzf(r7)     // Catch:{ all -> 0x04bb }
            r5 = r5[r4]     // Catch:{ all -> 0x04bb }
            int r7 = r1.zzdly     // Catch:{ all -> 0x04bb }
            int r8 = r1.zzdma     // Catch:{ all -> 0x04bb }
            int r7 = r7 + r8
            int r8 = r1.zzdlz     // Catch:{ all -> 0x04bb }
            int r15 = r1.zzdmb     // Catch:{ all -> 0x04bb }
            int r8 = r8 + r15
            if (r7 >= 0) goto L_0x0276
            r7 = 0
            goto L_0x027f
        L_0x0276:
            int r15 = r1.width     // Catch:{ all -> 0x04bb }
            int r15 = r15 + r7
            if (r15 <= r5) goto L_0x027f
            int r7 = r1.width     // Catch:{ all -> 0x04bb }
            int r7 = r5 - r7
        L_0x027f:
            r5 = r6[r4]     // Catch:{ all -> 0x04bb }
            if (r8 >= r5) goto L_0x0286
            r8 = r6[r4]     // Catch:{ all -> 0x04bb }
            goto L_0x0293
        L_0x0286:
            int r5 = r1.height     // Catch:{ all -> 0x04bb }
            int r5 = r5 + r8
            r15 = r6[r3]     // Catch:{ all -> 0x04bb }
            if (r5 <= r15) goto L_0x0293
            r5 = r6[r3]     // Catch:{ all -> 0x04bb }
            int r6 = r1.height     // Catch:{ all -> 0x04bb }
            int r8 = r5 - r6
        L_0x0293:
            int[] r5 = new int[r13]     // Catch:{ all -> 0x04bb }
            r5[r4] = r7     // Catch:{ all -> 0x04bb }
            r5[r3] = r8     // Catch:{ all -> 0x04bb }
        L_0x0299:
            if (r5 != 0) goto L_0x02a2
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzdw(r0)     // Catch:{ all -> 0x04bb }
            monitor-exit(r2)     // Catch:{ all -> 0x04bb }
            return
        L_0x02a2:
            com.google.android.gms.internal.ads.zzwg.zzps()     // Catch:{ all -> 0x04bb }
            android.app.Activity r6 = r1.zzdll     // Catch:{ all -> 0x04bb }
            int r7 = r1.width     // Catch:{ all -> 0x04bb }
            int r6 = com.google.android.gms.internal.ads.zzbaq.zzc(r6, r7)     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzwg.zzps()     // Catch:{ all -> 0x04bb }
            android.app.Activity r7 = r1.zzdll     // Catch:{ all -> 0x04bb }
            int r8 = r1.height     // Catch:{ all -> 0x04bb }
            int r7 = com.google.android.gms.internal.ads.zzbaq.zzc(r7, r8)     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzbfn r8 = r1.zzdfp     // Catch:{ all -> 0x04bb }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04bb }
            android.view.ViewParent r8 = r8.getParent()     // Catch:{ all -> 0x04bb }
            if (r8 == 0) goto L_0x04ad
            boolean r15 = r8 instanceof android.view.ViewGroup     // Catch:{ all -> 0x04bb }
            if (r15 == 0) goto L_0x04ad
            r15 = r8
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzbfn r9 = r1.zzdfp     // Catch:{ all -> 0x04bb }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x04bb }
            r15.removeView(r9)     // Catch:{ all -> 0x04bb }
            android.widget.PopupWindow r9 = r1.zzdmf     // Catch:{ all -> 0x04bb }
            if (r9 != 0) goto L_0x0305
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8     // Catch:{ all -> 0x04bb }
            r1.zzdmh = r8     // Catch:{ all -> 0x04bb }
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzbfn r8 = r1.zzdfp     // Catch:{ all -> 0x04bb }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04bb }
            android.graphics.Bitmap r8 = com.google.android.gms.internal.ads.zzaye.zzm(r8)     // Catch:{ all -> 0x04bb }
            android.widget.ImageView r9 = new android.widget.ImageView     // Catch:{ all -> 0x04bb }
            android.app.Activity r15 = r1.zzdll     // Catch:{ all -> 0x04bb }
            r9.<init>(r15)     // Catch:{ all -> 0x04bb }
            r1.zzdmd = r9     // Catch:{ all -> 0x04bb }
            r9.setImageBitmap(r8)     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzbfn r8 = r1.zzdfp     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzbhg r8 = r8.zzaax()     // Catch:{ all -> 0x04bb }
            r1.zzdmc = r8     // Catch:{ all -> 0x04bb }
            android.view.ViewGroup r8 = r1.zzdmh     // Catch:{ all -> 0x04bb }
            android.widget.ImageView r9 = r1.zzdmd     // Catch:{ all -> 0x04bb }
            r8.addView(r9)     // Catch:{ all -> 0x04bb }
            goto L_0x030a
        L_0x0305:
            android.widget.PopupWindow r8 = r1.zzdmf     // Catch:{ all -> 0x04bb }
            r8.dismiss()     // Catch:{ all -> 0x04bb }
        L_0x030a:
            android.widget.RelativeLayout r8 = new android.widget.RelativeLayout     // Catch:{ all -> 0x04bb }
            android.app.Activity r9 = r1.zzdll     // Catch:{ all -> 0x04bb }
            r8.<init>(r9)     // Catch:{ all -> 0x04bb }
            r1.zzdmg = r8     // Catch:{ all -> 0x04bb }
            r8.setBackgroundColor(r4)     // Catch:{ all -> 0x04bb }
            android.widget.RelativeLayout r8 = r1.zzdmg     // Catch:{ all -> 0x04bb }
            android.view.ViewGroup$LayoutParams r9 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x04bb }
            r9.<init>(r6, r7)     // Catch:{ all -> 0x04bb }
            r8.setLayoutParams(r9)     // Catch:{ all -> 0x04bb }
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04bb }
            android.widget.RelativeLayout r8 = r1.zzdmg     // Catch:{ all -> 0x04bb }
            android.widget.PopupWindow r8 = com.google.android.gms.internal.ads.zzaye.zza(r8, r6, r7, r4)     // Catch:{ all -> 0x04bb }
            r1.zzdmf = r8     // Catch:{ all -> 0x04bb }
            r8.setOutsideTouchable(r3)     // Catch:{ all -> 0x04bb }
            android.widget.PopupWindow r8 = r1.zzdmf     // Catch:{ all -> 0x04bb }
            r8.setTouchable(r3)     // Catch:{ all -> 0x04bb }
            android.widget.PopupWindow r8 = r1.zzdmf     // Catch:{ all -> 0x04bb }
            boolean r9 = r1.zzdlx     // Catch:{ all -> 0x04bb }
            if (r9 != 0) goto L_0x033b
            r9 = 1
            goto L_0x033c
        L_0x033b:
            r9 = 0
        L_0x033c:
            r8.setClippingEnabled(r9)     // Catch:{ all -> 0x04bb }
            android.widget.RelativeLayout r8 = r1.zzdmg     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzbfn r9 = r1.zzdfp     // Catch:{ all -> 0x04bb }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x04bb }
            r8.addView(r9, r12, r12)     // Catch:{ all -> 0x04bb }
            android.widget.LinearLayout r8 = new android.widget.LinearLayout     // Catch:{ all -> 0x04bb }
            android.app.Activity r9 = r1.zzdll     // Catch:{ all -> 0x04bb }
            r8.<init>(r9)     // Catch:{ all -> 0x04bb }
            r1.zzdme = r8     // Catch:{ all -> 0x04bb }
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzwg.zzps()     // Catch:{ all -> 0x04bb }
            android.app.Activity r9 = r1.zzdll     // Catch:{ all -> 0x04bb }
            int r9 = com.google.android.gms.internal.ads.zzbaq.zzc(r9, r14)     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzwg.zzps()     // Catch:{ all -> 0x04bb }
            android.app.Activity r15 = r1.zzdll     // Catch:{ all -> 0x04bb }
            int r14 = com.google.android.gms.internal.ads.zzbaq.zzc(r15, r14)     // Catch:{ all -> 0x04bb }
            r8.<init>(r9, r14)     // Catch:{ all -> 0x04bb }
            java.lang.String r9 = r1.zzdlw     // Catch:{ all -> 0x04bb }
            int r14 = r9.hashCode()     // Catch:{ all -> 0x04bb }
            switch(r14) {
                case -1364013995: goto L_0x03a6;
                case -1012429441: goto L_0x039c;
                case -655373719: goto L_0x0392;
                case 1163912186: goto L_0x0388;
                case 1288627767: goto L_0x037e;
                case 1755462605: goto L_0x0374;
                default: goto L_0x0373;
            }     // Catch:{ all -> 0x04bb }
        L_0x0373:
            goto L_0x03af
        L_0x0374:
            java.lang.String r14 = "top-center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04bb }
            if (r9 == 0) goto L_0x03af
            r12 = 1
            goto L_0x03af
        L_0x037e:
            java.lang.String r14 = "bottom-center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04bb }
            if (r9 == 0) goto L_0x03af
            r12 = 4
            goto L_0x03af
        L_0x0388:
            java.lang.String r14 = "bottom-right"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04bb }
            if (r9 == 0) goto L_0x03af
            r12 = 5
            goto L_0x03af
        L_0x0392:
            java.lang.String r14 = "bottom-left"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04bb }
            if (r9 == 0) goto L_0x03af
            r12 = 3
            goto L_0x03af
        L_0x039c:
            java.lang.String r14 = "top-left"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04bb }
            if (r9 == 0) goto L_0x03af
            r12 = 0
            goto L_0x03af
        L_0x03a6:
            java.lang.String r14 = "center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04bb }
            if (r9 == 0) goto L_0x03af
            r12 = 2
        L_0x03af:
            r9 = 9
            r14 = 10
            if (r12 == 0) goto L_0x03ef
            r15 = 14
            if (r12 == r3) goto L_0x03e8
            if (r12 == r13) goto L_0x03e2
            r13 = 12
            if (r12 == r11) goto L_0x03db
            if (r12 == r10) goto L_0x03d4
            r9 = 11
            r10 = 5
            if (r12 == r10) goto L_0x03cd
            r8.addRule(r14)     // Catch:{ all -> 0x04bb }
            r8.addRule(r9)     // Catch:{ all -> 0x04bb }
            goto L_0x03f5
        L_0x03cd:
            r8.addRule(r13)     // Catch:{ all -> 0x04bb }
            r8.addRule(r9)     // Catch:{ all -> 0x04bb }
            goto L_0x03f5
        L_0x03d4:
            r8.addRule(r13)     // Catch:{ all -> 0x04bb }
            r8.addRule(r15)     // Catch:{ all -> 0x04bb }
            goto L_0x03f5
        L_0x03db:
            r8.addRule(r13)     // Catch:{ all -> 0x04bb }
            r8.addRule(r9)     // Catch:{ all -> 0x04bb }
            goto L_0x03f5
        L_0x03e2:
            r9 = 13
            r8.addRule(r9)     // Catch:{ all -> 0x04bb }
            goto L_0x03f5
        L_0x03e8:
            r8.addRule(r14)     // Catch:{ all -> 0x04bb }
            r8.addRule(r15)     // Catch:{ all -> 0x04bb }
            goto L_0x03f5
        L_0x03ef:
            r8.addRule(r14)     // Catch:{ all -> 0x04bb }
            r8.addRule(r9)     // Catch:{ all -> 0x04bb }
        L_0x03f5:
            android.widget.LinearLayout r9 = r1.zzdme     // Catch:{ all -> 0x04bb }
            com.google.android.gms.internal.ads.zzaps r10 = new com.google.android.gms.internal.ads.zzaps     // Catch:{ all -> 0x04bb }
            r10.<init>(r1)     // Catch:{ all -> 0x04bb }
            r9.setOnClickListener(r10)     // Catch:{ all -> 0x04bb }
            android.widget.LinearLayout r9 = r1.zzdme     // Catch:{ all -> 0x04bb }
            java.lang.String r10 = "Close button"
            r9.setContentDescription(r10)     // Catch:{ all -> 0x04bb }
            android.widget.RelativeLayout r9 = r1.zzdmg     // Catch:{ all -> 0x04bb }
            android.widget.LinearLayout r10 = r1.zzdme     // Catch:{ all -> 0x04bb }
            r9.addView(r10, r8)     // Catch:{ all -> 0x04bb }
            android.widget.PopupWindow r8 = r1.zzdmf     // Catch:{ RuntimeException -> 0x0465 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x0465 }
            com.google.android.gms.internal.ads.zzwg.zzps()     // Catch:{ RuntimeException -> 0x0465 }
            android.app.Activity r9 = r1.zzdll     // Catch:{ RuntimeException -> 0x0465 }
            r10 = r5[r4]     // Catch:{ RuntimeException -> 0x0465 }
            int r9 = com.google.android.gms.internal.ads.zzbaq.zzc(r9, r10)     // Catch:{ RuntimeException -> 0x0465 }
            com.google.android.gms.internal.ads.zzwg.zzps()     // Catch:{ RuntimeException -> 0x0465 }
            android.app.Activity r10 = r1.zzdll     // Catch:{ RuntimeException -> 0x0465 }
            r11 = r5[r3]     // Catch:{ RuntimeException -> 0x0465 }
            int r10 = com.google.android.gms.internal.ads.zzbaq.zzc(r10, r11)     // Catch:{ RuntimeException -> 0x0465 }
            r8.showAtLocation(r0, r4, r9, r10)     // Catch:{ RuntimeException -> 0x0465 }
            r0 = r5[r4]
            r8 = r5[r3]
            com.google.android.gms.internal.ads.zzaqc r9 = r1.zzdeg
            if (r9 == 0) goto L_0x043d
            com.google.android.gms.internal.ads.zzaqc r9 = r1.zzdeg
            int r10 = r1.width
            int r11 = r1.height
            r9.zza(r0, r8, r10, r11)
        L_0x043d:
            com.google.android.gms.internal.ads.zzbfn r0 = r1.zzdfp
            com.google.android.gms.internal.ads.zzbhg r6 = com.google.android.gms.internal.ads.zzbhg.zzq(r6, r7)
            r0.zza(r6)
            r0 = r5[r4]
            r3 = r5[r3]
            com.google.android.gms.internal.ads.zzaye r5 = com.google.android.gms.ads.internal.zzq.zzkw()
            android.app.Activity r6 = r1.zzdll
            int[] r5 = r5.zzf(r6)
            r4 = r5[r4]
            int r3 = r3 - r4
            int r4 = r1.width
            int r5 = r1.height
            r1.zzb(r0, r3, r4, r5)
            java.lang.String r0 = "resized"
            r1.zzdy(r0)
            monitor-exit(r2)
            return
        L_0x0465:
            r0 = move-exception
            java.lang.String r3 = "Cannot show popup window: "
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r4 = r0.length()
            if (r4 == 0) goto L_0x047b
            java.lang.String r0 = r3.concat(r0)
            goto L_0x0480
        L_0x047b:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
        L_0x0480:
            r1.zzdw(r0)
            android.widget.RelativeLayout r0 = r1.zzdmg
            com.google.android.gms.internal.ads.zzbfn r3 = r1.zzdfp
            android.view.View r3 = r3.getView()
            r0.removeView(r3)
            android.view.ViewGroup r0 = r1.zzdmh
            if (r0 == 0) goto L_0x04ab
            android.view.ViewGroup r0 = r1.zzdmh
            android.widget.ImageView r3 = r1.zzdmd
            r0.removeView(r3)
            android.view.ViewGroup r0 = r1.zzdmh
            com.google.android.gms.internal.ads.zzbfn r3 = r1.zzdfp
            android.view.View r3 = r3.getView()
            r0.addView(r3)
            com.google.android.gms.internal.ads.zzbfn r0 = r1.zzdfp
            com.google.android.gms.internal.ads.zzbhg r3 = r1.zzdmc
            r0.zza(r3)
        L_0x04ab:
            monitor-exit(r2)
            return
        L_0x04ad:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzdw(r0)
            monitor-exit(r2)
            return
        L_0x04b4:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzdw(r0)
            monitor-exit(r2)
            return
        L_0x04bb:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
            switch-data {-1364013995->0x0193, -1012429441->0x0189, -655373719->0x017f, 1163912186->0x0175, 1288627767->0x016b, 1755462605->0x0161, }
            switch-data {-1364013995->0x03a6, -1012429441->0x039c, -655373719->0x0392, 1163912186->0x0388, 1288627767->0x037e, 1755462605->0x0374, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapt.zzg(java.util.Map):void");
    }

    public final void zzac(boolean z) {
        synchronized (this.lock) {
            if (this.zzdmf != null) {
                this.zzdmf.dismiss();
                this.zzdmg.removeView(this.zzdfp.getView());
                if (this.zzdmh != null) {
                    this.zzdmh.removeView(this.zzdmd);
                    this.zzdmh.addView(this.zzdfp.getView());
                    this.zzdfp.zza(this.zzdmc);
                }
                if (z) {
                    zzdy("default");
                    if (this.zzdeg != null) {
                        this.zzdeg.zzuh();
                    }
                }
                this.zzdmf = null;
                this.zzdmg = null;
                this.zzdmh = null;
                this.zzdme = null;
            }
        }
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.lock) {
            this.zzdly = i;
            this.zzdlz = i2;
            PopupWindow popupWindow = this.zzdmf;
        }
    }

    public final boolean zzuf() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdmf != null;
        }
        return z;
    }

    public final void zzi(int i, int i2) {
        this.zzdly = i;
        this.zzdlz = i2;
    }
}
