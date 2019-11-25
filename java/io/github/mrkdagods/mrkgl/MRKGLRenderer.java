package io.github.mrkdagods.mrkgl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MRKGLRenderer implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int w, int h) {
        MRKNativeBridge.MRKNativeInit(w, h, w/h);

        MRKNativeBridge.MRKProxyInit();
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        MRKNativeBridge.MRKNativeRender();
    }
}
