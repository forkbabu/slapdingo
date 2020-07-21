package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbez extends zzbes {
    private static final Set<String> zzekq = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzekr = new DecimalFormat("#,###");
    private File zzcz;
    private boolean zzeks;

    public zzbez(zzbdb zzbdb) {
        super(zzbdb);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzaxv.zzfd("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(cacheDir, "admobVideoStreams");
        this.zzcz = file;
        if (!file.isDirectory() && !this.zzcz.mkdirs()) {
            String valueOf = String.valueOf(this.zzcz.getAbsolutePath());
            zzaxv.zzfd(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzcz = null;
        } else if (!this.zzcz.setReadable(true, false) || !this.zzcz.setExecutable(true, false)) {
            String valueOf2 = String.valueOf(this.zzcz.getAbsolutePath());
            zzaxv.zzfd(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzcz = null;
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:199:0x04d4 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:163:0x03c0 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:166:0x03e0 */
    /* JADX DEBUG: Additional 3 move instruction added to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v7, resolved type: java.lang.String} */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4, types: [int] */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r24v10 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01ee, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f0, code lost:
        r1 = r5.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01f9, code lost:
        if (r1 < 400) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01fb, code lost:
        r15 = "badUrl";
        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x020b, code lost:
        if (r2.length() == 0) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x020d, code lost:
        r2 = "HTTP request failed. Code: ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0213, code lost:
        r2 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 32);
        r4.append("HTTP status code ");
        r4.append(r1);
        r4.append(" at ");
        r4.append(r31);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0240, code lost:
        throw new java.io.IOException(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0241, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0245, code lost:
        r7 = r5.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0249, code lost:
        if (r7 >= 0) goto L_0x0274;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x024b, code lost:
        r1 = java.lang.String.valueOf(r31);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0255, code lost:
        if (r1.length() == 0) goto L_0x025c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0257, code lost:
        r0 = "Stream cache aborted, missing content-length header at ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x025c, code lost:
        r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0262, code lost:
        com.google.android.gms.internal.ads.zzaxv.zzfd(r0);
        zza(r31, r12.getAbsolutePath(), "contentLengthMissing", null);
        com.google.android.gms.internal.ads.zzbez.zzekq.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0273, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0274, code lost:
        r1 = com.google.android.gms.internal.ads.zzbez.zzekr.format((long) r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzwg.zzpw().zzd(com.google.android.gms.internal.ads.zzaav.zzclv)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x028b, code lost:
        if (r7 <= r3) goto L_0x02e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x028d, code lost:
        r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r31).length());
        r2.append("Content length ");
        r2.append(r1);
        r2.append(" exceeds limit at ");
        r2.append(r31);
        com.google.android.gms.internal.ads.zzaxv.zzfd(r2.toString());
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02c6, code lost:
        if (r1.length() == 0) goto L_0x02cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02c8, code lost:
        r0 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02cd, code lost:
        r0 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02d3, code lost:
        zza(r31, r12.getAbsolutePath(), "sizeExceeded", r0);
        com.google.android.gms.internal.ads.zzbez.zzekq.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02e1, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02e2, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r31).length());
        r4.append("Caching ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r31);
        com.google.android.gms.internal.ads.zzaxv.zzee(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzq.zzld();
        r17 = r16.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x033b, code lost:
        r10 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:?, code lost:
        r6 = new com.google.android.gms.internal.ads.zzbag(((java.lang.Long) com.google.android.gms.internal.ads.zzwg.zzpw().zzd(com.google.android.gms.internal.ads.zzaav.zzcly)).longValue());
        r13 = ((java.lang.Long) com.google.android.gms.internal.ads.zzwg.zzpw().zzd(com.google.android.gms.internal.ads.zzaav.zzclx)).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0355, code lost:
        r20 = r5.read(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0359, code lost:
        if (r20 < 0) goto L_0x0471;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x035b, code lost:
        r11 = r11 + r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x035d, code lost:
        if (r11 <= r3) goto L_0x0392;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x035f, code lost:
        r15 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:?, code lost:
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x036f, code lost:
        if (r1.length() == 0) goto L_0x0377;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0371, code lost:
        r1 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0377, code lost:
        r1 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0383, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0384, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0387, code lost:
        r2 = r1;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x038a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x038d, code lost:
        r1 = r10;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x038f, code lost:
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
        r1.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0399, code lost:
        if (r2.write(r1) > 0) goto L_0x0395;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x039b, code lost:
        r1.clear();
        r24 = ((r16.currentTimeMillis() - r17) > (1000 * r13) ? 1 : ((r16.currentTimeMillis() - r17) == (1000 * r13) ? 0 : -1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03aa, code lost:
        if (r24 > 0) goto L_0x0425;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03b0, code lost:
        if (r30.zzeks != false) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03b6, code lost:
        if (r6.tryAcquire() == false) goto L_0x03ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03be, code lost:
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03c2, code lost:
        r24 = r10;
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:?, code lost:
        com.google.android.gms.internal.ads.zzbaq.zzaag.post(new com.google.android.gms.internal.ads.zzber(r30, r31, r12.getAbsolutePath(), r11, r7, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03e7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03e9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03ea, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03ef, code lost:
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0401, code lost:
        r6 = r19;
        r1 = r1;
        r5 = r21;
        r15 = r22;
        r10 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r7 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0415, code lost:
        r27 = r4;
        r24 = r10;
        r15 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0424, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0425, code lost:
        r15 = "downloadTimeout";
        r0 = java.lang.Long.toString(r13);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0458, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0459, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x045c, code lost:
        r2 = r2.toString();
        r1 = r10;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0463, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0467, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x046a, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0471, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:?, code lost:
        r27.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0480, code lost:
        if (com.google.android.gms.internal.ads.zzaxv.isLoggable(3) == false) goto L_0x04c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0482, code lost:
        r1 = com.google.android.gms.internal.ads.zzbez.zzekr.format((long) r11);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r31);
        com.google.android.gms.internal.ads.zzaxv.zzee(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x04b9, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x04bb, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x04bc, code lost:
        r15 = r22;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04be, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x04c1, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x04ca, code lost:
        if (r0.isFile() == false) goto L_0x04d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x04cc, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:?, code lost:
        r0.createNewFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x04eb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x04ee, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x04f3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x04f6, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x04fa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04fd, code lost:
        r27 = r4;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0506, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0510, code lost:
        throw new java.io.IOException("Invalid protocol.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x051b, code lost:
        throw new java.io.IOException("Too many redirects (20)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x051c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x051f, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0522, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0525, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0528, code lost:
        r2 = null;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x052e, code lost:
        com.google.android.gms.ads.internal.zzq.zzla().zza(r0, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0540, code lost:
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 26);
        r3.append("Preload aborted for URL \"");
        r3.append(r31);
        r3.append("\"");
        com.google.android.gms.internal.ads.zzaxv.zzfc(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0564, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 25);
        r4.append("Preload failed for URL \"");
        r4.append(r31);
        r4.append("\"");
        com.google.android.gms.internal.ads.zzaxv.zzd(r4.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x05a3, code lost:
        r0 = "Could not delete partial cache file at ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x05a8, code lost:
        r0 = new java.lang.String("Could not delete partial cache file at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012e, code lost:
        r15 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        com.google.android.gms.ads.internal.zzq.zzli();
        r1 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzwg.zzpw().zzd(com.google.android.gms.internal.ads.zzaav.zzclz)).intValue();
        r2 = new java.net.URL(r31);
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0149, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x014c, code lost:
        if (r3 > 20) goto L_0x0511;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014e, code lost:
        r5 = r2.openConnection();
        r5.setConnectTimeout(r1);
        r5.setReadTimeout(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015a, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x0506;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015c, code lost:
        r5 = (java.net.HttpURLConnection) r5;
        r6 = new com.google.android.gms.internal.ads.zzbau();
        r6.zza(r5, (byte[]) null);
        r5.setInstanceFollowRedirects(false);
        r7 = r5.getResponseCode();
        r6.zza(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0173, code lost:
        if ((r7 / 100) != 3) goto L_0x01ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r4 = r5.getHeaderField("Location");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x017b, code lost:
        if (r4 == null) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x017d, code lost:
        r6 = new java.net.URL(r2, r4);
        r2 = r6.getProtocol();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0186, code lost:
        if (r2 == null) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x018e, code lost:
        if (r2.equals("http") != false) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0196, code lost:
        if (r2.equals("https") != false) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0198, code lost:
        r2 = java.lang.String.valueOf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a4, code lost:
        if (r2.length() == 0) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a6, code lost:
        r1 = "Unsupported scheme: ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01ab, code lost:
        r1 = new java.lang.String("Unsupported scheme: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01b4, code lost:
        throw new java.io.IOException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b5, code lost:
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01bf, code lost:
        if (r4.length() == 0) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c1, code lost:
        r2 = "Redirecting to ".concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c6, code lost:
        r2 = new java.lang.String("Redirecting to ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01cc, code lost:
        com.google.android.gms.internal.ads.zzaxv.zzee(r2);
        r5.disconnect();
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01dc, code lost:
        throw new java.io.IOException("Protocol is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e4, code lost:
        throw new java.io.IOException("Missing Location header in redirect");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e8, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e9, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x04b9 A[ExcHandler: RuntimeException (e java.lang.RuntimeException), PHI: r22 r24 r27 
      PHI: (r22v7 java.lang.String) = (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v15 java.lang.String), (r22v15 java.lang.String) binds: [B:199:0x04d4, B:200:?, B:163:0x03c0, B:166:0x03e0] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v3 ?) = (r24v0 ?), (r24v0 ?), (r24v4 ?), (r24v10 ?) binds: [B:199:0x04d4, B:200:?, B:163:0x03c0, B:166:0x03e0] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r27v9 java.io.FileOutputStream) = (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v13 java.io.FileOutputStream), (r27v17 java.io.FileOutputStream) binds: [B:199:0x04d4, B:200:?, B:163:0x03c0, B:166:0x03e0] A[DONT_GENERATE, DONT_INLINE], Splitter:B:166:0x03e0] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x052e  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0540  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0564  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x05a3  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x05a8  */
    @Override // com.google.android.gms.internal.ads.zzbes
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfm(java.lang.String r31) {
        /*
            r30 = this;
            r8 = r30
            r9 = r31
            java.io.File r0 = r8.zzcz
            r10 = 0
            r11 = 0
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "noCacheDir"
            r8.zza(r9, r10, r0, r10)
            return r11
        L_0x0010:
            java.io.File r0 = r8.zzcz
            if (r0 != 0) goto L_0x0016
            r3 = 0
            goto L_0x0032
        L_0x0016:
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x001d:
            if (r2 >= r1) goto L_0x0032
            r4 = r0[r2]
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = ".done"
            boolean r4 = r4.endsWith(r5)
            if (r4 != 0) goto L_0x002f
            int r3 = r3 + 1
        L_0x002f:
            int r2 = r2 + 1
            goto L_0x001d
        L_0x0032:
            com.google.android.gms.internal.ads.zzaag<java.lang.Integer> r0 = com.google.android.gms.internal.ads.zzaav.zzclu
            com.google.android.gms.internal.ads.zzaar r1 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r3 <= r0) goto L_0x0095
            java.io.File r0 = r8.zzcz
            if (r0 != 0) goto L_0x004a
        L_0x0048:
            r0 = 0
            goto L_0x0088
        L_0x004a:
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.io.File[] r0 = r0.listFiles()
            int r3 = r0.length
            r5 = r10
            r4 = 0
        L_0x0056:
            if (r4 >= r3) goto L_0x0073
            r6 = r0[r4]
            java.lang.String r7 = r6.getName()
            java.lang.String r12 = ".done"
            boolean r7 = r7.endsWith(r12)
            if (r7 != 0) goto L_0x0070
            long r12 = r6.lastModified()
            int r7 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x0070
            r5 = r6
            r1 = r12
        L_0x0070:
            int r4 = r4 + 1
            goto L_0x0056
        L_0x0073:
            if (r5 == 0) goto L_0x0048
            boolean r0 = r5.delete()
            java.io.File r1 = r8.zzd(r5)
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L_0x0088
            boolean r1 = r1.delete()
            r0 = r0 & r1
        L_0x0088:
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "Unable to expire stream cache"
            com.google.android.gms.internal.ads.zzaxv.zzfd(r0)
            java.lang.String r0 = "expireFailed"
            r8.zza(r9, r10, r0, r10)
            return r11
        L_0x0095:
            java.lang.String r0 = r30.zzfn(r31)
            java.io.File r12 = new java.io.File
            java.io.File r1 = r8.zzcz
            r12.<init>(r1, r0)
            java.io.File r0 = r8.zzd(r12)
            boolean r1 = r12.isFile()
            r13 = 1
            if (r1 == 0) goto L_0x00d8
            boolean r1 = r0.isFile()
            if (r1 == 0) goto L_0x00d8
            long r0 = r12.length()
            int r1 = (int) r0
            java.lang.String r0 = "Stream cache hit at "
            java.lang.String r2 = java.lang.String.valueOf(r31)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00c7
            java.lang.String r0 = r0.concat(r2)
            goto L_0x00cd
        L_0x00c7:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r0)
            r0 = r2
        L_0x00cd:
            com.google.android.gms.internal.ads.zzaxv.zzee(r0)
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zza(r9, r0, r1)
            return r13
        L_0x00d8:
            java.io.File r1 = r8.zzcz
            java.lang.String r1 = r1.getAbsolutePath()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r31)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00f2
            java.lang.String r1 = r1.concat(r2)
            r14 = r1
            goto L_0x00f8
        L_0x00f2:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r14 = r2
        L_0x00f8:
            java.util.Set<java.lang.String> r1 = com.google.android.gms.internal.ads.zzbez.zzekq
            monitor-enter(r1)
            java.util.Set<java.lang.String> r2 = com.google.android.gms.internal.ads.zzbez.zzekq     // Catch:{ all -> 0x05bf }
            boolean r2 = r2.contains(r14)     // Catch:{ all -> 0x05bf }
            if (r2 == 0) goto L_0x0128
            java.lang.String r0 = "Stream cache already in progress at "
            java.lang.String r2 = java.lang.String.valueOf(r31)     // Catch:{ all -> 0x05bf }
            int r3 = r2.length()     // Catch:{ all -> 0x05bf }
            if (r3 == 0) goto L_0x0114
            java.lang.String r0 = r0.concat(r2)     // Catch:{ all -> 0x05bf }
            goto L_0x011a
        L_0x0114:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x05bf }
            r2.<init>(r0)     // Catch:{ all -> 0x05bf }
            r0 = r2
        L_0x011a:
            com.google.android.gms.internal.ads.zzaxv.zzfd(r0)     // Catch:{ all -> 0x05bf }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ all -> 0x05bf }
            java.lang.String r2 = "inProgress"
            r8.zza(r9, r0, r2, r10)     // Catch:{ all -> 0x05bf }
            monitor-exit(r1)     // Catch:{ all -> 0x05bf }
            return r11
        L_0x0128:
            java.util.Set<java.lang.String> r2 = com.google.android.gms.internal.ads.zzbez.zzekq     // Catch:{ all -> 0x05bf }
            r2.add(r14)     // Catch:{ all -> 0x05bf }
            monitor-exit(r1)     // Catch:{ all -> 0x05bf }
            java.lang.String r15 = "error"
            com.google.android.gms.ads.internal.zzq.zzli()     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            com.google.android.gms.internal.ads.zzaag<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzaav.zzclz     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            com.google.android.gms.internal.ads.zzaar r2 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            int r1 = r1.intValue()     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            r2.<init>(r9)     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            r3 = 0
        L_0x0149:
            int r3 = r3 + r13
            r4 = 20
            if (r3 > r4) goto L_0x0511
            java.net.URLConnection r5 = r2.openConnection()     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            r5.setConnectTimeout(r1)     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            r5.setReadTimeout(r1)     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            boolean r6 = r5 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            if (r6 == 0) goto L_0x0506
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            com.google.android.gms.internal.ads.zzbau r6 = new com.google.android.gms.internal.ads.zzbau     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            r6.<init>()     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            r6.zza(r5, r10)     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            r5.setInstanceFollowRedirects(r11)     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            int r7 = r5.getResponseCode()     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            r6.zza(r5, r7)     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            int r7 = r7 / 100
            r6 = 3
            if (r7 != r6) goto L_0x01ec
            java.lang.String r4 = "Location"
            java.lang.String r4 = r5.getHeaderField(r4)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r4 == 0) goto L_0x01dd
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r6.<init>(r2, r4)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r2 = r6.getProtocol()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r2 == 0) goto L_0x01d5
            java.lang.String r7 = "http"
            boolean r7 = r2.equals(r7)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r7 != 0) goto L_0x01b5
            java.lang.String r7 = "https"
            boolean r7 = r2.equals(r7)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r7 != 0) goto L_0x01b5
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r1 = "Unsupported scheme: "
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r3 == 0) goto L_0x01ab
            java.lang.String r1 = r1.concat(r2)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            goto L_0x01b1
        L_0x01ab:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r1 = r2
        L_0x01b1:
            r0.<init>(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            throw r0     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
        L_0x01b5:
            java.lang.String r2 = "Redirecting to "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            int r7 = r4.length()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            if (r7 == 0) goto L_0x01c6
            java.lang.String r2 = r2.concat(r4)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            goto L_0x01cc
        L_0x01c6:
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r2 = r4
        L_0x01cc:
            com.google.android.gms.internal.ads.zzaxv.zzee(r2)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r5.disconnect()     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            r2 = r6
            goto L_0x0149
        L_0x01d5:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r1 = "Protocol is null"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            throw r0     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
        L_0x01dd:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            java.lang.String r1 = "Missing Location header in redirect"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
            throw r0     // Catch:{ IOException -> 0x01e7, RuntimeException -> 0x01e5 }
        L_0x01e5:
            r0 = move-exception
            goto L_0x01e8
        L_0x01e7:
            r0 = move-exception
        L_0x01e8:
            r2 = r10
        L_0x01e9:
            r1 = r14
            goto L_0x052a
        L_0x01ec:
            boolean r1 = r5 instanceof java.net.HttpURLConnection
            if (r1 == 0) goto L_0x0245
            r1 = r5
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1
            int r1 = r1.getResponseCode()
            r2 = 400(0x190, float:5.6E-43)
            if (r1 < r2) goto L_0x0245
            java.lang.String r15 = "badUrl"
            java.lang.String r0 = "HTTP request failed. Code: "
            java.lang.String r2 = java.lang.Integer.toString(r1)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x0213
            java.lang.String r0 = r0.concat(r2)
            r2 = r0
            goto L_0x0218
        L_0x0213:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r0)
        L_0x0218:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            java.lang.String r3 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            int r3 = r3.length()     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            int r3 = r3 + 32
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            java.lang.String r3 = "HTTP status code "
            r4.append(r3)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            r4.append(r1)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            java.lang.String r1 = " at "
            r4.append(r1)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            r4.append(r9)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
            throw r0     // Catch:{ IOException -> 0x0243, RuntimeException -> 0x0241 }
        L_0x0241:
            r0 = move-exception
            goto L_0x01e9
        L_0x0243:
            r0 = move-exception
            goto L_0x01e9
        L_0x0245:
            int r7 = r5.getContentLength()
            if (r7 >= 0) goto L_0x0274
            java.lang.String r0 = "Stream cache aborted, missing content-length header at "
            java.lang.String r1 = java.lang.String.valueOf(r31)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x025c
            java.lang.String r0 = r0.concat(r1)
            goto L_0x0262
        L_0x025c:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            r0 = r1
        L_0x0262:
            com.google.android.gms.internal.ads.zzaxv.zzfd(r0)
            java.lang.String r0 = r12.getAbsolutePath()
            java.lang.String r1 = "contentLengthMissing"
            r8.zza(r9, r0, r1, r10)
            java.util.Set<java.lang.String> r0 = com.google.android.gms.internal.ads.zzbez.zzekq
            r0.remove(r14)
            return r11
        L_0x0274:
            java.text.DecimalFormat r1 = com.google.android.gms.internal.ads.zzbez.zzekr
            long r2 = (long) r7
            java.lang.String r1 = r1.format(r2)
            com.google.android.gms.internal.ads.zzaag<java.lang.Integer> r2 = com.google.android.gms.internal.ads.zzaav.zzclv
            com.google.android.gms.internal.ads.zzaar r3 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r2 = r3.zzd(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            if (r7 <= r3) goto L_0x02e2
            java.lang.String r0 = java.lang.String.valueOf(r1)
            int r0 = r0.length()
            int r0 = r0 + 33
            java.lang.String r2 = java.lang.String.valueOf(r31)
            int r2 = r2.length()
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "Content length "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = " exceeds limit at "
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.internal.ads.zzaxv.zzfd(r0)
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x02cd
            java.lang.String r0 = r0.concat(r1)
            goto L_0x02d3
        L_0x02cd:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            r0 = r1
        L_0x02d3:
            java.lang.String r1 = r12.getAbsolutePath()
            java.lang.String r2 = "sizeExceeded"
            r8.zza(r9, r1, r2, r0)
            java.util.Set<java.lang.String> r0 = com.google.android.gms.internal.ads.zzbez.zzekq
            r0.remove(r14)
            return r11
        L_0x02e2:
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r2 = r2 + r4
            java.lang.String r4 = java.lang.String.valueOf(r31)
            int r4 = r4.length()
            int r2 = r2 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            java.lang.String r2 = "Caching "
            r4.append(r2)
            r4.append(r1)
            java.lang.String r1 = " bytes from "
            r4.append(r1)
            r4.append(r9)
            java.lang.String r1 = r4.toString()
            com.google.android.gms.internal.ads.zzaxv.zzee(r1)
            java.io.InputStream r1 = r5.getInputStream()
            java.nio.channels.ReadableByteChannel r5 = java.nio.channels.Channels.newChannel(r1)
            java.io.FileOutputStream r4 = new java.io.FileOutputStream
            r4.<init>(r12)
            java.nio.channels.FileChannel r2 = r4.getChannel()     // Catch:{ IOException -> 0x04fc, RuntimeException -> 0x04fa }
            r1 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ IOException -> 0x04fc, RuntimeException -> 0x04fa }
            com.google.android.gms.common.util.Clock r16 = com.google.android.gms.ads.internal.zzq.zzld()     // Catch:{ IOException -> 0x04fc, RuntimeException -> 0x04fa }
            long r17 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x04fc, RuntimeException -> 0x04fa }
            com.google.android.gms.internal.ads.zzaag<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzaav.zzcly     // Catch:{ IOException -> 0x04fc, RuntimeException -> 0x04fa }
            com.google.android.gms.internal.ads.zzaar r10 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ IOException -> 0x04fc, RuntimeException -> 0x04fa }
            java.lang.Object r6 = r10.zzd(r6)     // Catch:{ IOException -> 0x04fc, RuntimeException -> 0x04fa }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ IOException -> 0x04fc, RuntimeException -> 0x04fa }
            r10 = r14
            long r13 = r6.longValue()     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            com.google.android.gms.internal.ads.zzbag r6 = new com.google.android.gms.internal.ads.zzbag     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            r6.<init>(r13)     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            com.google.android.gms.internal.ads.zzaag<java.lang.Long> r13 = com.google.android.gms.internal.ads.zzaav.zzclx     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            com.google.android.gms.internal.ads.zzaar r14 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            java.lang.Object r13 = r14.zzd(r13)     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            long r13 = r13.longValue()     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
        L_0x0355:
            int r20 = r5.read(r1)     // Catch:{ IOException -> 0x04f5, RuntimeException -> 0x04f3 }
            if (r20 < 0) goto L_0x0471
            int r11 = r11 + r20
            if (r11 <= r3) goto L_0x0392
            java.lang.String r15 = "sizeExceeded"
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.Integer.toString(r11)     // Catch:{ IOException -> 0x038c, RuntimeException -> 0x038a }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x038c, RuntimeException -> 0x038a }
            int r2 = r1.length()     // Catch:{ IOException -> 0x038c, RuntimeException -> 0x038a }
            if (r2 == 0) goto L_0x0377
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x038c, RuntimeException -> 0x038a }
            r1 = r0
            goto L_0x037c
        L_0x0377:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x038c, RuntimeException -> 0x038a }
            r1.<init>(r0)     // Catch:{ IOException -> 0x038c, RuntimeException -> 0x038a }
        L_0x037c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0386, RuntimeException -> 0x0384 }
            java.lang.String r2 = "stream cache file size limit exceeded"
            r0.<init>(r2)     // Catch:{ IOException -> 0x0386, RuntimeException -> 0x0384 }
            throw r0     // Catch:{ IOException -> 0x0386, RuntimeException -> 0x0384 }
        L_0x0384:
            r0 = move-exception
            goto L_0x0387
        L_0x0386:
            r0 = move-exception
        L_0x0387:
            r2 = r1
            r1 = r10
            goto L_0x038f
        L_0x038a:
            r0 = move-exception
            goto L_0x038d
        L_0x038c:
            r0 = move-exception
        L_0x038d:
            r1 = r10
            r2 = 0
        L_0x038f:
            r10 = r4
            goto L_0x052a
        L_0x0392:
            r1.flip()     // Catch:{ IOException -> 0x0469, RuntimeException -> 0x0467 }
        L_0x0395:
            int r20 = r2.write(r1)     // Catch:{ IOException -> 0x0469, RuntimeException -> 0x0467 }
            if (r20 > 0) goto L_0x0395
            r1.clear()     // Catch:{ IOException -> 0x0469, RuntimeException -> 0x0467 }
            long r20 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x0469, RuntimeException -> 0x0467 }
            long r20 = r20 - r17
            r22 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 * r13
            int r24 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r24 > 0) goto L_0x0425
            r20 = r1
            boolean r1 = r8.zzeks     // Catch:{ IOException -> 0x0469, RuntimeException -> 0x0467 }
            if (r1 != 0) goto L_0x0415
            boolean r1 = r6.tryAcquire()     // Catch:{ IOException -> 0x0469, RuntimeException -> 0x0467 }
            if (r1 == 0) goto L_0x03ef
            java.lang.String r21 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x0469, RuntimeException -> 0x0467 }
            android.os.Handler r1 = com.google.android.gms.internal.ads.zzbaq.zzaag     // Catch:{ IOException -> 0x0469, RuntimeException -> 0x0467 }
            r22 = r15
            com.google.android.gms.internal.ads.zzber r15 = new com.google.android.gms.internal.ads.zzber     // Catch:{ IOException -> 0x03e9, RuntimeException -> 0x03e7 }
            r23 = 0
            r24 = r10
            r10 = r1
            r1 = r15
            r25 = r2
            r2 = r30
            r26 = r3
            r3 = r31
            r27 = r4
            r4 = r21
            r21 = r5
            r5 = r11
            r19 = r6
            r28 = 3
            r6 = r7
            r29 = r7
            r7 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x04bb, RuntimeException -> 0x04b9 }
            r10.post(r15)     // Catch:{ IOException -> 0x04bb, RuntimeException -> 0x04b9 }
            goto L_0x0401
        L_0x03e7:
            r0 = move-exception
            goto L_0x03ea
        L_0x03e9:
            r0 = move-exception
        L_0x03ea:
            r27 = r4
            r1 = r10
            goto L_0x04f0
        L_0x03ef:
            r25 = r2
            r26 = r3
            r27 = r4
            r21 = r5
            r19 = r6
            r29 = r7
            r24 = r10
            r22 = r15
            r28 = 3
        L_0x0401:
            r6 = r19
            r1 = r20
            r5 = r21
            r15 = r22
            r10 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r7 = r29
            goto L_0x0355
        L_0x0415:
            r27 = r4
            r24 = r10
            r22 = r15
            java.lang.String r15 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
            java.lang.String r1 = "abort requested"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
            throw r0     // Catch:{ IOException -> 0x0465, RuntimeException -> 0x0463 }
        L_0x0425:
            r27 = r4
            r24 = r10
            r22 = r15
            java.lang.String r15 = "downloadTimeout"
            java.lang.String r0 = java.lang.Long.toString(r13)
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 29
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Timeout exceeded. Limit: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = " sec"
            r2.append(r0)
            java.lang.String r10 = r2.toString()
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x045b, RuntimeException -> 0x0459 }
            java.lang.String r1 = "stream cache time limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x045b, RuntimeException -> 0x0459 }
            throw r0     // Catch:{ IOException -> 0x045b, RuntimeException -> 0x0459 }
        L_0x0459:
            r0 = move-exception
            goto L_0x045c
        L_0x045b:
            r0 = move-exception
        L_0x045c:
            r2 = r10
            r1 = r24
            r10 = r27
            goto L_0x052a
        L_0x0463:
            r0 = move-exception
            goto L_0x04be
        L_0x0465:
            r0 = move-exception
            goto L_0x04be
        L_0x0467:
            r0 = move-exception
            goto L_0x046a
        L_0x0469:
            r0 = move-exception
        L_0x046a:
            r27 = r4
            r22 = r15
            r1 = r10
            goto L_0x0502
        L_0x0471:
            r27 = r4
            r24 = r10
            r22 = r15
            r28 = 3
            r27.close()     // Catch:{ IOException -> 0x04ed, RuntimeException -> 0x04eb }
            boolean r1 = com.google.android.gms.internal.ads.zzaxv.isLoggable(r28)     // Catch:{ IOException -> 0x04ed, RuntimeException -> 0x04eb }
            if (r1 == 0) goto L_0x04c1
            java.text.DecimalFormat r1 = com.google.android.gms.internal.ads.zzbez.zzekr
            long r2 = (long) r11
            java.lang.String r1 = r1.format(r2)
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r2 = r2 + 22
            java.lang.String r3 = java.lang.String.valueOf(r31)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Preloaded "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = " bytes from "
            r3.append(r1)
            r3.append(r9)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzaxv.zzee(r1)
            goto L_0x04c1
        L_0x04b9:
            r0 = move-exception
            goto L_0x04bc
        L_0x04bb:
            r0 = move-exception
        L_0x04bc:
            r15 = r22
        L_0x04be:
            r1 = r24
            goto L_0x0502
        L_0x04c1:
            r1 = 1
            r2 = 0
            r12.setReadable(r1, r2)
            boolean r1 = r0.isFile()
            if (r1 == 0) goto L_0x04d4
            long r1 = java.lang.System.currentTimeMillis()
            r0.setLastModified(r1)
            goto L_0x04d7
        L_0x04d4:
            r0.createNewFile()     // Catch:{ IOException -> 0x04d7, RuntimeException -> 0x04b9 }
        L_0x04d7:
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zza(r9, r0, r11)
            java.util.Set<java.lang.String> r0 = com.google.android.gms.internal.ads.zzbez.zzekq
            r1 = r24
            r0.remove(r1)     // Catch:{ IOException -> 0x04e9, RuntimeException -> 0x04e7 }
            r0 = 1
            return r0
        L_0x04e7:
            r0 = move-exception
            goto L_0x04f0
        L_0x04e9:
            r0 = move-exception
            goto L_0x04f0
        L_0x04eb:
            r0 = move-exception
            goto L_0x04ee
        L_0x04ed:
            r0 = move-exception
        L_0x04ee:
            r1 = r24
        L_0x04f0:
            r15 = r22
            goto L_0x0502
        L_0x04f3:
            r0 = move-exception
            goto L_0x04f6
        L_0x04f5:
            r0 = move-exception
        L_0x04f6:
            r27 = r4
            r1 = r10
            goto L_0x0500
        L_0x04fa:
            r0 = move-exception
            goto L_0x04fd
        L_0x04fc:
            r0 = move-exception
        L_0x04fd:
            r27 = r4
            r1 = r14
        L_0x0500:
            r22 = r15
        L_0x0502:
            r10 = r27
            r2 = 0
            goto L_0x052a
        L_0x0506:
            r1 = r14
            r22 = r15
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x051e, RuntimeException -> 0x051c }
            java.lang.String r2 = "Invalid protocol."
            r0.<init>(r2)     // Catch:{ IOException -> 0x051e, RuntimeException -> 0x051c }
            throw r0     // Catch:{ IOException -> 0x051e, RuntimeException -> 0x051c }
        L_0x0511:
            r1 = r14
            r22 = r15
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x051e, RuntimeException -> 0x051c }
            java.lang.String r2 = "Too many redirects (20)"
            r0.<init>(r2)     // Catch:{ IOException -> 0x051e, RuntimeException -> 0x051c }
            throw r0     // Catch:{ IOException -> 0x051e, RuntimeException -> 0x051c }
        L_0x051c:
            r0 = move-exception
            goto L_0x051f
        L_0x051e:
            r0 = move-exception
        L_0x051f:
            r15 = r22
            goto L_0x0528
        L_0x0522:
            r0 = move-exception
            goto L_0x0525
        L_0x0524:
            r0 = move-exception
        L_0x0525:
            r1 = r14
            r22 = r15
        L_0x0528:
            r2 = 0
            r10 = 0
        L_0x052a:
            boolean r3 = r0 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x0537
            com.google.android.gms.internal.ads.zzaxh r3 = com.google.android.gms.ads.internal.zzq.zzla()
            java.lang.String r4 = "VideoStreamFullFileCache.preload"
            r3.zza(r0, r4)
        L_0x0537:
            r10.close()     // Catch:{ IOException | NullPointerException -> 0x053b }
            goto L_0x053c
        L_0x053b:
        L_0x053c:
            boolean r3 = r8.zzeks
            if (r3 == 0) goto L_0x0564
            java.lang.String r0 = java.lang.String.valueOf(r31)
            int r0 = r0.length()
            int r0 = r0 + 26
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = "Preload aborted for URL \""
            r3.append(r0)
            r3.append(r9)
            java.lang.String r0 = "\""
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.google.android.gms.internal.ads.zzaxv.zzfc(r0)
            goto L_0x0587
        L_0x0564:
            java.lang.String r3 = java.lang.String.valueOf(r31)
            int r3 = r3.length()
            int r3 = r3 + 25
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Preload failed for URL \""
            r4.append(r3)
            r4.append(r9)
            java.lang.String r3 = "\""
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.google.android.gms.internal.ads.zzaxv.zzd(r3, r0)
        L_0x0587:
            boolean r0 = r12.exists()
            if (r0 == 0) goto L_0x05b1
            boolean r0 = r12.delete()
            if (r0 != 0) goto L_0x05b1
            java.lang.String r0 = "Could not delete partial cache file at "
            java.lang.String r3 = r12.getAbsolutePath()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x05a8
            java.lang.String r0 = r0.concat(r3)
            goto L_0x05ae
        L_0x05a8:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r0)
            r0 = r3
        L_0x05ae:
            com.google.android.gms.internal.ads.zzaxv.zzfd(r0)
        L_0x05b1:
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zza(r9, r0, r15, r2)
            java.util.Set<java.lang.String> r0 = com.google.android.gms.internal.ads.zzbez.zzekq
            r0.remove(r1)
            r1 = 0
            return r1
        L_0x05bf:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbez.zzfm(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzbes
    public final void abort() {
        this.zzeks = true;
    }

    private final File zzd(File file) {
        return new File(this.zzcz, String.valueOf(file.getName()).concat(".done"));
    }
}
