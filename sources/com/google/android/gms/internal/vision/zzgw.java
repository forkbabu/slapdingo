package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgi;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
abstract class zzgw<T extends zzgi> {
    private static final Logger logger = Logger.getLogger(zzgf.class.getName());
    private static String zzwo = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzgw() {
    }

    /* access modifiers changed from: protected */
    public abstract T zzfy();

    static <T extends zzgi> T zzc(Class<T> cls) {
        String str;
        ClassLoader classLoader = zzgw.class.getClassLoader();
        if (cls.equals(zzgi.class)) {
            str = zzwo;
        } else if (cls.getPackage().equals(zzgw.class.getPackage())) {
            str = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            try {
                return cls.cast(((zzgw) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zzfy());
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
            Iterator it2 = ServiceLoader.load(zzgw.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it2.hasNext()) {
                try {
                    arrayList.add(cls.cast(((zzgw) it2.next()).zzfy()));
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
