package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeg {
    private static final String[] zzya = {"/aclk", "/pcs/click", "/dbm/clk"};
    private String zzxw = "googleads.g.doubleclick.net";
    private String zzxx = "/pagead/ads";
    private String zzxy = "ad.doubleclick.net";
    private String[] zzxz = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzdw zzyb;

    public zzeg(zzdw zzdw) {
        this.zzyb = zzdw;
    }

    private final boolean zza(Uri uri) {
        if (uri != null) {
            try {
                return uri.getHost().equals(this.zzxy);
            } catch (NullPointerException unused) {
                return false;
            }
        } else {
            throw null;
        }
    }

    public final boolean zzb(Uri uri) {
        if (uri != null) {
            try {
                String host = uri.getHost();
                for (String str : this.zzxz) {
                    if (host.endsWith(str)) {
                        return true;
                    }
                }
            } catch (NullPointerException unused) {
            }
            return false;
        }
        throw null;
    }

    public final zzdw zzcb() {
        return this.zzyb;
    }

    public final Uri zza(Uri uri, Context context) throws zzef {
        return zza(uri, this.zzyb.zzb(context));
    }

    public final void zza(MotionEvent motionEvent) {
        this.zzyb.zza(motionEvent);
    }

    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzef {
        try {
            return zza(uri, this.zzyb.zza(context, uri.getQueryParameter("ai"), view, activity));
        } catch (UnsupportedOperationException unused) {
            throw new zzef("Provided Uri is not in a valid state");
        }
    }

    public final boolean zzc(Uri uri) {
        if (zzb(uri)) {
            for (String str : zzya) {
                if (uri.getPath().endsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Uri zza(Uri uri, String str) throws zzef {
        try {
            boolean zza = zza(uri);
            if (zza) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzef("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzef("Query parameter already exists: ms");
            }
            if (zza) {
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                if (indexOf != -1) {
                    int i = indexOf + 1;
                    return Uri.parse(uri2.substring(0, i) + "dc_ms" + "=" + str + ";" + uri2.substring(i));
                }
                String encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";" + "dc_ms" + "=" + str + ";" + uri2.substring(indexOf2 + encodedPath.length()));
            }
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            if (indexOf3 == -1) {
                return uri.buildUpon().appendQueryParameter("ms", str).build();
            }
            int i2 = indexOf3 + 1;
            return Uri.parse(uri3.substring(0, i2) + "ms" + "=" + str + "&" + uri3.substring(i2));
        } catch (UnsupportedOperationException unused) {
            throw new zzef("Provided Uri is not in a valid state");
        }
    }
}
