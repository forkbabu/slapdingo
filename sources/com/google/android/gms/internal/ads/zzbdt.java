package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbdt implements zzok {
    private boolean isOpen;
    private Uri uri;
    private InputStream zzeiv;
    private final zzok zzeiw;
    private final zzoy<zzok> zzeix;
    private final zzbdw zzeiy;
    private final Context zzvr;

    public zzbdt(Context context, zzok zzok, zzoy<zzok> zzoy, zzbdw zzbdw) {
        this.zzvr = context;
        this.zzeiw = zzok;
        this.zzeix = zzoy;
        this.zzeiy = zzbdw;
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final void close() throws IOException {
        if (this.isOpen) {
            this.isOpen = false;
            this.uri = null;
            InputStream inputStream = this.zzeiv;
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
                this.zzeiv = null;
            } else {
                this.zzeiw.close();
            }
            zzoy<zzok> zzoy = this.zzeix;
            if (zzoy != null) {
                zzoy.zze(this);
                return;
            }
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x009f */
    @Override // com.google.android.gms.internal.ads.zzok
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzop r21) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "ms"
            java.lang.String r3 = "Cache connection took "
            boolean r4 = r1.isOpen
            if (r4 != 0) goto L_0x015e
            r4 = 1
            r1.isOpen = r4
            android.net.Uri r5 = r0.uri
            r1.uri = r5
            com.google.android.gms.internal.ads.zzoy<com.google.android.gms.internal.ads.zzok> r5 = r1.zzeix
            if (r5 == 0) goto L_0x001a
            r5.zza(r1, r0)
        L_0x001a:
            android.net.Uri r5 = r0.uri
            com.google.android.gms.internal.ads.zzsy r5 = com.google.android.gms.internal.ads.zzsy.zzd(r5)
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzaav.zzcsl
            com.google.android.gms.internal.ads.zzaar r7 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r6 = r7.zzd(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r7 = -1
            if (r6 == 0) goto L_0x0118
            if (r5 == 0) goto L_0x0136
            long r9 = r0.position
            r5.zzbvc = r9
            boolean r6 = r5.zzbvb
            if (r6 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzaag<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzaav.zzcsn
            com.google.android.gms.internal.ads.zzaar r9 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r6 = r9.zzd(r6)
            java.lang.Long r6 = (java.lang.Long) r6
            goto L_0x0057
        L_0x004b:
            com.google.android.gms.internal.ads.zzaag<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzaav.zzcsm
            com.google.android.gms.internal.ads.zzaar r9 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r6 = r9.zzd(r6)
            java.lang.Long r6 = (java.lang.Long) r6
        L_0x0057:
            long r9 = r6.longValue()
            com.google.android.gms.common.util.Clock r6 = com.google.android.gms.ads.internal.zzq.zzld()
            long r11 = r6.elapsedRealtime()
            com.google.android.gms.ads.internal.zzq.zzlq()
            android.content.Context r6 = r1.zzvr
            java.util.concurrent.Future r6 = com.google.android.gms.internal.ads.zztn.zza(r6, r5)
            r13 = 0
            r14 = 44
            java.util.concurrent.TimeUnit r15 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException | TimeoutException -> 0x00cd, InterruptedException -> 0x009f }
            java.lang.Object r9 = r6.get(r9, r15)     // Catch:{ ExecutionException | TimeoutException -> 0x00cd, InterruptedException -> 0x009f }
            java.io.InputStream r9 = (java.io.InputStream) r9     // Catch:{ ExecutionException | TimeoutException -> 0x00cd, InterruptedException -> 0x009f }
            r1.zzeiv = r9     // Catch:{ ExecutionException | TimeoutException -> 0x00cd, InterruptedException -> 0x009f }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzq.zzld()
            long r5 = r0.elapsedRealtime()
            long r5 = r5 - r11
            com.google.android.gms.internal.ads.zzbdw r0 = r1.zzeiy
            r0.zzb(r4, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r14)
            r0.append(r3)
            r0.append(r5)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzaxv.zzeh(r0)
            return r7
        L_0x009d:
            r0 = move-exception
            goto L_0x00f4
        L_0x009f:
            r6.cancel(r4)     // Catch:{ all -> 0x009d }
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x009d }
            r4.interrupt()     // Catch:{ all -> 0x009d }
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzq.zzld()
            long r6 = r4.elapsedRealtime()
            long r6 = r6 - r11
            com.google.android.gms.internal.ads.zzbdw r4 = r1.zzeiy
            r4.zzb(r13, r6)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r14)
            r4.append(r3)
            r4.append(r6)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.google.android.gms.internal.ads.zzaxv.zzeh(r2)
            goto L_0x0136
        L_0x00cd:
            r6.cancel(r4)
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzq.zzld()
            long r6 = r4.elapsedRealtime()
            long r6 = r6 - r11
            com.google.android.gms.internal.ads.zzbdw r4 = r1.zzeiy
            r4.zzb(r13, r6)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r14)
            r4.append(r3)
            r4.append(r6)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.google.android.gms.internal.ads.zzaxv.zzeh(r2)
            goto L_0x0136
        L_0x00f4:
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzq.zzld()
            long r4 = r4.elapsedRealtime()
            long r4 = r4 - r11
            com.google.android.gms.internal.ads.zzbdw r6 = r1.zzeiy
            r6.zzb(r13, r4)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r14)
            r6.append(r3)
            r6.append(r4)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            com.google.android.gms.internal.ads.zzaxv.zzeh(r2)
            throw r0
        L_0x0118:
            r2 = 0
            if (r5 == 0) goto L_0x0127
            long r2 = r0.position
            r5.zzbvc = r2
            com.google.android.gms.internal.ads.zzsq r2 = com.google.android.gms.ads.internal.zzq.zzlc()
            com.google.android.gms.internal.ads.zzsx r2 = r2.zza(r5)
        L_0x0127:
            if (r2 == 0) goto L_0x0136
            boolean r3 = r2.zzmv()
            if (r3 == 0) goto L_0x0136
            java.io.InputStream r0 = r2.zzmw()
            r1.zzeiv = r0
            return r7
        L_0x0136:
            if (r5 == 0) goto L_0x0157
            com.google.android.gms.internal.ads.zzop r2 = new com.google.android.gms.internal.ads.zzop
            java.lang.String r3 = r5.url
            android.net.Uri r10 = android.net.Uri.parse(r3)
            byte[] r11 = r0.zzbid
            long r12 = r0.zzbie
            long r14 = r0.position
            long r3 = r0.zzcp
            java.lang.String r5 = r0.zzcn
            int r0 = r0.flags
            r9 = r2
            r16 = r3
            r18 = r5
            r19 = r0
            r9.<init>(r10, r11, r12, r14, r16, r18, r19)
            r0 = r2
        L_0x0157:
            com.google.android.gms.internal.ads.zzok r2 = r1.zzeiw
            long r2 = r2.zza(r0)
            return r2
        L_0x015e:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Attempt to open an already open CacheDataSource."
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdt.zza(com.google.android.gms.internal.ads.zzop):long");
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.isOpen) {
            InputStream inputStream = this.zzeiv;
            if (inputStream != null) {
                i3 = inputStream.read(bArr, i, i2);
            } else {
                i3 = this.zzeiw.read(bArr, i, i2);
            }
            zzoy<zzok> zzoy = this.zzeix;
            if (zzoy != null) {
                zzoy.zzc(this, i3);
            }
            return i3;
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final Uri getUri() {
        return this.uri;
    }
}
