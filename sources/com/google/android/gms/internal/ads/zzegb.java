package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import com.google.android.gms.internal.ads.zzegb.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzegb<MessageType extends zzegb<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzeeh<MessageType, BuilderType> {
    private static Map<Object, zzegb<?, ?>> zziei = new ConcurrentHashMap();
    protected zzejc zzieg = zzejc.zzbhs();
    private int zzieh = -1;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public static class zza<T extends zzegb<T, ?>> extends zzeei<T> {
        private final T zziek;

        public zza(T t) {
            this.zziek = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    static final class zzc implements zzefw<zzc> {
        @Override // com.google.android.gms.internal.ads.zzefw
        public final int zzw() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzefw
        public final zzejq zzbex() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzefw
        public final zzejt zzbey() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzefw
        public final boolean zzbez() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzefw
        public final boolean zzbfa() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzefw
        public final zzeho zza(zzeho zzeho, zzehl zzehl) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzefw
        public final zzehu zza(zzehu zzehu, zzehu zzehu2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public static final class zze {
        public static final int zzieo = 1;
        public static final int zziep = 2;
        public static final int zzieq = 3;
        public static final int zzier = 4;
        public static final int zzies = 5;
        public static final int zziet = 6;
        public static final int zzieu = 7;
        private static final /* synthetic */ int[] zziev = {1, 2, 3, 4, 5, 6, 7};
        public static final int zziew = 1;
        public static final int zziex = 2;
        private static final /* synthetic */ int[] zziey = {1, 2};
        public static final int zziez = 1;
        public static final int zzifa = 2;
        private static final /* synthetic */ int[] zzifb = {1, 2};

        public static int[] zzbfs() {
            return (int[]) zziev.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public static class zzf<ContainingType extends zzehl, Type> extends zzefp<ContainingType, Type> {
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzegb<MessageType, BuilderType> implements zzehn {
        protected zzefu<zzc> zzien = zzefu.zzbev();

        /* access modifiers changed from: package-private */
        public final zzefu<zzc> zzbfr() {
            if (this.zzien.isImmutable()) {
                this.zzien = (zzefu) this.zzien.clone();
            }
            return this.zzien;
        }
    }

    public String toString() {
        return zzehq.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzhzi != 0) {
            return this.zzhzi;
        }
        this.zzhzi = zzeia.zzbgz().zzaw(this).hashCode(this);
        return this.zzhzi;
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public static abstract class zzb<MessageType extends zzegb<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzeeg<MessageType, BuilderType> {
        private final MessageType zziek;
        protected MessageType zziel;
        protected boolean zziem = false;

        protected zzb(MessageType messagetype) {
            this.zziek = messagetype;
            this.zziel = messagetype.zza(zze.zzier, null, null);
        }

        /* access modifiers changed from: protected */
        public void zzbfm() {
            MessageType zza = this.zziel.zza(zze.zzier, null, null);
            zza((zzegb) zza, (zzegb) this.zziel);
            this.zziel = zza;
        }

        @Override // com.google.android.gms.internal.ads.zzehn
        public final boolean isInitialized() {
            return zzegb.zza((zzegb) this.zziel, false);
        }

        /* renamed from: zzbfn */
        public MessageType zzbfp() {
            if (this.zziem) {
                return this.zziel;
            }
            MessageType messagetype = this.zziel;
            zzeia.zzbgz().zzaw(messagetype).zzaj(messagetype);
            this.zziem = true;
            return this.zziel;
        }

        /* renamed from: zzbfo */
        public final MessageType zzbfq() {
            MessageType zzbfp = zzbfp();
            if (zzbfp.isInitialized()) {
                return zzbfp;
            }
            throw new zzeja(zzbfp);
        }

        /* renamed from: zzb */
        public final BuilderType zza(MessageType messagetype) {
            if (this.zziem) {
                zzbfm();
                this.zziem = false;
            }
            zza((zzegb) this.zziel, (zzegb) messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzeia.zzbgz().zzaw(messagetype).zzg(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzefo zzefo) throws zzegl {
            if (this.zziem) {
                zzbfm();
                this.zziem = false;
            }
            try {
                zzeia.zzbgz().zzaw(this.zziel).zza(this.zziel, bArr, 0, i2 + 0, new zzeem(zzefo));
                return this;
            } catch (zzegl e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzegl.zzbfu();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzefc zzefc, zzefo zzefo) throws IOException {
            if (this.zziem) {
                zzbfm();
                this.zziem = false;
            }
            try {
                zzeia.zzbgz().zzaw(this.zziel).zza(this.zziel, zzefj.zza(zzefc), zzefo);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeeg
        public final /* synthetic */ zzeeg zza(byte[] bArr, int i, int i2, zzefo zzefo) throws zzegl {
            return zzb(bArr, 0, i2, zzefo);
        }

        @Override // com.google.android.gms.internal.ads.zzeeg
        public final /* synthetic */ zzeeg zzbcs() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.ads.zzehn
        public final /* synthetic */ zzehl zzbfk() {
            return this.zziek;
        }

        @Override // java.lang.Object, com.google.android.gms.internal.ads.zzeeg
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb = (zzb) this.zziek.zza(zze.zzies, null, null);
            zzb.zza(zzbfp());
            return zzb;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzeia.zzbgz().zzaw(this).equals(this, (zzegb) obj);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzegb<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbfc() {
        return zza(zze.zzies, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzehn
    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzbfd() {
        BuilderType zza2 = zza(zze.zzies, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeeh
    public final int zzbcu() {
        return this.zzieh;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeeh
    public final void zzfp(int i) {
        this.zzieh = i;
    }

    @Override // com.google.android.gms.internal.ads.zzehl
    public final void zzb(zzefl zzefl) throws IOException {
        zzeia.zzbgz().zzaw(this).zza(this, zzefn.zza(zzefl));
    }

    @Override // com.google.android.gms.internal.ads.zzehl
    public final int zzbfe() {
        if (this.zzieh == -1) {
            this.zzieh = zzeia.zzbgz().zzaw(this).zzat(this);
        }
        return this.zzieh;
    }

    static <T extends zzegb<?, ?>> T zzd(Class<T> cls) {
        T t = zziei.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = zziei.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = ((zzegb) zzejf.zzj(cls)).zza(zze.zziet, (Object) null, (Object) null);
            if (t != null) {
                zziei.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzegb<?, ?>> void zza(Class<T> cls, T t) {
        zziei.put(cls, t);
    }

    protected static Object zza(zzehl zzehl, String str, Object[] objArr) {
        return new zzeic(zzehl, str, objArr);
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

    protected static final <T extends zzegb<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzieo, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzav = zzeia.zzbgz().zzaw(t).zzav(t);
        if (z) {
            t.zza(zze.zziep, zzav ? t : null, null);
        }
        return zzav;
    }

    protected static zzegh zzbff() {
        return zzege.zzbft();
    }

    protected static zzegh zza(zzegh zzegh) {
        int size = zzegh.size();
        return zzegh.zzha(size == 0 ? 10 : size << 1);
    }

    protected static zzegj zzbfg() {
        return zzegz.zzbgk();
    }

    protected static <E> zzegm<E> zzbfh() {
        return zzehz.zzbgy();
    }

    protected static <E> zzegm<E> zza(zzegm<E> zzegm) {
        int size = zzegm.size();
        return zzegm.zzfs(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzegb<T, ?>> T zza(T t, zzefc zzefc, zzefo zzefo) throws zzegl {
        T zza2 = t.zza(zze.zzier, null, null);
        try {
            zzeih<T> zzaw = zzeia.zzbgz().zzaw(zza2);
            zzaw.zza(zza2, zzefj.zza(zzefc), zzefo);
            zzaw.zzaj(zza2);
            return zza2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzegl) {
                throw ((zzegl) e.getCause());
            }
            throw new zzegl(e.getMessage()).zzl(zza2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzegl) {
                throw ((zzegl) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzegb<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzefo zzefo) throws zzegl {
        T zza2 = t.zza(zze.zzier, null, null);
        try {
            zzeih<T> zzaw = zzeia.zzbgz().zzaw(zza2);
            zzaw.zza(zza2, bArr, 0, i2, new zzeem(zzefo));
            zzaw.zzaj(zza2);
            if (((zzegb) zza2).zzhzi == 0) {
                return zza2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzegl) {
                throw ((zzegl) e.getCause());
            }
            throw new zzegl(e.getMessage()).zzl(zza2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzegl.zzbfu().zzl(zza2);
        }
    }

    private static <T extends zzegb<T, ?>> T zza(T t) throws zzegl {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzegl(new zzeja(t).getMessage()).zzl(t);
    }

    protected static <T extends zzegb<T, ?>> T zza(T t, zzeer zzeer) throws zzegl {
        return zza(zza(zzb(t, zzeer, zzefo.zzbeq())));
    }

    protected static <T extends zzegb<T, ?>> T zza(T t, zzeer zzeer, zzefo zzefo) throws zzegl {
        return zza(zzb(t, zzeer, zzefo));
    }

    private static <T extends zzegb<T, ?>> T zzb(T t, zzeer zzeer, zzefo zzefo) throws zzegl {
        try {
            zzefc zzbde = zzeer.zzbde();
            T zza2 = zza(t, zzbde, zzefo);
            try {
                zzbde.zzfx(0);
                return zza2;
            } catch (zzegl e) {
                throw e.zzl(zza2);
            }
        } catch (zzegl e2) {
            throw e2;
        }
    }

    protected static <T extends zzegb<T, ?>> T zza(T t, byte[] bArr) throws zzegl {
        return zza(zza(t, bArr, 0, bArr.length, zzefo.zzbeq()));
    }

    protected static <T extends zzegb<T, ?>> T zza(T t, byte[] bArr, zzefo zzefo) throws zzegl {
        return zza(zza(t, bArr, 0, bArr.length, zzefo));
    }

    @Override // com.google.android.gms.internal.ads.zzehl
    public final /* synthetic */ zzeho zzbfi() {
        zzb zzb2 = (zzb) zza(zze.zzies, (Object) null, (Object) null);
        zzb2.zza(this);
        return zzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzehl
    public final /* synthetic */ zzeho zzbfj() {
        return (zzb) zza(zze.zzies, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzehn
    public final /* synthetic */ zzehl zzbfk() {
        return (zzegb) zza(zze.zziet, (Object) null, (Object) null);
    }
}
