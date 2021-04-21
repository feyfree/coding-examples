package com.feyfree.basic.objects;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * 对象示例
 *
 * @author leilei
 */
public class ObjectsSample {

    public static void main(String[] args) {
        System.out.println(VM.current().details());
        Object obj = new Object();
        System.out.println(obj + " 十六进制哈希: " + Integer.toHexString(obj.hashCode()));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
