package com.example.fridgepoetry2;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        // Get the root Linearlayout object.
        LinearLayout rootLayout = (LinearLayout)findViewById(R.id.idDrawBallView);

        // Create the DrawBallView custom view object.
        final DrawMagnetView drawMagnetView = new DrawMagnetView(this);

        //set min width and height.
        drawMagnetView.setMinimumWidth(500);
        drawMagnetView.setMinimumHeight(800);

        // Create a ontouch listener object.
        View.OnTouchListener onTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                // Set drawBallView currX and currY value to user finger x y ordinate value..
                drawMagnetView.setCurrX(motionEvent.getX());
                drawMagnetView.setCurrY(motionEvent.getY());

                // Set ball color to blue.
                drawMagnetView.setBallColor(Color.BLUE);

                // Notify drawBallView to redraw. This will invoke DrawBallView's onDraw() method.
                drawMagnetView.invalidate();

                // Return true means this listener has complete process this event successfully.
                return true;
            }
        };

        // Register onTouchListener object to drawBallView.
        drawMagnetView.setOnTouchListener(onTouchListener);

        // Add drawBallView object in root LinearLayout object.
        rootLayout.addView(drawMagnetView);
    }
}