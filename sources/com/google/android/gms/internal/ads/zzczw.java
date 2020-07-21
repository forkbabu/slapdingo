package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.itextpdf.text.html.HtmlTags;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczw implements zzddz<Bundle> {
    private final zzvo zzgsb;

    public zzczw(zzvo zzvo) {
        this.zzgsb = zzvo;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzvo zzvo = this.zzgsb;
        if (zzvo == null) {
            return;
        }
        if (zzvo.orientation == 1) {
            bundle2.putString("avo", HtmlTags.P);
        } else if (this.zzgsb.orientation == 2) {
            bundle2.putString("avo", "l");
        }
    }
}
