package com.google.android.gms.internal.ads;

import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzalm {
    private static final Charset UTF_8 = Charset.forName(XmpWriter.UTF8);
    public static final zzaln<JSONObject> zzdhf = new zzalo();
    public static final zzall<InputStream> zzdhg = zzalp.zzdhh;

    static final /* synthetic */ InputStream zze(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(UTF_8));
    }
}
