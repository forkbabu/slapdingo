package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzajg extends zzajt<zzalf> implements zzajp, zzaju {
    private final zzbhu zzdfd;
    /* access modifiers changed from: private */
    public zzajx zzdfe;

    public zzajg(Context context, zzbbd zzbbd) throws zzbfz {
        try {
            zzbhu zzbhu = new zzbhu(context, new zzajm(this));
            this.zzdfd = zzbhu;
            zzbhu.setWillNotDraw(true);
            this.zzdfd.addJavascriptInterface(new zzajn(this), "GoogleJsInterface");
            zzq.zzkw().zza(context, zzbbd.zzbpn, this.zzdfd.getSettings());
            super.zzg(this);
        } catch (Throwable th) {
            throw new zzbfz("Init failed.", th);
        }
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

    @Override // com.google.android.gms.internal.ads.zzaju
    public final void zzcy(String str) {
        zzcz(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", str));
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final void zzcz(String str) {
        zzbbf.zzedl.execute(new zzajj(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final void zzda(String str) {
        zzbbf.zzedl.execute(new zzaji(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final void zza(zzajx zzajx) {
        this.zzdfe = zzajx;
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final void destroy() {
        this.zzdfd.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final boolean isDestroyed() {
        return this.zzdfd.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final zzale zzsy() {
        return new zzalh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzajp, com.google.android.gms.internal.ads.zzake
    public final void zzdb(String str) {
        zzbbf.zzedl.execute(new zzajl(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdc(String str) {
        this.zzdfd.zzdb(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdd(String str) {
        this.zzdfd.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzde(String str) {
        this.zzdfd.loadData(str, "text/html", XmpWriter.UTF8);
    }
}
