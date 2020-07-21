package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbde {
    private final zzbbd zzdpd;
    private final String zzdpt;
    private final zzabi zzefb;
    private boolean zzeff;
    private final zzabg zzehs;
    private final zzazm zzeht = new zzazn().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzxz();
    private final long[] zzehu;
    private final String[] zzehv;
    private boolean zzehw = false;
    private boolean zzehx = false;
    private boolean zzehy = false;
    private boolean zzehz = false;
    private zzbcm zzeia;
    private boolean zzeib;
    private boolean zzeic;
    private long zzeid = -1;
    private final Context zzvr;

    public zzbde(Context context, zzbbd zzbbd, String str, zzabi zzabi, zzabg zzabg) {
        this.zzvr = context;
        this.zzdpd = zzbbd;
        this.zzdpt = str;
        this.zzefb = zzabi;
        this.zzehs = zzabg;
        String str2 = (String) zzwg.zzpw().zzd(zzaav.zzcma);
        if (str2 == null) {
            this.zzehv = new String[0];
            this.zzehu = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzehv = new String[split.length];
        this.zzehu = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzehu[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzaxv.zzd("Unable to parse frame hash target time number.", e);
                this.zzehu[i] = -1;
            }
        }
    }

    public final void zzb(zzbcm zzbcm) {
        zzabd.zza(this.zzefb, this.zzehs, "vpc2");
        this.zzehw = true;
        zzabi zzabi = this.zzefb;
        if (zzabi != null) {
            zzabi.zzh("vpn", zzbcm.zzyo());
        }
        this.zzeia = zzbcm;
    }

    public final void zzfa() {
        if (this.zzehw && !this.zzehx) {
            zzabd.zza(this.zzefb, this.zzehs, "vfr2");
            this.zzehx = true;
        }
    }

    public final void onStop() {
        if (zzacx.zzdbo.get().booleanValue() && !this.zzeib) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzdpt);
            bundle.putString("player", this.zzeia.zzyo());
            for (zzazo zzazo : this.zzeht.zzxy()) {
                String valueOf = String.valueOf(zzazo.name);
                bundle.putString(valueOf.length() != 0 ? "fps_c_".concat(valueOf) : new String("fps_c_"), Integer.toString(zzazo.count));
                String valueOf2 = String.valueOf(zzazo.name);
                bundle.putString(valueOf2.length() != 0 ? "fps_p_".concat(valueOf2) : new String("fps_p_"), Double.toString(zzazo.zzebg));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.zzehu;
                if (i < jArr.length) {
                    String str = this.zzehv[i];
                    if (str != null) {
                        String valueOf3 = String.valueOf(Long.valueOf(jArr[i]));
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 3);
                        sb.append("fh_");
                        sb.append(valueOf3);
                        bundle.putString(sb.toString(), str);
                    }
                    i++;
                } else {
                    zzq.zzkw().zza(this.zzvr, this.zzdpd.zzbpn, "gmob-apps", bundle, true);
                    this.zzeib = true;
                    return;
                }
            }
        }
    }

    public final void zzc(zzbcm zzbcm) {
        if (this.zzehy && !this.zzehz) {
            if (zzaxv.zzwr() && !this.zzehz) {
                zzaxv.zzeh("VideoMetricsMixin first frame");
            }
            zzabd.zza(this.zzefb, this.zzehs, "vff2");
            this.zzehz = true;
        }
        long nanoTime = zzq.zzld().nanoTime();
        if (this.zzeff && this.zzeic && this.zzeid != -1) {
            this.zzeht.zza(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzeid)));
        }
        this.zzeic = this.zzeff;
        this.zzeid = nanoTime;
        long longValue = ((Long) zzwg.zzpw().zzd(zzaav.zzcmb)).longValue();
        long currentPosition = (long) zzbcm.getCurrentPosition();
        int i = 0;
        while (true) {
            String[] strArr = this.zzehv;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] != null || longValue <= Math.abs(currentPosition - this.zzehu[i])) {
                i++;
            } else {
                String[] strArr2 = this.zzehv;
                int i2 = 8;
                Bitmap bitmap = zzbcm.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j);
                        i4++;
                        j--;
                        i2 = 8;
                    }
                    i3++;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", Long.valueOf(j2));
                return;
            }
        }
    }

    public final void zzzt() {
        this.zzeff = true;
        if (this.zzehx && !this.zzehy) {
            zzabd.zza(this.zzefb, this.zzehs, "vfp2");
            this.zzehy = true;
        }
    }

    public final void zzzu() {
        this.zzeff = false;
    }
}
