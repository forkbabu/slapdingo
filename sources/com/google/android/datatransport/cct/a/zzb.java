package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

public final class zzb implements Configurator {
    public static final Configurator zza = new zzb();

    private static final class zza implements ObjectEncoder<zza> {
        static final zza zza = new zza();

        private zza() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.google.firebase.encoders.Encoder
        public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            zza zza2 = (zza) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add("sdkVersion", zza2.zzi());
            objectEncoderContext2.add("model", zza2.zzf());
            objectEncoderContext2.add("hardware", zza2.zzd());
            objectEncoderContext2.add("device", zza2.zzb());
            objectEncoderContext2.add("product", zza2.zzh());
            objectEncoderContext2.add("osBuild", zza2.zzg());
            objectEncoderContext2.add("manufacturer", zza2.zze());
            objectEncoderContext2.add("fingerprint", zza2.zzc());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.a.zzb$zzb  reason: collision with other inner class name */
    private static final class C0001zzb implements ObjectEncoder<zzo> {
        static final C0001zzb zza = new C0001zzb();

        private C0001zzb() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.google.firebase.encoders.Encoder
        public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("logRequest", ((zzo) obj).zza());
        }
    }

    private static final class zzc implements ObjectEncoder<zzp> {
        static final zzc zza = new zzc();

        private zzc() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.google.firebase.encoders.Encoder
        public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            zzp zzp = (zzp) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add("clientType", zzp.zzc());
            objectEncoderContext2.add("androidClientInfo", zzp.zzb());
        }
    }

    private static final class zzd implements ObjectEncoder<zzq> {
        static final zzd zza = new zzd();

        private zzd() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.google.firebase.encoders.Encoder
        public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            zzq zzq = (zzq) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add("eventTimeMs", zzq.zzb());
            objectEncoderContext2.add("eventCode", zzq.zza());
            objectEncoderContext2.add("eventUptimeMs", zzq.zzc());
            objectEncoderContext2.add("sourceExtension", zzq.zze());
            objectEncoderContext2.add("sourceExtensionJsonProto3", zzq.zzf());
            objectEncoderContext2.add("timezoneOffsetSeconds", zzq.zzg());
            objectEncoderContext2.add("networkConnectionInfo", zzq.zzd());
        }
    }

    private static final class zze implements ObjectEncoder<zzr> {
        static final zze zza = new zze();

        private zze() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.google.firebase.encoders.Encoder
        public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            zzr zzr = (zzr) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add("requestTimeMs", zzr.zzg());
            objectEncoderContext2.add("requestUptimeMs", zzr.zzh());
            objectEncoderContext2.add("clientInfo", zzr.zzb());
            objectEncoderContext2.add("logSource", zzr.zzd());
            objectEncoderContext2.add("logSourceName", zzr.zze());
            objectEncoderContext2.add("logEvent", zzr.zzc());
            objectEncoderContext2.add("qosTier", zzr.zzf());
        }
    }

    private static final class zzf implements ObjectEncoder<zzt> {
        static final zzf zza = new zzf();

        private zzf() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.google.firebase.encoders.Encoder
        public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            zzt zzt = (zzt) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add("networkType", zzt.zzc());
            objectEncoderContext2.add("mobileSubtype", zzt.zzb());
        }
    }

    private zzb() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(zzo.class, C0001zzb.zza);
        encoderConfig.registerEncoder(zze.class, C0001zzb.zza);
        encoderConfig.registerEncoder(zzr.class, zze.zza);
        encoderConfig.registerEncoder(zzk.class, zze.zza);
        encoderConfig.registerEncoder(zzp.class, zzc.zza);
        encoderConfig.registerEncoder(zzg.class, zzc.zza);
        encoderConfig.registerEncoder(zza.class, zza.zza);
        encoderConfig.registerEncoder(zzd.class, zza.zza);
        encoderConfig.registerEncoder(zzq.class, zzd.zza);
        encoderConfig.registerEncoder(zzi.class, zzd.zza);
        encoderConfig.registerEncoder(zzt.class, zzf.zza);
        encoderConfig.registerEncoder(zzn.class, zzf.zza);
    }
}
