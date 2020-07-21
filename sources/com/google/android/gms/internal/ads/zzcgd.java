package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcgd extends zzait implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzadc {
    private boolean zzenl = false;
    private zzyi zzfwt;
    private View zzfwy;
    private zzccd zzfya;
    private boolean zzgbj = false;

    public zzcgd(zzccd zzccd, zzcck zzcck) {
        this.zzfwy = zzcck.zzalk();
        this.zzfwt = zzcck.getVideoController();
        this.zzfya = zzccd;
        if (zzcck.zzall() != null) {
            zzcck.zzall().zza(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final void zza(IObjectWrapper iObjectWrapper, zzaiv zzaiv) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzenl) {
            zzaxv.zzfb("Instream ad can not be shown after destroy().");
            zza(zzaiv, 2);
        } else if (this.zzfwy == null || this.zzfwt == null) {
            String str = this.zzfwy == null ? "can not get video view." : "can not get video controller.";
            zzaxv.zzfb(str.length() != 0 ? "Instream internal error: ".concat(str) : new String("Instream internal error: "));
            zza(zzaiv, 0);
        } else if (this.zzgbj) {
            zzaxv.zzfb("Instream ad should not be used again.");
            zza(zzaiv, 1);
        } else {
            this.zzgbj = true;
            zzamv();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zzfwy, new ViewGroup.LayoutParams(-1, -1));
            zzq.zzlt();
            zzbbv.zza(this.zzfwy, (ViewTreeObserver.OnGlobalLayoutListener) this);
            zzq.zzlt();
            zzbbv.zza(this.zzfwy, (ViewTreeObserver.OnScrollChangedListener) this);
            zzamw();
            try {
                zzaiv.zzst();
            } catch (RemoteException e) {
                zzaxv.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zza(iObjectWrapper, new zzcgf(this));
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final zzyi getVideoController() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzenl) {
            return this.zzfwt;
        }
        zzaxv.zzfb("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final zzado zzsn() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzenl) {
            zzaxv.zzfb("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzccd zzccd = this.zzfya;
        if (zzccd == null || zzccd.zzald() == null) {
            return null;
        }
        return this.zzfya.zzald().zzsn();
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzamv();
        zzccd zzccd = this.zzfya;
        if (zzccd != null) {
            zzccd.destroy();
        }
        this.zzfya = null;
        this.zzfwy = null;
        this.zzfwt = null;
        this.zzenl = true;
    }

    private final void zzamv() {
        View view = this.zzfwy;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zzfwy);
            }
        }
    }

    public final void onGlobalLayout() {
        zzamw();
    }

    public final void onScrollChanged() {
        zzamw();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzrx() {
        zzaye.zzdzw.post(new zzcgc(this));
    }

    private final void zzamw() {
        View view;
        zzccd zzccd = this.zzfya;
        if (zzccd != null && (view = this.zzfwy) != null) {
            zzccd.zzb(view, Collections.emptyMap(), Collections.emptyMap(), zzccd.zzz(this.zzfwy));
        }
    }

    private static void zza(zzaiv zzaiv, int i) {
        try {
            zzaiv.zzdb(i);
        } catch (RemoteException e) {
            zzaxv.zze("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzamx() {
        try {
            destroy();
        } catch (RemoteException e) {
            zzaxv.zze("#007 Could not call remote method.", e);
        }
    }
}
