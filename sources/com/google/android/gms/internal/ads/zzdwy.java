package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebn;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdwy {
    private static final Logger logger = Logger.getLogger(zzdwy.class.getName());
    private static final ConcurrentMap<String, zzb> zzhqd = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zza> zzhqe = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zzhqf = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzdwb<?>> zzhqg = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzdwt<?>> zzhqh = new ConcurrentHashMap();

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    interface zza {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    interface zzb {
        Set<Class<?>> zzaxm();

        zzdwi<?> zzaxw();

        Class<?> zzaxx();

        Class<?> zzaxy();

        <P> zzdwi<P> zzb(Class<P> cls) throws GeneralSecurityException;
    }

    private static <KeyProtoT extends zzehl> zzb zza(zzdwj<KeyProtoT> zzdwj) {
        return new zzdxa(zzdwj);
    }

    private static <KeyProtoT extends zzehl> zza zzb(zzdwj<KeyProtoT> zzdwj) {
        return new zzdxb(zzdwj);
    }

    private static synchronized zzb zzhk(String str) throws GeneralSecurityException {
        zzb zzb2;
        synchronized (zzdwy.class) {
            if (!zzhqd.containsKey(str)) {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "No key manager found for key type ".concat(valueOf) : new String("No key manager found for key type "));
            }
            zzb2 = zzhqd.get(str);
        }
        return zzb2;
    }

    @Deprecated
    public static zzdwb<?> zzhl(String str) throws GeneralSecurityException {
        if (str != null) {
            zzdwb<?> zzdwb = zzhqg.get(str.toLowerCase());
            if (zzdwb != null) {
                return zzdwb;
            }
            String format = String.format("no catalogue found for %s. ", str);
            if (str.toLowerCase().startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
                format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
                format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkmac")) {
                format = String.valueOf(format).concat("Maybe call MacConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
            } else if (str.toLowerCase().startsWith("tink")) {
                format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    private static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0092, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void zza(java.lang.String r8, java.lang.Class<?> r9, boolean r10) throws java.security.GeneralSecurityException {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzdwy> r0 = com.google.android.gms.internal.ads.zzdwy.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.ads.zzdwy$zzb> r1 = com.google.android.gms.internal.ads.zzdwy.zzhqd     // Catch:{ all -> 0x0093 }
            boolean r1 = r1.containsKey(r8)     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)
            return
        L_0x000d:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.ads.zzdwy$zzb> r1 = com.google.android.gms.internal.ads.zzdwy.zzhqd
            java.lang.Object r1 = r1.get(r8)
            com.google.android.gms.internal.ads.zzdwy$zzb r1 = (com.google.android.gms.internal.ads.zzdwy.zzb) r1
            java.lang.Class r2 = r1.zzaxx()
            boolean r2 = r2.equals(r9)
            if (r2 != 0) goto L_0x0065
            java.util.logging.Logger r10 = com.google.android.gms.internal.ads.zzdwy.logger
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
            java.lang.String r3 = "com.google.crypto.tink.Registry"
            java.lang.String r4 = "ensureKeyManagerInsertable"
            java.lang.String r5 = "Attempted overwrite of a registered key manager for key type "
            java.lang.String r6 = java.lang.String.valueOf(r8)
            int r7 = r6.length()
            if (r7 == 0) goto L_0x0038
            java.lang.String r5 = r5.concat(r6)
            goto L_0x003e
        L_0x0038:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r5)
            r5 = r6
        L_0x003e:
            r10.logp(r2, r3, r4, r5)
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException
            java.lang.String r2 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r8
            r8 = 1
            java.lang.Class r1 = r1.zzaxx()
            java.lang.String r1 = r1.getName()
            r3[r8] = r1
            r8 = 2
            java.lang.String r9 = r9.getName()
            r3[r8] = r9
            java.lang.String r8 = java.lang.String.format(r2, r3)
            r10.<init>(r8)
            throw r10
        L_0x0065:
            if (r10 == 0) goto L_0x0091
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r9 = com.google.android.gms.internal.ads.zzdwy.zzhqf
            java.lang.Object r9 = r9.get(r8)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0091
            java.security.GeneralSecurityException r9 = new java.security.GeneralSecurityException
            java.lang.String r10 = "New keys are already disallowed for key type "
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r1 = r8.length()
            if (r1 == 0) goto L_0x0088
            java.lang.String r8 = r10.concat(r8)
            goto L_0x008d
        L_0x0088:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r10)
        L_0x008d:
            r9.<init>(r8)
            throw r9
        L_0x0091:
            monitor-exit(r0)
            return
        L_0x0093:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwy.zza(java.lang.String, java.lang.Class, boolean):void");
    }

    public static synchronized <P> void zza(zzdwi<P> zzdwi, boolean z) throws GeneralSecurityException {
        synchronized (zzdwy.class) {
            if (zzdwi != null) {
                String keyType = zzdwi.getKeyType();
                zza(keyType, zzdwi.getClass(), z);
                if (!zzhqd.containsKey(keyType)) {
                    zzhqd.put(keyType, new zzdwx(zzdwi));
                }
                zzhqf.put(keyType, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <KeyProtoT extends zzehl> void zza(zzdwj<KeyProtoT> zzdwj, boolean z) throws GeneralSecurityException {
        synchronized (zzdwy.class) {
            String keyType = zzdwj.getKeyType();
            zza(keyType, zzdwj.getClass(), true);
            if (!zzhqd.containsKey(keyType)) {
                zzhqd.put(keyType, zza(zzdwj));
                zzhqe.put(keyType, zzb(zzdwj));
            }
            zzhqf.put(keyType, true);
        }
    }

    public static synchronized <KeyProtoT extends zzehl, PublicKeyProtoT extends zzehl> void zza(zzdwv<KeyProtoT, PublicKeyProtoT> zzdwv, zzdwj<PublicKeyProtoT> zzdwj, boolean z) throws GeneralSecurityException {
        Class<?> zzaxy;
        synchronized (zzdwy.class) {
            String keyType = zzdwv.getKeyType();
            String keyType2 = zzdwj.getKeyType();
            zza(keyType, zzdwv.getClass(), true);
            zza(keyType2, zzdwj.getClass(), false);
            if (!keyType.equals(keyType2)) {
                if (zzhqd.containsKey(keyType) && (zzaxy = zzhqd.get(keyType).zzaxy()) != null) {
                    if (!zzaxy.equals(zzdwj.getClass())) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        StringBuilder sb = new StringBuilder(String.valueOf(keyType).length() + 96 + String.valueOf(keyType2).length());
                        sb.append("Attempted overwrite of a registered key manager for key type ");
                        sb.append(keyType);
                        sb.append(" with inconsistent public key type ");
                        sb.append(keyType2);
                        logger2.logp(level, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", sb.toString());
                        throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", zzdwv.getClass().getName(), zzaxy.getName(), zzdwj.getClass().getName()));
                    }
                }
                if (!zzhqd.containsKey(keyType) || zzhqd.get(keyType).zzaxy() == null) {
                    zzhqd.put(keyType, new zzdwz(zzdwv, zzdwj));
                    zzhqe.put(keyType, zzb(zzdwv));
                }
                zzhqf.put(keyType, true);
                if (!zzhqd.containsKey(keyType2)) {
                    zzhqd.put(keyType2, zza(zzdwj));
                }
                zzhqf.put(keyType2, false);
            } else {
                throw new GeneralSecurityException("Private and public key type must be different.");
            }
        }
    }

    public static synchronized <P> void zza(zzdwt<P> zzdwt) throws GeneralSecurityException {
        synchronized (zzdwy.class) {
            if (zzdwt != null) {
                Class<P> zzaxi = zzdwt.zzaxi();
                if (zzhqh.containsKey(zzaxi)) {
                    zzdwt<?> zzdwt2 = zzhqh.get(zzaxi);
                    if (!zzdwt.getClass().equals(zzdwt2.getClass())) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(zzaxi.toString());
                        logger2.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", valueOf.length() != 0 ? "Attempted overwrite of a registered SetWrapper for type ".concat(valueOf) : new String("Attempted overwrite of a registered SetWrapper for type "));
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", zzaxi.getName(), zzdwt2.getClass().getName(), zzdwt.getClass().getName()));
                    }
                }
                zzhqh.put(zzaxi, zzdwt);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    private static zzdwi<?> zzhm(String str) throws GeneralSecurityException {
        return zzhk(str).zzaxw();
    }

    /* JADX DEBUG: Type inference failed for r5v7. Raw type applied. Possible types: com.google.android.gms.internal.ads.zzdwi<?>, com.google.android.gms.internal.ads.zzdwi<P> */
    private static <P> zzdwi<P> zza(String str, Class<P> cls) throws GeneralSecurityException {
        zzb zzhk = zzhk(str);
        if (cls == null) {
            return zzhk.zzaxw();
        }
        if (zzhk.zzaxm().contains(cls)) {
            return zzhk.zzb(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzhk.zzaxx());
        Set<Class<?>> zzaxm = zzhk.zzaxm();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class<?> cls2 : zzaxm) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder(String.valueOf(name).length() + 77 + String.valueOf(valueOf).length() + String.valueOf(sb2).length());
        sb3.append("Primitive type ");
        sb3.append(name);
        sb3.append(" not supported by key manager of type ");
        sb3.append(valueOf);
        sb3.append(", supported primitives: ");
        sb3.append(sb2);
        throw new GeneralSecurityException(sb3.toString());
    }

    public static synchronized zzebf zza(zzebi zzebi) throws GeneralSecurityException {
        zzebf zzo;
        synchronized (zzdwy.class) {
            zzdwi<?> zzhm = zzhm(zzebi.zzbar());
            if (zzhqf.get(zzebi.zzbar()).booleanValue()) {
                zzo = zzhm.zzo(zzebi.zzbas());
            } else {
                String valueOf = String.valueOf(zzebi.zzbar());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzo;
    }

    public static synchronized zzehl zzb(zzebi zzebi) throws GeneralSecurityException {
        zzehl zzn;
        synchronized (zzdwy.class) {
            zzdwi<?> zzhm = zzhm(zzebi.zzbar());
            if (zzhqf.get(zzebi.zzbar()).booleanValue()) {
                zzn = zzhm.zzn(zzebi.zzbas());
            } else {
                String valueOf = String.valueOf(zzebi.zzbar());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzn;
    }

    public static <P> P zza(String str, zzehl zzehl, Class<P> cls) throws GeneralSecurityException {
        return zza(str, (Class) checkNotNull(cls)).zza(zzehl);
    }

    private static <P> P zza(String str, zzeer zzeer, Class<P> cls) throws GeneralSecurityException {
        return zza(str, cls).zzm(zzeer);
    }

    public static <P> P zza(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return zza(str, zzeer.zzu(bArr), (Class) checkNotNull(cls));
    }

    public static <P> zzdwr<P> zza(zzdwo zzdwo, zzdwi<P> zzdwi, Class<P> cls) throws GeneralSecurityException {
        Class cls2 = (Class) checkNotNull(cls);
        zzdxc.zzc(zzdwo.zzaxq());
        zzdwr<P> zza2 = zzdwr.zza(cls2);
        for (zzebn.zzb zzb2 : zzdwo.zzaxq().zzbbf()) {
            if (zzb2.zzaxt() == zzebg.ENABLED) {
                zzdwu<P> zza3 = zza2.zza(zza(zzb2.zzbbj().zzbar(), zzb2.zzbbj().zzbas(), cls2), zzb2);
                if (zzb2.zzbbk() == zzdwo.zzaxq().zzbbe()) {
                    zza2.zza(zza3);
                }
            }
        }
        return zza2;
    }

    public static <P> P zza(zzdwr<P> zzdwr) throws GeneralSecurityException {
        zzdwt<?> zzdwt = zzhqh.get(zzdwr.zzaxi());
        if (zzdwt != null) {
            return zzdwt.zza(zzdwr);
        }
        String valueOf = String.valueOf(zzdwr.zzaxi().getName());
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
    }
}
