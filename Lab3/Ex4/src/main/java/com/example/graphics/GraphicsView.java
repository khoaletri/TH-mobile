package com.example.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends View {
    private Bitmap[] frames = new Bitmap[3]; // Array to hold 3 frames
    private int currentFrameIndex = 0; // Index to track the current frame
    private int frameWidth = 800; // Desired width of the frame
    private int frameHeight = 800; // Desired height of the frame
    private long period = 500; // Period in milliseconds (slower animation)
    private boolean isPlaying = false; // Track if the animation and music are playing

    private MediaPlayer mPlayer;
    private Handler handler;
    private Bitmap playIcon, pauseIcon;
    private int iconWidth = 100; // Desired width of the icon
    private int iconHeight = 100; // Desired height of the icon

    public GraphicsView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        // Load and scale each bitmap frame from resources
        frames[0] = BitmapFactory.decodeResource(getResources(), R.drawable.win_1);
        frames[1] = BitmapFactory.decodeResource(getResources(), R.drawable.win_2);
        frames[2] = BitmapFactory.decodeResource(getResources(), R.drawable.win_3);

        for (int i = 0; i < frames.length; i++) {
            frames[i] = Bitmap.createScaledBitmap(frames[i], frameWidth, frameHeight, true);
        }

        // Load play and pause icons
        Bitmap playIconSrc = BitmapFactory.decodeResource(getResources(), R.drawable.play_icon);
        Bitmap pauseIconSrc = BitmapFactory.decodeResource(getResources(), R.drawable.pause_icon);

        // Scale play and pause icons
        playIcon = Bitmap.createScaledBitmap(playIconSrc, iconWidth, iconHeight, true);
        pauseIcon = Bitmap.createScaledBitmap(pauseIconSrc, iconWidth, iconHeight, true);

        // Initialize MediaPlayer
        mPlayer = MediaPlayer.create(context, R.raw.pursuit); // Replace with your actual sound file

        // Initialize Handler for animation
        handler = new Handler();
    }

    private void startAnimation() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isPlaying) {
                    // Update the frame index
                    currentFrameIndex = (currentFrameIndex + 1) % frames.length;
                    // Invalidate the view to trigger onDraw
                    invalidate();
                    // Continue the animation
                    handler.postDelayed(this, period);
                }
            }
        }, period);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw the current frame bitmap
        canvas.drawBitmap(frames[currentFrameIndex], 40, 40, null);

        // Calculate position for play/pause button (middle bottom)
        int buttonX = (getWidth() - iconWidth) / 2;
        int buttonY = getHeight() - iconHeight - 40;

        // Draw play/pause button
        Bitmap buttonIcon = isPlaying ? pauseIcon : playIcon;
        canvas.drawBitmap(buttonIcon, buttonX, buttonY, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Calculate position for play/pause button (middle bottom)
        int buttonX = (getWidth() - iconWidth) / 2;
        int buttonY = getHeight() - iconHeight - 40;

        // Check if the touch event is within the play/pause button area
        float x = event.getX();
        float y = event.getY();

        if (x >= buttonX && x <= buttonX + iconWidth &&
                y >= buttonY && y <= buttonY + iconHeight) {
            // Toggle play/pause state
            isPlaying = !isPlaying;
            if (isPlaying) {
                // Start animation and music
                startAnimation();
                if (mPlayer != null && !mPlayer.isPlaying()) {
                    mPlayer.start();
                }
            } else {
                // Pause music
                if (mPlayer != null && mPlayer.isPlaying()) {
                    mPlayer.pause();
                }
                // Stop animation
                handler.removeCallbacksAndMessages(null);
            }
            // Redraw the view to update the play/pause icon
            invalidate();
            return true;
        }

        return super.onTouchEvent(event);
    }
}
