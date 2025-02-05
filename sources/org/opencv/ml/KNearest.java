package org.opencv.ml;

import org.opencv.core.Mat;

public class KNearest extends StatModel {
    public static final int BRUTE_FORCE = 1;
    public static final int KDTREE = 2;

    private static native long create_0();

    @Override // org.opencv.ml.StatModel, org.opencv.core.Algorithm
    private static native void delete(long j);

    private static native float findNearest_0(long j, long j2, int i, long j3, long j4, long j5);

    private static native float findNearest_1(long j, long j2, int i, long j3);

    private static native int getAlgorithmType_0(long j);

    private static native int getDefaultK_0(long j);

    private static native int getEmax_0(long j);

    private static native boolean getIsClassifier_0(long j);

    private static native void setAlgorithmType_0(long j, int i);

    private static native void setDefaultK_0(long j, int i);

    private static native void setEmax_0(long j, int i);

    private static native void setIsClassifier_0(long j, boolean z);

    protected KNearest(long j) {
        super(j);
    }

    @Override // org.opencv.ml.StatModel, org.opencv.core.Algorithm
    public static KNearest __fromPtr__(long j) {
        return new KNearest(j);
    }

    public static KNearest create() {
        return __fromPtr__(create_0());
    }

    public boolean getIsClassifier() {
        return getIsClassifier_0(this.nativeObj);
    }

    public float findNearest(Mat mat, int i, Mat mat2, Mat mat3, Mat mat4) {
        return findNearest_0(this.nativeObj, mat.nativeObj, i, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public float findNearest(Mat mat, int i, Mat mat2) {
        return findNearest_1(this.nativeObj, mat.nativeObj, i, mat2.nativeObj);
    }

    public int getAlgorithmType() {
        return getAlgorithmType_0(this.nativeObj);
    }

    public int getDefaultK() {
        return getDefaultK_0(this.nativeObj);
    }

    public int getEmax() {
        return getEmax_0(this.nativeObj);
    }

    public void setAlgorithmType(int i) {
        setAlgorithmType_0(this.nativeObj, i);
    }

    public void setDefaultK(int i) {
        setDefaultK_0(this.nativeObj, i);
    }

    public void setEmax(int i) {
        setEmax_0(this.nativeObj, i);
    }

    public void setIsClassifier(boolean z) {
        setIsClassifier_0(this.nativeObj, z);
    }

    /* access modifiers changed from: protected */
    @Override // org.opencv.ml.StatModel, org.opencv.core.Algorithm
    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
