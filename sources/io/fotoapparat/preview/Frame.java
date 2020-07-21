package io.fotoapparat.preview;

import com.itextpdf.text.html.HtmlTags;
import io.fotoapparat.parameter.Resolution;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lio/fotoapparat/preview/Frame;", "", HtmlTags.SIZE, "Lio/fotoapparat/parameter/Resolution;", "image", "", "rotation", "", "(Lio/fotoapparat/parameter/Resolution;[BI)V", "getImage", "()[B", "getRotation", "()I", "getSize", "()Lio/fotoapparat/parameter/Resolution;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Frame.kt */
public final class Frame {
    private final byte[] image;
    private final int rotation;
    private final Resolution size;

    public static /* synthetic */ Frame copy$default(Frame frame, Resolution resolution, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            resolution = frame.size;
        }
        if ((i2 & 2) != 0) {
            bArr = frame.image;
        }
        if ((i2 & 4) != 0) {
            i = frame.rotation;
        }
        return frame.copy(resolution, bArr, i);
    }

    public final Resolution component1() {
        return this.size;
    }

    public final byte[] component2() {
        return this.image;
    }

    public final int component3() {
        return this.rotation;
    }

    public final Frame copy(Resolution resolution, byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(resolution, HtmlTags.SIZE);
        Intrinsics.checkParameterIsNotNull(bArr, "image");
        return new Frame(resolution, bArr, i);
    }

    public Frame(Resolution resolution, byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(resolution, HtmlTags.SIZE);
        Intrinsics.checkParameterIsNotNull(bArr, "image");
        this.size = resolution;
        this.image = bArr;
        this.rotation = i;
    }

    public final Resolution getSize() {
        return this.size;
    }

    public final byte[] getImage() {
        return this.image;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public String toString() {
        return "Frame{size=" + this.size + ", image= array(" + this.image.length + ")" + ", rotation=" + this.rotation + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            Frame frame = (Frame) obj;
            if (!(!Intrinsics.areEqual(this.size, frame.size)) && Arrays.equals(this.image, frame.image) && this.rotation == frame.rotation) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type io.fotoapparat.preview.Frame");
    }

    public int hashCode() {
        return (((this.size.hashCode() * 31) + Arrays.hashCode(this.image)) * 31) + this.rotation;
    }
}
