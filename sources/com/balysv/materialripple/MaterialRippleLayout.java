package com.balysv.materialripple;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;

public class MaterialRippleLayout extends FrameLayout {
    private static final float DEFAULT_ALPHA = 0.2f;
    private static final int DEFAULT_BACKGROUND = 0;
    private static final int DEFAULT_COLOR = -16777216;
    private static final boolean DEFAULT_DELAY_CLICK = true;
    private static final float DEFAULT_DIAMETER_DP = 35.0f;
    private static final int DEFAULT_DURATION = 350;
    private static final int DEFAULT_FADE_DURATION = 75;
    private static final boolean DEFAULT_HOVER = true;
    private static final boolean DEFAULT_PERSISTENT = false;
    private static final boolean DEFAULT_RIPPLE_OVERLAY = false;
    private static final int DEFAULT_ROUNDED_CORNERS = 0;
    private static final boolean DEFAULT_SEARCH_ADAPTER = false;
    private static final int FADE_EXTRA_DELAY = 50;
    private static final long HOVER_DURATION = 2500;
    private final Rect bounds;
    /* access modifiers changed from: private */
    public View childView;
    private Property<MaterialRippleLayout, Integer> circleAlphaProperty;
    private Point currentCoords;
    private boolean eventCancelled;
    private GestureDetector gestureDetector;
    /* access modifiers changed from: private */
    public boolean hasPerformedLongPress;
    private ObjectAnimator hoverAnimator;
    private int layerType;
    private GestureDetector.SimpleOnGestureListener longClickListener;
    private final Paint paint;
    private AdapterView parentAdapter;
    private PerformClickEvent pendingClickEvent;
    private PressedEvent pendingPressEvent;
    private int positionInAdapter;
    /* access modifiers changed from: private */
    public boolean prepressed;
    private Point previousCoords;
    private float radius;
    private Property<MaterialRippleLayout, Float> radiusProperty;
    /* access modifiers changed from: private */
    public int rippleAlpha;
    private AnimatorSet rippleAnimator;
    private Drawable rippleBackground;
    private int rippleColor;
    /* access modifiers changed from: private */
    public boolean rippleDelayClick;
    private int rippleDiameter;
    private int rippleDuration;
    private int rippleFadeDuration;
    /* access modifiers changed from: private */
    public boolean rippleHover;
    /* access modifiers changed from: private */
    public boolean rippleInAdapter;
    private boolean rippleOverlay;
    /* access modifiers changed from: private */
    public boolean ripplePersistent;
    private float rippleRoundedCorners;

    public boolean isInEditMode() {
        return true;
    }

    public static RippleBuilder on(View view) {
        return new RippleBuilder(view);
    }

