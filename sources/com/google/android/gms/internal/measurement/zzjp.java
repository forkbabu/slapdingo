package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzib;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
final class zzjp<T> implements zzkc<T> {
    private final zzjj zza;
    private final zzku<?, ?> zzb;
    private final boolean zzc;
    private final zzhq<?> zzd;

    private zzjp(zzku<?, ?> zzku, zzhq<?> zzhq, zzjj zzjj) {
        this.zzb = zzku;
        this.zzc = zzhq.zza(zzjj);
        this.zzd = zzhq;
        this.zza = zzjj;
    }

    static <T> zzjp<T> zza(zzku<?, ?> zzku, zzhq<?> zzhq, zzjj zzjj) {
        return new zzjp<>(zzku, zzhq, zzjj);
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final T zza() {
        return this.zza.zzbr().zzu();
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final void zzb(T t, T t2) {
        zzke.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzke.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final void zza(T t, zzln zzln) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry<?, Object> next = zzd2.next();
            zzht zzht = (zzht) next.getKey();
            if (zzht.zzc() != zzlo.MESSAGE || zzht.zzd() || zzht.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zziq) {
                zzln.zza(zzht.zza(), (Object) ((zziq) next).zza().zzc());
            } else {
                zzln.zza(zzht.zza(), next.getValue());
            }
        }
        zzku<?, ?> zzku = this.zzb;
        zzku.zzb(zzku.zzb(t), zzln);
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final void zza(T t, byte[] bArr, int i, int i2, zzgo zzgo) throws IOException {
        T t2 = t;
        zzkt zzkt = ((zzib) t2).zzb;
        if (zzkt == zzkt.zza()) {
            zzkt = zzkt.zzb();
            ((zzib) t2).zzb = zzkt;
        }
        t.zza();
        zzib.zzd zzd2 = null;
        while (i < i2) {
            int zza2 = zzgp.zza(bArr, i, zzgo);
            int i3 = zzgo.zza;
            if (i3 == 11) {
                int i4 = 0;
                zzgt zzgt = null;
                while (zza2 < i2) {
                    zza2 = zzgp.zza(bArr, zza2, zzgo);
                    int i5 = zzgo.zza;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzd2 != null) {
                                zzjy.zza();
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                zza2 = zzgp.zze(bArr, zza2, zzgo);
                                zzgt = (zzgt) zzgo.zzc;
                            }
                        }
                    } else if (i7 == 0) {
                        zza2 = zzgp.zza(bArr, zza2, zzgo);
                        i4 = zzgo.zza;
                        zzd2 = (zzib.zzd) this.zzd.zza(zzgo.zzd, this.zza, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza2 = zzgp.zza(i5, bArr, zza2, i2, zzgo);
                }
                if (zzgt != null) {
                    zzkt.zza((i4 << 3) | 2, zzgt);
                }
                i = zza2;
            } else if ((i3 & 7) == 2) {
                zzd2 = (zzib.zzd) this.zzd.zza(zzgo.zzd, this.zza, i3 >>> 3);
                if (zzd2 == null) {
                    i = zzgp.zza(i3, bArr, zza2, i2, zzkt, zzgo);
                } else {
                    zzjy.zza();
                    throw new NoSuchMethodError();
                }
            } else {
                i = zzgp.zza(i3, bArr, zza2, i2, zzgo);
            }
        }
        if (i != i2) {
            throw zzij.zzg();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final void zza(T t, zzjz zzjz, zzho zzho) throws IOException {
        boolean z;
        zzku<?, ?> zzku = this.zzb;
        zzhq<?> zzhq = this.zzd;
        Object zzc2 = zzku.zzc(t);
        zzhr<?> zzb2 = zzhq.zzb(t);
        do {
            try {
                if (zzjz.zza() == Integer.MAX_VALUE) {
                    zzku.zzb(t, zzc2);
                    return;
                }
                int zzb3 = zzjz.zzb();
                if (zzb3 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzgt zzgt = null;
                    while (zzjz.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzjz.zzb();
                        if (zzb4 == 16) {
                            i = zzjz.zzo();
                            obj = zzhq.zza(zzho, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zzhq.zza(zzjz, obj, zzho, zzb2);
                            } else {
                                zzgt = zzjz.zzn();
                            }
                        } else if (!zzjz.zzc()) {
                            break;
                        }
                    }
                    if (zzjz.zzb() != 12) {
                        throw zzij.zze();
                    } else if (zzgt != null) {
                        if (obj != null) {
                            zzhq.zza(zzgt, obj, zzho, zzb2);
                        } else {
                            zzku.zza(zzc2, i, zzgt);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zzhq.zza(zzho, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zzhq.zza(zzjz, zza2, zzho, zzb2);
                    } else {
                        z = zzku.zza(zzc2, zzjz);
                        continue;
                    }
                } else {
                    z = zzjz.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzku.zzb(t, zzc2);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final int zzb(T t) {
        zzku<?, ?> zzku = this.zzb;
        int zze = zzku.zze(zzku.zzb(t)) + 0;
        return this.zzc ? zze + this.zzd.zza((Object) t).zzg() : zze;
    }
}
