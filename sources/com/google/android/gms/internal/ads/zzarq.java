package com.google.android.gms.internal.ads;

import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzarq implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzarl zzdpf;
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdph;

    zzarq(zzarl zzarl, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdpf = zzarl;
        this.zzdph = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzdpf.zza(thread, th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdph;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdph;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
