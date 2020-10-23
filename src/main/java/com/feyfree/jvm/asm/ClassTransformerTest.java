package com.feyfree.jvm.asm;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static jdk.internal.org.objectweb.asm.Opcodes.ASM4;
import static jdk.internal.org.objectweb.asm.Opcodes.INVOKESTATIC;

public class ClassTransformerTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassReader cr = new ClassReader(ClassPrinter.class.getClassLoader().getResourceAsStream("com/feyfree/jvm/asm/Tank.class"));

        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ClassVisitor(ASM4, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                return new MethodVisitor(ASM4, mv) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC, "com/feyfree/jvm/asm/TimeProxy.java", "before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };

        cr.accept(cv, 0);
        byte[] b2 = cw.toByteArray();
        MyClassLoader cl = new MyClassLoader();
        cl.loadClass("com.feyfree.jvm.asm.TimeProxy");
        Class c2 = cl.defineClass("com.feyfree.jvm.asm.Tank", b2);
        c2.getConstructor().newInstance();

        String path = (String) System.getProperties().get("user.dir");
        File f = new File(path + "com/feyfree/jvm/asm/");

        f.mkdirs();

        FileOutputStream fos = new FileOutputStream(new File(path + "/com/feyfree/jvm/asm/Tank_0.class"));
        fos.write(b2);
        fos.flush();
    }


}
