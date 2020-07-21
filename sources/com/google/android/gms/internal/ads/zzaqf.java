package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.webkit.WebView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzaqf {
    private static final Object lock = new Object();
    private static boolean zzdmy = false;
    private static boolean zzzg = false;
    private zzdpi zzdmz;

    public final boolean zzp(Context context) {
        synchronized (lock) {
            if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzctk)).booleanValue()) {
                return false;
            }
            if (zzzg) {
                return true;
            }
            try {
                zzq(context);
                boolean zzau = this.zzdmz.zzau(ObjectWrapper.wrap(context));
                zzzg = zzau;
                return zzau;
            } catch (RemoteException | NullPointerException e) {
                zzbba.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    private final void zzq(Context context) {
        synchronized (lock) {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzctk)).booleanValue() && !zzdmy) {
                try {
                    zzdmy = true;
                    this.zzdmz = (zzdpi) zzbaz.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", zzaqe.zzbxr);
                } catch (zzbbb e) {
                    zzbba.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final String getVersion(Context context) {
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzctk)).booleanValue()) {
            return null;
        }
        try {
            zzq(context);
            String valueOf = String.valueOf(this.zzdmz.getVersion());
            return valueOf.length() != 0 ? "a.".concat(valueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4) {
        return zza(str, webView, str2, str3, str4, "Google");
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (lock) {
            try {
                if (((Boolean) zzwg.zzpw().zzd(zzaav.zzctk)).booleanValue()) {
                    if (zzzg) {
                        try {
                            return this.zzdmz.zza(str, ObjectWrapper.wrap(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e) {
                            zzbba.zze("#007 Could not call remote method.", e);
                            return null;
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzab(com.google.android.gms.dynamic.IObjectWrapper r4) {
        /*
            r3 = this;
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzaqf.lock
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzaav.zzctk     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.ads.zzaar r2 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ all -> 0x002c }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x002c }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x002c }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x002a
            boolean r1 = com.google.android.gms.internal.ads.zzaqf.zzzg     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x001a
            goto L_0x002a
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.ads.zzdpi r0 = r3.zzdmz     // Catch:{ RemoteException -> 0x0023, NullPointerException -> 0x0021 }
            r0.zzab(r4)     // Catch:{ RemoteException -> 0x0023, NullPointerException -> 0x0021 }
            return
        L_0x0021:
            r4 = move-exception
            goto L_0x0024
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            java.lang.String r0 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzbba.zze(r0, r4)
            return
        L_0x002a:
            monitor-exit(r0)
            return
        L_0x002c:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqf.zzab(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzac(com.google.android.gms.dynamic.IObjectWrapper r4) {
        /*
            r3 = this;
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzaqf.lock
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzaav.zzctk     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.ads.zzaar r2 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ all -> 0x002c }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x002c }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x002c }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x002a
            boolean r1 = com.google.android.gms.internal.ads.zzaqf.zzzg     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x001a
            goto L_0x002a
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.ads.zzdpi r0 = r3.zzdmz     // Catch:{ RemoteException -> 0x0023, NullPointerException -> 0x0021 }
            r0.zzac(r4)     // Catch:{ RemoteException -> 0x0023, NullPointerException -> 0x0021 }
            return
        L_0x0021:
            r4 = move-exception
            goto L_0x0024
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            java.lang.String r0 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzbba.zze(r0, r4)
            return
        L_0x002a:
            monitor-exit(r0)
            return
        L_0x002c:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqf.zzac(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.dynamic.IObjectWrapper r4, android.view.View r5) {
        /*
            r3 = this;
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzaqf.lock
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzaav.zzctk     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzaar r2 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ all -> 0x0030 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x0030 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0030 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e
            boolean r1 = com.google.android.gms.internal.ads.zzaqf.zzzg     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x001a
            goto L_0x002e
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzdpi r0 = r3.zzdmz     // Catch:{ RemoteException -> 0x0027, NullPointerException -> 0x0025 }
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)     // Catch:{ RemoteException -> 0x0027, NullPointerException -> 0x0025 }
            r0.zzc(r4, r5)     // Catch:{ RemoteException -> 0x0027, NullPointerException -> 0x0025 }
            return
        L_0x0025:
            r4 = move-exception
            goto L_0x0028
        L_0x0027:
            r4 = move-exception
        L_0x0028:
            java.lang.String r5 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzbba.zze(r5, r4)
            return
        L_0x002e:
            monitor-exit(r0)
            return
        L_0x0030:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqf.zza(com.google.android.gms.dynamic.IObjectWrapper, android.view.View):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.dynamic.IObjectWrapper r4, android.view.View r5) {
        /*
            r3 = this;
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzaqf.lock
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzaav.zzctk     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzaar r2 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ all -> 0x0030 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x0030 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0030 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e
            boolean r1 = com.google.android.gms.internal.ads.zzaqf.zzzg     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x001a
            goto L_0x002e
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzdpi r0 = r3.zzdmz     // Catch:{ RemoteException -> 0x0027, NullPointerException -> 0x0025 }
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)     // Catch:{ RemoteException -> 0x0027, NullPointerException -> 0x0025 }
            r0.zzd(r4, r5)     // Catch:{ RemoteException -> 0x0027, NullPointerException -> 0x0025 }
            return
        L_0x0025:
            r4 = move-exception
            goto L_0x0028
        L_0x0027:
            r4 = move-exception
        L_0x0028:
            java.lang.String r5 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzbba.zze(r5, r4)
            return
        L_0x002e:
            monitor-exit(r0)
            return
        L_0x0030:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqf.zzb(com.google.android.gms.dynamic.IObjectWrapper, android.view.View):void");
    }
}
