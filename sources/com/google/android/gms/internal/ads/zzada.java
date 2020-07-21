package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzada extends zzadk {
    private static final int zzdbr = Color.rgb(12, (int) CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 206);
    private static final int zzdbs;
    private static final int zzdbt;
    private static final int zzdbu = zzdbr;
    private final int backgroundColor;
    private final int textColor;
    private final int textSize;
    private final String zzdbv;
    private final List<zzadf> zzdbw = new ArrayList();
    private final List<zzadt> zzdbx = new ArrayList();
    private final int zzdby;
    private final int zzdbz;
    private final boolean zzdca;

    public zzada(String str, List<zzadf> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzdbv = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzadf zzadf = list.get(i3);
                this.zzdbw.add(zzadf);
                this.zzdbx.add(zzadf);
            }
        }
        this.backgroundColor = num != null ? num.intValue() : zzdbt;
        this.textColor = num2 != null ? num2.intValue() : zzdbu;
        this.textSize = num3 != null ? num3.intValue() : 12;
        this.zzdby = i;
        this.zzdbz = i2;
        this.zzdca = z;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final String getText() {
        return this.zzdbv;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final List<zzadt> zzrt() {
        return this.zzdbx;
    }

    public final List<zzadf> zzru() {
        return this.zzdbw;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final int zzrv() {
        return this.zzdby;
    }

    public final int zzrw() {
        return this.zzdbz;
    }

    static {
        int rgb = Color.rgb(204, 204, 204);
        zzdbs = rgb;
        zzdbt = rgb;
    }
}
