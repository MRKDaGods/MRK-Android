package io.github.mrkdagods.mrkgl;

public class MRKNativeBridge {
    public static native void MRKNativeInit(int width, int height, float dpr);
    public static native void MRKNativeRender();
    public static native void MRKNativeTouchEvent(int x, int y, int type);

    public static native void MRKProxyInit();
}
