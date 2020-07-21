package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzalx implements zzahk {
    private final /* synthetic */ zzals zzdhq;
    private final zzaku zzdht;
    private final zzbbn<O> zzdhu;

    public zzalx(zzals zzals, zzaku zzaku, zzbbn<O> zzbbn) {
        this.zzdhq = zzals;
        this.zzdht = zzaku;
        this.zzdhu = zzbbn;
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzdhu.set(this.zzdhq.zzdhl.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzdhu.setException(e);
        } finally {
            this.zzdht.release();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void onFailure(String str) {
        if (str == null) {
            try {
                this.zzdhu.setException(new zzalg());
            } catch (IllegalStateException unused) {
                this.zzdht.release();
                return;
            } catch (Throwable th) {
                this.zzdht.release();
                throw th;
            }
        } else {
            this.zzdhu.setException(new zzalg(str));
        }
        this.zzdht.release();
    }
}
