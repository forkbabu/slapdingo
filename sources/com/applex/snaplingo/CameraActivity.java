package com.applex.snaplingo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.theartofdev.edmodo.cropper.CropImage;
import io.fotoapparat.Fotoapparat;
import io.fotoapparat.configuration.CameraConfiguration;
import io.fotoapparat.configuration.UpdateConfiguration;
import io.fotoapparat.error.CameraErrorListener;
import io.fotoapparat.exception.camera.CameraException;
import io.fotoapparat.log.LoggersKt;
import io.fotoapparat.parameter.ScaleType;
import io.fotoapparat.preview.FrameProcessor;
import io.fotoapparat.result.BitmapPhoto;
import io.fotoapparat.result.WhenDoneListener;
import io.fotoapparat.result.transformer.ResolutionTransformersKt;
import io.fotoapparat.selector.AntiBandingModeSelectorsKt;
import io.fotoapparat.selector.FlashSelectorsKt;
import io.fotoapparat.selector.FocusModeSelectorsKt;
import io.fotoapparat.selector.JpegQualitySelectorsKt;
import io.fotoapparat.selector.LensPositionSelectorsKt;
import io.fotoapparat.selector.PreviewFpsRangeSelectorsKt;
import io.fotoapparat.selector.ResolutionSelectorsKt;
import io.fotoapparat.selector.SelectorsKt;
import io.fotoapparat.selector.SensorSensitivitySelectorsKt;
import io.fotoapparat.view.CameraView;
import io.fotoapparat.view.FocusView;

