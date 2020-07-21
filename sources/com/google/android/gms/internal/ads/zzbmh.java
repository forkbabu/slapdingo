package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbmh implements zzqs {
    private final Clock zzbqd;
    private boolean zzbvq = false;
    private zzbfn zzdfp;
    private final zzbls zzflm;
    private final Executor zzflp;
    private zzblw zzflr = new zzblw();
    private boolean zzfmn = false;

    public zzbmh(Executor executor, zzbls zzbls, Clock clock) {
        this.zzflp = executor;
        this.zzflm = zzbls;
        this.zzbqd = clock;
    }

    private final void zzagw() {
        try {
            JSONObject zza = this.zzflm.zzj(this.zzflr);
            if (this.zzdfp != null) {
                this.zzflp.execute(new zzbmg(this, zza));
            }
        } catch (JSONException e) {
            zzaxv.zza("Failed to call video active view js", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqs
    public final void zza(zzqt zzqt) {
        this.zzflr.zzbrd = this.zzfmn ? false : zzqt.zzbrd;
        this.zzflr.timestamp = this.zzbqd.elapsedRealtime();
        this.zzflr.zzfly = zzqt;
        if (this.zzbvq) {
            zzagw();
        }
    }

    public final void zzg(zzbfn zzbfn) {
        this.zzdfp = zzbfn;
    }

    public final void disable() {
        this.zzbvq = false;
    }

    public final void enable() {
        this.zzbvq = true;
        zzagw();
    }

    public final void zzbf(boolean z) {
        this.zzfmn = z;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(JSONObject jSONObject) {
        this.zzdfp.zza("AFMA_updateActiveView", jSONObject);
    }
}
