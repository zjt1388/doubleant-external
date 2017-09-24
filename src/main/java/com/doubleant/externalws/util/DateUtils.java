package com.doubleant.externalws.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator
 * on 2017/9/23.
 */
public class DateUtils {

    public static final String defaultFormat = "yyyy-MM-dd HH:mm:ss";

    public static String toString(Date date){
        return new SimpleDateFormat(defaultFormat).format(date);
    }

    public static Date now(){
        return new Date();
    }
}
