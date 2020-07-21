package com.labters.documentscanner.base;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.labters.documentscanner.R;
import com.labters.documentscanner.libraries.NativeClass;
import com.labters.documentscanner.libraries.PolygonView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;

public abstract class DocumentScanActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public CompositeDisposable disposable = new CompositeDisposable();
    private NativeClass nativeClass = new NativeClass();
    private Bitmap selectedImage;

    /* access modifiers changed from: protected */
    public abstract Bitmap getBitmapImage();

    /* access modifiers changed from: protected */
    public abstract FrameLayout getHolderImageCrop();

    /* access modifiers changed from: protected */
    public abstract ImageView getImageView();

    /* access modifiers changed from: protected */
    public abstract PolygonView getPolygonView();

    /* access modifiers changed from: protected */
    public abstract void hideProgressBar();

    /* access modifiers changed from: protected */
    public abstract void showError(CropperErrorType cropperErrorType);

    /* access modifiers changed from: protected */
    public abstract void showProgressBar();

    private void setImageRotation() {
        Bitmap bitmap = this.selectedImage;
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        int i = 1;
        while (i <= 4) {
            if (this.nativeClass.getPoint(copy) == null) {
                copy = rotateBitmap(copy, (float) (i * 90));
                i++;
            } else {
                this.selectedImage = copy.copy(this.selectedImage.getConfig(), true);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public Bitmap rotateBitmap(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private void setProgressBar(boolean z) {
        if (z) {
            showProgressBar();
        } else {
            hideProgressBar();
        }
    }

    /* access modifiers changed from: protected */
    public void startCropping(Bitmap bitmap) {
        this.selectedImage = bitmap;
        setProgressBar(true);
        this.disposable.add(Observable.fromCallable(new Callable() {
            /* class com.labters.documentscanner.base.$$Lambda$DocumentScanActivity$Ld73f9_sQt4aEYvFiwqqcxAFwZo */

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DocumentScanActivity.this.lambda$startCropping$0$DocumentScanActivity();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class com.labters.documentscanner.base.$$Lambda$DocumentScanActivity$b8vawJZqetkeza9tcR_ZJrzGqFw */

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DocumentScanActivity.this.lambda$startCropping$1$DocumentScanActivity((Boolean) obj);
            }
        }));
    }

    public /* synthetic */ Boolean lambda$startCropping$0$DocumentScanActivity() throws Exception {
        setImageRotation();
        return false;
    }

    public /* synthetic */ void lambda$startCropping$1$DocumentScanActivity(Boolean bool) throws Exception {
        initializeCropping();
        setProgressBar(false);
    }

    private void initializeCropping() {
        getImageView().setImageBitmap(scaledBitmap(this.selectedImage, getHolderImageCrop().getWidth(), getHolderImageCrop().getHeight()));
        Bitmap bitmap = ((BitmapDrawable) getImageView().getDrawable()).getBitmap();
        try {
            getPolygonView().setPoints(getEdgePoints(bitmap));
            getPolygonView().setVisibility(0);
            int dimension = ((int) getResources().getDimension(R.dimen.scanPadding)) * 2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bitmap.getWidth() + dimension, bitmap.getHeight() + dimension);
            layoutParams.gravity = 17;
            getPolygonView().setLayoutParams(layoutParams);
            getPolygonView().setPointColor(getResources().getColor(R.color.blue));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public Bitmap getCroppedImage(Bitmap bitmap) {
        startCropping(bitmap);
        try {
            Map<Integer, PointF> points = getPolygonView().getPoints();
            float width = ((float) this.selectedImage.getWidth()) / ((float) getImageView().getWidth());
            float height = ((float) this.selectedImage.getHeight()) / ((float) getImageView().getHeight());
            float f = ((PointF) Objects.requireNonNull(points.get(1))).x * width;
            float f2 = ((PointF) Objects.requireNonNull(points.get(2))).x * width;
            float f3 = ((PointF) Objects.requireNonNull(points.get(3))).x * width;
            return this.nativeClass.getScannedBitmap(this.selectedImage, ((PointF) Objects.requireNonNull(points.get(0))).x * width, ((PointF) Objects.requireNonNull(points.get(0))).y * height, f, ((PointF) Objects.requireNonNull(points.get(1))).y * height, f2, ((PointF) Objects.requireNonNull(points.get(2))).y * height, f3, ((PointF) Objects.requireNonNull(points.get(3))).y * height);
        } catch (Exception unused) {
            showError(CropperErrorType.CROP_ERROR);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Bitmap scaledBitmap(Bitmap bitmap, int i, int i2) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight()), new RectF(0.0f, 0.0f, (float) i, (float) i2), Matrix.ScaleToFit.CENTER);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private Map<Integer, PointF> getEdgePoints(Bitmap bitmap) throws Exception {
        return orderedValidEdgePoints(bitmap, getContourEdgePoints(bitmap));
    }

    private List<PointF> getContourEdgePoints(Bitmap bitmap) {
        MatOfPoint2f point = this.nativeClass.getPoint(bitmap);
        if (point == null) {
            point = new MatOfPoint2f();
        }
        List asList = Arrays.asList(point.toArray());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < asList.size(); i++) {
            arrayList.add(new PointF((float) ((Point) asList.get(i)).x, (float) ((Point) asList.get(i)).y));
        }
        return arrayList;
    }

    private Map<Integer, PointF> getOutlinePoints(Bitmap bitmap) {
        HashMap hashMap = new HashMap();
        hashMap.put(0, new PointF(0.0f, 0.0f));
        hashMap.put(1, new PointF((float) bitmap.getWidth(), 0.0f));
        hashMap.put(2, new PointF(0.0f, (float) bitmap.getHeight()));
        hashMap.put(3, new PointF((float) bitmap.getWidth(), (float) bitmap.getHeight()));
        return hashMap;
    }

    private Map<Integer, PointF> orderedValidEdgePoints(Bitmap bitmap, List<PointF> list) {
        Map<Integer, PointF> orderedPoints = getPolygonView().getOrderedPoints(list);
        return !getPolygonView().isValidShape(orderedPoints) ? getOutlinePoints(bitmap) : orderedPoints;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        this.disposable.clear();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        this.disposable.dispose();
    }
}
