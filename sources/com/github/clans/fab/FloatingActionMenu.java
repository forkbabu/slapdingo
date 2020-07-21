package com.github.clans.fab;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import java.util.ArrayList;

public class FloatingActionMenu extends ViewGroup {
    private static final int ANIMATION_DURATION = 300;
    private static final float CLOSED_PLUS_ROTATION = 0.0f;
    private static final int LABELS_POSITION_LEFT = 0;
    private static final int LABELS_POSITION_RIGHT = 1;
    private static final float OPENED_PLUS_ROTATION_LEFT = -135.0f;
    private static final float OPENED_PLUS_ROTATION_RIGHT = 135.0f;
    private static final int OPEN_DOWN = 1;
    private static final int OPEN_UP = 0;
    private int mAnimationDelayPerItem;
    private int mBackgroundColor;
    private int mButtonSpacing;
    private int mButtonsCount;
    private AnimatorSet mCloseAnimatorSet;
    private Interpolator mCloseInterpolator;
    private Typeface mCustomTypefaceFromFont;
    private ValueAnimator mHideBackgroundAnimator;
    private Drawable mIcon;
    private boolean mIconAnimated;
    private AnimatorSet mIconToggleSet;
    private ImageView mImageToggle;
    private Animation mImageToggleHideAnimation;
    private Animation mImageToggleShowAnimation;
    /* access modifiers changed from: private */
    public boolean mIsAnimated;
    /* access modifiers changed from: private */
    public boolean mIsMenuButtonAnimationRunning;
    private boolean mIsMenuOpening;
    private boolean mIsSetClosedOnTouchOutside;
    private int mLabelsColorNormal;
    private int mLabelsColorPressed;
    private int mLabelsColorRipple;
    private Context mLabelsContext;
    private int mLabelsCornerRadius;
    private int mLabelsEllipsize;
    private int mLabelsHideAnimation;
    private int mLabelsMargin;
    private int mLabelsMaxLines;
    private int mLabelsPaddingBottom;
    private int mLabelsPaddingLeft;
    private int mLabelsPaddingRight;
    private int mLabelsPaddingTop;
    private int mLabelsPosition;
    private int mLabelsShowAnimation;
    private boolean mLabelsShowShadow;
    private boolean mLabelsSingleLine;
    private int mLabelsStyle;
    private ColorStateList mLabelsTextColor;
    private float mLabelsTextSize;
    private int mLabelsVerticalOffset;
    private int mMaxButtonWidth;
    /* access modifiers changed from: private */
    public FloatingActionButton mMenuButton;
    /* access modifiers changed from: private */
    public Animation mMenuButtonHideAnimation;
    private Animation mMenuButtonShowAnimation;
    private int mMenuColorNormal;
    private int mMenuColorPressed;
    private int mMenuColorRipple;
    private int mMenuFabSize;
    private String mMenuLabelText;
    /* access modifiers changed from: private */
    public boolean mMenuOpened;
    private int mMenuShadowColor;
    private float mMenuShadowRadius;
    private float mMenuShadowXOffset;
    private float mMenuShadowYOffset;
    private boolean mMenuShowShadow;
    private AnimatorSet mOpenAnimatorSet;
    private int mOpenDirection;
    private Interpolator mOpenInterpolator;
    private ValueAnimator mShowBackgroundAnimator;
    /* access modifiers changed from: private */
    public OnMenuToggleListener mToggleListener;
    private Handler mUiHandler;
    private boolean mUsingMenuLabel;

    public interface OnMenuToggleListener {
        void onMenuToggle(boolean z);
    }

    private int adjustForOvershoot(int i) {
        double d = (double) i;
        return (int) ((0.03d * d) + d);
    }

