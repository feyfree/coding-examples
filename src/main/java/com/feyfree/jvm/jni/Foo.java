package com.feyfree.jvm.jni;

public class Foo {
    int i = 0xDEADBEEF;

    public static native void foo();

    public native void bar(int i, long j);

    public native void bar(String s, Object o);
}
