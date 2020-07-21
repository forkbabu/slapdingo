package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcix {
    private final zzcis zzgdc;
    private final AtomicReference<zzamr> zzgdd = new AtomicReference<>();

    zzcix(zzcis zzcis) {
        this.zzgdc = zzcis;
    }

    public final void zzb(zzamr zzamr) {
        this.zzgdd.compareAndSet(null, zzamr);
    }

    public final zzdlm zzd(String str, JSONObject jSONObject) throws zzdlg {
        zzams zzams;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzams = new zzann(new AdMobAdapter());
            } else if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                zzams = new zzann(new AdUrlAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzams = new zzann(new zzapn());
            } else {
                zzams = zze(str, jSONObject);
            }
            zzdlm zzdlm = new zzdlm(zzams);
            this.zzgdc.zza(str, zzdlm);
            return zzdlm;
        } catch (Throwable th) {
            throw new zzdlg(th);
        }
    }

    public final zzaox zzdl(String str) throws RemoteException {
        zzaox zzdl = zzanm().zzdl(str);
        this.zzgdc.zza(str, zzdl);
        return zzdl;
    }

    public final boolean zzanl() {
        return this.zzgdd.get() != null;
    }

    private final zzams zze(String str, JSONObject jSONObject) throws RemoteException {
        zzamr zzanm = zzanm();
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                if (zzanm.zzdi(jSONObject.getString("class_name"))) {
                    return zzanm.zzdh("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                }
                return zzanm.zzdh("com.google.ads.mediation.customevent.CustomEventAdapter");
            } catch (JSONException e) {
                zzaxv.zzc("Invalid custom event.", e);
            }
        }
        return zzanm.zzdh(str);
    }

    private final zzamr zzanm() throws RemoteException {
        zzamr zzamr = this.zzgdd.get();
        if (zzamr != null) {
            return zzamr;
        }
        zzaxv.zzfd("Unexpected call to adapter creator.");
        throw new RemoteException();
    }
}
