package com.labters.documentscanner;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.labters.documentscanner.ImageCropActivity;
import com.labters.documentscanner.base.CropperErrorType;
import com.labters.documentscanner.base.DocumentScanActivity;
import com.labters.documentscanner.helpers.ScannerConstants;
import com.labters.documentscanner.libraries.PolygonView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.Callable;

public class ImageCropActivity extends DocumentScanActivity {
    private View.OnClickListener btnCloseClick = new View.OnClickListener() {
        /* class com.labters.documentscanner.$$Lambda$ImageCropActivity$zY5XxJzQ5zqFcva6VaRHLizQN3s */

        public final void onClick(View view) {
            ImageCropActivity.this.lambda$new$0$ImageCropActivity(view);
        }
    };
    /* access modifiers changed from: private */
    public Bitmap cropImage;
    private FrameLayout holderImageCrop;
    private ImageView imageView;
    private View.OnClickListener onRotateLeftClick = new View.OnClickListener() {
        /* class com.labters.documentscanner.ImageCropActivity.AnonymousClass2 */

        public void onClick(View view) {
            ImageCropActivity.this.showProgressBar();
            ImageCropActivity.this.disposable.add(Observable.fromCallable(new Callable() {
                /* class com.labters.documentscanner.$$Lambda$ImageCropActivity$2$vAmHtq_v0rftZjRjOjl1l3owfdo */

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ImageCropActivity.AnonymousClass2.this.lambda$onClick$0$ImageCropActivity$2();
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                /* class com.labters.documentscanner.$$Lambda$ImageCropActivity$2$5osjVUxbyuyd2Z_GhSTKwAoMo */

                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ImageCropActivity.AnonymousClass2.this.lambda$onClick$1$ImageCropActivity$2((Boolean) obj);
                }
            }));
        }

        public /* synthetic */ Boolean lambda$onClick$0$ImageCropActivity$2() throws Exception {
            ImageCropActivity imageCropActivity = ImageCropActivity.this;
            Bitmap unused = imageCropActivity.cropImage = imageCropActivity.rotateBitmap(imageCropActivity.cropImage, -90.0f);
            return false;
        }

