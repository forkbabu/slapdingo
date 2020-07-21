package jp.wasabeef.picasso.transformations;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import com.squareup.picasso.Transformation;

public class CropTransformation implements Transformation {
    private static final String TAG = "PicassoTransformation";
    private float mAspectRatio;
    private GravityHorizontal mGravityHorizontal;
    private GravityVertical mGravityVertical;
    private int mHeight;
    private float mHeightRatio;
    private int mLeft;
    private int mTop;
    private int mWidth;
    private float mWidthRatio;

    public enum GravityHorizontal {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum GravityVertical {
        TOP,
        CENTER,
        BOTTOM
    }

    public CropTransformation(int i, int i2, int i3, int i4) {
        this.mGravityHorizontal = GravityHorizontal.CENTER;
        this.mGravityVertical = GravityVertical.CENTER;
        this.mLeft = i;
        this.mTop = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        this.mGravityHorizontal = null;
        this.mGravityVertical = null;
    }

    public CropTransformation(int i, int i2, GravityHorizontal gravityHorizontal, GravityVertical gravityVertical) {
        this.mGravityHorizontal = GravityHorizontal.CENTER;
        this.mGravityVertical = GravityVertical.CENTER;
        this.mWidth = i;
        this.mHeight = i2;
        this.mGravityHorizontal = gravityHorizontal;
        this.mGravityVertical = gravityVertical;
    }

    public CropTransformation(int i, int i2) {
        this(i, i2, GravityHorizontal.CENTER, GravityVertical.CENTER);
    }

    public CropTransformation(float f, float f2, GravityHorizontal gravityHorizontal, GravityVertical gravityVertical) {
        this.mGravityHorizontal = GravityHorizontal.CENTER;
        this.mGravityVertical = GravityVertical.CENTER;
        this.mWidthRatio = f;
        this.mHeightRatio = f2;
        this.mGravityHorizontal = gravityHorizontal;
        this.mGravityVertical = gravityVertical;
    }

    public CropTransformation(float f, float f2) {
        this(f, f2, GravityHorizontal.CENTER, GravityVertical.CENTER);
    }

    public CropTransformation(int i, int i2, float f, GravityHorizontal gravityHorizontal, GravityVertical gravityVertical) {
        this.mGravityHorizontal = GravityHorizontal.CENTER;
        this.mGravityVertical = GravityVertical.CENTER;
        this.mWidth = i;
        this.mHeight = i2;
        this.mAspectRatio = f;
        this.mGravityHorizontal = gravityHorizontal;
        this.mGravityVertical = gravityVertical;
    }

    public CropTransformation(float f, float f2, float f3, GravityHorizontal gravityHorizontal, GravityVertical gravityVertical) {
        this.mGravityHorizontal = GravityHorizontal.CENTER;
        this.mGravityVertical = GravityVertical.CENTER;
        this.mWidthRatio = f;
        this.mHeightRatio = f2;
        this.mAspectRatio = f3;
        this.mGravityHorizontal = gravityHorizontal;
        this.mGravityVertical = gravityVertical;
    }

    public CropTransformation(float f, GravityHorizontal gravityHorizontal, GravityVertical gravityVertical) {
        this.mGravityHorizontal = GravityHorizontal.CENTER;
        this.mGravityVertical = GravityVertical.CENTER;
        this.mAspectRatio = f;
        this.mGravityHorizontal = gravityHorizontal;
        this.mGravityVertical = gravityVertical;
    }

