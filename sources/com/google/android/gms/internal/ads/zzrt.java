package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzrt {
    private ByteArrayOutputStream zzbtx = new ByteArrayOutputStream(4096);
    private Base64OutputStream zzbty = new Base64OutputStream(this.zzbtx, 10);

    public final void write(byte[] bArr) throws IOException {
        this.zzbty.write(bArr);
    }

    public final String toString() {
        try {
            this.zzbty.close();
        } catch (IOException e) {
            zzaxv.zzc("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.zzbtx.close();
            return this.zzbtx.toString();
        } catch (IOException e2) {
            zzaxv.zzc("HashManager: Unable to convert to Base64.", e2);
            return "";
        } finally {
            this.zzbtx = null;
            this.zzbty = null;
        }
    }
}
