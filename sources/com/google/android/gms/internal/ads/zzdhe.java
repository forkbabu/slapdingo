package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdhe implements zzcxp<zzbmw> {
    private final /* synthetic */ zzdha zzgwv;

    zzdhe(zzdha zzdha) {
        this.zzgwv = zzdha;
    }

    @Override // com.google.android.gms.internal.ads.zzcxp
    public final void zzapy() {
        this.zzgwv.zzgwr = null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x004f, code lost:
        if (r3.zzgwv.zzbov.zzede < ((java.lang.Integer) com.google.android.gms.internal.ads.zzwg.zzpw().zzd(com.google.android.gms.internal.ads.zzaav.zzctq)).intValue()) goto L_0x0051;
     */
    @Override // com.google.android.gms.internal.ads.zzcxp
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onSuccess(com.google.android.gms.internal.ads.zzbmw r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzbmw r4 = (com.google.android.gms.internal.ads.zzbmw) r4
            com.google.android.gms.internal.ads.zzdha r0 = r3.zzgwv
            com.google.android.gms.internal.ads.zzbmw r0 = r0.zzgwr
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzdha r0 = r3.zzgwv
            com.google.android.gms.internal.ads.zzbmw r0 = r0.zzgwr
            r0.destroy()
        L_0x000f:
            com.google.android.gms.internal.ads.zzdha r0 = r3.zzgwv
            r0.zzgwr = r4
            com.google.android.gms.internal.ads.zzdha r0 = r3.zzgwv
            android.view.ViewGroup r0 = r0.zzfng
            r0.removeAllViews()
            com.google.android.gms.internal.ads.zzdha r0 = r3.zzgwv
            android.view.ViewGroup r0 = r0.zzfng
            android.view.View r1 = r4.zzahk()
            com.google.android.gms.internal.ads.zzayj r2 = com.google.android.gms.ads.internal.zzq.zzky()
            android.view.ViewGroup$LayoutParams r2 = r2.zzxo()
            r0.addView(r1, r2)
            boolean r0 = r4.zzahd()
            if (r0 != 0) goto L_0x0051
            com.google.android.gms.internal.ads.zzdha r0 = r3.zzgwv
            com.google.android.gms.internal.ads.zzbbd r0 = r0.zzbov
            int r0 = r0.zzede
            com.google.android.gms.internal.ads.zzaag<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzaav.zzctq
            com.google.android.gms.internal.ads.zzaar r2 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r0 >= r1) goto L_0x0076
        L_0x0051:
            com.google.android.gms.internal.ads.zzdha r0 = r3.zzgwv
            com.google.android.gms.ads.internal.overlay.zzq r0 = r0.zza(r4)
            android.widget.RelativeLayout$LayoutParams r1 = com.google.android.gms.internal.ads.zzdha.zzb(r4)
            boolean r2 = r4.zzahl()
            if (r2 == 0) goto L_0x0069
            boolean r2 = r4.zzahe()
            if (r2 != 0) goto L_0x0069
            r2 = 1
            goto L_0x006a
        L_0x0069:
            r2 = 0
        L_0x006a:
            r0.zzal(r2)
            com.google.android.gms.internal.ads.zzdha r2 = r3.zzgwv
            android.view.ViewGroup r2 = r2.zzfng
            r2.addView(r0, r1)
        L_0x0076:
            com.google.android.gms.internal.ads.zzdha r0 = r3.zzgwv
            r0.zzc(r4)
            com.google.android.gms.internal.ads.zzdha r0 = r3.zzgwv
            android.view.ViewGroup r0 = r0.zzfng
            com.google.android.gms.internal.ads.zzdha r1 = r3.zzgwv
            com.google.android.gms.internal.ads.zzvh r1 = r1.zzars()
            int r1 = r1.heightPixels
            r0.setMinimumHeight(r1)
            com.google.android.gms.internal.ads.zzdha r0 = r3.zzgwv
            android.view.ViewGroup r0 = r0.zzfng
            com.google.android.gms.internal.ads.zzdha r1 = r3.zzgwv
            com.google.android.gms.internal.ads.zzvh r1 = r1.zzars()
            int r1 = r1.widthPixels
            r0.setMinimumWidth(r1)
            com.google.android.gms.internal.ads.zzdha r0 = r3.zzgwv
            com.google.android.gms.internal.ads.zzdhi r0 = r0.zzgwo
            com.google.android.gms.internal.ads.zzbmy r1 = new com.google.android.gms.internal.ads.zzbmy
            com.google.android.gms.internal.ads.zzdha r2 = r3.zzgwv
            r1.<init>(r4, r2)
            r0.zzb(r1)
            r4.zzahr()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdhe.onSuccess(java.lang.Object):void");
    }
}
