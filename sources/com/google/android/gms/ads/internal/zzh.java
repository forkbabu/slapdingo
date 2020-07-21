package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzaav;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzbaq;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbf;
import com.google.android.gms.internal.ads.zzcw;
import com.google.android.gms.internal.ads.zzdp;
import com.google.android.gms.internal.ads.zzdw;
import com.google.android.gms.internal.ads.zzed;
import com.google.android.gms.internal.ads.zzwg;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzh implements zzdw, Runnable {
    private final List<Object[]> zzbos = new Vector();
    private final AtomicReference<zzdw> zzbot = new AtomicReference<>();
    private final AtomicReference<zzdw> zzbou = new AtomicReference<>();
    private zzbbd zzbov;
    private CountDownLatch zzbow = new CountDownLatch(1);
    private Context zzvr;
    private final int zzxn;

    public zzh(Context context, zzbbd zzbbd) {
        this.zzvr = context;
        this.zzbov = zzbbd;
        int intValue = ((Integer) zzwg.zzpw().zzd(zzaav.zzcqa)).intValue();
        if (intValue == 1) {
            this.zzxn = zzcw.zznk;
        } else if (intValue != 2) {
            this.zzxn = zzcw.zznj;
        } else {
            this.zzxn = zzcw.zznl;
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcqr)).booleanValue()) {
            zzbbf.zzedh.execute(this);
            return;
        }
        zzwg.zzps();
        if (zzbaq.zzyi()) {
            zzbbf.zzedh.execute(this);
        } else {
            run();
        }
    }

    private final boolean zzkb() {
        try {
            this.zzbow.await();
            return true;
        } catch (InterruptedException e) {
            zzaxv.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void zzkc() {
        zzdw zzcb = zzcb();
        if (!this.zzbos.isEmpty() && zzcb != null) {
            for (Object[] objArr : this.zzbos) {
                if (objArr.length == 1) {
                    zzcb.zza((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    zzcb.zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzbos.clear();
        }
    }

    private static Context zze(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zzb(Context context) {
        zzdw zzdw;
        if (!zzkb()) {
            return "";
        }
        if (this.zzxn == zzcw.zznk || this.zzxn == zzcw.zznl) {
            zzdw = this.zzbou.get();
        } else {
            zzdw = this.zzbot.get();
        }
        if (zzdw == null) {
            return "";
        }
        zzkc();
        return zzdw.zzb(zze(context));
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, View view, Activity activity) {
        zzdw zzcb = zzcb();
        return zzcb != null ? zzcb.zza(context, view, activity) : "";
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view, Activity activity) {
        zzdw zzcb;
        if (!zzkb() || (zzcb = zzcb()) == null) {
            return "";
        }
        zzkc();
        return zzcb.zza(zze(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zzb(View view) {
        zzdw zzcb = zzcb();
        if (zzcb != null) {
            zzcb.zzb(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zza(MotionEvent motionEvent) {
        zzdw zzcb = zzcb();
        if (zzcb != null) {
            zzkc();
            zzcb.zza(motionEvent);
            return;
        }
        this.zzbos.add(new Object[]{motionEvent});
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zza(int i, int i2, int i3) {
        zzdw zzcb = zzcb();
        if (zzcb != null) {
            zzkc();
            zzcb.zza(i, i2, i3);
            return;
        }
        this.zzbos.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.zzbov.zzedf;
            if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcog)).booleanValue() && z2) {
                z = true;
            }
            if (this.zzxn != zzcw.zznk) {
                this.zzbot.set(zzed.zzb(this.zzbov.zzbpn, zze(this.zzvr), z, this.zzxn));
            }
            if (this.zzxn != zzcw.zznj) {
                this.zzbou.set(zzdp.zza(this.zzbov.zzbpn, zze(this.zzvr), z));
            }
        } finally {
            this.zzbow.countDown();
            this.zzvr = null;
            this.zzbov = null;
        }
    }

    private final zzdw zzcb() {
        if (this.zzxn == zzcw.zznk) {
            return this.zzbou.get();
        }
        return this.zzbot.get();
    }
}
