package pe.edu.cibertec.gestures;

import android.content.Context;
import android.graphics.Matrix;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public class ScallImageView extends AppCompatImageView{

    private GestureDetectorCompat gestureDetectorCompat;
    private ScaleGestureDetector scaleGestureDetector;
    private static Float sclaeFactor = 1f;
    private Matrix matrix;

    public ScallImageView(Context context){
        super(context);
        init();
    }

    public ScallImageView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public ScallImageView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setScaleType(ScaleType.MATRIX);
        gestureDetectorCompat = new GestureDetectorCompat(getContext(), new ScrollListener());
        scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        gestureDetectorCompat.onTouchEvent(event);
        scaleGestureDetector.onTouchEvent(event);
        return true;
    }

    float scrollX = getScrollX();
    float scrollY = getScrollY();

    private class ScrollListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            scrollX += distanceX;
            scrollY += distanceY;

            scrollX = Math.max(0f, Math.min(scrollX, getDrawable().getIntrinsicWidth()));
            scrollY = Math.max(0f, Math.min(scrollY, getDrawable().getIntrinsicHeight()));

            scrollTo((int)scrollX, (int)scrollY);
            return true;
        }
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector){
            sclaeFactor *= detector.getScaleFactor();
            sclaeFactor = Math.max(0.1f, Math.min(sclaeFactor, 2f));

            matrix = new Matrix(getImageMatrix());
            matrix.setScale(sclaeFactor, sclaeFactor, detector.getFocusX(), detector.getFocusY());
            setImageMatrix(matrix);
            return true;
        }
    }
}
