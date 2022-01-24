package com.ssrlive.socksdroid;

class System
{
    static {
        java.lang.System.loadLibrary("system");
    }

    public static native int sendfd(int fd, String sock);
    public static native void jniclose(int fd);
}
