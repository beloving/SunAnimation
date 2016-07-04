package org.codehock.sunanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * source from : screencut/animation2.gif
 * Created by 刚 on 2016/7/4.
 */
public class ScaleSunAnimation extends View {

    private Paint mGrasslandPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


    public ScaleSunAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*-绘制天空背景颜色-*/
        canvas.drawColor(Color.parseColor("#5983FD"));

        canvas.save();

        /*-绘制地面草地颜色-*/
        drawGrassland(canvas);

        /*-绘制天空的白云-*/
        drawSkyClouds(canvas);

        /*-绘制太阳-*/
        drawSkySun(canvas);

        /*-绘制太阳的倒影-*/
        drawSunMirror(canvas);
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

    }

    /**
     * 绘制天空的白云
     *
     * @param canvas
     */
    private void drawSkyClouds(Canvas canvas) {

    }

    /**
     * 绘制草地
     *
     * @param canvas
     */
    private void drawGrassland(Canvas canvas) {

        mGrasslandPaint.setColor(Color.parseColor("#ff0000"));
        mGrasslandPaint.setStrokeWidth(29);
        mGrasslandPaint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(80, 80);
        path.quadTo(120, 120, 140, 66);
        path.quadTo(160, 20, 200, 66);
        canvas.drawPath(path, mGrasslandPaint);
    }
}
