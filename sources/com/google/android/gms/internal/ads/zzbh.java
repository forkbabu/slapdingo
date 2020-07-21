package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.jsoup.helper.HttpConnection;
import org.spongycastle.i18n.LocalizedMessage;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbh extends zzaa<String> {
    private final Object mLock = new Object();
    private zzal<String> zzcy;

    public zzbh(int i, String str, zzal<String> zzal, zzai zzai) {
        super(i, str, zzai);
        this.zzcy = zzal;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzi */
    public void zza(String str) {
        zzal<String> zzal;
        synchronized (this.mLock) {
            zzal = this.zzcy;
        }
        if (zzal != null) {
            zzal.zzb(str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaa
    public final zzaj<String> zza(zzy zzy) {
        String str;
        try {
            byte[] bArr = zzy.data;
            Map<String, String> map = zzy.zzam;
            String str2 = LocalizedMessage.DEFAULT_ENCODING;
            String str3 = map.get(HttpConnection.CONTENT_TYPE);
            if (str3 != null) {
                String[] split = str3.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    String[] split2 = split[i].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        str2 = split2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzy.data);
        }
        return zzaj.zza(str, zzbc.zzb(zzy));
    }
}
