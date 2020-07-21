package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcy extends zzcu<Integer, Object> {
    public String zznw;
    public long zznx;
    public String zzny;
    public String zznz;
    public String zzoa;

    public zzcy(String str) {
        this();
        zzam(str);
    }

    public zzcy() {
        this.zznw = ExifInterface.LONGITUDE_EAST;
        this.zznx = -1;
        this.zzny = ExifInterface.LONGITUDE_EAST;
        this.zznz = ExifInterface.LONGITUDE_EAST;
        this.zzoa = ExifInterface.LONGITUDE_EAST;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcu
    public final void zzam(String str) {
        String str2;
        long j;
        String str3;
        String str4;
        HashMap zzan = zzan(str);
        if (zzan != null) {
            Object obj = zzan.get(0);
            String str5 = ExifInterface.LONGITUDE_EAST;
            if (obj == null) {
                str2 = str5;
            } else {
                str2 = (String) zzan.get(0);
            }
            this.zznw = str2;
            if (zzan.get(1) == null) {
                j = -1;
            } else {
                j = ((Long) zzan.get(1)).longValue();
            }
            this.zznx = j;
            if (zzan.get(2) == null) {
                str3 = str5;
            } else {
                str3 = (String) zzan.get(2);
            }
            this.zzny = str3;
            if (zzan.get(3) == null) {
                str4 = str5;
            } else {
                str4 = (String) zzan.get(3);
            }
            this.zznz = str4;
            if (zzan.get(4) != null) {
                str5 = (String) zzan.get(4);
            }
            this.zzoa = str5;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcu
    public final HashMap<Integer, Object> zzbo() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zznw);
        hashMap.put(4, this.zzoa);
        hashMap.put(3, this.zznz);
        hashMap.put(2, this.zzny);
        hashMap.put(1, Long.valueOf(this.zznx));
        return hashMap;
    }
}
