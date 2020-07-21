package io.fotoapparat.characteristic;

import io.fotoapparat.hardware.orientation.Orientation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lio/fotoapparat/characteristic/Characteristics;", "", "cameraId", "", "lensPosition", "Lio/fotoapparat/characteristic/LensPosition;", "cameraOrientation", "Lio/fotoapparat/hardware/orientation/Orientation;", "isMirrored", "", "(ILio/fotoapparat/characteristic/LensPosition;Lio/fotoapparat/hardware/orientation/Orientation;Z)V", "getCameraId", "()I", "getCameraOrientation", "()Lio/fotoapparat/hardware/orientation/Orientation;", "()Z", "getLensPosition", "()Lio/fotoapparat/characteristic/LensPosition;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Characteristics.kt */
public final class Characteristics {
    private final int cameraId;
    private final Orientation cameraOrientation;
    private final boolean isMirrored;
    private final LensPosition lensPosition;

    public static /* synthetic */ Characteristics copy$default(Characteristics characteristics, int i, LensPosition lensPosition2, Orientation orientation, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = characteristics.cameraId;
        }
        if ((i2 & 2) != 0) {
            lensPosition2 = characteristics.lensPosition;
        }
        if ((i2 & 4) != 0) {
            orientation = characteristics.cameraOrientation;
        }
        if ((i2 & 8) != 0) {
            z = characteristics.isMirrored;
        }
        return characteristics.copy(i, lensPosition2, orientation, z);
    }

    public final int component1() {
        return this.cameraId;
    }

    public final LensPosition component2() {
        return this.lensPosition;
    }

    public final Orientation component3() {
        return this.cameraOrientation;
    }

    public final boolean component4() {
        return this.isMirrored;
    }

    public final Characteristics copy(int i, LensPosition lensPosition2, Orientation orientation, boolean z) {
        Intrinsics.checkParameterIsNotNull(lensPosition2, "lensPosition");
        Intrinsics.checkParameterIsNotNull(orientation, "cameraOrientation");
        return new Characteristics(i, lensPosition2, orientation, z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Characteristics) {
                Characteristics characteristics = (Characteristics) obj;
                if ((this.cameraId == characteristics.cameraId) && Intrinsics.areEqual(this.lensPosition, characteristics.lensPosition) && Intrinsics.areEqual(this.cameraOrientation, characteristics.cameraOrientation)) {
                    if (this.isMirrored == characteristics.isMirrored) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.cameraId * 31;
        LensPosition lensPosition2 = this.lensPosition;
        int i2 = 0;
        int hashCode = (i + (lensPosition2 != null ? lensPosition2.hashCode() : 0)) * 31;
        Orientation orientation = this.cameraOrientation;
        if (orientation != null) {
            i2 = orientation.hashCode();
        }
        int i3 = (hashCode + i2) * 31;
        boolean z = this.isMirrored;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i3 + i4;
    }

    public String toString() {
        return "Characteristics(cameraId=" + this.cameraId + ", lensPosition=" + this.lensPosition + ", cameraOrientation=" + this.cameraOrientation + ", isMirrored=" + this.isMirrored + ")";
    }

    public Characteristics(int i, LensPosition lensPosition2, Orientation orientation, boolean z) {
        Intrinsics.checkParameterIsNotNull(lensPosition2, "lensPosition");
        Intrinsics.checkParameterIsNotNull(orientation, "cameraOrientation");
        this.cameraId = i;
        this.lensPosition = lensPosition2;
        this.cameraOrientation = orientation;
        this.isMirrored = z;
    }

    public final int getCameraId() {
        return this.cameraId;
    }

    public final LensPosition getLensPosition() {
        return this.lensPosition;
    }

    public final Orientation getCameraOrientation() {
        return this.cameraOrientation;
    }

    public final boolean isMirrored() {
        return this.isMirrored;
    }
}
