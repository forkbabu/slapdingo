package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Log;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzor implements zzok {
    private static final Pattern zzbig = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzbih = new AtomicReference<>();
    private zzop zzbif;
    private final boolean zzbii;
    private final int zzbij;
    private final int zzbik;
    private final String zzbil;
    private final zzpk<String> zzbim = null;
    private final zzos zzbin;
    private final zzos zzbio;
    private final zzoy<? super zzor> zzbip;
    private HttpURLConnection zzbiq;
    private InputStream zzbir;
    private boolean zzbis;
    private long zzbit;
    private long zzbiu;
    private long zzbiv;
    private long zzcq;

    public zzor(String str, zzpk<String> zzpk, zzoy<? super zzor> zzoy, int i, int i2, boolean z, zzos zzos) {
        this.zzbil = zzpb.checkNotEmpty(str);
        this.zzbip = zzoy;
        this.zzbio = new zzos();
        this.zzbij = i;
        this.zzbik = i2;
        this.zzbii = true;
        this.zzbin = null;
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.zzbiq;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.zzbiq;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final long zza(zzop zzop) throws zzoq {
        HttpURLConnection httpURLConnection;
        HttpURLConnection zza;
        this.zzbif = zzop;
        long j = 0;
        this.zzcq = 0;
        this.zzbiv = 0;
        try {
            URL url = new URL(zzop.uri.toString());
            byte[] bArr = zzop.zzbid;
            long j2 = zzop.position;
            long j3 = zzop.zzcp;
            boolean isFlagSet = zzop.isFlagSet(1);
            if (!this.zzbii) {
                httpURLConnection = zza(url, bArr, j2, j3, isFlagSet, true);
            } else {
                URL url2 = url;
                byte[] bArr2 = bArr;
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i <= 20) {
                        zza = zza(url2, bArr2, j2, j3, isFlagSet, false);
                        int responseCode = zza.getResponseCode();
                        if (!(responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303)) {
                            if (bArr2 == null) {
                                if (responseCode != 307) {
                                    if (responseCode != 308) {
                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                        bArr2 = null;
                        String headerField = zza.getHeaderField("Location");
                        zza.disconnect();
                        if (headerField != null) {
                            url2 = new URL(url2, headerField);
                            String protocol = url2.getProtocol();
                            if ("https".equals(protocol) || "http".equals(protocol)) {
                                i = i2;
                                j3 = j3;
                                j2 = j2;
                            } else {
                                String valueOf = String.valueOf(protocol);
                                throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
                            }
                        } else {
                            throw new ProtocolException("Null location redirect");
                        }
                    } else {
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("Too many redirects: ");
                        sb.append(i2);
                        throw new NoRouteToHostException(sb.toString());
                    }
                }
                httpURLConnection = zza;
            }
            this.zzbiq = httpURLConnection;
            try {
                int responseCode2 = httpURLConnection.getResponseCode();
                if (responseCode2 < 200 || responseCode2 > 299) {
                    Map<String, List<String>> headerFields = this.zzbiq.getHeaderFields();
                    zziq();
                    zzot zzot = new zzot(responseCode2, headerFields, zzop);
                    if (responseCode2 == 416) {
                        zzot.initCause(new zzom(0));
                    }
                    throw zzot;
                }
                this.zzbiq.getContentType();
                if (responseCode2 == 200 && zzop.position != 0) {
                    j = zzop.position;
                }
                this.zzbit = j;
                if (!zzop.isFlagSet(1)) {
                    long j4 = -1;
                    if (zzop.zzcp != -1) {
                        this.zzbiu = zzop.zzcp;
                    } else {
                        long zzc = zzc(this.zzbiq);
                        if (zzc != -1) {
                            j4 = zzc - this.zzbit;
                        }
                        this.zzbiu = j4;
                    }
                } else {
                    this.zzbiu = zzop.zzcp;
                }
                try {
                    this.zzbir = this.zzbiq.getInputStream();
                    this.zzbis = true;
                    zzoy<? super zzor> zzoy = this.zzbip;
                    if (zzoy != null) {
                        zzoy.zza(this, zzop);
                    }
                    return this.zzbiu;
                } catch (IOException e) {
                    zziq();
                    throw new zzoq(e, zzop, 1);
                }
            } catch (IOException e2) {
                zziq();
                String valueOf2 = String.valueOf(zzop.uri.toString());
                throw new zzoq(valueOf2.length() != 0 ? "Unable to connect to ".concat(valueOf2) : new String("Unable to connect to "), e2, zzop, 1);
            }
        } catch (IOException e3) {
            String valueOf3 = String.valueOf(zzop.uri.toString());
            throw new zzoq(valueOf3.length() != 0 ? "Unable to connect to ".concat(valueOf3) : new String("Unable to connect to "), e3, zzop, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final int read(byte[] bArr, int i, int i2) throws zzoq {
        try {
            if (this.zzbiv != this.zzbit) {
                byte[] andSet = zzbih.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.zzbiv != this.zzbit) {
                    int read = this.zzbir.read(andSet, 0, (int) Math.min(this.zzbit - this.zzbiv, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzbiv += (long) read;
                        if (this.zzbip != null) {
                            this.zzbip.zzc(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                zzbih.set(andSet);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.zzbiu != -1) {
                long j = this.zzbiu - this.zzcq;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j);
            }
            int read2 = this.zzbir.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzcq += (long) read2;
                if (this.zzbip != null) {
                    this.zzbip.zzc(this, read2);
                }
                return read2;
            } else if (this.zzbiu == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzoq(e, this.zzbif, 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r3 > android.support.v4.media.session.PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) goto L_0x003a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006b */
    @Override // com.google.android.gms.internal.ads.zzok
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() throws com.google.android.gms.internal.ads.zzoq {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzbir     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x007b
            java.net.HttpURLConnection r2 = r9.zzbiq     // Catch:{ all -> 0x008e }
            long r3 = r9.zzbiu     // Catch:{ all -> 0x008e }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0013
            long r3 = r9.zzbiu     // Catch:{ all -> 0x008e }
            goto L_0x0018
        L_0x0013:
            long r3 = r9.zzbiu     // Catch:{ all -> 0x008e }
            long r7 = r9.zzcq     // Catch:{ all -> 0x008e }
            long r3 = r3 - r7
        L_0x0018:
            int r7 = com.google.android.gms.internal.ads.zzpo.SDK_INT     // Catch:{ all -> 0x008e }
            r8 = 19
            if (r7 == r8) goto L_0x0024
            int r7 = com.google.android.gms.internal.ads.zzpo.SDK_INT     // Catch:{ all -> 0x008e }
            r8 = 20
            if (r7 != r8) goto L_0x006b
        L_0x0024:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x006b }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0034
            int r3 = r2.read()     // Catch:{ Exception -> 0x006b }
            r4 = -1
            if (r3 != r4) goto L_0x003a
            goto L_0x006b
        L_0x0034:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x006b
        L_0x003a:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x006b }
            if (r4 != 0) goto L_0x0052
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x006b }
            if (r3 == 0) goto L_0x006b
        L_0x0052:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006b }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x006b }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x006b }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x006b }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x006b }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            java.io.InputStream r2 = r9.zzbir     // Catch:{ IOException -> 0x0071 }
            r2.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x007b
        L_0x0071:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzoq r3 = new com.google.android.gms.internal.ads.zzoq
            com.google.android.gms.internal.ads.zzop r4 = r9.zzbif
            r5 = 3
            r3.<init>(r2, r4, r5)
            throw r3
        L_0x007b:
            r9.zzbir = r0
            r9.zziq()
            boolean r0 = r9.zzbis
            if (r0 == 0) goto L_0x008d
            r9.zzbis = r1
            com.google.android.gms.internal.ads.zzoy<? super com.google.android.gms.internal.ads.zzor> r0 = r9.zzbip
            if (r0 == 0) goto L_0x008d
            r0.zze(r9)
        L_0x008d:
            return
        L_0x008e:
            r2 = move-exception
            r9.zzbir = r0
            r9.zziq()
            boolean r0 = r9.zzbis
            if (r0 == 0) goto L_0x00a1
            r9.zzbis = r1
            com.google.android.gms.internal.ads.zzoy<? super com.google.android.gms.internal.ads.zzor> r0 = r9.zzbip
            if (r0 == 0) goto L_0x00a1
            r0.zze(r9)
        L_0x00a1:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzor.close():void");
    }

    private final HttpURLConnection zza(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzbij);
        httpURLConnection.setReadTimeout(this.zzbik);
        for (Map.Entry<String, String> entry : this.zzbio.zzir().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb3.append(valueOf);
                sb3.append((j + j2) - 1);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty("Range", sb2);
        }
        httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, this.zzbil);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zzc(java.net.HttpURLConnection r10) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r10.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            java.lang.String r3 = "DefaultHttpDataSource"
            if (r1 != 0) goto L_0x0036
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0015 }
            goto L_0x0038
        L_0x0015:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 28
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r4.append(r1)
            r4.append(r0)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            android.util.Log.e(r3, r1)
        L_0x0036:
            r4 = -1
        L_0x0038:
            java.lang.String r1 = "Content-Range"
            java.lang.String r10 = r10.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L_0x00cb
            java.util.regex.Pattern r1 = com.google.android.gms.internal.ads.zzor.zzbig
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r6 = r1.find()
            if (r6 == 0) goto L_0x00cb
            r6 = 2
            java.lang.String r6 = r1.group(r6)     // Catch:{ NumberFormatException -> 0x00aa }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x00aa }
            r8 = 1
            java.lang.String r1 = r1.group(r8)     // Catch:{ NumberFormatException -> 0x00aa }
            long r8 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x00aa }
            long r6 = r6 - r8
            r8 = 1
            long r6 = r6 + r8
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x006e
            r4 = r6
            goto L_0x00cb
        L_0x006e:
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x00cb
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00aa }
            int r1 = r1.length()     // Catch:{ NumberFormatException -> 0x00aa }
            int r1 = r1 + 26
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00aa }
            int r8 = r8.length()     // Catch:{ NumberFormatException -> 0x00aa }
            int r1 = r1 + r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00aa }
            r8.<init>(r1)     // Catch:{ NumberFormatException -> 0x00aa }
            java.lang.String r1 = "Inconsistent headers ["
            r8.append(r1)     // Catch:{ NumberFormatException -> 0x00aa }
            r8.append(r0)     // Catch:{ NumberFormatException -> 0x00aa }
            java.lang.String r0 = "] ["
            r8.append(r0)     // Catch:{ NumberFormatException -> 0x00aa }
            r8.append(r10)     // Catch:{ NumberFormatException -> 0x00aa }
            r8.append(r2)     // Catch:{ NumberFormatException -> 0x00aa }
            java.lang.String r0 = r8.toString()     // Catch:{ NumberFormatException -> 0x00aa }
            android.util.Log.w(r3, r0)     // Catch:{ NumberFormatException -> 0x00aa }
            long r0 = java.lang.Math.max(r4, r6)     // Catch:{ NumberFormatException -> 0x00aa }
            r4 = r0
            goto L_0x00cb
        L_0x00aa:
            java.lang.String r0 = java.lang.String.valueOf(r10)
            int r0 = r0.length()
            int r0 = r0 + 27
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r1.append(r0)
            r1.append(r10)
            r1.append(r2)
            java.lang.String r10 = r1.toString()
            android.util.Log.e(r3, r10)
        L_0x00cb:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzor.zzc(java.net.HttpURLConnection):long");
    }

    private final void zziq() {
        HttpURLConnection httpURLConnection = this.zzbiq;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.zzbiq = null;
        }
    }
}
