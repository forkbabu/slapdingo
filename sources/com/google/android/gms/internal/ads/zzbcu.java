package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbcu {
    private final Context zzclc;
    private final zzbdb zzeez;
    private final ViewGroup zzefu;
    private zzbco zzefv;

    public zzbcu(Context context, ViewGroup viewGroup, zzbfn zzbfn) {
        this(context, viewGroup, zzbfn, null);
    }

    private zzbcu(Context context, ViewGroup viewGroup, zzbdb zzbdb, zzbco zzbco) {
        this.zzclc = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzefu = viewGroup;
        this.zzeez = zzbdb;
        this.zzefv = null;
    }

    public final void zze(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzbco zzbco = this.zzefv;
        if (zzbco != null) {
            zzbco.zzd(i, i2, i3, i4);
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzbdc zzbdc) {
        if (this.zzefv == null) {
            zzabd.zza(this.zzeez.zzzn().zzrp(), this.zzeez.zzzk(), "vpr2");
            Context context = this.zzclc;
            zzbdb zzbdb = this.zzeez;
            zzbco zzbco = new zzbco(context, zzbdb, i5, z, zzbdb.zzzn().zzrp(), zzbdc);
            this.zzefv = zzbco;
            this.zzefu.addView(zzbco, 0, new ViewGroup.LayoutParams(-1, -1));
            this.zzefv.zzd(i, i2, i3, i4);
            this.zzeez.zzav(false);
        }
    }

    public final zzbco zzze() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzefv;
    }

    public final void onPause() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzbco zzbco = this.zzefv;
        if (zzbco != null) {
            zzbco.pause();
        }
    }

    public final void onDestroy() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzbco zzbco = this.zzefv;
        if (zzbco != null) {
            zzbco.destroy();
            this.zzefu.removeView(this.zzefv);
            this.zzefv = null;
        }
    }
}
