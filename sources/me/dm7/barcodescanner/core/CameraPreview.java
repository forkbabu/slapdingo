package me.dm7.barcodescanner.core;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.List;
import org.spongycastle.crypto.tls.CipherSuite;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "CameraPreview";
    Camera.AutoFocusCallback autoFocusCB = new Camera.AutoFocusCallback() {
        /* class me.dm7.barcodescanner.core.CameraPreview.AnonymousClass2 */

        public void onAutoFocus(boolean z, Camera camera) {
            CameraPreview.this.scheduleAutoFocus();
        }
    };
    private Runnable doAutoFocus = new Runnable() {
        /* class me.dm7.barcodescanner.core.CameraPreview.AnonymousClass1 */

        public void run() {
            if (CameraPreview.this.mCameraWrapper != null && CameraPreview.this.mPreviewing && CameraPreview.this.mAutoFocus && CameraPreview.this.mSurfaceCreated) {
                CameraPreview.this.safeAutoFocus();
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean mAutoFocus = true;
    private Handler mAutoFocusHandler;
    /* access modifiers changed from: private */
    public CameraWrapper mCameraWrapper;
    private Camera.PreviewCallback mPreviewCallback;
    /* access modifiers changed from: private */
    public boolean mPreviewing = true;
    private boolean mShouldScaleToFill = true;
    /* access modifiers changed from: private */
    public boolean mSurfaceCreated = false;

    public CameraPreview(Context context, CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        super(context);
        init(cameraWrapper, previewCallback);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        super(context, attributeSet);
        init(cameraWrapper, previewCallback);
    }

    public void init(CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        setCamera(cameraWrapper, previewCallback);
        this.mAutoFocusHandler = new Handler();
        getHolder().addCallback(this);
        getHolder().setType(3);
    }

    public void setCamera(CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        this.mCameraWrapper = cameraWrapper;
        this.mPreviewCallback = previewCallback;
    }

    public void setShouldScaleToFill(boolean z) {
        this.mShouldScaleToFill = z;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceCreated = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() != null) {
            stopCameraPreview();
            showCameraPreview();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mSurfaceCreated = false;
        stopCameraPreview();
    }

    public void showCameraPreview() {
        if (this.mCameraWrapper != null) {
            try {
                getHolder().addCallback(this);
                this.mPreviewing = true;
                setupCameraParameters();
                this.mCameraWrapper.mCamera.setPreviewDisplay(getHolder());
                this.mCameraWrapper.mCamera.setDisplayOrientation(getDisplayOrientation());
                this.mCameraWrapper.mCamera.setOneShotPreviewCallback(this.mPreviewCallback);
                this.mCameraWrapper.mCamera.startPreview();
                if (!this.mAutoFocus) {
                    return;
                }
                if (this.mSurfaceCreated) {
                    safeAutoFocus();
                } else {
                    scheduleAutoFocus();
                }
            } catch (Exception e) {
                Log.e(TAG, e.toString(), e);
            }
        }
    }

    public void safeAutoFocus() {
        try {
            this.mCameraWrapper.mCamera.autoFocus(this.autoFocusCB);
        } catch (RuntimeException unused) {
            scheduleAutoFocus();
        }
    }

    public void stopCameraPreview() {
        if (this.mCameraWrapper != null) {
            try {
                this.mPreviewing = false;
                getHolder().removeCallback(this);
                this.mCameraWrapper.mCamera.cancelAutoFocus();
                this.mCameraWrapper.mCamera.setOneShotPreviewCallback(null);
                this.mCameraWrapper.mCamera.stopPreview();
            } catch (Exception e) {
                Log.e(TAG, e.toString(), e);
            }
        }
    }

    public void setupCameraParameters() {
        Camera.Size optimalPreviewSize = getOptimalPreviewSize();
        Camera.Parameters parameters = this.mCameraWrapper.mCamera.getParameters();
        parameters.setPreviewSize(optimalPreviewSize.width, optimalPreviewSize.height);
        this.mCameraWrapper.mCamera.setParameters(parameters);
        adjustViewSize(optimalPreviewSize);
    }

    private void adjustViewSize(Camera.Size size) {
        Point convertSizeToLandscapeOrientation = convertSizeToLandscapeOrientation(new Point(getWidth(), getHeight()));
        float f = ((float) size.width) / ((float) size.height);
        if (((float) convertSizeToLandscapeOrientation.x) / ((float) convertSizeToLandscapeOrientation.y) > f) {
            setViewSize((int) (((float) convertSizeToLandscapeOrientation.y) * f), convertSizeToLandscapeOrientation.y);
        } else {
            setViewSize(convertSizeToLandscapeOrientation.x, (int) (((float) convertSizeToLandscapeOrientation.x) / f));
        }
    }

    private Point convertSizeToLandscapeOrientation(Point point) {
        if (getDisplayOrientation() % CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 == 0) {
            return point;
        }
        return new Point(point.y, point.x);
    }

    private void setViewSize(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (getDisplayOrientation() % CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 != 0) {
            i2 = i;
            i = i2;
        }
        if (this.mShouldScaleToFill) {
            float f = (float) i;
            float width = ((float) ((View) getParent()).getWidth()) / f;
            float f2 = (float) i2;
            float height = ((float) ((View) getParent()).getHeight()) / f2;
            if (width <= height) {
                width = height;
            }
            i = Math.round(f * width);
            i2 = Math.round(f2 * width);
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    public int getDisplayOrientation() {
        int i = 0;
        if (this.mCameraWrapper == null) {
            return 0;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        if (this.mCameraWrapper.mCameraId == -1) {
            Camera.getCameraInfo(0, cameraInfo);
        } else {
            Camera.getCameraInfo(this.mCameraWrapper.mCameraId, cameraInfo);
        }
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256;
            } else if (rotation == 3) {
                i = TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    private Camera.Size getOptimalPreviewSize() {
        CameraWrapper cameraWrapper = this.mCameraWrapper;
        Camera.Size size = null;
        if (cameraWrapper == null) {
            return null;
        }
        List<Camera.Size> supportedPreviewSizes = cameraWrapper.mCamera.getParameters().getSupportedPreviewSizes();
        int width = getWidth();
        int height = getHeight();
        if (DisplayUtils.getScreenOrientation(getContext()) == 1) {
            height = width;
            width = height;
        }
        double d = ((double) width) / ((double) height);
        if (supportedPreviewSizes == null) {
            return null;
        }
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        for (Camera.Size size2 : supportedPreviewSizes) {
            if (Math.abs((((double) size2.width) / ((double) size2.height)) - d) <= 0.1d && ((double) Math.abs(size2.height - height)) < d3) {
                d3 = (double) Math.abs(size2.height - height);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : supportedPreviewSizes) {
                if (((double) Math.abs(size3.height - height)) < d2) {
                    size = size3;
                    d2 = (double) Math.abs(size3.height - height);
                }
            }
        }
        return size;
    }

    public void setAutoFocus(boolean z) {
        if (this.mCameraWrapper != null && this.mPreviewing && z != this.mAutoFocus) {
            this.mAutoFocus = z;
            if (!z) {
                Log.v(TAG, "Cancelling autofocus");
                this.mCameraWrapper.mCamera.cancelAutoFocus();
            } else if (this.mSurfaceCreated) {
                Log.v(TAG, "Starting autofocus");
                safeAutoFocus();
            } else {
                scheduleAutoFocus();
            }
        }
    }

    /* access modifiers changed from: private */
    public void scheduleAutoFocus() {
        this.mAutoFocusHandler.postDelayed(this.doAutoFocus, 1000);
    }
}
