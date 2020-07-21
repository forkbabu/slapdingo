package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzna;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
final class zzq {
    private String zza;
    private boolean zzb;
    private zzcc.zzi zzc;
    /* access modifiers changed from: private */
    public BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzo zzh;

    private zzq(zzo zzo, String str) {
        this.zzh = zzo;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzq(zzo zzo, String str, zzcc.zzi zzi, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzo;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.zzg.put(num, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zzi;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzv zzv) {
        int zza2 = zzv.zza();
        if (zzv.zzc != null) {
            this.zze.set(zza2, zzv.zzc.booleanValue());
        }
        if (zzv.zzd != null) {
            this.zzd.set(zza2, zzv.zzd.booleanValue());
        }
        if (zzv.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(zza2));
            long longValue = zzv.zze.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(zza2), Long.valueOf(longValue));
            }
        }
        if (zzv.zzf != null) {
            List<Long> list = this.zzg.get(Integer.valueOf(zza2));
            if (list == null) {
                list = new ArrayList<>();
                this.zzg.put(Integer.valueOf(zza2), list);
            }
            if (zzv.zzb()) {
                list.clear();
            }
            if (zzna.zzb() && this.zzh.zzt().zzd(this.zza, zzaq.zzbf) && zzv.zzc()) {
                list.clear();
            }
            if (!zzna.zzb() || !this.zzh.zzt().zzd(this.zza, zzaq.zzbf)) {
                list.add(Long.valueOf(zzv.zzf.longValue() / 1000));
                return;
            }
            long longValue2 = zzv.zzf.longValue() / 1000;
            if (!list.contains(Long.valueOf(longValue2))) {
                list.add(Long.valueOf(longValue2));
            }
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:23:0x00d3 */
    /* JADX DEBUG: Additional 1 move instruction added to help type inference */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.List] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzcc.zza zza(int r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.measurement.zzcc$zza$zza r0 = com.google.android.gms.internal.measurement.zzcc.zza.zzh()
            r0.zza(r8)
            boolean r8 = r7.zzb
            r0.zza(r8)
            com.google.android.gms.internal.measurement.zzcc$zzi r8 = r7.zzc
            if (r8 == 0) goto L_0x0013
            r0.zza(r8)
        L_0x0013:
            com.google.android.gms.internal.measurement.zzcc$zzi$zza r8 = com.google.android.gms.internal.measurement.zzcc.zzi.zzi()
            java.util.BitSet r1 = r7.zzd
            java.util.List r1 = com.google.android.gms.measurement.internal.zzks.zza(r1)
            com.google.android.gms.internal.measurement.zzcc$zzi$zza r8 = r8.zzb(r1)
            java.util.BitSet r1 = r7.zze
            java.util.List r1 = com.google.android.gms.measurement.internal.zzks.zza(r1)
            com.google.android.gms.internal.measurement.zzcc$zzi$zza r8 = r8.zza(r1)
            java.util.Map<java.lang.Integer, java.lang.Long> r1 = r7.zzf
            if (r1 != 0) goto L_0x0031
            r1 = 0
            goto L_0x007e
        L_0x0031:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Map<java.lang.Integer, java.lang.Long> r2 = r7.zzf
            int r2 = r2.size()
            r1.<init>(r2)
            java.util.Map<java.lang.Integer, java.lang.Long> r2 = r7.zzf
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0046:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x007e
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            com.google.android.gms.internal.measurement.zzcc$zzb$zza r4 = com.google.android.gms.internal.measurement.zzcc.zzb.zze()
            com.google.android.gms.internal.measurement.zzcc$zzb$zza r4 = r4.zza(r3)
            java.util.Map<java.lang.Integer, java.lang.Long> r5 = r7.zzf
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r3 = r5.get(r3)
            java.lang.Long r3 = (java.lang.Long) r3
            long r5 = r3.longValue()
            com.google.android.gms.internal.measurement.zzcc$zzb$zza r3 = r4.zza(r5)
            com.google.android.gms.internal.measurement.zzjj r3 = r3.zzv()
            com.google.android.gms.internal.measurement.zzib r3 = (com.google.android.gms.internal.measurement.zzib) r3
            com.google.android.gms.internal.measurement.zzcc$zzb r3 = (com.google.android.gms.internal.measurement.zzcc.zzb) r3
            r1.add(r3)
            goto L_0x0046
        L_0x007e:
            r8.zzc(r1)
            java.util.Map<java.lang.Integer, java.util.List<java.lang.Long>> r1 = r7.zzg
            if (r1 != 0) goto L_0x008a
            java.util.List r1 = java.util.Collections.emptyList()
            goto L_0x00d3
        L_0x008a:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Map<java.lang.Integer, java.util.List<java.lang.Long>> r2 = r7.zzg
            int r2 = r2.size()
            r1.<init>(r2)
            java.util.Map<java.lang.Integer, java.util.List<java.lang.Long>> r2 = r7.zzg
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x009f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00d3
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            com.google.android.gms.internal.measurement.zzcc$zzj$zza r4 = com.google.android.gms.internal.measurement.zzcc.zzj.zze()
            int r5 = r3.intValue()
            com.google.android.gms.internal.measurement.zzcc$zzj$zza r4 = r4.zza(r5)
            java.util.Map<java.lang.Integer, java.util.List<java.lang.Long>> r5 = r7.zzg
            java.lang.Object r3 = r5.get(r3)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x00c7
            java.util.Collections.sort(r3)
            r4.zza(r3)
        L_0x00c7:
            com.google.android.gms.internal.measurement.zzjj r3 = r4.zzv()
            com.google.android.gms.internal.measurement.zzib r3 = (com.google.android.gms.internal.measurement.zzib) r3
            com.google.android.gms.internal.measurement.zzcc$zzj r3 = (com.google.android.gms.internal.measurement.zzcc.zzj) r3
            r1.add(r3)
            goto L_0x009f
        L_0x00d3:
            r8.zzd(r1)
            r0.zza(r8)
            com.google.android.gms.internal.measurement.zzjj r8 = r0.zzv()
            com.google.android.gms.internal.measurement.zzib r8 = (com.google.android.gms.internal.measurement.zzib) r8
            com.google.android.gms.internal.measurement.zzcc$zza r8 = (com.google.android.gms.internal.measurement.zzcc.zza) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zza(int):com.google.android.gms.internal.measurement.zzcc$zza");
    }

    /* synthetic */ zzq(zzo zzo, String str, zzcc.zzi zzi, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzr zzr) {
        this(zzo, str, zzi, bitSet, bitSet2, map, map2);
    }

    /* synthetic */ zzq(zzo zzo, String str, zzr zzr) {
        this(zzo, str);
    }
}