public class CameraActivity extends AppCompatActivity {
    private static final String LOGGING_TAG = "Fotoapparat Example";
    boolean activeCameraBack = true;
    /* access modifiers changed from: private */
    public CameraConfiguration cameraConfiguration = CameraConfiguration.builder().photoResolution(SelectorsKt.firstAvailable(ResolutionSelectorsKt.highestResolution())).focusMode(SelectorsKt.firstAvailable(FocusModeSelectorsKt.continuousFocusPicture(), FocusModeSelectorsKt.autoFocus(), FocusModeSelectorsKt.fixed())).flash(SelectorsKt.firstAvailable(FlashSelectorsKt.autoRedEye(), FlashSelectorsKt.off(), FlashSelectorsKt.on())).jpegQuality(JpegQualitySelectorsKt.highestQuality()).antiBandingMode(AntiBandingModeSelectorsKt.auto()).previewResolution(SelectorsKt.firstAvailable(ResolutionSelectorsKt.highestResolution())).previewFpsRange(PreviewFpsRangeSelectorsKt.highestFps()).sensorSensitivity(SensorSensitivitySelectorsKt.lowestSensorSensitivity()).frameProcessor(new SampleFrameProcessor()).build();
    private CameraView cameraView;
    private View capture;
    /* access modifiers changed from: private */
    public String docName;
    long[] flashState;
    private FocusView focusView;
    /* access modifiers changed from: private */
    public Fotoapparat fotoapparat;
    /* access modifiers changed from: private */
    public String imageName;
    /* access modifiers changed from: private */
    public boolean isFirst;
    ImageView preview;
    View switchCameraButton;
    ImageView torchSwitch;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.camera_layout);
        this.cameraView = (CameraView) findViewById(R.id.cameraView);
        this.focusView = (FocusView) findViewById(R.id.focusView);
        this.capture = findViewById(R.id.capture);
        this.torchSwitch = (ImageView) findViewById(R.id.torchSwitch);
        this.switchCameraButton = findViewById(R.id.switchCamera);
        this.preview = (ImageView) findViewById(R.id.result);
        this.cameraView.setVisibility(0);
        if (getIntent().getStringExtra("boolcam") != null && getIntent().getStringExtra("boolcam").matches("1")) {
            this.docName = String.valueOf(System.currentTimeMillis());
            this.imageName = "0.jpg";
            this.isFirst = true;
        } else if (getIntent().getStringExtra("boolcam") == null || !getIntent().getStringExtra("boolcam").matches(ExifInterface.GPS_MEASUREMENT_2D)) {
            this.isFirst = false;
            this.docName = getIntent().getStringExtra("prevDocName");
        } else {
            this.docName = getIntent().getStringExtra("prevDocName");
            if (getIntent().getStringExtra("imageCount") != null) {
                this.imageName = getIntent().getStringExtra("imageCount") + ".jpg";
            } else {
                this.imageName = "0.jpg";
            }
            this.isFirst = false;
        }
        Fotoapparat createFotoapparat = createFotoapparat();
        this.fotoapparat = createFotoapparat;
        createFotoapparat.updateConfiguration(this.cameraConfiguration);
        takePictureOnClick();
        switchCameraOnClick();
        toggleTorchOnSwitch();
        zoomSeekBar();
    }

    private Fotoapparat createFotoapparat() {
        return Fotoapparat.with(this).into(this.cameraView).focusView(this.focusView).previewScaleType(ScaleType.CenterInside).lensPosition(LensPositionSelectorsKt.back()).frameProcessor(new SampleFrameProcessor()).logger(LoggersKt.loggers(LoggersKt.logcat(), LoggersKt.fileLogger(this))).cameraErrorCallback(new CameraErrorListener() {
            /* class com.applex.snaplingo.CameraActivity.AnonymousClass1 */

            @Override // io.fotoapparat.error.CameraErrorListener
            public void onError(CameraException cameraException) {
                Toast.makeText(CameraActivity.this, cameraException.toString(), 1).show();
            }
        }).flash(SelectorsKt.firstAvailable(FlashSelectorsKt.autoRedEye(), FlashSelectorsKt.off(), FlashSelectorsKt.on())).photoResolution(SelectorsKt.firstAvailable(ResolutionSelectorsKt.highestResolution())).jpegQuality(JpegQualitySelectorsKt.highestQuality()).previewResolution(SelectorsKt.firstAvailable(ResolutionSelectorsKt.highestResolution())).previewFpsRange(PreviewFpsRangeSelectorsKt.highestFps()).sensorSensitivity(SensorSensitivitySelectorsKt.lowestSensorSensitivity()).build();
    }

    private void zoomSeekBar() {
        ((SeekBar) findViewById(R.id.zoomSeekBar)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /* class com.applex.snaplingo.CameraActivity.AnonymousClass2 */

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                CameraActivity.this.fotoapparat.setZoom(((float) i) / ((float) seekBar.getMax()));
            }
        });
    }

    private void switchCameraOnClick() {
        boolean isAvailable = this.fotoapparat.isAvailable(LensPositionSelectorsKt.front());
        this.switchCameraButton.setVisibility(isAvailable ? 0 : 8);
        if (isAvailable) {
            switchCameraOnClick(this.switchCameraButton);
        }
    }

    private void toggleTorchOnSwitch() {
        this.torchSwitch.setImageResource(R.drawable.ic_flash_off_black_24dp);
        this.flashState = new long[]{0};
        this.fotoapparat.updateConfiguration(UpdateConfiguration.builder().flash(FlashSelectorsKt.on()).build());
        this.torchSwitch.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.CameraActivity.AnonymousClass3 */

            public void onClick(View view) {
                if (CameraActivity.this.flashState[0] == 2) {
                    CameraActivity.this.torchSwitch.setImageResource(R.drawable.ic_flash_off_black_24dp);
                    CameraActivity.this.flashState[0] = 0;
                    CameraActivity.this.fotoapparat.updateConfiguration(UpdateConfiguration.builder().flash(FlashSelectorsKt.off()).build());
                    return;
                }
                CameraActivity.this.torchSwitch.setImageResource(R.drawable.ic_flash_on_black_24dp);
                CameraActivity.this.flashState[0] = 2;
                CameraActivity.this.fotoapparat.updateConfiguration(UpdateConfiguration.builder().flash(FlashSelectorsKt.on()).build());
            }
        });
    }

    private void switchCameraOnClick(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.CameraActivity.AnonymousClass4 */

            public void onClick(View view) {
                CameraActivity cameraActivity = CameraActivity.this;
                cameraActivity.activeCameraBack = !cameraActivity.activeCameraBack;
                CameraActivity.this.fotoapparat.switchTo(CameraActivity.this.activeCameraBack ? LensPositionSelectorsKt.back() : LensPositionSelectorsKt.front(), CameraActivity.this.cameraConfiguration);
            }
        });
    }

    private void takePictureOnClick() {
        this.capture.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.CameraActivity.AnonymousClass5 */

            public void onClick(View view) {
                CameraActivity.this.takePicture();
                Toast makeText = Toast.makeText(CameraActivity.this, "Hold steady", 0);
                makeText.setGravity(48, 0, 240);
                makeText.show();
            }
        });
    }

    /* access modifiers changed from: private */
    public void takePicture() {
        this.fotoapparat.takePicture().toBitmap(ResolutionTransformersKt.scaled(0.3f)).whenDone(new WhenDoneListener<BitmapPhoto>() {
            /* class com.applex.snaplingo.CameraActivity.AnonymousClass6 */

            /* JADX WARNING: Code restructure failed: missing block: B:20:0x00af, code lost:
                r3 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
                r0.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b4, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b5, code lost:
                r1.addSuppressed(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b8, code lost:
                throw r3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f5, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
                r1.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fa, code lost:
                r1 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fb, code lost:
                r14.addSuppressed(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fe, code lost:
                throw r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:55:0x0101, code lost:
                r1 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
                r0.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:0x0106, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:59:0x0107, code lost:
                r14.addSuppressed(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:60:0x010a, code lost:
                throw r1;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void whenDone(io.fotoapparat.result.BitmapPhoto r14) {
                /*
                    r13 = this;
                    if (r14 != 0) goto L_0x000a
                    java.lang.String r14 = "Fotoapparat Example"
                    java.lang.String r0 = "Couldn't capture photo."
                    android.util.Log.e(r14, r0)
                    return
                L_0x000a:
                    com.applex.snaplingo.CameraActivity r0 = com.applex.snaplingo.CameraActivity.this
                    android.content.Intent r0 = r0.getIntent()
                    java.lang.String r1 = "boolcam"
                    java.lang.String r0 = r0.getStringExtra(r1)
                    r1 = 1119092736(0x42b40000, float:90.0)
                    r2 = 0
                    r3 = 100
                    r4 = 1
                    if (r0 == 0) goto L_0x0155
                    java.io.File r0 = new java.io.File
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.io.File r6 = android.os.Environment.getExternalStorageDirectory()
                    r5.append(r6)
                    java.lang.String r6 = "/SnapLingo/.documents"
                    r5.append(r6)
                    java.lang.String r5 = r5.toString()
                    com.applex.snaplingo.CameraActivity r6 = com.applex.snaplingo.CameraActivity.this
                    java.lang.String r6 = r6.docName
                    r0.<init>(r5, r6)
                    r0.mkdirs()
                    boolean r5 = r0.exists()
                    if (r5 == 0) goto L_0x004a
                    r0.mkdir()
                L_0x004a:
                    android.graphics.Bitmap r6 = r14.bitmap
                    com.applex.snaplingo.CameraActivity r14 = com.applex.snaplingo.CameraActivity.this
                    android.content.res.Resources r14 = r14.getResources()
                    android.content.res.Configuration r14 = r14.getConfiguration()
                    int r14 = r14.orientation
                    if (r14 != r4) goto L_0x0071
                    android.graphics.Matrix r11 = new android.graphics.Matrix
                    r11.<init>()
                    r11.postRotate(r1)
                    r7 = 0
                    r8 = 0
                    int r9 = r6.getWidth()
                    int r10 = r6.getHeight()
                    r12 = 1
                    android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r6, r7, r8, r9, r10, r11, r12)
                L_0x0071:
                    java.io.File r14 = new java.io.File
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
                    r0.append(r1)
                    java.lang.String r1 = "/SnapLingo/.documents/"
                    r0.append(r1)
                    com.applex.snaplingo.CameraActivity r1 = com.applex.snaplingo.CameraActivity.this
                    java.lang.String r1 = r1.docName
                    r0.append(r1)
                    java.lang.String r1 = "/"
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    com.applex.snaplingo.CameraActivity r1 = com.applex.snaplingo.CameraActivity.this
                    java.lang.String r1 = r1.imageName
                    r14.<init>(r0, r1)
                    java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00b9 }
                    r0.<init>(r14)     // Catch:{ IOException -> 0x00b9 }
                    android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x00ad }
                    r6.compress(r1, r3, r0)     // Catch:{ all -> 0x00ad }
                    r0.close()
                    goto L_0x00bd
                L_0x00ad:
                    r1 = move-exception
                    throw r1     // Catch:{ all -> 0x00af }
                L_0x00af:
                    r3 = move-exception
                    r0.close()     // Catch:{ all -> 0x00b4 }
                    goto L_0x00b8
                L_0x00b4:
                    r0 = move-exception
                    r1.addSuppressed(r0)
                L_0x00b8:
                    throw r3
                L_0x00b9:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x00bd:
                    id.zelory.compressor.Compressor r0 = new id.zelory.compressor.Compressor     // Catch:{ IOException -> 0x00c9 }
                    com.applex.snaplingo.CameraActivity r1 = com.applex.snaplingo.CameraActivity.this     // Catch:{ IOException -> 0x00c9 }
                    r0.<init>(r1)     // Catch:{ IOException -> 0x00c9 }
                    java.io.File r2 = r0.compressToFile(r14)     // Catch:{ IOException -> 0x00c9 }
                    goto L_0x00cd
                L_0x00c9:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x00cd:
                    java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x010b }
                    java.lang.Object r1 = java.util.Objects.requireNonNull(r2)     // Catch:{ IOException -> 0x010b }
                    java.io.File r1 = (java.io.File) r1     // Catch:{ IOException -> 0x010b }
                    r0.<init>(r1)     // Catch:{ IOException -> 0x010b }
                    java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ff }
                    r1.<init>(r14)     // Catch:{ all -> 0x00ff }
                    r14 = 1024(0x400, float:1.435E-42)
                    byte[] r14 = new byte[r14]     // Catch:{ all -> 0x00f3 }
                L_0x00e1:
                    int r2 = r0.read(r14)     // Catch:{ all -> 0x00f3 }
                    if (r2 <= 0) goto L_0x00ec
                    r3 = 0
                    r1.write(r14, r3, r2)     // Catch:{ all -> 0x00f3 }
                    goto L_0x00e1
                L_0x00ec:
                    r1.close()
                    r0.close()
                    goto L_0x010f
                L_0x00f3:
                    r14 = move-exception
                    throw r14     // Catch:{ all -> 0x00f5 }
                L_0x00f5:
                    r2 = move-exception
                    r1.close()     // Catch:{ all -> 0x00fa }
                    goto L_0x00fe
                L_0x00fa:
                    r1 = move-exception
                    r14.addSuppressed(r1)
                L_0x00fe:
                    throw r2
                L_0x00ff:
                    r14 = move-exception
                    throw r14     // Catch:{ all -> 0x0101 }
                L_0x0101:
                    r1 = move-exception
                    r0.close()     // Catch:{ all -> 0x0106 }
                    goto L_0x010a
                L_0x0106:
                    r0 = move-exception
                    r14.addSuppressed(r0)
                L_0x010a:
                    throw r1
                L_0x010b:
                    r14 = move-exception
                    r14.printStackTrace()
                L_0x010f:
                    android.content.Intent r14 = new android.content.Intent
                    com.applex.snaplingo.CameraActivity r0 = com.applex.snaplingo.CameraActivity.this
                    java.lang.Class<com.applex.snaplingo.ViewPager> r1 = com.applex.snaplingo.ViewPager.class
                    r14.<init>(r0, r1)
                    com.applex.snaplingo.CameraActivity r0 = com.applex.snaplingo.CameraActivity.this
                    boolean r0 = r0.isFirst
                    java.lang.String r1 = "from"
                    if (r0 == 0) goto L_0x0128
                    java.lang.String r0 = "1"
                    r14.putExtra(r1, r0)
                    goto L_0x013e
                L_0x0128:
                    java.lang.String r0 = "3"
                    r14.putExtra(r1, r0)
                    com.applex.snaplingo.CameraActivity r0 = com.applex.snaplingo.CameraActivity.this
                    android.content.Intent r0 = r0.getIntent()
                    java.lang.String r1 = "imageCount"
                    java.lang.String r0 = r0.getStringExtra(r1)
                    java.lang.String r1 = "pos"
                    r14.putExtra(r1, r0)
                L_0x013e:
                    com.applex.snaplingo.CameraActivity r0 = com.applex.snaplingo.CameraActivity.this
                    java.lang.String r0 = r0.docName
                    java.lang.String r1 = "docName"
                    r14.putExtra(r1, r0)
                    com.applex.snaplingo.CameraActivity r0 = com.applex.snaplingo.CameraActivity.this
                    r0.startActivity(r14)
                    com.applex.snaplingo.CameraActivity r14 = com.applex.snaplingo.CameraActivity.this
                    r14.finish()
                    goto L_0x01e8
                L_0x0155:
                    android.graphics.Bitmap r14 = r14.bitmap
                    com.applex.snaplingo.CameraActivity r0 = com.applex.snaplingo.CameraActivity.this
                    android.content.res.Resources r0 = r0.getResources()
                    android.content.res.Configuration r0 = r0.getConfiguration()
                    int r0 = r0.orientation
                    if (r0 != r4) goto L_0x017d
                    android.graphics.Matrix r9 = new android.graphics.Matrix
                    r9.<init>()
                    r9.postRotate(r1)
                    r5 = 0
                    r6 = 0
                    int r7 = r14.getWidth()
                    int r8 = r14.getHeight()
                    r10 = 1
                    r4 = r14
                    android.graphics.Bitmap r14 = android.graphics.Bitmap.createBitmap(r4, r5, r6, r7, r8, r9, r10)
                L_0x017d:
                    java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
                    r0.<init>()
                    android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
                    r14.compress(r1, r3, r0)
                    com.applex.snaplingo.CameraActivity r0 = com.applex.snaplingo.CameraActivity.this
                    android.content.Context r0 = r0.getApplicationContext()
                    android.content.ContentResolver r0 = r0.getContentResolver()
                    long r3 = java.lang.System.currentTimeMillis()
                    java.lang.String r1 = java.lang.String.valueOf(r3)
                    java.lang.String r14 = android.provider.MediaStore.Images.Media.insertImage(r0, r14, r1, r2)
                    android.net.Uri r14 = android.net.Uri.parse(r14)
                    com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r14 = com.theartofdev.edmodo.cropper.CropImage.activity(r14)
                    java.lang.String r0 = "SnapCrop"
                    com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r14 = r14.setActivityTitle(r0)
                    java.lang.Boolean r0 = java.lang.Boolean.TRUE
                    boolean r0 = r0.booleanValue()
                    com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r14 = r14.setAllowRotation(r0)
                    java.lang.Boolean r0 = java.lang.Boolean.TRUE
                    boolean r0 = r0.booleanValue()
                    com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r14 = r14.setAllowCounterRotation(r0)
                    java.lang.Boolean r0 = java.lang.Boolean.TRUE
                    boolean r0 = r0.booleanValue()
                    com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r14 = r14.setAllowFlipping(r0)
                    java.lang.Boolean r0 = java.lang.Boolean.TRUE
                    boolean r0 = r0.booleanValue()
                    com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r14 = r14.setAutoZoomEnabled(r0)
                    java.lang.Boolean r0 = java.lang.Boolean.FALSE
                    boolean r0 = r0.booleanValue()
                    com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r14 = r14.setMultiTouchEnabled(r0)
                    com.theartofdev.edmodo.cropper.CropImageView$Guidelines r0 = com.theartofdev.edmodo.cropper.CropImageView.Guidelines.ON
                    com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r14 = r14.setGuidelines(r0)
                    com.applex.snaplingo.CameraActivity r0 = com.applex.snaplingo.CameraActivity.this
                    r14.start(r0)
                L_0x01e8:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.applex.snaplingo.CameraActivity.AnonymousClass6.whenDone(io.fotoapparat.result.BitmapPhoto):void");
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 203) {
            CropImage.ActivityResult activityResult = CropImage.getActivityResult(intent);
            if (i2 == -1) {
                try {
                    MainActivity.resultUri = activityResult.getUri();
                } catch (Exception e) {
                    Toast.makeText(this, (CharSequence) e, 0).show();
                }
                ImageView imageView = (ImageView) findViewById(R.id.result);
                imageView.setImageURI(MainActivity.resultUri);
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                TextRecognizer build = new TextRecognizer.Builder(getApplicationContext()).build();
                if (!build.isOperational()) {
                    Toast.makeText(this, "Error", 0).show();
                    return;
                }
                SparseArray<TextBlock> detect = build.detect(new Frame.Builder().setBitmap(bitmap).build());
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < detect.size(); i3++) {
                    sb.append(detect.valueAt(i3).getValue());
                    if (i3 != detect.size() - 1) {
                        sb.append("\n");
                    }
                }
                Intent intent2 = new Intent(this, MainActivity.class);
                intent2.putExtra("Text", sb.toString().trim());
                intent2.putExtra("selection", "1");
                startActivity(intent2);
                finish();
            }
        } else if (i2 == 204) {
            Toast.makeText(this, "+error", 0).show();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        this.fotoapparat.start();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        this.fotoapparat.stop();
    }

    private class SampleFrameProcessor implements FrameProcessor {
        @Override // io.fotoapparat.preview.FrameProcessor
        public void process(io.fotoapparat.preview.Frame frame) {
        }

        private SampleFrameProcessor() {
        }
    }
}
