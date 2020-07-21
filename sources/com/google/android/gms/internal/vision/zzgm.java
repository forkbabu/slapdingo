package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzgm extends zzgk<zzgx.zzd> {
    zzgm() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final boolean zze(zzih zzih) {
        return zzih instanceof zzgx.zze;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final zzgn<zzgx.zzd> zzf(Object obj) {
        return ((zzgx.zze) obj).zzwz;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final zzgn<zzgx.zzd> zzg(Object obj) {
        return ((zzgx.zze) obj).zzgl();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final void zzh(Object obj) {
        zzf(obj).zzdq();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final <UT, UB> UB zza(zzix zzix, Object obj, zzgi zzgi, zzgn<zzgx.zzd> zzgn, UB ub, zzjo<UT, UB> zzjo) throws IOException {
        Object zza;
        ArrayList arrayList;
        zzgx.zzg zzg = (zzgx.zzg) obj;
        int i = zzg.zzxq.number;
        if (!zzg.zzxq.zzwx || !zzg.zzxq.zzwy) {
            Object obj2 = null;
            if (zzg.zzxq.zzww != zzkf.ENUM) {
                switch (zzgl.zzsg[zzg.zzxq.zzww.ordinal()]) {
                    case 1:
                        obj2 = Double.valueOf(zzix.readDouble());
                        break;
                    case 2:
                        obj2 = Float.valueOf(zzix.readFloat());
                        break;
                    case 3:
                        obj2 = Long.valueOf(zzix.zzdy());
                        break;
                    case 4:
                        obj2 = Long.valueOf(zzix.zzdx());
                        break;
                    case 5:
                        obj2 = Integer.valueOf(zzix.zzdz());
                        break;
                    case 6:
                        obj2 = Long.valueOf(zzix.zzea());
                        break;
                    case 7:
                        obj2 = Integer.valueOf(zzix.zzeb());
                        break;
                    case 8:
                        obj2 = Boolean.valueOf(zzix.zzec());
                        break;
                    case 9:
                        obj2 = Integer.valueOf(zzix.zzef());
                        break;
                    case 10:
                        obj2 = Integer.valueOf(zzix.zzeh());
                        break;
                    case 11:
                        obj2 = Long.valueOf(zzix.zzei());
                        break;
                    case 12:
                        obj2 = Integer.valueOf(zzix.zzej());
                        break;
                    case 13:
                        obj2 = Long.valueOf(zzix.zzek());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        obj2 = zzix.zzee();
                        break;
                    case 16:
                        obj2 = zzix.readString();
                        break;
                    case 17:
                        obj2 = zzix.zzb(zzg.zzxp.getClass(), zzgi);
                        break;
                    case 18:
                        obj2 = zzix.zza(zzg.zzxp.getClass(), zzgi);
                        break;
                }
            } else {
                int zzdz = zzix.zzdz();
                if (zzg.zzxq.zzwv.zzh(zzdz) == null) {
                    return zziy.zza(i, zzdz, ub, zzjo);
                }
                obj2 = Integer.valueOf(zzdz);
            }
            if (zzg.zzxq.zzwx) {
                zzgn.zzb(zzg.zzxq, obj2);
            } else {
                int i2 = zzgl.zzsg[zzg.zzxq.zzww.ordinal()];
                if ((i2 == 17 || i2 == 18) && (zza = zzgn.zza(zzg.zzxq)) != null) {
                    obj2 = zzgy.zzb(zza, obj2);
                }
                zzgn.zza(zzg.zzxq, obj2);
            }
        } else {
            switch (zzgl.zzsg[zzg.zzxq.zzww.ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    zzix.zza(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    zzix.zzb(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    zzix.zzd(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    zzix.zzc(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    zzix.zze(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    zzix.zzf(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    zzix.zzg(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    zzix.zzh(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    zzix.zzk(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    zzix.zzm(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    zzix.zzn(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    zzix.zzo(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    zzix.zzp(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    zzix.zzl(arrayList);
                    ub = zziy.zza(i, arrayList, zzg.zzxq.zzwv, ub, zzjo);
                    break;
                default:
                    String valueOf = String.valueOf(zzg.zzxq.zzww);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
                    sb.append("Type cannot be packed: ");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
            }
            zzgn.zza(zzg.zzxq, arrayList);
        }
        return ub;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final int zza(Map.Entry<?, ?> entry) {
        return ((zzgx.zzd) entry.getKey()).number;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final void zza(zzkl zzkl, Map.Entry<?, ?> entry) throws IOException {
        zzgx.zzd zzd = (zzgx.zzd) entry.getKey();
        if (zzd.zzwx) {
            switch (zzgl.zzsg[zzd.zzww.ordinal()]) {
                case 1:
                    zziy.zza(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 2:
                    zziy.zzb(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 3:
                    zziy.zzc(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 4:
                    zziy.zzd(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 5:
                    zziy.zzh(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 6:
                    zziy.zzf(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 7:
                    zziy.zzk(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 8:
                    zziy.zzn(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 9:
                    zziy.zzi(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 10:
                    zziy.zzl(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 11:
                    zziy.zzg(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 12:
                    zziy.zzj(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 13:
                    zziy.zze(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 14:
                    zziy.zzh(zzd.number, (List) entry.getValue(), zzkl, zzd.zzwy);
                    return;
                case 15:
                    zziy.zzb(zzd.number, (List) entry.getValue(), zzkl);
                    return;
                case 16:
                    zziy.zza(zzd.number, (List) entry.getValue(), zzkl);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        zziy.zzb(zzd.number, (List) entry.getValue(), zzkl, zzis.zzhp().zzf(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        zziy.zza(zzd.number, (List) entry.getValue(), zzkl, zzis.zzhp().zzf(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (zzgl.zzsg[zzd.zzww.ordinal()]) {
                case 1:
                    zzkl.zza(zzd.number, ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    zzkl.zza(zzd.number, ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    zzkl.zzi(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    zzkl.zza(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    zzkl.zzh(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    zzkl.zzc(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    zzkl.zzk(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    zzkl.zza(zzd.number, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    zzkl.zzi(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    zzkl.zzr(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    zzkl.zzj(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    zzkl.zzj(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    zzkl.zzb(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    zzkl.zzh(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    zzkl.zza(zzd.number, (zzfm) entry.getValue());
                    return;
                case 16:
                    zzkl.zza(zzd.number, (String) entry.getValue());
                    return;
                case 17:
                    zzkl.zzb(zzd.number, entry.getValue(), zzis.zzhp().zzf(entry.getValue().getClass()));
                    return;
                case 18:
                    zzkl.zza(zzd.number, entry.getValue(), zzis.zzhp().zzf(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final Object zza(zzgi zzgi, zzih zzih, int i) {
        return zzgi.zza(zzih, i);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final void zza(zzix zzix, Object obj, zzgi zzgi, zzgn<zzgx.zzd> zzgn) throws IOException {
        zzgx.zzg zzg = (zzgx.zzg) obj;
        zzgn.zza(zzg.zzxq, zzix.zza(zzg.zzxp.getClass(), zzgi));
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final void zza(zzfm zzfm, Object obj, zzgi zzgi, zzgn<zzgx.zzd> zzgn) throws IOException {
        byte[] bArr;
        zzgx.zzg zzg = (zzgx.zzg) obj;
        zzih zzgc = zzg.zzxp.zzgk().zzgc();
        int size = zzfm.size();
        if (size == 0) {
            bArr = zzgy.zzxr;
        } else {
            byte[] bArr2 = new byte[size];
            zzfm.zza(bArr2, 0, 0, size);
            bArr = bArr2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.hasArray()) {
            zzfl zzfl = new zzfl(wrap, true);
            zzis.zzhp().zzv(zzgc).zza(zzgc, zzfl, zzgi);
            zzgn.zza(zzg.zzxq, zzgc);
            if (zzfl.zzdv() != Integer.MAX_VALUE) {
                throw zzhh.zzgr();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
