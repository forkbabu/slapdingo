package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.itextpdf.text.html.HtmlTags;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public abstract class zzs<T> {
    private static String PREFIX = "com.google.android.gms.vision.dynamite";
    private final Object lock = new Object();
    private final String tag;
    private final String zzdm;
    private final String zzdn;
    private final boolean zzdo;
    private boolean zzdp;
    private boolean zzdq;
    private T zzdr;
    private final Context zzg;

    public zzs(Context context, String str, String str2) {
        boolean z = false;
        this.zzdp = false;
        this.zzdq = false;
        this.zzg = context;
        this.tag = str;
        String str3 = PREFIX;
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str2).length());
        sb.append(str3);
        sb.append(".");
        sb.append(str2);
        this.zzdm = sb.toString();
        this.zzdn = str2;
        if (context != null) {
            zzbj.maybeInit(context);
            zzdl zza = zzdl.zza("barcode", Boolean.valueOf(zzla.zzjq()), HtmlTags.FACE, Boolean.TRUE, "ica", Boolean.valueOf(zzla.zzjr()), "ocr", Boolean.TRUE);
            if (zza.containsKey(str2) && ((Boolean) zza.get(str2)).booleanValue()) {
                z = true;
            }
        }
        this.zzdo = z;
    }

    /* access modifiers changed from: protected */
    public abstract T zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException;

    /* access modifiers changed from: protected */
    public abstract void zzo() throws RemoteException;

    public final boolean isOperational() {
        return zzq() != null;
    }

    public final void zzp() {
        synchronized (this.lock) {
            if (this.zzdr != null) {
                try {
                    zzo();
                } catch (RemoteException e) {
                    Log.e(this.tag, "Could not finalize native handle", e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final T zzq() {
        DynamiteModule dynamiteModule;
        synchronized (this.lock) {
            if (this.zzdr != null) {
                T t = this.zzdr;
                return t;
            }
            try {
                dynamiteModule = DynamiteModule.load(this.zzg, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, this.zzdm);
            } catch (DynamiteModule.LoadingException unused) {
                Log.d(this.tag, "Cannot load feature, fall back to load dynamite module.");
                dynamiteModule = zzw.zza(this.zzg, this.zzdn, this.zzdo);
                if (dynamiteModule == null && this.zzdo && !this.zzdp) {
                    String str = this.tag;
                    String valueOf = String.valueOf(this.zzdn);
                    Log.d(str, valueOf.length() != 0 ? "Broadcasting download intent for dependency ".concat(valueOf) : new String("Broadcasting download intent for dependency "));
                    String str2 = this.zzdn;
                    Intent intent = new Intent();
                    intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
                    intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", str2);
                    intent.setAction("com.google.android.gms.vision.DEPENDENCY");
                    this.zzg.sendBroadcast(intent);
                    this.zzdp = true;
                }
            }
            if (dynamiteModule != null) {
                try {
                    this.zzdr = zza(dynamiteModule, this.zzg);
                } catch (RemoteException | DynamiteModule.LoadingException e) {
                    Log.e(this.tag, "Error creating remote native handle", e);
                }
            }
            if (!this.zzdq && this.zzdr == null) {
                Log.w(this.tag, "Native handle not yet available. Reverting to no-op handle.");
                this.zzdq = true;
            } else if (this.zzdq && this.zzdr != null) {
                Log.w(this.tag, "Native handle is now available.");
            }
            T t2 = this.zzdr;
            return t2;
        }
    }
}
