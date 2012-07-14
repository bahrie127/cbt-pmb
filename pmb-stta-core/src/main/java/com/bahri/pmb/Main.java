package com.bahri.pmb;

import com.bahri.pmb.util.RandomUtil;

import java.util.GregorianCalendar;

/**
 * Created by IntelliJ IDEA.
 * User: latief
 * Date: 3/29/12
 * Time: 8:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args){
//        boolean b = false;
//        Long b=new GregorianCalendar().getTimeInMillis(); //271088165510156
//        System.out.println(((1L << 48) - 1));
//
        for(int i=0;i<20;i++){
            System.out.println(RandomUtil.nextRandom(20));
        }

    }
}