        public /* synthetic */ void lambda$onClick$1$ImageCropActivity$2(Boolean bool) throws Exception {
            ImageCropActivity.this.hideProgressBar();
            ImageCropActivity imageCropActivity = ImageCropActivity.this;
            imageCropActivity.startCropping(imageCropActivity.cropImage);
        }
    };
    private View.OnClickListener onRotateRightClick = new View.OnClickListener() {
        /* class com.labters.documentscanner.ImageCropActivity.AnonymousClass1 */

        public void onClick(View view) {
            ImageCropActivity.this.showProgressBar();
            ImageCropActivity.this.disposable.add(Observable.fromCallable(new Callable() {
                /* class com.labters.documentscanner.$$Lambda$ImageCropActivity$1$3FMe3RZFXW6F5SxFY_YgxJjNXA */

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ImageCropActivity.AnonymousClass1.this.lambda$onClick$0$ImageCropActivity$1();
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                /* class com.labters.documentscanner.$$Lambda$ImageCropActivity$1$YVldYcT6_9K1VkuKQGFf4UxIwc */

                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ImageCropActivity.AnonymousClass1.this.lambda$onClick$1$ImageCropActivity$1((Boolean) obj);
                }
            }));
        }

        public /* synthetic */ Boolean lambda$onClick$0$ImageCropActivity$1() throws Exception {
            ImageCropActivity imageCropActivity = ImageCropActivity.this;
            Bitmap unused = imageCropActivity.cropImage = imageCropActivity.rotateBitmap(imageCropActivity.cropImage, 90.0f);
            return false;
        }

        public /* synthetic */ void lambda$onClick$1$ImageCropActivity$1(Boolean bool) throws Exception {
            ImageCropActivity.this.hideProgressBar();
            ImageCropActivity imageCropActivity = ImageCropActivity.this;
            imageCropActivity.startCropping(imageCropActivity.cropImage);
        }
    };
    private PolygonView polygonView;
    private ProgressBar progressBar;

    public /* synthetic */ void lambda$new$0$ImageCropActivity(View view) {
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_image_crop);
        this.cropImage = ScannerConstants.selectedImageBitmap;
        if (getResources().getConfiguration().orientation == 2) {
            Matrix matrix = new Matrix();
            matrix.postRotate(90.0f);
            Bitmap bitmap = this.cropImage;
            this.cropImage = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.cropImage.getHeight(), matrix, true);
        }
        if (ScannerConstants.selectedImageBitmap != null) {
            initView();
            return;
        }
        Toast.makeText(this, ScannerConstants.imageError, 1).show();
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // com.labters.documentscanner.base.DocumentScanActivity
    public FrameLayout getHolderImageCrop() {
        return this.holderImageCrop;
    }

    /* access modifiers changed from: protected */
    @Override // com.labters.documentscanner.base.DocumentScanActivity
    public ImageView getImageView() {
        return this.imageView;
    }

    /* access modifiers changed from: protected */
    @Override // com.labters.documentscanner.base.DocumentScanActivity
    public PolygonView getPolygonView() {
        return this.polygonView;
    }

    /* access modifiers changed from: protected */
    @Override // com.labters.documentscanner.base.DocumentScanActivity
    public void showProgressBar() {
        setViewInteract((RelativeLayout) findViewById(R.id.rlContainer), false);
        this.progressBar.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    @Override // com.labters.documentscanner.base.DocumentScanActivity
    public void hideProgressBar() {
        setViewInteract((RelativeLayout) findViewById(R.id.rlContainer), true);
        this.progressBar.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    @Override // com.labters.documentscanner.base.DocumentScanActivity
    public void showError(CropperErrorType cropperErrorType) {
        if (cropperErrorType == CropperErrorType.CROP_ERROR) {
            Toast.makeText(this, ScannerConstants.cropError, 1).show();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.labters.documentscanner.base.DocumentScanActivity
    public Bitmap getBitmapImage() {
        return this.cropImage;
    }

    private void setViewInteract(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i < viewGroup.getChildCount()) {
                    setViewInteract(viewGroup.getChildAt(i), z);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private void initView() {
        ImageView imageView2 = (ImageView) findViewById(R.id.done);
        ImageView imageView3 = (ImageView) findViewById(R.id.btnClose);
        this.holderImageCrop = (FrameLayout) findViewById(R.id.holderImageCrop);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.rotate_left);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.rotate_right);
        this.polygonView = (PolygonView) findViewById(R.id.polygonView);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Bitmap bitmap = this.cropImage;
        this.imageView.setImageBitmap(scaledBitmap(bitmap, bitmap.getWidth(), this.cropImage.getHeight()));
        if (this.progressBar.getIndeterminateDrawable() != null && ScannerConstants.progressColor != null) {
            this.progressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor(ScannerConstants.progressColor), PorterDuff.Mode.MULTIPLY);
        } else if (!(this.progressBar.getProgressDrawable() == null || ScannerConstants.progressColor == null)) {
            this.progressBar.getProgressDrawable().setColorFilter(Color.parseColor(ScannerConstants.progressColor), PorterDuff.Mode.MULTIPLY);
        }
        imageView3.setOnClickListener(this.btnCloseClick);
        linearLayout2.setOnClickListener(this.onRotateRightClick);
        linearLayout.setOnClickListener(this.onRotateLeftClick);
        startCropping(this.cropImage);
        imageView2.setOnClickListener(new View.OnClickListener() {
            /* class com.labters.documentscanner.$$Lambda$ImageCropActivity$pEcGYYMYeto9_HzdzM6rfBVMXw */

            public final void onClick(View view) {
                ImageCropActivity.this.lambda$initView$1$ImageCropActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$initView$1$ImageCropActivity(View view) {
        ScannerConstants.position = Integer.parseInt((String) Objects.requireNonNull(getIntent().getStringExtra("position")));
        saveToInternalStorage(getCroppedImage(ScannerConstants.selectedImageBitmap));
        super.onBackPressed();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        r5.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0076, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007c, code lost:
        r0.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0082, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0087, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0088, code lost:
        r5.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x008b, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        r2 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void saveToInternalStorage(android.graphics.Bitmap r5) {
        /*
            r4 = this;
            java.io.File r0 = new java.io.File
            android.content.Intent r1 = r4.getIntent()
            java.lang.String r2 = "path"
            java.lang.String r1 = r1.getStringExtra(r2)
            android.content.Intent r2 = r4.getIntent()
            java.lang.String r3 = "imageName"
            java.lang.String r2 = r2.getStringExtra(r3)
            java.lang.Object r2 = java.util.Objects.requireNonNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            r0.<init>(r1, r2)
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x003b }
            r1.<init>(r0)     // Catch:{ IOException -> 0x003b }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x002f }
            r3 = 100
            r5.compress(r2, r3, r1)     // Catch:{ all -> 0x002f }
            r1.close()
            goto L_0x003f
        L_0x002f:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r2 = move-exception
            r1.close()     // Catch:{ all -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r1 = move-exception
            r5.addSuppressed(r1)
        L_0x003a:
            throw r2
        L_0x003b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x003f:
            r5 = 0
            id.zelory.compressor.Compressor r1 = new id.zelory.compressor.Compressor     // Catch:{ IOException -> 0x004a }
            r1.<init>(r4)     // Catch:{ IOException -> 0x004a }
            java.io.File r5 = r1.compressToFile(r0)     // Catch:{ IOException -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r1 = move-exception
            r1.printStackTrace()
        L_0x004e:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x008c }
            java.lang.Object r5 = java.util.Objects.requireNonNull(r5)     // Catch:{ IOException -> 0x008c }
            java.io.File r5 = (java.io.File) r5     // Catch:{ IOException -> 0x008c }
            r1.<init>(r5)     // Catch:{ IOException -> 0x008c }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x0080 }
            r5.<init>(r0)     // Catch:{ all -> 0x0080 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0074 }
        L_0x0062:
            int r2 = r1.read(r0)     // Catch:{ all -> 0x0074 }
            if (r2 <= 0) goto L_0x006d
            r3 = 0
            r5.write(r0, r3, r2)     // Catch:{ all -> 0x0074 }
            goto L_0x0062
        L_0x006d:
            r5.close()
            r1.close()
            goto L_0x0090
        L_0x0074:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r2 = move-exception
            r5.close()     // Catch:{ all -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r5 = move-exception
            r0.addSuppressed(r5)
        L_0x007f:
            throw r2
        L_0x0080:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r1 = move-exception
            r5.addSuppressed(r1)
        L_0x008b:
            throw r0
        L_0x008c:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.labters.documentscanner.ImageCropActivity.saveToInternalStorage(android.graphics.Bitmap):void");
    }
}
