package com.example.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends View {
    private int x = 0;
    private int y = 0;
    private int width = 200; // Initial width of the rectangle
    private int height = 100; // Initial height of the rectangle

    public GraphicsView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw a rectangle only if x and y are not zero (i.e., touch event has occurred)
        if (x != 0 && y != 0) {
            int right = x + width;
            int bottom = y + height;
            Rect rect = new Rect(x, y, right, bottom);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.RED);
            canvas.drawRect(rect, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Get the coordinates of the touch event
        x = (int) event.getX();
        y = (int) event.getY();

        // Redraw the view with the new coordinates
        invalidate();

        // Indicate that the touch event has been handled
        return true;
    }
}
