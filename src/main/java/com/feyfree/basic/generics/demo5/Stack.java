package com.feyfree.basic.generics.demo5;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * 简单的栈结构的实现 泛型版本-泛型转换
 *
 * @author leilei  form Effective Java
 */
public class Stack<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();//确保容量足够
        elements[size++] = e;
    }

    /**
     * 这里都是需要返回E
     * 所以这里的转换是安全的
     */
    @SuppressWarnings("unchecked")
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (E) elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }


    public boolean isEmpty() {
        return this.elements == null || this.elements.length <= 0;
    }

    /**
     * 所有E的子类的集合都可以添加进来
     *
     * @param iter
     */
    public void pushAll(Iterable<? extends E> iter) {
        for (E e : iter) {
            this.push(e);
        }
    }

    /**
     * 可以将elements里面的元素全部弹出到E得超类中
     *
     * @param dst
     */
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }
}