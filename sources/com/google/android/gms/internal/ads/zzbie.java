package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.ads.internal.zzq;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbie {
    private final Context zzaah;
    private final zzbbd zzbov;
    private final WeakReference<Context> zzeqw;

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static class zza {
        /* access modifiers changed from: private */
        public Context zzaah;
        /* access modifiers changed from: private */
        public zzbbd zzbov;
        /* access modifiers changed from: private */
        public WeakReference<Context> zzeqw;

        public final zza zza(zzbbd zzbbd) {
            this.zzbov = zzbbd;
            return this;
        }

        public final zza zzbx(Context context) {
            this.zzeqw = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzaah = context;
            return this;
        }
    }

    private zzbie(zza zza2) {
        this.zzbov = zza2.zzbov;
        this.zzaah = zza2.zzaah;
        this.zzeqw = zza2.zzeqw;
    }

    /* access modifiers changed from: package-private */
    public final Context zzacz() {
        return this.zzaah;
    }

    /* access modifiers changed from: package-private */
    public final WeakReference<Context> zzada() {
        return this.zzeqw;
    }

    /* access modifiers changed from: package-private */
    public final zzbbd zzadb() {
        return this.zzbov;
    }

    /* access modifiers changed from: package-private */
    public final String zzadc() {
        return zzq.zzkw().zzs(this.zzaah, this.zzbov.zzbpn);
    }

    public final zzeg zzadd() {
        return new zzeg(new zzh(this.zzaah, this.zzbov));
    }
}
