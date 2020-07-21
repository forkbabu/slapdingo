package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbjf extends zzdeu {
    private final /* synthetic */ zzbiz zzeto;
    private zzelj<String> zzext;
    private zzelj<zzckj> zzeyj;
    private zzelj<Map<zzdor, zzckj>> zzeyl;
    private zzelj<Set<zzbyg<zzdpa>>> zzeyn;
    private zzelj<Set<zzbyg<zzdpa>>> zzeyu;
    private zzelj zzeyv;
    private zzelj<zzdou> zzeyw;
    private zzelj<ApplicationInfo> zzezg;
    private zzelj<zzdfy> zzfal;
    private final zzdgd zzfdp;
    private zzelj<zzdeq> zzfdq;
    private zzelj<String> zzfdr;
    private zzelj<zzdfa> zzfds;
    private zzelj<Integer> zzfdt;
    private zzelj<zzdfe> zzfdu;
    private zzelj<zzdfk> zzfdv;
    private zzelj<zzdfp> zzfdw;
    private zzelj<Boolean> zzfdx;
    private zzelj<zzdgc> zzfdy;
    private zzelj<zzdgq> zzfdz;
    private zzelj<zzckj> zzfea;
    private zzelj<zzckj> zzfeb;
    private zzelj<zzckj> zzfec;

    private zzbjf(zzbiz zzbiz, zzdgd zzdgd) {
        this.zzeto = zzbiz;
        this.zzfdp = zzdgd;
        this.zzfdq = new zzder(zzbkz.zzfki, this.zzeto.zzerq, this.zzeto.zzerl, zzdnu.zzaug());
        this.zzfdr = new zzdgg(zzdgd);
        this.zzfds = new zzdfc(zzbiu.zzerd, this.zzeto.zzerq, this.zzfdr, zzdnu.zzaug());
        this.zzfdt = new zzdgh(zzdgd);
        this.zzfdu = new zzdfi(zzbkz.zzfki, this.zzfdt, this.zzeto.zzerq, this.zzeto.zzesj, this.zzeto.zzerl, zzdnu.zzaug());
        this.zzfdv = new zzdfm(zzbkt.zzfke, zzdnu.zzaug(), this.zzeto.zzerq);
        this.zzfdw = new zzdfr(zzbkv.zzfkf, zzdnu.zzaug(), this.zzfdr);
        this.zzfdx = new zzdgi(zzdgd);
        this.zzezg = new zzdgf(zzdgd);
        this.zzfal = new zzdga(this.zzeto.zzesl, this.zzeto.zzerl, this.zzfdx, this.zzezg);
        this.zzfdy = new zzdge(zzbkx.zzfkg, this.zzeto.zzerl, this.zzeto.zzerq);
        this.zzfdz = new zzdgs(zzdnu.zzaug());
        this.zzext = new zzdgk(zzdgd);
        this.zzeyj = zzekx.zzas(zzcjy.zzanx());
        this.zzfea = zzekx.zzas(zzcjw.zzanw());
        this.zzfeb = zzekx.zzas(zzcka.zzanz());
        this.zzfec = zzekx.zzas(zzckc.zzaob());
        this.zzeyl = ((zzele) ((zzele) ((zzele) ((zzele) zzelc.zzib(4).zza(zzdor.GMS_SIGNALS, this.zzeyj)).zza(zzdor.BUILD_URL, this.zzfea)).zza(zzdor.HTTP, this.zzfeb)).zza(zzdor.PRE_PROCESS, this.zzfec)).zzbjg();
        this.zzeyn = zzekx.zzas(new zzcke(this.zzext, this.zzeto.zzerq, zzdnu.zzaug(), this.zzeyl));
        zzelf zzbjh = zzelf.zzar(0, 1).zzav(this.zzeyn).zzbjh();
        this.zzeyu = zzbjh;
        this.zzeyv = zzdpc.zzar(zzbjh);
        this.zzeyw = zzekx.zzas(zzdoz.zzv(zzdnu.zzaug(), this.zzeto.zzerl, this.zzeyv));
    }

    private final zzdft zzaez() {
        return new zzdft((zzaae) zzelg.zza(new zzaae(), "Cannot return null from a non-@Nullable @Provides method"), zzdnu.zzauh(), (List) zzelg.zza(this.zzfdp.zzarl(), "Cannot return null from a non-@Nullable @Provides method"));
    }

    private final zzdew zzafa() {
        return new zzdew(zzbkw.zzagp(), zzdnu.zzauh(), (String) zzelg.zza(this.zzfdp.zzari(), "Cannot return null from a non-@Nullable @Provides method"), this.zzfdp.zzarj());
    }

    @Override // com.google.android.gms.internal.ads.zzdeu
    public final zzdeb<JSONObject> zzafb() {
        return zzdeg.zza(zzdnu.zzauh(), zzdsz.zza((zzdec) zzelg.zza(new zzdcn(new zzdfp(zzbks.zzagl(), zzdnu.zzauh(), zzdgg.zzc(this.zzfdp)), 0, (ScheduledExecutorService) this.zzeto.zzerl.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdec) zzelg.zza(new zzdcn(new zzdfy(zzbkf.zzb(this.zzeto.zzerh), (ScheduledExecutorService) this.zzeto.zzerl.get(), this.zzfdp.zzark(), zzdgf.zzb(this.zzfdp)), ((Long) zzwg.zzpw().zzd(zzaav.zzcru)).longValue(), (ScheduledExecutorService) this.zzeto.zzerl.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdec) zzelg.zza(new zzdcn(new zzdgc(zzbku.zzagn(), (ScheduledExecutorService) this.zzeto.zzerl.get(), zzbih.zza(this.zzeto.zzeri)), ((Long) zzwg.zzpw().zzd(zzaav.zzcsc)).longValue(), (ScheduledExecutorService) this.zzeto.zzerl.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdec) zzelg.zza(new zzdcn(new zzdeq(zzbkw.zzagp(), zzbih.zza(this.zzeto.zzeri), (ScheduledExecutorService) this.zzeto.zzerl.get(), zzdnu.zzauh()), 0, (ScheduledExecutorService) this.zzeto.zzerl.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdec) zzelg.zza(new zzdcn(new zzdgq(zzdnu.zzauh()), 0, (ScheduledExecutorService) this.zzeto.zzerl.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdec) zzelg.zza(zzdgj.zzarp(), "Cannot return null from a non-@Nullable @Provides method"), new zzdfa(null, zzbih.zza(this.zzeto.zzeri), zzdgg.zzc(this.zzfdp), zzdnu.zzauh()), new zzdfk(zzbkq.zzagj(), zzdnu.zzauh(), zzbih.zza(this.zzeto.zzeri)), zzaez(), zzafa(), new zzdfe(zzbkw.zzagp(), this.zzfdp.zzaro(), zzbih.zza(this.zzeto.zzeri), (zzaxh) this.zzeto.zzesj.get(), (ScheduledExecutorService) this.zzeto.zzerl.get(), zzdnu.zzauh()), (zzdec) this.zzeto.zzesk.get()));
    }

    @Override // com.google.android.gms.internal.ads.zzdeu
    public final zzdeb<JSONObject> zzafc() {
        return zzdgo.zza(zzbks.zzagl(), this.zzeto.zzesk.get(), zzafa(), zzaez(), zzekx.zzat(this.zzfdq), zzekx.zzat(this.zzfds), zzekx.zzat(this.zzfdu), zzekx.zzat(this.zzfdv), zzekx.zzat(this.zzfdw), zzekx.zzat(this.zzfal), zzekx.zzat(this.zzfdy), zzekx.zzat(this.zzfdz), zzdnu.zzauh(), (ScheduledExecutorService) this.zzeto.zzerl.get());
    }

    @Override // com.google.android.gms.internal.ads.zzdeu
    public final zzdou zzafd() {
        return this.zzeyw.get();
    }
}
