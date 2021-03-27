package com.example.fridgepoetry2;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.example.fridgepoetry2.R;

public class DrawMagnetView extends View {

    // Record current ball horizontal ordinate.
    private float currX = 100;

    // Record current ball vertical ordinate
    private float currY = 100;

    private final Bitmap[] bitmaps = {BitmapFactory.decodeResource(getResources(),R.drawable.live), BitmapFactory.decodeResource(getResources(),R.drawable.laugh), BitmapFactory.decodeResource(getResources(),R.drawable.above),BitmapFactory.decodeResource(getResources(),R.drawable.love), BitmapFactory.decodeResource(getResources(),R.drawable.ache), BitmapFactory.decodeResource(getResources(),R.drawable.again)};

    private final float[][] locations = new float[bitmaps.length][2];

    private Paint paint = new Paint();

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

    public void initializeLocations(){

        for (int i = 0; i < bitmaps.length; i++){
            locations[i][0] = (float)Math.random()*1000;
            locations[i][1] = (float)Math.random()*1000;
        }
    }

    // DrawMagnetView constructor.
    public DrawMagnetView(Context context) {
        super(context);
        initializeLocations();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        boolean moved = false;

        for (int i = 0; i<bitmaps.length; i++){
            if(locations[i][0]< currX +100 && locations[i][1]<currY+100 && locations[i][0] > currX - 100 && locations[i][1] > currY - 100 && !moved){
                canvas.drawBitmap(bitmaps[i], currX, currY, paint);
                locations[i][0]= currX;
                locations[i][1]= currY;
                moved = true;
            }

            else {
                canvas.drawBitmap(bitmaps[i], locations[i][0], locations[i][1], paint);
            }
        }
    }
}
