package org.opencv.features2d;

import org.opencv.core.Mat;
import org.opencv.core.TermCriteria;

public class BOWKMeansTrainer extends BOWTrainer {
    private static native long BOWKMeansTrainer_0(int i, int i2, int i3, double d, int i4, int i5);

    private static native long BOWKMeansTrainer_1(int i);

    @Override // org.opencv.features2d.BOWTrainer
    private static native long cluster_0(long j, long j2);

    @Override // org.opencv.features2d.BOWTrainer
    private static native long cluster_1(long j);

    @Override // org.opencv.features2d.BOWTrainer
    private static native void delete(long j);

    protected BOWKMeansTrainer(long j) {
        super(j);
    }

    @Override // org.opencv.features2d.BOWTrainer
    public static BOWKMeansTrainer __fromPtr__(long j) {
        return new BOWKMeansTrainer(j);
    }

    public BOWKMeansTrainer(int i, TermCriteria termCriteria, int i2, int i3) {
        super(BOWKMeansTrainer_0(i, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, i2, i3));
    }

    public BOWKMeansTrainer(int i) {
        super(BOWKMeansTrainer_1(i));
    }

    @Override // org.opencv.features2d.BOWTrainer
    public Mat cluster(Mat mat) {
        return new Mat(cluster_0(this.nativeObj, mat.nativeObj));
    }

    @Override // org.opencv.features2d.BOWTrainer
    public Mat cluster() {
        return new Mat(cluster_1(this.nativeObj));
    }

    /* access modifiers changed from: protected */
    @Override // org.opencv.features2d.BOWTrainer
    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
