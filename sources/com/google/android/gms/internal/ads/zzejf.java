package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzejf {
    private static final Logger logger = Logger.getLogger(zzejf.class.getName());
    private static final Unsafe zzhni = zzbhx();
    private static final Class<?> zzhzm = zzeek.zzbcx();
    private static final boolean zziay = zzbhy();
    private static final boolean zzijd = zzm(Long.TYPE);
    private static final boolean zzije = zzm(Integer.TYPE);
    private static final zzd zzijf;
    private static final boolean zzijg = zzbhz();
    private static final long zzijh = ((long) zzk(byte[].class));
    private static final long zziji = ((long) zzk(boolean[].class));
    private static final long zzijj = ((long) zzl(boolean[].class));
    private static final long zzijk = ((long) zzk(int[].class));
    private static final long zzijl = ((long) zzl(int[].class));
    private static final long zzijm = ((long) zzk(long[].class));
    private static final long zzijn = ((long) zzl(long[].class));
    private static final long zzijo = ((long) zzk(float[].class));
    private static final long zzijp = ((long) zzl(float[].class));
    private static final long zzijq = ((long) zzk(double[].class));
    private static final long zzijr = ((long) zzl(double[].class));
    private static final long zzijs = ((long) zzk(Object[].class));
    private static final long zzijt = ((long) zzl(Object[].class));
    private static final long zziju;
    private static final int zzijv = ((int) (zzijh & 7));
    static final boolean zzijw = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    private zzejf() {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final byte zzy(Object obj, long j) {
            if (zzejf.zzijw) {
                return zzejf.zzq(obj, j);
            }
            return zzejf.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzejf.zzijw) {
                zzejf.zza(obj, j, b);
            } else {
                zzejf.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final boolean zzm(Object obj, long j) {
            if (zzejf.zzijw) {
                return zzejf.zzs(obj, j);
            }
            return zzejf.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzejf.zzijw) {
                zzejf.zzb(obj, j, z);
            } else {
                zzejf.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final byte zzy(Object obj, long j) {
            return this.zzijz.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final void zze(Object obj, long j, byte b) {
            this.zzijz.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final boolean zzm(Object obj, long j) {
            return this.zzijz.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zzijz.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final float zzn(Object obj, long j) {
            return this.zzijz.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final void zza(Object obj, long j, float f) {
            this.zzijz.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final double zzo(Object obj, long j) {
            return this.zzijz.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final void zza(Object obj, long j, double d) {
            this.zzijz.putDouble(obj, j, d);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final byte zzy(Object obj, long j) {
            if (zzejf.zzijw) {
                return zzejf.zzq(obj, j);
            }
            return zzejf.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzejf.zzijw) {
                zzejf.zza(obj, j, b);
            } else {
                zzejf.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final boolean zzm(Object obj, long j) {
            if (zzejf.zzijw) {
                return zzejf.zzs(obj, j);
            }
            return zzejf.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzejf.zzijw) {
                zzejf.zzb(obj, j, z);
            } else {
                zzejf.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzejf.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static boolean zzbhv() {
        return zziay;
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    static abstract class zzd {
        Unsafe zzijz;

        zzd(Unsafe unsafe) {
            this.zzijz = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzijz.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzijz.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzijz.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzijz.putLong(obj, j, j2);
        }
    }

    static boolean zzbhw() {
        return zzijg;
    }

    static <T> T zzj(Class<T> cls) {
        try {
            return zzhni.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzk(Class<?> cls) {
        if (zziay) {
            return zzijf.zzijz.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzl(Class<?> cls) {
        if (zziay) {
            return zzijf.zzijz.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzijf.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzijf.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzijf.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzijf.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzijf.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzijf.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzijf.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzijf.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzijf.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzijf.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzijf.zzijz.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzijf.zzijz.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzijf.zzy(bArr, zzijh + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzijf.zze(bArr, zzijh + j, b);
    }

    static Unsafe zzbhx() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzejh());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzbhy() {
        Unsafe unsafe = zzhni;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzeek.zzbcw()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzbhz() {
        Unsafe unsafe = zzhni;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzbia() == null) {
                return false;
            }
            if (zzeek.zzbcw()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzm(Class<?> cls) {
        if (!zzeek.zzbcw()) {
            return false;
        }
        try {
            Class<?> cls2 = zzhzm;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field zzbia() {
        Field zzb2;
        if (zzeek.zzbcw() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzk = zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    static {
        zzd zzd2;
        zzd zzd3 = null;
        if (zzhni != null) {
            if (!zzeek.zzbcw()) {
                zzd3 = new zzb(zzhni);
            } else if (zzijd) {
                zzd3 = new zzc(zzhni);
            } else if (zzije) {
                zzd3 = new zza(zzhni);
            }
        }
        zzijf = zzd3;
        Field zzbia = zzbia();
        zziju = (zzbia == null || (zzd2 = zzijf) == null) ? -1 : zzd2.zzijz.objectFieldOffset(zzbia);
    }
}
