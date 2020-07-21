package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.itextpdf.text.html.HtmlTags;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaxo {
    private final Object lock = new Object();
    private long zzdyh = -1;
    private long zzdyi = -1;
    private int zzdyj = -1;
    int zzdyk = -1;
    private long zzdyl = 0;
    private final String zzdym;
    private final zzaxx zzdyn;
    private int zzdyo = 0;
    private int zzdyp = 0;

    public zzaxo(String str, zzaxx zzaxx) {
        this.zzdym = str;
        this.zzdyn = zzaxx;
    }

    public final void zzvv() {
        synchronized (this.lock) {
            this.zzdyo++;
        }
    }

    public final void zzvu() {
        synchronized (this.lock) {
            this.zzdyp++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzve r11, long r12) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.lock
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzaxx r1 = r10.zzdyn     // Catch:{ all -> 0x0077 }
            long r1 = r1.zzxa()     // Catch:{ all -> 0x0077 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzq.zzld()     // Catch:{ all -> 0x0077 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0077 }
            long r5 = r10.zzdyi     // Catch:{ all -> 0x0077 }
            r7 = -1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0040
            long r1 = r3 - r1
            com.google.android.gms.internal.ads.zzaag<java.lang.Long> r5 = com.google.android.gms.internal.ads.zzaav.zzcod     // Catch:{ all -> 0x0077 }
            com.google.android.gms.internal.ads.zzaar r6 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ all -> 0x0077 }
            java.lang.Object r5 = r6.zzd(r5)     // Catch:{ all -> 0x0077 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0077 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0077 }
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0033
            r1 = -1
            r10.zzdyk = r1     // Catch:{ all -> 0x0077 }
            goto L_0x003b
        L_0x0033:
            com.google.android.gms.internal.ads.zzaxx r1 = r10.zzdyn     // Catch:{ all -> 0x0077 }
            int r1 = r1.zzxb()     // Catch:{ all -> 0x0077 }
            r10.zzdyk = r1     // Catch:{ all -> 0x0077 }
        L_0x003b:
            r10.zzdyi = r12     // Catch:{ all -> 0x0077 }
            r10.zzdyh = r12     // Catch:{ all -> 0x0077 }
            goto L_0x0042
        L_0x0040:
            r10.zzdyh = r12     // Catch:{ all -> 0x0077 }
        L_0x0042:
            r12 = 1
            if (r11 == 0) goto L_0x0056
            android.os.Bundle r13 = r11.extras     // Catch:{ all -> 0x0077 }
            if (r13 == 0) goto L_0x0056
            android.os.Bundle r11 = r11.extras     // Catch:{ all -> 0x0077 }
            java.lang.String r13 = "gw"
            r1 = 2
            int r11 = r11.getInt(r13, r1)     // Catch:{ all -> 0x0077 }
            if (r11 != r12) goto L_0x0056
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            return
        L_0x0056:
            int r11 = r10.zzdyj     // Catch:{ all -> 0x0077 }
            int r11 = r11 + r12
            r10.zzdyj = r11     // Catch:{ all -> 0x0077 }
            int r11 = r10.zzdyk     // Catch:{ all -> 0x0077 }
            int r11 = r11 + r12
            r10.zzdyk = r11     // Catch:{ all -> 0x0077 }
            if (r11 != 0) goto L_0x006c
            r11 = 0
            r10.zzdyl = r11     // Catch:{ all -> 0x0077 }
            com.google.android.gms.internal.ads.zzaxx r11 = r10.zzdyn     // Catch:{ all -> 0x0077 }
            r11.zzfa(r3)     // Catch:{ all -> 0x0077 }
            goto L_0x0075
        L_0x006c:
            com.google.android.gms.internal.ads.zzaxx r11 = r10.zzdyn     // Catch:{ all -> 0x0077 }
            long r11 = r11.zzxc()     // Catch:{ all -> 0x0077 }
            long r3 = r3 - r11
            r10.zzdyl = r3     // Catch:{ all -> 0x0077 }
        L_0x0075:
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            return
        L_0x0077:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxo.zza(com.google.android.gms.internal.ads.zzve, long):void");
    }

    public final Bundle zzp(Context context, String str) {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzdym);
            bundle.putLong("basets", this.zzdyi);
            bundle.putLong("currts", this.zzdyh);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzdyj);
            bundle.putInt("preqs_in_session", this.zzdyk);
            bundle.putLong("time_in_session", this.zzdyl);
            bundle.putInt("pclick", this.zzdyo);
            bundle.putInt("pimp", this.zzdyp);
            bundle.putBoolean("support_transparent_background", zzan(context));
        }
        return bundle;
    }

    private static boolean zzan(Context context) {
        Context zzab = zzatd.zzab(context);
        int identifier = zzab.getResources().getIdentifier("Theme.Translucent", HtmlTags.STYLE, AbstractSpiCall.ANDROID_CLIENT_TYPE);
        if (identifier == 0) {
            zzaxv.zzfc("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == zzab.getPackageManager().getActivityInfo(new ComponentName(zzab.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzaxv.zzfc("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            zzaxv.zzfd("Fail to fetch AdActivity theme");
            zzaxv.zzfc("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }
}
