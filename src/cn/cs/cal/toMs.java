package cn.cs.cal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class toMs {
    public static void main(String args[]) throws ParseException {
        String sTime = "14:21:48";
        //日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        //将字符串设置为规定格式
        Date date = sdf.parse(sTime);
        //将时间转换为毫秒
        double msDate = date.getTime();
        System.out.println(msDate);
    }
}
