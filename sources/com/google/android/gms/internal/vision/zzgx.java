package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import com.google.android.gms.internal.vision.zzgx.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public abstract class zzgx<MessageType extends zzgx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzey<MessageType, BuilderType> {
    private static Map<Object, zzgx<?, ?>> zzwu = new ConcurrentHashMap();
    protected zzjr zzws = zzjr.zzih();
    private int zzwt = -1;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static class zzc<T extends zzgx<T, ?>> extends zzfd<T> {
        private final T zzwp;

        public zzc(T t) {
            this.zzwp = t;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzf {
        public static final int zzxa = 1;
        public static final int zzxb = 2;
        public static final int zzxc = 3;
        public static final int zzxd = 4;
        public static final int zzxe = 5;
        public static final int zzxf = 6;
        public static final int zzxg = 7;
        private static final /* synthetic */ int[] zzxh = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzxi = 1;
        public static final int zzxj = 2;
        private static final /* synthetic */ int[] zzxk = {1, 2};
        public static final int zzxl = 1;
        public static final int zzxm = 2;
        private static final /* synthetic */ int[] zzxn = {1, 2};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzxh.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static abstract class zzb<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzij {
        protected zzb(MessageType messagetype) {
            super(messagetype);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.vision.zzgx.zza
        public void zzfz() {
            super.zzfz();
            ((zze) this.zzwq).zzwz = (zzgn) ((zze) this.zzwq).zzwz.clone();
        }

        @Override // com.google.android.gms.internal.vision.zzgx.zza
        public /* synthetic */ zzgx zzga() {
            return (zze) zzgc();
        }

        @Override // com.google.android.gms.internal.vision.zzig, com.google.android.gms.internal.vision.zzgx.zza
        public /* synthetic */ zzih zzgc() {
            if (this.zzwr) {
                return (zze) this.zzwq;
            }
            ((zze) this.zzwq).zzwz.zzdq();
            return super.zzgc();
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgx<MessageType, BuilderType> implements zzij {
        protected zzgn<zzd> zzwz = zzgn.zzfo();

        /* access modifiers changed from: package-private */
        public final zzgn<zzd> zzgl() {
            if (this.zzwz.isImmutable()) {
                this.zzwz = (zzgn) this.zzwz.clone();
            }
            return this.zzwz;
        }

        public final <Type> Type zzc(zzgj<MessageType, Type> zzgj) {
            zzg zzb = zzgx.zza(zzgj);
            if (zzb.zzxo == zzge()) {
                Type<Object> zza = this.zzwz.zza(zzb.zzxq);
                if (zza == null) {
                    return zzb.zzgl;
                }
                if (!zzb.zzxq.zzwx) {
                    return zzb.zzj(zza);
                }
                if (zzb.zzxq.zzww.zziq() != zzki.ENUM) {
                    return zza;
                }
                Type arrayList = new ArrayList();
                for (Object obj : zza) {
                    arrayList.add(zzb.zzj(obj));
                }
                return arrayList;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    public String toString() {
        return zzii.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzrx != 0) {
            return this.zzrx;
        }
        this.zzrx = zzis.zzhp().zzv(this).hashCode(this);
        return this.zzrx;
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    static final class zzd implements zzgp<zzd> {
        final int number = 202056002;
        final zzha<?> zzwv = null;
        final zzkf zzww;
        final boolean zzwx;
        final boolean zzwy;

        zzd(zzha<?> zzha, int i, zzkf zzkf, boolean z, boolean z2) {
            this.zzww = zzkf;
            this.zzwx = true;
            this.zzwy = false;
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final int zzah() {
            return this.number;
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final zzkf zzft() {
            return this.zzww;
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final zzki zzfu() {
            return this.zzww.zziq();
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final boolean zzfv() {
            return this.zzwx;
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final boolean zzfw() {
            return this.zzwy;
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final zzig zza(zzig zzig, zzih zzih) {
            return ((zza) zzig).zza((zzgx) ((zzgx) zzih));
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final zzim zza(zzim zzim, zzim zzim2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            return this.number - ((zzd) obj).number;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static abstract class zza<MessageType extends zzgx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzfb<MessageType, BuilderType> {
        private final MessageType zzwp;
        protected MessageType zzwq;
        protected boolean zzwr = false;

        protected zza(MessageType messagetype) {
            this.zzwp = messagetype;
            this.zzwq = messagetype.zza(zzf.zzxd, null, null);
        }

        /* access modifiers changed from: protected */
        public void zzfz() {
            MessageType zza = this.zzwq.zza(zzf.zzxd, null, null);
            zza((zzgx) zza, (zzgx) this.zzwq);
            this.zzwq = zza;
        }

        @Override // com.google.android.gms.internal.vision.zzij
        public final boolean isInitialized() {
            return zzgx.zza((zzgx) this.zzwq, false);
        }

        /* renamed from: zzga */
        public MessageType zzgc() {
            if (this.zzwr) {
                return this.zzwq;
            }
            MessageType messagetype = this.zzwq;
            zzis.zzhp().zzv(messagetype).zzh(messagetype);
            this.zzwr = true;
            return this.zzwq;
        }

        /* renamed from: zzgb */
        public final MessageType zzgd() {
            MessageType zzgc = zzgc();
            if (zzgc.isInitialized()) {
                return zzgc;
            }
            throw new zzjp(zzgc);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzwr) {
                zzfz();
                this.zzwr = false;
            }
            zza((zzgx) this.zzwq, (zzgx) messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzis.zzhp().zzv(messagetype).zzd(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzgi zzgi) throws zzhh {
            if (this.zzwr) {
                zzfz();
                this.zzwr = false;
            }
            try {
                zzis.zzhp().zzv(this.zzwq).zza(this.zzwq, bArr, 0, i2 + 0, new zzfg(zzgi));
                return this;
            } catch (zzhh e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzhh.zzgn();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzfy zzfy, zzgi zzgi) throws IOException {
            if (this.zzwr) {
                zzfz();
                this.zzwr = false;
            }
            try {
                zzis.zzhp().zzv(this.zzwq).zza(this.zzwq, zzgd.zza(zzfy), zzgi);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.vision.zzfb
        public final /* synthetic */ zzfb zza(zzey zzey) {
            return zza((zzgx) ((zzgx) zzey));
        }

        @Override // com.google.android.gms.internal.vision.zzfb
        public final /* synthetic */ zzfb zza(byte[] bArr, int i, int i2, zzgi zzgi) throws zzhh {
            return zzb(bArr, 0, i2, zzgi);
        }

        @Override // com.google.android.gms.internal.vision.zzfb
        public final /* synthetic */ zzfb zzdo() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.vision.zzij
        public final /* synthetic */ zzih zzge() {
            return this.zzwp;
        }

        @Override // com.google.android.gms.internal.vision.zzfb, java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.zzwp.zza(zzf.zzxe, null, null);
            zza.zza((zzgx) zzgc());
            return zza;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static class zzg<ContainingType extends zzih, Type> extends zzgj<ContainingType, Type> {
        final Type zzgl;
        final ContainingType zzxo;
        final zzih zzxp;
        final zzd zzxq;

        zzg(ContainingType containingtype, Type type, zzih zzih, zzd zzd, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (zzd.zzww == zzkf.MESSAGE && zzih == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.zzxo = containingtype;
                this.zzgl = type;
                this.zzxp = zzih;
                this.zzxq = zzd;
            }
        }

        /* access modifiers changed from: package-private */
        public final Object zzj(Object obj) {
            return this.zzxq.zzww.zziq() == zzki.ENUM ? this.zzxq.zzwv.zzh(((Integer) obj).intValue()) : obj;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzis.zzhp().zzv(this).equals(this, (zzgx) obj);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzgx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzgf() {
        return zza(zzf.zzxe, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.vision.zzij
    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzey
    public final int zzdm() {
        return this.zzwt;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzey
    public final void zzae(int i) {
        this.zzwt = i;
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final void zzb(zzgf zzgf) throws IOException {
        zzis.zzhp().zzv(this).zza(this, zzgh.zza(zzgf));
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final int zzgg() {
        if (this.zzwt == -1) {
            this.zzwt = zzis.zzhp().zzv(this).zzs(this);
        }
        return this.zzwt;
    }

    static <T extends zzgx<?, ?>> T zzd(Class<T> cls) {
        T t = zzwu.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = zzwu.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = ((zzgx) zzju.zzh(cls)).zza(zzf.zzxf, (Object) null, (Object) null);
            if (t != null) {
                zzwu.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzgx<?, ?>> void zza(Class<T> cls, T t) {
        zzwu.put(cls, t);
    }

    protected static Object zza(zzih zzih, String str, Object[] objArr) {
        return new zziu(zzih, str, objArr);
    }

    public static <ContainingType extends zzih, Type> zzg<ContainingType, Type> zza(ContainingType containingtype, zzih zzih, zzha<?> zzha, int i, zzkf zzkf, boolean z, Class cls) {
        return new zzg<>(containingtype, Collections.emptyList(), zzih, new zzd(null, 202056002, zzkf, true, false), cls);
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

    /* access modifiers changed from: private */
    public static <MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>, T> zzg<MessageType, T> zza(zzgj<MessageType, T> zzgj) {
        return (zzg) zzgj;
    }

    protected static final <T extends zzgx<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zzxa, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzu = zzis.zzhp().zzv(t).zzu(t);
        if (z) {
            t.zza(zzf.zzxb, zzu ? t : null, null);
        }
        return zzu;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.zzhc, com.google.android.gms.internal.vision.zzgz] */
    protected static zzhc zzgh() {
        return zzgz.zzgm();
    }

    protected static <E> zzhe<E> zzgi() {
        return zziv.zzhs();
    }

    protected static <E> zzhe<E> zza(zzhe<E> zzhe) {
        int size = zzhe.size();
        return zzhe.zzah(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzgx<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzgi zzgi) throws zzhh {
        T zza2 = t.zza(zzf.zzxd, null, null);
        try {
            zziw<T> zzv = zzis.zzhp().zzv(zza2);
            zzv.zza(zza2, bArr, 0, i2, new zzfg(zzgi));
            zzv.zzh(zza2);
            if (((zzgx) zza2).zzrx == 0) {
                return zza2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzhh) {
                throw ((zzhh) e.getCause());
            }
            throw new zzhh(e.getMessage()).zzg(zza2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzhh.zzgn().zzg(zza2);
        }
    }

    private static <T extends zzgx<T, ?>> T zzb(T t) throws zzhh {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzhh(new zzjp(t).getMessage()).zzg(t);
    }

    protected static <T extends zzgx<T, ?>> T zza(T t, byte[] bArr) throws zzhh {
        return zzb(zza(t, bArr, 0, bArr.length, zzgi.zzfm()));
    }

    protected static <T extends zzgx<T, ?>> T zza(T t, byte[] bArr, zzgi zzgi) throws zzhh {
        return zzb(zza(t, bArr, 0, bArr.length, zzgi));
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final /* synthetic */ zzig zzgj() {
        zza zza2 = (zza) zza(zzf.zzxe, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final /* synthetic */ zzig zzgk() {
        return (zza) zza(zzf.zzxe, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.vision.zzij
    public final /* synthetic */ zzih zzge() {
        return (zzgx) zza(zzf.zzxf, (Object) null, (Object) null);
    }
}
