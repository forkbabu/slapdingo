package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdde implements zzdec<zzddb> {
    private final ScheduledExecutorService zzfkm;
    private final zzdla zzfpv;
    private final zzdvi zzgad;
    private final zzcwh zzgnj;
    private String zzgqz;
    private final zzcwj zzgtq;
    private final Context zzvr;

    public zzdde(zzdvi zzdvi, ScheduledExecutorService scheduledExecutorService, String str, zzcwj zzcwj, Context context, zzdla zzdla, zzcwh zzcwh) {
        this.zzgad = zzdvi;
        this.zzfkm = scheduledExecutorService;
        this.zzgqz = str;
        this.zzgtq = zzcwj;
        this.zzvr = context;
        this.zzfpv = zzdla;
        this.zzgnj = zzcwh;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzddb> zzaqm() {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcpp)).booleanValue()) {
            return zzdux.zza(new zzddd(this), this.zzgad);
        }
        return zzdux.zzaf(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(String str, List list, Bundle bundle) throws Exception {
        zzbbn zzbbn = new zzbbn();
        this.zzgnj.zzgn(str);
        zzaox zzgo = this.zzgnj.zzgo(str);
        if (zzgo != null) {
            zzgo.zza(ObjectWrapper.wrap(this.zzvr), this.zzgqz, bundle, (Bundle) list.get(0), this.zzfpv.zzboz, new zzcwp(str, zzgo, zzbbn));
            return zzbbn;
        }
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzaqy() {
        Map<String, List<Bundle>> zzs = this.zzgtq.zzs(this.zzgqz, this.zzfpv.zzhaz);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<Bundle>> entry : zzs.entrySet()) {
            String key = entry.getKey();
            arrayList.add(zzduo.zzg(zzdux.zza(new zzddg(this, key, entry.getValue(), this.zzfpv.zzhay.zzcgz != null ? this.zzfpv.zzhay.zzcgz.getBundle(key) : null), this.zzgad)).zza(((Long) zzwg.zzpw().zzd(zzaav.zzcpo)).longValue(), TimeUnit.MILLISECONDS, this.zzfkm).zza(Throwable.class, new zzddf(key), this.zzgad));
        }
        return zzdux.zzk(arrayList).zza(new zzddi(arrayList), this.zzgad);
    }
}
