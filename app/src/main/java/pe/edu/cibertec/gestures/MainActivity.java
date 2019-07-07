package pe.edu.cibertec.gestures;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Touch_Event";
    private static final String IMAGE_TAG = "Touch_Event_Image";
    private ImageView imgTouch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListeners();
    }

    private void setListeners() {
        imgTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getActionMasked();
                switch (action){
                    case (MotionEvent.ACTION_DOWN):
                        Log.i(IMAGE_TAG, "Se presionó la imagen");
                        return true;

                    case (MotionEvent.ACTION_MOVE):
                        Log.i(IMAGE_TAG, "Se movió la imagen(?)");
                        return true;

                    case (MotionEvent.ACTION_UP):
                        Log.i(IMAGE_TAG, "Se subió la imagen(?)");
                        return true;

                    case (MotionEvent.ACTION_CANCEL):
                        Log.i(IMAGE_TAG, "Se canceló la imagen(?)");
                        return true;

                    case (MotionEvent.ACTION_OUTSIDE):
                        Log.i(IMAGE_TAG, "Se outsideó la imagen(?)");
                        return true;
                }
                return false;
            }
        });
    }

    private void initView(){
        imgTouch = findViewById(R.id.imgTouch);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();

        switch (action){
            case (MotionEvent.ACTION_DOWN):
                Log.i(TAG, "Acción de mover hacía abajo");
                return true;

            case (MotionEvent.ACTION_MOVE):
                Log.i(TAG, "Acción de moverse");
                return true;

            case (MotionEvent.ACTION_CANCEL):
                Log.i(TAG, "Acción de cancelar");
                return true;

            case (MotionEvent.ACTION_UP):
                Log.i(TAG, "Acción de mover hacía arriba");
                return true;

            case (MotionEvent.ACTION_OUTSIDE):
                Log.i(TAG, "Acción de outsidear(?)");
                return true;

            default:
                return super.onTouchEvent(event);
        }
    }
}
