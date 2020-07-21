package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.util.CollectionUtils;
import com.itextpdf.text.html.HtmlTags;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzahh implements zzahc<zzbfn> {
    private static final Map<String, Integer> zzdeh = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final zzc zzdee;
    private final zzapt zzdef;
    private final zzaqc zzdeg;

    public zzahh(zzc zzc, zzapt zzapt, zzaqc zzaqc) {
        this.zzdee = zzc;
        this.zzdef = zzapt;
        this.zzdeg = zzaqc;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahc
    public final /* synthetic */ void zza(zzbfn zzbfn, Map map) {
        zzc zzc;
        zzbfn zzbfn2 = zzbfn;
        int intValue = zzdeh.get((String) map.get(HtmlTags.A)).intValue();
        if (intValue != 5 && intValue != 7 && (zzc = this.zzdee) != null && !zzc.zzjy()) {
            this.zzdee.zzbn(null);
        } else if (intValue == 1) {
            this.zzdef.zzg(map);
        } else if (intValue == 3) {
            new zzapu(zzbfn2, map).execute();
        } else if (intValue == 4) {
            new zzapo(zzbfn2, map).execute();
        } else if (intValue == 5) {
            new zzapv(zzbfn2, map).execute();
        } else if (intValue == 6) {
            this.zzdef.zzac(true);
        } else if (intValue != 7) {
            zzaxv.zzfc("Unknown MRAID command called.");
        } else {
            this.zzdeg.zzui();
        }
    }
}
