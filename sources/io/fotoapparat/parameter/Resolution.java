package io.fotoapparat.parameter;

import com.itextpdf.text.html.HtmlTags;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\u0006\u0010\u0014\u001a\u00020\u0000J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lio/fotoapparat/parameter/Resolution;", "Lio/fotoapparat/parameter/Parameter;", HtmlTags.WIDTH, "", HtmlTags.HEIGHT, "(II)V", "area", "getArea", "()I", "aspectRatio", "", "getAspectRatio", "()F", "component1", "component2", "copy", "equals", "", "other", "", "flipDimensions", "hashCode", "toString", "", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Resolution.kt */
public final class Resolution implements Parameter {
    public final int height;
    public final int width;

    public static /* synthetic */ Resolution copy$default(Resolution resolution, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = resolution.width;
        }
        if ((i3 & 2) != 0) {
            i2 = resolution.height;
        }
        return resolution.copy(i, i2);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final Resolution copy(int i, int i2) {
        return new Resolution(i, i2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Resolution) {
                Resolution resolution = (Resolution) obj;
                if (this.width == resolution.width) {
                    if (this.height == resolution.height) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    public String toString() {
        return "Resolution(width=" + this.width + ", height=" + this.height + ")";
    }

    public Resolution(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final int getArea() {
        return this.width * this.height;
    }

    public final float getAspectRatio() {
        int i = this.width;
        if (i == 0) {
            return FloatCompanionObject.INSTANCE.getNaN();
        }
        int i2 = this.height;
        return i2 == 0 ? FloatCompanionObject.INSTANCE.getNaN() : ((float) i) / ((float) i2);
    }

    public final Resolution flipDimensions() {
        return new Resolution(this.height, this.width);
    }
}
