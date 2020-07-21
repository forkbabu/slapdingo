package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzq;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcyv {
    public final String zzgrf;
    public String zzgrg;
    public Bundle zzgrh = new Bundle();

    public zzcyv(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        Map<String, String> hashMap = new HashMap<>();
        jsonReader.beginObject();
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName = nextName == null ? "" : nextName;
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -995427962) {
                if (hashCode == -271442291 && nextName.equals("signal_dictionary")) {
                    c = 1;
                }
            } else if (nextName.equals("params")) {
                c = 0;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c != 1) {
                jsonReader.skipValue();
            } else {
                hashMap = zzazy.zzb(jsonReader);
            }
        }
        this.zzgrf = str;
        jsonReader.endObject();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null)) {
                this.zzgrh.putString(entry.getKey(), entry.getValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzcyv zzo(Bundle bundle) {
        try {
            this.zzgrg = zzq.zzkw().zzd(bundle).toString();
        } catch (JSONException unused) {
            this.zzgrg = "{}";
        }
        return this;
    }
}
