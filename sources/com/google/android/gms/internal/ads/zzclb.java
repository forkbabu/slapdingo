package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzclb implements zzdpa {
    private final Clock zzbqd;
    private final Map<zzdor, Long> zzgep = new HashMap();
    private final zzckv zzgeq;
    private final Map<zzdor, zzcla> zzger = new HashMap();

    public zzclb(zzckv zzckv, Set<zzcla> set, Clock clock) {
        this.zzgeq = zzckv;
        for (zzcla zzcla : set) {
            this.zzger.put(zzcla.zzgeo, zzcla);
        }
        this.zzbqd = clock;
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zza(zzdor zzdor, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zzb(zzdor zzdor, String str) {
        this.zzgep.put(zzdor, Long.valueOf(this.zzbqd.elapsedRealtime()));
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zza(zzdor zzdor, String str, Throwable th) {
        if (this.zzgep.containsKey(zzdor)) {
            long elapsedRealtime = this.zzbqd.elapsedRealtime() - this.zzgep.get(zzdor).longValue();
            Map<String, String> zzro = this.zzgeq.zzro();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzro.put(concat, valueOf2.length() != 0 ? "f.".concat(valueOf2) : new String("f."));
        }
        if (this.zzger.containsKey(zzdor)) {
            zza(zzdor, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zzc(zzdor zzdor, String str) {
        if (this.zzgep.containsKey(zzdor)) {
            long elapsedRealtime = this.zzbqd.elapsedRealtime() - this.zzgep.get(zzdor).longValue();
            Map<String, String> zzro = this.zzgeq.zzro();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzro.put(concat, valueOf2.length() != 0 ? "s.".concat(valueOf2) : new String("s."));
        }
        if (this.zzger.containsKey(zzdor)) {
            zza(zzdor, true);
        }
    }

    private final void zza(zzdor zzdor, boolean z) {
        zzdor zzb = this.zzger.get(zzdor).zzgen;
        String str = z ? "s." : "f.";
        if (this.zzgep.containsKey(zzb)) {
            long elapsedRealtime = this.zzbqd.elapsedRealtime() - this.zzgep.get(zzb).longValue();
            Map<String, String> zzro = this.zzgeq.zzro();
            String valueOf = String.valueOf(this.zzger.get(zzdor).label);
            String concat = valueOf.length() != 0 ? "label.".concat(valueOf) : new String("label.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzro.put(concat, valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
    }
}
