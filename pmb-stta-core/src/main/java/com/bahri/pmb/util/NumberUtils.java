package com.bahri.pmb.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 3/29/12
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class NumberUtils {
    
    public static String floatToStringFormat(float f){
        NumberFormat format = DecimalFormat.getInstance();
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        return format.format((double) f);
    }
    
}
