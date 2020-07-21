package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzao;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
public class Element implements Text {
    private zzao zzef;

    Element(zzao zzao) {
        this.zzef = zzao;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getLanguage() {
        return this.zzef.zzek;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getValue() {
        return this.zzef.zzet;
    }

    @Override // com.google.android.gms.vision.text.Text
    public Rect getBoundingBox() {
        return zzc.zza(this);
    }

    @Override // com.google.android.gms.vision.text.Text
    public Point[] getCornerPoints() {
        return zzc.zza(this.zzef.zzeq);
    }

    @Override // com.google.android.gms.vision.text.Text
    public List<? extends Text> getComponents() {
        return new ArrayList();
    }
}
