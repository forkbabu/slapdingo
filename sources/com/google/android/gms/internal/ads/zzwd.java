package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
abstract class zzwd<T> {
    private static final zzxf zzcij = zzpp();

    zzwd() {
    }

    /* access modifiers changed from: protected */
    public abstract T zza(zzxf zzxf) throws RemoteException;

    /* access modifiers changed from: protected */
    public abstract T zzpm();

    /* access modifiers changed from: protected */
    public abstract T zzpn() throws RemoteException;

    private static zzxf zzpp() {
        try {
            Object newInstance = zzvp.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzbba.zzfd("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            if (queryLocalInterface instanceof zzxf) {
                return (zzxf) queryLocalInterface;
            }
            return new zzxh(iBinder);
        } catch (Exception unused) {
            zzbba.zzfd("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    private final T zzpq() {
        zzxf zzxf = zzcij;
        if (zzxf == null) {
            zzbba.zzfd("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zza(zzxf);
        } catch (RemoteException e) {
            zzbba.zzd("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    private final T zzpr() {
        try {
            return zzpn();
        } catch (RemoteException e) {
            zzbba.zzd("Cannot invoke remote loader.", e);
            return null;
        }
    }

    public final T zzd(Context context, boolean z) {
        T t;
        boolean z2 = false;
        boolean z3 = z;
        if (!z3) {
            zzwg.zzps();
            if (!zzbaq.zzd(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzbba.zzee("Google Play Services is not available.");
                z3 = true;
            }
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID)) {
            z3 = true;
        }
        zzaav.initialize(context);
        if (zzach.zzczs.get().booleanValue()) {
            z3 = false;
        }
        if (z3) {
            t = zzpq();
            if (t == null) {
                t = zzpr();
            }
        } else {
            T zzpr = zzpr();
            int i = zzpr == null ? 1 : 0;
            if (i != 0) {
                if (zzwg.zzpz().nextInt(zzacq.zzdau.get().intValue()) == 0) {
                    z2 = true;
                }
                if (z2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", i);
                    zzwg.zzps().zza(context, zzwg.zzpy().zzbpn, "gmob-apps", bundle, true);
                }
            }
            t = zzpr == null ? zzpq() : zzpr;
        }
        return t == null ? zzpm() : t;
    }
}
