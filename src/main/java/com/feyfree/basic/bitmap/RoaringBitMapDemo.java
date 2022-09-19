package com.feyfree.basic.bitmap;

import org.roaringbitmap.longlong.LongBitmapDataProvider;
import org.roaringbitmap.longlong.LongIterator;
import org.roaringbitmap.longlong.Roaring64NavigableMap;

/**
 * @author leilei
 */
public class RoaringBitMapDemo {
    public static void main(String[] args) {
        // first Roaring64NavigableMap
        LongBitmapDataProvider r = Roaring64NavigableMap.bitmapOf(1, 2, 100, 1000);
        r.addLong(1234);
        r.addLong(123455689009L);
        // true
        System.out.println(r.contains(1));
        // false
        System.out.println(r.contains(3));
        LongIterator i = r.getLongIterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
