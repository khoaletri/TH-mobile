package com.example.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends View {
    private Bitmap[] frames = new Bitmap[3]; // Array to hold 3 frames
    private int currentFrameIndex = 0; // Index to track the current frame
    private int frameWidth = 800; // Desired width of the frame
    private int frameHeight = 800; // Desired height of the frame

    public GraphicsView(Context context) {
        super(context);

        // Initialize and scale each bitmap frame from resources
        frames[0] = BitmapFactory.decodeResource(getResources(), R.drawable.win_1);
        frames[1] = BitmapFactory.decodeResource(getResources(), R.drawable.win_2);
        frames[2] = BitmapFactory.decodeResource(getResources(), R.drawable.win_3);

        for (int i = 0; i < frames.length; i++) {
            frames[i] = Bitmap.createScaledBitmap(frames[i], frameWidth, frameHeight, true);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw the current frame bitmap
        canvas.drawBitmap(frames[currentFrameIndex], 40, 40, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Increment the index for the next frame on touch
        currentFrameIndex = (currentFrameIndex + 1) % frames.length;

        // Redraw the view with the updated frame
        invalidate();

        // Indicate that the touch event has been handled
        return true;
    }
}
