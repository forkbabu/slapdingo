package me.dm7.barcodescanner.zxing;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import me.dm7.barcodescanner.core.BarcodeScannerView;
import me.dm7.barcodescanner.core.DisplayUtils;

public class ZXingScannerView extends BarcodeScannerView {
    public static final List<BarcodeFormat> ALL_FORMATS;
    private static final String TAG = "ZXingScannerView";
    private List<BarcodeFormat> mFormats;
    private MultiFormatReader mMultiFormatReader;
    /* access modifiers changed from: private */
    public ResultHandler mResultHandler;

    public interface ResultHandler {
        void handleResult(Result result);
    }

    static {
        ArrayList arrayList = new ArrayList();
        ALL_FORMATS = arrayList;
        arrayList.add(BarcodeFormat.UPC_A);
        ALL_FORMATS.add(BarcodeFormat.UPC_E);
        ALL_FORMATS.add(BarcodeFormat.EAN_13);
        ALL_FORMATS.add(BarcodeFormat.EAN_8);
        ALL_FORMATS.add(BarcodeFormat.RSS_14);
        ALL_FORMATS.add(BarcodeFormat.CODE_39);
        ALL_FORMATS.add(BarcodeFormat.CODE_93);
        ALL_FORMATS.add(BarcodeFormat.CODE_128);
        ALL_FORMATS.add(BarcodeFormat.ITF);
        ALL_FORMATS.add(BarcodeFormat.CODABAR);
        ALL_FORMATS.add(BarcodeFormat.QR_CODE);
        ALL_FORMATS.add(BarcodeFormat.DATA_MATRIX);
        ALL_FORMATS.add(BarcodeFormat.PDF_417);
    }

    public ZXingScannerView(Context context) {
        super(context);
        initMultiFormatReader();
    }

    public ZXingScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initMultiFormatReader();
    }

    public void setFormats(List<BarcodeFormat> list) {
        this.mFormats = list;
        initMultiFormatReader();
    }

    public void setResultHandler(ResultHandler resultHandler) {
        this.mResultHandler = resultHandler;
    }

    public Collection<BarcodeFormat> getFormats() {
        List<BarcodeFormat> list = this.mFormats;
        return list == null ? ALL_FORMATS : list;
    }

    private void initMultiFormatReader() {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.put((Object) DecodeHintType.POSSIBLE_FORMATS, (Object) getFormats());
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.mMultiFormatReader = multiFormatReader;
        multiFormatReader.setHints(enumMap);
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        MultiFormatReader multiFormatReader;
        if (this.mResultHandler != null) {
            try {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                int i = previewSize.width;
                int i2 = previewSize.height;
                if (DisplayUtils.getScreenOrientation(getContext()) == 1) {
                    byte[] bArr2 = new byte[bArr.length];
                    for (int i3 = 0; i3 < i2; i3++) {
                        for (int i4 = 0; i4 < i; i4++) {
                            bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
                        }
                    }
                    bArr = bArr2;
                    i = i2;
                    i2 = i;
                }
                final Result result = null;
                PlanarYUVLuminanceSource buildLuminanceSource = buildLuminanceSource(bArr, i, i2);
                if (buildLuminanceSource != null) {
                    try {
                        result = this.mMultiFormatReader.decodeWithState(new BinaryBitmap(new HybridBinarizer(buildLuminanceSource)));
                        multiFormatReader = this.mMultiFormatReader;
                    } catch (ReaderException unused) {
                        multiFormatReader = this.mMultiFormatReader;
                    } catch (NullPointerException unused2) {
                        multiFormatReader = this.mMultiFormatReader;
                    } catch (ArrayIndexOutOfBoundsException unused3) {
                        multiFormatReader = this.mMultiFormatReader;
                    } catch (Throwable th) {
                        this.mMultiFormatReader.reset();
                        throw th;
                    }
                    multiFormatReader.reset();
                }
                if (result != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class me.dm7.barcodescanner.zxing.ZXingScannerView.AnonymousClass1 */

                        public void run() {
                            ResultHandler access$000 = ZXingScannerView.this.mResultHandler;
                            ResultHandler unused = ZXingScannerView.this.mResultHandler = null;
                            ZXingScannerView.this.stopCameraPreview();
                            if (access$000 != null) {
                                access$000.handleResult(result);
                            }
                        }
                    });
                } else {
                    camera.setOneShotPreviewCallback(this);
                }
            } catch (RuntimeException e) {
                Log.e(TAG, e.toString(), e);
            }
        }
    }

    public void resumeCameraPreview(ResultHandler resultHandler) {
        this.mResultHandler = resultHandler;
        super.resumeCameraPreview();
    }

    public PlanarYUVLuminanceSource buildLuminanceSource(byte[] bArr, int i, int i2) {
        Rect framingRectInPreview = getFramingRectInPreview(i, i2);
        if (framingRectInPreview == null) {
            return null;
        }
        try {
            return new PlanarYUVLuminanceSource(bArr, i, i2, framingRectInPreview.left, framingRectInPreview.top, framingRectInPreview.width(), framingRectInPreview.height(), false);
        } catch (Exception unused) {
            return null;
        }
    }
}
