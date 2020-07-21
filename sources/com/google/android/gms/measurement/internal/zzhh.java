package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzng;
import com.google.android.gms.internal.measurement.zzns;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.itextpdf.text.pdf.PdfBoolean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzhh extends zzg {
    protected zzid zza;
    final zzp zzb;
    protected boolean zzc = true;
    private zzhc zzd;
    private final Set<zzhf> zze = new CopyOnWriteArraySet();
    private boolean zzf;
    private final AtomicReference<String> zzg = new AtomicReference<>();

    protected zzhh(zzgd zzgd) {
        super(zzgd);
        this.zzb = new zzp(zzgd);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zzz() {
        return false;
    }

    public final void zzab() {
        if (zzn().getApplicationContext() instanceof Application) {
            ((Application) zzn().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzq().zza(atomicReference, 15000, "boolean test flag value", new zzhi(this, atomicReference));
    }

    public final String zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzq().zza(atomicReference, 15000, "String test flag value", new zzht(this, atomicReference));
    }

    public final Long zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzq().zza(atomicReference, 15000, "long test flag value", new zzhu(this, atomicReference));
    }

    public final Integer zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzq().zza(atomicReference, 15000, "int test flag value", new zzhx(this, atomicReference));
    }

    public final Double zzag() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzq().zza(atomicReference, 15000, "double test flag value", new zzhw(this, atomicReference));
    }

    public final void zza(boolean z) {
        zzw();
        zzb();
        zzq().zza(new zzhz(this, z));
    }

    /* access modifiers changed from: private */
    public final void zzc(boolean z) {
        zzd();
        zzb();
        zzw();
        zzr().zzw().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzs().zzb(z);
        zzam();
    }

    /* access modifiers changed from: private */
    public final void zzam() {
        zzd();
        String zza2 = zzs().zzn.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zza("app", "_npa", (Object) null, zzm().currentTimeMillis());
            } else {
                zza("app", "_npa", Long.valueOf(PdfBoolean.TRUE.equals(zza2) ? 1 : 0), zzm().currentTimeMillis());
            }
        }
        if (!this.zzy.zzab() || !this.zzc) {
            zzr().zzw().zza("Updating Scion state (FE)");
            zzh().zzac();
            return;
        }
        zzr().zzw().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzai();
        if (zzns.zzb() && zzt().zza(zzaq.zzbv)) {
            zzk().zza.zza();
        }
        if (zzng.zzb() && zzt().zza(zzaq.zzca)) {
            if (!(this.zzy.zzf().zza.zzc().zzi.zza() > 0)) {
                zzfq zzf2 = this.zzy.zzf();
                zzf2.zza.zzad();
                zzf2.zza(zzf2.zza.zzn().getPackageName());
            }
        }
        if (zzt().zza(zzaq.zzcq)) {
            zzq().zza(new zzib(this));
        }
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzm().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, String str2, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, zzm().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, j, bundle, true, this.zzd == null || zzkw.zze(str2), false, null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0355  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x03b7  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03c9  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x03fd  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x043d  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x04f9  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x056c  */
    /* JADX WARNING: Removed duplicated region for block: B:210:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r28, java.lang.String r29, long r30, android.os.Bundle r32, boolean r33, boolean r34, boolean r35, java.lang.String r36) {
        /*
            r27 = this;
            r7 = r27
            r8 = r28
            r15 = r29
            r13 = r30
            r12 = r32
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r32)
            r27.zzd()
            r27.zzw()
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzy
            boolean r0 = r0.zzab()
            if (r0 != 0) goto L_0x002c
            com.google.android.gms.measurement.internal.zzez r0 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzw()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.zza(r1)
            return
        L_0x002c:
            com.google.android.gms.measurement.internal.zzy r0 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaq.zzbb
            boolean r0 = r0.zza(r1)
            if (r0 == 0) goto L_0x0056
            com.google.android.gms.measurement.internal.zzes r0 = r27.zzg()
            java.util.List r0 = r0.zzah()
            if (r0 == 0) goto L_0x0056
            boolean r0 = r0.contains(r15)
            if (r0 != 0) goto L_0x0056
            com.google.android.gms.measurement.internal.zzez r0 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzw()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.zza(r1, r15, r8)
            return
        L_0x0056:
            boolean r0 = r7.zzf
            r11 = 0
            r10 = 0
            r9 = 1
            if (r0 != 0) goto L_0x00ae
            r7.zzf = r9
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzy     // Catch:{ ClassNotFoundException -> 0x00a1 }
            boolean r0 = r0.zzt()     // Catch:{ ClassNotFoundException -> 0x00a1 }
            java.lang.String r1 = "com.google.android.gms.tagmanager.TagManagerService"
            if (r0 != 0) goto L_0x0076
            android.content.Context r0 = r27.zzn()
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.Class r0 = java.lang.Class.forName(r1, r9, r0)
            goto L_0x007a
        L_0x0076:
            java.lang.Class r0 = java.lang.Class.forName(r1)
        L_0x007a:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x0092 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r10] = r3     // Catch:{ Exception -> 0x0092 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x0092 }
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0092 }
            android.content.Context r2 = r27.zzn()     // Catch:{ Exception -> 0x0092 }
            r1[r10] = r2     // Catch:{ Exception -> 0x0092 }
            r0.invoke(r11, r1)     // Catch:{ Exception -> 0x0092 }
            goto L_0x00ae
        L_0x0092:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzez r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzi()
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.zza(r2, r0)
            goto L_0x00ae
        L_0x00a1:
            com.google.android.gms.measurement.internal.zzez r0 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzv()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.zza(r1)
        L_0x00ae:
            com.google.android.gms.measurement.internal.zzy r0 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaq.zzbh
            boolean r0 = r0.zza(r1)
            if (r0 == 0) goto L_0x00df
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x00df
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x00df
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.common.util.Clock r0 = r27.zzm()
            long r5 = r0.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r27
            r1.zza(r2, r3, r4, r5)
        L_0x00df:
            boolean r0 = com.google.android.gms.internal.measurement.zzof.zzb()
            if (r0 == 0) goto L_0x010d
            com.google.android.gms.measurement.internal.zzy r0 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaq.zzcm
            boolean r0 = r0.zza(r1)
            if (r0 == 0) goto L_0x010d
            r27.zzu()
            if (r33 == 0) goto L_0x010d
            boolean r0 = com.google.android.gms.measurement.internal.zzkw.zzg(r29)
            if (r0 == 0) goto L_0x010d
            com.google.android.gms.measurement.internal.zzkw r0 = r27.zzp()
            com.google.android.gms.measurement.internal.zzfl r1 = r27.zzs()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzx
            android.os.Bundle r1 = r1.zza()
            r0.zza(r12, r1)
        L_0x010d:
            r0 = 40
            if (r35 == 0) goto L_0x0171
            r27.zzu()
            java.lang.String r1 = "_iap"
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x0171
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkw r1 = r1.zzi()
            java.lang.String r2 = "event"
            boolean r3 = r1.zza(r2, r15)
            r4 = 2
            if (r3 != 0) goto L_0x012c
            goto L_0x013f
        L_0x012c:
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zzhb.zza
            boolean r3 = r1.zza(r2, r3, r15)
            if (r3 != 0) goto L_0x0137
            r4 = 13
            goto L_0x013f
        L_0x0137:
            boolean r1 = r1.zza(r2, r0, r15)
            if (r1 != 0) goto L_0x013e
            goto L_0x013f
        L_0x013e:
            r4 = 0
        L_0x013f:
            if (r4 == 0) goto L_0x0171
            com.google.android.gms.measurement.internal.zzez r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzh()
            com.google.android.gms.measurement.internal.zzex r2 = r27.zzo()
            java.lang.String r2 = r2.zza(r15)
            java.lang.String r3 = "Invalid public event name. Event will not be logged (FE)"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzy
            r1.zzi()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzkw.zza(r15, r0, r9)
            if (r15 == 0) goto L_0x0165
            int r10 = r29.length()
        L_0x0165:
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkw r1 = r1.zzi()
            java.lang.String r2 = "_ev"
            r1.zza(r4, r2, r0, r10)
            return
        L_0x0171:
            r27.zzu()
            com.google.android.gms.measurement.internal.zzin r1 = r27.zzi()
            com.google.android.gms.measurement.internal.zzik r1 = r1.zza(r10)
            java.lang.String r2 = "_sc"
            if (r1 == 0) goto L_0x0188
            boolean r3 = r12.containsKey(r2)
            if (r3 != 0) goto L_0x0188
            r1.zzd = r9
        L_0x0188:
            if (r33 == 0) goto L_0x018e
            if (r35 == 0) goto L_0x018e
            r3 = 1
            goto L_0x018f
        L_0x018e:
            r3 = 0
        L_0x018f:
            com.google.android.gms.measurement.internal.zzin.zza(r1, r12, r3)
            java.lang.String r3 = "am"
            boolean r16 = r3.equals(r8)
            boolean r3 = com.google.android.gms.measurement.internal.zzkw.zze(r29)
            if (r33 == 0) goto L_0x01d1
            com.google.android.gms.measurement.internal.zzhc r4 = r7.zzd
            if (r4 == 0) goto L_0x01d1
            if (r3 != 0) goto L_0x01d1
            if (r16 != 0) goto L_0x01d1
            com.google.android.gms.measurement.internal.zzez r0 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzw()
            com.google.android.gms.measurement.internal.zzex r1 = r27.zzo()
            java.lang.String r1 = r1.zza(r15)
            com.google.android.gms.measurement.internal.zzex r2 = r27.zzo()
            java.lang.String r2 = r2.zza(r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.zza(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzhc r1 = r7.zzd
            r2 = r28
            r3 = r29
            r4 = r32
            r5 = r30
            r1.interceptEvent(r2, r3, r4, r5)
            return
        L_0x01d1:
            com.google.android.gms.measurement.internal.zzgd r3 = r7.zzy
            boolean r3 = r3.zzag()
            if (r3 != 0) goto L_0x01da
            return
        L_0x01da:
            com.google.android.gms.measurement.internal.zzkw r3 = r27.zzp()
            int r3 = r3.zzb(r15)
            if (r3 == 0) goto L_0x021e
            com.google.android.gms.measurement.internal.zzez r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzh()
            com.google.android.gms.measurement.internal.zzex r2 = r27.zzo()
            java.lang.String r2 = r2.zza(r15)
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            r1.zza(r4, r2)
            r27.zzp()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzkw.zza(r15, r0, r9)
            if (r15 == 0) goto L_0x0206
            int r10 = r29.length()
        L_0x0206:
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkw r1 = r1.zzi()
            java.lang.String r2 = "_ev"
            r28 = r1
            r29 = r36
            r30 = r3
            r31 = r2
            r32 = r0
            r33 = r10
            r28.zza(r29, r30, r31, r32, r33)
            return
        L_0x021e:
            java.lang.String r0 = "_o"
            java.lang.String r3 = "_sn"
            java.lang.String r4 = "_si"
            java.lang.String[] r5 = new java.lang.String[]{r0, r3, r2, r4}
            java.util.List r17 = com.google.android.gms.common.util.CollectionUtils.listOf(r5)
            com.google.android.gms.measurement.internal.zzkw r5 = r27.zzp()
            r6 = 1
            r9 = r5
            r5 = 0
            r10 = r36
            r19 = r11
            r11 = r29
            r12 = r32
            r13 = r17
            r14 = r35
            r15 = r6
            android.os.Bundle r15 = r9.zza(r10, r11, r12, r13, r14, r15)
            if (r15 == 0) goto L_0x026d
            boolean r6 = r15.containsKey(r2)
            if (r6 == 0) goto L_0x026d
            boolean r6 = r15.containsKey(r4)
            if (r6 != 0) goto L_0x0253
            goto L_0x026d
        L_0x0253:
            java.lang.String r3 = r15.getString(r3)
            java.lang.String r2 = r15.getString(r2)
            long r9 = r15.getLong(r4)
            java.lang.Long r4 = java.lang.Long.valueOf(r9)
            com.google.android.gms.measurement.internal.zzik r11 = new com.google.android.gms.measurement.internal.zzik
            long r9 = r4.longValue()
            r11.<init>(r3, r2, r9)
            goto L_0x026f
        L_0x026d:
            r11 = r19
        L_0x026f:
            if (r11 != 0) goto L_0x0273
            r14 = r1
            goto L_0x0274
        L_0x0273:
            r14 = r11
        L_0x0274:
            com.google.android.gms.measurement.internal.zzy r1 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzaq.zzat
            boolean r1 = r1.zza(r2)
            java.lang.String r13 = "_ae"
            r9 = 0
            if (r1 == 0) goto L_0x02af
            r27.zzu()
            com.google.android.gms.measurement.internal.zzin r1 = r27.zzi()
            com.google.android.gms.measurement.internal.zzik r1 = r1.zza(r5)
            if (r1 == 0) goto L_0x02af
            r12 = r29
            boolean r1 = r13.equals(r12)
            if (r1 == 0) goto L_0x02b1
            com.google.android.gms.measurement.internal.zzjw r1 = r27.zzk()
            com.google.android.gms.measurement.internal.zzkc r1 = r1.zzb
            long r1 = r1.zzb()
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x02b1
            com.google.android.gms.measurement.internal.zzkw r3 = r27.zzp()
            r3.zza(r15, r1)
            goto L_0x02b1
        L_0x02af:
            r12 = r29
        L_0x02b1:
            boolean r1 = com.google.android.gms.internal.measurement.zzmv.zzb()
            if (r1 == 0) goto L_0x0333
            com.google.android.gms.measurement.internal.zzy r1 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzaq.zzbu
            boolean r1 = r1.zza(r2)
            if (r1 == 0) goto L_0x0333
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r8)
            java.lang.String r2 = "_ffr"
            if (r1 != 0) goto L_0x0316
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x0316
            com.google.android.gms.measurement.internal.zzkw r1 = r27.zzp()
            java.lang.String r2 = r15.getString(r2)
            boolean r3 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r2)
            if (r3 == 0) goto L_0x02e6
            r11 = r19
            goto L_0x02ea
        L_0x02e6:
            java.lang.String r11 = r2.trim()
        L_0x02ea:
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzs()
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzu
            java.lang.String r2 = r2.zza()
            boolean r2 = com.google.android.gms.measurement.internal.zzkw.zzc(r11, r2)
            if (r2 == 0) goto L_0x0309
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzw()
            java.lang.String r2 = "Not logging duplicate session_start_with_rollout event"
            r1.zza(r2)
            r1 = 0
            goto L_0x0313
        L_0x0309:
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzs()
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzu
            r1.zza(r11)
            r1 = 1
        L_0x0313:
            if (r1 != 0) goto L_0x0333
            return
        L_0x0316:
            boolean r1 = r13.equals(r12)
            if (r1 == 0) goto L_0x0333
            com.google.android.gms.measurement.internal.zzkw r1 = r27.zzp()
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzs()
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzu
            java.lang.String r1 = r1.zza()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0333
            r15.putString(r2, r1)
        L_0x0333:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r11.add(r15)
            com.google.android.gms.measurement.internal.zzkw r1 = r27.zzp()
            java.security.SecureRandom r1 = r1.zzh()
            long r3 = r1.nextLong()
            com.google.android.gms.measurement.internal.zzfl r1 = r27.zzs()
            com.google.android.gms.measurement.internal.zzfp r1 = r1.zzp
            long r1 = r1.zza()
            int r6 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x03b7
            com.google.android.gms.measurement.internal.zzfl r1 = r27.zzs()
            r9 = r30
            boolean r1 = r1.zza(r9)
            if (r1 == 0) goto L_0x03b9
            com.google.android.gms.measurement.internal.zzfl r1 = r27.zzs()
            com.google.android.gms.measurement.internal.zzfn r1 = r1.zzr
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x03b9
            com.google.android.gms.measurement.internal.zzez r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.String r2 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.zza(r2)
            r6 = 0
            com.google.android.gms.common.util.Clock r1 = r27.zzm()
            long r19 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r21 = "_sid"
            r1 = r27
            r22 = r3
            r3 = r21
            r4 = r6
            r5 = r19
            r1.zza(r2, r3, r4, r5)
            r4 = 0
            com.google.android.gms.common.util.Clock r1 = r27.zzm()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r27
            r1.zza(r2, r3, r4, r5)
            com.google.android.gms.common.util.Clock r1 = r27.zzm()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            r1 = r27
            r1.zza(r2, r3, r4, r5)
            goto L_0x03bb
        L_0x03b7:
            r9 = r30
        L_0x03b9:
            r22 = r3
        L_0x03bb:
            java.lang.String r1 = "extend_session"
            r2 = 0
            long r1 = r15.getLong(r1, r2)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x03e3
            com.google.android.gms.measurement.internal.zzez r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzjw r1 = r1.zze()
            com.google.android.gms.measurement.internal.zzke r1 = r1.zza
            r5 = 1
            r1.zza(r9, r5)
            goto L_0x03e4
        L_0x03e3:
            r5 = 1
        L_0x03e4:
            java.util.Set r1 = r15.keySet()
            int r2 = r15.size()
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.util.Arrays.sort(r1)
            boolean r2 = com.google.android.gms.internal.measurement.zzmo.zzb()
            if (r2 == 0) goto L_0x0436
            com.google.android.gms.measurement.internal.zzy r2 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzcg
            boolean r2 = r2.zza(r3)
            if (r2 == 0) goto L_0x0436
            com.google.android.gms.measurement.internal.zzy r2 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzcf
            boolean r2 = r2.zza(r3)
            if (r2 == 0) goto L_0x0436
            int r2 = r1.length
            r3 = 0
        L_0x0417:
            if (r3 >= r2) goto L_0x042e
            r4 = r1[r3]
            r27.zzp()
            java.lang.Object r6 = r15.get(r4)
            android.os.Bundle[] r6 = com.google.android.gms.measurement.internal.zzkw.zzb(r6)
            if (r6 == 0) goto L_0x042b
            r15.putParcelableArray(r4, r6)
        L_0x042b:
            int r3 = r3 + 1
            goto L_0x0417
        L_0x042e:
            r10 = r11
            r11 = r12
            r26 = r13
            r24 = 1
            goto L_0x04f2
        L_0x0436:
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x0439:
            java.lang.String r6 = "_eid"
            if (r3 >= r2) goto L_0x04df
            r5 = r1[r3]
            java.lang.Object r19 = r15.get(r5)
            r27.zzp()
            r32 = r1
            android.os.Bundle[] r1 = com.google.android.gms.measurement.internal.zzkw.zzb(r19)
            r19 = r2
            if (r1 == 0) goto L_0x04be
            int r2 = r1.length
            r15.putInt(r5, r2)
            r2 = 0
        L_0x0455:
            int r9 = r1.length
            if (r2 >= r9) goto L_0x04b0
            r10 = r1[r2]
            r9 = 1
            com.google.android.gms.measurement.internal.zzin.zza(r14, r10, r9)
            com.google.android.gms.measurement.internal.zzkw r18 = r27.zzp()
            r20 = 0
            java.lang.String r21 = "_ep"
            r24 = 1
            r9 = r18
            r18 = r10
            r10 = r36
            r25 = r11
            r11 = r21
            r12 = r18
            r26 = r13
            r13 = r17
            r18 = r14
            r14 = r35
            r7 = r15
            r15 = r20
            android.os.Bundle r9 = r9.zza(r10, r11, r12, r13, r14, r15)
            java.lang.String r10 = "_en"
            r11 = r29
            r9.putString(r10, r11)
            r12 = r22
            r9.putLong(r6, r12)
            java.lang.String r10 = "_gn"
            r9.putString(r10, r5)
            int r10 = r1.length
            java.lang.String r14 = "_ll"
            r9.putInt(r14, r10)
            java.lang.String r10 = "_i"
            r9.putInt(r10, r2)
            r10 = r25
            r10.add(r9)
            int r2 = r2 + 1
            r15 = r7
            r14 = r18
            r13 = r26
            r7 = r27
            r12 = r11
            r11 = r10
            goto L_0x0455
        L_0x04b0:
            r10 = r11
            r11 = r12
            r26 = r13
            r18 = r14
            r7 = r15
            r12 = r22
            r24 = 1
            int r1 = r1.length
            int r4 = r4 + r1
            goto L_0x04c9
        L_0x04be:
            r10 = r11
            r11 = r12
            r26 = r13
            r18 = r14
            r7 = r15
            r12 = r22
            r24 = 1
        L_0x04c9:
            int r3 = r3 + 1
            r1 = r32
            r15 = r7
            r22 = r12
            r14 = r18
            r2 = r19
            r13 = r26
            r5 = 1
            r7 = r27
            r12 = r11
            r11 = r10
            r9 = r30
            goto L_0x0439
        L_0x04df:
            r10 = r11
            r11 = r12
            r26 = r13
            r7 = r15
            r12 = r22
            r24 = 1
            if (r4 == 0) goto L_0x04f2
            r7.putLong(r6, r12)
            java.lang.String r1 = "_epc"
            r7.putInt(r1, r4)
        L_0x04f2:
            r7 = 0
        L_0x04f3:
            int r1 = r10.size()
            if (r7 >= r1) goto L_0x055b
            java.lang.Object r1 = r10.get(r7)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r7 == 0) goto L_0x0503
            r2 = 1
            goto L_0x0504
        L_0x0503:
            r2 = 0
        L_0x0504:
            if (r2 == 0) goto L_0x0509
            java.lang.String r2 = "_ep"
            goto L_0x050a
        L_0x0509:
            r2 = r11
        L_0x050a:
            r1.putString(r0, r8)
            if (r34 == 0) goto L_0x0517
            com.google.android.gms.measurement.internal.zzkw r3 = r27.zzp()
            android.os.Bundle r1 = r3.zza(r1)
        L_0x0517:
            r9 = r1
            com.google.android.gms.measurement.internal.zzao r12 = new com.google.android.gms.measurement.internal.zzao
            com.google.android.gms.measurement.internal.zzan r3 = new com.google.android.gms.measurement.internal.zzan
            r3.<init>(r9)
            r1 = r12
            r4 = r28
            r13 = 1
            r5 = r30
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzis r1 = r27.zzh()
            r14 = r36
            r1.zza(r12, r14)
            r12 = r27
            if (r16 != 0) goto L_0x0556
            java.util.Set<com.google.android.gms.measurement.internal.zzhf> r1 = r12.zze
            java.util.Iterator r15 = r1.iterator()
        L_0x053b:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x0556
            java.lang.Object r1 = r15.next()
            com.google.android.gms.measurement.internal.zzhf r1 = (com.google.android.gms.measurement.internal.zzhf) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r9)
            r2 = r28
            r3 = r29
            r5 = r30
            r1.onEvent(r2, r3, r4, r5)
            goto L_0x053b
        L_0x0556:
            int r7 = r7 + 1
            r24 = 1
            goto L_0x04f3
        L_0x055b:
            r12 = r27
            r13 = 1
            r27.zzu()
            com.google.android.gms.measurement.internal.zzin r0 = r27.zzi()
            r1 = 0
            com.google.android.gms.measurement.internal.zzik r0 = r0.zza(r1)
            if (r0 == 0) goto L_0x0583
            r0 = r26
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0583
            com.google.android.gms.measurement.internal.zzjw r0 = r27.zzk()
            com.google.android.gms.common.util.Clock r1 = r27.zzm()
            long r1 = r1.elapsedRealtime()
            r0.zza(r13, r13, r1)
        L_0x0583:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhh.zza(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        zzb();
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (zzt().zza(zzaq.zzcc)) {
            if (zzkw.zzc(str2, "screen_view")) {
                zzi().zza(bundle2, j);
                return;
            }
        }
        zzb(str3, str2, j, bundle2, z2, !z2 || this.zzd == null || zzkw.zze(str2), !z, null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzq().zza(new zzhk(this, str, str2, j, zzkw.zzb(bundle), z, z2, z3, str3));
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, true, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = "app";
        }
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzp().zzc(str2);
        } else {
            zzkw zzp = zzp();
            if (zzp.zza("user property", str2)) {
                if (!zzp.zza("user property", zzhd.zza, str2)) {
                    i = 15;
                } else if (zzp.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzp();
            String zza2 = zzkw.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzy.zzi().zza(i, "_ev", zza2, i2);
        } else if (obj != null) {
            int zzb2 = zzp().zzb(str2, obj);
            if (zzb2 != 0) {
                zzp();
                String zza3 = zzkw.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzy.zzi().zza(zzb2, "_ev", zza3, i2);
                return;
            }
            Object zzc2 = zzp().zzc(str2, obj);
            if (zzc2 != null) {
                zza(str, str2, j, zzc2);
            }
        } else {
            zza(str, str2, j, (Object) null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzq().zza(new zzhn(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzd()
            r8.zzb()
            r8.zzw()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0067
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0056
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0056
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x0038
            r4 = r2
            goto L_0x003a
        L_0x0038:
            r4 = 0
        L_0x003a:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzfl r0 = r8.zzs()
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzn
            r4 = r10
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0051
            java.lang.String r11 = "true"
        L_0x0051:
            r0.zza(r11)
            r6 = r10
            goto L_0x0065
        L_0x0056:
            if (r11 != 0) goto L_0x0067
            com.google.android.gms.measurement.internal.zzfl r10 = r8.zzs()
            com.google.android.gms.measurement.internal.zzfr r10 = r10.zzn
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r6 = r11
        L_0x0065:
            r3 = r1
            goto L_0x0069
        L_0x0067:
            r3 = r10
            r6 = r11
        L_0x0069:
            com.google.android.gms.measurement.internal.zzgd r10 = r8.zzy
            boolean r10 = r10.zzab()
            if (r10 != 0) goto L_0x007f
            com.google.android.gms.measurement.internal.zzez r9 = r8.zzr()
            com.google.android.gms.measurement.internal.zzfb r9 = r9.zzx()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x007f:
            com.google.android.gms.measurement.internal.zzgd r10 = r8.zzy
            boolean r10 = r10.zzag()
            if (r10 != 0) goto L_0x0088
            return
        L_0x0088:
            com.google.android.gms.measurement.internal.zzkr r10 = new com.google.android.gms.measurement.internal.zzkr
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzis r9 = r8.zzh()
            r9.zza(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhh.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzkr> zzb(boolean z) {
        zzb();
        zzw();
        zzr().zzx().zza("Getting user properties (FE)");
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzx.zza()) {
            zzr().zzf().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzq().zza(atomicReference, 5000, "get user properties", new zzhm(this, atomicReference, z));
            List<zzkr> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzr().zzf().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
    }

    public final String zzah() {
        zzb();
        return this.zzg.get();
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str) {
        this.zzg.set(str);
    }

    public final void zzai() {
        zzd();
        zzb();
        zzw();
        if (this.zzy.zzag()) {
            if (zzt().zza(zzaq.zzbg)) {
                zzy zzt = zzt();
                zzt.zzu();
                Boolean zze2 = zzt.zze("google_analytics_deferred_deep_link_enabled");
                if (zze2 != null && zze2.booleanValue()) {
                    zzr().zzw().zza("Deferred Deep Link feature enabled.");
                    zzq().zza(new zzhj(this));
                }
            }
            zzh().zzae();
            this.zzc = false;
            String zzw = zzs().zzw();
            if (!TextUtils.isEmpty(zzw)) {
                zzl().zzaa();
                if (!zzw.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzw);
                    zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
                }
            }
        }
    }

    public final void zza(zzhc zzhc) {
        zzhc zzhc2;
        zzd();
        zzb();
        zzw();
        if (!(zzhc == null || zzhc == (zzhc2 = this.zzd))) {
            Preconditions.checkState(zzhc2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzhc;
    }

    public final void zza(zzhf zzhf) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhf);
        if (!this.zze.add(zzhf)) {
            zzr().zzi().zza("OnEventListener already registered");
        }
    }

    public final void zzb(zzhf zzhf) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhf);
        if (!this.zze.remove(zzhf)) {
            zzr().zzi().zza("OnEventListener had not been registered");
        }
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzm().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzb();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzr().zzi().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        zzb(bundle2, j);
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zza();
        zzb(new Bundle(bundle), zzm().currentTimeMillis());
    }

    private final void zzb(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzgy.zza(bundle, "app_id", String.class, null);
        zzgy.zza(bundle, "origin", String.class, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
        zzgy.zza(bundle, "value", Object.class, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle.get("value");
        if (zzp().zzc(string) != 0) {
            zzr().zzf().zza("Invalid conditional user property name", zzo().zzc(string));
        } else if (zzp().zzb(string, obj) != 0) {
            zzr().zzf().zza("Invalid conditional user property value", zzo().zzc(string), obj);
        } else {
            Object zzc2 = zzp().zzc(string, obj);
            if (zzc2 == null) {
                zzr().zzf().zza("Unable to normalize conditional user property value", zzo().zzc(string), obj);
                return;
            }
            zzgy.zza(bundle, zzc2);
            long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzr().zzf().zza("Invalid conditional user property time to live", zzo().zzc(string), Long.valueOf(j3));
                } else {
                    zzq().zza(new zzhr(this, bundle));
                }
            } else {
                zzr().zzf().zza("Invalid conditional user property timeout", zzo().zzc(string), Long.valueOf(j2));
            }
        }
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zzb();
        zzb((String) null, str, str2, bundle);
    }

    public final void zza(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zza();
        zzb(str, str2, str3, bundle);
    }

    private final void zzb(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzm().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzq().zza(new zzhq(this, bundle2));
    }

    /* access modifiers changed from: private */
    public final void zzc(Bundle bundle) {
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        if (!this.zzy.zzab()) {
            zzr().zzx().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkr zzkr = new zzkr(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), bundle.getString("origin"));
        try {
            zzao zza2 = zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle.getString("origin"), 0, true, false);
            zzh().zza(new zzw(bundle.getString("app_id"), bundle.getString("origin"), zzkr, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle.getString("origin"), 0, true, false), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zza2, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle.getString("origin"), 0, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void zzd(Bundle bundle) {
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (!this.zzy.zzab()) {
            zzr().zzx().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzh().zza(new zzw(bundle.getString("app_id"), bundle.getString("origin"), new zzkr(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), 0, null, null), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle.getString("origin"), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        zzb();
        return zzb((String) null, str, str2);
    }

    public final ArrayList<Bundle> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3);
    }

    private final ArrayList<Bundle> zzb(String str, String str2, String str3) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzx.zza()) {
            zzr().zzf().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzq().zza(atomicReference, 5000, "get conditional user properties", new zzhs(this, atomicReference, str, str2, str3));
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzkw.zzb((List<zzw>) list);
            }
            zzr().zzf().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzb();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> zza(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3, z);
    }

    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzx.zza()) {
            zzr().zzf().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzq().zza(atomicReference, 5000, "get user properties", new zzhv(this, atomicReference, str, str2, str3, z));
            List<zzkr> list = (List) atomicReference.get();
            if (list == null) {
                zzr().zzf().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzkr zzkr : list) {
                arrayMap.put(zzkr.zza, zzkr.zza());
            }
            return arrayMap;
        }
    }

    public final String zzaj() {
        zzik zzab = this.zzy.zzv().zzab();
        if (zzab != null) {
            return zzab.zza;
        }
        return null;
    }

    public final String zzak() {
        zzik zzab = this.zzy.zzv().zzab();
        if (zzab != null) {
            return zzab.zzb;
        }
        return null;
    }

    public final String zzal() {
        if (this.zzy.zzo() != null) {
            return this.zzy.zzo();
        }
        try {
            return zzil.zza(zzn(), "google_app_id");
        } catch (IllegalStateException e) {
            this.zzy.zzr().zzf().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzhh zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzes zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzis zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzin zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzev zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzjw zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzex zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzkw zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzfw zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzez zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzfl zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }
}
