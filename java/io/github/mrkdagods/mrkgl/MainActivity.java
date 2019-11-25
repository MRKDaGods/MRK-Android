package io.github.mrkdagods.mrkgl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("mrk");
        System.loadLibrary("mrkproxy");
    }

    MRKGLView m_View;
    GLSurfaceView m_BackGL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        m_BackGL = new GLSurfaceView(getApplicationContext(), null);
        m_BackGL.setEGLContextClientVersion(2);
        m_BackGL.setRenderer(new GLSurfaceView.Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
            }

            @Override
            public void onSurfaceChanged(GL10 gl10, int i, int i1) {
            }

            @Override
            public void onDrawFrame(GL10 gl10) {
                gl10.glClearColor(0.f, 0.f, 0.f, 1.f);
                gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
            }
        });

        setContentView(m_BackGL);

        m_View = new MRKGLView(getApplicationContext(), null);
        addContentView(m_View, new WindowManager.LayoutParams());
    }
}
