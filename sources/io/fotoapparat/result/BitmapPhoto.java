package io.fotoapparat.result;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/fotoapparat/result/BitmapPhoto;", "", "bitmap", "Landroid/graphics/Bitmap;", "rotationDegrees", "", "(Landroid/graphics/Bitmap;I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: BitmapPhoto.kt */
public final class BitmapPhoto {
    public final Bitmap bitmap;
    public final int rotationDegrees;

    public static /* synthetic */ BitmapPhoto copy$default(BitmapPhoto bitmapPhoto, Bitmap bitmap2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bitmap2 = bitmapPhoto.bitmap;
        }
        if ((i2 & 2) != 0) {
            i = bitmapPhoto.rotationDegrees;
        }
        return bitmapPhoto.copy(bitmap2, i);
    }

    public final Bitmap component1() {
        return this.bitmap;
    }

    public final int component2() {
        return this.rotationDegrees;
    }

    public final BitmapPhoto copy(Bitmap bitmap2, int i) {
        Intrinsics.checkParameterIsNotNull(bitmap2, "bitmap");
        return new BitmapPhoto(bitmap2, i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BitmapPhoto) {
                BitmapPhoto bitmapPhoto = (BitmapPhoto) obj;
                if (Intrinsics.areEqual(this.bitmap, bitmapPhoto.bitmap)) {
                    if (this.rotationDegrees == bitmapPhoto.rotationDegrees) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Bitmap bitmap2 = this.bitmap;
        return ((bitmap2 != null ? bitmap2.hashCode() : 0) * 31) + this.rotationDegrees;
    }

    public String toString() {
        return "BitmapPhoto(bitmap=" + this.bitmap + ", rotationDegrees=" + this.rotationDegrees + ")";
    }

    public BitmapPhoto(Bitmap bitmap2, int i) {
        Intrinsics.checkParameterIsNotNull(bitmap2, "bitmap");
        this.bitmap = bitmap2;
        this.rotationDegrees = i;
    }
}
