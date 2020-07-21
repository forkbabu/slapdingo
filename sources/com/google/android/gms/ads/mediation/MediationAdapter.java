package com.google.android.gms.ads.mediation;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public interface MediationAdapter extends MediationExtrasReceiver {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public static class zza {
        private int zzepq;

        public final zza zzdt(int i) {
            this.zzepq = 1;
            return this;
        }

        public final Bundle zzacx() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzepq);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
