package io.fotoapparat.result;

import android.graphics.BitmapFactory;
import com.itextpdf.text.html.HtmlTags;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001c"}, d2 = {"Lio/fotoapparat/result/Photo;", "", "encodedImage", "", "rotationDegrees", "", "([BI)V", "decodedBounds", "Landroid/graphics/BitmapFactory$Options;", "getDecodedBounds", "()Landroid/graphics/BitmapFactory$Options;", "decodedBounds$delegate", "Lkotlin/Lazy;", HtmlTags.HEIGHT, "getHeight", "()I", HtmlTags.WIDTH, "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Photo.kt */
public final class Photo {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Photo.class), "decodedBounds", "getDecodedBounds()Landroid/graphics/BitmapFactory$Options;"))};
    public static final Companion Companion = new Companion(null);
    private final Lazy decodedBounds$delegate = LazyKt.lazy(new Photo$decodedBounds$2(this));
    public final byte[] encodedImage;
    public final int rotationDegrees;

    public static /* synthetic */ Photo copy$default(Photo photo, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bArr = photo.encodedImage;
        }
        if ((i2 & 2) != 0) {
            i = photo.rotationDegrees;
        }
        return photo.copy(bArr, i);
    }

    private final BitmapFactory.Options getDecodedBounds() {
        Lazy lazy = this.decodedBounds$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (BitmapFactory.Options) lazy.getValue();
    }

    public final byte[] component1() {
        return this.encodedImage;
    }

    public final int component2() {
        return this.rotationDegrees;
    }

    public final Photo copy(byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(bArr, "encodedImage");
        return new Photo(bArr, i);
    }

    public Photo(byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(bArr, "encodedImage");
        this.encodedImage = bArr;
        this.rotationDegrees = i;
    }

    public final int getHeight() {
        return getDecodedBounds().outHeight;
    }

    public final int getWidth() {
        return getDecodedBounds().outWidth;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            Photo photo = (Photo) obj;
            if (Arrays.equals(this.encodedImage, photo.encodedImage) && this.rotationDegrees == photo.rotationDegrees) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type io.fotoapparat.result.Photo");
    }

    public int hashCode() {
        return (Arrays.hashCode(this.encodedImage) * 31) + this.rotationDegrees;
    }

    public String toString() {
        return "Photo(encodedImage=ByteArray(" + this.encodedImage.length + ") rotationDegrees=" + this.rotationDegrees + ')';
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/fotoapparat/result/Photo$Companion;", "", "()V", "empty", "Lio/fotoapparat/result/Photo;", "empty$fotoapparat_release", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: Photo.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Photo empty$fotoapparat_release() {
            return new Photo(new byte[0], 0);
        }
    }
}
