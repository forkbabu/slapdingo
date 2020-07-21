package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzazf extends zzau {
    private final Context zzvr;

    public static zzae zzbk(Context context) {
        zzae zzae = new zzae(new zzav(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzazf(context, new zzbd()));
        zzae.start();
        return zzae;
    }

    private zzazf(Context context, zzar zzar) {
        super(zzar);
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzx, com.google.android.gms.internal.ads.zzau
    public final zzy zzc(zzaa<?> zzaa) throws zzao {
        if (zzaa.zzh() && zzaa.getMethod() == 0) {
            if (Pattern.matches((String) zzwg.zzpw().zzd(zzaav.zzcsp), zzaa.getUrl())) {
                zzwg.zzps();
                if (zzbaq.zzd(this.zzvr, 13400000)) {
                    zzy zzc = new zzahw(this.zzvr).zzc(zzaa);
                    if (zzc != null) {
                        String valueOf = String.valueOf(zzaa.getUrl());
                        zzaxv.zzeh(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zzc;
                    }
                    String valueOf2 = String.valueOf(zzaa.getUrl());
                    zzaxv.zzeh(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zzc(zzaa);
    }
}
