package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzib;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
final class zzt {
    private zzcc.zzc zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzo zzd;

    private zzt(zzo zzo) {
        this.zzd = zzo;
    }

    /* access modifiers changed from: package-private */
    public final zzcc.zzc zza(String str, zzcc.zzc zzc2) {
        String zzc3 = zzc2.zzc();
        List<zzcc.zze> zza2 = zzc2.zza();
        Long l = (Long) this.zzd.zzg().zzb(zzc2, "_eid");
        boolean z = l != null;
        if (z && zzc3.equals("_ep")) {
            zzc3 = (String) this.zzd.zzg().zzb(zzc2, "_en");
            if (TextUtils.isEmpty(zzc3)) {
                this.zzd.zzr().zzg().zza("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair<zzcc.zzc, Long> zza3 = this.zzd.zzi().zza(str, l);
                if (zza3 == null || zza3.first == null) {
                    this.zzd.zzr().zzg().zza("Extra parameter without existing main event. eventName, eventId", zzc3, l);
                    return null;
                }
                this.zza = (zzcc.zzc) zza3.first;
                this.zzc = ((Long) zza3.second).longValue();
                this.zzb = (Long) this.zzd.zzg().zzb(this.zza, "_eid");
            }
            long j = this.zzc - 1;
            this.zzc = j;
            if (j <= 0) {
                zzad zzi = this.zzd.zzi();
                zzi.zzd();
                zzi.zzr().zzx().zza("Clearing complex main event info. appId", str);
                try {
                    zzi.c_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    zzi.zzr().zzf().zza("Error clearing complex main event", e);
                }
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzcc.zze zze : this.zza.zza()) {
                this.zzd.zzg();
                if (zzks.zza(zzc2, zze.zzb()) == null) {
                    arrayList.add(zze);
                }
            }
            if (!arrayList.isEmpty()) {
                arrayList.addAll(zza2);
                zza2 = arrayList;
            } else {
                this.zzd.zzr().zzg().zza("No unique parameters in main event. eventName", zzc3);
            }
        } else if (z) {
            this.zzb = l;
            this.zza = zzc2;
            long j2 = 0L;
            Object zzb2 = this.zzd.zzg().zzb(zzc2, "_epc");
            if (zzb2 != null) {
                j2 = zzb2;
            }
            long longValue = j2.longValue();
            this.zzc = longValue;
            if (longValue <= 0) {
                this.zzd.zzr().zzg().zza("Complex event with zero extra param count. eventName", zzc3);
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, zzc2);
            }
        }
        return (zzcc.zzc) ((zzib) ((zzcc.zzc.zza) zzc2.zzbl()).zza(zzc3).zzc().zza(zza2).zzv());
    }

    /* synthetic */ zzt(zzo zzo, zzr zzr) {
        this(zzo);
    }
}
