package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzcmi extends Exception {
    private final int zzggb;

    public static zzuy zze(Throwable th) {
        if (th instanceof zzcmi) {
            return ((zzcmi) th).zzaow();
        }
        if (!(th instanceof zzazh)) {
            return zzdlq.zzh(zzdls.zzhbq, null);
        }
        zzazh zzazh = (zzazh) th;
        return new zzuy(zzazh.getErrorCode(), zzdsi.zzhg(zzazh.getMessage()), "com.google.android.gms.ads");
    }

    public zzcmi(int i) {
        this.zzggb = i;
    }

    public zzcmi(int i, String str) {
        super(str);
        this.zzggb = i;
    }

    public zzcmi(int i, String str, Throwable th) {
        super(str, th);
        this.zzggb = i;
    }

    public final zzuy zzaow() {
        if (getMessage() == null) {
            return zzdlq.zzh(this.zzggb, null);
        }
        return zzdlq.zzh(this.zzggb, getMessage());
    }
}
