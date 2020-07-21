package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzsy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsy> CREATOR = new zztb();
    public final String url;
    private final long zzbuw;
    private final String zzbux;
    private final String zzbuy;
    private final String zzbuz;
    private final Bundle zzbva;
    public final boolean zzbvb;
    public long zzbvc;

    public static zzsy zzbv(String str) {
        return zzd(Uri.parse(str));
    }

    public static zzsy zzd(Uri uri) {
        long j;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzaxv.zzfd(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            if (queryParameter2 == null) {
                j = 0;
            } else {
                j = Long.parseLong(queryParameter2);
            }
            Bundle bundle = new Bundle();
            zzq.zzky();
            for (String str3 : uri.getQueryParameterNames()) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new zzsy(queryParameter, j, host, str, str2, bundle, equals, 0);
        } catch (NullPointerException | NumberFormatException e) {
            zzaxv.zzd("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    zzsy(String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z, long j2) {
        this.url = str;
        this.zzbuw = j;
        this.zzbux = str2 == null ? "" : str2;
        this.zzbuy = str3 == null ? "" : str3;
        this.zzbuz = str4 == null ? "" : str4;
        this.zzbva = bundle == null ? new Bundle() : bundle;
        this.zzbvb = z;
        this.zzbvc = j2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.url, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzbuw);
        SafeParcelWriter.writeString(parcel, 4, this.zzbux, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbuy, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzbuz, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzbva, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbvb);
        SafeParcelWriter.writeLong(parcel, 9, this.zzbvc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
