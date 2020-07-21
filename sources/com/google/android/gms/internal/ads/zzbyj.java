package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbyj extends zzbwv<zzqs> implements zzqs {
    private final zzdkk zzfol;
    private Map<View, zzqo> zzftk = new WeakHashMap(1);
    private final Context zzvr;

    public zzbyj(Context context, Set<zzbyg<zzqs>> set, zzdkk zzdkk) {
        super(set);
        this.zzvr = context;
        this.zzfol = zzdkk;
    }

    @Override // com.google.android.gms.internal.ads.zzqs
    public final synchronized void zza(zzqt zzqt) {
        zza(new zzbyi(zzqt));
    }

    public final synchronized void zzv(View view) {
        zzqo zzqo = this.zzftk.get(view);
        if (zzqo == null) {
            zzqo = new zzqo(this.zzvr, view);
            zzqo.zza(this);
            this.zzftk.put(view, zzqo);
        }
        if (this.zzfol != null && this.zzfol.zzdsi) {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcpk)).booleanValue()) {
                zzqo.zzen(((Long) zzwg.zzpw().zzd(zzaav.zzcpj)).longValue());
                return;
            }
        }
        zzqo.zzlv();
    }

    public final synchronized void zzw(View view) {
        if (this.zzftk.containsKey(view)) {
            this.zzftk.get(view).zzb(this);
            this.zzftk.remove(view);
        }
    }
}
