package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzbtt;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcve<AdT, AdapterT, ListenerT extends zzbtt> implements zzcqt<AdT> {
    private final zzcqu<AdapterT, ListenerT> zzfjs;
    private final zzdou zzfpw;
    private final zzcqw<AdT, AdapterT, ListenerT> zzgnm;
    private final zzdvi zzgnn;

    public zzcve(zzdou zzdou, zzdvi zzdvi, zzcqu<AdapterT, ListenerT> zzcqu, zzcqw<AdT, AdapterT, ListenerT> zzcqw) {
        this.zzfpw = zzdou;
        this.zzgnn = zzdvi;
        this.zzgnm = zzcqw;
        this.zzfjs = zzcqu;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final boolean zza(zzdkw zzdkw, zzdkk zzdkk) {
        return !zzdkk.zzgzs.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final zzdvf<AdT> zzb(zzdkw zzdkw, zzdkk zzdkk) {
        zzcqv<AdapterT, ListenerT> zzcqv;
        Iterator<String> it2 = zzdkk.zzgzs.iterator();
        while (true) {
            if (!it2.hasNext()) {
                zzcqv = null;
                break;
            }
            try {
                zzcqv = this.zzfjs.zzf(it2.next(), zzdkk.zzgzu);
                break;
            } catch (zzdlg unused) {
            }
        }
        if (zzcqv == null) {
            return zzdux.immediateFailedFuture(new zzcti("unable to instantiate mediation adapter class"));
        }
        zzbbn zzbbn = new zzbbn();
        zzcqv.zzgki.zza(new zzcvj(this, zzbbn));
        if (zzdkk.zzdub) {
            Bundle bundle = zzdkw.zzhat.zzfpv.zzhay.zzcgz;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.zzfpw.zzu(zzdor.ADAPTER_LOAD_AD_SYN).zza(new zzcvh(this, zzdkw, zzdkk, zzcqv), this.zzgnn).zzw(zzdor.ADAPTER_LOAD_AD_ACK).zze(zzbbn).zzw(zzdor.ADAPTER_WRAP_ADAPTER).zzb(new zzcvg(this, zzdkw, zzdkk, zzcqv)).zzaus();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(zzdkw zzdkw, zzdkk zzdkk, zzcqv zzcqv, Void voidR) throws Exception {
        return this.zzgnm.zzb(zzdkw, zzdkk, zzcqv);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzdkw zzdkw, zzdkk zzdkk, zzcqv zzcqv) throws Exception {
        this.zzgnm.zza(zzdkw, zzdkk, zzcqv);
    }
}
