package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzib.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
public abstract class zzib<MessageType extends zzib<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzgj<MessageType, BuilderType> {
    private static Map<Object, zzib<?, ?>> zzd = new ConcurrentHashMap();
    protected zzkt zzb = zzkt.zza();
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
    public static class zzc<T extends zzib<T, ?>> extends zzgk<T> {
        private final T zza;

        public zzc(T t) {
            this.zza = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
    public static class zzd<ContainingType extends zzjj, Type> extends zzhm<ContainingType, Type> {
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
    static final class zze implements zzht<zze> {
        @Override // com.google.android.gms.internal.measurement.zzht
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzlh zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzlo zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzjm zza(zzjm zzjm, zzjj zzjj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzjs zza(zzjs zzjs, zzjs zzjs2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
    public static final class zzf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 1;
        public static final int zzi = 2;
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        private static final /* synthetic */ int[] zzm = {1, 2};
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzib<MessageType, BuilderType> implements zzjl {
        protected zzhr<zze> zzc = zzhr.zza();

        /* access modifiers changed from: package-private */
        public final zzhr<zze> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzhr) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public String toString() {
        return zzjo.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzjy.zza().zza(this).zza(this);
        return this.zza;
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
    public static abstract class zza<MessageType extends zzib<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzgi<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zza(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = messagetype.zza(zzf.zzd, null, null);
        }

        /* access modifiers changed from: protected */
        public void zzq() {
            MessageType zza2 = this.zza.zza(zzf.zzd, null, null);
            zza((zzib) zza2, (zzib) this.zza);
            this.zza = zza2;
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final boolean g_() {
            return zzib.zza((zzib) this.zza, false);
        }

        /* renamed from: zzs */
        public MessageType zzu() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzjy.zza().zza((Object) messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zzt */
        public final MessageType zzv() {
            MessageType zzu = zzu();
            if (zzu.g_()) {
                return zzu;
            }
            throw new zzkr(zzu);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            zza((zzib) this.zza, (zzib) messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzjy.zza().zza((Object) messagetype).zzb(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzho zzho) throws zzij {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzjy.zza().zza((Object) this.zza).zza(this.zza, bArr, 0, i2 + 0, new zzgo(zzho));
                return this;
            } catch (zzij e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzij.zza();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzhf zzhf, zzho zzho) throws IOException {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzjy.zza().zza((Object) this.zza).zza(this.zza, zzhg.zza(zzhf), zzho);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zza(zzgj zzgj) {
            return zza((zzib) ((zzib) zzgj));
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zza(byte[] bArr, int i, int i2, zzho zzho) throws zzij {
            return zzb(bArr, 0, i2, zzho);
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zza(byte[] bArr, int i, int i2) throws zzij {
            return zzb(bArr, 0, i2, zzho.zza());
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zzp() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final /* synthetic */ zzjj h_() {
            return this.zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzgi, java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza2 = (zza) this.zzc.zza(zzf.zze, null, null);
            zza2.zza((zzib) zzu());
            return zza2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzjy.zza().zza(this).zza(this, (zzib) obj);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzib<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzbk() {
        return zza(zzf.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final boolean g_() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzbl() {
        BuilderType zza2 = zza(zzf.zze, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzgj
    public final int zzbj() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzgj
    public final void zzc(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final void zza(zzhi zzhi) throws IOException {
        zzjy.zza().zza(this).zza((Object) this, (zzln) zzhl.zza(zzhi));
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final int zzbm() {
        if (this.zzc == -1) {
            this.zzc = zzjy.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    static <T extends zzib<?, ?>> T zza(Class<T> cls) {
        T t = zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = ((zzib) zzla.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzib<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzjj zzjj, String str, Object[] objArr) {
        return new zzka(zzjj, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzib<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zza, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzjy.zza().zza((Object) t).zzd(t);
        if (z) {
            t.zza(zzf.zzb, zzd2 ? t : null, null);
        }
        return zzd2;
    }

    protected static zzii zzbn() {
        return zzic.zzd();
    }

    protected static zzih zzbo() {
        return zzix.zzd();
    }

    protected static zzih zza(zzih zzih) {
        int size = zzih.size();
        return zzih.zzc(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzik<E> zzbp() {
        return zzjx.zzd();
    }

    protected static <E> zzik<E> zza(zzik<E> zzik) {
        int size = zzik.size();
        return zzik.zza(size == 0 ? 10 : size << 1);
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final /* synthetic */ zzjm zzbq() {
        zza zza2 = (zza) zza(zzf.zze, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final /* synthetic */ zzjm zzbr() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final /* synthetic */ zzjj h_() {
        return (zzib) zza(zzf.zzf, (Object) null, (Object) null);
    }
}
