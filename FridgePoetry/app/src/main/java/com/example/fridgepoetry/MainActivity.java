package com.example.fridgepoetry;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MotionEventCompat;

import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import static android.view.MotionEvent.INVALID_POINTER_ID;

public class MainActivity extends AppCompatActivity implements View.OnDragListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.addMagnets);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onDrag (View v, DragEvent event){
        return true;
    }

    private static final String IMAGEVIEW_TAG = "icon bitmap";

    ImageView imageView = new ImageView(this);

    imageView.setimageBitMap(iconBitmap);

    /*private int mActivePointerId = INVALID_POINTER_ID;

    @Override
    public boolean onTouchEvent(MotionEvent ev){
        mScaleDetector.onTouchEvent(ev);
        final int action = MotionEventCompat.getActionMasked(ev);

        switch(action){
            case MotionEvent.ACTION_DOWN: {
                final int pointerIndex = MotionEventCompat.getActionIndex(ev);
                final float x = MotionEventCompat.getX(ev, pointerIndex);
                final float y = MotionEventCompat.getY(ev, pointerIndex);

                mLastTouchX = x;
                mLastTouchY = y;

                mActivePointerId = MotionEventCompat.getPointerId(ev,0);
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                final int pointerIndex = MotionEventCompat.findPointerIndex(ev,mActivePointerId);
                final float x = MotionEventCompat.getX(ev, pointerIndex);
                final float y = MotionEventCompat.getY(ev, pointerIndex);
                final float dx = x - mLastTouchX;
                final float dy = y - mLastTouchY;

                mPosx += dx;
                mPosy += dy;

                invalidate();

                mLastTouchX = x;
                mLastTouchY = y;

                break;
            }

            case MotionEvent.ACTION_UP: {
                mActivePointerId = INVALID_POINTER_ID;
                break;
            }

            case MotionEvent.ACTION_CANCEL: {
                mActivePointerId = INVALID_POINTER_ID;
                break;
            }

            case MotionEvent.ACTION_POINTER_UP: {
                final int pointerIndex = MotionEventCompat.getActionIndex(ev);
                final int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);

                if(pointerId == mActivePOinterId) {
                    final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                    mLastTouchX = MotionEventCompat.getX(ev, newPointerIndex);
                    mLastTouchY = MotionEventCompat.getY(ev, newPointerIndex);
                    mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
                }
            }
        }
        return true;
    }*/
}