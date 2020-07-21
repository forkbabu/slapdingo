package com.google.android.gms.internal.vision;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzbe {
    public static zzcs<zzbf> zzf(Context context) {
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        boolean z = false;
        if ((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys"))) {
            z = true;
        }
        if (!z) {
            return zzcs.zzby();
        }
        if (zzas.zzt() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        zzcs<File> zzg = zzg(context);
        if (zzg.isPresent()) {
            return zzcs.zzc(zza(zzg.get()));
        }
        return zzcs.zzby();
    }

    private static zzcs<File> zzg(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            try {
                File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
                return file.exists() ? zzcs.zzc(file) : zzcs.zzby();
            } catch (RuntimeException e) {
                Log.e("HermeticFileOverrides", "no data dir", e);
                zzcs<File> zzby = zzcs.zzby();
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return zzby;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static zzbf zza(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                HashMap hashMap = new HashMap();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split(" ", 3);
                        if (split.length != 3) {
                            String valueOf = String.valueOf(readLine);
                            Log.e("HermeticFileOverrides", valueOf.length() != 0 ? "Invalid: ".concat(valueOf) : new String("Invalid: "));
                        } else {
                            String str = split[0];
                            String decode = Uri.decode(split[1]);
                            String decode2 = Uri.decode(split[2]);
                            if (!hashMap.containsKey(str)) {
                                hashMap.put(str, new HashMap());
                            }
                            ((Map) hashMap.get(str)).put(decode, decode2);
                        }
                    } else {
                        String valueOf2 = String.valueOf(file);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 7);
                        sb.append("Parsed ");
                        sb.append(valueOf2);
                        Log.i("HermeticFileOverrides", sb.toString());
                        zzbf zzbf = new zzbf(hashMap);
                        bufferedReader.close();
                        return zzbf;
                    }
                }
            } catch (Throwable th) {
                zzdx.zza(th, th);
            }
            throw th;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
