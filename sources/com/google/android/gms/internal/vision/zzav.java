package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzav implements zzaz {
    private static final Map<Uri, zzav> zzfr = new ArrayMap();
    private static final String[] zzfx = {"key", "value"};
    private final Uri uri;
    private final ContentResolver zzfs;
    private final ContentObserver zzft = new zzax(this, null);
    private final Object zzfu = new Object();
    private volatile Map<String, String> zzfv;
    private final List<zzaw> zzfw = new ArrayList();

    private zzav(ContentResolver contentResolver, Uri uri2) {
        this.zzfs = contentResolver;
        this.uri = uri2;
        contentResolver.registerContentObserver(uri2, false, this.zzft);
    }

    public static zzav zza(ContentResolver contentResolver, Uri uri2) {
        zzav zzav;
        synchronized (zzav.class) {
            zzav = zzfr.get(uri2);
            if (zzav == null) {
                try {
                    zzav zzav2 = new zzav(contentResolver, uri2);
                    try {
                        zzfr.put(uri2, zzav2);
                    } catch (SecurityException unused) {
                    }
                    zzav = zzav2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzav;
    }

    private final Map<String, String> zzv() {
        Map<String, String> map = this.zzfv;
        if (map == null) {
            synchronized (this.zzfu) {
                map = this.zzfv;
                if (map == null) {
                    map = zzx();
                    this.zzfv = map;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    public final void zzw() {
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

    /* JADX INFO: finally extract failed */
    private final Map<String, String> zzx() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Map<String, String> map = (Map) zzay.zza(new zzau(this));
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return map;
        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return null;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    static synchronized void zzy() {
        synchronized (zzav.class) {
            for (zzav zzav : zzfr.values()) {
                zzav.zzfs.unregisterContentObserver(zzav.zzft);
            }
            zzfr.clear();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzaz
    public final /* synthetic */ Object zzb(String str) {
        return zzv().get(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map zzz() {
        Map map;
        Cursor query = this.zzfs.query(this.uri, zzfx, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            query.close();
            return map;
        } finally {
            query.close();
        }
    }
}
