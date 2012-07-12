package com.bahri.pmb.util;

import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 7/4/12
 * Time: 11:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class RandomUtil {

    protected static final AtomicLong seed=new AtomicLong();

    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;

    public static int nextRandom(int n) {
        int bits, val;
        do {
            bits = next(31);
            val = bits % n;
        } while(bits - val + (n-1) < 0);
        return val;
    }

    protected static int next(int bits) {
        long oldseed, nextseed;
        AtomicLong seed = RandomUtil.seed;
        do {
            oldseed = seed.get();
            if(oldseed==0){
                seed.set(new GregorianCalendar().getTimeInMillis());
                oldseed = seed.get();
            }
            nextseed = (oldseed * multiplier + addend) & mask;
        } while (!seed.compareAndSet(oldseed, nextseed));
        return (int)(nextseed >>> (48 - bits));
    }
}

