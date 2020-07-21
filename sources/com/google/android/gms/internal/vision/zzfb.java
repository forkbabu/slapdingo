package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzey;
import com.google.android.gms.internal.vision.zzfb;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public abstract class zzfb<MessageType extends zzey<MessageType, BuilderType>, BuilderType extends zzfb<MessageType, BuilderType>> implements zzig {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzfy zzfy, zzgi zzgi) throws IOException;

    /* renamed from: zzdo */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2, zzgi zzgi) throws zzhh {
        try {
            zzfy zza = zzfy.zza(bArr, 0, i2, false);
            zza(zza, zzgi);
            zza.zzar(0);
            return this;
        } catch (zzhh e) {
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

    @Override // com.google.android.gms.internal.vision.zzig
    public final /* synthetic */ zzig zza(zzih zzih) {
        if (zzge().getClass().isInstance(zzih)) {
            return zza((zzey) ((zzey) zzih));
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