    public MaterialRippleLayout(Context context) {
        this(context, null, 0);
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint(1);
        this.bounds = new Rect();
        this.currentCoords = new Point();
        this.previousCoords = new Point();
        this.longClickListener = new GestureDetector.SimpleOnGestureListener() {
            /* class com.balysv.materialripple.MaterialRippleLayout.AnonymousClass2 */

            public void onLongPress(MotionEvent motionEvent) {
                MaterialRippleLayout materialRippleLayout = MaterialRippleLayout.this;
                boolean unused = materialRippleLayout.hasPerformedLongPress = materialRippleLayout.childView.performLongClick();
                if (MaterialRippleLayout.this.hasPerformedLongPress) {
                    if (MaterialRippleLayout.this.rippleHover) {
                        MaterialRippleLayout.this.startRipple(null);
                    }
                    MaterialRippleLayout.this.cancelPressedEvent();
                }
            }

            public boolean onDown(MotionEvent motionEvent) {
                boolean unused = MaterialRippleLayout.this.hasPerformedLongPress = false;
                return super.onDown(motionEvent);
            }
        };
        this.radiusProperty = new Property<MaterialRippleLayout, Float>(Float.class, "radius") {
            /* class com.balysv.materialripple.MaterialRippleLayout.AnonymousClass4 */

            public Float get(MaterialRippleLayout materialRippleLayout) {
                return Float.valueOf(materialRippleLayout.getRadius());
            }

            public void set(MaterialRippleLayout materialRippleLayout, Float f) {
                materialRippleLayout.setRadius(f.floatValue());
            }
        };
        this.circleAlphaProperty = new Property<MaterialRippleLayout, Integer>(Integer.class, "rippleAlpha") {
            /* class com.balysv.materialripple.MaterialRippleLayout.AnonymousClass5 */

            public Integer get(MaterialRippleLayout materialRippleLayout) {
                return Integer.valueOf(materialRippleLayout.getRippleAlpha());
            }

            public void set(MaterialRippleLayout materialRippleLayout, Integer num) {
                materialRippleLayout.setRippleAlpha(num);
            }
        };
        setWillNotDraw(false);
        this.gestureDetector = new GestureDetector(context, this.longClickListener);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialRippleLayout);
        this.rippleColor = obtainStyledAttributes.getColor(R.styleable.MaterialRippleLayout_mrl_rippleColor, -16777216);
        this.rippleDiameter = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialRippleLayout_mrl_rippleDimension, (int) dpToPx(getResources(), DEFAULT_DIAMETER_DP));
        this.rippleOverlay = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleOverlay, false);
        this.rippleHover = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleHover, true);
        this.rippleDuration = obtainStyledAttributes.getInt(R.styleable.MaterialRippleLayout_mrl_rippleDuration, DEFAULT_DURATION);
        this.rippleAlpha = (int) (obtainStyledAttributes.getFloat(R.styleable.MaterialRippleLayout_mrl_rippleAlpha, DEFAULT_ALPHA) * 255.0f);
        this.rippleDelayClick = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleDelayClick, true);
        this.rippleFadeDuration = obtainStyledAttributes.getInteger(R.styleable.MaterialRippleLayout_mrl_rippleFadeDuration, 75);
        this.rippleBackground = new ColorDrawable(obtainStyledAttributes.getColor(R.styleable.MaterialRippleLayout_mrl_rippleBackground, 0));
        this.ripplePersistent = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_ripplePersistent, false);
        this.rippleInAdapter = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleInAdapter, false);
        this.rippleRoundedCorners = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialRippleLayout_mrl_rippleRoundedCorners, 0);
        obtainStyledAttributes.recycle();
        this.paint.setColor(this.rippleColor);
        this.paint.setAlpha(this.rippleAlpha);
        enableClipPathSupportIfNecessary();
    }

    public <T extends View> T getChildView() {
        return this.childView;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            this.childView = view;
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout can host only one child");
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        View view = this.childView;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        View view = this.childView;
        if (view != null) {
            view.setOnLongClickListener(onLongClickListener);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !findClickableViewInChild(this.childView, (int) motionEvent.getX(), (int) motionEvent.getY());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (!isEnabled() || !this.childView.isEnabled()) {
            return onTouchEvent;
        }
        boolean contains = this.bounds.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        if (contains) {
            this.previousCoords.set(this.currentCoords.x, this.currentCoords.y);
            this.currentCoords.set((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.gestureDetector.onTouchEvent(motionEvent) && !this.hasPerformedLongPress) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                setPositionInAdapter();
                this.eventCancelled = false;
                this.pendingPressEvent = new PressedEvent(motionEvent);
                if (isInScrollingContainer()) {
                    cancelPressedEvent();
                    this.prepressed = true;
                    postDelayed(this.pendingPressEvent, (long) ViewConfiguration.getTapTimeout());
                } else {
                    this.pendingPressEvent.run();
                }
            } else if (actionMasked == 1) {
                this.pendingClickEvent = new PerformClickEvent();
                if (this.prepressed) {
                    this.childView.setPressed(true);
                    postDelayed(new Runnable() {
                        /* class com.balysv.materialripple.MaterialRippleLayout.AnonymousClass1 */

                        public void run() {
                            MaterialRippleLayout.this.childView.setPressed(false);
                        }
                    }, (long) ViewConfiguration.getPressedStateDuration());
                }
                if (contains) {
                    startRipple(this.pendingClickEvent);
                } else if (!this.rippleHover) {
                    setRadius(0.0f);
                }
                if (!this.rippleDelayClick && contains) {
                    this.pendingClickEvent.run();
                }
                cancelPressedEvent();
            } else if (actionMasked == 2) {
                if (this.rippleHover) {
                    if (contains && !this.eventCancelled) {
                        invalidate();
                    } else if (!contains) {
                        startRipple(null);
                    }
                }
                if (!contains) {
                    cancelPressedEvent();
                    ObjectAnimator objectAnimator = this.hoverAnimator;
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                    }
                    this.childView.onTouchEvent(motionEvent);
                    this.eventCancelled = true;
                }
            } else if (actionMasked == 3) {
                if (this.rippleInAdapter) {
                    this.currentCoords.set(this.previousCoords.x, this.previousCoords.y);
                    this.previousCoords = new Point();
                }
                this.childView.onTouchEvent(motionEvent);
                if (!this.rippleHover) {
                    this.childView.setPressed(false);
                } else if (!this.prepressed) {
                    startRipple(null);
                }
                cancelPressedEvent();
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void cancelPressedEvent() {
        PressedEvent pressedEvent = this.pendingPressEvent;
        if (pressedEvent != null) {
            removeCallbacks(pressedEvent);
            this.prepressed = false;
        }
    }

    /* access modifiers changed from: private */
    public void startHover() {
        if (!this.eventCancelled) {
            ObjectAnimator objectAnimator = this.hoverAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator duration = ObjectAnimator.ofFloat(this, this.radiusProperty, (float) this.rippleDiameter, (float) (Math.sqrt(Math.pow((double) getWidth(), 2.0d) + Math.pow((double) getHeight(), 2.0d)) * 1.2000000476837158d)).setDuration(HOVER_DURATION);
            this.hoverAnimator = duration;
            duration.setInterpolator(new LinearInterpolator());
            this.hoverAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public void startRipple(final Runnable runnable) {
        if (!this.eventCancelled) {
            float endRadius = getEndRadius();
            cancelAnimations();
            AnimatorSet animatorSet = new AnimatorSet();
            this.rippleAnimator = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                /* class com.balysv.materialripple.MaterialRippleLayout.AnonymousClass3 */

                public void onAnimationEnd(Animator animator) {
                    if (!MaterialRippleLayout.this.ripplePersistent) {
                        MaterialRippleLayout.this.setRadius(0.0f);
                        MaterialRippleLayout materialRippleLayout = MaterialRippleLayout.this;
                        materialRippleLayout.setRippleAlpha(Integer.valueOf(materialRippleLayout.rippleAlpha));
                    }
                    if (runnable != null && MaterialRippleLayout.this.rippleDelayClick) {
                        runnable.run();
                    }
                    MaterialRippleLayout.this.childView.setPressed(false);
                }
            });
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.radiusProperty, this.radius, endRadius);
            ofFloat.setDuration((long) this.rippleDuration);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this, this.circleAlphaProperty, this.rippleAlpha, 0);
            ofInt.setDuration((long) this.rippleFadeDuration);
            ofInt.setInterpolator(new AccelerateInterpolator());
            ofInt.setStartDelay((long) ((this.rippleDuration - this.rippleFadeDuration) - 50));
            if (this.ripplePersistent) {
                this.rippleAnimator.play(ofFloat);
            } else if (getRadius() > endRadius) {
                ofInt.setStartDelay(0);
                this.rippleAnimator.play(ofInt);
            } else {
                this.rippleAnimator.playTogether(ofFloat, ofInt);
            }
            this.rippleAnimator.start();
        }
    }

    private void cancelAnimations() {
        AnimatorSet animatorSet = this.rippleAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.rippleAnimator.removeAllListeners();
        }
        ObjectAnimator objectAnimator = this.hoverAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private float getEndRadius() {
        int width = getWidth();
        int height = getHeight();
        return ((float) Math.sqrt(Math.pow((double) ((float) (width / 2 > this.currentCoords.x ? width - this.currentCoords.x : this.currentCoords.x)), 2.0d) + Math.pow((double) ((float) (height / 2 > this.currentCoords.y ? height - this.currentCoords.y : this.currentCoords.y)), 2.0d))) * 1.2f;
    }

    private boolean isInScrollingContainer() {
        ViewParent parent = getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public AdapterView findParentAdapterView() {
        AdapterView adapterView = this.parentAdapter;
        if (adapterView != null) {
            return adapterView;
        }
        ViewParent parent = getParent();
        while (!(parent instanceof AdapterView)) {
            try {
                parent = parent.getParent();
            } catch (NullPointerException unused) {
                throw new RuntimeException("Could not find a parent AdapterView");
            }
        }
        AdapterView adapterView2 = (AdapterView) parent;
        this.parentAdapter = adapterView2;
        return adapterView2;
    }

    private void setPositionInAdapter() {
        if (this.rippleInAdapter) {
            this.positionInAdapter = findParentAdapterView().getPositionForView(this);
        }
    }

    private boolean adapterPositionChanged() {
        if (!this.rippleInAdapter) {
            return false;
        }
        int positionForView = findParentAdapterView().getPositionForView(this);
        boolean z = positionForView != this.positionInAdapter;
        this.positionInAdapter = positionForView;
        if (z) {
            cancelPressedEvent();
            cancelAnimations();
            this.childView.setPressed(false);
            setRadius(0.0f);
        }
        return z;
    }

    private boolean findClickableViewInChild(View view, int i, int i2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return findClickableViewInChild(childAt, i - rect.left, i2 - rect.top);
                }
            }
        } else if (view != this.childView) {
            if (!view.isEnabled()) {
                return false;
            }
            if (view.isClickable() || view.isLongClickable() || view.isFocusableInTouchMode()) {
                return true;
            }
            return false;
        }
        return view.isFocusableInTouchMode();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bounds.set(0, 0, i, i2);
        this.rippleBackground.setBounds(this.bounds);
    }

    public void draw(Canvas canvas) {
        boolean adapterPositionChanged = adapterPositionChanged();
        if (this.rippleOverlay) {
            if (!adapterPositionChanged) {
                this.rippleBackground.draw(canvas);
            }
            super.draw(canvas);
            if (!adapterPositionChanged) {
                if (this.rippleRoundedCorners != 0.0f) {
                    Path path = new Path();
                    RectF rectF = new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
                    float f = this.rippleRoundedCorners;
                    path.addRoundRect(rectF, f, f, Path.Direction.CW);
                    canvas.clipPath(path);
                }
                canvas.drawCircle((float) this.currentCoords.x, (float) this.currentCoords.y, this.radius, this.paint);
                return;
            }
            return;
        }
        if (!adapterPositionChanged) {
            this.rippleBackground.draw(canvas);
            canvas.drawCircle((float) this.currentCoords.x, (float) this.currentCoords.y, this.radius, this.paint);
        }
        super.draw(canvas);
    }

    /* access modifiers changed from: private */
    public float getRadius() {
        return this.radius;
    }

    public void setRadius(float f) {
        this.radius = f;
        invalidate();
    }

    public int getRippleAlpha() {
        return this.paint.getAlpha();
    }

    public void setRippleAlpha(Integer num) {
        this.paint.setAlpha(num.intValue());
        invalidate();
    }

    public void setRippleColor(int i) {
        this.rippleColor = i;
        this.paint.setColor(i);
        this.paint.setAlpha(this.rippleAlpha);
        invalidate();
    }

    public void setRippleOverlay(boolean z) {
        this.rippleOverlay = z;
    }

    public void setRippleDiameter(int i) {
        this.rippleDiameter = i;
    }

    public void setRippleDuration(int i) {
        this.rippleDuration = i;
    }

    public void setRippleBackground(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.rippleBackground = colorDrawable;
        colorDrawable.setBounds(this.bounds);
        invalidate();
    }

    public void setRippleHover(boolean z) {
        this.rippleHover = z;
    }

    public void setRippleDelayClick(boolean z) {
        this.rippleDelayClick = z;
    }

    public void setRippleFadeDuration(int i) {
        this.rippleFadeDuration = i;
    }

    public void setRipplePersistent(boolean z) {
        this.ripplePersistent = z;
    }

    public void setRippleInAdapter(boolean z) {
        this.rippleInAdapter = z;
    }

    public void setRippleRoundedCorners(int i) {
        this.rippleRoundedCorners = (float) i;
        enableClipPathSupportIfNecessary();
    }

    public void setDefaultRippleAlpha(int i) {
        this.rippleAlpha = i;
        this.paint.setAlpha(i);
        invalidate();
    }

    public void performRipple() {
        this.currentCoords = new Point(getWidth() / 2, getHeight() / 2);
        startRipple(null);
    }

    public void performRipple(Point point) {
        this.currentCoords = new Point(point.x, point.y);
        startRipple(null);
    }

    private void enableClipPathSupportIfNecessary() {
        if (Build.VERSION.SDK_INT > 17) {
            return;
        }
        if (this.rippleRoundedCorners != 0.0f) {
            this.layerType = getLayerType();
            setLayerType(1, null);
            return;
        }
        setLayerType(this.layerType, null);
    }

    private class PerformClickEvent implements Runnable {
        private PerformClickEvent() {
        }

        public void run() {
            if (!MaterialRippleLayout.this.hasPerformedLongPress) {
                if (MaterialRippleLayout.this.getParent() instanceof AdapterView) {
                    clickAdapterView((AdapterView) MaterialRippleLayout.this.getParent());
                } else if (MaterialRippleLayout.this.rippleInAdapter) {
                    clickAdapterView(MaterialRippleLayout.this.findParentAdapterView());
                } else {
                    MaterialRippleLayout.this.childView.performClick();
                }
            }
        }

        private void clickAdapterView(AdapterView adapterView) {
            int positionForView = adapterView.getPositionForView(MaterialRippleLayout.this);
            long itemId = adapterView.getAdapter() != null ? adapterView.getAdapter().getItemId(positionForView) : 0;
            if (positionForView != -1) {
                adapterView.performItemClick(MaterialRippleLayout.this, positionForView, itemId);
            }
        }
    }

    private final class PressedEvent implements Runnable {
        private final MotionEvent event;

        public PressedEvent(MotionEvent motionEvent) {
            this.event = motionEvent;
        }

        public void run() {
            boolean unused = MaterialRippleLayout.this.prepressed = false;
            MaterialRippleLayout.this.childView.setLongClickable(false);
            MaterialRippleLayout.this.childView.onTouchEvent(this.event);
            MaterialRippleLayout.this.childView.setPressed(true);
            if (MaterialRippleLayout.this.rippleHover) {
                MaterialRippleLayout.this.startHover();
            }
        }
    }

    static float dpToPx(Resources resources, float f) {
        return TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    public static class RippleBuilder {
        private final View child;
        private final Context context;
        private float rippleAlpha = MaterialRippleLayout.DEFAULT_ALPHA;
        private int rippleBackground = 0;
        private int rippleColor = -16777216;
        private boolean rippleDelayClick = true;
        private float rippleDiameter = MaterialRippleLayout.DEFAULT_DIAMETER_DP;
        private int rippleDuration = MaterialRippleLayout.DEFAULT_DURATION;
        private int rippleFadeDuration = 75;
        private boolean rippleHover = true;
        private boolean rippleOverlay = false;
        private boolean ripplePersistent = false;
        private float rippleRoundedCorner = 0.0f;
        private boolean rippleSearchAdapter = false;

        public RippleBuilder(View view) {
            this.child = view;
            this.context = view.getContext();
        }

        public RippleBuilder rippleColor(int i) {
            this.rippleColor = i;
            return this;
        }

        public RippleBuilder rippleOverlay(boolean z) {
            this.rippleOverlay = z;
            return this;
        }

        public RippleBuilder rippleHover(boolean z) {
            this.rippleHover = z;
            return this;
        }

        public RippleBuilder rippleDiameterDp(int i) {
            this.rippleDiameter = (float) i;
            return this;
        }

        public RippleBuilder rippleDuration(int i) {
            this.rippleDuration = i;
            return this;
        }

        public RippleBuilder rippleAlpha(float f) {
            this.rippleAlpha = f * 255.0f;
            return this;
        }

        public RippleBuilder rippleDelayClick(boolean z) {
            this.rippleDelayClick = z;
            return this;
        }

        public RippleBuilder rippleFadeDuration(int i) {
            this.rippleFadeDuration = i;
            return this;
        }

        public RippleBuilder ripplePersistent(boolean z) {
            this.ripplePersistent = z;
            return this;
        }

        public RippleBuilder rippleBackground(int i) {
            this.rippleBackground = i;
            return this;
        }

        public RippleBuilder rippleInAdapter(boolean z) {
            this.rippleSearchAdapter = z;
            return this;
        }

        public RippleBuilder rippleRoundedCorners(int i) {
            this.rippleRoundedCorner = (float) i;
            return this;
        }

        public MaterialRippleLayout create() {
            int i;
            MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(this.context);
            materialRippleLayout.setRippleColor(this.rippleColor);
            materialRippleLayout.setDefaultRippleAlpha((int) this.rippleAlpha);
            materialRippleLayout.setRippleDelayClick(this.rippleDelayClick);
            materialRippleLayout.setRippleDiameter((int) MaterialRippleLayout.dpToPx(this.context.getResources(), this.rippleDiameter));
            materialRippleLayout.setRippleDuration(this.rippleDuration);
            materialRippleLayout.setRippleFadeDuration(this.rippleFadeDuration);
            materialRippleLayout.setRippleHover(this.rippleHover);
            materialRippleLayout.setRipplePersistent(this.ripplePersistent);
            materialRippleLayout.setRippleOverlay(this.rippleOverlay);
            materialRippleLayout.setRippleBackground(this.rippleBackground);
            materialRippleLayout.setRippleInAdapter(this.rippleSearchAdapter);
            materialRippleLayout.setRippleRoundedCorners((int) MaterialRippleLayout.dpToPx(this.context.getResources(), this.rippleRoundedCorner));
            ViewGroup.LayoutParams layoutParams = this.child.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) this.child.getParent();
            if (viewGroup == null || !(viewGroup instanceof MaterialRippleLayout)) {
                if (viewGroup != null) {
                    i = viewGroup.indexOfChild(this.child);
                    viewGroup.removeView(this.child);
                } else {
                    i = 0;
                }
                materialRippleLayout.addView(this.child, new ViewGroup.LayoutParams(-1, -1));
                if (viewGroup != null) {
                    viewGroup.addView(materialRippleLayout, i, layoutParams);
                }
                return materialRippleLayout;
            }
            throw new IllegalStateException("MaterialRippleLayout could not be created: parent of the view already is a MaterialRippleLayout");
        }
    }
}
