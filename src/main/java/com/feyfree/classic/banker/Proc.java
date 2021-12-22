package com.feyfree.classic.banker;

public class Proc {
    char name;
    /**
     * 最大申请数量
     */
    int[] maxRes;
    /**
     * 已经申请的数量
     */
    int[] allocRes;

    /**
     * 当前需要申请的数量
     */
    int[] needRes;

    /**
     * 初始状态
     */
    boolean finishStatus;

    public Proc(char name, int[] max, int[] alloc, int[] need) {
        this.name = name;
        this.maxRes = max;
        this.allocRes = alloc;
        this.needRes = need;
        this.finishStatus = false;
    }

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void setMaxRes(int[] maxRes) {
        this.maxRes = maxRes;
    }

    public int[] getMaxRes() {
        return maxRes;
    }

    public void setAllocRes(int[] allocRes) {
        this.allocRes = allocRes;
    }

    public int[] getAllocRes() {
        return allocRes;
    }

    public void setNeedRes(int[] needRes) {
        this.needRes = needRes;
    }

    public int[] getNeedRes() {
        return needRes;
    }
}