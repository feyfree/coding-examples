package com.feyfree.redis;

import java.util.Random;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

/**
 * redis lock 的三种实现
 * <p>
 * lock是基于setnx实现加锁、
 * lock2是基于multi事务的方式
 * lock3是watch加Transaction
 *
 * @author leilei
 */
public class RedisLock {

    /**
     * 加锁标志
     */
    public static final String LOCKED = "TRUE";
    public static final long ONE_MILLI_NANOS = 1000000L;
    /*
     * 默认超时时间（毫秒）
     * */
    public static final long DEFAULT_TIME_OUT = 3000;
    public static JedisPool pool;
    public static final Random R = new Random();

    //锁的超时时间（秒），过期删除
    public static final int EXPIRE = 5 * 60;

    private final Jedis jedis;
    private final String key;
    //锁状态标志
    private boolean locked = false;

    public RedisLock(String key) {
        this.key = key;
        this.jedis = new Jedis("127.0.0.1", 6379, 60000);
    }

    /**
     * 通过jedis.setnx实现锁
     *
     * @param timeout
     * @return
     */
    public boolean lock(long timeout) {
        long nano = System.nanoTime();
        timeout *= ONE_MILLI_NANOS;
        try {
            while ((System.nanoTime() - nano) < timeout) {
                if (jedis.setnx(key, LOCKED) == 1) {
                    jedis.expire(key, EXPIRE);
                    locked = true;
                    return locked;
                }
                // 短暂休眠，nano避免出现活锁
                Thread.sleep(3, R.nextInt(500));
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    /**
     * 事务和管道都是异步模式。在事务和管道中不能同步查询结果，因此下面 t.getSet(key, LOCKED);只能被一个线程查询
     * 否则线程获取不到
     *
     * @param timeout
     * @return
     */
    public boolean lock2(long timeout) {
        long nano = System.nanoTime();
        timeout *= ONE_MILLI_NANOS;
        try {
            while ((System.nanoTime() - nano) < timeout) {
                Transaction t = jedis.multi();
                // 开启事务，当server端收到multi指令
                // 会将该client的命令放入一个队列，然后依次执行，知道收到exec指令
                t.getSet(key, LOCKED);
                t.expire(key, EXPIRE);
                String ret = (String) t.exec().get(0);
                System.out.println(Thread.currentThread() + " ========== " + ret);
                if ("TRUE".equalsIgnoreCase(ret)) {
                    return true;
                }
                // 短暂休眠，nano避免出现活锁
                Thread.sleep(3, R.nextInt(500));
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    public boolean lock3(long timeout) {
        long nano = System.nanoTime();
        timeout *= ONE_MILLI_NANOS;
        try {
            while ((System.nanoTime() - nano) < timeout) {
                jedis.watch(key);
                // 开启watch之后，如果key的值被修改，则事务失败，exec方法返回null
                String value = jedis.get(key);
                if (value == null || "UNLOCK".equals(value)) {
                    Transaction t = jedis.multi();
                    t.setex(key, EXPIRE, LOCKED);
                    if (t.exec() != null) {
                        return true;
                    }
                }
                jedis.unwatch();
                // 短暂休眠，nano避免出现活锁
                Thread.sleep(3, R.nextInt(500));
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    public boolean lock() {
        return lock(DEFAULT_TIME_OUT);
    }

    /**
     * 无论是否加锁成功，必须调用
     */
    public void unlock() {
        if (locked) {
            jedis.del(key);
        }
    }

}