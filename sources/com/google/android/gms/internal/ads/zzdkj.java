package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.itextpdf.text.html.HtmlTags;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdkj {
    public final int height;
    public final int width;
    public final boolean zzgzj;

    public zzdkj(int i, int i2, boolean z) {
        this.width = i;
        this.height = i2;
        this.zzgzj = z;
    }

    static List<zzdkj> zze(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (HtmlTags.WIDTH.equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if (HtmlTags.HEIGHT.equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(nextName)) {
                    z = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzdkj(i, i2, z));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
