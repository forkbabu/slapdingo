package org.opencv.features2d;

public class FlannBasedMatcher extends DescriptorMatcher {
    private static native long FlannBasedMatcher_0();

    private static native long create_0();

    @Override // org.opencv.core.Algorithm, org.opencv.features2d.DescriptorMatcher
    private static native void delete(long j);

    protected FlannBasedMatcher(long j) {
        super(j);
    }

    @Override // org.opencv.core.Algorithm, org.opencv.features2d.DescriptorMatcher
    public static FlannBasedMatcher __fromPtr__(long j) {
        return new FlannBasedMatcher(j);
    }

    public FlannBasedMatcher() {
        super(FlannBasedMatcher_0());
    }

    public static FlannBasedMatcher create() {
        return __fromPtr__(create_0());
    }

    /* access modifiers changed from: protected */
    @Override // org.opencv.core.Algorithm, org.opencv.features2d.DescriptorMatcher
    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
