//package com.feyfree.jvm.asm;
//
//import jdk.internal.org.objectweb.asm.*;
//
//import java.io.IOException;
//
//import static jdk.internal.org.objectweb.asm.Opcodes.ASM4;
//
///**
// * @author leilei
// */
//public class ClassPrinter extends ClassVisitor {
//
//    ClassPrinter() {
//        super(ASM4);
//    }
//
//    @Override
//    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
//        System.out.println(name + " extends " + superName + " {");
//    }
//
//    @Override
//    public void visitSource(String source, String debug) {
//    }
//
//    @Override
//    public void visitOuterClass(String owner, String name, String desc) {
//    }
//
//    @Override
//    public AnnotationVisitor visitAnnotation(String desc,
//                                             boolean visible) {
//        return null;
//    }
//
//    @Override
//    public void visitAttribute(Attribute attr) {
//    }
//
//    @Override
//    public void visitInnerClass(String name, String outerName,
//                                String innerName, int access) {
//    }
//
//    @Override
//    public FieldVisitor visitField(int access, String name, String desc,
//                                   String signature, Object value) {
//        System.out.println(" " + desc + " " + name);
//        return null;
//    }
//
//    @Override
//    public MethodVisitor visitMethod(int access, String name,
//                                     String desc, String signature, String[] exceptions) {
//        System.out.println(" " + name + desc);
//        return null;
//    }
//
//    @Override
//    public void visitEnd() {
//        System.out.println("}");
//    }
//
//
//    public static void main(String[] args) throws IOException {
//        ClassPrinter classPrinter = new ClassPrinter();
//        ClassReader classReader = new ClassReader("java.lang.Runnable");
//        ClassReader classReader1 = new ClassReader(ClassPrinter.class.getClassLoader().getResourceAsStream("com/feyfree/algs4/Accumulator.class"));
//        classReader.accept(classPrinter, 0);
//        classReader1.accept(classPrinter, 0);
//    }
//}
