package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebf;
import com.google.android.gms.internal.ads.zzehl;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzdwj<KeyProtoT extends zzehl> {
    private final Class<KeyProtoT> zzhpm;
    private final Map<Class<?>, zzdwl<?, KeyProtoT>> zzhpn;
    private final Class<?> zzhpo;

    @SafeVarargs
    protected zzdwj(Class<KeyProtoT> cls, zzdwl<?, KeyProtoT>... zzdwlArr) {
        this.zzhpm = cls;
        HashMap hashMap = new HashMap();
        int length = zzdwlArr.length;
        int i = 0;
        while (i < length) {
            zzdwl<?, KeyProtoT> zzdwl = zzdwlArr[i];
            if (hashMap.containsKey(zzdwl.zzaxi())) {
                String valueOf = String.valueOf(zzdwl.zzaxi().getCanonicalName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            } else {
                hashMap.put(zzdwl.zzaxi(), zzdwl);
                i++;
            }
        }
        if (zzdwlArr.length > 0) {
            this.zzhpo = zzdwlArr[0].zzaxi();
        } else {
            this.zzhpo = Void.class;
        }
        this.zzhpn = Collections.unmodifiableMap(hashMap);
    }

    public abstract String getKeyType();

    public abstract zzebf.zza zzaxl();

    public abstract void zzc(KeyProtoT keyprotot) throws GeneralSecurityException;

    public abstract KeyProtoT zzp(zzeer zzeer) throws zzegl;

    public final Class<KeyProtoT> zzaxk() {
        return this.zzhpm;
    }

    public final <P> P zza(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        zzdwl<?, KeyProtoT> zzdwl = this.zzhpn.get(cls);
        if (zzdwl != null) {
            return zzdwl.zzag(keyprotot);
        }
        String canonicalName = cls.getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 41);
        sb.append("Requested primitive class ");
        sb.append(canonicalName);
        sb.append(" not supported.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final Set<Class<?>> zzaxm() {
        return this.zzhpn.keySet();
    }

    /* access modifiers changed from: package-private */
    public final Class<?> zzaxn() {
        return this.zzhpo;
    }

    public zzdwm<?, KeyProtoT> zzaxo() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }
}
