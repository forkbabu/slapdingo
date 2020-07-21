package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaqi;
import com.google.android.gms.internal.ads.zzbba;
import com.google.android.gms.internal.ads.zzwg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzaqi zzacn;

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzaqi zzb = zzwg.zzpt().zzb(this);
        this.zzacn = zzb;
        if (zzb == null) {
            zzbba.zze("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzb.onCreate(bundle);
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onRestart() {
        super.onRestart();
        try {
            if (this.zzacn != null) {
                this.zzacn.onRestart();
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        try {
            if (this.zzacn != null) {
                this.zzacn.onStart();
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        try {
            if (this.zzacn != null) {
                this.zzacn.onResume();
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        try {
            if (this.zzacn != null) {
                this.zzacn.onPause();
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.zzacn != null) {
                this.zzacn.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        try {
            if (this.zzacn != null) {
                this.zzacn.onStop();
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        try {
            if (this.zzacn != null) {
                this.zzacn.onDestroy();
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    private final void zzdp() {
        zzaqi zzaqi = this.zzacn;
        if (zzaqi != null) {
            try {
                zzaqi.zzdp();
            } catch (RemoteException e) {
                zzbba.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        super.setContentView(i);
        zzdp();
    }

    @Override // android.app.Activity
    public final void setContentView(View view) {
        super.setContentView(view);
        zzdp();
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzdp();
    }

    public final void onBackPressed() {
        boolean z = true;
        try {
            if (this.zzacn != null) {
                z = this.zzacn.zzul();
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.zzacn.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.zzacn.zzad(ObjectWrapper.wrap(configuration));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }
}
