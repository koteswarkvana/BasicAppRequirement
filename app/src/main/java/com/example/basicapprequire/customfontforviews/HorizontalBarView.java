package com.example.basicapprequire.customfontforviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public final class HorizontalBarView extends View {

    private final Paint mPaint = new Paint();
    private int percent = 0;

    public HorizontalBarView(Context context) {
        super(context);
        init();
    }

    public HorizontalBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HorizontalBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public void set(int color, int percent) {

        if(percent < 0 || percent > 200) {
            throw new IllegalArgumentException("Percent value must range from 0 to 200");
        }

        mPaint.setColor(color);
        this.percent = percent;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final float width = MeasureSpec.getSize(widthMeasureSpec);
        final float adjWidth = (width*((float)percent/200));
        setMeasuredDimension((int)adjWidth, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
    }

}