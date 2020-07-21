package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdao implements zzdec<zzdal> {
    private final zzdvi zzgad;
    private final Context zzvr;

    public zzdao(zzdvi zzdvi, Context context) {
        this.zzgad = zzdvi;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdal> zzaqm() {
        return this.zzgad.zze(new zzdan(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdal zzaqq() throws Exception {
        AudioManager audioManager = (AudioManager) this.zzvr.getSystemService("audio");
        return new zzdal(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzq.zzlb().zzqc(), zzq.zzlb().zzqd());
    }
}
