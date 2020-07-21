package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzekk implements zzbs, Closeable, Iterator<zzbp> {
    private static zzeks zzdc = zzeks.zzn(zzekk.class);
    private static final zzbp zzipa = new zzekj("eof ");
    long zzasm = 0;
    long zzbfs = 0;
    protected zzekm zziox;
    protected zzbo zzipb;
    private zzbp zzipc = null;
    long zzipd = 0;
    private List<zzbp> zzipe = new ArrayList();

    public final List<zzbp> zzbjd() {
        if (this.zziox == null || this.zzipc == zzipa) {
            return this.zzipe;
        }
        return new zzekq(this.zzipe, this);
    }

    public void zza(zzekm zzekm, long j, zzbo zzbo) throws IOException {
        this.zziox = zzekm;
        long position = zzekm.position();
        this.zzbfs = position;
        this.zzipd = position;
        zzekm.zzfc(zzekm.position() + j);
        this.zzasm = zzekm.position();
        this.zzipb = zzbo;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
        zzbp zzbp = this.zzipc;
        if (zzbp == zzipa) {
            return false;
        }
        if (zzbp != null) {
            return true;
        }
        try {
            this.zzipc = (zzbp) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzipc = zzipa;
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzbje */
    public final zzbp next() {
        zzbp zza;
        zzbp zzbp = this.zzipc;
        if (zzbp == null || zzbp == zzipa) {
            zzekm zzekm = this.zziox;
            if (zzekm == null || this.zzipd >= this.zzasm) {
                this.zzipc = zzipa;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzekm) {
                    this.zziox.zzfc(this.zzipd);
                    zza = this.zzipb.zza(this.zziox, this);
                    this.zzipd = this.zziox.position();
                }
                return zza;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zzipc = null;
            return zzbp;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zzipe.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.zzipe.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zziox.close();
    }
}
