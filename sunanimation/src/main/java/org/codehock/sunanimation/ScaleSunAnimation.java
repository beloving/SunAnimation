package org.codehock.sunanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * source from : screencut/animation2.gif
 * Created by 刚 on 2016/7/4.
 */
public class ScaleSunAnimation extends View {

    private Paint mGrasslandPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mSkyCloudPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mSkySunPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mSkySunFrontPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private RectF mSkyCloundRectF = new RectF();
    private RectF mSkyMiniCloundRectF = new RectF();
    private float mSkyWidth, mSkyHeight;
    private float mSkyMiniWidth, mSkyMiniHeight;

    private float mSunCx, mSunCy, mSunRadius;
    private float mGridHeight;

    private float mGridLeft;
    private float mGridTop;

    private float mPathWidth;


    public ScaleSunAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);

        mSkyCloudPaint.setColor(Color.WHITE);
        mSkyCloudPaint.setStyle(Paint.Style.FILL);

        mSkySunPaint.setColor(Color.parseColor("#33FFFFFF"));
        mSkySunPaint.setStyle(Paint.Style.FILL);

        mSkySunFrontPaint.setColor(Color.parseColor("#FCC542"));
        mSkySunFrontPaint.setStyle(Paint.Style.STROKE);
        mSkySunFrontPaint.setStrokeWidth(30);

        mSkyWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 66,
                context.getResources().getDisplayMetrics());
        mSkyHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25,
                context.getResources().getDisplayMetrics());

        mSkyMiniWidth = mSkyWidth / 3 * 2;
        mSkyMiniHeight = mSkyHeight / 3 * 2;

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mSunCx = getWidth() / 2;
        mSunCy = getHeight() / 3;

        mGridHeight = getHeight() / 3 / 4;

        mGridLeft = 0;
        mGridTop = getHeight() / 3 * 2;

        mPathWidth = getWidth() / 4;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*-绘制天空背景颜色-*/
        canvas.drawColor(Color.parseColor("#5983FD"));

        canvas.save();

        /*-绘制草地绘制单元格-*/
        drawGrasslandGrid(canvas);

        /*-绘制地面草地颜色-*/
        drawGrassland(canvas);

        /*-绘制天空的白云-*/
        drawSkyClouds(canvas);

        /*-绘制太阳-*/
        drawSkySun(canvas);

        /*-绘制太阳的倒影-*/
        drawSunMirror(canvas);
    }

    private void drawGrasslandGrid(Canvas canvas) {

    }

    /**
     * 绘制太阳到地面的倒影
     *
     * @param canvas
     */
    private void drawSunMirror(Canvas canvas) {

    }

    /**
     * 绘制天空中的太阳
     *
     * @param canvas
     */
    private void drawSkySun(Canvas canvas) {
        canvas.save();
        mSunRadius = getWidth() / 5;
        canvas.drawCircle(mSunCx, mSunCy, mSunRadius, mSkySunPaint);

//        Path path = new Path();

//        float width = mSunCx / 3;
//        path.moveTo(mSunCx - width, mSunCy + 180);
//        path.quadTo(mSunCx + width, mSunCy - 180, mSunCx + width * 2, mSunCy);
//        path.quadTo(mSunCx + width * 3, mSunCy + 180, mSunCx + width * 4, mSunCy);
//        canvas.drawPath(path, mSkySunFrontPaint);
    }

    /**
     * 绘制天空的白云
     *
     * @param canvas
     */
    private void drawSkyClouds(Canvas canvas) {
        canvas.save();
        mSkyCloundRectF.left = getWidth() / 4 - mSkyWidth / 2;
        mSkyCloundRectF.top = getHeight() / 6;
        mSkyCloundRectF.right = getWidth() / 4 + mSkyWidth / 2;
        mSkyCloundRectF.bottom = getHeight() / 6 + mSkyHeight;

        canvas.drawRoundRect(mSkyCloundRectF, mSkyHeight / 2, mSkyHeight / 2, mSkyCloudPaint);

        mSkyMiniCloundRectF.left = getWidth() / 4 - mSkyMiniWidth / 2;
        mSkyMiniCloundRectF.top = getHeight() / 6 - mSkyMiniHeight / 2;
        mSkyMiniCloundRectF.right = getWidth() / 4 + mSkyMiniWidth / 2;
        mSkyMiniCloundRectF.bottom = getHeight() / 6 + mSkyMiniHeight;

        canvas.drawRoundRect(mSkyMiniCloundRectF, mSkyMiniHeight / 2, mSkyMiniHeight / 2, mSkyCloudPaint);


        mSkyCloundRectF.left = getWidth() / 4 * 3 - mSkyWidth / 2;
        mSkyCloundRectF.top = getHeight() / 6;
        mSkyCloundRectF.right = getWidth() / 4 * 3 + mSkyWidth / 2;
        mSkyCloundRectF.bottom = getHeight() / 6 + mSkyHeight;

        canvas.drawRoundRect(mSkyCloundRectF, mSkyHeight / 2, mSkyHeight / 2, mSkyCloudPaint);

        mSkyMiniCloundRectF.left = getWidth() / 4 * 3 - mSkyMiniWidth / 2;
        mSkyMiniCloundRectF.top = getHeight() / 6 - mSkyMiniHeight / 2;
        mSkyMiniCloundRectF.right = getWidth() / 4 * 3 + mSkyMiniWidth / 2;
        mSkyMiniCloundRectF.bottom = getHeight() / 6 + mSkyMiniHeight;

        canvas.drawRoundRect(mSkyMiniCloundRectF, mSkyMiniHeight / 2, mSkyMiniHeight / 2, mSkyCloudPaint);
    }

    /**
     * 绘制草地
     *
     * @param canvas
     */
    private void drawGrassland(Canvas canvas) {

//        mGrasslandPaint.setColor(Color.parseColor("#ff0000"));
//        mGrasslandPaint.setStrokeWidth(29);
//        mGrasslandPaint.setStyle(Paint.Style.STROKE);
//        Path path = new Path();
//        path.moveTo(80, 80);
//        path.quadTo(120, 120, 140, 66);
//        path.quadTo(160, 20, 200, 66);
//        canvas.drawPath(path, mGrasslandPaint);
    }
}
