package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzefj implements zzeib {
    private int tag;
    private final zzefc zziav;
    private int zziaw;
    private int zziax = 0;

    public static zzefj zza(zzefc zzefc) {
        if (zzefc.zziak != null) {
            return zzefc.zziak;
        }
        return new zzefj(zzefc);
    }

    private zzefj(zzefc zzefc) {
        zzefc zzefc2 = (zzefc) zzegd.zza(zzefc, "input");
        this.zziav = zzefc2;
        zzefc2.zziak = this;
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final int zzbek() throws IOException {
        int i = this.zziax;
        if (i != 0) {
            this.tag = i;
            this.zziax = 0;
        } else {
            this.tag = this.zziav.zzbdm();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zziaw) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final boolean zzbel() throws IOException {
        int i;
        if (this.zziav.zzbec() || (i = this.tag) == this.zziaw) {
            return false;
        }
        return this.zziav.zzfy(i);
    }

    private final void zzgh(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzegl.zzbfz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final double readDouble() throws IOException {
        zzgh(1);
        return this.zziav.readDouble();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final float readFloat() throws IOException {
        zzgh(5);
        return this.zziav.readFloat();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final long zzbdn() throws IOException {
        zzgh(0);
        return this.zziav.zzbdn();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final long zzbdo() throws IOException {
        zzgh(0);
        return this.zziav.zzbdo();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final int zzbdp() throws IOException {
        zzgh(0);
        return this.zziav.zzbdp();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final long zzbdq() throws IOException {
        zzgh(1);
        return this.zziav.zzbdq();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final int zzbdr() throws IOException {
        zzgh(5);
        return this.zziav.zzbdr();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final boolean zzbds() throws IOException {
        zzgh(0);
        return this.zziav.zzbds();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final String readString() throws IOException {
        zzgh(2);
        return this.zziav.readString();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final String zzbdt() throws IOException {
        zzgh(2);
        return this.zziav.zzbdt();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final <T> T zza(zzeih<T> zzeih, zzefo zzefo) throws IOException {
        zzgh(2);
        return zzc(zzeih, zzefo);
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final <T> T zzb(zzeih<T> zzeih, zzefo zzefo) throws IOException {
        zzgh(3);
        return zzd(zzeih, zzefo);
    }

    private final <T> T zzc(zzeih<T> zzeih, zzefo zzefo) throws IOException {
        int zzbdv = this.zziav.zzbdv();
        if (this.zziav.zziah < this.zziav.zziai) {
            int zzfz = this.zziav.zzfz(zzbdv);
            T newInstance = zzeih.newInstance();
            this.zziav.zziah++;
            zzeih.zza(newInstance, this, zzefo);
            zzeih.zzaj(newInstance);
            this.zziav.zzfx(0);
            zzefc zzefc = this.zziav;
            zzefc.zziah--;
            this.zziav.zzga(zzfz);
            return newInstance;
        }
        throw new zzegl("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzeih<T> zzeih, zzefo zzefo) throws IOException {
        int i = this.zziaw;
        this.zziaw = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzeih.newInstance();
            zzeih.zza(newInstance, this, zzefo);
            zzeih.zzaj(newInstance);
            if (this.tag == this.zziaw) {
                return newInstance;
            }
            throw zzegl.zzbgb();
        } finally {
            this.zziaw = i;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final zzeer zzbdu() throws IOException {
        zzgh(2);
        return this.zziav.zzbdu();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final int zzbdv() throws IOException {
        zzgh(0);
        return this.zziav.zzbdv();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final int zzbdw() throws IOException {
        zzgh(0);
        return this.zziav.zzbdw();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final int zzbdx() throws IOException {
        zzgh(5);
        return this.zziav.zzbdx();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final long zzbdy() throws IOException {
        zzgh(1);
        return this.zziav.zzbdy();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final int zzbdz() throws IOException {
        zzgh(0);
        return this.zziav.zzbdz();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final long zzbea() throws IOException {
        zzgh(0);
        return this.zziav.zzbea();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzk(List<Double> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzefm) {
            zzefm zzefm = (zzefm) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzefm.zzd(this.zziav.readDouble());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else if (i == 2) {
                int zzbdv = this.zziav.zzbdv();
                zzgi(zzbdv);
                int zzbed = this.zziav.zzbed() + zzbdv;
                do {
                    zzefm.zzd(this.zziav.readDouble());
                } while (this.zziav.zzbed() < zzbed);
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zziav.readDouble()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else if (i2 == 2) {
                int zzbdv2 = this.zziav.zzbdv();
                zzgi(zzbdv2);
                int zzbed2 = this.zziav.zzbed() + zzbdv2;
                do {
                    list.add(Double.valueOf(this.zziav.readDouble()));
                } while (this.zziav.zzbed() < zzbed2);
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzl(List<Float> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzega) {
            zzega zzega = (zzega) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbdv = this.zziav.zzbdv();
                zzgj(zzbdv);
                int zzbed = this.zziav.zzbed() + zzbdv;
                do {
                    zzega.zzh(this.zziav.readFloat());
                } while (this.zziav.zzbed() < zzbed);
            } else if (i == 5) {
                do {
                    zzega.zzh(this.zziav.readFloat());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbdv2 = this.zziav.zzbdv();
                zzgj(zzbdv2);
                int zzbed2 = this.zziav.zzbed() + zzbdv2;
                do {
                    list.add(Float.valueOf(this.zziav.readFloat()));
                } while (this.zziav.zzbed() < zzbed2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zziav.readFloat()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzm(List<Long> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzegz) {
            zzegz zzegz = (zzegz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzegz.zzfs(this.zziav.zzbdn());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else if (i == 2) {
                int zzbed = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    zzegz.zzfs(this.zziav.zzbdn());
                } while (this.zziav.zzbed() < zzbed);
                zzgk(zzbed);
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zziav.zzbdn()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else if (i2 == 2) {
                int zzbed2 = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    list.add(Long.valueOf(this.zziav.zzbdn()));
                } while (this.zziav.zzbed() < zzbed2);
                zzgk(zzbed2);
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzn(List<Long> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzegz) {
            zzegz zzegz = (zzegz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzegz.zzfs(this.zziav.zzbdo());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else if (i == 2) {
                int zzbed = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    zzegz.zzfs(this.zziav.zzbdo());
                } while (this.zziav.zzbed() < zzbed);
                zzgk(zzbed);
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zziav.zzbdo()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else if (i2 == 2) {
                int zzbed2 = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    list.add(Long.valueOf(this.zziav.zzbdo()));
                } while (this.zziav.zzbed() < zzbed2);
                zzgk(zzbed2);
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzo(List<Integer> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzege) {
            zzege zzege = (zzege) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzege.zzhb(this.zziav.zzbdp());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else if (i == 2) {
                int zzbed = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    zzege.zzhb(this.zziav.zzbdp());
                } while (this.zziav.zzbed() < zzbed);
                zzgk(zzbed);
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zziav.zzbdp()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else if (i2 == 2) {
                int zzbed2 = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    list.add(Integer.valueOf(this.zziav.zzbdp()));
                } while (this.zziav.zzbed() < zzbed2);
                zzgk(zzbed2);
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzp(List<Long> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzegz) {
            zzegz zzegz = (zzegz) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzegz.zzfs(this.zziav.zzbdq());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else if (i == 2) {
                int zzbdv = this.zziav.zzbdv();
                zzgi(zzbdv);
                int zzbed = this.zziav.zzbed() + zzbdv;
                do {
                    zzegz.zzfs(this.zziav.zzbdq());
                } while (this.zziav.zzbed() < zzbed);
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zziav.zzbdq()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else if (i2 == 2) {
                int zzbdv2 = this.zziav.zzbdv();
                zzgi(zzbdv2);
                int zzbed2 = this.zziav.zzbed() + zzbdv2;
                do {
                    list.add(Long.valueOf(this.zziav.zzbdq()));
                } while (this.zziav.zzbed() < zzbed2);
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzq(List<Integer> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzege) {
            zzege zzege = (zzege) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbdv = this.zziav.zzbdv();
                zzgj(zzbdv);
                int zzbed = this.zziav.zzbed() + zzbdv;
                do {
                    zzege.zzhb(this.zziav.zzbdr());
                } while (this.zziav.zzbed() < zzbed);
            } else if (i == 5) {
                do {
                    zzege.zzhb(this.zziav.zzbdr());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbdv2 = this.zziav.zzbdv();
                zzgj(zzbdv2);
                int zzbed2 = this.zziav.zzbed() + zzbdv2;
                do {
                    list.add(Integer.valueOf(this.zziav.zzbdr()));
                } while (this.zziav.zzbed() < zzbed2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zziav.zzbdr()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzr(List<Boolean> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzeep) {
            zzeep zzeep = (zzeep) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeep.addBoolean(this.zziav.zzbds());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else if (i == 2) {
                int zzbed = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    zzeep.addBoolean(this.zziav.zzbds());
                } while (this.zziav.zzbed() < zzbed);
                zzgk(zzbed);
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zziav.zzbds()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else if (i2 == 2) {
                int zzbed2 = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    list.add(Boolean.valueOf(this.zziav.zzbds()));
                } while (this.zziav.zzbed() < zzbed2);
                zzgk(zzbed2);
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzs(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzbdm;
        int zzbdm2;
        if ((this.tag & 7) != 2) {
            throw zzegl.zzbfz();
        } else if (!(list instanceof zzegw) || z) {
            do {
                list.add(z ? zzbdt() : readString());
                if (!this.zziav.zzbec()) {
                    zzbdm = this.zziav.zzbdm();
                } else {
                    return;
                }
            } while (zzbdm == this.tag);
            this.zziax = zzbdm;
        } else {
            zzegw zzegw = (zzegw) list;
            do {
                zzegw.zzaj(zzbdu());
                if (!this.zziav.zzbec()) {
                    zzbdm2 = this.zziav.zzbdm();
                } else {
                    return;
                }
            } while (zzbdm2 == this.tag);
            this.zziax = zzbdm2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final <T> void zza(List<T> list, zzeih<T> zzeih, zzefo zzefo) throws IOException {
        int zzbdm;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzeih, zzefo));
                if (!this.zziav.zzbec() && this.zziax == 0) {
                    zzbdm = this.zziav.zzbdm();
                } else {
                    return;
                }
            } while (zzbdm == i);
            this.zziax = zzbdm;
            return;
        }
        throw zzegl.zzbfz();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final <T> void zzb(List<T> list, zzeih<T> zzeih, zzefo zzefo) throws IOException {
        int zzbdm;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzeih, zzefo));
                if (!this.zziav.zzbec() && this.zziax == 0) {
                    zzbdm = this.zziav.zzbdm();
                } else {
                    return;
                }
            } while (zzbdm == i);
            this.zziax = zzbdm;
            return;
        }
        throw zzegl.zzbfz();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzt(List<zzeer> list) throws IOException {
        int zzbdm;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzbdu());
                if (!this.zziav.zzbec()) {
                    zzbdm = this.zziav.zzbdm();
                } else {
                    return;
                }
            } while (zzbdm == this.tag);
            this.zziax = zzbdm;
            return;
        }
        throw zzegl.zzbfz();
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzu(List<Integer> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzege) {
            zzege zzege = (zzege) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzege.zzhb(this.zziav.zzbdv());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else if (i == 2) {
                int zzbed = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    zzege.zzhb(this.zziav.zzbdv());
                } while (this.zziav.zzbed() < zzbed);
                zzgk(zzbed);
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zziav.zzbdv()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else if (i2 == 2) {
                int zzbed2 = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    list.add(Integer.valueOf(this.zziav.zzbdv()));
                } while (this.zziav.zzbed() < zzbed2);
                zzgk(zzbed2);
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzv(List<Integer> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzege) {
            zzege zzege = (zzege) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzege.zzhb(this.zziav.zzbdw());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else if (i == 2) {
                int zzbed = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    zzege.zzhb(this.zziav.zzbdw());
                } while (this.zziav.zzbed() < zzbed);
                zzgk(zzbed);
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zziav.zzbdw()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else if (i2 == 2) {
                int zzbed2 = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    list.add(Integer.valueOf(this.zziav.zzbdw()));
                } while (this.zziav.zzbed() < zzbed2);
                zzgk(zzbed2);
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzw(List<Integer> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzege) {
            zzege zzege = (zzege) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbdv = this.zziav.zzbdv();
                zzgj(zzbdv);
                int zzbed = this.zziav.zzbed() + zzbdv;
                do {
                    zzege.zzhb(this.zziav.zzbdx());
                } while (this.zziav.zzbed() < zzbed);
            } else if (i == 5) {
                do {
                    zzege.zzhb(this.zziav.zzbdx());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbdv2 = this.zziav.zzbdv();
                zzgj(zzbdv2);
                int zzbed2 = this.zziav.zzbed() + zzbdv2;
                do {
                    list.add(Integer.valueOf(this.zziav.zzbdx()));
                } while (this.zziav.zzbed() < zzbed2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zziav.zzbdx()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzx(List<Long> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzegz) {
            zzegz zzegz = (zzegz) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzegz.zzfs(this.zziav.zzbdy());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else if (i == 2) {
                int zzbdv = this.zziav.zzbdv();
                zzgi(zzbdv);
                int zzbed = this.zziav.zzbed() + zzbdv;
                do {
                    zzegz.zzfs(this.zziav.zzbdy());
                } while (this.zziav.zzbed() < zzbed);
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zziav.zzbdy()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else if (i2 == 2) {
                int zzbdv2 = this.zziav.zzbdv();
                zzgi(zzbdv2);
                int zzbed2 = this.zziav.zzbed() + zzbdv2;
                do {
                    list.add(Long.valueOf(this.zziav.zzbdy()));
                } while (this.zziav.zzbed() < zzbed2);
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzy(List<Integer> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzege) {
            zzege zzege = (zzege) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzege.zzhb(this.zziav.zzbdz());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else if (i == 2) {
                int zzbed = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    zzege.zzhb(this.zziav.zzbdz());
                } while (this.zziav.zzbed() < zzbed);
                zzgk(zzbed);
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zziav.zzbdz()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else if (i2 == 2) {
                int zzbed2 = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    list.add(Integer.valueOf(this.zziav.zzbdz()));
                } while (this.zziav.zzbed() < zzbed2);
                zzgk(zzbed2);
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final void zzz(List<Long> list) throws IOException {
        int zzbdm;
        int zzbdm2;
        if (list instanceof zzegz) {
            zzegz zzegz = (zzegz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzegz.zzfs(this.zziav.zzbea());
                    if (!this.zziav.zzbec()) {
                        zzbdm2 = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm2 == this.tag);
                this.zziax = zzbdm2;
            } else if (i == 2) {
                int zzbed = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    zzegz.zzfs(this.zziav.zzbea());
                } while (this.zziav.zzbed() < zzbed);
                zzgk(zzbed);
            } else {
                throw zzegl.zzbfz();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zziav.zzbea()));
                    if (!this.zziav.zzbec()) {
                        zzbdm = this.zziav.zzbdm();
                    } else {
                        return;
                    }
                } while (zzbdm == this.tag);
                this.zziax = zzbdm;
            } else if (i2 == 2) {
                int zzbed2 = this.zziav.zzbed() + this.zziav.zzbdv();
                do {
                    list.add(Long.valueOf(this.zziav.zzbea()));
                } while (this.zziav.zzbed() < zzbed2);
                zzgk(zzbed2);
            } else {
                throw zzegl.zzbfz();
            }
        }
    }

    private static void zzgi(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzegl.zzbgb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final <K, V> void zza(Map<K, V> map, zzehg<K, V> zzehg, zzefo zzefo) throws IOException {
        zzgh(2);
        int zzfz = this.zziav.zzfz(this.zziav.zzbdv());
        K k = zzehg.zzign;
        V v = zzehg.zzckr;
        while (true) {
            try {
                int zzbek = zzbek();
                if (zzbek == Integer.MAX_VALUE || this.zziav.zzbec()) {
                    map.put(k, v);
                } else if (zzbek == 1) {
                    k = zza(zzehg.zzigm, (Class<?>) null, (zzefo) null);
                } else if (zzbek != 2) {
                    try {
                        if (!zzbel()) {
                            throw new zzegl("Unable to parse map entry.");
                        }
                    } catch (zzego unused) {
                        if (!zzbel()) {
                            throw new zzegl("Unable to parse map entry.");
                        }
                    }
                } else {
                    v = zza(zzehg.zzigo, zzehg.zzckr.getClass(), zzefo);
                }
            } finally {
                this.zziav.zzga(zzfz);
            }
        }
        map.put(k, v);
    }

    private final Object zza(zzejq zzejq, Class<?> cls, zzefo zzefo) throws IOException {
        switch (zzefi.zziau[zzejq.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzbds());
            case 2:
                return zzbdu();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzbdw());
            case 5:
                return Integer.valueOf(zzbdr());
            case 6:
                return Long.valueOf(zzbdq());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzbdp());
            case 9:
                return Long.valueOf(zzbdo());
            case 10:
                zzgh(2);
                return zzc(zzeia.zzbgz().zzh(cls), zzefo);
            case 11:
                return Integer.valueOf(zzbdx());
            case 12:
                return Long.valueOf(zzbdy());
            case 13:
                return Integer.valueOf(zzbdz());
            case 14:
                return Long.valueOf(zzbea());
            case 15:
                return zzbdt();
            case 16:
                return Integer.valueOf(zzbdv());
            case 17:
                return Long.valueOf(zzbdn());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzgj(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzegl.zzbgb();
        }
    }

    private final void zzgk(int i) throws IOException {
        if (this.zziav.zzbed() != i) {
            throw zzegl.zzbfu();
        }
    }
}
