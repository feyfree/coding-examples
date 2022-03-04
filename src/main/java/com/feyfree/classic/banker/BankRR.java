package com.feyfree.classic.banker;

import java.util.Scanner;

/**
 * copy from network  命名优化了一点
 * <p>
 * 银行家算法数据结构
 * 1. 每个进程的对资源的最大需求数量
 * 2. 每个进程当前分配的资源数量
 * 3. 每个进程剩余需要的资源数量
 * 步骤
 * 1. 轮询检查申请是否超过了之前声明的最大需求数量
 * 2. 检查此时系统剩余的可用资源是否能满足这次的需求
 * 3. 尝试分配， 并更改数据结构
 * 4. 用安全性算法检查此次分配是否会导致系统进入不安全状态
 * 安全算法步骤
 * 1. 检查当前剩余是否能满足某个进程， 如果能满足则把该进程加入安全序列， 并把资源全部回收
 * 2. 轮询重复上述进程， 观察是否能将所有进程都加入安全序列
 */
public class BankRR {
    /**
     * 进程数量
     */
    int pcbNums;

    /**
     * 资源种类数量
     */
    int resNums;

    /**
     * 进程数组
     */
    Proc[] pcbs;

    /**
     * 最大需求资源向量
     */
    int[] max;

    /**
     * 拥有资源数向量
     */
    int[] alloc;

    /**
     * 还需要资源数向量
     */
    int[] need;

    /**
     * 可用资源数向量
     */
    int[] ava;

    /**
     * 安全序列数组
     */
    char[] safeSeq;

    /**
     * 安全序列
     */
    boolean safeStatus = false;

    public void bankInit() {
        // A sample
		/*   Max   Alloc  Need   Avai
		 - a 7 5 3, 0 1 0, 7 4 3, 3 3 2
		 - b 3 2 2, 2 0 0, 1 2 2
		 - c 9 0 2, 3 0 2, 6 0 0
		 - d 2 2 2, 2 1 1, 0 1 1
		 - e 4 3 3, 0 0 2, 4 3 1
		 */
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        System.out.println("一共有几个进程：");
        pcbNums = in.nextInt();
        System.out.println("一共有几个资源");
        resNums = in.nextInt();
        // 创建进程数组
        pcbs = new Proc[pcbNums];
        // 可用资源
        ava = new int[resNums];
        // 安全序列
        safeSeq = new char[pcbNums];
        for (int i = 0; i < pcbs.length; i++) {
            // 最大资源
            max = new int[resNums];
            // 拥有资源
            alloc = new int[resNums];
            // 需要资源
            need = new int[resNums];
            System.out.println("-----------------------");
            System.out.println("输入第" + (i + 1) + "个进程信息(名字-最大资源-拥有资源)");
            System.out.println("名字：");
            char name = in.next().charAt(0);
            System.out.println("最大资源：");
            for (int j = 0; j < resNums; j++) {
                max[j] = in.nextInt();
            }
            System.out.println("拥有资源：");
            for (int j = 0; j < resNums; j++) {
                alloc[j] = in.nextInt();
            }
            for (int j = 0; j < resNums; j++) {
                need[j] = max[j] - alloc[j];
            }
            pcbs[i] = new Proc(name, max, alloc, need);
        }
        System.out.println("---可用资源---：");
        for (int j = 0; j < resNums; j++) {
            ava[j] = in.nextInt();
        }
    }

    public void process() {
        int safeCount = 0;
        while (safeCount != pcbNums) {
            for (int i = 0; i < pcbNums; i++) {
                // 判断该pcb是否完成
                if (!pcbs[i].finishStatus) {
                    for (int j = 0; j < resNums; j++) {
                        int nowRes = pcbs[i].getNeedRes()[j];
                        if (nowRes <= ava[j]) {
                            pcbs[i].finishStatus = true;
                        } else {
                            pcbs[i].finishStatus = false;
                            break;
                        }
                    }
                    // 如果该pcb可以完成，则完成后回收资源
                    if (pcbs[i].finishStatus) {
                        for (int j = 0; j < resNums; j++) {
                            ava[j] += pcbs[i].getNeedRes()[j];
                        }
                        safeSeq[safeCount] = pcbs[i].getName();
                        safeCount++;
                    }
                }
            }
            for (int i = 0; i < pcbNums; i++) {
                if (pcbs[i].finishStatus) {
                    // 这地方是否会存在死循环， 比如第一个进程  完成了， 这个safeStatus 会一直是 true ?
                    safeStatus = true;
                    break;
                } else {
                    safeStatus = false;
                }
            }
            if (!safeStatus) {
                break;
            }
        }
        if (safeStatus) {
            System.out.println("该系统安全，安全序列为：");
            for (int i = 0; i < pcbNums; i++) {
                System.out.print(safeSeq[i] + " ");
            }
        } else {
            System.out.println("该系统不安全");
        }
    }

    public static void main(String[] args) {
        BankRR test = new BankRR();
        test.bankInit();
        test.process();
    }
}