package com.google.android.gms.internal.measurement;

import com.itextpdf.text.pdf.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
final class zzkq {
    static String zza(zzgt zzgt) {
        zzkp zzkp = new zzkp(zzgt);
        StringBuilder sb = new StringBuilder(zzkp.zza());
        for (int i = 0; i < zzkp.zza(); i++) {
            byte zza = zzkp.zza(i);
            if (zza == 34) {
                sb.append("\\\"");
            } else if (zza == 39) {
                sb.append("\\'");
            } else if (zza != 92) {
                switch (zza) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (zza < 32 || zza > 126) {
                            sb.append('\\');
                            sb.append((char) (((zza >>> 6) & 3) + 48));
                            sb.append((char) (((zza >>> 3) & 7) + 48));
                            sb.append((char) ((zza & 7) + ByteBuffer.ZERO));
                            break;
                        } else {
                            sb.append((char) zza);
                            continue;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
