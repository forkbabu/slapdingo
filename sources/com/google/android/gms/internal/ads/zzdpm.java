package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbw;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdpm {
    private static volatile zzbw.zza.zzc zzhhq = zzbw.zza.zzc.UNKNOWN;
    private final Executor executor;
    private final Task<zztr> zzhhp;
    private final Context zzvr;

    static void zzb(zzbw.zza.zzc zzc) {
        zzhhq = zzc;
    }

    public static zzdpm zza(Context context, Executor executor2) {
        return new zzdpm(context, executor2, Tasks.call(executor2, new zzdpl(context)));
    }

    private zzdpm(Context context, Executor executor2, Task<zztr> task) {
        this.zzvr = context;
        this.executor = executor2;
        this.zzhhp = task;
    }

    public final Task<Boolean> zzg(int i, long j) {
        return zza(i, j, null, null, null, null);
    }

    public final Task<Boolean> zza(int i, long j, Exception exc) {
        return zza(i, j, exc, null, null, null);
    }

    public final Task<Boolean> zza(int i, long j, String str, Map<String, String> map) {
        return zza(i, j, null, str, null, null);
    }

    public final Task<Boolean> zzi(int i, String str) {
        return zza(4007, 0, null, null, null, str);
    }

    private final Task<Boolean> zza(int i, long j, Exception exc, String str, Map<String, String> map, String str2) {
        zzbw.zza.C0003zza zzc = zzbw.zza.zzt().zzj(this.zzvr.getPackageName()).zzc(j);
        zzc.zza(zzhhq);
        if (exc != null) {
            zzc.zzk(zzdsk.zza(exc)).zzl(exc.getClass().getName());
        }
        if (str2 != null) {
            zzc.zzm(str2);
        }
        if (str != null) {
            zzc.zzn(str);
        }
        return this.zzhhp.continueWith(this.executor, new zzdpo(zzc, i));
    }

    static final /* synthetic */ Boolean zza(zzbw.zza.C0003zza zza, int i, Task task) throws Exception {
        if (!task.isSuccessful()) {
            return false;
        }
        zztv zzf = ((zztr) task.getResult()).zzf(((zzbw.zza) ((zzegb) zza.zzbfq())).toByteArray());
        zzf.zzbx(i);
        zzf.zzdx();
        return true;
    }

    static final /* synthetic */ zztr zzcj(Context context) throws Exception {
        return new zztr(context, "GLAS", null);
    }
}
