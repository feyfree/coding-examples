package com.feyfree.jvm.dispatch;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

import static java.lang.invoke.MethodHandles.lookup;

public class Test {
    class GrandFather {
        void thinking() {
            System.out.println("I am grandfather");
        }
    }

    class Father extends GrandFather {
        @Override
        void thinking() {
            System.out.println("I am father");
        }
    }

    class Son extends Father {
        @Override
        void thinking() {
            // version 1
            // output : I am father
//            try {
//                MethodType mt = MethodType.methodType(void.class);
//                MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
//                mh.invoke(this);
//            } catch (Throwable e) {
//                e.printStackTrace();
//            }

            // version 2
            // output : I am grandfather
            try {
                MethodType mt = MethodType.methodType(void.class);
                Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                lookupImpl.setAccessible(true);
                MethodHandle mh = ((MethodHandles.Lookup) lookupImpl.get(null)).findSpecial(GrandFather.class, "thinking", mt, GrandFather.class);
                mh.invoke(this);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        (new Test().new Son()).thinking();
    }
}
