package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzatb implements zzasq {
    private zzalj<JSONObject, JSONObject> zzduj;
    private zzalj<JSONObject, JSONObject> zzduk;

    public zzatb(Context context) {
        this.zzduk = zzq.zzlj().zza(context, zzbbd.zzym()).zza("google.afma.request.getAdDictionary", zzalm.zzdhf, zzalm.zzdhf);
        this.zzduj = zzq.zzlj().zza(context, zzbbd.zzym()).zza("google.afma.sdkConstants.getSdkConstants", zzalm.zzdhf, zzalm.zzdhf);
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final zzalj<JSONObject, JSONObject> zzuy() {
        return this.zzduj;
    }
}
