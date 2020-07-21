package com.google.android.gms.internal.vision;

import android.os.Binder;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final /* synthetic */ class zzay {
    public static <V> V zza(zzbb<V> zzbb) {
        long clearCallingIdentity;
        try {
            return zzbb.zzu();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zzu = zzbb.zzu();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zzu;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
