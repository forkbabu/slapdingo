package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzab;
import com.google.android.gms.internal.measurement.zzac;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzu;
import com.google.android.gms.internal.measurement.zzw;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.4 */
public class AppMeasurementDynamiteService extends zzu {
    zzgd zza = null;
    private Map<Integer, zzhf> zzb = new ArrayMap();

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.4 */
    class zza implements zzhf {
        private zzab zza;

        zza(zzab zzab) {
            this.zza = zzab;
        }

        @Override // com.google.android.gms.measurement.internal.zzhf
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event listener threw exception", e);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.4 */
    class zzb implements zzhc {
        private zzab zza;

        zzb(zzab zzab) {
            this.zza = zzab;
        }

        @Override // com.google.android.gms.measurement.internal.zzhc
        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event interceptor threw exception", e);
            }
        }
    }

    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void initialize(IObjectWrapper iObjectWrapper, zzae zzae, long j) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzgd zzgd = this.zza;
        if (zzgd == null) {
            this.zza = zzgd.zza(context, zzae, Long.valueOf(j));
        } else {
            zzgd.zzr().zzi().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setUserId(String str, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(null, "_id", str, true, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zza();
        this.zza.zzv().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        zzhh zzh = this.zza.zzh();
        zzh.zza((String) null);
        zzh.zzq().zza(new zzhp(zzh, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
        zzhh zzh = this.zza.zzh();
        zzh.zzb();
        zzh.zzq().zza(new zzia(zzh, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        zzhh zzh = this.zza.zzh();
        zzh.zzb();
        zzh.zzq().zza(new zzhl(zzh, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getMaxUserProperties(String str, zzw zzw) throws RemoteException {
        zza();
        this.zza.zzh();
        Preconditions.checkNotEmpty(str);
        this.zza.zzi().zza(zzw, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getCurrentScreenName(zzw zzw) throws RemoteException {
        zza();
        zza(zzw, this.zza.zzh().zzaj());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getCurrentScreenClass(zzw zzw) throws RemoteException {
        zza();
        zza(zzw, this.zza.zzh().zzak());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getCachedAppInstanceId(zzw zzw) throws RemoteException {
        zza();
        zza(zzw, this.zza.zzh().zzah());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getAppInstanceId(zzw zzw) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzh(this, zzw));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getGmpAppId(zzw zzw) throws RemoteException {
        zza();
        zza(zzw, this.zza.zzh().zzal());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void generateEventId(zzw zzw) throws RemoteException {
        zza();
        this.zza.zzi().zza(zzw, this.zza.zzi().zzg());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zza(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zzb(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void logEventAndBundle(String str, String str2, Bundle bundle, zzw zzw, long j) throws RemoteException {
        Bundle bundle2;
        zza();
        Preconditions.checkNotEmpty(str2);
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.zza.zzq().zza(new zzj(this, zzw, new zzao(str2, new zzan(bundle), "app", j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzw zzw, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        Bundle bundle = new Bundle();
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzr().zzi().zza("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void performAction(Bundle bundle, zzw zzw, long j) throws RemoteException {
        zza();
        zzw.zza(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getUserProperties(String str, String str2, boolean z, zzw zzw) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzi(this, zzw, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object obj;
        Object obj2;
        zza();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzr().zza(i, true, false, str, obj, obj2, obj3);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setEventInterceptor(zzab zzab) throws RemoteException {
        zza();
        zzhh zzh = this.zza.zzh();
        zzb zzb2 = new zzb(zzab);
        zzh.zzb();
        zzh.zzw();
        zzh.zzq().zza(new zzho(zzh, zzb2));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void registerOnMeasurementEventListener(zzab zzab) throws RemoteException {
        zza();
        zzhf zzhf = this.zzb.get(Integer.valueOf(zzab.zza()));
        if (zzhf == null) {
            zzhf = new zza(zzab);
            this.zzb.put(Integer.valueOf(zzab.zza()), zzhf);
        }
        this.zza.zzh().zza(zzhf);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void unregisterOnMeasurementEventListener(zzab zzab) throws RemoteException {
        zza();
        zzhf remove = this.zzb.remove(Integer.valueOf(zzab.zza()));
        if (remove == null) {
            remove = new zza(zzab);
        }
        this.zza.zzh().zzb(remove);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setInstanceIdProvider(zzac zzac) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzr().zzf().zza("Conditional user property must not be null");
        } else {
            this.zza.zzh().zza(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzh().zzc(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getConditionalUserProperties(String str, String str2, zzw zzw) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzl(this, zzw, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getTestFlag(zzw zzw, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzi().zza(zzw, this.zza.zzh().zzad());
        } else if (i == 1) {
            this.zza.zzi().zza(zzw, this.zza.zzh().zzae().longValue());
        } else if (i == 2) {
            zzkw zzi = this.zza.zzi();
            double doubleValue = this.zza.zzh().zzag().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzw.zza(bundle);
            } catch (RemoteException e) {
                zzi.zzy.zzr().zzi().zza("Error returning double value to wrapper", e);
            }
        } else if (i == 3) {
            this.zza.zzi().zza(zzw, this.zza.zzh().zzaf().intValue());
        } else if (i == 4) {
            this.zza.zzi().zza(zzw, this.zza.zzh().zzac().booleanValue());
        }
    }

    private final void zza(zzw zzw, String str) {
        this.zza.zzi().zza(zzw, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        zzhh zzh = this.zza.zzh();
        zzh.zzw();
        zzh.zzb();
        zzh.zzq().zza(new zzhy(zzh, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void isDataCollectionEnabled(zzw zzw) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzk(this, zzw));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setDefaultEventParameters(Bundle bundle) {
        Bundle bundle2;
        zza();
        zzhh zzh = this.zza.zzh();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzh.zzq().zza(new zzhg(zzh, bundle2));
    }
}
