package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdqp {
    private final Context zzvr;
    private final zzdpm zzvv;

    public zzdqp(Context context, zzdpm zzdpm) {
        this.zzvr = context;
        this.zzvv = zzdpm;
    }

    private final void zzj(byte[] bArr) {
        if (this.zzvv != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("os.arch:");
            sb.append(zzdsj.OS_ARCH.value());
            sb.append(";");
            try {
                String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
                if (strArr != null) {
                    sb.append("supported_abis:");
                    sb.append(Arrays.toString(strArr));
                    sb.append(";");
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
            sb.append("CPU_ABI:");
            sb.append(Build.CPU_ABI);
            sb.append(";");
            sb.append("CPU_ABI2:");
            sb.append(Build.CPU_ABI2);
            sb.append(";");
            if (bArr != null) {
                sb.append("ELF:");
                sb.append(Arrays.toString(bArr));
                sb.append(";");
            }
            this.zzvv.zzi(4007, sb.toString());
        }
    }

    private final String zzavj() {
        HashSet hashSet = new HashSet(Arrays.asList("i686", "armv71"));
        String value = zzdsj.OS_ARCH.value();
        if (!TextUtils.isEmpty(value) && hashSet.contains(value)) {
            return value;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (NoSuchFieldException e) {
            zzdpm zzdpm = this.zzvv;
            if (zzdpm != null) {
                zzdpm.zza(2024, 0, e);
            }
        } catch (IllegalAccessException e2) {
            zzdpm zzdpm2 = this.zzvv;
            if (zzdpm2 != null) {
                zzdpm2.zza(2024, 0, e2);
            }
        }
        if (Build.CPU_ABI != null) {
            return Build.CPU_ABI;
        }
        return Build.CPU_ABI2;
    }

    private final zzgo zzavk() {
        File file = new File(new File(this.zzvr.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            return zzgo.UNSUPPORTED;
        }
        File[] listFiles = file.listFiles(new zzdtr(Pattern.compile(".*\\.so$", 2)));
        if (listFiles == null || listFiles.length == 0) {
            return zzgo.UNSUPPORTED;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(listFiles[0]);
            try {
                byte[] bArr = new byte[20];
                if (fileInputStream.read(bArr) == 20) {
                    byte[] bArr2 = {0, 0};
                    if (bArr[5] == 2) {
                        zzj(bArr);
                        zzgo zzgo = zzgo.UNSUPPORTED;
                        fileInputStream.close();
                        return zzgo;
                    }
                    bArr2[0] = bArr[19];
                    bArr2[1] = bArr[18];
                    short s = ByteBuffer.wrap(bArr2).getShort();
                    if (s == 3) {
                        zzgo zzgo2 = zzgo.X86;
                        fileInputStream.close();
                        return zzgo2;
                    } else if (s == 40) {
                        zzgo zzgo3 = zzgo.ARM7;
                        fileInputStream.close();
                        return zzgo3;
                    } else if (s == 62) {
                        zzgo zzgo4 = zzgo.X86_64;
                        fileInputStream.close();
                        return zzgo4;
                    } else if (s != 183) {
                        zzgo zzgo5 = zzgo.UNSUPPORTED;
                        fileInputStream.close();
                        return zzgo5;
                    } else {
                        zzgo zzgo6 = zzgo.ARM64;
                        fileInputStream.close();
                        return zzgo6;
                    }
                } else {
                    fileInputStream.close();
                    return zzgo.UNSUPPORTED;
                }
            } catch (Throwable th) {
                zzeea.zza(th, th);
            }
        } catch (IOException unused) {
        }
        throw th;
    }

    public final zzgo zzavl() {
        zzgo zzavk = zzavk();
        if (zzavk != zzgo.UNSUPPORTED) {
            return zzavk;
        }
        String zzavj = zzavj();
        if (!TextUtils.isEmpty(zzavj)) {
            if (zzavj.equalsIgnoreCase("i686") || zzavj.equalsIgnoreCase("x86")) {
                return zzgo.X86;
            }
            if (zzavj.equalsIgnoreCase("x86_64")) {
                return zzgo.X86_64;
            }
            if (zzavj.equalsIgnoreCase("arm64-v8a")) {
                return zzgo.ARM64;
            }
            if (zzavj.equalsIgnoreCase("armeabi-v7a") || zzavj.equalsIgnoreCase("armv71")) {
                return zzgo.ARM7;
            }
        }
        zzj(null);
        return zzgo.UNSUPPORTED;
    }
}
