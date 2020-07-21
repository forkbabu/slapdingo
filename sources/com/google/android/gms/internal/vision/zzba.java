package com.google.android.gms.internal.vision;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzba implements zzaz {
    private static zzba zzfz;
    @Nullable
    private final ContentObserver zzft;
    @Nullable
    private final Context zzg;

    static zzba zze(Context context) {
        zzba zzba;
        synchronized (zzba.class) {
            if (zzfz == null) {
                zzfz = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzba(context) : new zzba();
            }
            zzba = zzfz;
        }
        return zzba;
    }

    private zzba(Context context) {
        this.zzg = context;
        this.zzft = new zzbc(this, null);
        context.getContentResolver().registerContentObserver(zzaq.CONTENT_URI, true, this.zzft);
    }

    private zzba() {
        this.zzg = null;
        this.zzft = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final String zzb(String str) {
        if (this.zzg == null) {
            return null;
        }
        try {
            return (String) zzay.zza(new zzbd(this, str));
        } catch (IllegalStateException | SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    static synchronized void zzab() {
        synchronized (zzba.class) {
            if (!(zzfz == null || zzfz.zzg == null || zzfz.zzft == null)) {
                zzfz.zzg.getContentResolver().unregisterContentObserver(zzfz.zzft);
            }
            zzfz = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzd(String str) {
        return zzaq.zza(this.zzg.getContentResolver(), str, (String) null);
    }
}
