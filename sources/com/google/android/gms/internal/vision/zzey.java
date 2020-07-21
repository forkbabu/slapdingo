package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzey;
import com.google.android.gms.internal.vision.zzfb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public abstract class zzey<MessageType extends zzey<MessageType, BuilderType>, BuilderType extends zzfb<MessageType, BuilderType>> implements zzih {
    protected int zzrx = 0;

    @Override // com.google.android.gms.internal.vision.zzih
    public final zzfm zzdl() {
        try {
            zzfu zzaq = zzfm.zzaq(zzgg());
            zzb(zzaq.zzex());
            return zzaq.zzew();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzgg()];
            zzgf zze = zzgf.zze(bArr);
            zzb(zze);
            zze.zzfi();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzdm() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzae(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzgy.checkNotNull(iterable);
        if (iterable instanceof zzho) {
            List<?> zzgy = ((zzho) iterable).zzgy();
            zzho zzho = (zzho) list;
            int size = list.size();
            for (Object obj : zzgy) {
                if (obj == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(zzho.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = zzho.size() - 1; size2 >= size; size2--) {
                        zzho.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (obj instanceof zzfm) {
                    zzho.zzc((zzfm) obj);
                } else {
                    zzho.add((String) obj);
                }
            }
        } else if (iterable instanceof zzit) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (T t : iterable) {
                if (t == null) {
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(list.size() - size3);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                        list.remove(size4);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(t);
            }
        }
    }
}
