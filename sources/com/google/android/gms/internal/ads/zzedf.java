package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedi;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzedf<T_WRAPPER extends zzedi<T_ENGINE>, T_ENGINE> {
    private static final Logger logger = Logger.getLogger(zzedf.class.getName());
    private static final List<Provider> zzhyd;
    public static final zzedf<zzedh, Cipher> zzhye = new zzedf<>(new zzedh());
    public static final zzedf<zzedl, Mac> zzhyf = new zzedf<>(new zzedl());
    private static final zzedf<zzedn, Signature> zzhyg = new zzedf<>(new zzedn());
    private static final zzedf<zzedo, MessageDigest> zzhyh = new zzedf<>(new zzedo());
    public static final zzedf<zzedk, KeyAgreement> zzhyi = new zzedf<>(new zzedk());
    public static final zzedf<zzedm, KeyPairGenerator> zzhyj = new zzedf<>(new zzedm());
    public static final zzedf<zzedj, KeyFactory> zzhyk = new zzedf<>(new zzedj());
    private T_WRAPPER zzhyl;
    private List<Provider> zzhym = zzhyd;
    private boolean zzhyn = true;

    private zzedf(T_WRAPPER t_wrapper) {
        this.zzhyl = t_wrapper;
    }

    public final T_ENGINE zzhq(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider provider : this.zzhym) {
            try {
                return this.zzhyl.zza(str, provider);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (this.zzhyn) {
            return this.zzhyl.zza(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }

    static {
        if (zzedw.zzbcq()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
                }
            }
            zzhyd = arrayList;
        } else {
            zzhyd = new ArrayList();
        }
    }
}
