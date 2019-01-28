package com.tahirietrit.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class CustomImageView extends android.support.v7.widget.AppCompatImageView implements
        View.OnTouchListener {

    Paint paint;
    int width;
    int height;
    float centerY;
    float centerX;
    float blockWidth;
    float blockHeight;
    boolean isInitialized = false;
    ArrayList<Float> dataSet = new ArrayList<>();

    public void setDataSet(ArrayList<Float> dataSet) {
        this.dataSet = dataSet;
        invalidate();
    }

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInitialized) {
            isInitialized = true;
            setOnTouchListener(this);
            width = getWidth();
            height = getHeight();
            centerX = width / 2;
            centerY = height / 2;
            blockHeight = centerY;

        }
        try {
            blockWidth = (width - ((dataSet.size() - 2) * 10)) / dataSet.size();
        } catch (Exception e) {
            blockWidth = width / 1;
        }
        paint = new Paint();
        paint.setColor(Color.MAGENTA);
        paint.setAntiAlias(true);

        for (int i = 0; i < dataSet.size(); i++) {
            canvas.drawRect(i * (blockWidth + 10),
                    (centerY - (blockHeight * (dataSet.get(i) / 100))),
                    (i * (blockWidth + 10)) + blockWidth,
                    (centerY + (blockHeight * (dataSet.get(i) / 100))),
                    paint);


            canvas.drawCircle((i * (blockWidth + 10) + blockWidth / 2),
                    ((centerY - (blockHeight * (dataSet.get(i) / 100)) - (blockWidth / 2))),
                    blockWidth / 2,
                    paint);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                centerY = event.getY();
                centerX = event.getX();
                invalidate();
            }
            break;
            case MotionEvent.ACTION_MOVE: {
                centerY = event.getY();
                centerX = event.getX();
                invalidate();
            }
            break;
            case MotionEvent.ACTION_UP: {
                centerY = height / 2;
                centerX = width / 2;
                invalidate();
            }
            break;
        }
        return true;
    }
}
