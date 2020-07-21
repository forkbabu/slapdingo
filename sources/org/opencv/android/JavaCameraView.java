package org.opencv.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class JavaCameraView extends CameraBridgeViewBase implements Camera.PreviewCallback {
    private static final int MAGIC_TEXTURE_ID = 10;
    private static final String TAG = "JavaCameraView";
    private byte[] mBuffer;
    protected Camera mCamera;
    protected JavaCameraFrame[] mCameraFrame;
    /* access modifiers changed from: private */
    public boolean mCameraFrameReady = false;
    /* access modifiers changed from: private */
    public int mChainIdx = 0;
    /* access modifiers changed from: private */
    public Mat[] mFrameChain;
    /* access modifiers changed from: private */
    public int mPreviewFormat = 17;
    /* access modifiers changed from: private */
    public boolean mStopThread;
    private SurfaceTexture mSurfaceTexture;
    private Thread mThread;

    public static class JavaCameraSizeAccessor implements CameraBridgeViewBase.ListItemAccessor {
        @Override // org.opencv.android.CameraBridgeViewBase.ListItemAccessor
        public int getWidth(Object obj) {
            return ((Camera.Size) obj).width;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.ListItemAccessor
        public int getHeight(Object obj) {
            return ((Camera.Size) obj).height;
        }
    }

    public JavaCameraView(Context context, int i) {
        super(context, i);
    }

    public JavaCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0279 A[Catch:{ Exception -> 0x031a }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02f8 A[Catch:{ Exception -> 0x031a }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0307 A[Catch:{ Exception -> 0x031a }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean initializeCamera(int r11, int r12) {
        /*
            r10 = this;
            java.lang.String r0 = "JavaCameraView"
            java.lang.String r1 = "Initialize java camera"
            android.util.Log.d(r0, r1)
            monitor-enter(r10)
            r0 = 0
            r10.mCamera = r0     // Catch:{ all -> 0x0320 }
            int r1 = r10.mCameraIndex     // Catch:{ all -> 0x0320 }
            r2 = 9
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 != r3) goto L_0x009e
            java.lang.String r1 = "JavaCameraView"
            java.lang.String r6 = "Trying to open camera with old open()"
            android.util.Log.d(r1, r6)     // Catch:{ all -> 0x0320 }
            android.hardware.Camera r1 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x0022 }
            r10.mCamera = r1     // Catch:{ Exception -> 0x0022 }
            goto L_0x003d
        L_0x0022:
            r1 = move-exception
            java.lang.String r6 = "JavaCameraView"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Camera is not available (in use or does not exist): "
            r7.append(r8)
            java.lang.String r1 = r1.getLocalizedMessage()
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            android.util.Log.e(r6, r1)
        L_0x003d:
            android.hardware.Camera r1 = r10.mCamera
            if (r1 != 0) goto L_0x014a
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r2) goto L_0x014a
            r1 = 0
            r2 = 0
        L_0x0047:
            int r6 = android.hardware.Camera.getNumberOfCameras()
            if (r1 >= r6) goto L_0x014a
            java.lang.String r6 = "JavaCameraView"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Trying to open camera with new open("
            r7.append(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            r7.append(r8)
            java.lang.String r8 = ")"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r6, r7)
            android.hardware.Camera r6 = android.hardware.Camera.open(r1)     // Catch:{ RuntimeException -> 0x0074 }
            r10.mCamera = r6     // Catch:{ RuntimeException -> 0x0074 }
            r2 = 1
            goto L_0x0097
        L_0x0074:
            r6 = move-exception
            java.lang.String r7 = "JavaCameraView"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Camera #"
            r8.append(r9)
            r8.append(r1)
            java.lang.String r9 = "failed to open: "
            r8.append(r9)
            java.lang.String r6 = r6.getLocalizedMessage()
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            android.util.Log.e(r7, r6)
        L_0x0097:
            if (r2 == 0) goto L_0x009b
            goto L_0x014a
        L_0x009b:
            int r1 = r1 + 1
            goto L_0x0047
        L_0x009e:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r2) goto L_0x014a
            int r1 = r10.mCameraIndex
            int r2 = r10.mCameraIndex
            r6 = 98
            r7 = 99
            if (r2 != r7) goto L_0x00ca
            java.lang.String r2 = "JavaCameraView"
            java.lang.String r8 = "Trying to open back camera"
            android.util.Log.i(r2, r8)
            android.hardware.Camera$CameraInfo r2 = new android.hardware.Camera$CameraInfo
            r2.<init>()
            r8 = 0
        L_0x00b9:
            int r9 = android.hardware.Camera.getNumberOfCameras()
            if (r8 >= r9) goto L_0x00ed
            android.hardware.Camera.getCameraInfo(r8, r2)
            int r9 = r2.facing
            if (r9 != 0) goto L_0x00c7
            goto L_0x00e8
        L_0x00c7:
            int r8 = r8 + 1
            goto L_0x00b9
        L_0x00ca:
            int r2 = r10.mCameraIndex
            if (r2 != r6) goto L_0x00ed
            java.lang.String r2 = "JavaCameraView"
            java.lang.String r8 = "Trying to open front camera"
            android.util.Log.i(r2, r8)
            android.hardware.Camera$CameraInfo r2 = new android.hardware.Camera$CameraInfo
            r2.<init>()
            r8 = 0
        L_0x00db:
            int r9 = android.hardware.Camera.getNumberOfCameras()
            if (r8 >= r9) goto L_0x00ed
            android.hardware.Camera.getCameraInfo(r8, r2)
            int r9 = r2.facing
            if (r9 != r5) goto L_0x00ea
        L_0x00e8:
            r1 = r8
            goto L_0x00ed
        L_0x00ea:
            int r8 = r8 + 1
            goto L_0x00db
        L_0x00ed:
            if (r1 != r7) goto L_0x00f7
            java.lang.String r1 = "JavaCameraView"
            java.lang.String r2 = "Back camera not found!"
            android.util.Log.e(r1, r2)
            goto L_0x014a
        L_0x00f7:
            if (r1 != r6) goto L_0x0101
            java.lang.String r1 = "JavaCameraView"
            java.lang.String r2 = "Front camera not found!"
            android.util.Log.e(r1, r2)
            goto L_0x014a
        L_0x0101:
            java.lang.String r2 = "JavaCameraView"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Trying to open camera with new open("
            r6.append(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            r6.append(r7)
            java.lang.String r7 = ")"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r2, r6)
            android.hardware.Camera r2 = android.hardware.Camera.open(r1)     // Catch:{ RuntimeException -> 0x0127 }
            r10.mCamera = r2     // Catch:{ RuntimeException -> 0x0127 }
            goto L_0x014a
        L_0x0127:
            r2 = move-exception
            java.lang.String r6 = "JavaCameraView"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Camera #"
            r7.append(r8)
            r7.append(r1)
            java.lang.String r1 = "failed to open: "
            r7.append(r1)
            java.lang.String r1 = r2.getLocalizedMessage()
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            android.util.Log.e(r6, r1)
        L_0x014a:
            android.hardware.Camera r1 = r10.mCamera
            if (r1 != 0) goto L_0x0150
            monitor-exit(r10)
            return r4
        L_0x0150:
            android.hardware.Camera r1 = r10.mCamera     // Catch:{ Exception -> 0x031a }
            android.hardware.Camera$Parameters r1 = r1.getParameters()     // Catch:{ Exception -> 0x031a }
            java.lang.String r2 = "JavaCameraView"
            java.lang.String r6 = "getSupportedPreviewSizes()"
            android.util.Log.d(r2, r6)     // Catch:{ Exception -> 0x031a }
            java.util.List r2 = r1.getSupportedPreviewSizes()     // Catch:{ Exception -> 0x031a }
            if (r2 == 0) goto L_0x031e
            org.opencv.android.JavaCameraView$JavaCameraSizeAccessor r6 = new org.opencv.android.JavaCameraView$JavaCameraSizeAccessor     // Catch:{ Exception -> 0x031a }
            r6.<init>()     // Catch:{ Exception -> 0x031a }
            org.opencv.core.Size r2 = r10.calculateCameraFrameSize(r2, r6, r11, r12)     // Catch:{ Exception -> 0x031a }
            java.lang.String r6 = android.os.Build.FINGERPRINT     // Catch:{ Exception -> 0x031a }
            java.lang.String r7 = "generic"
            boolean r6 = r6.startsWith(r7)     // Catch:{ Exception -> 0x031a }
            if (r6 != 0) goto L_0x01ce
            java.lang.String r6 = android.os.Build.FINGERPRINT     // Catch:{ Exception -> 0x031a }
            java.lang.String r7 = "unknown"
            boolean r6 = r6.startsWith(r7)     // Catch:{ Exception -> 0x031a }
            if (r6 != 0) goto L_0x01ce
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ Exception -> 0x031a }
            java.lang.String r7 = "google_sdk"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x031a }
            if (r6 != 0) goto L_0x01ce
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ Exception -> 0x031a }
            java.lang.String r7 = "Emulator"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x031a }
            if (r6 != 0) goto L_0x01ce
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ Exception -> 0x031a }
            java.lang.String r7 = "Android SDK built for x86"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x031a }
            if (r6 != 0) goto L_0x01ce
            java.lang.String r6 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x031a }
            java.lang.String r7 = "Genymotion"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x031a }
            if (r6 != 0) goto L_0x01ce
            java.lang.String r6 = android.os.Build.BRAND     // Catch:{ Exception -> 0x031a }
            java.lang.String r7 = "generic"
            boolean r6 = r6.startsWith(r7)     // Catch:{ Exception -> 0x031a }
            if (r6 == 0) goto L_0x01bd
            java.lang.String r6 = android.os.Build.DEVICE     // Catch:{ Exception -> 0x031a }
            java.lang.String r7 = "generic"
            boolean r6 = r6.startsWith(r7)     // Catch:{ Exception -> 0x031a }
            if (r6 != 0) goto L_0x01ce
        L_0x01bd:
            java.lang.String r6 = "google_sdk"
            java.lang.String r7 = android.os.Build.PRODUCT     // Catch:{ Exception -> 0x031a }
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x031a }
            if (r6 == 0) goto L_0x01c8
            goto L_0x01ce
        L_0x01c8:
            r6 = 17
            r1.setPreviewFormat(r6)     // Catch:{ Exception -> 0x031a }
            goto L_0x01d4
        L_0x01ce:
            r6 = 842094169(0x32315659, float:1.0322389E-8)
            r1.setPreviewFormat(r6)     // Catch:{ Exception -> 0x031a }
        L_0x01d4:
            int r6 = r1.getPreviewFormat()     // Catch:{ Exception -> 0x031a }
            r10.mPreviewFormat = r6     // Catch:{ Exception -> 0x031a }
            java.lang.String r6 = "JavaCameraView"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031a }
            r7.<init>()     // Catch:{ Exception -> 0x031a }
            java.lang.String r8 = "Set preview size to "
            r7.append(r8)     // Catch:{ Exception -> 0x031a }
            double r8 = r2.width     // Catch:{ Exception -> 0x031a }
            int r8 = (int) r8     // Catch:{ Exception -> 0x031a }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x031a }
            r7.append(r8)     // Catch:{ Exception -> 0x031a }
            java.lang.String r8 = "x"
            r7.append(r8)     // Catch:{ Exception -> 0x031a }
            double r8 = r2.height     // Catch:{ Exception -> 0x031a }
            int r8 = (int) r8     // Catch:{ Exception -> 0x031a }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x031a }
            r7.append(r8)     // Catch:{ Exception -> 0x031a }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x031a }
            android.util.Log.d(r6, r7)     // Catch:{ Exception -> 0x031a }
            double r6 = r2.width     // Catch:{ Exception -> 0x031a }
            int r6 = (int) r6     // Catch:{ Exception -> 0x031a }
            double r7 = r2.height     // Catch:{ Exception -> 0x031a }
            int r2 = (int) r7     // Catch:{ Exception -> 0x031a }
            r1.setPreviewSize(r6, r2)     // Catch:{ Exception -> 0x031a }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x031a }
            r6 = 14
            if (r2 < r6) goto L_0x0223
            java.lang.String r2 = android.os.Build.MODEL     // Catch:{ Exception -> 0x031a }
            java.lang.String r6 = "GT-I9100"
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x031a }
            if (r2 != 0) goto L_0x0223
            r1.setRecordingHint(r5)     // Catch:{ Exception -> 0x031a }
        L_0x0223:
            java.util.List r2 = r1.getSupportedFocusModes()     // Catch:{ Exception -> 0x031a }
            if (r2 == 0) goto L_0x0236
            java.lang.String r6 = "continuous-video"
            boolean r2 = r2.contains(r6)     // Catch:{ Exception -> 0x031a }
            if (r2 == 0) goto L_0x0236
            java.lang.String r2 = "continuous-video"
            r1.setFocusMode(r2)     // Catch:{ Exception -> 0x031a }
        L_0x0236:
            android.hardware.Camera r2 = r10.mCamera     // Catch:{ Exception -> 0x031a }
            r2.setParameters(r1)     // Catch:{ Exception -> 0x031a }
            android.hardware.Camera r1 = r10.mCamera     // Catch:{ Exception -> 0x031a }
            android.hardware.Camera$Parameters r1 = r1.getParameters()     // Catch:{ Exception -> 0x031a }
            android.hardware.Camera$Size r2 = r1.getPreviewSize()     // Catch:{ Exception -> 0x031a }
            int r2 = r2.width     // Catch:{ Exception -> 0x031a }
            r10.mFrameWidth = r2     // Catch:{ Exception -> 0x031a }
            android.hardware.Camera$Size r2 = r1.getPreviewSize()     // Catch:{ Exception -> 0x031a }
            int r2 = r2.height     // Catch:{ Exception -> 0x031a }
            r10.mFrameHeight = r2     // Catch:{ Exception -> 0x031a }
            android.view.ViewGroup$LayoutParams r2 = r10.getLayoutParams()     // Catch:{ Exception -> 0x031a }
            int r2 = r2.width     // Catch:{ Exception -> 0x031a }
            if (r2 != r3) goto L_0x0272
            android.view.ViewGroup$LayoutParams r2 = r10.getLayoutParams()     // Catch:{ Exception -> 0x031a }
            int r2 = r2.height     // Catch:{ Exception -> 0x031a }
            if (r2 != r3) goto L_0x0272
            float r12 = (float) r12     // Catch:{ Exception -> 0x031a }
            int r2 = r10.mFrameHeight     // Catch:{ Exception -> 0x031a }
            float r2 = (float) r2     // Catch:{ Exception -> 0x031a }
            float r12 = r12 / r2
            float r11 = (float) r11     // Catch:{ Exception -> 0x031a }
            int r2 = r10.mFrameWidth     // Catch:{ Exception -> 0x031a }
            float r2 = (float) r2     // Catch:{ Exception -> 0x031a }
            float r11 = r11 / r2
            float r11 = java.lang.Math.min(r12, r11)     // Catch:{ Exception -> 0x031a }
            r10.mScale = r11     // Catch:{ Exception -> 0x031a }
            goto L_0x0275
        L_0x0272:
            r11 = 0
            r10.mScale = r11     // Catch:{ Exception -> 0x031a }
        L_0x0275:
            org.opencv.android.FpsMeter r11 = r10.mFpsMeter     // Catch:{ Exception -> 0x031a }
            if (r11 == 0) goto L_0x0282
            org.opencv.android.FpsMeter r11 = r10.mFpsMeter     // Catch:{ Exception -> 0x031a }
            int r12 = r10.mFrameWidth     // Catch:{ Exception -> 0x031a }
            int r2 = r10.mFrameHeight     // Catch:{ Exception -> 0x031a }
            r11.setResolution(r12, r2)     // Catch:{ Exception -> 0x031a }
        L_0x0282:
            int r11 = r10.mFrameWidth     // Catch:{ Exception -> 0x031a }
            int r12 = r10.mFrameHeight     // Catch:{ Exception -> 0x031a }
            int r11 = r11 * r12
            int r12 = r1.getPreviewFormat()     // Catch:{ Exception -> 0x031a }
            int r12 = android.graphics.ImageFormat.getBitsPerPixel(r12)     // Catch:{ Exception -> 0x031a }
            int r11 = r11 * r12
            int r11 = r11 / 8
            byte[] r11 = new byte[r11]     // Catch:{ Exception -> 0x031a }
            r10.mBuffer = r11     // Catch:{ Exception -> 0x031a }
            android.hardware.Camera r12 = r10.mCamera     // Catch:{ Exception -> 0x031a }
            r12.addCallbackBuffer(r11)     // Catch:{ Exception -> 0x031a }
            android.hardware.Camera r11 = r10.mCamera     // Catch:{ Exception -> 0x031a }
            r11.setPreviewCallbackWithBuffer(r10)     // Catch:{ Exception -> 0x031a }
            r11 = 2
            org.opencv.core.Mat[] r12 = new org.opencv.core.Mat[r11]     // Catch:{ Exception -> 0x031a }
            r10.mFrameChain = r12     // Catch:{ Exception -> 0x031a }
            org.opencv.core.Mat r1 = new org.opencv.core.Mat     // Catch:{ Exception -> 0x031a }
            int r2 = r10.mFrameHeight     // Catch:{ Exception -> 0x031a }
            int r3 = r10.mFrameHeight     // Catch:{ Exception -> 0x031a }
            int r3 = r3 / r11
            int r2 = r2 + r3
            int r3 = r10.mFrameWidth     // Catch:{ Exception -> 0x031a }
            int r6 = org.opencv.core.CvType.CV_8UC1     // Catch:{ Exception -> 0x031a }
            r1.<init>(r2, r3, r6)     // Catch:{ Exception -> 0x031a }
            r12[r4] = r1     // Catch:{ Exception -> 0x031a }
            org.opencv.core.Mat[] r12 = r10.mFrameChain     // Catch:{ Exception -> 0x031a }
            org.opencv.core.Mat r1 = new org.opencv.core.Mat     // Catch:{ Exception -> 0x031a }
            int r2 = r10.mFrameHeight     // Catch:{ Exception -> 0x031a }
            int r3 = r10.mFrameHeight     // Catch:{ Exception -> 0x031a }
            int r3 = r3 / r11
            int r2 = r2 + r3
            int r3 = r10.mFrameWidth     // Catch:{ Exception -> 0x031a }
            int r6 = org.opencv.core.CvType.CV_8UC1     // Catch:{ Exception -> 0x031a }
            r1.<init>(r2, r3, r6)     // Catch:{ Exception -> 0x031a }
            r12[r5] = r1     // Catch:{ Exception -> 0x031a }
            r10.AllocateCache()     // Catch:{ Exception -> 0x031a }
            org.opencv.android.JavaCameraView$JavaCameraFrame[] r11 = new org.opencv.android.JavaCameraView.JavaCameraFrame[r11]     // Catch:{ Exception -> 0x031a }
            r10.mCameraFrame = r11     // Catch:{ Exception -> 0x031a }
            org.opencv.android.JavaCameraView$JavaCameraFrame r12 = new org.opencv.android.JavaCameraView$JavaCameraFrame     // Catch:{ Exception -> 0x031a }
            org.opencv.core.Mat[] r1 = r10.mFrameChain     // Catch:{ Exception -> 0x031a }
            r1 = r1[r4]     // Catch:{ Exception -> 0x031a }
            int r2 = r10.mFrameWidth     // Catch:{ Exception -> 0x031a }
            int r3 = r10.mFrameHeight     // Catch:{ Exception -> 0x031a }
            r12.<init>(r1, r2, r3)     // Catch:{ Exception -> 0x031a }
            r11[r4] = r12     // Catch:{ Exception -> 0x031a }
            org.opencv.android.JavaCameraView$JavaCameraFrame[] r11 = r10.mCameraFrame     // Catch:{ Exception -> 0x031a }
            org.opencv.android.JavaCameraView$JavaCameraFrame r12 = new org.opencv.android.JavaCameraView$JavaCameraFrame     // Catch:{ Exception -> 0x031a }
            org.opencv.core.Mat[] r1 = r10.mFrameChain     // Catch:{ Exception -> 0x031a }
            r1 = r1[r5]     // Catch:{ Exception -> 0x031a }
            int r2 = r10.mFrameWidth     // Catch:{ Exception -> 0x031a }
            int r3 = r10.mFrameHeight     // Catch:{ Exception -> 0x031a }
            r12.<init>(r1, r2, r3)     // Catch:{ Exception -> 0x031a }
            r11[r5] = r12     // Catch:{ Exception -> 0x031a }
            int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x031a }
            r12 = 11
            if (r11 < r12) goto L_0x0307
            android.graphics.SurfaceTexture r11 = new android.graphics.SurfaceTexture     // Catch:{ Exception -> 0x031a }
            r12 = 10
            r11.<init>(r12)     // Catch:{ Exception -> 0x031a }
            r10.mSurfaceTexture = r11     // Catch:{ Exception -> 0x031a }
            android.hardware.Camera r12 = r10.mCamera     // Catch:{ Exception -> 0x031a }
            r12.setPreviewTexture(r11)     // Catch:{ Exception -> 0x031a }
            goto L_0x030c
        L_0x0307:
            android.hardware.Camera r11 = r10.mCamera     // Catch:{ Exception -> 0x031a }
            r11.setPreviewDisplay(r0)     // Catch:{ Exception -> 0x031a }
        L_0x030c:
            java.lang.String r11 = "JavaCameraView"
            java.lang.String r12 = "startPreview"
            android.util.Log.d(r11, r12)     // Catch:{ Exception -> 0x031a }
            android.hardware.Camera r11 = r10.mCamera     // Catch:{ Exception -> 0x031a }
            r11.startPreview()     // Catch:{ Exception -> 0x031a }
            r4 = 1
            goto L_0x031e
        L_0x031a:
            r11 = move-exception
            r11.printStackTrace()
        L_0x031e:
            monitor-exit(r10)
            return r4
        L_0x0320:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.opencv.android.JavaCameraView.initializeCamera(int, int):boolean");
    }

    /* access modifiers changed from: protected */
    public void releaseCamera() {
        synchronized (this) {
            if (this.mCamera != null) {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback(null);
                this.mCamera.release();
            }
            this.mCamera = null;
            if (this.mFrameChain != null) {
                this.mFrameChain[0].release();
                this.mFrameChain[1].release();
            }
            if (this.mCameraFrame != null) {
                this.mCameraFrame[0].release();
                this.mCameraFrame[1].release();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.opencv.android.CameraBridgeViewBase
    public boolean connectCamera(int i, int i2) {
        Log.d(TAG, "Connecting to camera");
        if (!initializeCamera(i, i2)) {
            return false;
        }
        this.mCameraFrameReady = false;
        Log.d(TAG, "Starting processing thread");
        this.mStopThread = false;
        Thread thread = new Thread(new CameraWorker());
        this.mThread = thread;
        thread.start();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // org.opencv.android.CameraBridgeViewBase
    public void disconnectCamera() {
        Log.d(TAG, "Disconnecting from camera");
        try {
            this.mStopThread = true;
            Log.d(TAG, "Notify thread");
            synchronized (this) {
                notify();
            }
            Log.d(TAG, "Waiting for thread");
            if (this.mThread != null) {
                this.mThread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.mThread = null;
            throw th;
        }
        this.mThread = null;
        releaseCamera();
        this.mCameraFrameReady = false;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this) {
            this.mFrameChain[this.mChainIdx].put(0, 0, bArr);
            this.mCameraFrameReady = true;
            notify();
        }
        Camera camera2 = this.mCamera;
        if (camera2 != null) {
            camera2.addCallbackBuffer(this.mBuffer);
        }
    }

    private class JavaCameraFrame implements CameraBridgeViewBase.CvCameraViewFrame {
        private int mHeight;
        private Mat mRgba = new Mat();
        private int mWidth;
        private Mat mYuvFrameData;

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public Mat gray() {
            return this.mYuvFrameData.submat(0, this.mHeight, 0, this.mWidth);
        }

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public Mat rgba() {
            if (JavaCameraView.this.mPreviewFormat == 17) {
                Imgproc.cvtColor(this.mYuvFrameData, this.mRgba, 96, 4);
            } else if (JavaCameraView.this.mPreviewFormat == 842094169) {
                Imgproc.cvtColor(this.mYuvFrameData, this.mRgba, 100, 4);
            } else {
                throw new IllegalArgumentException("Preview Format can be NV21 or YV12");
            }
            return this.mRgba;
        }

        public JavaCameraFrame(Mat mat, int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
            this.mYuvFrameData = mat;
        }

        public void release() {
            this.mRgba.release();
        }
    }

    private class CameraWorker implements Runnable {
        private CameraWorker() {
        }

        public void run() {
            boolean z;
            do {
                synchronized (JavaCameraView.this) {
                    while (!JavaCameraView.this.mCameraFrameReady && !JavaCameraView.this.mStopThread) {
                        try {
                            JavaCameraView.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    z = false;
                    if (JavaCameraView.this.mCameraFrameReady) {
                        int unused = JavaCameraView.this.mChainIdx = 1 - JavaCameraView.this.mChainIdx;
                        boolean unused2 = JavaCameraView.this.mCameraFrameReady = false;
                        z = true;
                    }
                }
                if (!JavaCameraView.this.mStopThread && z && !JavaCameraView.this.mFrameChain[1 - JavaCameraView.this.mChainIdx].empty()) {
                    JavaCameraView javaCameraView = JavaCameraView.this;
                    javaCameraView.deliverAndDrawFrame(javaCameraView.mCameraFrame[1 - JavaCameraView.this.mChainIdx]);
                }
            } while (!JavaCameraView.this.mStopThread);
            Log.d(JavaCameraView.TAG, "Finish processing thread");
        }
    }
}
