package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzagb extends zzaey {
    private final /* synthetic */ zzafz zzdcz;

    private zzagb(zzafz zzafz) {
        this.zzdcz = zzafz;
    }

    @Override // com.google.android.gms.internal.ads.zzaez
    public final void zza(zzaep zzaep, String str) {
        if (this.zzdcz.zzdcx != null) {
            this.zzdcz.zzdcx.onCustomClick(this.zzdcz.zzb(zzaep), str);
        }
    }
}
