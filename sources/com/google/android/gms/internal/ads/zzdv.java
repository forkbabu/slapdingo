package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzdv implements zzdw {
    protected static volatile zzex zzwf;
    protected MotionEvent zzwk;
    protected LinkedList<MotionEvent> zzwl = new LinkedList<>();
    protected long zzwm = 0;
    protected long zzwn = 0;
    protected long zzwo = 0;
    protected long zzwp = 0;
    protected long zzwq = 0;
    protected long zzwr = 0;
    protected long zzws = 0;
    protected double zzwt;
    private double zzwu;
    private double zzwv;
    protected float zzww;
    protected float zzwx;
    protected float zzwy;
    protected float zzwz;
    private boolean zzxa = false;
    protected boolean zzxb = false;
    protected DisplayMetrics zzxc;

    protected zzdv(Context context) {
        try {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcqo)).booleanValue()) {
                zzcx.zzbp();
            } else {
                zzfe.zzb(zzwf);
            }
            this.zzxc = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzeu;

    /* access modifiers changed from: protected */
    public abstract zzcf.zza.C0006zza zza(Context context, zzby.zza zza);

    /* access modifiers changed from: protected */
    public abstract zzcf.zza.C0006zza zzb(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzfd zzb(MotionEvent motionEvent) throws zzeu;

    @Override // com.google.android.gms.internal.ads.zzdw
    public void zzb(View view) {
    }

    /* access modifiers changed from: protected */
    public abstract zzcf.zza.C0006zza zzc(Context context, View view, Activity activity);

    @Override // com.google.android.gms.internal.ads.zzdw
    public String zzb(Context context) {
        if (zzfg.isMainThread()) {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcqq)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return zza(context, null, zzcw.zznn, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public String zza(Context context, View view, Activity activity) {
        return zza(context, null, zzcw.zzno, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, zzcw.zznp, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.zzxa) {
            zzby();
            this.zzxa = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzwt = 0.0d;
            this.zzwu = (double) motionEvent.getRawX();
            this.zzwv = (double) motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = (double) motionEvent.getRawX();
            double rawY = (double) motionEvent.getRawY();
            double d = rawX - this.zzwu;
            double d2 = rawY - this.zzwv;
            this.zzwt += Math.sqrt((d * d) + (d2 * d2));
            this.zzwu = rawX;
            this.zzwv = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 == 0) {
            this.zzww = motionEvent.getX();
            this.zzwx = motionEvent.getY();
            this.zzwy = motionEvent.getRawX();
            this.zzwz = motionEvent.getRawY();
            this.zzwm++;
        } else if (action2 == 1) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.zzwk = obtain;
            this.zzwl.add(obtain);
            if (this.zzwl.size() > 6) {
                this.zzwl.remove().recycle();
            }
            this.zzwo++;
            this.zzwq = zza(new Throwable().getStackTrace());
        } else if (action2 == 2) {
            this.zzwn += (long) (motionEvent.getHistorySize() + 1);
            try {
                zzfd zzb = zzb(motionEvent);
                if ((zzb == null || zzb.zzzr == null || zzb.zzzu == null) ? false : true) {
                    this.zzwr += zzb.zzzr.longValue() + zzb.zzzu.longValue();
                }
                if (!(this.zzxc == null || zzb == null || zzb.zzzs == null || zzb.zzzv == null)) {
                    z = true;
                }
                if (z) {
                    this.zzws += zzb.zzzs.longValue() + zzb.zzzv.longValue();
                }
            } catch (zzeu unused) {
            }
        } else if (action2 == 3) {
            this.zzwp++;
        }
        this.zzxb = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public void zza(int i, int i2, int i3) {
        if (this.zzwk != null) {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcqb)).booleanValue()) {
                zzby();
            } else {
                this.zzwk.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzxc;
        if (displayMetrics != null) {
            this.zzwk = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * displayMetrics.density, this.zzxc.density * ((float) i2), 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzwk = null;
        }
        this.zzxb = false;
    }

    private final void zzby() {
        this.zzwq = 0;
        this.zzwm = 0;
        this.zzwn = 0;
        this.zzwo = 0;
        this.zzwp = 0;
        this.zzwr = 0;
        this.zzws = 0;
        if (this.zzwl.size() > 0) {
            Iterator<MotionEvent> it2 = this.zzwl.iterator();
            while (it2.hasNext()) {
                it2.next().recycle();
            }
            this.zzwl.clear();
        } else {
            MotionEvent motionEvent = this.zzwk;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzwk = null;
    }

    private final String zza(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        String str2;
        zzdu zzdu;
        int i2;
        int i3;
        int i4;
        int i5;
        long currentTimeMillis = System.currentTimeMillis();
        boolean booleanValue = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcqd)).booleanValue();
        zzcf.zza.C0006zza zza = null;
        if (booleanValue) {
            zzdu = zzwf != null ? zzwf.zzcm() : null;
            str2 = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcqo)).booleanValue() ? "be" : "te";
        } else {
            zzdu = null;
            str2 = null;
        }
        try {
            if (i == zzcw.zznp) {
                zza = zzb(context, view, activity);
                this.zzxa = true;
                i5 = 1002;
            } else if (i == zzcw.zzno) {
                zza = zzc(context, view, activity);
                i5 = 1008;
            } else {
                zza = zza(context, null);
                i5 = 1000;
            }
            if (booleanValue && zzdu != null) {
                zzdu.zza(i5, -1, System.currentTimeMillis() - currentTimeMillis, str2);
            }
        } catch (Exception e) {
            if (booleanValue && zzdu != null) {
                if (i == zzcw.zznp) {
                    i4 = 1003;
                } else if (i == zzcw.zzno) {
                    i4 = 1009;
                } else {
                    i4 = i == zzcw.zznn ? 1001 : -1;
                }
                zzdu.zza(i4, -1, System.currentTimeMillis() - currentTimeMillis, str2, e);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (zza != null) {
            try {
                if (((zzcf.zza) ((zzegb) zza.zzbfq())).zzbfe() != 0) {
                    String zzj = zzcx.zzj((zzcf.zza) ((zzegb) zza.zzbfq()), str);
                    if (!booleanValue || zzdu == null) {
                        return zzj;
                    }
                    if (i == zzcw.zznp) {
                        i3 = 1006;
                    } else if (i == zzcw.zzno) {
                        i3 = 1010;
                    } else {
                        i3 = i == zzcw.zznn ? 1004 : -1;
                    }
                    zzdu.zza(i3, -1, System.currentTimeMillis() - currentTimeMillis2, str2);
                    return zzj;
                }
            } catch (Exception e2) {
                String num = Integer.toString(7);
                if (!booleanValue || zzdu == null) {
                    return num;
                }
                if (i == zzcw.zznp) {
                    i2 = 1007;
                } else if (i == zzcw.zzno) {
                    i2 = 1011;
                } else {
                    i2 = i == zzcw.zznn ? 1005 : -1;
                }
                zzdu.zza(i2, -1, System.currentTimeMillis() - currentTimeMillis2, str2, e2);
                return num;
            }
        }
        return Integer.toString(5);
    }
}
