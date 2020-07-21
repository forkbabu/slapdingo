package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.JsonWriter;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.itextpdf.text.html.HtmlTags;
import com.zhihu.matisse.internal.loader.AlbumLoader;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzbau {
    private static boolean enabled = false;
    private static Object lock = new Object();
    private static Clock zzbqd = DefaultClock.getInstance();
    private static boolean zzecx = false;
    private static final Set<String> zzecy = new HashSet(Arrays.asList(new String[0]));
    private final List<String> zzecz;

    public zzbau() {
        this(null);
    }

    public zzbau(String str) {
        List<String> list;
        if (!isEnabled()) {
            list = new ArrayList<>();
        } else {
            String[] strArr = new String[1];
            String valueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = valueOf.length() != 0 ? "network_request_".concat(valueOf) : new String("network_request_");
            list = Arrays.asList(strArr);
        }
        this.zzecz = list;
    }

    public final void zza(HttpURLConnection httpURLConnection, byte[] bArr) {
        HashMap hashMap;
        if (isEnabled()) {
            if (httpURLConnection.getRequestProperties() == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(httpURLConnection.getRequestProperties());
            }
            zzb(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), hashMap, bArr);
        }
    }

    public final void zza(String str, String str2, Map<String, ?> map, byte[] bArr) {
        if (isEnabled()) {
            zzb(str, str2, map, bArr);
        }
    }

    private final void zzb(String str, String str2, Map<String, ?> map, byte[] bArr) {
        zza("onNetworkRequest", new zzbat(str, str2, map, bArr));
    }

    public final void zza(HttpURLConnection httpURLConnection, int i) {
        if (isEnabled()) {
            String str = null;
            zzb(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    String valueOf = String.valueOf(e.getMessage());
                    zzbba.zzfd(valueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(valueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                }
                zzez(str);
            }
        }
    }

    public final void zza(Map<String, ?> map, int i) {
        if (isEnabled()) {
            zzb(map, i);
            if (i < 200 || i >= 300) {
                zzez(null);
            }
        }
    }

    private final void zzb(Map<String, ?> map, int i) {
        zza("onNetworkResponse", new zzbaw(i, map));
    }

    public final void zzey(String str) {
        if (isEnabled() && str != null) {
            zzi(str.getBytes());
        }
    }

    public final void zzi(byte[] bArr) {
        zza("onNetworkResponseBody", new zzbav(bArr));
    }

    private final void zzez(String str) {
        zza("onNetworkRequestError", new zzbay(str));
    }

    private static void zza(JsonWriter jsonWriter, Map<String, ?> map) throws IOException {
        if (map != null) {
            jsonWriter.name("headers").beginArray();
            Iterator<Map.Entry<String, ?>> it2 = map.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<String, ?> next = it2.next();
                String key = next.getKey();
                if (!zzecy.contains(key)) {
                    if (!(next.getValue() instanceof List)) {
                        if (!(next.getValue() instanceof String)) {
                            zzbba.zzfb("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                            break;
                        }
                        jsonWriter.beginObject();
                        jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.NAME).value(key);
                        jsonWriter.name("value").value((String) next.getValue());
                        jsonWriter.endObject();
                    } else {
                        for (String str : (List) next.getValue()) {
                            jsonWriter.beginObject();
                            jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.NAME).value(key);
                            jsonWriter.name("value").value(str);
                            jsonWriter.endObject();
                        }
                    }
                }
            }
            jsonWriter.endArray();
        }
    }

    private final void zza(String str, zzbax zzbax) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zzbqd.currentTimeMillis());
            jsonWriter.name(NotificationCompat.CATEGORY_EVENT).value(str);
            jsonWriter.name("components").beginArray();
            for (String str2 : this.zzecz) {
                jsonWriter.value(str2);
            }
            jsonWriter.endArray();
            zzbax.zzb(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            zzbba.zzc("unable to log", e);
        }
        zzfa(stringWriter.toString());
    }

    private static synchronized void zzfa(String str) {
        synchronized (zzbau.class) {
            zzbba.zzfc("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 4000;
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                zzbba.zzfc(valueOf.length() != 0 ? "GMA Debug CONTENT ".concat(valueOf) : new String("GMA Debug CONTENT "));
                i = i2;
            }
            zzbba.zzfc("GMA Debug FINISH");
        }
    }

    public static void zzyk() {
        synchronized (lock) {
            zzecx = false;
            enabled = false;
            zzbba.zzfd("Ad debug logging enablement is out of date.");
        }
    }

    public static void zzar(boolean z) {
        synchronized (lock) {
            zzecx = true;
            enabled = z;
        }
    }

    public static boolean zzyl() {
        boolean z;
        synchronized (lock) {
            z = zzecx;
        }
        return z;
    }

    public static boolean isEnabled() {
        boolean z;
        synchronized (lock) {
            z = zzecx && enabled;
        }
        return z;
    }

    public static boolean zzbt(Context context) {
        if (Build.VERSION.SDK_INT < 17 || !zzacg.zzczq.get().booleanValue()) {
            return false;
        }
        try {
            if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            zzbba.zzd("Fail to determine debug setting.", e);
            return false;
        }
    }

    static final /* synthetic */ void zza(String str, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zza(byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        int length = bArr.length;
        String encode = Base64Utils.encode(bArr);
        if (length < 10000) {
            jsonWriter.name(HtmlTags.BODY).value(encode);
        } else {
            String zzew = zzbaq.zzew(encode);
            if (zzew != null) {
                jsonWriter.name("bodydigest").value(zzew);
            }
        }
        jsonWriter.name("bodylength").value((long) length);
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zza(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long) i);
        jsonWriter.endObject();
        zza(jsonWriter, map);
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name(AlbumLoader.COLUMN_URI).value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zza(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name(HtmlTags.BODY).value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }
}
