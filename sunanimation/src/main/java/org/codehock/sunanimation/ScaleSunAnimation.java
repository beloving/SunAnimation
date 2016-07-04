package org.codehock.sunanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

/**
 * source from : screencut/animation2.gif
 * Created by 刚 on 2016/7/4.
 */
public class ScaleSunAnimation extends View {

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

        canvas.drawColor(Color.parseColor("#4F94CD"));
    }
}
