package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzhu implements zziz {
    private static final zzie zzyx = new zzhx();
    private final zzie zzyw;

    public zzhu() {
        this(new zzhw(zzgv.zzfx(), zzhc()));
    }

    private zzhu(zzie zzie) {
        this.zzyw = (zzie) zzgy.zza(zzie, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.vision.zziz
    public final <T> zziw<T> zze(Class<T> cls) {
        zziy.zzg(cls);
        zzif zzb = this.zzyw.zzb(cls);
        if (zzb.zzhk()) {
            if (zzgx.class.isAssignableFrom(cls)) {
                return zzin.zza(zziy.zzhv(), zzgo.zzfr(), zzb.zzhl());
            }
            return zzin.zza(zziy.zzht(), zzgo.zzfs(), zzb.zzhl());
        } else if (zzgx.class.isAssignableFrom(cls)) {
            if (zza(zzb)) {
                return zzil.zza(cls, zzb, zzir.zzhn(), zzhr.zzhb(), zziy.zzhv(), zzgo.zzfr(), zzic.zzhh());
            }
            return zzil.zza(cls, zzb, zzir.zzhn(), zzhr.zzhb(), zziy.zzhv(), (zzgk<?>) null, zzic.zzhh());
        } else if (zza(zzb)) {
            return zzil.zza(cls, zzb, zzir.zzhm(), zzhr.zzha(), zziy.zzht(), zzgo.zzfs(), zzic.zzhg());
        } else {
            return zzil.zza(cls, zzb, zzir.zzhm(), zzhr.zzha(), zziy.zzhu(), (zzgk<?>) null, zzic.zzhg());
        }
    }

    private static boolean zza(zzif zzif) {
        return zzif.zzhj() == zzgx.zzf.zzxi;
    }

    private static zzie zzhc() {
        try {
            return (zzie) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzyx;
        }
    }
}
