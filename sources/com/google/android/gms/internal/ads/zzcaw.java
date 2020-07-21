package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcaw implements zzbpc<zzbph> {
    private final zzccv zzfnj;
    private final Map<String, zzcqt<zzbph>> zzfpf;
    private final Map<String, zzcqt<zzccd>> zzfuj;
    private final Map<String, zzcsu<zzccd>> zzfuk;
    private final zzelj<zzbpc<zzbnc>> zzful;

    zzcaw(Map<String, zzcqt<zzbph>> map, Map<String, zzcqt<zzccd>> map2, Map<String, zzcsu<zzccd>> map3, zzelj<zzbpc<zzbnc>> zzelj, zzccv zzccv) {
        this.zzfpf = map;
        this.zzfuj = map2;
        this.zzfuk = map3;
        this.zzful = zzelj;
        this.zzfnj = zzccv;
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final zzcqt<zzbph> zze(int i, String str) {
        zzcqt<zzbnc> zze;
        zzcqt<zzbph> zzcqt = this.zzfpf.get(str);
        if (zzcqt != null) {
            return zzcqt;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzcsu<zzccd> zzcsu = this.zzfuk.get(str);
            if (zzcsu != null) {
                return zzbph.zza((zzcsu<? extends zzbpb>) zzcsu);
            }
            zzcqt<zzccd> zzcqt2 = this.zzfuj.get(str);
            if (zzcqt2 != null) {
                return zzbph.zza(zzcqt2);
            }
            return null;
        } else if (this.zzfnj.zzaly() == null || (zze = this.zzful.get().zze(i, str)) == null) {
            return null;
        } else {
            return zzbph.zza(zze);
        }
    }
}
