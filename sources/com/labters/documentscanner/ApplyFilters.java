package com.labters.documentscanner;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
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

public class ApplyFilters extends DocumentScanActivity {
    private ImageView btnClose;
    private ImageView btnDone;
    private Bitmap cropImage;
    LinearLayout filter1;
    ImageView filter1img;
    LinearLayout filter2;
    ImageView filter2img;
    LinearLayout filter3;
    ImageView filter3img;
    LinearLayout filter4;
    ImageView filter4img;
    private FrameLayout holderImageCrop;
    private ImageView imageView;
    private boolean isContrast1;
    private boolean isContrast2;
    private boolean isInverted;
    private ProgressBar progressBar;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;

    /* access modifiers changed from: protected */
    @Override // com.labters.documentscanner.base.DocumentScanActivity
    public PolygonView getPolygonView() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_apply_filters);
        this.cropImage = ScannerConstants.selectedImageBitmap;
        this.isInverted = false;
        this.isContrast1 = false;
        this.isContrast2 = false;
        if (ScannerConstants.selectedImageBitmap != null) {
            initView();
        } else {
            Toast.makeText(this, ScannerConstants.imageError, 1).show();
            finish();
        }
        this.btnClose.setOnClickListener(new View.OnClickListener() {
            /* class com.labters.documentscanner.$$Lambda$ApplyFilters$BdBuFcL6iLE1T1NzkXGnIcbNmaY */

            public final void onClick(View view) {
                ApplyFilters.this.lambda$onCreate$0$ApplyFilters(view);
            }
        });
        this.btnDone.setOnClickListener(new View.OnClickListener() {
            /* class com.labters.documentscanner.$$Lambda$ApplyFilters$4cw2oElxG1Ss3DrLjBrhTTNM5YM */

            public final void onClick(View view) {
                ApplyFilters.this.lambda$onCreate$1$ApplyFilters(view);
            }
        });
        this.filter1.setOnClickListener(new View.OnClickListener() {
            /* class com.labters.documentscanner.$$Lambda$ApplyFilters$HFbjCoGf7ThhBkByzC6Ojwli7V8 */

            public final void onClick(View view) {
                ApplyFilters.this.lambda$onCreate$2$ApplyFilters(view);
            }
        });
        this.filter2.setOnClickListener(new View.OnClickListener() {
            /* class com.labters.documentscanner.$$Lambda$ApplyFilters$f5fYCpzCQzb6l4vRcv6ehQfV_fU */

            public final void onClick(View view) {
                ApplyFilters.this.lambda$onCreate$5$ApplyFilters(view);
            }
        });
        this.filter3.setOnClickListener(new View.OnClickListener() {
            /* class com.labters.documentscanner.$$Lambda$ApplyFilters$Qrm9ESonlgFReMUQUohFZ5rJJQ */

            public final void onClick(View view) {
                ApplyFilters.this.lambda$onCreate$8$ApplyFilters(view);
            }
        });
        this.filter4.setOnClickListener(new View.OnClickListener() {
            /* class com.labters.documentscanner.$$Lambda$ApplyFilters$VFdDv_89s6M140vRMj49llSJ5Y */

            public final void onClick(View view) {
                ApplyFilters.this.lambda$onCreate$11$ApplyFilters(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$ApplyFilters(View view) {
        super.onBackPressed();
        ScannerConstants.position = Integer.parseInt((String) Objects.requireNonNull(getIntent().getStringExtra("position")));
    }

    public /* synthetic */ void lambda$onCreate$1$ApplyFilters(View view) {
        ScannerConstants.position = Integer.parseInt((String) Objects.requireNonNull(getIntent().getStringExtra("position")));
        saveToInternalStorage(this.cropImage);
        super.onBackPressed();
    }

    public /* synthetic */ void lambda$onCreate$2$ApplyFilters(View view) {
        this.filter1img.setImageResource(R.drawable.ic_filter_normal_selected);
        this.filter2img.setImageResource(R.drawable.ic_filter_b_and_w_24px);
        this.filter3img.setImageResource(R.drawable.ic_photo_filter_highcont);
        this.filter4img.setImageResource(R.drawable.ic_baseline_gradient_24);
        this.text1.setTypeface(Typeface.DEFAULT_BOLD);
        this.text2.setTypeface(Typeface.DEFAULT);
        this.text3.setTypeface(Typeface.DEFAULT);
        this.text4.setTypeface(Typeface.DEFAULT);
        this.text1.setTextColor(getResources().getColor(R.color.colorAccent));
        this.text2.setTextColor(getResources().getColor(R.color.colorGrey));
        this.text3.setTextColor(getResources().getColor(R.color.colorGrey));
        this.text4.setTextColor(getResources().getColor(R.color.colorGrey));
        this.imageView.setImageBitmap(scaledBitmap(ScannerConstants.selectedImageBitmap, this.holderImageCrop.getWidth(), this.holderImageCrop.getHeight()));
    }

    public /* synthetic */ void lambda$onCreate$5$ApplyFilters(View view) {
        this.filter1img.setImageResource(R.drawable.ic_filter_normal);
        this.filter2img.setImageResource(R.drawable.ic_filter_b_and_w_selected);
        this.filter3img.setImageResource(R.drawable.ic_photo_filter_highcont);
        this.filter4img.setImageResource(R.drawable.ic_baseline_gradient_24);
        this.text1.setTypeface(Typeface.DEFAULT);
        this.text2.setTypeface(Typeface.DEFAULT_BOLD);
        this.text3.setTypeface(Typeface.DEFAULT);
        this.text4.setTypeface(Typeface.DEFAULT);
        this.text1.setTextColor(getResources().getColor(R.color.colorGrey));
        this.text2.setTextColor(getResources().getColor(R.color.colorAccent));
        this.text3.setTextColor(getResources().getColor(R.color.colorGrey));
        this.text4.setTextColor(getResources().getColor(R.color.colorGrey));
        showProgressBar();
        this.disposable.add(Observable.fromCallable(new Callable() {
            /* class com.labters.documentscanner.$$Lambda$ApplyFilters$LtTWww6hXzbfP24pfcwRadii5iQ */

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ApplyFilters.this.lambda$null$3$ApplyFilters();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class com.labters.documentscanner.$$Lambda$ApplyFilters$6kiHUk8ZSKH6Mca9lOAv31C_LgE */

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ApplyFilters.this.lambda$null$4$ApplyFilters((Boolean) obj);
            }
        }));
    }

    public /* synthetic */ Boolean lambda$null$3$ApplyFilters() throws Exception {
        this.isContrast1 = false;
        this.isContrast2 = false;
        invertColor();
        return false;
    }

    public /* synthetic */ void lambda$null$4$ApplyFilters(Boolean bool) throws Exception {
        hideProgressBar();
        this.imageView.setImageBitmap(scaledBitmap(this.cropImage, this.holderImageCrop.getWidth(), this.holderImageCrop.getHeight()));
    }

    public /* synthetic */ void lambda$onCreate$8$ApplyFilters(View view) {
        this.filter1img.setImageResource(R.drawable.ic_filter_normal);
        this.filter2img.setImageResource(R.drawable.ic_filter_b_and_w_24px);
        this.filter3img.setImageResource(R.drawable.ic_photo_filter_highcont_selected);
        this.filter4img.setImageResource(R.drawable.ic_baseline_gradient_24);
        this.text1.setTypeface(Typeface.DEFAULT);
        this.text2.setTypeface(Typeface.DEFAULT);
        this.text3.setTypeface(Typeface.DEFAULT_BOLD);
        this.text4.setTypeface(Typeface.DEFAULT);
        this.text1.setTextColor(getResources().getColor(R.color.colorGrey));
        this.text2.setTextColor(getResources().getColor(R.color.colorGrey));
        this.text3.setTextColor(getResources().getColor(R.color.colorAccent));
        this.text4.setTextColor(getResources().getColor(R.color.colorGrey));
        showProgressBar();
        this.disposable.add(Observable.fromCallable(new Callable() {
            /* class com.labters.documentscanner.$$Lambda$ApplyFilters$CBOT3H_TzqJHVIuXScOx8Ke9yc */

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ApplyFilters.this.lambda$null$6$ApplyFilters();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class com.labters.documentscanner.$$Lambda$ApplyFilters$csEYMzFo7Mgk6o0XAZyU0nlHwBs */

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ApplyFilters.this.lambda$null$7$ApplyFilters((Boolean) obj);
            }
        }));
    }

    public /* synthetic */ Boolean lambda$null$6$ApplyFilters() throws Exception {
        this.isInverted = false;
        this.isContrast2 = false;
        applyContrast1();
        return false;
    }

    public /* synthetic */ void lambda$null$7$ApplyFilters(Boolean bool) throws Exception {
        hideProgressBar();
        this.imageView.setImageBitmap(scaledBitmap(this.cropImage, this.holderImageCrop.getWidth(), this.holderImageCrop.getHeight()));
    }

    public /* synthetic */ void lambda$onCreate$11$ApplyFilters(View view) {
        this.filter1img.setImageResource(R.drawable.ic_filter_normal);
        this.filter2img.setImageResource(R.drawable.ic_filter_b_and_w_24px);
        this.filter3img.setImageResource(R.drawable.ic_photo_filter_highcont);
        this.filter4img.setImageResource(R.drawable.ic_baseline_gradient_selected24);
        this.text1.setTypeface(Typeface.DEFAULT);
        this.text2.setTypeface(Typeface.DEFAULT);
        this.text3.setTypeface(Typeface.DEFAULT);
        this.text4.setTypeface(Typeface.DEFAULT_BOLD);
        this.text1.setTextColor(getResources().getColor(R.color.colorGrey));
        this.text2.setTextColor(getResources().getColor(R.color.colorGrey));
        this.text3.setTextColor(getResources().getColor(R.color.colorGrey));
        this.text4.setTextColor(getResources().getColor(R.color.colorAccent));
        showProgressBar();
        this.disposable.add(Observable.fromCallable(new Callable() {
            /* class com.labters.documentscanner.$$Lambda$ApplyFilters$1tFC9nBetCUQlgvTv_6NOnKFXAM */

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ApplyFilters.this.lambda$null$9$ApplyFilters();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class com.labters.documentscanner.$$Lambda$ApplyFilters$EF3LuYj8O8Cwo6MExWdOXbRC8g */

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ApplyFilters.this.lambda$null$10$ApplyFilters((Boolean) obj);
            }
        }));
    }

    public /* synthetic */ Boolean lambda$null$9$ApplyFilters() throws Exception {
        this.isInverted = false;
        this.isContrast1 = false;
        applyContrast2();
        return false;
    }

    public /* synthetic */ void lambda$null$10$ApplyFilters(Boolean bool) throws Exception {
        hideProgressBar();
        this.imageView.setImageBitmap(scaledBitmap(this.cropImage, this.holderImageCrop.getWidth(), this.holderImageCrop.getHeight()));
    }

    private void initView() {
        this.btnDone = (ImageView) findViewById(R.id.btnDone);
        this.btnClose = (ImageView) findViewById(R.id.btnClose);
        this.holderImageCrop = (FrameLayout) findViewById(R.id.holderImageCrop);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.filter4 = (LinearLayout) findViewById(R.id.filter4);
        this.filter3 = (LinearLayout) findViewById(R.id.filter3);
        this.filter1 = (LinearLayout) findViewById(R.id.filter1);
        this.filter2 = (LinearLayout) findViewById(R.id.filter2);
        this.filter4img = (ImageView) findViewById(R.id.filter4img);
        this.filter3img = (ImageView) findViewById(R.id.filter3img);
        this.filter1img = (ImageView) findViewById(R.id.filter1img);
        this.filter2img = (ImageView) findViewById(R.id.filter2img);
        this.text1 = (TextView) findViewById(R.id.filter1_text);
        this.text2 = (TextView) findViewById(R.id.filter2_text);
        this.text3 = (TextView) findViewById(R.id.filter3_text);
        this.text4 = (TextView) findViewById(R.id.filter4_text);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.imageView.setImageBitmap(scaledBitmap(this.cropImage, ScannerConstants.selectedImageBitmap.getWidth(), ScannerConstants.selectedImageBitmap.getHeight()));
        this.text1.setTextColor(getResources().getColor(R.color.colorAccent));
        this.filter1img.setImageResource(R.drawable.ic_filter_normal_selected);
        this.text1.setTypeface(Typeface.DEFAULT_BOLD);
        if (this.progressBar.getIndeterminateDrawable() != null && ScannerConstants.progressColor != null) {
            this.progressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor(ScannerConstants.progressColor), PorterDuff.Mode.MULTIPLY);
        } else if (!(this.progressBar.getProgressDrawable() == null || ScannerConstants.progressColor == null)) {
            this.progressBar.getProgressDrawable().setColorFilter(Color.parseColor(ScannerConstants.progressColor), PorterDuff.Mode.MULTIPLY);
        }
        hideProgressBar();
    }

    private void invertColor() {
        if (!this.isInverted) {
            Bitmap copy = ScannerConstants.selectedImageBitmap.copy(ScannerConstants.selectedImageBitmap.getConfig(), true);
            this.cropImage = copy;
            Bitmap createBitmap = Bitmap.createBitmap(copy.getWidth(), this.cropImage.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            Paint paint = new Paint();
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(this.cropImage, 0.0f, 0.0f, paint);
            this.cropImage = createBitmap.copy(createBitmap.getConfig(), true);
        } else {
            Bitmap bitmap = this.cropImage;
            this.cropImage = bitmap.copy(bitmap.getConfig(), true);
        }
        this.isInverted = !this.isInverted;
    }

    private void applyContrast1() {
        ApplyFilters applyFilters;
        boolean z;
        ApplyFilters applyFilters2 = this;
        if (!applyFilters2.isContrast1) {
            Bitmap copy = ScannerConstants.selectedImageBitmap.copy(ScannerConstants.selectedImageBitmap.getConfig(), true);
            applyFilters2.cropImage = copy;
            int width = copy.getWidth();
            int height = applyFilters2.cropImage.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, applyFilters2.cropImage.getConfig());
            Canvas canvas = new Canvas();
            canvas.setBitmap(createBitmap);
            canvas.drawBitmap(applyFilters2.cropImage, 0.0f, 0.0f, new Paint(-16777216));
            double pow = Math.pow(1.3d, 2.0d);
            int i = 0;
            while (i < width) {
                int i2 = 0;
                while (i2 < height) {
                    int pixel = applyFilters2.cropImage.getPixel(i, i2);
                    int alpha = Color.alpha(pixel);
                    int red = (int) (((((((double) Color.red(pixel)) / 255.0d) - 0.5d) * pow) + 0.5d) * 255.0d);
                    int i3 = 255;
                    if (red < 0) {
                        red = 0;
                    } else if (red > 255) {
                        red = 255;
                    }
                    int green = (int) (((((((double) Color.green(pixel)) / 255.0d) - 0.5d) * pow) + 0.5d) * 255.0d);
                    if (green < 0) {
                        green = 0;
                    } else if (green > 255) {
                        green = 255;
                    }
                    int blue = (int) (((((((double) Color.blue(pixel)) / 255.0d) - 0.5d) * pow) + 0.5d) * 255.0d);
                    if (blue < 0) {
                        i3 = 0;
                    } else if (blue <= 255) {
                        i3 = blue;
                    }
                    createBitmap.setPixel(i, i2, Color.argb(alpha, red, green, i3));
                    i2++;
                    applyFilters2 = this;
                    width = width;
                    height = height;
                }
                i++;
                applyFilters2 = this;
            }
            z = true;
            applyFilters = this;
            applyFilters.cropImage = createBitmap.copy(createBitmap.getConfig(), true);
        } else {
            applyFilters = applyFilters2;
            z = true;
            Bitmap bitmap = applyFilters.cropImage;
            applyFilters.cropImage = bitmap.copy(bitmap.getConfig(), true);
        }
        applyFilters.isContrast1 ^= z;
    }

    private void applyContrast2() {
        ApplyFilters applyFilters;
        boolean z;
        ApplyFilters applyFilters2 = this;
        if (!applyFilters2.isContrast2) {
            Bitmap copy = ScannerConstants.selectedImageBitmap.copy(ScannerConstants.selectedImageBitmap.getConfig(), true);
            applyFilters2.cropImage = copy;
            int width = copy.getWidth();
            int height = applyFilters2.cropImage.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, applyFilters2.cropImage.getConfig());
            Canvas canvas = new Canvas();
            canvas.setBitmap(createBitmap);
            canvas.drawBitmap(applyFilters2.cropImage, 0.0f, 0.0f, new Paint(-16777216));
            double pow = Math.pow(1.2d, 1.0d);
            int i = 0;
            while (i < width) {
                int i2 = 0;
                while (i2 < height) {
                    int pixel = applyFilters2.cropImage.getPixel(i, i2);
                    int alpha = Color.alpha(pixel);
                    int red = (int) (((((((double) Color.red(pixel)) / 255.0d) - 0.5d) * pow) + 0.5d) * 255.0d);
                    int i3 = 255;
                    if (red < 0) {
                        red = 0;
                    } else if (red > 255) {
                        red = 255;
                    }
                    int green = (int) (((((((double) Color.green(pixel)) / 255.0d) - 0.5d) * pow) + 0.5d) * 255.0d);
                    if (green < 0) {
                        green = 0;
                    } else if (green > 255) {
                        green = 255;
                    }
                    int blue = (int) (((((((double) Color.blue(pixel)) / 255.0d) - 0.5d) * pow) + 0.5d) * 255.0d);
                    if (blue < 0) {
                        i3 = 0;
                    } else if (blue <= 255) {
                        i3 = blue;
                    }
                    createBitmap.setPixel(i, i2, Color.argb(alpha, red, green, i3));
                    i2++;
                    applyFilters2 = this;
                    width = width;
                    height = height;
                }
                i++;
                applyFilters2 = this;
            }
            z = true;
            applyFilters = this;
            applyFilters.cropImage = createBitmap.copy(createBitmap.getConfig(), true);
        } else {
            applyFilters = applyFilters2;
            z = true;
            Bitmap bitmap = applyFilters.cropImage;
            applyFilters.cropImage = bitmap.copy(bitmap.getConfig(), true);
        }
        applyFilters.isContrast2 ^= z;
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
        throw new UnsupportedOperationException("Method not decompiled: com.labters.documentscanner.ApplyFilters.saveToInternalStorage(android.graphics.Bitmap):void");
    }
}
