package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzq;
import com.itextpdf.text.html.HtmlTags;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcyy implements zzddz<Bundle> {
    private final zzvh zzboz;
    private final List<Parcelable> zzgrk;
    private final Context zzvr;

    public zzcyy(Context context, zzvh zzvh, List<Parcelable> list) {
        this.zzvr = context;
        this.zzboz = zzvh;
        this.zzgrk = list;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (zzacn.zzdap.get().booleanValue()) {
            Bundle bundle3 = new Bundle();
            zzq.zzkw();
            bundle3.putString("activity", zzaye.zzav(this.zzvr));
            Bundle bundle4 = new Bundle();
            bundle4.putInt(HtmlTags.WIDTH, this.zzboz.width);
            bundle4.putInt(HtmlTags.HEIGHT, this.zzboz.height);
            bundle3.putBundle(HtmlTags.SIZE, bundle4);
            if (this.zzgrk.size() > 0) {
                List<Parcelable> list = this.zzgrk;
                bundle3.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle2.putBundle("view_hierarchy", bundle3);
        }
    }
}
