package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzefn implements zzejw {
    private final zzefl zziaa;

    public static zzefn zza(zzefl zzefl) {
        if (zzefl.zziaz != null) {
            return zzefl.zziaz;
        }
        return new zzefn(zzefl);
    }

    private zzefn(zzefl zzefl) {
        zzefl zzefl2 = (zzefl) zzegd.zza(zzefl, "output");
        this.zziaa = zzefl2;
        zzefl2.zziaz = this;
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final int zzbep() {
        return zzegb.zze.zziez;
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzal(int i, int i2) throws IOException {
        this.zziaa.zzae(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzp(int i, long j) throws IOException {
        this.zziaa.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzq(int i, long j) throws IOException {
        this.zziaa.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zza(int i, float f) throws IOException {
        this.zziaa.zza(i, f);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzb(int i, double d) throws IOException {
        this.zziaa.zzb(i, d);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzam(int i, int i2) throws IOException {
        this.zziaa.zzab(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzh(int i, long j) throws IOException {
        this.zziaa.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzab(int i, int i2) throws IOException {
        this.zziaa.zzab(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzj(int i, long j) throws IOException {
        this.zziaa.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzae(int i, int i2) throws IOException {
        this.zziaa.zzae(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzh(int i, boolean z) throws IOException {
        this.zziaa.zzh(i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzk(int i, String str) throws IOException {
        this.zziaa.zzk(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zza(int i, zzeer zzeer) throws IOException {
        this.zziaa.zza(i, zzeer);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzac(int i, int i2) throws IOException {
        this.zziaa.zzac(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzad(int i, int i2) throws IOException {
        this.zziaa.zzad(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzi(int i, long j) throws IOException {
        this.zziaa.zzi(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zza(int i, Object obj, zzeih zzeih) throws IOException {
        this.zziaa.zza(i, (zzehl) obj, zzeih);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzb(int i, Object obj, zzeih zzeih) throws IOException {
        zzefl zzefl = this.zziaa;
        zzefl.writeTag(i, 3);
        zzeih.zza((zzehl) obj, zzefl.zziaz);
        zzefl.writeTag(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzgy(int i) throws IOException {
        this.zziaa.writeTag(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzgz(int i) throws IOException {
        this.zziaa.writeTag(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzc(int i, Object obj) throws IOException {
        if (obj instanceof zzeer) {
            this.zziaa.zzb(i, (zzeer) obj);
        } else {
            this.zziaa.zza(i, (zzehl) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzgq(list.get(i4).intValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzgl(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzab(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzgt(list.get(i4).intValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzgo(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzae(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzfl(list.get(i4).longValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzfi(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzfm(list.get(i4).longValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzfi(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzfo(list.get(i4).longValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzfk(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzg(list.get(i4).floatValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzf(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzc(list.get(i4).doubleValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzb(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzgv(list.get(i4).intValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzgl(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzab(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzbt(list.get(i4).booleanValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzbs(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzh(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzegw) {
            zzegw zzegw = (zzegw) list;
            while (i2 < list.size()) {
                Object zzhd = zzegw.zzhd(i2);
                if (zzhd instanceof String) {
                    this.zziaa.zzk(i, (String) zzhd);
                } else {
                    this.zziaa.zza(i, (zzeer) zzhd);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzk(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzb(int i, List<zzeer> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zziaa.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzgr(list.get(i4).intValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzgm(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzac(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzgu(list.get(i4).intValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzgo(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzae(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzfp(list.get(i4).longValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzfk(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzgs(list.get(i4).intValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzgn(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzad(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziaa.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefl.zzfn(list.get(i4).longValue());
            }
            this.zziaa.zzgm(i3);
            while (i2 < list.size()) {
                this.zziaa.zzfj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziaa.zzi(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zza(int i, List<?> list, zzeih zzeih) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzeih);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final void zzb(int i, List<?> list, zzeih zzeih) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzeih);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final <K, V> void zza(int i, zzehg<K, V> zzehg, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zziaa.writeTag(i, 2);
            this.zziaa.zzgm(zzehd.zza(zzehg, entry.getKey(), entry.getValue()));
            zzehd.zza(this.zziaa, zzehg, entry.getKey(), entry.getValue());
        }
    }
}
