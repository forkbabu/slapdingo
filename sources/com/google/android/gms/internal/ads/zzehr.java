package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzehr<T> implements zzeih<T> {
    private final zzehl zzigw;
    private final boolean zzigx;
    private final zzeiz<?, ?> zzihg;
    private final zzefq<?> zzihh;

    private zzehr(zzeiz<?, ?> zzeiz, zzefq<?> zzefq, zzehl zzehl) {
        this.zzihg = zzeiz;
        this.zzigx = zzefq.zzj(zzehl);
        this.zzihh = zzefq;
        this.zzigw = zzehl;
    }

    static <T> zzehr<T> zza(zzeiz<?, ?> zzeiz, zzefq<?> zzefq, zzehl zzehl) {
        return new zzehr<>(zzeiz, zzefq, zzehl);
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final T newInstance() {
        return this.zzigw.zzbfj().zzbfp();
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final boolean equals(T t, T t2) {
        if (!this.zzihg.zzax(t).equals(this.zzihg.zzax(t2))) {
            return false;
        }
        if (this.zzigx) {
            return this.zzihh.zzah(t).equals(this.zzihh.zzah(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final int hashCode(T t) {
        int hashCode = this.zzihg.zzax(t).hashCode();
        return this.zzigx ? (hashCode * 53) + this.zzihh.zzah(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final void zzg(T t, T t2) {
        zzeij.zza(this.zzihg, t, t2);
        if (this.zzigx) {
            zzeij.zza(this.zzihh, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final void zza(T t, zzejw zzejw) throws IOException {
        Iterator<Map.Entry<?, Object>> it2 = this.zzihh.zzah(t).iterator();
        while (it2.hasNext()) {
            Map.Entry<?, Object> next = it2.next();
            zzefw zzefw = (zzefw) next.getKey();
            if (zzefw.zzbey() != zzejt.MESSAGE || zzefw.zzbez() || zzefw.zzbfa()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzegs) {
                zzejw.zzc(zzefw.zzw(), ((zzegs) next).zzbgf().zzbct());
            } else {
                zzejw.zzc(zzefw.zzw(), next.getValue());
            }
        }
        zzeiz<?, ?> zzeiz = this.zzihg;
        zzeiz.zzc(zzeiz.zzax(t), zzejw);
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final void zza(T t, byte[] bArr, int i, int i2, zzeem zzeem) throws IOException {
        T t2 = t;
        zzejc zzejc = ((zzegb) t2).zzieg;
        if (zzejc == zzejc.zzbhs()) {
            zzejc = zzejc.zzbht();
            ((zzegb) t2).zzieg = zzejc;
        }
        t.zzbfr();
        zzegb.zzf zzf = null;
        while (i < i2) {
            int zza = zzeen.zza(bArr, i, zzeem);
            int i3 = zzeem.zzhzo;
            if (i3 == 11) {
                int i4 = 0;
                zzeer zzeer = null;
                while (zza < i2) {
                    zza = zzeen.zza(bArr, zza, zzeem);
                    int i5 = zzeem.zzhzo;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzf != null) {
                                zzeia.zzbgz();
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                zza = zzeen.zze(bArr, zza, zzeem);
                                zzeer = (zzeer) zzeem.zzhzq;
                            }
                        }
                    } else if (i7 == 0) {
                        zza = zzeen.zza(bArr, zza, zzeem);
                        i4 = zzeem.zzhzo;
                        zzf = (zzegb.zzf) this.zzihh.zza(zzeem.zzhzr, this.zzigw, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza = zzeen.zza(i5, bArr, zza, i2, zzeem);
                }
                if (zzeer != null) {
                    zzejc.zzd((i4 << 3) | 2, zzeer);
                }
                i = zza;
            } else if ((i3 & 7) == 2) {
                zzf = (zzegb.zzf) this.zzihh.zza(zzeem.zzhzr, this.zzigw, i3 >>> 3);
                if (zzf == null) {
                    i = zzeen.zza(i3, bArr, zza, i2, zzejc, zzeem);
                } else {
                    zzeia.zzbgz();
                    throw new NoSuchMethodError();
                }
            } else {
                i = zzeen.zza(i3, bArr, zza, i2, zzeem);
            }
        }
        if (i != i2) {
            throw zzegl.zzbgb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final void zza(T t, zzeib zzeib, zzefo zzefo) throws IOException {
        boolean z;
        zzeiz<?, ?> zzeiz = this.zzihg;
        zzefq<?> zzefq = this.zzihh;
        Object zzay = zzeiz.zzay(t);
        zzefu<?> zzai = zzefq.zzai(t);
        do {
            try {
                if (zzeib.zzbek() == Integer.MAX_VALUE) {
                    zzeiz.zzj(t, zzay);
                    return;
                }
                int tag = zzeib.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzeer zzeer = null;
                    while (zzeib.zzbek() != Integer.MAX_VALUE) {
                        int tag2 = zzeib.getTag();
                        if (tag2 == 16) {
                            i = zzeib.zzbdv();
                            obj = zzefq.zza(zzefo, this.zzigw, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzefq.zza(zzeib, obj, zzefo, zzai);
                            } else {
                                zzeer = zzeib.zzbdu();
                            }
                        } else if (!zzeib.zzbel()) {
                            break;
                        }
                    }
                    if (zzeib.getTag() != 12) {
                        throw zzegl.zzbfy();
                    } else if (zzeer != null) {
                        if (obj != null) {
                            zzefq.zza(zzeer, obj, zzefo, zzai);
                        } else {
                            zzeiz.zza(zzay, i, zzeer);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzefq.zza(zzefo, this.zzigw, tag >>> 3);
                    if (zza != null) {
                        zzefq.zza(zzeib, zza, zzefo, zzai);
                    } else {
                        z = zzeiz.zza(zzay, zzeib);
                        continue;
                    }
                } else {
                    z = zzeib.zzbel();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzeiz.zzj(t, zzay);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final void zzaj(T t) {
        this.zzihg.zzaj(t);
        this.zzihh.zzaj(t);
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final boolean zzav(T t) {
        return this.zzihh.zzah(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final int zzat(T t) {
        zzeiz<?, ?> zzeiz = this.zzihg;
        int zzaz = zzeiz.zzaz(zzeiz.zzax(t)) + 0;
        return this.zzigx ? zzaz + this.zzihh.zzah(t).zzbew() : zzaz;
    }
}
