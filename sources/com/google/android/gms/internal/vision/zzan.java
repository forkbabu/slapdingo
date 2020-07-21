package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
public final class zzan extends zzs<zzad> {
    private final zzam zzen;

    public zzan(Context context, zzam zzam) {
        super(context, "TextNativeHandle", "ocr");
        this.zzen = zzam;
        zzq();
    }

    public final zzah[] zza(Bitmap bitmap, zzu zzu, zzaj zzaj) {
        if (!isOperational()) {
            return new zzah[0];
        }
        try {
            return ((zzad) zzq()).zza(ObjectWrapper.wrap(bitmap), zzu, zzaj);
        } catch (RemoteException e) {
            Log.e("TextNativeHandle", "Error calling native text recognizer", e);
            return new zzah[0];
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzs
    public final void zzo() throws RemoteException {
        ((zzad) zzq()).zzr();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzs
    public final /* synthetic */ zzad zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzaf zzaf;
        IBinder instantiate = dynamiteModule.instantiate("com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator");
        if (instantiate == null) {
            zzaf = null;
        } else {
            IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
            if (queryLocalInterface instanceof zzaf) {
                zzaf = (zzaf) queryLocalInterface;
            } else {
                zzaf = new zzae(instantiate);
            }
        }
        if (zzaf == null) {
            return null;
        }
        return zzaf.zza(ObjectWrapper.wrap(context), this.zzen);
    }
}
