package org.codehock.sunanimation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 刚 on 2016/7/3.
 */
public class SunAnimation extends View {

    private int mSunBackgroundColor;
    private int mSunFaceColor;
    private int mSunEyeColor;
    private int mMouthColor;

    private Paint mFaceClipPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mFacePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mEyePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mMouthPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mAuthorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


    private float mRadius;

    public SunAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);

        initializeDefaultValue(context);

        initializeCustomParams(context, attrs);

        initializePaint();

        AutoStartAnimation();
    }

    private void AutoStartAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 15, 0, -15);
        animator.setDuration(1000);
        animator.setRepeatCount(-1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mRadius = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }

    private void initializePaint() {
        mFaceClipPaint.setColor(Color.WHITE);
        mFaceClipPaint.setStyle(Paint.Style.FILL);

        mBackgroundPaint.setColor(mSunBackgroundColor);
        mBackgroundPaint.setStyle(Paint.Style.FILL);

        mFacePaint.setColor(mSunFaceColor);
        mFacePaint.setStyle(Paint.Style.FILL);

        mEyePaint.setColor(mSunEyeColor);
        mEyePaint.setStyle(Paint.Style.FILL);

        mMouthPaint.setColor(mMouthColor);

        mAuthorPaint.setColor(Color.parseColor("#EE7600"));
        mAuthorPaint.setTextSize(25);


    }

    /**
     * 绘制自定义的参数
     *
     * @param context
     * @param attrs
     */
    private void initializeCustomParams(Context context, AttributeSet attrs) {

    }

    /**
     * 绘制默认的参数值
     *
     * @param context
     */
    private void initializeDefaultValue(Context context) {
        mSunBackgroundColor = Color.parseColor("#FFB90F");
        mSunFaceColor = Color.parseColor("#11000000");
        mSunEyeColor = Color.parseColor("#000000");
        mMouthColor = Color.parseColor("#E9967A");
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);
        canvas.save();

        canvas.rotate(mRadius, getWidth() / 2, getHeight() / 2);

        /*-绘制太阳的整体背景-*/
        drawSunBackground(canvas);

        /*-裁剪太阳边框-*/
        drawSunClipCircle(canvas);

        /*-绘制太阳的脸-*/
        drawSunFace(canvas);

        /*-绘制太阳的眼睛、嘴巴-*/
        drawSunEyeAndOther(canvas);

        /*-绘制署名信息-*/
        drawAuthor(canvas);
    }

    /**
     * 绘制署名信息
     *
     * @param canvas
     */
    private void drawAuthor(Canvas canvas) {
        canvas.drawText("create by kima.wang \n on 2016/07/03", 30, 30, mAuthorPaint);
    }

    /**
     * 绘制太阳的整体背景
     *
     * @param canvas
     */
    private void drawSunBackground(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getHeight() / 2, mBackgroundPaint);
    }

    /**
     * 绘制太阳的边上的阳光
     *
     * @param canvas
     */
    private void drawSunClipCircle(Canvas canvas) {
        canvas.save();

        for (int i = 0; i < 9; i++) {
            canvas.rotate(40, getWidth() / 2, getHeight() / 2);
            canvas.drawCircle(getWidth() / 2, 0, getWidth() / 6, mFaceClipPaint);
        }

        canvas.restore();
    }

    /**
     * 绘制太阳的脸
     *
     * @param canvas
     */
    private void drawSunFace(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 3.5f, mFacePaint);
    }

    /**
     * 绘制太阳的嘴巴、眼睛、以及其他
     *
     * @param canvas
     */
    private void drawSunEyeAndOther(Canvas canvas) {

        //绘制左眼睛
        canvas.drawCircle(getWidth() / 2 - getWidth() / 10, getHeight() / 2 - getHeight() / 12, 23, mEyePaint);

        //绘制右眼睛
        canvas.drawCircle(getWidth() / 2 + getWidth() / 10, getHeight() / 2 - getHeight() / 12, 23, mEyePaint);

        //绘制嘴巴
        Path path = new Path();
        path.moveTo(getWidth() / 2, getHeight() / 2);
        canvas.drawPath(path, mMouthPaint);
    }
}
