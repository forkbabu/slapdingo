package com.google.android.gms.internal.vision;

import com.itextpdf.text.pdf.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzjk {
    static String zzd(zzfm zzfm) {
        zzjn zzjn = new zzjn(zzfm);
        StringBuilder sb = new StringBuilder(zzjn.size());
        for (int i = 0; i < zzjn.size(); i++) {
            byte zzao = zzjn.zzao(i);
            if (zzao == 34) {
                sb.append("\\\"");
            } else if (zzao == 39) {
                sb.append("\\'");
            } else if (zzao != 92) {
                switch (zzao) {
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
                        if (zzao < 32 || zzao > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzao >>> 6) & 3) + 48));
                            sb.append((char) (((zzao >>> 3) & 7) + 48));
                            sb.append((char) ((zzao & 7) + ByteBuffer.ZERO));
                            break;
                        } else {
                            sb.append((char) zzao);
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
