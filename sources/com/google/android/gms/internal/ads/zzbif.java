package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzbie;
import com.google.android.gms.internal.ads.zzbkb;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzbif implements zzblb {
    private static zzbif zzeqx;

    /* access modifiers changed from: protected */
    public abstract zzdeu zza(zzdgd zzdgd);

    public abstract Executor zzade();

    public abstract ScheduledExecutorService zzadf();

    public abstract Executor zzadg();

    public abstract zzdvi zzadh();

    public abstract zzbus zzadi();

    public abstract zzcix zzadj();

    public abstract zzbkg zzadk();

    public abstract zzbob zzadl();

    public abstract zzbmt zzadm();

    public abstract zzdhf zzadn();

    public abstract zzcah zzado();

    public abstract zzcbf zzadp();

    public abstract zzchp zzadq();

    public abstract zzdkb zzadr();

    public abstract zzcxw zzads();

    public abstract zzcxz zzadt();

    public abstract zzdll<zzcgr> zzadu();

    public static zzbif zza(Context context, zzamr zzamr, int i) {
        zzbif zzf = zzf(context, i);
        zzf.zzadj().zzb(zzamr);
        return zzf;
    }

    @Deprecated
    public static zzbif zzf(Context context, int i) {
        synchronized (zzbif.class) {
            if (zzeqx == null) {
                return zza(new zzbbd(201604000, i, true, false), context, new zzbja());
            }
            zzbif zzbif = zzeqx;
            return zzbif;
        }
    }

    @Deprecated
    private static zzbif zza(zzbbd zzbbd, Context context, zzbkb.zza zza) {
        zzbif zzbif;
        synchronized (zzbif.class) {
            if (zzeqx == null) {
                zzeqx = new zzbjp().zzc(new zzbie(new zzbie.zza().zza(zzbbd).zzbx(context))).zza(new zzbkb(zza)).zzafs();
                zzaav.initialize(context);
                zzq.zzla().zzd(context, zzbbd);
                zzq.zzlc().initialize(context);
                zzq.zzkw().zzap(context);
                zzq.zzkw().zzaq(context);
                zzaxt.zzao(context);
                zzq.zzkz().initialize(context);
                zzq.zzlr().initialize(context);
                if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcvp)).booleanValue()) {
                    new zzcqp(context, zzbbd, new zztm(new zztr(context)), new zzcpz(new zzcpx(context), zzeqx.zzadh())).zzapn();
                }
            }
            zzbif = zzeqx;
        }
        return zzbif;
    }

    @Override // com.google.android.gms.internal.ads.zzblb
    public final zzdeu zza(zzasm zzasm, int i) {
        return zza(new zzdgd(zzasm, i));
    }
}
