package org.opencv.features2d;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfRect;
import org.opencv.utils.Converters;

public class MSER extends Feature2D {
    private static native long create_0(int i, int i2, int i3, double d, double d2, int i4, double d3, double d4, int i5);

    private static native long create_1();

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    private static native void delete(long j);

    private static native void detectRegions_0(long j, long j2, long j3, long j4);

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    private static native String getDefaultName_0(long j);

    private static native int getDelta_0(long j);

    private static native int getMaxArea_0(long j);

    private static native int getMinArea_0(long j);

    private static native boolean getPass2Only_0(long j);

    private static native void setDelta_0(long j, int i);

    private static native void setMaxArea_0(long j, int i);

    private static native void setMinArea_0(long j, int i);

    private static native void setPass2Only_0(long j, boolean z);

    protected MSER(long j) {
        super(j);
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public static MSER __fromPtr__(long j) {
        return new MSER(j);
    }

    public static MSER create(int i, int i2, int i3, double d, double d2, int i4, double d3, double d4, int i5) {
        return __fromPtr__(create_0(i, i2, i3, d, d2, i4, d3, d4, i5));
    }

    public static MSER create() {
        return __fromPtr__(create_1());
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public boolean getPass2Only() {
        return getPass2Only_0(this.nativeObj);
    }

    public int getDelta() {
        return getDelta_0(this.nativeObj);
    }

    public int getMaxArea() {
        return getMaxArea_0(this.nativeObj);
    }

    public int getMinArea() {
        return getMinArea_0(this.nativeObj);
    }

    public void detectRegions(Mat mat, List<MatOfPoint> list, MatOfRect matOfRect) {
        Mat mat2 = new Mat();
        detectRegions_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, ((Mat) matOfRect).nativeObj);
        Converters.Mat_to_vector_vector_Point(mat2, list);
        mat2.release();
    }

    public void setDelta(int i) {
        setDelta_0(this.nativeObj, i);
    }

    public void setMaxArea(int i) {
        setMaxArea_0(this.nativeObj, i);
    }

    public void setMinArea(int i) {
        setMinArea_0(this.nativeObj, i);
    }

    public void setPass2Only(boolean z) {
        setPass2Only_0(this.nativeObj, z);
    }

    /* access modifiers changed from: protected */
    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
