package com.feyfree.algs4;

import com.feyfree.algs4.StdDraw;
import com.feyfree.algs4.StdRandom;

/******************************************************************************
 *  Compilation:  javac InsertionBars.java
 *  Execution:    java InsertionBars N
 *  Dependencies: StdDraw.java
 *
 *  Insertion sort n random real numbers between 0 and 1, visualizing
 *  the results by ploting bars with heights proportional to the values.
 *
 *  % java InsertionBars 20
 *
 ******************************************************************************/


public class InsertionBars {
    public static void sort(double[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j >= 1 && less(a[j], a[j - 1])) {
                exch(a, j, j - 1);
                j--;
            }
            show(a, i, j);
        }
    }

    private static void show(double[] a, int i, int j) {
        StdDraw.setYscale(-a.length + i + 0.8, i + 0.8);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int k = 0; k < j; k++) {
            StdDraw.filledRectangle(k, a[k] * 0.3, 0.25, a[k] * 0.3);
        }

        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.filledRectangle(j, a[j] * 0.3, 0.25, a[j] * 0.3);

        StdDraw.setPenColor(StdDraw.BLACK);
        for (int k = j + 1; k <= i; k++) {
            StdDraw.filledRectangle(k, a[k] * 0.3, 0.25, a[k] * 0.3);
        }
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int k = i + 1; k < a.length; k++) {
            StdDraw.filledRectangle(k, a[k] * 0.3, 0.25, a[k] * 0.3);
        }
    }

    private static boolean less(double v, double w) {
        return v < w;
    }

    private static void exch(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setCanvasSize(160, 640);
        StdDraw.setXscale(-1, n + 1);
        StdDraw.setPenRadius(0.006);
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(0.0, 1.0);
        }
        sort(a);
    }

}