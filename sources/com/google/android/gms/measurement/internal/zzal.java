package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzal {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final zzan zze;
    private final String zzf;

    private zzal(zzgd zzgd, String str, String str2, String str3, long j, long j2, zzan zzan) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzan);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzgd.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId, name", zzez.zza(str2), zzez.zza(str3));
        }
        this.zze = zzan;
    }

    zzal(zzgd zzgd, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzan zzan;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzgd.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId", zzez.zza(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzan = new zzan(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it2 = bundle2.keySet().iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (next == null) {
                    zzgd.zzr().zzf().zza("Param name can't be null");
                    it2.remove();
                } else {
                    Object zza2 = zzgd.zzi().zza(next, bundle2.get(next));
                    if (zza2 == null) {
                        zzgd.zzr().zzi().zza("Param value can't be null", zzgd.zzj().zzb(next));
                        it2.remove();
                    } else {
                        zzgd.zzi().zza(bundle2, next, zza2);
                    }
                }
            }
            zzan = new zzan(bundle2);
        }
        this.zze = zzan;
    }

    /* access modifiers changed from: package-private */
    public final zzal zza(zzgd zzgd, long j) {
        return new zzal(zzgd, this.zzf, this.zza, this.zzb, this.zzc, j, this.zze);
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String valueOf = String.valueOf(this.zze);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }
}
