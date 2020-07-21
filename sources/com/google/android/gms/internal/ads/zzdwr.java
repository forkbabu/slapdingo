package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebn;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdwr<P> {
    private static final Charset UTF_8 = Charset.forName(XmpWriter.UTF8);
    private final Class<P> zzhpl;
    private ConcurrentMap<String, List<zzdwu<P>>> zzhps = new ConcurrentHashMap();
    private zzdwu<P> zzhpt;

    public final zzdwu<P> zzaxr() {
        return this.zzhpt;
    }

    private zzdwr(Class<P> cls) {
        this.zzhpl = cls;
    }

    public static <P> zzdwr<P> zza(Class<P> cls) {
        return new zzdwr<>(cls);
    }

    public final void zza(zzdwu<P> zzdwu) {
        if (zzdwu == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        } else if (zzdwu.zzaxt() == zzebg.ENABLED) {
            List<zzdwu<P>> list = this.zzhps.get(new String(zzdwu.zzaxv(), UTF_8));
            if (list == null) {
                list = Collections.emptyList();
            }
            if (!list.isEmpty()) {
                this.zzhpt = zzdwu;
                return;
            }
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        } else {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
    }

    public final zzdwu<P> zza(P p, zzebn.zzb zzb) throws GeneralSecurityException {
        byte[] bArr;
        if (zzb.zzaxt() == zzebg.ENABLED) {
            int i = zzdwd.zzhpi[zzb.zzaxu().ordinal()];
            if (i == 1 || i == 2) {
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzb.zzbbk()).array();
            } else if (i == 3) {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzb.zzbbk()).array();
            } else if (i == 4) {
                bArr = zzdwe.zzhpj;
            } else {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            zzdwu<P> zzdwu = new zzdwu<>(p, bArr, zzb.zzaxt(), zzb.zzaxu(), zzb.zzbbk());
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzdwu);
            String str = new String(zzdwu.zzaxv(), UTF_8);
            List<zzdwu<P>> put = this.zzhps.put(str, Collections.unmodifiableList(arrayList));
            if (put != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(put);
                arrayList2.add(zzdwu);
                this.zzhps.put(str, Collections.unmodifiableList(arrayList2));
            }
            return zzdwu;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    public final Class<P> zzaxi() {
        return this.zzhpl;
    }
}
