package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzgd implements zzix {
    private int tag;
    private int zzsl;
    private final zzfy zzte;
    private int zztf = 0;

    public static zzgd zza(zzfy zzfy) {
        if (zzfy.zzsx != null) {
            return zzfy.zzsx;
        }
        return new zzgd(zzfy);
    }

    private zzgd(zzfy zzfy) {
        zzfy zzfy2 = (zzfy) zzgy.zza(zzfy, "input");
        this.zzte = zzfy2;
        zzfy2.zzsx = this;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzdv() throws IOException {
        int i = this.zztf;
        if (i != 0) {
            this.tag = i;
            this.zztf = 0;
        } else {
            this.tag = this.zzte.zzey();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzsl) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final boolean zzdw() throws IOException {
        int i;
        if (this.zzte.zzdu() || (i = this.tag) == this.zzsl) {
            return false;
        }
        return this.zzte.zzas(i);
    }

    private final void zzak(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzhh.zzgs();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final double readDouble() throws IOException {
        zzak(1);
        return this.zzte.readDouble();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final float readFloat() throws IOException {
        zzak(5);
        return this.zzte.readFloat();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzdx() throws IOException {
        zzak(0);
        return this.zzte.zzdx();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzdy() throws IOException {
        zzak(0);
        return this.zzte.zzdy();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzdz() throws IOException {
        zzak(0);
        return this.zzte.zzdz();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzea() throws IOException {
        zzak(1);
        return this.zzte.zzea();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeb() throws IOException {
        zzak(5);
        return this.zzte.zzeb();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final boolean zzec() throws IOException {
        zzak(0);
        return this.zzte.zzec();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final String readString() throws IOException {
        zzak(2);
        return this.zzte.readString();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final String zzed() throws IOException {
        zzak(2);
        return this.zzte.zzed();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zza(Class<T> cls, zzgi zzgi) throws IOException {
        zzak(2);
        return zzb(zzis.zzhp().zzf(cls), zzgi);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zza(zziw<T> zziw, zzgi zzgi) throws IOException {
        zzak(2);
        return zzb(zziw, zzgi);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zzb(Class<T> cls, zzgi zzgi) throws IOException {
        zzak(3);
        return zzd(zzis.zzhp().zzf(cls), zzgi);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zzc(zziw<T> zziw, zzgi zzgi) throws IOException {
        zzak(3);
        return zzd(zziw, zzgi);
    }

    private final <T> T zzb(zziw<T> zziw, zzgi zzgi) throws IOException {
        int zzef = this.zzte.zzef();
        if (this.zzte.zzsu < this.zzte.zzsv) {
            int zzat = this.zzte.zzat(zzef);
            T newInstance = zziw.newInstance();
            this.zzte.zzsu++;
            zziw.zza(newInstance, this, zzgi);
            zziw.zzh(newInstance);
            this.zzte.zzar(0);
            zzfy zzfy = this.zzte;
            zzfy.zzsu--;
            this.zzte.zzau(zzat);
            return newInstance;
        }
        throw new zzhh("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zziw<T> zziw, zzgi zzgi) throws IOException {
        int i = this.zzsl;
        this.zzsl = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zziw.newInstance();
            zziw.zza(newInstance, this, zzgi);
            zziw.zzh(newInstance);
            if (this.tag == this.zzsl) {
                return newInstance;
            }
            throw zzhh.zzgt();
        } finally {
            this.zzsl = i;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final zzfm zzee() throws IOException {
        zzak(2);
        return this.zzte.zzee();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzef() throws IOException {
        zzak(0);
        return this.zzte.zzef();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeg() throws IOException {
        zzak(0);
        return this.zzte.zzeg();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeh() throws IOException {
        zzak(5);
        return this.zzte.zzeh();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzei() throws IOException {
        zzak(1);
        return this.zzte.zzei();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzej() throws IOException {
        zzak(0);
        return this.zzte.zzej();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzek() throws IOException {
        zzak(0);
        return this.zzte.zzek();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zza(List<Double> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgg) {
            zzgg zzgg = (zzgg) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzgg.zzc(this.zzte.readDouble());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzef = this.zzte.zzef();
                zzal(zzef);
                int zzfa = this.zzte.zzfa() + zzef;
                do {
                    zzgg.zzc(this.zzte.readDouble());
                } while (this.zzte.zzfa() < zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zzte.readDouble()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzef2 = this.zzte.zzef();
                zzal(zzef2);
                int zzfa2 = this.zzte.zzfa() + zzef2;
                do {
                    list.add(Double.valueOf(this.zzte.readDouble()));
                } while (this.zzte.zzfa() < zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzb(List<Float> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgt) {
            zzgt zzgt = (zzgt) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzef = this.zzte.zzef();
                zzam(zzef);
                int zzfa = this.zzte.zzfa() + zzef;
                do {
                    zzgt.zzu(this.zzte.readFloat());
                } while (this.zzte.zzfa() < zzfa);
            } else if (i == 5) {
                do {
                    zzgt.zzu(this.zzte.readFloat());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzef2 = this.zzte.zzef();
                zzam(zzef2);
                int zzfa2 = this.zzte.zzfa() + zzef2;
                do {
                    list.add(Float.valueOf(this.zzte.readFloat()));
                } while (this.zzte.zzfa() < zzfa2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzte.readFloat()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzc(List<Long> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzhv) {
            zzhv zzhv = (zzhv) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhv.zzac(this.zzte.zzdx());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzhv.zzac(this.zzte.zzdx());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzte.zzdx()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Long.valueOf(this.zzte.zzdx()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzd(List<Long> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzhv) {
            zzhv zzhv = (zzhv) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhv.zzac(this.zzte.zzdy());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzhv.zzac(this.zzte.zzdy());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzte.zzdy()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Long.valueOf(this.zzte.zzdy()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zze(List<Integer> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgz.zzbm(this.zzte.zzdz());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzgz.zzbm(this.zzte.zzdz());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzte.zzdz()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Integer.valueOf(this.zzte.zzdz()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzf(List<Long> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzhv) {
            zzhv zzhv = (zzhv) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzhv.zzac(this.zzte.zzea());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzef = this.zzte.zzef();
                zzal(zzef);
                int zzfa = this.zzte.zzfa() + zzef;
                do {
                    zzhv.zzac(this.zzte.zzea());
                } while (this.zzte.zzfa() < zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzte.zzea()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzef2 = this.zzte.zzef();
                zzal(zzef2);
                int zzfa2 = this.zzte.zzfa() + zzef2;
                do {
                    list.add(Long.valueOf(this.zzte.zzea()));
                } while (this.zzte.zzfa() < zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzg(List<Integer> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzef = this.zzte.zzef();
                zzam(zzef);
                int zzfa = this.zzte.zzfa() + zzef;
                do {
                    zzgz.zzbm(this.zzte.zzeb());
                } while (this.zzte.zzfa() < zzfa);
            } else if (i == 5) {
                do {
                    zzgz.zzbm(this.zzte.zzeb());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzef2 = this.zzte.zzef();
                zzam(zzef2);
                int zzfa2 = this.zzte.zzfa() + zzef2;
                do {
                    list.add(Integer.valueOf(this.zzte.zzeb()));
                } while (this.zzte.zzfa() < zzfa2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzte.zzeb()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzh(List<Boolean> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzfk) {
            zzfk zzfk = (zzfk) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzfk.addBoolean(this.zzte.zzec());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzfk.addBoolean(this.zzte.zzec());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzte.zzec()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Boolean.valueOf(this.zzte.zzec()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzi(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzey;
        int zzey2;
        if ((this.tag & 7) != 2) {
            throw zzhh.zzgs();
        } else if (!(list instanceof zzho) || z) {
            do {
                list.add(z ? zzed() : readString());
                if (!this.zzte.zzdu()) {
                    zzey = this.zzte.zzey();
                } else {
                    return;
                }
            } while (zzey == this.tag);
            this.zztf = zzey;
        } else {
            zzho zzho = (zzho) list;
            do {
                zzho.zzc(zzee());
                if (!this.zzte.zzdu()) {
                    zzey2 = this.zzte.zzey();
                } else {
                    return;
                }
            } while (zzey2 == this.tag);
            this.zztf = zzey2;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> void zza(List<T> list, zziw<T> zziw, zzgi zzgi) throws IOException {
        int zzey;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzb(zziw, zzgi));
                if (!this.zzte.zzdu() && this.zztf == 0) {
                    zzey = this.zzte.zzey();
                } else {
                    return;
                }
            } while (zzey == i);
            this.zztf = zzey;
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> void zzb(List<T> list, zziw<T> zziw, zzgi zzgi) throws IOException {
        int zzey;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zziw, zzgi));
                if (!this.zzte.zzdu() && this.zztf == 0) {
                    zzey = this.zzte.zzey();
                } else {
                    return;
                }
            } while (zzey == i);
            this.zztf = zzey;
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzj(List<zzfm> list) throws IOException {
        int zzey;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzee());
                if (!this.zzte.zzdu()) {
                    zzey = this.zzte.zzey();
                } else {
                    return;
                }
            } while (zzey == this.tag);
            this.zztf = zzey;
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzk(List<Integer> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgz.zzbm(this.zzte.zzef());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzgz.zzbm(this.zzte.zzef());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzte.zzef()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Integer.valueOf(this.zzte.zzef()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzl(List<Integer> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgz.zzbm(this.zzte.zzeg());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzgz.zzbm(this.zzte.zzeg());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzte.zzeg()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Integer.valueOf(this.zzte.zzeg()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzm(List<Integer> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzef = this.zzte.zzef();
                zzam(zzef);
                int zzfa = this.zzte.zzfa() + zzef;
                do {
                    zzgz.zzbm(this.zzte.zzeh());
                } while (this.zzte.zzfa() < zzfa);
            } else if (i == 5) {
                do {
                    zzgz.zzbm(this.zzte.zzeh());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzef2 = this.zzte.zzef();
                zzam(zzef2);
                int zzfa2 = this.zzte.zzfa() + zzef2;
                do {
                    list.add(Integer.valueOf(this.zzte.zzeh()));
                } while (this.zzte.zzfa() < zzfa2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzte.zzeh()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzn(List<Long> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzhv) {
            zzhv zzhv = (zzhv) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzhv.zzac(this.zzte.zzei());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzef = this.zzte.zzef();
                zzal(zzef);
                int zzfa = this.zzte.zzfa() + zzef;
                do {
                    zzhv.zzac(this.zzte.zzei());
                } while (this.zzte.zzfa() < zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzte.zzei()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzef2 = this.zzte.zzef();
                zzal(zzef2);
                int zzfa2 = this.zzte.zzfa() + zzef2;
                do {
                    list.add(Long.valueOf(this.zzte.zzei()));
                } while (this.zzte.zzfa() < zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzo(List<Integer> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgz.zzbm(this.zzte.zzej());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzgz.zzbm(this.zzte.zzej());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzte.zzej()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Integer.valueOf(this.zzte.zzej()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzp(List<Long> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzhv) {
            zzhv zzhv = (zzhv) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhv.zzac(this.zzte.zzek());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzhv.zzac(this.zzte.zzek());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzte.zzek()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Long.valueOf(this.zzte.zzek()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    private static void zzal(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzhh.zzgt();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <K, V> void zza(Map<K, V> map, zzhy<K, V> zzhy, zzgi zzgi) throws IOException {
        zzak(2);
        int zzat = this.zzte.zzat(this.zzte.zzef());
        K k = zzhy.zzzc;
        V v = zzhy.zzgl;
        while (true) {
            try {
                int zzdv = zzdv();
                if (zzdv == Integer.MAX_VALUE || this.zzte.zzdu()) {
                    map.put(k, v);
                } else if (zzdv == 1) {
                    k = zza(zzhy.zzzb, (Class<?>) null, (zzgi) null);
                } else if (zzdv != 2) {
                    try {
                        if (!zzdw()) {
                            throw new zzhh("Unable to parse map entry.");
                        }
                    } catch (zzhg unused) {
                        if (!zzdw()) {
                            throw new zzhh("Unable to parse map entry.");
                        }
                    }
                } else {
                    v = zza(zzhy.zzzd, zzhy.zzgl.getClass(), zzgi);
                }
            } finally {
                this.zzte.zzau(zzat);
            }
        }
        map.put(k, v);
    }

    private final Object zza(zzkf zzkf, Class<?> cls, zzgi zzgi) throws IOException {
        switch (zzgc.zzsg[zzkf.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzec());
            case 2:
                return zzee();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzeg());
            case 5:
                return Integer.valueOf(zzeb());
            case 6:
                return Long.valueOf(zzea());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzdz());
            case 9:
                return Long.valueOf(zzdy());
            case 10:
                return zza(cls, zzgi);
            case 11:
                return Integer.valueOf(zzeh());
            case 12:
                return Long.valueOf(zzei());
            case 13:
                return Integer.valueOf(zzej());
            case 14:
                return Long.valueOf(zzek());
            case 15:
                return zzed();
            case 16:
                return Integer.valueOf(zzef());
            case 17:
                return Long.valueOf(zzdx());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzam(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzhh.zzgt();
        }
    }

    private final void zzan(int i) throws IOException {
        if (this.zzte.zzfa() != i) {
            throw zzhh.zzgn();
        }
    }
}
