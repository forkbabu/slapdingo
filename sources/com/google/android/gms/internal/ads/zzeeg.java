package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeeg;
import com.google.android.gms.internal.ads.zzeeh;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzeeg<MessageType extends zzeeh<MessageType, BuilderType>, BuilderType extends zzeeg<MessageType, BuilderType>> implements zzeho {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzefc zzefc, zzefo zzefo) throws IOException;

    /* renamed from: zzbcs */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2, zzefo zzefo) throws zzegl {
        try {
            zzefc zzb = zzefc.zzb(bArr, 0, i2, false);
            zza(zzb, zzefo);
            zzb.zzfx(0);
            return this;
        } catch (zzegl e) {
            throw e;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + "byte array".length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeho
    public final /* synthetic */ zzeho zzf(zzehl zzehl) {
        if (zzbfk().getClass().isInstance(zzehl)) {
            return zza((zzeeh) zzehl);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
