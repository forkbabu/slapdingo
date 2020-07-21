package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzbgp;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbgy;
import com.google.android.gms.internal.ads.zzbha;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.PdfBoolean;
import java.net.URISyntaxException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzahg<T extends zzbgq & zzbgp & zzbgt & zzbgy & zzbha> implements zzahc<T> {
    private final zzc zzdee;
    private final zzapt zzdef;

    public zzahg(zzc zzc, zzapt zzapt) {
        this.zzdee = zzc;
        this.zzdef = zzapt;
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if (HtmlTags.P.equalsIgnoreCase(str)) {
            zzq.zzky();
            return 7;
        } else if ("l".equalsIgnoreCase(str)) {
            zzq.zzky();
            return 6;
        } else if ("c".equalsIgnoreCase(str)) {
            return zzq.zzky().zzxn();
        } else {
            return -1;
        }
    }

    private final void zzab(boolean z) {
        zzapt zzapt = this.zzdef;
        if (zzapt != null) {
            zzapt.zzac(z);
        }
    }

    static Uri zza(Context context, zzeg zzeg, Uri uri, View view, Activity activity) {
        if (zzeg == null) {
            return uri;
        }
        try {
            if (zzeg.zzc(uri)) {
                return zzeg.zza(uri, context, view, activity);
            }
            return uri;
        } catch (zzef unused) {
            return uri;
        } catch (Exception e) {
            zzq.zzla().zza(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    static Uri zze(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String valueOf = String.valueOf(uri.toString());
            zzaxv.zzc(valueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(valueOf) : new String("Error adding click uptime parameter to url: "), e);
        }
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzahc
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbgq zzbgq = (zzbgq) obj;
        String zzc = zzawn.zzc((String) map.get(HtmlTags.U), zzbgq.getContext(), true);
        String str = (String) map.get(HtmlTags.A);
        if (str == null) {
            zzaxv.zzfd("Action missing from an open GMSG.");
            return;
        }
        zzc zzc2 = this.zzdee;
        if (zzc2 != null && !zzc2.zzjy()) {
            this.zzdee.zzbn(zzc);
        } else if ("expand".equalsIgnoreCase(str)) {
            if (((zzbgp) zzbgq).zzabe()) {
                zzaxv.zzfd("Cannot expand WebView that is already expanded.");
                return;
            }
            zzab(false);
            ((zzbgt) zzbgq).zzc(zzc(map), zzd(map));
        } else if ("webapp".equalsIgnoreCase(str)) {
            zzab(false);
            if (zzc != null) {
                ((zzbgt) zzbgq).zza(zzc(map), zzd(map), zzc);
            } else {
                ((zzbgt) zzbgq).zza(zzc(map), zzd(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else if ("app".equalsIgnoreCase(str) && PdfBoolean.TRUE.equalsIgnoreCase((String) map.get("system_browser"))) {
            zzab(true);
            if (TextUtils.isEmpty(zzc)) {
                zzaxv.zzfd("Destination url cannot be empty.");
                return;
            }
            try {
                ((zzbgt) zzbgq).zza(new zzd(new zzahj(zzbgq.getContext(), ((zzbgy) zzbgq).zzabc(), ((zzbha) zzbgq).getView()).zze(map)));
            } catch (ActivityNotFoundException e) {
                zzaxv.zzfd(e.getMessage());
            }
        } else if ("open_app".equalsIgnoreCase(str)) {
            if (zzwg.zzpw().zzd(zzaav.zzcxq).booleanValue()) {
                zzab(true);
                String str2 = (String) map.get(HtmlTags.P);
                if (str2 == null) {
                    zzaxv.zzfd("Package name missing from open app action.");
                    return;
                }
                PackageManager packageManager = zzbgq.getContext().getPackageManager();
                if (packageManager == null) {
                    zzaxv.zzfd("Cannot get package manager from open app action.");
                    return;
                }
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str2);
                if (launchIntentForPackage != null) {
                    ((zzbgt) zzbgq).zza(new zzd(launchIntentForPackage));
                }
            }
        } else {
            zzab(true);
            String str3 = (String) map.get("intent_url");
            Intent intent = null;
            if (!TextUtils.isEmpty(str3)) {
                try {
                    intent = Intent.parseUri(str3, 0);
                } catch (URISyntaxException e2) {
                    String valueOf = String.valueOf(str3);
                    zzaxv.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e2);
                }
            }
            if (!(intent == null || intent.getData() == null)) {
                Uri data = intent.getData();
                if (!Uri.EMPTY.equals(data)) {
                    intent.setData(zze(zza(zzbgq.getContext(), ((zzbgy) zzbgq).zzabc(), data, ((zzbha) zzbgq).getView(), zzbgq.zzzl())));
                }
            }
            if (intent != null) {
                ((zzbgt) zzbgq).zza(new zzd(intent));
                return;
            }
            if (!TextUtils.isEmpty(zzc)) {
                zzc = zze(zza(zzbgq.getContext(), ((zzbgy) zzbgq).zzabc(), Uri.parse(zzc), ((zzbha) zzbgq).getView(), zzbgq.zzzl())).toString();
            }
            ((zzbgt) zzbgq).zza(new zzd((String) map.get(HtmlTags.I), zzc, (String) map.get("m"), (String) map.get(HtmlTags.P), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
        }
    }
}
