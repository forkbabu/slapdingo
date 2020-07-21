package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzyq;
import com.google.android.gms.internal.ads.zzzd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class QueryInfo {
    private final zzzd zzhhe;

    public QueryInfo(zzzd zzzd) {
        this.zzhhe = zzzd;
    }

    public String getQuery() {
        return this.zzhhe.getQuery();
    }

    public Bundle getQueryBundle() {
        return this.zzhhe.getQueryBundle();
    }

    public String getRequestId() {
        return zzzd.zza(this);
    }

    public static void generate(Context context, AdFormat adFormat, AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzyq zzyq;
        if (adRequest == null) {
            zzyq = null;
        } else {
            zzyq = adRequest.zzdq();
        }
        new zzare(context, adFormat, zzyq).zza(queryInfoGenerationCallback);
    }
}
