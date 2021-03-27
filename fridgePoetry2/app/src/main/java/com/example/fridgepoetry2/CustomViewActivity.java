package com.example.fridgepoetry2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        // Get the root Linearlayout object.
        LinearLayout rootLayout = (LinearLayout)findViewById(R.id.idDrawMagnetView);

        // Create the DrawMagnetView custom view object.
        final DrawMagnetView drawMagnetView = new DrawMagnetView(this);

        // Set min width and height.
        drawMagnetView.setMinimumWidth(500);
        drawMagnetView.setMinimumHeight(800);

        // Create an onclick listener object for the clear button
        ImageButton clear = (ImageButton)findViewById(R.id.clearButton);
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                drawMagnetView.initializeLocations();
                drawMagnetView.invalidate();
            }
        });

        // Create an ontouch listener object.
        View.OnTouchListener onTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                    // Set the values currX and currY for the drawMagnetView object to the location that the user touched
                    drawMagnetView.setCurrX(motionEvent.getX());
                    drawMagnetView.setCurrY(motionEvent.getY());

                    // Notify drawMagnetView to redraw. This will invoke DrawMagnetView's onDraw() method.
                    drawMagnetView.invalidate();

                    // Return true means this listener has complete process this event successfully.
                return true;
            }
        };

        // Register onTouchListener object to drawMagnetView.
        drawMagnetView.setOnTouchListener(onTouchListener);

        // Add drawMagnetView object in root LinearLayout object.
        rootLayout.addView(drawMagnetView);
    }
}