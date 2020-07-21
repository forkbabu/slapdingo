package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzin<T> implements zziw<T> {
    private final zzih zzzn;
    private final boolean zzzo;
    private final zzjo<?, ?> zzzx;
    private final zzgk<?> zzzy;

    private zzin(zzjo<?, ?> zzjo, zzgk<?> zzgk, zzih zzih) {
        this.zzzx = zzjo;
        this.zzzo = zzgk.zze(zzih);
        this.zzzy = zzgk;
        this.zzzn = zzih;
    }

    static <T> zzin<T> zza(zzjo<?, ?> zzjo, zzgk<?> zzgk, zzih zzih) {
        return new zzin<>(zzjo, zzgk, zzih);
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final T newInstance() {
        return this.zzzn.zzgk().zzgc();
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final boolean equals(T t, T t2) {
        if (!this.zzzx.zzw(t).equals(this.zzzx.zzw(t2))) {
            return false;
        }
        if (this.zzzo) {
            return this.zzzy.zzf(t).equals(this.zzzy.zzf(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final int hashCode(T t) {
        int hashCode = this.zzzx.zzw(t).hashCode();
        return this.zzzo ? (hashCode * 53) + this.zzzy.zzf(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final void zzd(T t, T t2) {
        zziy.zza(this.zzzx, t, t2);
        if (this.zzzo) {
            zziy.zza(this.zzzy, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final void zza(T t, zzkl zzkl) throws IOException {
        Iterator<Map.Entry<?, Object>> it2 = this.zzzy.zzf(t).iterator();
        while (it2.hasNext()) {
            Map.Entry<?, Object> next = it2.next();
            zzgp zzgp = (zzgp) next.getKey();
            if (zzgp.zzfu() != zzki.MESSAGE || zzgp.zzfv() || zzgp.zzfw()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzhk) {
                zzkl.zza(zzgp.zzah(), (Object) ((zzhk) next).zzgx().zzdl());
            } else {
                zzkl.zza(zzgp.zzah(), next.getValue());
            }
        }
        zzjo<?, ?> zzjo = this.zzzx;
        zzjo.zzc(zzjo.zzw(t), zzkl);
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final void zza(T t, byte[] bArr, int i, int i2, zzfg zzfg) throws IOException {
        T t2 = t;
        zzjr zzjr = ((zzgx) t2).zzws;
        if (zzjr == zzjr.zzih()) {
            zzjr = zzjr.zzii();
            ((zzgx) t2).zzws = zzjr;
        }
        zzgn<zzgx.zzd> zzgl = t.zzgl();
        zzgx.zzg zzg = null;
        while (i < i2) {
            int zza = zzfe.zza(bArr, i, zzfg);
            int i3 = zzfg.zzsd;
            if (i3 == 11) {
                int i4 = 0;
                zzfm zzfm = null;
                while (zza < i2) {
                    zza = zzfe.zza(bArr, zza, zzfg);
                    int i5 = zzfg.zzsd;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzg != null) {
                                zza = zzfe.zza(zzis.zzhp().zzf(zzg.zzxp.getClass()), bArr, zza, i2, zzfg);
                                zzgl.zza(zzg.zzxq, zzfg.zzsf);
                            } else if (i7 == 2) {
                                zza = zzfe.zze(bArr, zza, zzfg);
                                zzfm = (zzfm) zzfg.zzsf;
                            }
                        }
                    } else if (i7 == 0) {
                        zza = zzfe.zza(bArr, zza, zzfg);
                        i4 = zzfg.zzsd;
                        zzg = (zzgx.zzg) this.zzzy.zza(zzfg.zzcu, this.zzzn, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza = zzfe.zza(i5, bArr, zza, i2, zzfg);
                }
                if (zzfm != null) {
                    zzjr.zzb((i4 << 3) | 2, zzfm);
                }
                i = zza;
            } else if ((i3 & 7) == 2) {
                zzgx.zzg zzg2 = (zzgx.zzg) this.zzzy.zza(zzfg.zzcu, this.zzzn, i3 >>> 3);
                if (zzg2 != null) {
                    i = zzfe.zza(zzis.zzhp().zzf(zzg2.zzxp.getClass()), bArr, zza, i2, zzfg);
                    zzgl.zza(zzg2.zzxq, zzfg.zzsf);
                } else {
                    i = zzfe.zza(i3, bArr, zza, i2, zzjr, zzfg);
                }
                zzg = zzg2;
            } else {
                i = zzfe.zza(i3, bArr, zza, i2, zzfg);
            }
        }
        if (i != i2) {
            throw zzhh.zzgt();
        }
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final void zza(T t, zzix zzix, zzgi zzgi) throws IOException {
        boolean z;
        zzjo<?, ?> zzjo = this.zzzx;
        zzgk<?> zzgk = this.zzzy;
        Object zzx = zzjo.zzx(t);
        zzgn<?> zzg = zzgk.zzg(t);
        do {
            try {
                if (zzix.zzdv() == Integer.MAX_VALUE) {
                    zzjo.zzg(t, zzx);
                    return;
                }
                int tag = zzix.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzfm zzfm = null;
                    while (zzix.zzdv() != Integer.MAX_VALUE) {
                        int tag2 = zzix.getTag();
                        if (tag2 == 16) {
                            i = zzix.zzef();
                            obj = zzgk.zza(zzgi, this.zzzn, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzgk.zza(zzix, obj, zzgi, zzg);
                            } else {
                                zzfm = zzix.zzee();
                            }
                        } else if (!zzix.zzdw()) {
                            break;
                        }
                    }
                    if (zzix.getTag() != 12) {
                        throw zzhh.zzgr();
                    } else if (zzfm != null) {
                        if (obj != null) {
                            zzgk.zza(zzfm, obj, zzgi, zzg);
                        } else {
                            zzjo.zza(zzx, i, zzfm);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzgk.zza(zzgi, this.zzzn, tag >>> 3);
                    if (zza != null) {
                        zzgk.zza(zzix, zza, zzgi, zzg);
                    } else {
                        z = zzjo.zza(zzx, zzix);
                        continue;
                    }
                } else {
                    z = zzix.zzdw();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzjo.zzg(t, zzx);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final void zzh(T t) {
        this.zzzx.zzh(t);
        this.zzzy.zzh(t);
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final boolean zzu(T t) {
        return this.zzzy.zzf(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final int zzs(T t) {
        zzjo<?, ?> zzjo = this.zzzx;
        int zzy = zzjo.zzy(zzjo.zzw(t)) + 0;
        return this.zzzo ? zzy + this.zzzy.zzf(t).zzfp() : zzy;
    }
}
