package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzazw extends zzaa<zzy> {
    private final Map<String, String> zzam;
    private final zzbbn<zzy> zzebq;
    private final zzbau zzebr;

    public zzazw(String str, zzbbn<zzy> zzbbn) {
        this(str, null, zzbbn);
    }

    private zzazw(String str, Map<String, String> map, zzbbn<zzy> zzbbn) {
        super(0, str, new zzazv(zzbbn));
        this.zzam = null;
        this.zzebq = zzbbn;
        zzbau zzbau = new zzbau();
        this.zzebr = zzbau;
        zzbau.zza(str, "GET", null, null);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaa
    public final zzaj<zzy> zza(zzy zzy) {
        return zzaj.zza(zzy, zzbc.zzb(zzy));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaa
    public final /* synthetic */ void zza(zzy zzy) {
        zzy zzy2 = zzy;
        this.zzebr.zza(zzy2.zzam, zzy2.statusCode);
        zzbau zzbau = this.zzebr;
        byte[] bArr = zzy2.data;
        if (zzbau.isEnabled() && bArr != null) {
            zzbau.zzi(bArr);
        }
        this.zzebq.set(zzy2);
    }
}
