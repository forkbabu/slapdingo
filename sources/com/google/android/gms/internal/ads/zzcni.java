package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcni extends zzcng {
    /* access modifiers changed from: private */
    public static final Pattern zzggy = Pattern.compile("Received error HTTP response code: (.*)");
    private final ScheduledExecutorService zzfkm;
    private final zzdla zzfpv;
    private final zzdvi zzgad;
    private final zzcml zzggw;
    /* access modifiers changed from: private */
    public final zzcqf zzggx;

    zzcni(zzbuv zzbuv, zzdla zzdla, zzcml zzcml, zzdvi zzdvi, ScheduledExecutorService scheduledExecutorService, zzcqf zzcqf) {
        super(zzbuv);
        this.zzfpv = zzdla;
        this.zzggw = zzcml;
        this.zzgad = zzdvi;
        this.zzfkm = scheduledExecutorService;
        this.zzggx = zzcqf;
    }

    @Override // com.google.android.gms.internal.ads.zzcng
    public final zzdvf<zzdkw> zzb(zzasm zzasm) throws zzcmi {
        zzdvf<zzdkw> zzb = zzdux.zzb(this.zzggw.zze(zzasm), new zzcnl(this), this.zzgad);
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcuf)).booleanValue()) {
            zzb = zzdux.zzb(zzdux.zza(zzb, (long) ((Integer) zzwg.zzpw().zzd(zzaav.zzcug)).intValue(), TimeUnit.SECONDS, this.zzfkm), TimeoutException.class, zzcnk.zzboi, zzbbf.zzedm);
        }
        zzdux.zza(zzb, new zzcnn(this), zzbbf.zzedm);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzd(InputStream inputStream) throws Exception {
        return zzdux.zzaf(new zzdkw(new zzdkr(this.zzfpv), zzdku.zza(new InputStreamReader(inputStream))));
    }
}
