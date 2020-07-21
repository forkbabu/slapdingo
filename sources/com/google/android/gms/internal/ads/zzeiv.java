package com.google.android.gms.internal.ads;

import com.itextpdf.text.pdf.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeiv {
    static String zzam(zzeer zzeer) {
        zzeiy zzeiy = new zzeiy(zzeer);
        StringBuilder sb = new StringBuilder(zzeiy.size());
        for (int i = 0; i < zzeiy.size(); i++) {
            byte zzft = zzeiy.zzft(i);
            if (zzft == 34) {
                sb.append("\\\"");
            } else if (zzft == 39) {
                sb.append("\\'");
            } else if (zzft != 92) {
                switch (zzft) {
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
                        if (zzft < 32 || zzft > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzft >>> 6) & 3) + 48));
                            sb.append((char) (((zzft >>> 3) & 7) + 48));
                            sb.append((char) ((zzft & 7) + ByteBuffer.ZERO));
                            break;
                        } else {
                            sb.append((char) zzft);
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
