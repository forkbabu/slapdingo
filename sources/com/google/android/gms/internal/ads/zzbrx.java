package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbrx {
    private final zzdla zzfpv;
    private Bundle zzfrg;
    private final String zzfrh;
    private final zzdkv zzfri;
    private final Context zzvr;

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static class zza {
        /* access modifiers changed from: private */
        public zzdla zzfpv;
        /* access modifiers changed from: private */
        public Bundle zzfrg;
        /* access modifiers changed from: private */
        public String zzfrh;
        /* access modifiers changed from: private */
        public zzdkv zzfri;
        /* access modifiers changed from: private */
        public Context zzvr;

        public final zza zzce(Context context) {
            this.zzvr = context;
            return this;
        }

        public final zza zza(zzdla zzdla) {
            this.zzfpv = zzdla;
            return this;
        }

        public final zza zzf(Bundle bundle) {
            this.zzfrg = bundle;
            return this;
        }

        public final zza zzfw(String str) {
            this.zzfrh = str;
            return this;
        }

        public final zzbrx zzaiz() {
            return new zzbrx(this);
        }

        public final zza zza(zzdkv zzdkv) {
            this.zzfri = zzdkv;
            return this;
        }
    }

    private zzbrx(zza zza2) {
        this.zzvr = zza2.zzvr;
        this.zzfpv = zza2.zzfpv;
        this.zzfrg = zza2.zzfrg;
        this.zzfrh = zza2.zzfrh;
        this.zzfri = zza2.zzfri;
    }

    /* access modifiers changed from: package-private */
    public final zza zzaiu() {
        return new zza().zzce(this.zzvr).zza(this.zzfpv).zzfw(this.zzfrh).zzf(this.zzfrg);
    }

    /* access modifiers changed from: package-private */
    public final zzdla zzaiv() {
        return this.zzfpv;
    }

    /* access modifiers changed from: package-private */
    public final zzdkv zzaiw() {
        return this.zzfri;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzaix() {
        return this.zzfrg;
    }

    /* access modifiers changed from: package-private */
    public final String zzaiy() {
        return this.zzfrh;
    }

    /* access modifiers changed from: package-private */
    public final Context zzcd(Context context) {
        if (this.zzfrh != null) {
            return context;
        }
        return this.zzvr;
    }
}
