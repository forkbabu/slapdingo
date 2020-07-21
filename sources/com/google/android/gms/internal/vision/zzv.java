package com.google.android.gms.internal.vision;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzv {
    public static Bitmap zzb(Bitmap bitmap, zzu zzu) {
        int i;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (zzu.rotation != 0) {
            Matrix matrix = new Matrix();
            int i2 = zzu.rotation;
            if (i2 == 0) {
                i = 0;
            } else if (i2 == 1) {
                i = 90;
            } else if (i2 == 2) {
                i = CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256;
            } else if (i2 == 3) {
                i = TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
            } else {
                throw new IllegalArgumentException("Unsupported rotation degree.");
            }
            matrix.postRotate((float) i);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }
        if (zzu.rotation == 1 || zzu.rotation == 3) {
            zzu.width = height;
            zzu.height = width;
        }
        return bitmap;
    }
}
