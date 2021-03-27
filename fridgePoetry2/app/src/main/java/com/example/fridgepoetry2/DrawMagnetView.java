package com.example.fridgepoetry2;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import com.example.fridgepoetry2.R;

public class DrawMagnetView extends View {

    // Record current ball horizontal ordinate.
    private float currX = 100;

    // Record current ball vertical ordinate
    private float currY = 100;

    // This is the ball color.
    private int ballColor = Color.GREEN;

    public int getBallColor() {
        return ballColor;
    }

    public void setBallColor(int ballColor) {
        this.ballColor = ballColor;
    }

    // getter and setter method for currX and currY.
    public float getCurrX() {
        return currX;
    }

    public float getCurrY() {
        return currY;
    }

    public void setCurrX(float currX) {
        this.currX = currX;
    }

    public void setCurrY(float currY) {
        this.currY = currY;
    }

    // DrawBallView constructor.
    public DrawMagnetView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Create a new Paint object.
        Paint paint = new Paint();

        Bitmap word = BitmapFactory.decodeResource(getResources(),R.drawable.a);

        // Set paint color.
        paint.setColor(this.getBallColor());

        // Draw a circle in the canvas.
        canvas.drawBitmap(word,currX,currY,paint);
    }
}
