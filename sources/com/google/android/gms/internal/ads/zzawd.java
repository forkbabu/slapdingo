package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzawd implements zzawl {
    static final zzawl zzdwt = new zzawd();

    private zzawd() {
    }

    @Override // com.google.android.gms.internal.ads.zzawl
    public final Object zzb(zzbhy zzbhy) {
        String currentScreenName = zzbhy.getCurrentScreenName();
        if (currentScreenName != null) {
            return currentScreenName;
        }
        String currentScreenClass = zzbhy.getCurrentScreenClass();
        return currentScreenClass != null ? currentScreenClass : "";
    }
}