    @Override // com.squareup.picasso.Transformation
    public Bitmap transform(Bitmap bitmap) {
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "transform(): called, " + key());
        }
        if (this.mWidth == 0 && this.mWidthRatio != 0.0f) {
            this.mWidth = (int) (((float) bitmap.getWidth()) * this.mWidthRatio);
        }
        if (this.mHeight == 0 && this.mHeightRatio != 0.0f) {
            this.mHeight = (int) (((float) bitmap.getHeight()) * this.mHeightRatio);
        }
        if (this.mAspectRatio != 0.0f) {
            if (this.mWidth == 0 && this.mHeight == 0) {
                float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "transform(): mAspectRatio: " + this.mAspectRatio + ", sourceRatio: " + width);
                }
                if (width > this.mAspectRatio) {
                    this.mHeight = bitmap.getHeight();
                } else {
                    this.mWidth = bitmap.getWidth();
                }
            }
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "transform(): before setting other of h/w: mAspectRatio: " + this.mAspectRatio + ", set one of width: " + this.mWidth + ", height: " + this.mHeight);
            }
            int i = this.mWidth;
            if (i != 0) {
                this.mHeight = (int) (((float) i) / this.mAspectRatio);
            } else {
                int i2 = this.mHeight;
                if (i2 != 0) {
                    this.mWidth = (int) (((float) i2) * this.mAspectRatio);
                }
            }
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "transform(): mAspectRatio: " + this.mAspectRatio + ", set width: " + this.mWidth + ", height: " + this.mHeight);
            }
        }
        if (this.mWidth == 0) {
            this.mWidth = bitmap.getWidth();
        }
        if (this.mHeight == 0) {
            this.mHeight = bitmap.getHeight();
        }
        if (this.mGravityHorizontal != null) {
            this.mLeft = getLeft(bitmap);
        }
        if (this.mGravityVertical != null) {
            this.mTop = getTop(bitmap);
        }
        int i3 = this.mLeft;
        int i4 = this.mTop;
        Rect rect = new Rect(i3, i4, this.mWidth + i3, this.mHeight + i4);
        Rect rect2 = new Rect(0, 0, this.mWidth, this.mHeight);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "transform(): created sourceRect with mLeft: " + this.mLeft + ", mTop: " + this.mTop + ", right: " + (this.mLeft + this.mWidth) + ", bottom: " + (this.mTop + this.mHeight));
        }
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "transform(): created targetRect with width: " + this.mWidth + ", height: " + this.mHeight);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "transform(): copying from source with width: " + bitmap.getWidth() + ", height: " + bitmap.getHeight());
        }
        canvas.drawBitmap(bitmap, rect, rect2, (Paint) null);
        bitmap.recycle();
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "transform(): returning bitmap with width: " + createBitmap.getWidth() + ", height: " + createBitmap.getHeight());
        }
        return createBitmap;
    }

    @Override // com.squareup.picasso.Transformation
    public String key() {
        return "CropTransformation(width=" + this.mWidth + ", height=" + this.mHeight + ", mWidthRatio=" + this.mWidthRatio + ", mHeightRatio=" + this.mHeightRatio + ", mAspectRatio=" + this.mAspectRatio + ", gravityHorizontal=" + this.mGravityHorizontal + ", mGravityVertical=" + this.mGravityVertical + ")";
    }

    private int getTop(Bitmap bitmap) {
        int i = AnonymousClass1.$SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityVertical[this.mGravityVertical.ordinal()];
        if (i == 2) {
            return (bitmap.getHeight() - this.mHeight) / 2;
        }
        if (i != 3) {
            return 0;
        }
        return bitmap.getHeight() - this.mHeight;
    }

    /* renamed from: jp.wasabeef.picasso.transformations.CropTransformation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityHorizontal;
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityVertical;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                jp.wasabeef.picasso.transformations.CropTransformation$GravityHorizontal[] r0 = jp.wasabeef.picasso.transformations.CropTransformation.GravityHorizontal.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.wasabeef.picasso.transformations.CropTransformation.AnonymousClass1.$SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityHorizontal = r0
                r1 = 1
                jp.wasabeef.picasso.transformations.CropTransformation$GravityHorizontal r2 = jp.wasabeef.picasso.transformations.CropTransformation.GravityHorizontal.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = jp.wasabeef.picasso.transformations.CropTransformation.AnonymousClass1.$SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityHorizontal     // Catch:{ NoSuchFieldError -> 0x001d }
                jp.wasabeef.picasso.transformations.CropTransformation$GravityHorizontal r3 = jp.wasabeef.picasso.transformations.CropTransformation.GravityHorizontal.CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = jp.wasabeef.picasso.transformations.CropTransformation.AnonymousClass1.$SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityHorizontal     // Catch:{ NoSuchFieldError -> 0x0028 }
                jp.wasabeef.picasso.transformations.CropTransformation$GravityHorizontal r4 = jp.wasabeef.picasso.transformations.CropTransformation.GravityHorizontal.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                jp.wasabeef.picasso.transformations.CropTransformation$GravityVertical[] r3 = jp.wasabeef.picasso.transformations.CropTransformation.GravityVertical.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                jp.wasabeef.picasso.transformations.CropTransformation.AnonymousClass1.$SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityVertical = r3
                jp.wasabeef.picasso.transformations.CropTransformation$GravityVertical r4 = jp.wasabeef.picasso.transformations.CropTransformation.GravityVertical.TOP     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = jp.wasabeef.picasso.transformations.CropTransformation.AnonymousClass1.$SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityVertical     // Catch:{ NoSuchFieldError -> 0x0043 }
                jp.wasabeef.picasso.transformations.CropTransformation$GravityVertical r3 = jp.wasabeef.picasso.transformations.CropTransformation.GravityVertical.CENTER     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = jp.wasabeef.picasso.transformations.CropTransformation.AnonymousClass1.$SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityVertical     // Catch:{ NoSuchFieldError -> 0x004d }
                jp.wasabeef.picasso.transformations.CropTransformation$GravityVertical r1 = jp.wasabeef.picasso.transformations.CropTransformation.GravityVertical.BOTTOM     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.wasabeef.picasso.transformations.CropTransformation.AnonymousClass1.<clinit>():void");
        }
    }

    private int getLeft(Bitmap bitmap) {
        int i = AnonymousClass1.$SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityHorizontal[this.mGravityHorizontal.ordinal()];
        if (i == 2) {
            return (bitmap.getWidth() - this.mWidth) / 2;
        }
        if (i != 3) {
            return 0;
        }
        return bitmap.getWidth() - this.mWidth;
    }
}
