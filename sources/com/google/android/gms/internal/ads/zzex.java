package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzcf;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzex {
    private static final String TAG = zzex.class.getSimpleName();
    protected Context zzvr;
    private volatile boolean zzxi;
    private zzev zzys;
    private ExecutorService zzyt;
    private DexClassLoader zzyu;
    private zzei zzyv;
    private byte[] zzyw;
    private volatile AdvertisingIdClient zzyx = null;
    private Future zzyy;
    private boolean zzyz;
    /* access modifiers changed from: private */
    public volatile zzcf.zza zzza;
    private Future zzzb;
    private zzdu zzzc;
    private boolean zzzd;
    private boolean zzze;
    private Map<Pair<String, String>, zzgk> zzzf;
    private boolean zzzg;

    public static zzex zza(Context context, String str, String str2, boolean z) {
        zzex zzex = new zzex(context);
        try {
            zzex.zzyt = Executors.newCachedThreadPool(new zzfa());
            zzex.zzxi = z;
            if (z) {
                zzex.zzyy = zzex.zzyt.submit(new zzez(zzex));
            }
            zzex.zzyt.execute(new zzfb(zzex));
            try {
                GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
                zzex.zzzd = instance.getApkVersion(zzex.zzvr) > 0;
                zzex.zzze = instance.isGooglePlayServicesAvailable(zzex.zzvr) == 0;
            } catch (Throwable unused) {
            }
            zzex.zza(0, true);
            if (zzfg.isMainThread()) {
                if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcqp)).booleanValue()) {
                    throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
                }
            }
            zzei zzei = new zzei(null);
            zzex.zzyv = zzei;
            try {
                zzex.zzyw = zzei.zzao(str);
                try {
                    File cacheDir = zzex.zzvr.getCacheDir();
                    if (cacheDir == null) {
                        cacheDir = zzex.zzvr.getDir("dex", 0);
                        if (cacheDir == null) {
                            throw new zzeu();
                        }
                    }
                    File file = new File(String.format("%s/%s.jar", cacheDir, "1584479576572"));
                    if (!file.exists()) {
                        byte[] zza = zzex.zzyv.zza(zzex.zzyw, str2);
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(zza, 0, zza.length);
                        fileOutputStream.close();
                    }
                    zzex.zzb(cacheDir, "1584479576572");
                    try {
                        zzex.zzyu = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzex.zzvr.getClassLoader());
                        zzc(file);
                        zzex.zza(cacheDir, "1584479576572");
                        zzap(String.format("%s/%s.dex", cacheDir, "1584479576572"));
                        zzex.zzzc = new zzdu(zzex);
                        zzex.zzzg = true;
                        return zzex;
                    } catch (Throwable th) {
                        zzc(file);
                        zzex.zza(cacheDir, "1584479576572");
                        zzap(String.format("%s/%s.dex", cacheDir, "1584479576572"));
                        throw th;
                    }
                } catch (FileNotFoundException e) {
                    throw new zzeu(e);
                } catch (IOException e2) {
                    throw new zzeu(e2);
                } catch (zzeh e3) {
                    throw new zzeu(e3);
                } catch (NullPointerException e4) {
                    throw new zzeu(e4);
                }
            } catch (zzeh e5) {
                throw new zzeu(e5);
            }
        } catch (zzeu unused2) {
        }
    }

    public final Context getContext() {
        return this.zzvr;
    }

    public final boolean isInitialized() {
        return this.zzzg;
    }

    public final ExecutorService zzch() {
        return this.zzyt;
    }

    public final DexClassLoader zzci() {
        return this.zzyu;
    }

    public final zzei zzcj() {
        return this.zzyv;
    }

    public final byte[] zzck() {
        return this.zzyw;
    }

    public final boolean zzcl() {
        return this.zzzd;
    }

    public final zzdu zzcm() {
        return this.zzzc;
    }

    public final boolean zzcn() {
        return this.zzze;
    }

    public final boolean zzcc() {
        return this.zzys.zzcc();
    }

    /* access modifiers changed from: package-private */
    public final zzev zzco() {
        return this.zzys;
    }

    public final zzcf.zza zzcp() {
        return this.zzza;
    }

    public final Future zzcq() {
        return this.zzzb;
    }

    private zzex(Context context) {
        boolean z = false;
        this.zzxi = false;
        this.zzyy = null;
        this.zzza = null;
        this.zzzb = null;
        this.zzzd = false;
        this.zzze = false;
        this.zzzg = false;
        Context applicationContext = context.getApplicationContext();
        z = applicationContext != null ? true : z;
        this.zzyz = z;
        this.zzvr = z ? applicationContext : context;
        this.zzzf = new HashMap();
        if (this.zzys == null) {
            this.zzys = new zzev(this.zzvr);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:20|21|22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cd, code lost:
        r10 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00c0 */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[ExcHandler: zzeh | IOException | NoSuchAlgorithmException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:20:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d4 A[SYNTHETIC, Splitter:B:42:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00db A[SYNTHETIC, Splitter:B:46:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e5 A[SYNTHETIC, Splitter:B:54:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ec A[SYNTHETIC, Splitter:B:58:0x00ec] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "test"
            java.io.File r1 = new java.io.File
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r10
            r5 = 1
            r3[r5] = r11
            java.lang.String r6 = "%s/%s.tmp"
            java.lang.String r3 = java.lang.String.format(r6, r3)
            r1.<init>(r3)
            boolean r3 = r1.exists()
            if (r3 == 0) goto L_0x001d
            return
        L_0x001d:
            java.io.File r3 = new java.io.File
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r10
            r2[r5] = r11
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r2)
            r3.<init>(r10)
            boolean r10 = r3.exists()
            if (r10 != 0) goto L_0x0035
            return
        L_0x0035:
            long r5 = r3.length()
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 > 0) goto L_0x0040
            return
        L_0x0040:
            int r10 = (int) r5
            byte[] r10 = new byte[r10]
            r2 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00d0 }
            r5.<init>(r3)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00d0 }
            int r6 = r5.read(r10)     // Catch:{ all -> 0x00c9 }
            if (r6 > 0) goto L_0x0056
            r5.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            zzc(r3)
            return
        L_0x0056:
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            r6.print(r0)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            r6.print(r0)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            r6.print(r0)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r0 = com.google.android.gms.internal.ads.zzcf.zzc.zzbf()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            byte[] r6 = r6.getBytes()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            com.google.android.gms.internal.ads.zzeer r6 = com.google.android.gms.internal.ads.zzeer.zzu(r6)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r0 = r0.zzd(r6)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            byte[] r11 = r11.getBytes()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            com.google.android.gms.internal.ads.zzeer r11 = com.google.android.gms.internal.ads.zzeer.zzu(r11)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r11 = r0.zzc(r11)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            com.google.android.gms.internal.ads.zzei r0 = r9.zzyv     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            byte[] r6 = r9.zzyw     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            java.lang.String r10 = r0.zzb(r6, r10)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            byte[] r10 = r10.getBytes()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            com.google.android.gms.internal.ads.zzeer r0 = com.google.android.gms.internal.ads.zzeer.zzu(r10)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r0 = r11.zza(r0)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            byte[] r10 = com.google.android.gms.internal.ads.zzcx.zzb(r10)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            com.google.android.gms.internal.ads.zzeer r10 = com.google.android.gms.internal.ads.zzeer.zzu(r10)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            r0.zzb(r10)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            r1.createNewFile()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            r10.<init>(r1)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00cd, zzeh | IOException | NoSuchAlgorithmException -> 0x00cd }
            com.google.android.gms.internal.ads.zzehl r11 = r11.zzbfq()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzegb r11 = (com.google.android.gms.internal.ads.zzegb) r11     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzcf$zzc r11 = (com.google.android.gms.internal.ads.zzcf.zzc) r11     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            int r0 = r11.length     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            r10.write(r11, r4, r0)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            r10.close()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            r5.close()     // Catch:{ IOException -> 0x00c0 }
        L_0x00c0:
            r10.close()     // Catch:{ IOException -> 0x00c3 }
        L_0x00c3:
            zzc(r3)
            return
        L_0x00c7:
            r11 = move-exception
            goto L_0x00cb
        L_0x00c9:
            r11 = move-exception
            r10 = r2
        L_0x00cb:
            r2 = r5
            goto L_0x00d2
        L_0x00cd:
            r10 = r2
        L_0x00ce:
            r2 = r5
            goto L_0x00e3
        L_0x00d0:
            r11 = move-exception
            r10 = r2
        L_0x00d2:
            if (r2 == 0) goto L_0x00d9
            r2.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00d9
        L_0x00d8:
        L_0x00d9:
            if (r10 == 0) goto L_0x00de
            r10.close()     // Catch:{ IOException -> 0x00de }
        L_0x00de:
            zzc(r3)
            throw r11
        L_0x00e2:
            r10 = r2
        L_0x00e3:
            if (r2 == 0) goto L_0x00ea
            r2.close()     // Catch:{ IOException -> 0x00e9 }
            goto L_0x00ea
        L_0x00e9:
        L_0x00ea:
            if (r10 == 0) goto L_0x00ef
            r10.close()     // Catch:{ IOException -> 0x00ef }
        L_0x00ef:
            zzc(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzex.zza(java.io.File, java.lang.String):void");
    }

    private static void zzap(String str) {
        zzc(new File(str));
    }

    private static void zzc(File file) {
        if (!file.exists()) {
            Log.d(TAG, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
            return;
        }
        file.delete();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00dd, code lost:
        r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00cc */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[ExcHandler: zzeh | IOException | NoSuchAlgorithmException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:21:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e4 A[SYNTHETIC, Splitter:B:54:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00eb A[SYNTHETIC, Splitter:B:58:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f2 A[SYNTHETIC, Splitter:B:65:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f9 A[SYNTHETIC, Splitter:B:69:0x00f9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.io.File r0 = new java.io.File
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r10
            r4 = 1
            r2[r4] = r11
            java.lang.String r5 = "%s/%s.tmp"
            java.lang.String r2 = java.lang.String.format(r5, r2)
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x001b
            return r3
        L_0x001b:
            java.io.File r2 = new java.io.File
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r10
            r1[r4] = r11
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r1)
            r2.<init>(r10)
            boolean r10 = r2.exists()
            if (r10 == 0) goto L_0x0033
            return r3
        L_0x0033:
            r10 = 0
            long r5 = r0.length()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x0042
            zzc(r0)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            return r3
        L_0x0042:
            int r1 = (int) r5     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            byte[] r1 = new byte[r1]     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            r5.<init>(r0)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            int r6 = r5.read(r1)     // Catch:{ all -> 0x00d9 }
            if (r6 > 0) goto L_0x005e
            java.lang.String r11 = com.google.android.gms.internal.ads.zzex.TAG     // Catch:{ all -> 0x00d9 }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r11, r1)     // Catch:{ all -> 0x00d9 }
            zzc(r0)     // Catch:{ all -> 0x00d9 }
            r5.close()     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            return r3
        L_0x005e:
            com.google.android.gms.internal.ads.zzefo r6 = com.google.android.gms.internal.ads.zzefo.zzber()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            com.google.android.gms.internal.ads.zzcf$zzc r1 = com.google.android.gms.internal.ads.zzcf.zzc.zzb(r1, r6)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            com.google.android.gms.internal.ads.zzeer r7 = r1.zzbd()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            byte[] r7 = r7.toByteArray()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            r6.<init>(r7)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            boolean r11 = r11.equals(r6)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            if (r11 == 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzeer r11 = r1.zzbc()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            com.google.android.gms.internal.ads.zzeer r6 = r1.zzbb()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            byte[] r6 = r6.toByteArray()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            byte[] r6 = com.google.android.gms.internal.ads.zzcx.zzb(r6)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            if (r11 == 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzeer r11 = r1.zzbe()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            byte[] r6 = r6.getBytes()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            if (r11 != 0) goto L_0x00a8
            goto L_0x00d2
        L_0x00a8:
            com.google.android.gms.internal.ads.zzei r11 = r9.zzyv     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            byte[] r0 = r9.zzyw     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            com.google.android.gms.internal.ads.zzeer r1 = r1.zzbb()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            byte[] r1 = r1.toByteArray()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            r6.<init>(r1)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            byte[] r11 = r11.zza(r0, r6)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            r2.createNewFile()     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            r0.<init>(r2)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00dd, zzeh | IOException | NoSuchAlgorithmException -> 0x00dd }
            int r10 = r11.length     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00d0 }
            r0.write(r11, r3, r10)     // Catch:{ zzeh | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00d0 }
            r5.close()     // Catch:{ IOException -> 0x00cc }
        L_0x00cc:
            r0.close()     // Catch:{ IOException -> 0x00cf }
        L_0x00cf:
            return r4
        L_0x00d0:
            r11 = move-exception
            goto L_0x00db
        L_0x00d2:
            zzc(r0)
            r5.close()     // Catch:{ IOException -> 0x00d8 }
        L_0x00d8:
            return r3
        L_0x00d9:
            r11 = move-exception
            r0 = r10
        L_0x00db:
            r10 = r5
            goto L_0x00e2
        L_0x00dd:
            r0 = r10
        L_0x00de:
            r10 = r5
            goto L_0x00f0
        L_0x00e0:
            r11 = move-exception
            r0 = r10
        L_0x00e2:
            if (r10 == 0) goto L_0x00e9
            r10.close()     // Catch:{ IOException -> 0x00e8 }
            goto L_0x00e9
        L_0x00e8:
        L_0x00e9:
            if (r0 == 0) goto L_0x00ee
            r0.close()     // Catch:{ IOException -> 0x00ee }
        L_0x00ee:
            throw r11
        L_0x00ef:
            r0 = r10
        L_0x00f0:
            if (r10 == 0) goto L_0x00f7
            r10.close()     // Catch:{ IOException -> 0x00f6 }
            goto L_0x00f7
        L_0x00f6:
        L_0x00f7:
            if (r0 == 0) goto L_0x00fc
            r0.close()     // Catch:{ IOException -> 0x00fc }
        L_0x00fc:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzex.zzb(java.io.File, java.lang.String):boolean");
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzzf.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzzf.put(new Pair<>(str, str2), new zzgk(this, str, str2, clsArr));
        return true;
    }

    public final Method zza(String str, String str2) {
        zzgk zzgk = this.zzzf.get(new Pair(str, str2));
        if (zzgk == null) {
            return null;
        }
        return zzgk.zzdc();
    }

    /* access modifiers changed from: private */
    public final void zzcr() {
        try {
            if (this.zzyx == null && this.zzyz) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzvr);
                advertisingIdClient.start();
                this.zzyx = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzyx = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, boolean z) {
        if (this.zzze) {
            Future<?> submit = this.zzyt.submit(new zzfc(this, i, z));
            if (i == 0) {
                this.zzzb = submit;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzcf.zza zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep((long) (i * 1000));
            } catch (InterruptedException unused) {
            }
        }
        return zzcs();
    }

    /* access modifiers changed from: private */
    public static boolean zza(int i, zzcf.zza zza) {
        if (i >= 4) {
            return false;
        }
        if (zza != null && zza.zzak() && !zza.zzag().equals("0000000000000000000000000000000000000000000000000000000000000000") && zza.zzap() && zza.zzaq().zzbh() && zza.zzaq().zzbi() != -2) {
            return false;
        }
        return true;
    }

    private final zzcf.zza zzcs() {
        try {
            return zzdpt.zzj(this.zzvr, this.zzvr.getPackageName(), Integer.toString(this.zzvr.getPackageManager().getPackageInfo(this.zzvr.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final AdvertisingIdClient zzct() {
        if (!this.zzxi) {
            return null;
        }
        if (this.zzyx != null) {
            return this.zzyx;
        }
        Future future = this.zzyy;
        if (future != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.zzyy = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzyy.cancel(true);
            }
        }
        return this.zzyx;
    }

    public final int zzbv() {
        if (this.zzzc != null) {
            return zzdu.zzbv();
        }
        return Integer.MIN_VALUE;
    }
}