    public FloatingActionMenu(Context context) {
        this(context, null);
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOpenAnimatorSet = new AnimatorSet();
        this.mCloseAnimatorSet = new AnimatorSet();
        this.mButtonSpacing = Util.dpToPx(getContext(), 0.0f);
        this.mLabelsMargin = Util.dpToPx(getContext(), 0.0f);
        this.mLabelsVerticalOffset = Util.dpToPx(getContext(), 0.0f);
        this.mUiHandler = new Handler();
        this.mLabelsPaddingTop = Util.dpToPx(getContext(), 4.0f);
        this.mLabelsPaddingRight = Util.dpToPx(getContext(), 8.0f);
        this.mLabelsPaddingBottom = Util.dpToPx(getContext(), 4.0f);
        this.mLabelsPaddingLeft = Util.dpToPx(getContext(), 8.0f);
        this.mLabelsCornerRadius = Util.dpToPx(getContext(), 3.0f);
        this.mMenuShadowRadius = 4.0f;
        this.mMenuShadowXOffset = 1.0f;
        this.mMenuShadowYOffset = 3.0f;
        this.mIsAnimated = true;
        this.mIconAnimated = true;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionMenu, 0, 0);
        this.mButtonSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_buttonSpacing, this.mButtonSpacing);
        this.mLabelsMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_margin, this.mLabelsMargin);
        this.mLabelsPosition = obtainStyledAttributes.getInt(R.styleable.FloatingActionMenu_menu_labels_position, 0);
        this.mLabelsShowAnimation = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionMenu_menu_labels_showAnimation, this.mLabelsPosition == 0 ? R.anim.fab_slide_in_from_right : R.anim.fab_slide_in_from_left);
        this.mLabelsHideAnimation = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionMenu_menu_labels_hideAnimation, this.mLabelsPosition == 0 ? R.anim.fab_slide_out_to_right : R.anim.fab_slide_out_to_left);
        this.mLabelsPaddingTop = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_paddingTop, this.mLabelsPaddingTop);
        this.mLabelsPaddingRight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_paddingRight, this.mLabelsPaddingRight);
        this.mLabelsPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_paddingBottom, this.mLabelsPaddingBottom);
        this.mLabelsPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_paddingLeft, this.mLabelsPaddingLeft);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.FloatingActionMenu_menu_labels_textColor);
        this.mLabelsTextColor = colorStateList;
        if (colorStateList == null) {
            this.mLabelsTextColor = ColorStateList.valueOf(-1);
        }
        this.mLabelsTextSize = obtainStyledAttributes.getDimension(R.styleable.FloatingActionMenu_menu_labels_textSize, getResources().getDimension(R.dimen.labels_text_size));
        this.mLabelsCornerRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_cornerRadius, this.mLabelsCornerRadius);
        this.mLabelsShowShadow = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionMenu_menu_labels_showShadow, true);
        this.mLabelsColorNormal = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_labels_colorNormal, -13421773);
        this.mLabelsColorPressed = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_labels_colorPressed, -12303292);
        this.mLabelsColorRipple = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_labels_colorRipple, 1728053247);
        this.mMenuShowShadow = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionMenu_menu_showShadow, true);
        this.mMenuShadowColor = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_shadowColor, 1711276032);
        this.mMenuShadowRadius = obtainStyledAttributes.getDimension(R.styleable.FloatingActionMenu_menu_shadowRadius, this.mMenuShadowRadius);
        this.mMenuShadowXOffset = obtainStyledAttributes.getDimension(R.styleable.FloatingActionMenu_menu_shadowXOffset, this.mMenuShadowXOffset);
        this.mMenuShadowYOffset = obtainStyledAttributes.getDimension(R.styleable.FloatingActionMenu_menu_shadowYOffset, this.mMenuShadowYOffset);
        this.mMenuColorNormal = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_colorNormal, -2473162);
        this.mMenuColorPressed = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_colorPressed, -1617853);
        this.mMenuColorRipple = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_colorRipple, -1711276033);
        this.mAnimationDelayPerItem = obtainStyledAttributes.getInt(R.styleable.FloatingActionMenu_menu_animationDelayPerItem, 50);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.FloatingActionMenu_menu_icon);
        this.mIcon = drawable;
        if (drawable == null) {
            this.mIcon = getResources().getDrawable(R.drawable.fab_add);
        }
        this.mLabelsSingleLine = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionMenu_menu_labels_singleLine, false);
        this.mLabelsEllipsize = obtainStyledAttributes.getInt(R.styleable.FloatingActionMenu_menu_labels_ellipsize, 0);
        this.mLabelsMaxLines = obtainStyledAttributes.getInt(R.styleable.FloatingActionMenu_menu_labels_maxLines, -1);
        this.mMenuFabSize = obtainStyledAttributes.getInt(R.styleable.FloatingActionMenu_menu_fab_size, 0);
        this.mLabelsStyle = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionMenu_menu_labels_style, 0);
        String string = obtainStyledAttributes.getString(R.styleable.FloatingActionMenu_menu_labels_customFont);
        try {
            if (!TextUtils.isEmpty(string)) {
                this.mCustomTypefaceFromFont = Typeface.createFromAsset(getContext().getAssets(), string);
            }
            this.mOpenDirection = obtainStyledAttributes.getInt(R.styleable.FloatingActionMenu_menu_openDirection, 0);
            this.mBackgroundColor = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_backgroundColor, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.FloatingActionMenu_menu_fab_label)) {
                this.mUsingMenuLabel = true;
                this.mMenuLabelText = obtainStyledAttributes.getString(R.styleable.FloatingActionMenu_menu_fab_label);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.FloatingActionMenu_menu_labels_padding)) {
                initPadding(obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_padding, 0));
            }
            this.mOpenInterpolator = new OvershootInterpolator();
            this.mCloseInterpolator = new AnticipateInterpolator();
            this.mLabelsContext = new ContextThemeWrapper(getContext(), this.mLabelsStyle);
            initBackgroundDimAnimation();
            createMenuButton();
            initMenuButtonAnimations(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Unable to load specified custom font: " + string, e);
        }
    }

    private void initMenuButtonAnimations(TypedArray typedArray) {
        int resourceId = typedArray.getResourceId(R.styleable.FloatingActionMenu_menu_fab_show_animation, R.anim.fab_scale_up);
        setMenuButtonShowAnimation(AnimationUtils.loadAnimation(getContext(), resourceId));
        this.mImageToggleShowAnimation = AnimationUtils.loadAnimation(getContext(), resourceId);
        int resourceId2 = typedArray.getResourceId(R.styleable.FloatingActionMenu_menu_fab_hide_animation, R.anim.fab_scale_down);
        setMenuButtonHideAnimation(AnimationUtils.loadAnimation(getContext(), resourceId2));
        this.mImageToggleHideAnimation = AnimationUtils.loadAnimation(getContext(), resourceId2);
    }

    private void initBackgroundDimAnimation() {
        int alpha = Color.alpha(this.mBackgroundColor);
        final int red = Color.red(this.mBackgroundColor);
        final int green = Color.green(this.mBackgroundColor);
        final int blue = Color.blue(this.mBackgroundColor);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, alpha);
        this.mShowBackgroundAnimator = ofInt;
        ofInt.setDuration(300L);
        this.mShowBackgroundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.github.clans.fab.FloatingActionMenu.AnonymousClass1 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingActionMenu.this.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), red, green, blue));
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(alpha, 0);
        this.mHideBackgroundAnimator = ofInt2;
        ofInt2.setDuration(300L);
        this.mHideBackgroundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.github.clans.fab.FloatingActionMenu.AnonymousClass2 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingActionMenu.this.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), red, green, blue));
            }
        });
    }

    private boolean isBackgroundEnabled() {
        return this.mBackgroundColor != 0;
    }

    private void initPadding(int i) {
        this.mLabelsPaddingTop = i;
        this.mLabelsPaddingRight = i;
        this.mLabelsPaddingBottom = i;
        this.mLabelsPaddingLeft = i;
    }

    private void createMenuButton() {
        FloatingActionButton floatingActionButton = new FloatingActionButton(getContext());
        this.mMenuButton = floatingActionButton;
        floatingActionButton.mShowShadow = this.mMenuShowShadow;
        if (this.mMenuShowShadow) {
            this.mMenuButton.mShadowRadius = Util.dpToPx(getContext(), this.mMenuShadowRadius);
            this.mMenuButton.mShadowXOffset = Util.dpToPx(getContext(), this.mMenuShadowXOffset);
            this.mMenuButton.mShadowYOffset = Util.dpToPx(getContext(), this.mMenuShadowYOffset);
        }
        this.mMenuButton.setColors(this.mMenuColorNormal, this.mMenuColorPressed, this.mMenuColorRipple);
        this.mMenuButton.mShadowColor = this.mMenuShadowColor;
        this.mMenuButton.mFabSize = this.mMenuFabSize;
        this.mMenuButton.updateBackground();
        this.mMenuButton.setLabelText(this.mMenuLabelText);
        ImageView imageView = new ImageView(getContext());
        this.mImageToggle = imageView;
        imageView.setImageDrawable(this.mIcon);
        addView(this.mMenuButton, super.generateDefaultLayoutParams());
        addView(this.mImageToggle);
        createDefaultIconAnimation();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        if (r8.mLabelsPosition == 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        if (r8.mLabelsPosition == 0) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createDefaultIconAnimation() {
        /*
            r8 = this;
            int r0 = r8.mOpenDirection
            r1 = 1124532224(0x43070000, float:135.0)
            r2 = -1022951424(0xffffffffc3070000, float:-135.0)
            if (r0 != 0) goto L_0x0018
            int r0 = r8.mLabelsPosition
            if (r0 != 0) goto L_0x000f
            r0 = -1022951424(0xffffffffc3070000, float:-135.0)
            goto L_0x0011
        L_0x000f:
            r0 = 1124532224(0x43070000, float:135.0)
        L_0x0011:
            int r3 = r8.mLabelsPosition
            if (r3 != 0) goto L_0x0025
        L_0x0015:
            r1 = -1022951424(0xffffffffc3070000, float:-135.0)
            goto L_0x0025
        L_0x0018:
            int r0 = r8.mLabelsPosition
            if (r0 != 0) goto L_0x001f
            r0 = 1124532224(0x43070000, float:135.0)
            goto L_0x0021
        L_0x001f:
            r0 = -1022951424(0xffffffffc3070000, float:-135.0)
        L_0x0021:
            int r3 = r8.mLabelsPosition
            if (r3 != 0) goto L_0x0015
        L_0x0025:
            android.widget.ImageView r2 = r8.mImageToggle
            r3 = 2
            float[] r4 = new float[r3]
            r5 = 0
            r4[r5] = r0
            r0 = 1
            r6 = 0
            r4[r0] = r6
            java.lang.String r7 = "rotation"
            android.animation.ObjectAnimator r2 = android.animation.ObjectAnimator.ofFloat(r2, r7, r4)
            android.widget.ImageView r4 = r8.mImageToggle
            float[] r3 = new float[r3]
            r3[r5] = r6
            r3[r0] = r1
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r4, r7, r3)
            android.animation.AnimatorSet r1 = r8.mOpenAnimatorSet
            r1.play(r0)
            android.animation.AnimatorSet r0 = r8.mCloseAnimatorSet
            r0.play(r2)
            android.animation.AnimatorSet r0 = r8.mOpenAnimatorSet
            android.view.animation.Interpolator r1 = r8.mOpenInterpolator
            r0.setInterpolator(r1)
            android.animation.AnimatorSet r0 = r8.mCloseAnimatorSet
            android.view.animation.Interpolator r1 = r8.mCloseInterpolator
            r0.setInterpolator(r1)
            android.animation.AnimatorSet r0 = r8.mOpenAnimatorSet
            r1 = 300(0x12c, double:1.48E-321)
            r0.setDuration(r1)
            android.animation.AnimatorSet r0 = r8.mCloseAnimatorSet
            r0.setDuration(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.clans.fab.FloatingActionMenu.createDefaultIconAnimation():void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.mMaxButtonWidth = 0;
        measureChildWithMargins(this.mImageToggle, i, 0, i2, 0);
        for (int i3 = 0; i3 < this.mButtonsCount; i3++) {
            View childAt = getChildAt(i3);
            if (!(childAt.getVisibility() == 8 || childAt == this.mImageToggle)) {
                measureChildWithMargins(childAt, i, 0, i2, 0);
                this.mMaxButtonWidth = Math.max(this.mMaxButtonWidth, childAt.getMeasuredWidth());
            }
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = 1;
            if (i5 >= this.mButtonsCount) {
                break;
            }
            View childAt2 = getChildAt(i5);
            if (!(childAt2.getVisibility() == 8 || childAt2 == this.mImageToggle)) {
                int measuredWidth = childAt2.getMeasuredWidth() + 0;
                int measuredHeight = i4 + childAt2.getMeasuredHeight();
                Label label = (Label) childAt2.getTag(R.id.fab_label);
                if (label != null) {
                    int measuredWidth2 = this.mMaxButtonWidth - childAt2.getMeasuredWidth();
                    if (!this.mUsingMenuLabel) {
                        i7 = 2;
                    }
                    int i8 = measuredWidth2 / i7;
                    measureChildWithMargins(label, i, childAt2.getMeasuredWidth() + label.calculateShadowWidth() + this.mLabelsMargin + i8, i2, 0);
                    i6 = Math.max(i6, measuredWidth + label.getMeasuredWidth() + i8);
                }
                i4 = measuredHeight;
            }
            i5++;
        }
        int max = Math.max(this.mMaxButtonWidth, i6 + this.mLabelsMargin) + getPaddingLeft() + getPaddingRight();
        int adjustForOvershoot = adjustForOvershoot(i4 + (this.mButtonSpacing * (this.mButtonsCount - 1)) + getPaddingTop() + getPaddingBottom());
        if (getLayoutParams().width == -1) {
            max = getDefaultSize(getSuggestedMinimumWidth(), i);
        }
        if (getLayoutParams().height == -1) {
            adjustForOvershoot = getDefaultSize(getSuggestedMinimumHeight(), i2);
        }
        setMeasuredDimension(max, adjustForOvershoot);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        if (this.mLabelsPosition == 0) {
            i5 = ((i3 - i) - (this.mMaxButtonWidth / 2)) - getPaddingRight();
        } else {
            i5 = (this.mMaxButtonWidth / 2) + getPaddingLeft();
        }
        boolean z2 = this.mOpenDirection == 0;
        if (z2) {
            i6 = ((i4 - i2) - this.mMenuButton.getMeasuredHeight()) - getPaddingBottom();
        } else {
            i6 = getPaddingTop();
        }
        int measuredWidth = i5 - (this.mMenuButton.getMeasuredWidth() / 2);
        FloatingActionButton floatingActionButton = this.mMenuButton;
        floatingActionButton.layout(measuredWidth, i6, floatingActionButton.getMeasuredWidth() + measuredWidth, this.mMenuButton.getMeasuredHeight() + i6);
        int measuredWidth2 = i5 - (this.mImageToggle.getMeasuredWidth() / 2);
        int measuredHeight = ((this.mMenuButton.getMeasuredHeight() / 2) + i6) - (this.mImageToggle.getMeasuredHeight() / 2);
        ImageView imageView = this.mImageToggle;
        imageView.layout(measuredWidth2, measuredHeight, imageView.getMeasuredWidth() + measuredWidth2, this.mImageToggle.getMeasuredHeight() + measuredHeight);
        if (z2) {
            i6 = i6 + this.mMenuButton.getMeasuredHeight() + this.mButtonSpacing;
        }
        for (int i8 = this.mButtonsCount - 1; i8 >= 0; i8--) {
            View childAt = getChildAt(i8);
            if (childAt != this.mImageToggle) {
                FloatingActionButton floatingActionButton2 = (FloatingActionButton) childAt;
                if (floatingActionButton2.getVisibility() != 8) {
                    int measuredWidth3 = i5 - (floatingActionButton2.getMeasuredWidth() / 2);
                    if (z2) {
                        i6 = (i6 - floatingActionButton2.getMeasuredHeight()) - this.mButtonSpacing;
                    }
                    if (floatingActionButton2 != this.mMenuButton) {
                        floatingActionButton2.layout(measuredWidth3, i6, floatingActionButton2.getMeasuredWidth() + measuredWidth3, floatingActionButton2.getMeasuredHeight() + i6);
                        if (!this.mIsMenuOpening) {
                            floatingActionButton2.hide(false);
                        }
                    }
                    View view = (View) floatingActionButton2.getTag(R.id.fab_label);
                    if (view != null) {
                        int measuredWidth4 = ((this.mUsingMenuLabel ? this.mMaxButtonWidth : floatingActionButton2.getMeasuredWidth()) / 2) + this.mLabelsMargin;
                        int i9 = this.mLabelsPosition == 0 ? i5 - measuredWidth4 : measuredWidth4 + i5;
                        if (this.mLabelsPosition == 0) {
                            i7 = i9 - view.getMeasuredWidth();
                        } else {
                            i7 = view.getMeasuredWidth() + i9;
                        }
                        int i10 = this.mLabelsPosition == 0 ? i7 : i9;
                        if (this.mLabelsPosition != 0) {
                            i9 = i7;
                        }
                        int measuredHeight2 = (i6 - this.mLabelsVerticalOffset) + ((floatingActionButton2.getMeasuredHeight() - view.getMeasuredHeight()) / 2);
                        view.layout(i10, measuredHeight2, i9, view.getMeasuredHeight() + measuredHeight2);
                        if (!this.mIsMenuOpening) {
                            view.setVisibility(4);
                        }
                    }
                    if (z2) {
                        i6 -= this.mButtonSpacing;
                    } else {
                        i6 = i6 + childAt.getMeasuredHeight() + this.mButtonSpacing;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.mMenuButton);
        bringChildToFront(this.mImageToggle);
        this.mButtonsCount = getChildCount();
        createLabels();
    }

    private void createLabels() {
        for (int i = 0; i < this.mButtonsCount; i++) {
            if (getChildAt(i) != this.mImageToggle) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) getChildAt(i);
                if (floatingActionButton.getTag(R.id.fab_label) == null) {
                    addLabel(floatingActionButton);
                    FloatingActionButton floatingActionButton2 = this.mMenuButton;
                    if (floatingActionButton == floatingActionButton2) {
                        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
                            /* class com.github.clans.fab.FloatingActionMenu.AnonymousClass3 */

                            public void onClick(View view) {
                                FloatingActionMenu floatingActionMenu = FloatingActionMenu.this;
                                floatingActionMenu.toggle(floatingActionMenu.mIsAnimated);
                            }
                        });
                    }
                }
            }
        }
    }

    private void addLabel(FloatingActionButton floatingActionButton) {
        CharSequence labelText = floatingActionButton.getLabelText();
        if (!TextUtils.isEmpty(labelText)) {
            Label label = new Label(this.mLabelsContext);
            label.setClickable(true);
            label.setFab(floatingActionButton);
            label.setShowAnimation(AnimationUtils.loadAnimation(getContext(), this.mLabelsShowAnimation));
            label.setHideAnimation(AnimationUtils.loadAnimation(getContext(), this.mLabelsHideAnimation));
            if (this.mLabelsStyle > 0) {
                label.setTextAppearance(getContext(), this.mLabelsStyle);
                label.setShowShadow(false);
                label.setUsingStyle(true);
            } else {
                label.setColors(this.mLabelsColorNormal, this.mLabelsColorPressed, this.mLabelsColorRipple);
                label.setShowShadow(this.mLabelsShowShadow);
                label.setCornerRadius(this.mLabelsCornerRadius);
                if (this.mLabelsEllipsize > 0) {
                    setLabelEllipsize(label);
                }
                label.setMaxLines(this.mLabelsMaxLines);
                label.updateBackground();
                label.setTextSize(0, this.mLabelsTextSize);
                label.setTextColor(this.mLabelsTextColor);
                int i = this.mLabelsPaddingLeft;
                int i2 = this.mLabelsPaddingTop;
                if (this.mLabelsShowShadow) {
                    i += floatingActionButton.getShadowRadius() + Math.abs(floatingActionButton.getShadowXOffset());
                    i2 += floatingActionButton.getShadowRadius() + Math.abs(floatingActionButton.getShadowYOffset());
                }
                label.setPadding(i, i2, this.mLabelsPaddingLeft, this.mLabelsPaddingTop);
                if (this.mLabelsMaxLines < 0 || this.mLabelsSingleLine) {
                    label.setSingleLine(this.mLabelsSingleLine);
                }
            }
            Typeface typeface = this.mCustomTypefaceFromFont;
            if (typeface != null) {
                label.setTypeface(typeface);
            }
            label.setText(labelText);
            label.setOnClickListener(floatingActionButton.getOnClickListener());
            addView(label);
            floatingActionButton.setTag(R.id.fab_label, label);
        }
    }

    private void setLabelEllipsize(Label label) {
        int i = this.mLabelsEllipsize;
        if (i == 1) {
            label.setEllipsize(TextUtils.TruncateAt.START);
        } else if (i == 2) {
            label.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else if (i == 3) {
            label.setEllipsize(TextUtils.TruncateAt.END);
        } else if (i == 4) {
            label.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.MarginLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.MarginLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    /* access modifiers changed from: private */
    public void hideMenuButtonWithImage(boolean z) {
        if (!isMenuButtonHidden()) {
            this.mMenuButton.hide(z);
            if (z) {
                this.mImageToggle.startAnimation(this.mImageToggleHideAnimation);
            }
            this.mImageToggle.setVisibility(4);
            this.mIsMenuButtonAnimationRunning = false;
        }
    }

    private void showMenuButtonWithImage(boolean z) {
        if (isMenuButtonHidden()) {
            this.mMenuButton.show(z);
            if (z) {
                this.mImageToggle.startAnimation(this.mImageToggleShowAnimation);
            }
            this.mImageToggle.setVisibility(0);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsSetClosedOnTouchOutside) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            return isOpened();
        }
        if (action != 1) {
            return false;
        }
        close(this.mIsAnimated);
        return true;
    }

    public boolean isOpened() {
        return this.mMenuOpened;
    }

    public void toggle(boolean z) {
        if (isOpened()) {
            close(z);
        } else {
            open(z);
        }
    }

    public void open(final boolean z) {
        if (!isOpened()) {
            if (isBackgroundEnabled()) {
                this.mShowBackgroundAnimator.start();
            }
            if (this.mIconAnimated) {
                AnimatorSet animatorSet = this.mIconToggleSet;
                if (animatorSet != null) {
                    animatorSet.start();
                } else {
                    this.mCloseAnimatorSet.cancel();
                    this.mOpenAnimatorSet.start();
                }
            }
            this.mIsMenuOpening = true;
            int i = 0;
            int i2 = 0;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if ((childAt instanceof FloatingActionButton) && childAt.getVisibility() != 8) {
                    i++;
                    final FloatingActionButton floatingActionButton = (FloatingActionButton) childAt;
                    this.mUiHandler.postDelayed(new Runnable() {
                        /* class com.github.clans.fab.FloatingActionMenu.AnonymousClass4 */

                        public void run() {
                            if (!FloatingActionMenu.this.isOpened()) {
                                if (floatingActionButton != FloatingActionMenu.this.mMenuButton) {
                                    floatingActionButton.show(z);
                                }
                                Label label = (Label) floatingActionButton.getTag(R.id.fab_label);
                                if (label != null && label.isHandleVisibilityChanges()) {
                                    label.show(z);
                                }
                            }
                        }
                    }, (long) i2);
                    i2 += this.mAnimationDelayPerItem;
                }
            }
            this.mUiHandler.postDelayed(new Runnable() {
                /* class com.github.clans.fab.FloatingActionMenu.AnonymousClass5 */

                public void run() {
                    boolean unused = FloatingActionMenu.this.mMenuOpened = true;
                    if (FloatingActionMenu.this.mToggleListener != null) {
                        FloatingActionMenu.this.mToggleListener.onMenuToggle(true);
                    }
                }
            }, (long) ((i + 1) * this.mAnimationDelayPerItem));
        }
    }

    public void close(final boolean z) {
        if (isOpened()) {
            if (isBackgroundEnabled()) {
                this.mHideBackgroundAnimator.start();
            }
            if (this.mIconAnimated) {
                AnimatorSet animatorSet = this.mIconToggleSet;
                if (animatorSet != null) {
                    animatorSet.start();
                } else {
                    this.mCloseAnimatorSet.start();
                    this.mOpenAnimatorSet.cancel();
                }
            }
            this.mIsMenuOpening = false;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if ((childAt instanceof FloatingActionButton) && childAt.getVisibility() != 8) {
                    i++;
                    final FloatingActionButton floatingActionButton = (FloatingActionButton) childAt;
                    this.mUiHandler.postDelayed(new Runnable() {
                        /* class com.github.clans.fab.FloatingActionMenu.AnonymousClass6 */

                        public void run() {
                            if (FloatingActionMenu.this.isOpened()) {
                                if (floatingActionButton != FloatingActionMenu.this.mMenuButton) {
                                    floatingActionButton.hide(z);
                                }
                                Label label = (Label) floatingActionButton.getTag(R.id.fab_label);
                                if (label != null && label.isHandleVisibilityChanges()) {
                                    label.hide(z);
                                }
                            }
                        }
                    }, (long) i2);
                    i2 += this.mAnimationDelayPerItem;
                }
            }
            this.mUiHandler.postDelayed(new Runnable() {
                /* class com.github.clans.fab.FloatingActionMenu.AnonymousClass7 */

                public void run() {
                    boolean unused = FloatingActionMenu.this.mMenuOpened = false;
                    if (FloatingActionMenu.this.mToggleListener != null) {
                        FloatingActionMenu.this.mToggleListener.onMenuToggle(false);
                    }
                }
            }, (long) ((i + 1) * this.mAnimationDelayPerItem));
        }
    }

    public void setIconAnimationInterpolator(Interpolator interpolator) {
        this.mOpenAnimatorSet.setInterpolator(interpolator);
        this.mCloseAnimatorSet.setInterpolator(interpolator);
    }

    public void setIconAnimationOpenInterpolator(Interpolator interpolator) {
        this.mOpenAnimatorSet.setInterpolator(interpolator);
    }

    public void setIconAnimationCloseInterpolator(Interpolator interpolator) {
        this.mCloseAnimatorSet.setInterpolator(interpolator);
    }

    public void setAnimated(boolean z) {
        this.mIsAnimated = z;
        long j = 300;
        this.mOpenAnimatorSet.setDuration(z ? 300 : 0);
        AnimatorSet animatorSet = this.mCloseAnimatorSet;
        if (!z) {
            j = 0;
        }
        animatorSet.setDuration(j);
    }

    public boolean isAnimated() {
        return this.mIsAnimated;
    }

    public void setAnimationDelayPerItem(int i) {
        this.mAnimationDelayPerItem = i;
    }

    public int getAnimationDelayPerItem() {
        return this.mAnimationDelayPerItem;
    }

    public void setOnMenuToggleListener(OnMenuToggleListener onMenuToggleListener) {
        this.mToggleListener = onMenuToggleListener;
    }

    public void setIconAnimated(boolean z) {
        this.mIconAnimated = z;
    }

    public boolean isIconAnimated() {
        return this.mIconAnimated;
    }

    public ImageView getMenuIconView() {
        return this.mImageToggle;
    }

    public void setIconToggleAnimatorSet(AnimatorSet animatorSet) {
        this.mIconToggleSet = animatorSet;
    }

    public AnimatorSet getIconToggleAnimatorSet() {
        return this.mIconToggleSet;
    }

    public void setMenuButtonShowAnimation(Animation animation) {
        this.mMenuButtonShowAnimation = animation;
        this.mMenuButton.setShowAnimation(animation);
    }

    public void setMenuButtonHideAnimation(Animation animation) {
        this.mMenuButtonHideAnimation = animation;
        this.mMenuButton.setHideAnimation(animation);
    }

    public boolean isMenuHidden() {
        return getVisibility() == 4;
    }

    public boolean isMenuButtonHidden() {
        return this.mMenuButton.isHidden();
    }

    public void showMenu(boolean z) {
        if (isMenuHidden()) {
            if (z) {
                startAnimation(this.mMenuButtonShowAnimation);
            }
            setVisibility(0);
        }
    }

    public void hideMenu(final boolean z) {
        if (!isMenuHidden() && !this.mIsMenuButtonAnimationRunning) {
            this.mIsMenuButtonAnimationRunning = true;
            if (isOpened()) {
                close(z);
                this.mUiHandler.postDelayed(new Runnable() {
                    /* class com.github.clans.fab.FloatingActionMenu.AnonymousClass8 */

                    public void run() {
                        if (z) {
                            FloatingActionMenu floatingActionMenu = FloatingActionMenu.this;
                            floatingActionMenu.startAnimation(floatingActionMenu.mMenuButtonHideAnimation);
                        }
                        FloatingActionMenu.this.setVisibility(4);
                        boolean unused = FloatingActionMenu.this.mIsMenuButtonAnimationRunning = false;
                    }
                }, (long) (this.mAnimationDelayPerItem * this.mButtonsCount));
                return;
            }
            if (z) {
                startAnimation(this.mMenuButtonHideAnimation);
            }
            setVisibility(4);
            this.mIsMenuButtonAnimationRunning = false;
        }
    }

    public void toggleMenu(boolean z) {
        if (isMenuHidden()) {
            showMenu(z);
        } else {
            hideMenu(z);
        }
    }

    public void showMenuButton(boolean z) {
        if (isMenuButtonHidden()) {
            showMenuButtonWithImage(z);
        }
    }

    public void hideMenuButton(final boolean z) {
        if (!isMenuButtonHidden() && !this.mIsMenuButtonAnimationRunning) {
            this.mIsMenuButtonAnimationRunning = true;
            if (isOpened()) {
                close(z);
                this.mUiHandler.postDelayed(new Runnable() {
                    /* class com.github.clans.fab.FloatingActionMenu.AnonymousClass9 */

                    public void run() {
                        FloatingActionMenu.this.hideMenuButtonWithImage(z);
                    }
                }, (long) (this.mAnimationDelayPerItem * this.mButtonsCount));
                return;
            }
            hideMenuButtonWithImage(z);
        }
    }

    public void toggleMenuButton(boolean z) {
        if (isMenuButtonHidden()) {
            showMenuButton(z);
        } else {
            hideMenuButton(z);
        }
    }

    public void setClosedOnTouchOutside(boolean z) {
        this.mIsSetClosedOnTouchOutside = z;
    }

    public void setMenuButtonColorNormal(int i) {
        this.mMenuColorNormal = i;
        this.mMenuButton.setColorNormal(i);
    }

    public void setMenuButtonColorNormalResId(int i) {
        this.mMenuColorNormal = getResources().getColor(i);
        this.mMenuButton.setColorNormalResId(i);
    }

    public int getMenuButtonColorNormal() {
        return this.mMenuColorNormal;
    }

    public void setMenuButtonColorPressed(int i) {
        this.mMenuColorPressed = i;
        this.mMenuButton.setColorPressed(i);
    }

    public void setMenuButtonColorPressedResId(int i) {
        this.mMenuColorPressed = getResources().getColor(i);
        this.mMenuButton.setColorPressedResId(i);
    }

    public int getMenuButtonColorPressed() {
        return this.mMenuColorPressed;
    }

    public void setMenuButtonColorRipple(int i) {
        this.mMenuColorRipple = i;
        this.mMenuButton.setColorRipple(i);
    }

    public void setMenuButtonColorRippleResId(int i) {
        this.mMenuColorRipple = getResources().getColor(i);
        this.mMenuButton.setColorRippleResId(i);
    }

    public int getMenuButtonColorRipple() {
        return this.mMenuColorRipple;
    }

    public void addMenuButton(FloatingActionButton floatingActionButton) {
        addView(floatingActionButton, this.mButtonsCount - 2);
        this.mButtonsCount++;
        addLabel(floatingActionButton);
    }

    public void removeMenuButton(FloatingActionButton floatingActionButton) {
        removeView(floatingActionButton.getLabelView());
        removeView(floatingActionButton);
        this.mButtonsCount--;
    }

    public void addMenuButton(FloatingActionButton floatingActionButton, int i) {
        int i2 = this.mButtonsCount - 2;
        if (i < 0) {
            i = 0;
        } else if (i > i2) {
            i = i2;
        }
        addView(floatingActionButton, i);
        this.mButtonsCount++;
        addLabel(floatingActionButton);
    }

    public void removeAllMenuButtons() {
        close(true);
        ArrayList<FloatingActionButton> arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt == this.mMenuButton || childAt == this.mImageToggle || !(childAt instanceof FloatingActionButton))) {
                arrayList.add((FloatingActionButton) childAt);
            }
        }
        for (FloatingActionButton floatingActionButton : arrayList) {
            removeMenuButton(floatingActionButton);
        }
    }

    public void setMenuButtonLabelText(String str) {
        this.mMenuButton.setLabelText(str);
    }

    public String getMenuButtonLabelText() {
        return this.mMenuLabelText;
    }

    public void setOnMenuButtonClickListener(View.OnClickListener onClickListener) {
        this.mMenuButton.setOnClickListener(onClickListener);
    }

    public void setOnMenuButtonLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mMenuButton.setOnLongClickListener(onLongClickListener);
    }
}
