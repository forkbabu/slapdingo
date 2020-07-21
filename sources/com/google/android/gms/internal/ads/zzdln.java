package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdln implements Runnable {
    private final InputStream zzhbn;
    private final ParcelFileDescriptor zzhbo;

    zzdln(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.zzhbn = inputStream;
        this.zzhbo = parcelFileDescriptor;
    }

    public final void run() {
        InputStream inputStream = this.zzhbn;
        try {
            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(this.zzhbo);
            try {
                IOUtils.copyStream(inputStream, autoCloseOutputStream);
                autoCloseOutputStream.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                zzeea.zza(th, th);
            }
            throw th;
            throw th;
        } catch (Throwable th2) {
            zzeea.zza(th, th2);
        }
    }
}
