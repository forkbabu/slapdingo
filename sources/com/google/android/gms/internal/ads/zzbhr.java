package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbhr {
    private final String method;
    public final Uri uri;
    public final String url;
    public final Map<String, String> zzam;

    public zzbhr(WebResourceRequest webResourceRequest) {
        this(webResourceRequest.getUrl().toString(), webResourceRequest.getUrl(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
    }

    public zzbhr(String str) {
        this(str, Uri.parse(str), null, null);
    }

    private zzbhr(String str, Uri uri2, String str2, Map<String, String> map) {
        this.url = str;
        this.uri = uri2;
        this.method = str2 == null ? "GET" : str2;
        this.zzam = map == null ? Collections.emptyMap() : map;
    }
}
