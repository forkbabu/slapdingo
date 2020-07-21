package org.opencv.android;

import android.hardware.Camera;
import android.util.Log;
import java.util.List;

public class CameraRenderer extends CameraGLRendererBase {
    public static final String LOGTAG = "CameraRenderer";
    private Camera mCamera;
    private boolean mPreviewStarted = false;

    CameraRenderer(CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
    }

    /* access modifiers changed from: protected */
    @Override // org.opencv.android.CameraGLRendererBase
    public synchronized void closeCamera() {
        Log.i(LOGTAG, "closeCamera");
        if (this.mCamera != null) {
            this.mCamera.stopPreview();
            this.mPreviewStarted = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ee  */
    @Override // org.opencv.android.CameraGLRendererBase
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void openCamera(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "CameraRenderer"
            java.lang.String r1 = "openCamera"
            android.util.Log.i(r0, r1)     // Catch:{ all -> 0x018d }
            r6.closeCamera()     // Catch:{ all -> 0x018d }
            r0 = -1
            r1 = 9
            r2 = 0
            r3 = 1
            if (r7 != r0) goto L_0x0097
            java.lang.String r7 = "CameraRenderer"
            java.lang.String r0 = "Trying to open camera with old open()"
            android.util.Log.d(r7, r0)     // Catch:{ all -> 0x018d }
            android.hardware.Camera r7 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x0020 }
            r6.mCamera = r7     // Catch:{ Exception -> 0x0020 }
            goto L_0x003b
        L_0x0020:
            r7 = move-exception
            java.lang.String r0 = "CameraRenderer"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Camera is not available (in use or does not exist): "
            r4.append(r5)
            java.lang.String r7 = r7.getLocalizedMessage()
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            android.util.Log.e(r0, r7)
        L_0x003b:
            android.hardware.Camera r7 = r6.mCamera
            if (r7 != 0) goto L_0x013d
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r1) goto L_0x013d
            r7 = 0
        L_0x0044:
            int r0 = android.hardware.Camera.getNumberOfCameras()
            if (r2 >= r0) goto L_0x013d
            java.lang.String r0 = "CameraRenderer"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "Trying to open camera with new open("
            r1.append(r4)
            r1.append(r2)
            java.lang.String r4 = ")"
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            android.hardware.Camera r0 = android.hardware.Camera.open(r2)     // Catch:{ RuntimeException -> 0x006d }
            r6.mCamera = r0     // Catch:{ RuntimeException -> 0x006d }
            r7 = 1
            goto L_0x0090
        L_0x006d:
            r0 = move-exception
            java.lang.String r1 = "CameraRenderer"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Camera #"
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = "failed to open: "
            r4.append(r5)
            java.lang.String r0 = r0.getLocalizedMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r1, r0)
        L_0x0090:
            if (r7 == 0) goto L_0x0094
            goto L_0x013d
        L_0x0094:
            int r2 = r2 + 1
            goto L_0x0044
        L_0x0097:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r1) goto L_0x013d
            int r7 = r6.mCameraIndex
            int r0 = r6.mCameraIndex
            r1 = 98
            r4 = 99
            if (r0 != r4) goto L_0x00c2
            java.lang.String r0 = "CameraRenderer"
            java.lang.String r3 = "Trying to open BACK camera"
            android.util.Log.i(r0, r3)
            android.hardware.Camera$CameraInfo r0 = new android.hardware.Camera$CameraInfo
            r0.<init>()
        L_0x00b1:
            int r3 = android.hardware.Camera.getNumberOfCameras()
            if (r2 >= r3) goto L_0x00e4
            android.hardware.Camera.getCameraInfo(r2, r0)
            int r3 = r0.facing
            if (r3 != 0) goto L_0x00bf
            goto L_0x00df
        L_0x00bf:
            int r2 = r2 + 1
            goto L_0x00b1
        L_0x00c2:
            int r0 = r6.mCameraIndex
            if (r0 != r1) goto L_0x00e4
            java.lang.String r0 = "CameraRenderer"
            java.lang.String r5 = "Trying to open FRONT camera"
            android.util.Log.i(r0, r5)
            android.hardware.Camera$CameraInfo r0 = new android.hardware.Camera$CameraInfo
            r0.<init>()
        L_0x00d2:
            int r5 = android.hardware.Camera.getNumberOfCameras()
            if (r2 >= r5) goto L_0x00e4
            android.hardware.Camera.getCameraInfo(r2, r0)
            int r5 = r0.facing
            if (r5 != r3) goto L_0x00e1
        L_0x00df:
            r7 = r2
            goto L_0x00e4
        L_0x00e1:
            int r2 = r2 + 1
            goto L_0x00d2
        L_0x00e4:
            if (r7 != r4) goto L_0x00ee
            java.lang.String r7 = "CameraRenderer"
            java.lang.String r0 = "Back camera not found!"
            android.util.Log.e(r7, r0)
            goto L_0x013d
        L_0x00ee:
            if (r7 != r1) goto L_0x00f8
            java.lang.String r7 = "CameraRenderer"
            java.lang.String r0 = "Front camera not found!"
            android.util.Log.e(r7, r0)
            goto L_0x013d
        L_0x00f8:
            java.lang.String r0 = "CameraRenderer"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Trying to open camera with new open("
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            android.hardware.Camera r0 = android.hardware.Camera.open(r7)     // Catch:{ RuntimeException -> 0x011a }
            r6.mCamera = r0     // Catch:{ RuntimeException -> 0x011a }
            goto L_0x013d
        L_0x011a:
            r0 = move-exception
            java.lang.String r1 = "CameraRenderer"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Camera #"
            r2.append(r3)
            r2.append(r7)
            java.lang.String r7 = "failed to open: "
            r2.append(r7)
            java.lang.String r7 = r0.getLocalizedMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.e(r1, r7)
        L_0x013d:
            android.hardware.Camera r7 = r6.mCamera
            if (r7 != 0) goto L_0x014a
            java.lang.String r7 = "CameraRenderer"
            java.lang.String r0 = "Error: can't open camera"
            android.util.Log.e(r7, r0)
            monitor-exit(r6)
            return
        L_0x014a:
            android.hardware.Camera r7 = r6.mCamera
            android.hardware.Camera$Parameters r7 = r7.getParameters()
            java.util.List r0 = r7.getSupportedFocusModes()
            if (r0 == 0) goto L_0x0163
            java.lang.String r1 = "continuous-video"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0163
            java.lang.String r0 = "continuous-video"
            r7.setFocusMode(r0)
        L_0x0163:
            android.hardware.Camera r0 = r6.mCamera
            r0.setParameters(r7)
            android.hardware.Camera r7 = r6.mCamera     // Catch:{ IOException -> 0x0170 }
            android.graphics.SurfaceTexture r0 = r6.mSTexture     // Catch:{ IOException -> 0x0170 }
            r7.setPreviewTexture(r0)     // Catch:{ IOException -> 0x0170 }
            goto L_0x018b
        L_0x0170:
            r7 = move-exception
            java.lang.String r0 = "CameraRenderer"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "setPreviewTexture() failed: "
            r1.append(r2)
            java.lang.String r7 = r7.getMessage()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            android.util.Log.e(r0, r7)
        L_0x018b:
            monitor-exit(r6)
            return
        L_0x018d:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.opencv.android.CameraRenderer.openCamera(int):void");
    }

    @Override // org.opencv.android.CameraGLRendererBase
    public synchronized void setCameraPreviewSize(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        synchronized (this) {
            Log.i(LOGTAG, "setCameraPreviewSize: " + i3 + "x" + i4);
            if (this.mCamera == null) {
                Log.e(LOGTAG, "Camera isn't initialized!");
                return;
            }
            if (this.mMaxCameraWidth > 0 && this.mMaxCameraWidth < i3) {
                i3 = this.mMaxCameraWidth;
            }
            if (this.mMaxCameraHeight > 0 && this.mMaxCameraHeight < i4) {
                i4 = this.mMaxCameraHeight;
            }
            Camera.Parameters parameters = this.mCamera.getParameters();
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes.size() > 0) {
                float f = ((float) i3) / ((float) i4);
                int i5 = 0;
                int i6 = 0;
                for (Camera.Size size : supportedPreviewSizes) {
                    int i7 = size.width;
                    int i8 = size.height;
                    Log.d(LOGTAG, "checking camera preview size: " + i7 + "x" + i8);
                    if (i7 <= i3 && i8 <= i4 && i7 >= i5 && i8 >= i6 && ((double) Math.abs(f - (((float) i7) / ((float) i8)))) < 0.2d) {
                        i6 = i8;
                        i5 = i7;
                    }
                }
                if (i5 <= 0 || i6 <= 0) {
                    i5 = supportedPreviewSizes.get(0).width;
                    i6 = supportedPreviewSizes.get(0).height;
                    Log.e(LOGTAG, "Error: best size was not selected, using " + i5 + " x " + i6);
                } else {
                    Log.i(LOGTAG, "Selected best size: " + i5 + " x " + i6);
                }
                if (this.mPreviewStarted) {
                    this.mCamera.stopPreview();
                    this.mPreviewStarted = false;
                }
                this.mCameraWidth = i5;
                this.mCameraHeight = i6;
                parameters.setPreviewSize(i5, i6);
            }
            parameters.set("orientation", "landscape");
            this.mCamera.setParameters(parameters);
            this.mCamera.startPreview();
            this.mPreviewStarted = true;
        }
    }
}
