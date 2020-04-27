package com.feyfree.others;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestJedisMulti {

    @Test
    public void testMultiJedisOp() throws InterruptedException {
        GenericObjectPoolConfig<Object> config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(20);
        JedisPool cPool = new JedisPool(config, "127.0.0.1", 6379);
        Thread threadA = new Thread() {
            @Override
            public void run() {
                try (Jedis resource = cPool.getResource()) {
                    op(resource, "test", "a");
                }
            }
        };
        Thread threadB = new Thread() {
            @Override
            public void run() {
                try (Jedis resource = cPool.getResource()) {
                    op(resource, "test", "b");
                }
            }
        };
        Thread threadC = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    op(cPool.getResource(), "test", "c");
                }
            }
        };
        Thread threadD = new Thread() {
            @Override
            public void run() {
                try (Jedis resource = cPool.getResource()) {
                    op(resource, "test", "d");
                }
            }
        };
        Thread threadE = new Thread() {
            @Override
            public void run() {
                try (Jedis resource = cPool.getResource()) {
                    op(resource, "test", "e");
                }
            }
        };
        Thread threadF = new Thread() {
            @Override
            public void run() {
                try (Jedis resource = cPool.getResource()) {
                    op(resource, "test", "f");
                }
            }
        };
        Thread threadG = new Thread() {
            @Override
            public void run() {
                try (Jedis resource = cPool.getResource()) {
                    op(resource, "test", "g");
                }
            }
        };
        Thread threadH = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try (Jedis resource = cPool.getResource()) {
                        op(resource, "test", "h");
                    }
                }

            }
        };
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
        threadF.start();
        threadG.start();
        threadH.start();


        threadA.join();
        threadB.join();
        threadC.join();
        threadD.join();
        threadE.join();
        threadF.join();
        threadG.join();
        threadH.join();
    }

    private void op(Jedis conn, String key, String msg) {
        conn.rpush(key, msg);
        Long len = conn.llen(key);
        if (len > 20) {
            conn.ltrim(key, len - 20, -1);
        }
        System.out.println("当前key的缓存长度" + conn.llen(key));
    }


}
