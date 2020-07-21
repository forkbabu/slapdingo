package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
abstract class zzefz<T extends zzefo> {
    private static final Logger logger = Logger.getLogger(zzefl.class.getName());
    private static String zzied = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzefz() {
    }

    /* access modifiers changed from: protected */
    public abstract T zzbfb();

    static <T extends zzefo> T zzc(Class<T> cls) {
        String str;
        ClassLoader classLoader = zzefz.class.getClassLoader();
        if (cls.equals(zzefo.class)) {
            str = zzied;
        } else if (cls.getPackage().equals(zzefz.class.getPackage())) {
            str = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            try {
                return cls.cast(((zzefz) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zzbfb());
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException(e);
            } catch (InstantiationException e2) {
                throw new IllegalStateException(e2);
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException(e3);
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it2 = ServiceLoader.load(zzefz.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it2.hasNext()) {
                try {
                    arrayList.add(cls.cast(((zzefz) it2.next()).zzbfb()));
                } catch (ServiceConfigurationError e5) {
                    Logger logger2 = logger;
                    Level level = Level.SEVERE;
                    String valueOf = String.valueOf(cls.getSimpleName());
                    logger2.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", valueOf.length() != 0 ? "Unable to load ".concat(valueOf) : new String("Unable to load "), (Throwable) e5);
                }
            }
            if (arrayList.size() == 1) {
                return arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (NoSuchMethodException e6) {
                throw new IllegalStateException(e6);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }
}
