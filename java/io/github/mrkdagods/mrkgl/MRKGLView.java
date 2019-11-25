package io.github.mrkdagods.mrkgl;

import android.content.Context;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MRKGLView extends GLSurfaceView {
    private MRKGLRenderer m_Renderer;

    public MRKGLView(Context context, AttributeSet attr)
    {
        super(context);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(PixelFormat.RGBA_8888);
        setZOrderOnTop(true);

        m_Renderer = new MRKGLRenderer();
        setRenderer(m_Renderer);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        MRKNativeBridge.MRKNativeTouchEvent((int) event.getX(), (int) event.getY(), event.getAction() == MotionEvent.ACTION_DOWN ? 0 :
                event.getAction() == MotionEvent.ACTION_UP ? 1 : event.getAction() == MotionEvent.ACTION_MOVE ? 2 : -1);

        return super.dispatchTouchEvent(event);
    }
}
