package com.zhihu.matisse.internal.utils;

import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.spongycastle.crypto.tls.CipherSuite;

final class ExifInterfaceCompat {
    private static final int EXIF_DEGREE_FALLBACK_VALUE = -1;
    private static final String TAG = ExifInterfaceCompat.class.getSimpleName();

    private ExifInterfaceCompat() {
    }

    public static ExifInterface newInstance(String str) throws IOException {
        if (str != null) {
            return new ExifInterface(str);
        }
        throw new NullPointerException("filename should not be null");
    }

    private static Date getExifDateTime(String str) {
        try {
            String attribute = newInstance(str).getAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME);
            if (TextUtils.isEmpty(attribute)) {
                return null;
            }
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                return simpleDateFormat.parse(attribute);
            } catch (ParseException e) {
                Log.d(TAG, "failed to parse date taken", e);
                return null;
            }
        } catch (IOException e2) {
            Log.e(TAG, "cannot read exif", e2);
            return null;
        }
    }

    public static long getExifDateTimeInMillis(String str) {
        Date exifDateTime = getExifDateTime(str);
        if (exifDateTime == null) {
            return -1;
        }
        return exifDateTime.getTime();
    }

    public static int getExifOrientation(String str) {
        try {
            int attributeInt = newInstance(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, -1);
            if (attributeInt == -1) {
                return 0;
            }
            if (attributeInt == 3) {
                return CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
        } catch (IOException e) {
            Log.e(TAG, "cannot read exif", e);
            return -1;
        }
    }
}
