package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.IOUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcpr implements zzdob<zzcpq, zzcpt> {
    private final ApplicationInfo applicationInfo;
    private final String zzdqe;
    private final zzasz zzgif;
    private final String zzgiv;
    private final Context zzvr;

    public zzcpr(Context context, String str, zzasz zzasz, String str2, ApplicationInfo applicationInfo2) {
        this.zzvr = context;
        this.zzgiv = str;
        this.zzgif = zzasz;
        this.zzdqe = str2;
        this.applicationInfo = applicationInfo2;
    }

    private final zzcpt zza(String str, zzass zzass, JSONObject jSONObject, String str2) throws zzcmi {
        byte[] bArr;
        int responseCode;
        InputStreamReader inputStreamReader;
        BufferedOutputStream bufferedOutputStream;
        String str3 = "doritos_v2";
        String str4 = "doritos";
        String str5 = "";
        try {
            if (zzass.getErrorCode() == -2) {
                zzcpt zzcpt = new zzcpt();
                String valueOf = String.valueOf(this.zzgiv);
                zzaxv.zzfc(valueOf.length() != 0 ? "SDK version: ".concat(valueOf) : new String("SDK version: "));
                String valueOf2 = String.valueOf(str);
                zzaxv.zzee(valueOf2.length() != 0 ? "AdRequestServiceImpl: Sending request: ".concat(valueOf2) : new String("AdRequestServiceImpl: Sending request: "));
                URL url = new URL(str);
                HashMap hashMap = new HashMap();
                long elapsedRealtime = zzq.zzld().elapsedRealtime();
                boolean z = false;
                int i = 0;
                while (true) {
                    this.zzgif.zzb(this.applicationInfo);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    try {
                        zzq.zzkw().zza(this.zzvr, this.zzgiv, z, httpURLConnection);
                        if (!TextUtils.isEmpty(str2)) {
                            httpURLConnection.addRequestProperty("Cookie", str2);
                        }
                        if (zzass.zzvc()) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("pii");
                            if (optJSONObject != null) {
                                if (!TextUtils.isEmpty(optJSONObject.optString(str4, str5))) {
                                    httpURLConnection.addRequestProperty("x-afma-drt-cookie", optJSONObject.optString(str4, str5));
                                }
                                if (!TextUtils.isEmpty(optJSONObject.optString(str3, str5))) {
                                    httpURLConnection.addRequestProperty("x-afma-drt-v2-cookie", optJSONObject.optString(str3, str5));
                                }
                            } else {
                                zzaxv.zzeh("DSID signal does not exist.");
                            }
                        }
                        if (zzass == null || TextUtils.isEmpty(zzass.zzvb())) {
                            bArr = null;
                        } else {
                            httpURLConnection.setDoOutput(true);
                            bArr = zzass.zzvb().getBytes();
                            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                            try {
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                                try {
                                    bufferedOutputStream2.write(bArr);
                                    IOUtils.closeQuietly(bufferedOutputStream2);
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    IOUtils.closeQuietly(bufferedOutputStream);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedOutputStream = null;
                                IOUtils.closeQuietly(bufferedOutputStream);
                                throw th;
                            }
                        }
                        zzbau zzbau = new zzbau();
                        zzbau.zza(httpURLConnection, bArr);
                        responseCode = httpURLConnection.getResponseCode();
                        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                            String key = entry.getKey();
                            List<String> value = entry.getValue();
                            if (hashMap.containsKey(key)) {
                                ((List) hashMap.get(key)).addAll(value);
                            } else {
                                hashMap.put(key, new ArrayList(value));
                                str5 = str5;
                            }
                            str4 = str4;
                            str3 = str3;
                        }
                        zzbau.zza(httpURLConnection, responseCode);
                        if (responseCode >= 200 && responseCode < 300) {
                            try {
                                InputStreamReader inputStreamReader2 = new InputStreamReader(httpURLConnection.getInputStream());
                                try {
                                    zzq.zzkw();
                                    String zza = zzaye.zza(inputStreamReader2);
                                    IOUtils.closeQuietly(inputStreamReader2);
                                    zzbau.zzey(zza);
                                    zzcpt.zzgiw = responseCode;
                                    zzcpt.zzdrd = zza;
                                    zzcpt.zzam = hashMap;
                                    if (TextUtils.isEmpty(zza)) {
                                        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcud)).booleanValue()) {
                                            throw new zzcmi(zzdls.zzhbs);
                                        }
                                    }
                                    zzcpt.zzgix = zzq.zzld().elapsedRealtime() - elapsedRealtime;
                                    return zzcpt;
                                } catch (Throwable th3) {
                                    th = th3;
                                    inputStreamReader = inputStreamReader2;
                                    IOUtils.closeQuietly(inputStreamReader);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStreamReader = null;
                                IOUtils.closeQuietly(inputStreamReader);
                                throw th;
                            }
                        } else if (responseCode < 300 || responseCode >= 400) {
                            StringBuilder sb = new StringBuilder(46);
                            sb.append("Received error HTTP response code: ");
                            sb.append(responseCode);
                            zzaxv.zzfd(sb.toString());
                            int i2 = zzdls.zzhbq;
                            StringBuilder sb2 = new StringBuilder(46);
                            sb2.append("Received error HTTP response code: ");
                            sb2.append(responseCode);
                        } else {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (!TextUtils.isEmpty(headerField)) {
                                URL url2 = new URL(headerField);
                                i++;
                                if (i <= ((Integer) zzwg.zzpw().zzd(zzaav.zzctj)).intValue()) {
                                    httpURLConnection.disconnect();
                                    this.zzgif.zzvh();
                                    url = url2;
                                    str5 = str5;
                                    str4 = str4;
                                    str3 = str3;
                                    z = false;
                                } else {
                                    zzaxv.zzfd("Too many redirects.");
                                    throw new zzcmi(zzdls.zzhbq, "Too many redirects");
                                }
                            } else {
                                zzaxv.zzfd("No location header to follow redirect.");
                                throw new zzcmi(zzdls.zzhbq, "No location header to follow redirect");
                            }
                        }
                    } finally {
                        httpURLConnection.disconnect();
                        this.zzgif.zzvh();
                    }
                }
                StringBuilder sb3 = new StringBuilder(46);
                sb3.append("Received error HTTP response code: ");
                sb3.append(responseCode);
                zzaxv.zzfd(sb3.toString());
                int i22 = zzdls.zzhbq;
                StringBuilder sb22 = new StringBuilder(46);
                sb22.append("Received error HTTP response code: ");
                sb22.append(responseCode);
                throw new zzcmi(i22, sb22.toString());
            } else if (zzass.getErrorCode() == 1) {
                if (zzass.zzuz() != null) {
                    zzaxv.zzfb(TextUtils.join(", ", zzass.zzuz()));
                }
                throw new zzcmi(zzdls.zzhbr, "Error building request URL.");
            } else {
                throw new zzcmi(zzdls.zzhbq);
            }
        } catch (IOException e) {
            String valueOf3 = String.valueOf(e.getMessage());
            String concat = valueOf3.length() != 0 ? "Error while connecting to ad server: ".concat(valueOf3) : new String("Error while connecting to ad server: ");
            zzaxv.zzfd(concat);
            throw new zzcmi(zzdls.zzhbq, concat, e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final /* synthetic */ zzcpt apply(zzcpq zzcpq) throws Exception {
        zzcpq zzcpq2 = zzcpq;
        return zza(zzcpq2.zzgip.getUrl(), zzcpq2.zzgip, zzcpq2.zzgio, this.zzdqe);
    }
}
