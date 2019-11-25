#pragma once

namespace MRK
{
    namespace GUI
    {
        typedef void(*MRKProxyGUICallback)();

        extern int MRKProxyRegisterGUICallback(MRKProxyGUICallback callback);
        extern void MRKProxySetColor(float r, float g, float b, float a);
        extern void MRKProxyLabel(float x, float y, float w, float h, const char* txt, float fontsize);
        extern void MRKProxyBox(float x, float y, float w, float h);
        extern void MRKProxyLine(float x1, float y1, float x2, float y2, float width);
        extern void MRKProxyGetScreenInfo(float* w, float* h, float* pr);
    }
}