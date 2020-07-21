package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeeg;
import com.google.android.gms.internal.ads.zzeeh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzeeh<MessageType extends zzeeh<MessageType, BuilderType>, BuilderType extends zzeeg<MessageType, BuilderType>> implements zzehl {
    protected int zzhzi = 0;

    @Override // com.google.android.gms.internal.ads.zzehl
    public final zzeer zzbct() {
        try {
            zzeez zzfv = zzeer.zzfv(zzbfe());
            zzb(zzfv.zzbdl());
            return zzfv.zzbdk();
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

    @Override // com.google.android.gms.internal.ads.zzehl
    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzbfe()];
            zzefl zzw = zzefl.zzw(bArr);
            zzb(zzw);
            zzw.zzben();
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
    public int zzbcu() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzfp(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzegd.checkNotNull(iterable);
        if (iterable instanceof zzegw) {
            List<?> zzbgg = ((zzegw) iterable).zzbgg();
            zzegw zzegw = (zzegw) list;
            int size = list.size();
            for (Object obj : zzbgg) {
                if (obj == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(zzegw.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = zzegw.size() - 1; size2 >= size; size2--) {
                        zzegw.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (obj instanceof zzeer) {
                    zzegw.zzaj((zzeer) obj);
                } else {
                    zzegw.add((String) obj);
                }
            }
        } else if (iterable instanceof zzehx) {
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
