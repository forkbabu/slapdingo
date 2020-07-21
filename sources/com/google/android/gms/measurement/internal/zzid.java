package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
final class zzid implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhh zza;

    private zzid(zzhh zzhh) {
        this.zza = zzhh;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.zza.zzr().zzx().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data == null || !data.isHierarchical()) {
                    this.zza.zzi().zza(activity, bundle);
                    return;
                }
                this.zza.zzp();
                this.zza.zzq().zza(new zzic(this, bundle == null, data, zzkw.zza(intent) ? "gs" : DebugKt.DEBUG_PROPERTY_VALUE_AUTO, data.getQueryParameter("referrer")));
                this.zza.zzi().zza(activity, bundle);
            }
        } catch (Exception e) {
            this.zza.zzr().zzf().zza("Throwable caught in onActivityCreated", e);
        } finally {
            this.zza.zzi().zza(activity, bundle);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0141 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            r2 = r21
            com.google.android.gms.measurement.internal.zzhh r3 = r1.zza
            r3.zzd()
            com.google.android.gms.measurement.internal.zzhh r3 = r1.zza     // Catch:{ Exception -> 0x01db }
            com.google.android.gms.measurement.internal.zzy r3 = r3.zzt()     // Catch:{ Exception -> 0x01db }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzaq.zzbh     // Catch:{ Exception -> 0x01db }
            boolean r3 = r3.zza(r4)     // Catch:{ Exception -> 0x01db }
            java.lang.String r4 = "Activity created with data 'referrer' without required params"
            java.lang.String r5 = "utm_medium"
            java.lang.String r6 = "_cis"
            java.lang.String r7 = "utm_source"
            java.lang.String r8 = "utm_campaign"
            java.lang.String r10 = "gclid"
            if (r3 != 0) goto L_0x0047
            com.google.android.gms.measurement.internal.zzhh r3 = r1.zza
            com.google.android.gms.measurement.internal.zzy r3 = r3.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzaq.zzbj
            boolean r3 = r3.zza(r11)
            if (r3 != 0) goto L_0x0047
            com.google.android.gms.measurement.internal.zzhh r3 = r1.zza
            com.google.android.gms.measurement.internal.zzy r3 = r3.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzaq.zzbi
            boolean r3 = r3.zza(r11)
            if (r3 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r3 = 0
            goto L_0x009e
        L_0x0047:
            com.google.android.gms.measurement.internal.zzhh r3 = r1.zza
            com.google.android.gms.measurement.internal.zzkw r3 = r3.zzp()
            boolean r11 = android.text.TextUtils.isEmpty(r21)
            if (r11 == 0) goto L_0x0054
            goto L_0x0045
        L_0x0054:
            boolean r11 = r2.contains(r10)
            if (r11 != 0) goto L_0x0078
            boolean r11 = r2.contains(r8)
            if (r11 != 0) goto L_0x0078
            boolean r11 = r2.contains(r7)
            if (r11 != 0) goto L_0x0078
            boolean r11 = r2.contains(r5)
            if (r11 != 0) goto L_0x0078
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzw()
            r3.zza(r4)
            goto L_0x0045
        L_0x0078:
            java.lang.String r11 = "https://google.com/search?"
            java.lang.String r12 = java.lang.String.valueOf(r21)
            int r13 = r12.length()
            if (r13 == 0) goto L_0x0089
            java.lang.String r11 = r11.concat(r12)
            goto L_0x008f
        L_0x0089:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r11)
            r11 = r12
        L_0x008f:
            android.net.Uri r11 = android.net.Uri.parse(r11)
            android.os.Bundle r3 = r3.zza(r11)
            if (r3 == 0) goto L_0x009e
            java.lang.String r11 = "referrer"
            r3.putString(r6, r11)
        L_0x009e:
            r11 = 0
            java.lang.String r12 = "_cmp"
            r13 = 1
            if (r18 == 0) goto L_0x0101
            com.google.android.gms.measurement.internal.zzhh r14 = r1.zza
            com.google.android.gms.measurement.internal.zzkw r14 = r14.zzp()
            r15 = r19
            android.os.Bundle r14 = r14.zza(r15)
            if (r14 == 0) goto L_0x0102
            java.lang.String r15 = "intent"
            r14.putString(r6, r15)
            com.google.android.gms.measurement.internal.zzhh r6 = r1.zza
            com.google.android.gms.measurement.internal.zzy r6 = r6.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzaq.zzbh
            boolean r6 = r6.zza(r15)
            if (r6 == 0) goto L_0x00e6
            boolean r6 = r14.containsKey(r10)
            if (r6 != 0) goto L_0x00e6
            if (r3 == 0) goto L_0x00e6
            boolean r6 = r3.containsKey(r10)
            if (r6 == 0) goto L_0x00e6
            java.lang.String r6 = "_cer"
            java.lang.String r15 = "gclid=%s"
            java.lang.Object[] r9 = new java.lang.Object[r13]
            java.lang.String r16 = r3.getString(r10)
            r9[r11] = r16
            java.lang.String r9 = java.lang.String.format(r15, r9)
            r14.putString(r6, r9)
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzhh r6 = r1.zza
            r6.zza(r0, r12, r14)
            com.google.android.gms.measurement.internal.zzhh r6 = r1.zza
            com.google.android.gms.measurement.internal.zzy r6 = r6.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzaq.zzcq
            boolean r6 = r6.zza(r9)
            if (r6 == 0) goto L_0x0102
            com.google.android.gms.measurement.internal.zzhh r6 = r1.zza
            com.google.android.gms.measurement.internal.zzp r6 = r6.zzb
            r6.zza(r0, r14)
            goto L_0x0102
        L_0x0101:
            r14 = 0
        L_0x0102:
            com.google.android.gms.measurement.internal.zzhh r6 = r1.zza
            com.google.android.gms.measurement.internal.zzy r6 = r6.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzaq.zzbj
            boolean r6 = r6.zza(r9)
            java.lang.String r9 = "auto"
            if (r6 == 0) goto L_0x013b
            com.google.android.gms.measurement.internal.zzhh r6 = r1.zza
            com.google.android.gms.measurement.internal.zzy r6 = r6.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzaq.zzbi
            boolean r6 = r6.zza(r15)
            if (r6 != 0) goto L_0x013b
            if (r3 == 0) goto L_0x013b
            boolean r6 = r3.containsKey(r10)
            if (r6 == 0) goto L_0x013b
            if (r14 == 0) goto L_0x0130
            boolean r6 = r14.containsKey(r10)
            if (r6 != 0) goto L_0x013b
        L_0x0130:
            com.google.android.gms.measurement.internal.zzhh r6 = r1.zza
            java.lang.String r14 = "_lgclid"
            java.lang.String r15 = r3.getString(r10)
            r6.zza(r9, r14, r15, r13)
        L_0x013b:
            boolean r6 = android.text.TextUtils.isEmpty(r21)
            if (r6 == 0) goto L_0x0142
            return
        L_0x0142:
            com.google.android.gms.measurement.internal.zzhh r6 = r1.zza
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfb r6 = r6.zzw()
            java.lang.String r14 = "Activity created with referrer"
            r6.zza(r14, r2)
            com.google.android.gms.measurement.internal.zzhh r6 = r1.zza
            com.google.android.gms.measurement.internal.zzy r6 = r6.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzaq.zzbi
            boolean r6 = r6.zza(r14)
            java.lang.String r14 = "_ldl"
            if (r6 == 0) goto L_0x0194
            if (r3 == 0) goto L_0x017e
            com.google.android.gms.measurement.internal.zzhh r2 = r1.zza
            r2.zza(r0, r12, r3)
            com.google.android.gms.measurement.internal.zzhh r2 = r1.zza
            com.google.android.gms.measurement.internal.zzy r2 = r2.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzaq.zzcq
            boolean r2 = r2.zza(r4)
            if (r2 == 0) goto L_0x018d
            com.google.android.gms.measurement.internal.zzhh r2 = r1.zza
            com.google.android.gms.measurement.internal.zzp r2 = r2.zzb
            r2.zza(r0, r3)
            goto L_0x018d
        L_0x017e:
            com.google.android.gms.measurement.internal.zzhh r0 = r1.zza
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzw()
            java.lang.String r3 = "Referrer does not contain valid parameters"
            r0.zza(r3, r2)
        L_0x018d:
            com.google.android.gms.measurement.internal.zzhh r0 = r1.zza
            r2 = 0
            r0.zza(r9, r14, r2, r13)
            return
        L_0x0194:
            boolean r0 = r2.contains(r10)
            if (r0 == 0) goto L_0x01bf
            boolean r0 = r2.contains(r8)
            if (r0 != 0) goto L_0x01be
            boolean r0 = r2.contains(r7)
            if (r0 != 0) goto L_0x01be
            boolean r0 = r2.contains(r5)
            if (r0 != 0) goto L_0x01be
            java.lang.String r0 = "utm_term"
            boolean r0 = r2.contains(r0)
            if (r0 != 0) goto L_0x01be
            java.lang.String r0 = "utm_content"
            boolean r0 = r2.contains(r0)
            if (r0 == 0) goto L_0x01bf
        L_0x01be:
            r11 = 1
        L_0x01bf:
            if (r11 != 0) goto L_0x01cf
            com.google.android.gms.measurement.internal.zzhh r0 = r1.zza
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzw()
            r0.zza(r4)
            return
        L_0x01cf:
            boolean r0 = android.text.TextUtils.isEmpty(r21)
            if (r0 != 0) goto L_0x01da
            com.google.android.gms.measurement.internal.zzhh r0 = r1.zza
            r0.zza(r9, r14, r2, r13)
        L_0x01da:
            return
        L_0x01db:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzhh r2 = r1.zza
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()
            java.lang.String r3 = "Throwable caught in handleReferrerForOnActivityCreated"
            r2.zza(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzid.zza(boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzi().zzc(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzi().zzb(activity);
        zzjw zzk = this.zza.zzk();
        zzk.zzq().zza(new zzjy(zzk, zzk.zzm().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzjw zzk = this.zza.zzk();
        zzk.zzq().zza(new zzjz(zzk, zzk.zzm().elapsedRealtime()));
        this.zza.zzi().zza(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzi().zzb(activity, bundle);
    }

    /* synthetic */ zzid(zzhh zzhh, zzhi zzhi) {
        this(zzhh);
    }
}
