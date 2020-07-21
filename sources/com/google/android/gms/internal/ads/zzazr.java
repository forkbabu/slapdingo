package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzazr extends zzbh {
    private final /* synthetic */ byte[] zzebk;
    private final /* synthetic */ Map zzebl;
    private final /* synthetic */ zzbau zzebm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzazr(zzazq zzazq, int i, String str, zzal zzal, zzai zzai, byte[] bArr, Map map, zzbau zzbau) {
        super(i, str, zzal, zzai);
        this.zzebk = bArr;
        this.zzebl = map;
        this.zzebm = zzbau;
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final byte[] zzg() throws zzl {
        byte[] bArr = this.zzebk;
        return bArr == null ? super.zzg() : bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final Map<String, String> getHeaders() throws zzl {
        Map<String, String> map = this.zzebl;
        return map == null ? super.getHeaders() : map;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzi(String str) {
        this.zzebm.zzey(str);
        super.zza(str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaa, com.google.android.gms.internal.ads.zzbh
    public final /* synthetic */ void zza(String str) {
        zza(str);
    }
}
