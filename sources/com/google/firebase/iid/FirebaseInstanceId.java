package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
public class FirebaseInstanceId {
    private static final long zza = TimeUnit.HOURS.toSeconds(8);
    private static zzaz zzb;
    private static ScheduledExecutorService zzc;
    private final Executor zzd;
    /* access modifiers changed from: private */
    public final FirebaseApp zze;
    private final zzao zzf;
    private final zzt zzg;
    private final zzat zzh;
    private final FirebaseInstallationsApi zzi;
    private boolean zzj;
    private final zza zzk;

    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static FirebaseInstanceId getInstance(FirebaseApp firebaseApp) {
        return (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
    public class zza {
        private boolean zzb;
        private final Subscriber zzc;
        private boolean zzd;
        private EventHandler<DataCollectionDefaultChange> zze;
        private Boolean zzf;

        zza(Subscriber subscriber) {
            this.zzc = subscriber;
        }

        private final synchronized void zzb() {
            if (!this.zzd) {
                this.zzb = zzd();
                Boolean zzc2 = zzc();
                this.zzf = zzc2;
                if (zzc2 == null && this.zzb) {
                    zzq zzq = new zzq(this);
                    this.zze = zzq;
                    this.zzc.subscribe(DataCollectionDefaultChange.class, zzq);
                }
                this.zzd = true;
            }
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean zza() {
            zzb();
            if (this.zzf == null) {
                return this.zzb && FirebaseInstanceId.this.zze.isDataCollectionDefaultEnabled();
            }
            return this.zzf.booleanValue();
        }

        /* access modifiers changed from: package-private */
        public final synchronized void zza(boolean z) {
            zzb();
            if (this.zze != null) {
                this.zzc.unsubscribe(DataCollectionDefaultChange.class, this.zze);
                this.zze = null;
            }
            SharedPreferences.Editor edit = FirebaseInstanceId.this.zze.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseInstanceId.this.zzj();
            }
            this.zzf = Boolean.valueOf(z);
        }

        private final Boolean zzc() {
            ApplicationInfo applicationInfo;
            Context applicationContext = FirebaseInstanceId.this.zze.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private final boolean zzd() {
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessaging");
                return true;
            } catch (ClassNotFoundException unused) {
                Context applicationContext = FirebaseInstanceId.this.zze.getApplicationContext();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(applicationContext.getPackageName());
                ResolveInfo resolveService = applicationContext.getPackageManager().resolveService(intent, 0);
                if (resolveService == null || resolveService.serviceInfo == null) {
                    return false;
                }
                return true;
            }
        }
    }

    FirebaseInstanceId(FirebaseApp firebaseApp, Subscriber subscriber, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, new zzao(firebaseApp.getApplicationContext()), zzh.zzb(), zzh.zzb(), subscriber, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi);
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzao zzao, Executor executor, Executor executor2, Subscriber subscriber, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.zzj = false;
        if (zzao.zza(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (zzb == null) {
                    zzb = new zzaz(firebaseApp.getApplicationContext());
                }
            }
            this.zze = firebaseApp;
            this.zzf = zzao;
            this.zzg = new zzt(firebaseApp, zzao, executor, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi);
            this.zzd = executor2;
            this.zzk = new zza(subscriber);
            this.zzh = new zzat(executor);
            this.zzi = firebaseInstallationsApi;
            executor2.execute(new zzl(this));
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    /* access modifiers changed from: private */
    public final void zzj() {
        if (zza(zzb())) {
            zzk();
        }
    }

    /* access modifiers changed from: package-private */
    public final FirebaseApp zza() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(boolean z) {
        this.zzj = z;
    }

    private final synchronized void zzk() {
        if (!this.zzj) {
            zza(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(long j) {
        zza(new zzbb(this, Math.min(Math.max(30L, j << 1), zza)), j);
        this.zzj = true;
    }

    static void zza(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (zzc == null) {
                zzc = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            zzc.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    public String getId() {
        zza(this.zze);
        zzj();
        return zzl();
    }

    private static void zza(FirebaseApp firebaseApp) {
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getProjectId(), "FirebaseApp has to define a valid projectId.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApplicationId(), "FirebaseApp has to define a valid applicationId.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApiKey(), "FirebaseApp has to define a valid apiKey.");
    }

    private final String zzl() {
        try {
            zzb.zzb(this.zze.getPersistenceKey());
            Task<String> id2 = this.zzi.getId();
            Preconditions.checkNotNull(id2, "Task must not be null");
            CountDownLatch countDownLatch = new CountDownLatch(1);
            id2.addOnCompleteListener(zzn.zza, new zzm(countDownLatch));
            countDownLatch.await(30000, TimeUnit.MILLISECONDS);
            if (id2.isSuccessful()) {
                return id2.getResult();
            }
            if (id2.isCanceled()) {
                throw new CancellationException("Task is already canceled");
            }
            throw new IllegalStateException(id2.getException());
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    public long getCreationTime() {
        return zzb.zza(this.zze.getPersistenceKey());
    }

    public Task<InstanceIdResult> getInstanceId() {
        return zza(zzao.zza(this.zze), "*");
    }

    private final Task<InstanceIdResult> zza(String str, String str2) {
        return Tasks.forResult(null).continueWithTask(this.zzd, new zzk(this, str, zza(str2)));
    }

    public void deleteInstanceId() throws IOException {
        zza(this.zze);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            zza(this.zzi.delete());
            zze();
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    @Deprecated
    public String getToken() {
        zza(this.zze);
        zzay zzb2 = zzb();
        if (zza(zzb2)) {
            zzk();
        }
        return zzay.zza(zzb2);
    }

    public String getToken(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((InstanceIdResult) zza(zza(str, str2))).getToken();
        }
        throw new IOException("MAIN_THREAD");
    }

    /* access modifiers changed from: package-private */
    public final zzay zzb() {
        return zzb(zzao.zza(this.zze), "*");
    }

    private final zzay zzb(String str, String str2) {
        return zzb.zza(zzm(), str, str2);
    }

    /* access modifiers changed from: package-private */
    public final String zzc() throws IOException {
        return getToken(zzao.zza(this.zze), "*");
    }

    private final <T> T zza(Task<T> task) throws IOException {
        try {
            return Tasks.await(task, 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    zze();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    public void deleteToken(String str, String str2) throws IOException {
        zza(this.zze);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            String zza2 = zza(str2);
            zza(this.zzg.zzb(zzl(), str, zza2));
            zzb.zzb(zzm(), str, zza2);
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    static boolean zzd() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zze() {
        zzb.zza();
        if (this.zzk.zza()) {
            zzk();
        }
    }

    public final boolean zzf() {
        return this.zzf.zza();
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        zzb.zzc(zzm());
        zzk();
    }

    public final boolean zzh() {
        return this.zzk.zza();
    }

    public final void zzb(boolean z) {
        this.zzk.zza(z);
    }

    private static String zza(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    private final String zzm() {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.zze.getName())) {
            return "";
        }
        return this.zze.getPersistenceKey();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzay zzay) {
        return zzay == null || zzay.zzb(this.zzf.zzc());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(String str, String str2, Task task) throws Exception {
        String zzl = zzl();
        zzay zzb2 = zzb(str, str2);
        if (!zza(zzb2)) {
            return Tasks.forResult(new zzaa(zzl, zzb2.zza));
        }
        return this.zzh.zza(str, str2, new zzp(this, zzl, str, str2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(String str, String str2, String str3) {
        return this.zzg.zza(str, str2, str3).onSuccessTask(this.zzd, new zzo(this, str2, str3, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(String str, String str2, String str3, String str4) throws Exception {
        zzb.zza(zzm(), str, str2, str4, this.zzf.zzc());
        return Tasks.forResult(new zzaa(str3, str4));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        if (this.zzk.zza()) {
            zzj();
        }
    }
}
