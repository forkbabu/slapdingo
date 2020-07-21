package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzekg implements zzbp {
    private static zzeks zzdc = zzeks.zzn(zzekg.class);
    private String type;
    private long zzawn;
    private zzbs zzior;
    boolean zzios;
    private boolean zziot;
    private ByteBuffer zziou;
    private long zziov;
    private long zziow = -1;
    private zzekm zziox;
    private ByteBuffer zzioy = null;

    private final synchronized void zzbjb() {
        if (!this.zziot) {
            try {
                zzeks zzeks = zzdc;
                String valueOf = String.valueOf(this.type);
                zzeks.zzii(valueOf.length() != 0 ? "mem mapping ".concat(valueOf) : new String("mem mapping "));
                this.zziou = this.zziox.zzh(this.zziov, this.zziow);
                this.zziot = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzl(ByteBuffer byteBuffer);

    protected zzekg(String str) {
        this.type = str;
        this.zziot = true;
        this.zzios = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void zza(zzekm zzekm, ByteBuffer byteBuffer, long j, zzbo zzbo) throws IOException {
        long position = zzekm.position();
        this.zziov = position;
        this.zzawn = position - ((long) byteBuffer.remaining());
        this.zziow = j;
        this.zziox = zzekm;
        zzekm.zzfc(zzekm.position() + j);
        this.zziot = false;
        this.zzios = false;
        zzbjc();
    }

    public final synchronized void zzbjc() {
        zzbjb();
        zzeks zzeks = zzdc;
        String valueOf = String.valueOf(this.type);
        zzeks.zzii(valueOf.length() != 0 ? "parsing details of ".concat(valueOf) : new String("parsing details of "));
        if (this.zziou != null) {
            ByteBuffer byteBuffer = this.zziou;
            this.zzios = true;
            byteBuffer.rewind();
            zzl(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zzioy = byteBuffer.slice();
            }
            this.zziou = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void zza(zzbs zzbs) {
        this.zzior = zzbs;
    }
}
