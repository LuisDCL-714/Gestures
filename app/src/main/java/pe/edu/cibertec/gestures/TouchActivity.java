package pe.edu.cibertec.gestures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class TouchActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private static final String TOUCH_LOG = "Touch_activity";
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        gestureDetector = new GestureDetector(this, this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(gestureDetector.onTouchEvent(event)){
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.i(TOUCH_LOG, "Down. "+e.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.i(TOUCH_LOG, "Show Press. "+e.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i(TOUCH_LOG, "Single Tap Up. "+e.toString());
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i(TOUCH_LOG, "Scroll. "+e1.toString()+". "+e2.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.i(TOUCH_LOG, "Long Press. "+e.toString());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i(TOUCH_LOG, "Fling. "+e1.toString()+". "+e2.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.i(TOUCH_LOG, "Single Tap Confirmed. "+e.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.i(TOUCH_LOG, "Double Tap. "+e.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.i(TOUCH_LOG, "Double Tap Event. "+e.toString());
        return true;
    }
}
