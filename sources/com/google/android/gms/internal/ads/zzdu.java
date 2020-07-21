package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import com.google.android.gms.internal.ads.zzbw;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzdu {
    /* access modifiers changed from: private */
    public static final ConditionVariable zzwg = new ConditionVariable();
    protected static volatile zztr zzwh = null;
    private static volatile Random zzwj = null;
    /* access modifiers changed from: private */
    public zzex zzwf;
    protected volatile Boolean zzwi;

    public zzdu(zzex zzex) {
        this.zzwf = zzex;
        zzex.zzch().execute(new zzdt(this));
    }

    public final void zza(int i, int i2, long j) {
        zza(i, i2, j, null, null);
    }

    public final void zza(int i, int i2, long j, String str) {
        zza(i, -1, j, str, null);
    }

    public final void zza(int i, int i2, long j, String str, Exception exc) {
        try {
            zzwg.block();
            if (this.zzwi.booleanValue() && zzwh != null) {
                zzbw.zza.C0003zza zzc = zzbw.zza.zzt().zzj(this.zzwf.zzvr.getPackageName()).zzc(j);
                if (str != null) {
                    zzc.zzm(str);
                }
                if (exc != null) {
                    StringWriter stringWriter = new StringWriter();
                    zzeea.zza(exc, new PrintWriter(stringWriter));
                    zzc.zzk(stringWriter.toString()).zzl(exc.getClass().getName());
                }
                zztv zzf = zzwh.zzf(((zzbw.zza) ((zzegb) zzc.zzbfq())).toByteArray());
                zzf.zzbx(i);
                if (i2 != -1) {
                    zzf.zzbw(i2);
                }
                zzf.zzdx();
            }
        } catch (Exception unused) {
        }
    }

    public static int zzbv() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            return zzbw().nextInt();
        } catch (RuntimeException unused) {
            return zzbw().nextInt();
        }
    }

    private static Random zzbw() {
        if (zzwj == null) {
            synchronized (zzdu.class) {
                if (zzwj == null) {
                    zzwj = new Random();
                }
            }
        }
        return zzwj;
    }
}
