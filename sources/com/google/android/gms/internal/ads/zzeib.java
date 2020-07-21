package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
interface zzeib {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zzeih<T> zzeih, zzefo zzefo) throws IOException;

    <T> void zza(List<T> list, zzeih<T> zzeih, zzefo zzefo) throws IOException;

    <K, V> void zza(Map<K, V> map, zzehg<K, V> zzehg, zzefo zzefo) throws IOException;

    @Deprecated
    <T> T zzb(zzeih<T> zzeih, zzefo zzefo) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zzeih<T> zzeih, zzefo zzefo) throws IOException;

    long zzbdn() throws IOException;

    long zzbdo() throws IOException;

    int zzbdp() throws IOException;

    long zzbdq() throws IOException;

    int zzbdr() throws IOException;

    boolean zzbds() throws IOException;

    String zzbdt() throws IOException;

    zzeer zzbdu() throws IOException;

    int zzbdv() throws IOException;

    int zzbdw() throws IOException;

    int zzbdx() throws IOException;

    long zzbdy() throws IOException;

    int zzbdz() throws IOException;

    long zzbea() throws IOException;

    int zzbek() throws IOException;

    boolean zzbel() throws IOException;

    void zzk(List<Double> list) throws IOException;

    void zzl(List<Float> list) throws IOException;

    void zzm(List<Long> list) throws IOException;

    void zzn(List<Long> list) throws IOException;

    void zzo(List<Integer> list) throws IOException;

    void zzp(List<Long> list) throws IOException;

    void zzq(List<Integer> list) throws IOException;

    void zzr(List<Boolean> list) throws IOException;

    void zzs(List<String> list) throws IOException;

    void zzt(List<zzeer> list) throws IOException;

    void zzu(List<Integer> list) throws IOException;

    void zzv(List<Integer> list) throws IOException;

    void zzw(List<Integer> list) throws IOException;

    void zzx(List<Long> list) throws IOException;

    void zzy(List<Integer> list) throws IOException;

    void zzz(List<Long> list) throws IOException;
}
