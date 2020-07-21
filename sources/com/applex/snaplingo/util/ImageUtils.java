package com.applex.snaplingo.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.itextpdf.text.Rectangle;
import java.io.File;

public class ImageUtils {
    public String mImageScaleType;

    private static class SingletonHolder {
        static final ImageUtils INSTANCE = new ImageUtils();

        private SingletonHolder() {
        }
    }

    public static ImageUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    static Rectangle calculateFitSize(float f, float f2, Rectangle rectangle) {
        float max = Math.max((f - rectangle.getWidth()) / f, (f2 - rectangle.getHeight()) / f2);
        return new Rectangle((float) Math.abs((int) (f - (f * max))), (float) Math.abs((int) (f2 - (max * f2))));
    }

    public Bitmap getRoundBitmap(Bitmap bitmap) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        if (!(bitmap.getWidth() == min && bitmap.getHeight() == min)) {
            float min2 = ((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) / ((float) min);
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) / min2), (int) (((float) bitmap.getHeight()) / min2), false);
        }
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, min, min);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#BAB399"));
        float f = ((float) min) / 2.0f;
        float f2 = 0.7f + f;
        canvas.drawCircle(f2, f2, f + 0.1f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public Bitmap getRoundBitmapFromPath(String str) {
        File file = new File(str);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = calculateInSampleSize(options);
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        if (decodeFile == null) {
            return null;
        }
        return getInstance().getRoundBitmap(decodeFile);
    }

    private int calculateInSampleSize(BitmapFactory.Options options) {
        int i = options.outHeight;
        int i2 = options.outWidth;
        int i3 = 1;
        if (i > 500 || i2 > 500) {
            int i4 = i / 2;
            int i5 = i2 / 2;
            while (i4 / i3 >= 500 && i5 / i3 >= 500) {
                i3 *= 2;
            }
        }
        return i3;
    }

    public Bitmap toGrayscale(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }
}
