package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzazs implements zzai {
    private final /* synthetic */ String zzebn;
    private final /* synthetic */ zzazt zzebo;

    zzazs(zzazq zzazq, String str, zzazt zzazt) {
        this.zzebn = str;
        this.zzebo = zzazt;
    }

    @Override // com.google.android.gms.internal.ads.zzai
    public final void zzc(zzao zzao) {
        String str = this.zzebn;
        String zzao2 = zzao.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(zzao2).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(zzao2);
        zzaxv.zzfd(sb.toString());
        this.zzebo.zzb(null);
    }
}
