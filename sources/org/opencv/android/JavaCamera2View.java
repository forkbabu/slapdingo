package org.opencv.android;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class JavaCamera2View extends CameraBridgeViewBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String LOGTAG = "JavaCamera2View";
    /* access modifiers changed from: private */
    public Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    /* access modifiers changed from: private */
    public CameraDevice mCameraDevice;
    private String mCameraID;
    /* access modifiers changed from: private */
    public CameraCaptureSession mCaptureSession;
    private ImageReader mImageReader;
    /* access modifiers changed from: private */
    public int mPreviewFormat = 35;
    /* access modifiers changed from: private */
    public CaptureRequest.Builder mPreviewRequestBuilder;
    private Size mPreviewSize = new Size(-1, -1);
    private final CameraDevice.StateCallback mStateCallback = new CameraDevice.StateCallback() {
        /* class org.opencv.android.JavaCamera2View.AnonymousClass1 */

        public void onOpened(CameraDevice cameraDevice) {
            CameraDevice unused = JavaCamera2View.this.mCameraDevice = cameraDevice;
            JavaCamera2View.this.createCameraPreviewSession();
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            CameraDevice unused = JavaCamera2View.this.mCameraDevice = null;
        }

        public void onError(CameraDevice cameraDevice, int i) {
            cameraDevice.close();
            CameraDevice unused = JavaCamera2View.this.mCameraDevice = null;
        }
    };

    public JavaCamera2View(Context context, int i) {
        super(context, i);
    }

    public JavaCamera2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void startBackgroundThread() {
        Log.i(LOGTAG, "startBackgroundThread");
        stopBackgroundThread();
        HandlerThread handlerThread = new HandlerThread("OpenCVCameraBackground");
        this.mBackgroundThread = handlerThread;
        handlerThread.start();
        this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper());
    }

    private void stopBackgroundThread() {
        Log.i(LOGTAG, "stopBackgroundThread");
        HandlerThread handlerThread = this.mBackgroundThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.mBackgroundThread.join();
                this.mBackgroundThread = null;
                this.mBackgroundHandler = null;
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "stopBackgroundThread", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        r11.mCameraID = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean initializeCamera() {
        /*
            r11 = this;
            java.lang.String r0 = "JavaCamera2View"
            java.lang.String r1 = "initializeCamera"
            android.util.Log.i(r0, r1)
            android.content.Context r1 = r11.getContext()
            java.lang.String r2 = "camera"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.hardware.camera2.CameraManager r1 = (android.hardware.camera2.CameraManager) r1
            r2 = 0
            java.lang.String[] r3 = r1.getCameraIdList()     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            int r4 = r3.length     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            if (r4 != 0) goto L_0x0021
            java.lang.String r1 = "Error: camera isn't detected."
            android.util.Log.e(r0, r1)     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            return r2
        L_0x0021:
            int r4 = r11.mCameraIndex     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            r5 = -1
            r6 = 1
            if (r4 != r5) goto L_0x002c
            r3 = r3[r2]     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            r11.mCameraID = r3     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            goto L_0x0064
        L_0x002c:
            int r4 = r3.length     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            r5 = 0
        L_0x002e:
            if (r5 >= r4) goto L_0x0064
            r7 = r3[r5]     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            android.hardware.camera2.CameraCharacteristics r8 = r1.getCameraCharacteristics(r7)     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            int r9 = r11.mCameraIndex     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            r10 = 99
            if (r9 != r10) goto L_0x004a
            android.hardware.camera2.CameraCharacteristics$Key r9 = android.hardware.camera2.CameraCharacteristics.LENS_FACING     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            java.lang.Object r9 = r8.get(r9)     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            int r9 = r9.intValue()     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            if (r9 == r6) goto L_0x005e
        L_0x004a:
            int r9 = r11.mCameraIndex     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            r10 = 98
            if (r9 != r10) goto L_0x0061
            android.hardware.camera2.CameraCharacteristics$Key r9 = android.hardware.camera2.CameraCharacteristics.LENS_FACING     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            int r8 = r8.intValue()     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            if (r8 != 0) goto L_0x0061
        L_0x005e:
            r11.mCameraID = r7     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            goto L_0x0064
        L_0x0061:
            int r5 = r5 + 1
            goto L_0x002e
        L_0x0064:
            java.lang.String r3 = r11.mCameraID     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            if (r3 == 0) goto L_0x0087
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            r3.<init>()     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            java.lang.String r4 = "Opening camera: "
            r3.append(r4)     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            java.lang.String r4 = r11.mCameraID     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            r3.append(r4)     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            java.lang.String r3 = r3.toString()     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            android.util.Log.i(r0, r3)     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            java.lang.String r3 = r11.mCameraID     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            android.hardware.camera2.CameraDevice$StateCallback r4 = r11.mStateCallback     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            android.os.Handler r5 = r11.mBackgroundHandler     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
            r1.openCamera(r3, r4, r5)     // Catch:{ CameraAccessException -> 0x0096, IllegalArgumentException -> 0x008f, SecurityException -> 0x0088 }
        L_0x0087:
            return r6
        L_0x0088:
            r1 = move-exception
            java.lang.String r3 = "OpenCamera - Security Exception"
            android.util.Log.e(r0, r3, r1)
            goto L_0x009c
        L_0x008f:
            r1 = move-exception
            java.lang.String r3 = "OpenCamera - Illegal Argument Exception"
            android.util.Log.e(r0, r3, r1)
            goto L_0x009c
        L_0x0096:
            r1 = move-exception
            java.lang.String r3 = "OpenCamera - Camera Access Exception"
            android.util.Log.e(r0, r3, r1)
        L_0x009c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.opencv.android.JavaCamera2View.initializeCamera():boolean");
    }

    /* access modifiers changed from: private */
    public void createCameraPreviewSession() {
        final int width = this.mPreviewSize.getWidth();
        final int height = this.mPreviewSize.getHeight();
        Log.i(LOGTAG, "createCameraPreviewSession(" + width + "x" + height + ")");
        if (width >= 0 && height >= 0) {
            try {
                if (this.mCameraDevice == null) {
                    Log.e(LOGTAG, "createCameraPreviewSession: camera isn't opened");
                } else if (this.mCaptureSession != null) {
                    Log.e(LOGTAG, "createCameraPreviewSession: mCaptureSession is already started");
                } else {
                    ImageReader newInstance = ImageReader.newInstance(width, height, this.mPreviewFormat, 2);
                    this.mImageReader = newInstance;
                    newInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
                        /* class org.opencv.android.JavaCamera2View.AnonymousClass2 */
                        static final /* synthetic */ boolean $assertionsDisabled = false;

                        public void onImageAvailable(ImageReader imageReader) {
                            Image acquireLatestImage = imageReader.acquireLatestImage();
                            if (acquireLatestImage != null) {
                                Image.Plane[] planes = acquireLatestImage.getPlanes();
                                ByteBuffer buffer = planes[0].getBuffer();
                                ByteBuffer buffer2 = planes[1].getBuffer();
                                JavaCamera2Frame javaCamera2Frame = new JavaCamera2Frame(new Mat(height, width, CvType.CV_8UC1, buffer), new Mat(height / 2, width / 2, CvType.CV_8UC2, buffer2), width, height);
                                JavaCamera2View.this.deliverAndDrawFrame(javaCamera2Frame);
                                javaCamera2Frame.release();
                                acquireLatestImage.close();
                            }
                        }
                    }, this.mBackgroundHandler);
                    Surface surface = this.mImageReader.getSurface();
                    CaptureRequest.Builder createCaptureRequest = this.mCameraDevice.createCaptureRequest(1);
                    this.mPreviewRequestBuilder = createCaptureRequest;
                    createCaptureRequest.addTarget(surface);
                    this.mCameraDevice.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() {
                        /* class org.opencv.android.JavaCamera2View.AnonymousClass3 */

                        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                            Log.i(JavaCamera2View.LOGTAG, "createCaptureSession::onConfigured");
                            if (JavaCamera2View.this.mCameraDevice != null) {
                                CameraCaptureSession unused = JavaCamera2View.this.mCaptureSession = cameraCaptureSession;
                                try {
                                    JavaCamera2View.this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 4);
                                    JavaCamera2View.this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 2);
                                    JavaCamera2View.this.mCaptureSession.setRepeatingRequest(JavaCamera2View.this.mPreviewRequestBuilder.build(), null, JavaCamera2View.this.mBackgroundHandler);
                                    Log.i(JavaCamera2View.LOGTAG, "CameraPreviewSession has been started");
                                } catch (Exception e) {
                                    Log.e(JavaCamera2View.LOGTAG, "createCaptureSession failed", e);
                                }
                            }
                        }

                        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                            Log.e(JavaCamera2View.LOGTAG, "createCameraPreviewSession failed");
                        }
                    }, null);
                }
            } catch (CameraAccessException e) {
                Log.e(LOGTAG, "createCameraPreviewSession", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.opencv.android.CameraBridgeViewBase
    public void disconnectCamera() {
        Log.i(LOGTAG, "closeCamera");
        try {
            CameraDevice cameraDevice = this.mCameraDevice;
            this.mCameraDevice = null;
            if (this.mCaptureSession != null) {
                this.mCaptureSession.close();
                this.mCaptureSession = null;
            }
            if (cameraDevice != null) {
                cameraDevice.close();
            }
            if (this.mImageReader != null) {
                this.mImageReader.close();
                this.mImageReader = null;
            }
        } finally {
            stopBackgroundThread();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean calcPreviewSize(int i, int i2) {
        Log.i(LOGTAG, "calcPreviewSize: " + i + "x" + i2);
        if (this.mCameraID == null) {
            Log.e(LOGTAG, "Camera isn't initialized!");
            return false;
        }
        try {
            float f = ((float) i) / ((float) i2);
            Size[] outputSizes = ((StreamConfigurationMap) ((CameraManager) getContext().getSystemService("camera")).getCameraCharacteristics(this.mCameraID).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(ImageReader.class);
            int width = outputSizes[0].getWidth();
            int height = outputSizes[0].getHeight();
            for (Size size : outputSizes) {
                int width2 = size.getWidth();
                int height2 = size.getHeight();
                Log.d(LOGTAG, "trying size: " + width2 + "x" + height2);
                if (i >= width2 && i2 >= height2 && width <= width2 && height <= height2 && ((double) Math.abs(f - (((float) width2) / ((float) height2)))) < 0.2d) {
                    height = height2;
                    width = width2;
                }
            }
            Log.i(LOGTAG, "best size: " + width + "x" + height);
            if (this.mPreviewSize.getWidth() == width && this.mPreviewSize.getHeight() == height) {
                return false;
            }
            this.mPreviewSize = new Size(width, height);
            return true;
        } catch (CameraAccessException e) {
            Log.e(LOGTAG, "calcPreviewSize - Camera Access Exception", e);
            return false;
        } catch (IllegalArgumentException e2) {
            Log.e(LOGTAG, "calcPreviewSize - Illegal Argument Exception", e2);
            return false;
        } catch (SecurityException e3) {
            Log.e(LOGTAG, "calcPreviewSize - Security Exception", e3);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.opencv.android.CameraBridgeViewBase
    public boolean connectCamera(int i, int i2) {
        Log.i(LOGTAG, "setCameraPreviewSize(" + i + "x" + i2 + ")");
        startBackgroundThread();
        initializeCamera();
        try {
            boolean calcPreviewSize = calcPreviewSize(i, i2);
            this.mFrameWidth = this.mPreviewSize.getWidth();
            this.mFrameHeight = this.mPreviewSize.getHeight();
            if (getLayoutParams().width == -1 && getLayoutParams().height == -1) {
                this.mScale = Math.min(((float) i2) / ((float) this.mFrameHeight), ((float) i) / ((float) this.mFrameWidth));
            } else {
                this.mScale = 0.0f;
            }
            AllocateCache();
            if (!calcPreviewSize) {
                return true;
            }
            if (this.mCaptureSession != null) {
                Log.d(LOGTAG, "closing existing previewSession");
                this.mCaptureSession.close();
                this.mCaptureSession = null;
            }
            createCameraPreviewSession();
            return true;
        } catch (RuntimeException e) {
            throw new RuntimeException("Interrupted while setCameraPreviewSize.", e);
        }
    }

    private class JavaCamera2Frame implements CameraBridgeViewBase.CvCameraViewFrame {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int mHeight;
        private Mat mRgba;
        private Mat mUVFrameData;
        private int mWidth;
        private Mat mYuvFrameData;

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public Mat gray() {
            return this.mYuvFrameData.submat(0, this.mHeight, 0, this.mWidth);
        }

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public Mat rgba() {
            if (JavaCamera2View.this.mPreviewFormat == 17) {
                Imgproc.cvtColor(this.mYuvFrameData, this.mRgba, 96, 4);
            } else if (JavaCamera2View.this.mPreviewFormat == 842094169) {
                Imgproc.cvtColor(this.mYuvFrameData, this.mRgba, 100, 4);
            } else if (JavaCamera2View.this.mPreviewFormat == 35) {
                Imgproc.cvtColorTwoPlane(this.mYuvFrameData, this.mUVFrameData, this.mRgba, 96);
            } else {
                throw new IllegalArgumentException("Preview Format can be NV21 or YV12");
            }
            return this.mRgba;
        }

        public JavaCamera2Frame(Mat mat, int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
            this.mYuvFrameData = mat;
            this.mUVFrameData = null;
            this.mRgba = new Mat();
        }

        public JavaCamera2Frame(Mat mat, Mat mat2, int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
            this.mYuvFrameData = mat;
            this.mUVFrameData = mat2;
            this.mRgba = new Mat();
        }

        public void release() {
            this.mRgba.release();
        }
    }
}
