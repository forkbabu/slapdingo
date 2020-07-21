package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

final class CropWindowMoveHandler {
    private static final Matrix MATRIX = new Matrix();
    private final float mMaxCropHeight;
    private final float mMaxCropWidth;
    private final float mMinCropHeight;
    private final float mMinCropWidth;
    private final PointF mTouchOffset = new PointF();
    private final Type mType;

    public enum Type {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER
    }

    private static float calculateAspectRatio(float f, float f2, float f3, float f4) {
        return (f3 - f) / (f4 - f2);
    }

    public CropWindowMoveHandler(Type type, CropWindowHandler cropWindowHandler, float f, float f2) {
        this.mType = type;
        this.mMinCropWidth = cropWindowHandler.getMinCropWidth();
        this.mMinCropHeight = cropWindowHandler.getMinCropHeight();
        this.mMaxCropWidth = cropWindowHandler.getMaxCropWidth();
        this.mMaxCropHeight = cropWindowHandler.getMaxCropHeight();
        calculateTouchOffset(cropWindowHandler.getRect(), f, f2);
    }

    public void move(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3, boolean z, float f4) {
        float f5 = f + this.mTouchOffset.x;
        float f6 = f2 + this.mTouchOffset.y;
        if (this.mType == Type.CENTER) {
            moveCenter(rectF, f5, f6, rectF2, i, i2, f3);
        } else if (z) {
            moveSizeWithFixedAspectRatio(rectF, f5, f6, rectF2, i, i2, f3, f4);
        } else {
            moveSizeWithFreeAspectRatio(rectF, f5, f6, rectF2, i, i2, f3);
        }
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropWindowMoveHandler$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$theartofdev$edmodo$cropper$CropWindowMoveHandler$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.theartofdev.edmodo.cropper.CropWindowMoveHandler$Type[] r0 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.theartofdev.edmodo.cropper.CropWindowMoveHandler.AnonymousClass1.$SwitchMap$com$theartofdev$edmodo$cropper$CropWindowMoveHandler$Type = r0
                com.theartofdev.edmodo.cropper.CropWindowMoveHandler$Type r1 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.Type.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.AnonymousClass1.$SwitchMap$com$theartofdev$edmodo$cropper$CropWindowMoveHandler$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.theartofdev.edmodo.cropper.CropWindowMoveHandler$Type r1 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.Type.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.AnonymousClass1.$SwitchMap$com$theartofdev$edmodo$cropper$CropWindowMoveHandler$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.theartofdev.edmodo.cropper.CropWindowMoveHandler$Type r1 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.Type.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.AnonymousClass1.$SwitchMap$com$theartofdev$edmodo$cropper$CropWindowMoveHandler$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.theartofdev.edmodo.cropper.CropWindowMoveHandler$Type r1 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.Type.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.AnonymousClass1.$SwitchMap$com$theartofdev$edmodo$cropper$CropWindowMoveHandler$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                com.theartofdev.edmodo.cropper.CropWindowMoveHandler$Type r1 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.AnonymousClass1.$SwitchMap$com$theartofdev$edmodo$cropper$CropWindowMoveHandler$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.theartofdev.edmodo.cropper.CropWindowMoveHandler$Type r1 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.AnonymousClass1.$SwitchMap$com$theartofdev$edmodo$cropper$CropWindowMoveHandler$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.theartofdev.edmodo.cropper.CropWindowMoveHandler$Type r1 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.AnonymousClass1.$SwitchMap$com$theartofdev$edmodo$cropper$CropWindowMoveHandler$Type     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.theartofdev.edmodo.cropper.CropWindowMoveHandler$Type r1 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.AnonymousClass1.$SwitchMap$com$theartofdev$edmodo$cropper$CropWindowMoveHandler$Type     // Catch:{ NoSuchFieldError -> 0x006c }
                com.theartofdev.edmodo.cropper.CropWindowMoveHandler$Type r1 = com.theartofdev.edmodo.cropper.CropWindowMoveHandler.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.CropWindowMoveHandler.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void calculateTouchOffset(RectF rectF, float f, float f2) {
        float f3;
        float f4;
        float f5;
        float f6 = 0.0f;
        switch (AnonymousClass1.$SwitchMap$com$theartofdev$edmodo$cropper$CropWindowMoveHandler$Type[this.mType.ordinal()]) {
            case 1:
                f6 = rectF.left - f;
                f4 = rectF.top;
                f3 = f4 - f2;
                break;
            case 2:
                f6 = rectF.right - f;
                f4 = rectF.top;
                f3 = f4 - f2;
                break;
            case 3:
                f6 = rectF.left - f;
                f4 = rectF.bottom;
                f3 = f4 - f2;
                break;
            case 4:
                f6 = rectF.right - f;
                f4 = rectF.bottom;
                f3 = f4 - f2;
                break;
            case 5:
                f5 = rectF.left;
                f6 = f5 - f;
                f3 = 0.0f;
                break;
            case 6:
                f4 = rectF.top;
                f3 = f4 - f2;
                break;
            case 7:
                f5 = rectF.right;
                f6 = f5 - f;
                f3 = 0.0f;
                break;
            case 8:
                f4 = rectF.bottom;
                f3 = f4 - f2;
                break;
            case 9:
                f6 = rectF.centerX() - f;
                f4 = rectF.centerY();
                f3 = f4 - f2;
                break;
            default:
                f3 = 0.0f;
                break;
        }
        this.mTouchOffset.x = f6;
        this.mTouchOffset.y = f3;
    }

    private void moveCenter(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        float centerX = f - rectF.centerX();
        float centerY = f2 - rectF.centerY();
        if (rectF.left + centerX < 0.0f || rectF.right + centerX > ((float) i) || rectF.left + centerX < rectF2.left || rectF.right + centerX > rectF2.right) {
            centerX /= 1.05f;
            this.mTouchOffset.x -= centerX / 2.0f;
        }
        if (rectF.top + centerY < 0.0f || rectF.bottom + centerY > ((float) i2) || rectF.top + centerY < rectF2.top || rectF.bottom + centerY > rectF2.bottom) {
            centerY /= 1.05f;
            this.mTouchOffset.y -= centerY / 2.0f;
        }
        rectF.offset(centerX, centerY);
        snapEdgesToBounds(rectF, rectF2, f3);
    }

    private void moveSizeWithFreeAspectRatio(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        switch (AnonymousClass1.$SwitchMap$com$theartofdev$edmodo$cropper$CropWindowMoveHandler$Type[this.mType.ordinal()]) {
            case 1:
                adjustTop(rectF, f2, rectF2, f3, 0.0f, false, false);
                adjustLeft(rectF, f, rectF2, f3, 0.0f, false, false);
                return;
            case 2:
                adjustTop(rectF, f2, rectF2, f3, 0.0f, false, false);
                adjustRight(rectF, f, rectF2, i, f3, 0.0f, false, false);
                return;
            case 3:
                adjustBottom(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                adjustLeft(rectF, f, rectF2, f3, 0.0f, false, false);
                return;
            case 4:
                adjustBottom(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                adjustRight(rectF, f, rectF2, i, f3, 0.0f, false, false);
                return;
            case 5:
                adjustLeft(rectF, f, rectF2, f3, 0.0f, false, false);
                return;
            case 6:
                adjustTop(rectF, f2, rectF2, f3, 0.0f, false, false);
                return;
            case 7:
                adjustRight(rectF, f, rectF2, i, f3, 0.0f, false, false);
                return;
            case 8:
                adjustBottom(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                return;
            default:
                return;
        }
    }

    private void moveSizeWithFixedAspectRatio(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3, float f4) {
        switch (AnonymousClass1.$SwitchMap$com$theartofdev$edmodo$cropper$CropWindowMoveHandler$Type[this.mType.ordinal()]) {
            case 1:
                if (calculateAspectRatio(f, f2, rectF.right, rectF.bottom) < f4) {
                    adjustTop(rectF, f2, rectF2, f3, f4, true, false);
                    adjustLeftByAspectRatio(rectF, f4);
                    return;
                }
                adjustLeft(rectF, f, rectF2, f3, f4, true, false);
                adjustTopByAspectRatio(rectF, f4);
                return;
            case 2:
                if (calculateAspectRatio(rectF.left, f2, f, rectF.bottom) < f4) {
                    adjustTop(rectF, f2, rectF2, f3, f4, false, true);
                    adjustRightByAspectRatio(rectF, f4);
                    return;
                }
                adjustRight(rectF, f, rectF2, i, f3, f4, true, false);
                adjustTopByAspectRatio(rectF, f4);
                return;
            case 3:
                if (calculateAspectRatio(f, rectF.top, rectF.right, f2) < f4) {
                    adjustBottom(rectF, f2, rectF2, i2, f3, f4, true, false);
                    adjustLeftByAspectRatio(rectF, f4);
                    return;
                }
                adjustLeft(rectF, f, rectF2, f3, f4, false, true);
                adjustBottomByAspectRatio(rectF, f4);
                return;
            case 4:
                if (calculateAspectRatio(rectF.left, rectF.top, f, f2) < f4) {
                    adjustBottom(rectF, f2, rectF2, i2, f3, f4, false, true);
                    adjustRightByAspectRatio(rectF, f4);
                    return;
                }
                adjustRight(rectF, f, rectF2, i, f3, f4, false, true);
                adjustBottomByAspectRatio(rectF, f4);
                return;
            case 5:
                adjustLeft(rectF, f, rectF2, f3, f4, true, true);
                adjustTopBottomByAspectRatio(rectF, rectF2, f4);
                return;
            case 6:
                adjustTop(rectF, f2, rectF2, f3, f4, true, true);
                adjustLeftRightByAspectRatio(rectF, rectF2, f4);
                return;
            case 7:
                adjustRight(rectF, f, rectF2, i, f3, f4, true, true);
                adjustTopBottomByAspectRatio(rectF, rectF2, f4);
                return;
            case 8:
                adjustBottom(rectF, f2, rectF2, i2, f3, f4, true, true);
                adjustLeftRightByAspectRatio(rectF, rectF2, f4);
                return;
            default:
                return;
        }
    }

    private void snapEdgesToBounds(RectF rectF, RectF rectF2, float f) {
        if (rectF.left < rectF2.left + f) {
            rectF.offset(rectF2.left - rectF.left, 0.0f);
        }
        if (rectF.top < rectF2.top + f) {
            rectF.offset(0.0f, rectF2.top - rectF.top);
        }
        if (rectF.right > rectF2.right - f) {
            rectF.offset(rectF2.right - rectF.right, 0.0f);
        }
        if (rectF.bottom > rectF2.bottom - f) {
            rectF.offset(0.0f, rectF2.bottom - rectF.bottom);
        }
    }

    private void adjustLeft(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            this.mTouchOffset.x -= f / 1.1f;
        }
        if (f < rectF2.left) {
            this.mTouchOffset.x -= (f - rectF2.left) / 2.0f;
        }
        if (f - rectF2.left < f2) {
            f = rectF2.left;
        }
        if (rectF.right - f < this.mMinCropWidth) {
            f = rectF.right - this.mMinCropWidth;
        }
        if (rectF.right - f > this.mMaxCropWidth) {
            f = rectF.right - this.mMaxCropWidth;
        }
        if (f - rectF2.left < f2) {
            f = rectF2.left;
        }
        if (f3 > 0.0f) {
            float f4 = (rectF.right - f) / f3;
            if (f4 < this.mMinCropHeight) {
                f = Math.max(rectF2.left, rectF.right - (this.mMinCropHeight * f3));
                f4 = (rectF.right - f) / f3;
            }
            if (f4 > this.mMaxCropHeight) {
                f = Math.max(rectF2.left, rectF.right - (this.mMaxCropHeight * f3));
                f4 = (rectF.right - f) / f3;
            }
            if (!z || !z2) {
                if (z && rectF.bottom - f4 < rectF2.top) {
                    f = Math.max(rectF2.left, rectF.right - ((rectF.bottom - rectF2.top) * f3));
                    f4 = (rectF.right - f) / f3;
                }
                if (z2 && rectF.top + f4 > rectF2.bottom) {
                    f = Math.max(f, Math.max(rectF2.left, rectF.right - ((rectF2.bottom - rectF.top) * f3)));
                }
            } else {
                f = Math.max(f, Math.max(rectF2.left, rectF.right - (rectF2.height() * f3)));
            }
        }
        rectF.left = f;
    }

    private void adjustRight(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        float f4 = (float) i;
        if (f > f4) {
            f = ((f - f4) / 1.05f) + f4;
            this.mTouchOffset.x -= (f - f4) / 1.1f;
        }
        if (f > rectF2.right) {
            this.mTouchOffset.x -= (f - rectF2.right) / 2.0f;
        }
        if (rectF2.right - f < f2) {
            f = rectF2.right;
        }
        if (f - rectF.left < this.mMinCropWidth) {
            f = rectF.left + this.mMinCropWidth;
        }
        if (f - rectF.left > this.mMaxCropWidth) {
            f = rectF.left + this.mMaxCropWidth;
        }
        if (rectF2.right - f < f2) {
            f = rectF2.right;
        }
        if (f3 > 0.0f) {
            float f5 = (f - rectF.left) / f3;
            if (f5 < this.mMinCropHeight) {
                f = Math.min(rectF2.right, rectF.left + (this.mMinCropHeight * f3));
                f5 = (f - rectF.left) / f3;
            }
            if (f5 > this.mMaxCropHeight) {
                f = Math.min(rectF2.right, rectF.left + (this.mMaxCropHeight * f3));
                f5 = (f - rectF.left) / f3;
            }
            if (!z || !z2) {
                if (z && rectF.bottom - f5 < rectF2.top) {
                    f = Math.min(rectF2.right, rectF.left + ((rectF.bottom - rectF2.top) * f3));
                    f5 = (f - rectF.left) / f3;
                }
                if (z2 && rectF.top + f5 > rectF2.bottom) {
                    f = Math.min(f, Math.min(rectF2.right, rectF.left + ((rectF2.bottom - rectF.top) * f3)));
                }
            } else {
                f = Math.min(f, Math.min(rectF2.right, rectF.left + (rectF2.height() * f3)));
            }
        }
        rectF.right = f;
    }

    private void adjustTop(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            this.mTouchOffset.y -= f / 1.1f;
        }
        if (f < rectF2.top) {
            this.mTouchOffset.y -= (f - rectF2.top) / 2.0f;
        }
        if (f - rectF2.top < f2) {
            f = rectF2.top;
        }
        if (rectF.bottom - f < this.mMinCropHeight) {
            f = rectF.bottom - this.mMinCropHeight;
        }
        if (rectF.bottom - f > this.mMaxCropHeight) {
            f = rectF.bottom - this.mMaxCropHeight;
        }
        if (f - rectF2.top < f2) {
            f = rectF2.top;
        }
        if (f3 > 0.0f) {
            float f4 = (rectF.bottom - f) * f3;
            if (f4 < this.mMinCropWidth) {
                f = Math.max(rectF2.top, rectF.bottom - (this.mMinCropWidth / f3));
                f4 = (rectF.bottom - f) * f3;
            }
            if (f4 > this.mMaxCropWidth) {
                f = Math.max(rectF2.top, rectF.bottom - (this.mMaxCropWidth / f3));
                f4 = (rectF.bottom - f) * f3;
            }
            if (!z || !z2) {
                if (z && rectF.right - f4 < rectF2.left) {
                    f = Math.max(rectF2.top, rectF.bottom - ((rectF.right - rectF2.left) / f3));
                    f4 = (rectF.bottom - f) * f3;
                }
                if (z2 && rectF.left + f4 > rectF2.right) {
                    f = Math.max(f, Math.max(rectF2.top, rectF.bottom - ((rectF2.right - rectF.left) / f3)));
                }
            } else {
                f = Math.max(f, Math.max(rectF2.top, rectF.bottom - (rectF2.width() / f3)));
            }
        }
        rectF.top = f;
    }

    private void adjustBottom(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        float f4 = (float) i;
        if (f > f4) {
            f = ((f - f4) / 1.05f) + f4;
            this.mTouchOffset.y -= (f - f4) / 1.1f;
        }
        if (f > rectF2.bottom) {
            this.mTouchOffset.y -= (f - rectF2.bottom) / 2.0f;
        }
        if (rectF2.bottom - f < f2) {
            f = rectF2.bottom;
        }
        if (f - rectF.top < this.mMinCropHeight) {
            f = rectF.top + this.mMinCropHeight;
        }
        if (f - rectF.top > this.mMaxCropHeight) {
            f = rectF.top + this.mMaxCropHeight;
        }
        if (rectF2.bottom - f < f2) {
            f = rectF2.bottom;
        }
        if (f3 > 0.0f) {
            float f5 = (f - rectF.top) * f3;
            if (f5 < this.mMinCropWidth) {
                f = Math.min(rectF2.bottom, rectF.top + (this.mMinCropWidth / f3));
                f5 = (f - rectF.top) * f3;
            }
            if (f5 > this.mMaxCropWidth) {
                f = Math.min(rectF2.bottom, rectF.top + (this.mMaxCropWidth / f3));
                f5 = (f - rectF.top) * f3;
            }
            if (!z || !z2) {
                if (z && rectF.right - f5 < rectF2.left) {
                    f = Math.min(rectF2.bottom, rectF.top + ((rectF.right - rectF2.left) / f3));
                    f5 = (f - rectF.top) * f3;
                }
                if (z2 && rectF.left + f5 > rectF2.right) {
                    f = Math.min(f, Math.min(rectF2.bottom, rectF.top + ((rectF2.right - rectF.left) / f3)));
                }
            } else {
                f = Math.min(f, Math.min(rectF2.bottom, rectF.top + (rectF2.width() / f3)));
            }
        }
        rectF.bottom = f;
    }

    private void adjustLeftByAspectRatio(RectF rectF, float f) {
        rectF.left = rectF.right - (rectF.height() * f);
    }

    private void adjustTopByAspectRatio(RectF rectF, float f) {
        rectF.top = rectF.bottom - (rectF.width() / f);
    }

    private void adjustRightByAspectRatio(RectF rectF, float f) {
        rectF.right = rectF.left + (rectF.height() * f);
    }

    private void adjustBottomByAspectRatio(RectF rectF, float f) {
        rectF.bottom = rectF.top + (rectF.width() / f);
    }

    private void adjustLeftRightByAspectRatio(RectF rectF, RectF rectF2, float f) {
        rectF.inset((rectF.width() - (rectF.height() * f)) / 2.0f, 0.0f);
        if (rectF.left < rectF2.left) {
            rectF.offset(rectF2.left - rectF.left, 0.0f);
        }
        if (rectF.right > rectF2.right) {
            rectF.offset(rectF2.right - rectF.right, 0.0f);
        }
    }

    private void adjustTopBottomByAspectRatio(RectF rectF, RectF rectF2, float f) {
        rectF.inset(0.0f, (rectF.height() - (rectF.width() / f)) / 2.0f);
        if (rectF.top < rectF2.top) {
            rectF.offset(0.0f, rectF2.top - rectF.top);
        }
        if (rectF.bottom > rectF2.bottom) {
            rectF.offset(0.0f, rectF2.bottom - rectF.bottom);
        }
    }
}
