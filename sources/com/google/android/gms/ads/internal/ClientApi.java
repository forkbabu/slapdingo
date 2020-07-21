package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzaea;
import com.google.android.gms.internal.ads.zzamr;
import com.google.android.gms.internal.ads.zzaqi;
import com.google.android.gms.internal.ads.zzaqt;
import com.google.android.gms.internal.ads.zzatj;
import com.google.android.gms.internal.ads.zzaui;
import com.google.android.gms.internal.ads.zzawr;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbif;
import com.google.android.gms.internal.ads.zzcde;
import com.google.android.gms.internal.ads.zzcdf;
import com.google.android.gms.internal.ads.zzcwq;
import com.google.android.gms.internal.ads.zzcws;
import com.google.android.gms.internal.ads.zzcxd;
import com.google.android.gms.internal.ads.zzvh;
import com.google.android.gms.internal.ads.zzwp;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzxi;
import com.google.android.gms.internal.ads.zzxm;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class ClientApi extends zzxi {
    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzxm zzc(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzaqt zzd(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzww zza(IObjectWrapper iObjectWrapper, zzvh zzvh, String str, zzamr zzamr, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcws(zzbif.zza(context, zzamr, i), context, zzvh, str);
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzww zzb(IObjectWrapper iObjectWrapper, zzvh zzvh, String str, zzamr zzamr, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcxd(zzbif.zza(context, zzamr, i), context, zzvh, str);
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzwp zza(IObjectWrapper iObjectWrapper, String str, zzamr zzamr, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcwq(zzbif.zza(context, zzamr, i), context, str);
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzadx zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzcde((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 201604000);
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzatj zza(IObjectWrapper iObjectWrapper, zzamr zzamr, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbif.zza(context, zzamr, i).zzadr().zzbz(context).zzafv().zzaga();
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzaqi zzb(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zzc = AdOverlayInfoParcel.zzc(activity.getIntent());
        if (zzc == null) {
            return new zzr(activity);
        }
        int i = zzc.zzdoj;
        if (i == 1) {
            return new zzs(activity);
        }
        if (i == 2) {
            return new zzx(activity);
        }
        if (i == 3) {
            return new zzz(activity);
        }
        if (i != 4) {
            return new zzr(activity);
        }
        return new zzu(activity, zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzxm zza(IObjectWrapper iObjectWrapper, int i) {
        return zzbif.zzf((Context) ObjectWrapper.unwrap(iObjectWrapper), i).zzadk();
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzww zza(IObjectWrapper iObjectWrapper, zzvh zzvh, String str, int i) {
        return new zzl((Context) ObjectWrapper.unwrap(iObjectWrapper), zzvh, str, new zzbbd(201604000, i, true, false));
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzaea zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzcdf((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzaui zzb(IObjectWrapper iObjectWrapper, String str, zzamr zzamr, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbif.zza(context, zzamr, i).zzadr().zzbz(context).zzfv(str).zzafv().zzagb();
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzww zzc(IObjectWrapper iObjectWrapper, zzvh zzvh, String str, zzamr zzamr, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbif.zza(context, zzamr, i).zzadn().zzfu(str).zzby(context).zzafh().zzafl();
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzawr zzb(IObjectWrapper iObjectWrapper, zzamr zzamr, int i) {
        return zzbif.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzamr, i).zzadt();
    }
}
