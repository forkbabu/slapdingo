package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbkb {
    private zza zzfjp;

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static abstract class zza {
        public abstract zzbfa zzady();

        public abstract zzbcl zzadz();

        public abstract zztr zzaea();

        public abstract zzavt zzaeb();

        public abstract zzaqp zzaec();

        public abstract zzame zzaed();

        public abstract zzabv zzaee();
    }

    public zzbkb(zza zza2) {
        this.zzfjp = zza2;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzavu, com.google.android.gms.internal.ads.zzavo] */
    public final com.google.android.gms.ads.internal.zza zzagi() {
        zza zza2 = this.zzfjp;
        return new com.google.android.gms.ads.internal.zza(zza2.zzady(), zza2.zzadz(), new zzavo(zza2.zzaeb()), zza2.zzaea(), zza2.zzaec(), zza2.zzaee());
    }

    public final zzavt zzaeb() {
        return this.zzfjp.zzaeb();
    }

    public final zzaqp zzaec() {
        return this.zzfjp.zzaec();
    }

    public final zzame zzaed() {
        return this.zzfjp.zzaed();
    }

    public final zzabv zzaee() {
        return this.zzfjp.zzaee();
    }
}
