package org.opencv.ml;

import org.opencv.core.Mat;
import org.opencv.core.TermCriteria;

public class RTrees extends DTrees {
    @Override // org.opencv.ml.DTrees
    private static native long create_0();

    @Override // org.opencv.ml.StatModel, org.opencv.ml.DTrees, org.opencv.core.Algorithm
    private static native void delete(long j);

    private static native int getActiveVarCount_0(long j);

    private static native boolean getCalculateVarImportance_0(long j);

    private static native double[] getTermCriteria_0(long j);

    private static native long getVarImportance_0(long j);

    private static native void getVotes_0(long j, long j2, long j3, int i);

    @Override // org.opencv.ml.DTrees
    private static native long load_0(String str, String str2);

    @Override // org.opencv.ml.DTrees
    private static native long load_1(String str);

    private static native void setActiveVarCount_0(long j, int i);

    private static native void setCalculateVarImportance_0(long j, boolean z);

    private static native void setTermCriteria_0(long j, int i, int i2, double d);

    protected RTrees(long j) {
        super(j);
    }

    @Override // org.opencv.ml.StatModel, org.opencv.ml.DTrees, org.opencv.core.Algorithm
    public static RTrees __fromPtr__(long j) {
        return new RTrees(j);
    }

    public Mat getVarImportance() {
        return new Mat(getVarImportance_0(this.nativeObj));
    }

    @Override // org.opencv.ml.DTrees
    public static RTrees create() {
        return __fromPtr__(create_0());
    }

    @Override // org.opencv.ml.DTrees
    public static RTrees load(String str, String str2) {
        return __fromPtr__(load_0(str, str2));
    }

    @Override // org.opencv.ml.DTrees
    public static RTrees load(String str) {
        return __fromPtr__(load_1(str));
    }

    public TermCriteria getTermCriteria() {
        return new TermCriteria(getTermCriteria_0(this.nativeObj));
    }

    public boolean getCalculateVarImportance() {
        return getCalculateVarImportance_0(this.nativeObj);
    }

    public int getActiveVarCount() {
        return getActiveVarCount_0(this.nativeObj);
    }

    public void getVotes(Mat mat, Mat mat2, int i) {
        getVotes_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, i);
    }

    public void setActiveVarCount(int i) {
        setActiveVarCount_0(this.nativeObj, i);
    }

    public void setCalculateVarImportance(boolean z) {
        setCalculateVarImportance_0(this.nativeObj, z);
    }

    public void setTermCriteria(TermCriteria termCriteria) {
        setTermCriteria_0(this.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    /* access modifiers changed from: protected */
    @Override // org.opencv.ml.StatModel, org.opencv.ml.DTrees, org.opencv.core.Algorithm
    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
