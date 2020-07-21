package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import java.util.Random;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzwg {
    private static zzwg zzcil = new zzwg();
    private final zzbaq zzcim;
    private final zzvp zzcin;
    private final String zzcio;
    private final zzaam zzcip;
    private final zzaao zzciq;
    private final zzaar zzcir;
    private final zzbbd zzcis;
    private final Random zzcit;
    private final WeakHashMap<QueryInfo, String> zzciu;

    protected zzwg() {
        this(new zzbaq(), new zzvp(new zzvc(), new zzuz(), new zzzf(), new zzafx(), new zzatu(), new zzauy(), new zzaqg(), new zzafw()), new zzaam(), new zzaao(), new zzaar(), zzbaq.zzyj(), new zzbbd(0, 201604000, true), new Random(), new WeakHashMap());
    }

    private zzwg(zzbaq zzbaq, zzvp zzvp, zzaam zzaam, zzaao zzaao, zzaar zzaar, String str, zzbbd zzbbd, Random random, WeakHashMap<QueryInfo, String> weakHashMap) {
        this.zzcim = zzbaq;
        this.zzcin = zzvp;
        this.zzcip = zzaam;
        this.zzciq = zzaao;
        this.zzcir = zzaar;
        this.zzcio = str;
        this.zzcis = zzbbd;
        this.zzcit = random;
        this.zzciu = weakHashMap;
    }

    public static zzbaq zzps() {
        return zzcil.zzcim;
    }

    public static zzvp zzpt() {
        return zzcil.zzcin;
    }

    public static zzaao zzpu() {
        return zzcil.zzciq;
    }

    public static zzaam zzpv() {
        return zzcil.zzcip;
    }

    public static zzaar zzpw() {
        return zzcil.zzcir;
    }

    public static String zzpx() {
        return zzcil.zzcio;
    }

    public static zzbbd zzpy() {
        return zzcil.zzcis;
    }

    public static Random zzpz() {
        return zzcil.zzcit;
    }

    public static WeakHashMap<QueryInfo, String> zzqa() {
        return zzcil.zzciu;
    }
}
