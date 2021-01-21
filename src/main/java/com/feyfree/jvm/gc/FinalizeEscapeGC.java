package com.feyfree.jvm.gc;

/**
 * 一次对象的自我拯救的演示
 * 此代码演示了两点
 * <p>
 * 1. 对象可以在被GC 的时候自我拯救
 * 2. 这种自救的机会只有一次， 因为一个对象的finalize() 方法最多只会被系统自动调用一次
 *
 * @author leilei
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("Yes, I am still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        // 对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc();

        // 因为finalize 方法优先级很低， 暂停0.5 s, 以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, I am dead!");
        }

        // 下面的代码和上面的完全相同， 但是这次自我拯救失败了
        SAVE_HOOK = null;
        System.gc();

        // 因为finalize 方法优先级很低， 暂停0.5 s, 以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, I am dead!");
        }

    }
}
