package com.google.android.gms.internal.auth;

import android.util.Log;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.UnsupportedEncodingException;

public abstract class zzaz extends FastSafeParcelableJsonResponse {
    private static String zzem = "AUTH";

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public byte[] toByteArray() {
        try {
            return toString().getBytes(XmpWriter.UTF8);
        } catch (UnsupportedEncodingException e) {
            Log.e(zzem, "Error serializing object.", e);
            return null;
        }
    }
}
