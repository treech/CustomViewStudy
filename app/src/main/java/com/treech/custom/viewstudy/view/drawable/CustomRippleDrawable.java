package com.treech.custom.viewstudy.view.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomRippleDrawable extends Drawable {

    private static final int STATE_IDLE = 0;
    private static final int STATE_ENTER = 1;
    private static final int STATE_EXIT = 2;

    private final int MAX_PROGRESS = 100;
    private long ANIMATION_TIME = 300;

    private final Paint mPaint;
    private PointF mPressedPointF;
    private PointF mCurrentPointF;
    private int mProgress = 0;
    private int mState = STATE_IDLE;
    private boolean mPendingExit;
    private float mMaxRadius;
    private ValueAnimator mRunningAnimator;
    private final int mRealAlpha;

    public CustomRippleDrawable() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#33000000"));
        mRealAlpha = mPaint.getAlpha();

        mPressedPointF = new PointF();
        mCurrentPointF = new PointF();
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        if (mState == STATE_ENTER) {
            if (mPaint.getAlpha() != mRealAlpha) {
                mPaint.setAlpha(mRealAlpha);
            }
            canvas.drawCircle(mPressedPointF.x, mPressedPointF.y, mMaxRadius * mProgress / MAX_PROGRESS, mPaint);
        } else if (mState == STATE_EXIT) {
            mPaint.setAlpha(mRealAlpha * mProgress / MAX_PROGRESS);
            canvas.drawRect(getBounds(), mPaint);
        }
    }

    @Override
    protected boolean onStateChange(int[] stateSet) {
        boolean enable = false;
        boolean pressed = false;

        for (int state : stateSet) {
            switch (state) {
                case android.R.attr.state_pressed:
                    pressed = true;
                    break;
                case android.R.attr.state_enabled:
                    enable = true;
                    break;
            }
        }

        if (!enable) return false;

        if (pressed) {
            enter();
            return true;
        } else if (mState == STATE_ENTER) {
            exit();
            return true;
        } else {
            return false;
        }
    }

    private void exit() {
        if (mProgress != MAX_PROGRESS && mState == STATE_ENTER) {
            mPendingExit = true;
        } else {
            mState = STATE_EXIT;
            startExitAnimation();
        }
    }

    private void startExitAnimation() {
        if (mRunningAnimator != null && mRunningAnimator.isRunning()) {
            mRunningAnimator.cancel();
        }

        mRunningAnimator = ValueAnimator.ofInt(mProgress, 0);
        mRunningAnimator.setInterpolator(new LinearInterpolator());
        mRunningAnimator.setDuration(ANIMATION_TIME);
        mRunningAnimator.addUpdateListener(animation -> {
            mProgress = (int) animation.getAnimatedValue();
            invalidateSelf();
        });
        mRunningAnimator.start();
    }

    private void enter() {
        mState = STATE_ENTER;
        mProgress = 0;
        mPressedPointF.set(mCurrentPointF);
        Rect bounds = getBounds();
        mMaxRadius = Math.max(bounds.width(), bounds.height());
        startEnterAnimation();
    }

    private void startEnterAnimation() {
        mRunningAnimator = ValueAnimator.ofInt(mProgress, MAX_PROGRESS);
        mRunningAnimator.setInterpolator(new LinearInterpolator());
        mRunningAnimator.setDuration(ANIMATION_TIME);
        mRunningAnimator.addUpdateListener(animation -> {
            mProgress = (int) animation.getAnimatedValue();
            invalidateSelf();
        });
        mRunningAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (mPendingExit) {
                    mPendingExit = false;
                    mState = STATE_EXIT;
                    startExitAnimation();
                }
            }
        });
        mRunningAnimator.start();
    }

    @Override
    public void setHotspot(float x, float y) {
        mCurrentPointF.set(x, y);
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSPARENT;
    }
}
