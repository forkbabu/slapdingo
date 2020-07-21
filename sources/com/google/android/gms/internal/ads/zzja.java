package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import org.opencv.ml.DTrees;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzja {
    private static final int[] zzaml = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzamm = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzamn = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, DTrees.PREDICT_MASK, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static int zzo(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) << 5;
    }
}
