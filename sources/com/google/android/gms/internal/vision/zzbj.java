package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public abstract class zzbj<T> {
    private static volatile Context zzg;
    private static final Object zzgg = new Object();
    private static volatile boolean zzgh = false;
    private static final AtomicReference<Collection<zzbj<?>>> zzgi = new AtomicReference<>();
    private static volatile zzcz<zzcs<zzbf>> zzgj;
    private static final AtomicInteger zzgm = new AtomicInteger();
    private final String name;
    private final zzbp zzgk;
    private final T zzgl;
    private volatile int zzgn;
    private volatile T zzgo;
    private final boolean zzgp;

    public static void init(Context context) {
        synchronized (zzgg) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzg != context) {
                zzav.zzy();
                zzbo.zzy();
                zzba.zzab();
                zzgj = zzdc.zza(zzbi.zzgf);
                zzg = context;
                zzgm.incrementAndGet();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    public static void maybeInit(Context context) {
        if (zzg == null) {
            synchronized (zzgg) {
                if (zzg == null) {
                    init(context);
                }
            }
        }
    }

    static void zzac() {
        zzgm.incrementAndGet();
    }

    private zzbj(zzbp zzbp, String str, T t, boolean z) {
        this.zzgn = -1;
        if (zzbp.zzgu == null && zzbp.zzgv == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        } else if (zzbp.zzgu == null || zzbp.zzgv == null) {
            this.zzgk = zzbp;
            this.name = str;
            this.zzgl = t;
            this.zzgp = z;
        } else {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
    }

    private final String zze(String str) {
        if (str != null && str.isEmpty()) {
            return this.name;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.name);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String zzad() {
        return zze(this.zzgk.zzgx);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T get() {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = com.google.android.gms.internal.vision.zzbj.zzgm
            int r0 = r0.get()
            int r1 = r6.zzgn
            if (r1 >= r0) goto L_0x0078
            monitor-enter(r6)
            int r1 = r6.zzgn     // Catch:{ all -> 0x0075 }
            if (r1 >= r0) goto L_0x0073
            android.content.Context r1 = com.google.android.gms.internal.vision.zzbj.zzg     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x006b
            com.google.android.gms.internal.vision.zzbp r1 = r6.zzgk     // Catch:{ all -> 0x0075 }
            boolean r1 = r1.zzgz     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0027
            java.lang.Object r1 = r6.zzaf()     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0020
            goto L_0x0037
        L_0x0020:
            java.lang.Object r1 = r6.zzae()     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0027:
            java.lang.Object r1 = r6.zzae()     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x002e
            goto L_0x0037
        L_0x002e:
            java.lang.Object r1 = r6.zzaf()     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            T r1 = r6.zzgl     // Catch:{ all -> 0x0075 }
        L_0x0037:
            com.google.android.gms.internal.vision.zzcz<com.google.android.gms.internal.vision.zzcs<com.google.android.gms.internal.vision.zzbf>> r2 = com.google.android.gms.internal.vision.zzbj.zzgj     // Catch:{ all -> 0x0075 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0075 }
            com.google.android.gms.internal.vision.zzcs r2 = (com.google.android.gms.internal.vision.zzcs) r2     // Catch:{ all -> 0x0075 }
            boolean r3 = r2.isPresent()     // Catch:{ all -> 0x0075 }
            if (r3 == 0) goto L_0x0066
            java.lang.Object r1 = r2.get()     // Catch:{ all -> 0x0075 }
            com.google.android.gms.internal.vision.zzbf r1 = (com.google.android.gms.internal.vision.zzbf) r1     // Catch:{ all -> 0x0075 }
            com.google.android.gms.internal.vision.zzbp r2 = r6.zzgk     // Catch:{ all -> 0x0075 }
            android.net.Uri r2 = r2.zzgv     // Catch:{ all -> 0x0075 }
            com.google.android.gms.internal.vision.zzbp r3 = r6.zzgk     // Catch:{ all -> 0x0075 }
            java.lang.String r3 = r3.zzgu     // Catch:{ all -> 0x0075 }
            com.google.android.gms.internal.vision.zzbp r4 = r6.zzgk     // Catch:{ all -> 0x0075 }
            java.lang.String r4 = r4.zzgx     // Catch:{ all -> 0x0075 }
            java.lang.String r5 = r6.name     // Catch:{ all -> 0x0075 }
            java.lang.String r1 = r1.zza(r2, r3, r4, r5)     // Catch:{ all -> 0x0075 }
            if (r1 != 0) goto L_0x0062
            T r1 = r6.zzgl     // Catch:{ all -> 0x0075 }
            goto L_0x0066
        L_0x0062:
            java.lang.Object r1 = r6.zza(r1)     // Catch:{ all -> 0x0075 }
        L_0x0066:
            r6.zzgo = r1     // Catch:{ all -> 0x0075 }
            r6.zzgn = r0     // Catch:{ all -> 0x0075 }
            goto L_0x0073
        L_0x006b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0075 }
            java.lang.String r1 = "Must call PhenotypeFlag.init() first"
            r0.<init>(r1)     // Catch:{ all -> 0x0075 }
            throw r0     // Catch:{ all -> 0x0075 }
        L_0x0073:
            monitor-exit(r6)     // Catch:{ all -> 0x0075 }
            goto L_0x0078
        L_0x0075:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0075 }
            throw r0
        L_0x0078:
            T r0 = r6.zzgo
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzbj.get():java.lang.Object");
    }

    @Nullable
    private final T zzae() {
        zzaz zzaz;
        Object zzb;
        boolean z = false;
        if (!this.zzgk.zzha) {
            String str = (String) zzba.zze(zzg).zzb("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
            if (str != null && zzaq.zzfc.matcher(str).matches()) {
                z = true;
            }
        }
        if (!z) {
            if (this.zzgk.zzgv == null) {
                zzaz = zzbo.zzb(zzg, this.zzgk.zzgu);
            } else if (!zzbh.zza(zzg, this.zzgk.zzgv)) {
                zzaz = null;
            } else if (this.zzgk.zzhb) {
                ContentResolver contentResolver = zzg.getContentResolver();
                String lastPathSegment = this.zzgk.zzgv.getLastPathSegment();
                String packageName = zzg.getPackageName();
                StringBuilder sb = new StringBuilder(String.valueOf(lastPathSegment).length() + 1 + String.valueOf(packageName).length());
                sb.append(lastPathSegment);
                sb.append("#");
                sb.append(packageName);
                zzaz = zzav.zza(contentResolver, zzbg.getContentProviderUri(sb.toString()));
            } else {
                zzaz = zzav.zza(zzg.getContentResolver(), this.zzgk.zzgv);
            }
            if (!(zzaz == null || (zzb = zzaz.zzb(zzad())) == null)) {
                return zza(zzb);
            }
        } else if (Log.isLoggable("PhenotypeFlag", 3)) {
            String valueOf = String.valueOf(zzad());
            Log.d("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
        }
        return null;
    }

    @Nullable
    private final T zzaf() {
        if (!this.zzgk.zzgy && (this.zzgk.zzhc == null || this.zzgk.zzhc.apply(zzg).booleanValue())) {
            Object zzb = zzba.zze(zzg).zzb(this.zzgk.zzgy ? null : zze(this.zzgk.zzgw));
            if (zzb != null) {
                return zza(zzb);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static zzbj<Long> zza(zzbp zzbp, String str, long j, boolean z) {
        return new zzbl(zzbp, str, Long.valueOf(j), true);
    }

    /* access modifiers changed from: private */
    public static zzbj<Boolean> zza(zzbp zzbp, String str, boolean z, boolean z2) {
        return new zzbk(zzbp, str, Boolean.valueOf(z), true);
    }

    /* access modifiers changed from: private */
    public static <T> zzbj<T> zza(zzbp zzbp, String str, T t, zzbm<T> zzbm, boolean z) {
        return new zzbn(zzbp, str, t, true, zzbm);
    }

    static final /* synthetic */ zzcs zzag() {
        new zzbe();
        return zzbe.zzf(zzg);
    }

    /* synthetic */ zzbj(zzbp zzbp, String str, Object obj, boolean z, zzbl zzbl) {
        this(zzbp, str, obj, z);
    }
}
