package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzbo implements zzaz {
    private static final Map<String, zzbo> zzgr = new ArrayMap();
    private final Object zzfu = new Object();
    private volatile Map<String, ?> zzfv;
    private final List<zzaw> zzfw = new ArrayList();
    private final SharedPreferences zzgs;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzgt = new zzbr(this);

    static zzbo zzb(Context context, String str) {
        zzbo zzbo;
        if (!((!zzas.zzt() || str.startsWith("direct_boot:")) ? true : zzas.isUserUnlocked(context))) {
            return null;
        }
        synchronized (zzbo.class) {
            zzbo = zzgr.get(str);
            if (zzbo == null) {
                zzbo = new zzbo(zzc(context, str));
                zzgr.put(str, zzbo);
            }
        }
        return zzbo;
    }

    private static SharedPreferences zzc(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (zzas.zzt()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return context.getSharedPreferences(str.substring(12), 0);
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return sharedPreferences;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private zzbo(SharedPreferences sharedPreferences) {
        this.zzgs = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.zzgt);
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.gms.internal.vision.zzaz
    public final Object zzb(String str) {
        Map<String, ?> map = this.zzfv;
        if (map == null) {
            synchronized (this.zzfu) {
                map = this.zzfv;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzgs.getAll();
                        this.zzfv = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    static synchronized void zzy() {
        synchronized (zzbo.class) {
            for (zzbo zzbo : zzgr.values()) {
                zzbo.zzgs.unregisterOnSharedPreferenceChangeListener(zzbo.zzgt);
            }
            zzgr.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzfu) {
            this.zzfv = null;
            zzbj.zzac();
        }
        synchronized (this) {
            for (zzaw zzaw : this.zzfw) {
                zzaw.zzaa();
            }
        }
    }
}
