package me.dm7.barcodescanner.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class ViewFinderView extends View implements IViewFinder {
    private static final long ANIMATION_DELAY = 80;
    private static final float LANDSCAPE_HEIGHT_RATIO = 0.625f;
    private static final float LANDSCAPE_WIDTH_HEIGHT_RATIO = 1.4f;
    private static final int MIN_DIMENSION_DIFF = 50;
    private static final int POINT_SIZE = 10;
    private static final float PORTRAIT_WIDTH_HEIGHT_RATIO = 0.75f;
    private static final float PORTRAIT_WIDTH_RATIO = 0.75f;
    private static final int[] SCANNER_ALPHA = {0, 64, 128, 192, 255, 192, 128, 64};
    private static final float SQUARE_DIMENSION_RATIO = 0.625f;
    private static final String TAG = "ViewFinderView";
    protected int mBorderLineLength;
    protected Paint mBorderPaint;
    private final int mDefaultBorderColor = getResources().getColor(R.color.viewfinder_border);
    private final int mDefaultBorderLineLength = getResources().getInteger(R.integer.viewfinder_border_length);
    private final int mDefaultBorderStrokeWidth = getResources().getInteger(R.integer.viewfinder_border_width);
    private final int mDefaultLaserColor = getResources().getColor(R.color.viewfinder_laser);
    private final int mDefaultMaskColor = getResources().getColor(R.color.viewfinder_mask);
    protected Paint mFinderMaskPaint;
    private Rect mFramingRect;
    protected Paint mLaserPaint;
    protected boolean mSquareViewFinder;
    private int scannerAlpha;

    public ViewFinderView(Context context) {
        super(context);
        init();
    }

    public ViewFinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.mLaserPaint = paint;
        paint.setColor(this.mDefaultLaserColor);
        this.mLaserPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.mFinderMaskPaint = paint2;
        paint2.setColor(this.mDefaultMaskColor);
        Paint paint3 = new Paint();
        this.mBorderPaint = paint3;
        paint3.setColor(this.mDefaultBorderColor);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth((float) this.mDefaultBorderStrokeWidth);
        this.mBorderLineLength = this.mDefaultBorderLineLength;
    }

    public void setLaserColor(int i) {
        this.mLaserPaint.setColor(i);
    }

    public void setMaskColor(int i) {
        this.mFinderMaskPaint.setColor(i);
    }

    public void setBorderColor(int i) {
        this.mBorderPaint.setColor(i);
    }

    public void setBorderStrokeWidth(int i) {
        this.mBorderPaint.setStrokeWidth((float) i);
    }

    public void setBorderLineLength(int i) {
        this.mBorderLineLength = i;
    }

    public void setSquareViewFinder(boolean z) {
        this.mSquareViewFinder = z;
    }

    @Override // me.dm7.barcodescanner.core.IViewFinder
    public void setupViewFinder() {
        updateFramingRect();
        invalidate();
    }

    @Override // me.dm7.barcodescanner.core.IViewFinder
    public Rect getFramingRect() {
        return this.mFramingRect;
    }

    public void onDraw(Canvas canvas) {
        if (getFramingRect() != null) {
            drawViewFinderMask(canvas);
            drawViewFinderBorder(canvas);
            drawLaser(canvas);
        }
    }

    public void drawViewFinderMask(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Rect framingRect = getFramingRect();
        float f = (float) width;
        canvas.drawRect(0.0f, 0.0f, f, (float) framingRect.top, this.mFinderMaskPaint);
        canvas.drawRect(0.0f, (float) framingRect.top, (float) framingRect.left, (float) (framingRect.bottom + 1), this.mFinderMaskPaint);
        canvas.drawRect((float) (framingRect.right + 1), (float) framingRect.top, f, (float) (framingRect.bottom + 1), this.mFinderMaskPaint);
        canvas.drawRect(0.0f, (float) (framingRect.bottom + 1), f, (float) height, this.mFinderMaskPaint);
    }

    public void drawViewFinderBorder(Canvas canvas) {
        Rect framingRect = getFramingRect();
        canvas.drawLine((float) (framingRect.left - 1), (float) (framingRect.top - 1), (float) (framingRect.left - 1), (float) ((framingRect.top - 1) + this.mBorderLineLength), this.mBorderPaint);
        canvas.drawLine((float) (framingRect.left - 1), (float) (framingRect.top - 1), (float) ((framingRect.left - 1) + this.mBorderLineLength), (float) (framingRect.top - 1), this.mBorderPaint);
        canvas.drawLine((float) (framingRect.left - 1), (float) (framingRect.bottom + 1), (float) (framingRect.left - 1), (float) ((framingRect.bottom + 1) - this.mBorderLineLength), this.mBorderPaint);
        canvas.drawLine((float) (framingRect.left - 1), (float) (framingRect.bottom + 1), (float) ((framingRect.left - 1) + this.mBorderLineLength), (float) (framingRect.bottom + 1), this.mBorderPaint);
        canvas.drawLine((float) (framingRect.right + 1), (float) (framingRect.top - 1), (float) (framingRect.right + 1), (float) ((framingRect.top - 1) + this.mBorderLineLength), this.mBorderPaint);
        canvas.drawLine((float) (framingRect.right + 1), (float) (framingRect.top - 1), (float) ((framingRect.right + 1) - this.mBorderLineLength), (float) (framingRect.top - 1), this.mBorderPaint);
        canvas.drawLine((float) (framingRect.right + 1), (float) (framingRect.bottom + 1), (float) (framingRect.right + 1), (float) ((framingRect.bottom + 1) - this.mBorderLineLength), this.mBorderPaint);
        canvas.drawLine((float) (framingRect.right + 1), (float) (framingRect.bottom + 1), (float) ((framingRect.right + 1) - this.mBorderLineLength), (float) (framingRect.bottom + 1), this.mBorderPaint);
    }

    public void drawLaser(Canvas canvas) {
        Rect framingRect = getFramingRect();
        this.mLaserPaint.setAlpha(SCANNER_ALPHA[this.scannerAlpha]);
        this.scannerAlpha = (this.scannerAlpha + 1) % SCANNER_ALPHA.length;
        int height = (framingRect.height() / 2) + framingRect.top;
        canvas.drawRect((float) (framingRect.left + 2), (float) (height - 1), (float) (framingRect.right - 1), (float) (height + 2), this.mLaserPaint);
        postInvalidateDelayed(ANIMATION_DELAY, framingRect.left - 10, framingRect.top - 10, framingRect.right + 10, framingRect.bottom + 10);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        updateFramingRect();
    }

    public synchronized void updateFramingRect() {
        int i;
        int i2;
        int i3;
        Point point = new Point(getWidth(), getHeight());
        int screenOrientation = DisplayUtils.getScreenOrientation(getContext());
        if (this.mSquareViewFinder) {
            if (screenOrientation != 1) {
                i3 = getHeight();
            } else {
                i3 = getWidth();
            }
            i2 = (int) (((float) i3) * 0.625f);
            i = i2;
        } else if (screenOrientation != 1) {
            int height = (int) (((float) getHeight()) * 0.625f);
            i = height;
            i2 = (int) (((float) height) * LANDSCAPE_WIDTH_HEIGHT_RATIO);
        } else {
            i2 = (int) (((float) getWidth()) * 0.75f);
            i = (int) (((float) i2) * 0.75f);
        }
        if (i2 > getWidth()) {
            i2 = getWidth() - 50;
        }
        if (i > getHeight()) {
            i = getHeight() - 50;
        }
        int i4 = (point.x - i2) / 2;
        int i5 = (point.y - i) / 2;
        this.mFramingRect = new Rect(i4, i5, i2 + i4, i + i5);
    }
}
