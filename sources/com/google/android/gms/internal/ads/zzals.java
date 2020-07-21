package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzals<I, O> implements zzalj<I, O> {
    private final zzakh zzdhk;
    /* access modifiers changed from: private */
    public final zzall<O> zzdhl;
    private final zzalk<I> zzdhm;
    private final String zzdhn;

    zzals(zzakh zzakh, String str, zzalk<I> zzalk, zzall<O> zzall) {
        this.zzdhk = zzakh;
        this.zzdhn = str;
        this.zzdhm = zzalk;
        this.zzdhl = zzall;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzdvf<O> zzi(I i) {
        zzbbn zzbbn = new zzbbn();
        zzaku zzb = this.zzdhk.zzb((zzeg) null);
        zzb.zza(new zzalv(this, zzb, i, zzbbn), new zzalu(this, zzbbn, zzb));
        return zzbbn;
    }

    /* access modifiers changed from: private */
    public final void zza(zzaku zzaku, zzalf zzalf, I i, zzbbn<O> zzbbn) {
        try {
            zzq.zzkw();
            String zzxj = zzaye.zzxj();
            zzagm.zzddz.zza(zzxj, new zzalx(this, zzaku, zzbbn));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", zzxj);
            jSONObject.put("args", this.zzdhm.zzj(i));
            zzalf.zza(this.zzdhn, jSONObject);
        } catch (Exception e) {
            zzbbn.setException(e);
            zzaxv.zzc("Unable to invokeJavascript", e);
            zzaku.release();
        } catch (Throwable th) {
            zzaku.release();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf<O> zzf(I i) throws Exception {
        return zzi(i);
    }
}
