package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcwp extends zzapb {
    private final String zzder;
    private final zzaox zzgor;
    private zzbbn<JSONObject> zzgos;
    private final JSONObject zzgot;
    private boolean zzgou = false;

    public zzcwp(String str, zzaox zzaox, zzbbn<JSONObject> zzbbn) {
        JSONObject jSONObject = new JSONObject();
        this.zzgot = jSONObject;
        this.zzgos = zzbbn;
        this.zzder = str;
        this.zzgor = zzaox;
        try {
            jSONObject.put("adapter_version", zzaox.zztr().toString());
            this.zzgot.put("sdk_version", this.zzgor.zzts().toString());
            this.zzgot.put(AppMeasurementSdk.ConditionalUserProperty.NAME, this.zzder);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final synchronized void zzdr(String str) throws RemoteException {
        if (!this.zzgou) {
            if (str == null) {
                onFailure("Adapter returned null signals");
                return;
            }
            try {
                this.zzgot.put("signals", str);
            } catch (JSONException unused) {
            }
            this.zzgos.set(this.zzgot);
            this.zzgou = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final synchronized void onFailure(String str) throws RemoteException {
        if (!this.zzgou) {
            try {
                this.zzgot.put("signal_error", str);
            } catch (JSONException unused) {
            }
            this.zzgos.set(this.zzgot);
            this.zzgou = true;
        }
    }
}
