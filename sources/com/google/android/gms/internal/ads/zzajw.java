package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzajw implements zzajp, zzaju {
    /* access modifiers changed from: private */
    public final zzbfn zzdfp;
    private final Context zzvr;

    public zzajw(Context context, zzbbd zzbbd, zzeg zzeg, zza zza) throws zzbfz {
        this.zzvr = context;
        zzq.zzkx();
        zzbfn zza2 = zzbfv.zza(context, zzbhg.zzacp(), "", false, false, zzeg, zzbbd, null, null, null, zztm.zzmz(), null, false);
        this.zzdfp = zza2;
        zza2.getView().setWillNotDraw(true);
    }

    @Override // com.google.android.gms.internal.ads.zzajh
    public final void zza(String str, Map map) {
        zzajo.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzake
    public final void zza(String str, JSONObject jSONObject) {
        zzajo.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajh, com.google.android.gms.internal.ads.zzajp
    public final void zzb(String str, JSONObject jSONObject) {
        zzajo.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajp
    public final void zzj(String str, String str2) {
        zzajo.zza(this, str, str2);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzwg.zzps();
        if (zzbaq.zzyi()) {
            runnable.run();
        } else {
            zzaye.zzdzw.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajp, com.google.android.gms.internal.ads.zzake
    public final void zzdb(String str) {
        runOnUiThread(new zzajz(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final void zzcy(String str) {
        runOnUiThread(new zzaka(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)));
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final void zzcz(String str) {
        runOnUiThread(new zzakd(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final void zzda(String str) {
        runOnUiThread(new zzakc(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zza(String str, zzahc<? super zzalf> zzahc) {
        this.zzdfp.zza(str, new zzakf(this, zzahc));
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zzb(String str, zzahc<? super zzalf> zzahc) {
        this.zzdfp.zza(str, new zzajy(zzahc));
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final void zza(zzajx zzajx) {
        zzbgz zzaaz = this.zzdfp.zzaaz();
        zzajx.getClass();
        zzaaz.zza(zzakb.zzb(zzajx));
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final zzale zzsy() {
        return new zzalh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final void destroy() {
        this.zzdfp.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final boolean isDestroyed() {
        return this.zzdfp.isDestroyed();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdg(String str) {
        this.zzdfp.zzdb(str);
    }
}
