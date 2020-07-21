package com.google.android.gms.internal.ads;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
class zzeim<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzibm;
    private final int zziik;
    /* access modifiers changed from: private */
    public List<zzeir> zziil;
    /* access modifiers changed from: private */
    public Map<K, V> zziim;
    private volatile zzeit zziin;
    /* access modifiers changed from: private */
    public Map<K, V> zziio;
    private volatile zzein zziip;

    static <FieldDescriptorType extends zzefw<FieldDescriptorType>> zzeim<FieldDescriptorType, Object> zzhn(int i) {
        return new zzeil(i);
    }

    private zzeim(int i) {
        this.zziik = i;
        this.zziil = Collections.emptyList();
        this.zziim = Collections.emptyMap();
        this.zziio = Collections.emptyMap();
    }

    public void zzbcz() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzibm) {
            if (this.zziim.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zziim);
            }
            this.zziim = map;
            if (this.zziio.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zziio);
            }
            this.zziio = map2;
            this.zzibm = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzibm;
    }

    public final int zzbhj() {
        return this.zziil.size();
    }

    public final Map.Entry<K, V> zzho(int i) {
        return this.zziil.get(i);
    }

    public final Iterable<Map.Entry<K, V>> zzbhk() {
        if (this.zziim.isEmpty()) {
            return zzeiq.zzbhp();
        }
        return this.zziim.entrySet();
    }

    public int size() {
        return this.zziil.size() + this.zziim.size();
    }

    public boolean containsKey(Object obj) {
        K k = (Comparable) obj;
        return zza(k) >= 0 || this.zziim.containsKey(k);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        K k = (Comparable) obj;
        int zza = zza((Comparable) k);
        if (zza >= 0) {
            return this.zziil.get(zza).getValue();
        }
        return this.zziim.get(k);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzbhm();
        int zza = zza((Comparable) k);
        if (zza >= 0) {
            return this.zziil.get(zza).setValue(v);
        }
        zzbhm();
        if (this.zziil.isEmpty() && !(this.zziil instanceof ArrayList)) {
            this.zziil = new ArrayList(this.zziik);
        }
        int i = -(zza + 1);
        if (i >= this.zziik) {
            return zzbhn().put(k, v);
        }
        int size = this.zziil.size();
        int i2 = this.zziik;
        if (size == i2) {
            zzeir remove = this.zziil.remove(i2 - 1);
            zzbhn().put(remove.getKey(), remove.getValue());
        }
        this.zziil.add(i, new zzeir(this, k, v));
        return null;
    }

    public void clear() {
        zzbhm();
        if (!this.zziil.isEmpty()) {
            this.zziil.clear();
        }
        if (!this.zziim.isEmpty()) {
            this.zziim.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzbhm();
        K k = (Comparable) obj;
        int zza = zza((Comparable) k);
        if (zza >= 0) {
            return zzhp(zza);
        }
        if (this.zziim.isEmpty()) {
            return null;
        }
        return this.zziim.remove(k);
    }

    /* access modifiers changed from: private */
    public final V zzhp(int i) {
        zzbhm();
        V value = this.zziil.remove(i).getValue();
        if (!this.zziim.isEmpty()) {
            Iterator<Map.Entry<K, V>> it2 = zzbhn().entrySet().iterator();
            this.zziil.add(new zzeir(this, it2.next()));
            it2.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zziil.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zziil.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zziil.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zziin == null) {
            this.zziin = new zzeit(this, null);
        }
        return this.zziin;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzbhl() {
        if (this.zziip == null) {
            this.zziip = new zzein(this, null);
        }
        return this.zziip;
    }

    /* access modifiers changed from: private */
    public final void zzbhm() {
        if (this.zzibm) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzbhn() {
        zzbhm();
        if (this.zziim.isEmpty() && !(this.zziim instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zziim = treeMap;
            this.zziio = treeMap.descendingMap();
        }
        return (SortedMap) this.zziim;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeim)) {
            return super.equals(obj);
        }
        zzeim zzeim = (zzeim) obj;
        int size = size();
        if (size != zzeim.size()) {
            return false;
        }
        int zzbhj = zzbhj();
        if (zzbhj != zzeim.zzbhj()) {
            return entrySet().equals(zzeim.entrySet());
        }
        for (int i = 0; i < zzbhj; i++) {
            if (!zzho(i).equals(zzeim.zzho(i))) {
                return false;
            }
        }
        if (zzbhj != size) {
            return this.zziim.equals(zzeim.zziim);
        }
        return true;
    }

    public int hashCode() {
        int zzbhj = zzbhj();
        int i = 0;
        for (int i2 = 0; i2 < zzbhj; i2++) {
            i += this.zziil.get(i2).hashCode();
        }
        return this.zziim.size() > 0 ? i + this.zziim.hashCode() : i;
    }

    /* synthetic */ zzeim(int i, zzeil zzeil) {
        this(i);
    }
}
