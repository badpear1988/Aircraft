package cn.cs.cal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalSpeed {

    /**
     *
     * @param st1,st2
     * @return timeDif
     */
    private static double calTimeDif(String st1,String st2) throws ParseException {

        //日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //将字符串设置为规定格式
        Date date1 = sdf.parse(st1);
        Date date2 = sdf.parse(st2);

        //计算两个时间差，值为毫秒
        double timeDif = date2.getTime() - date1.getTime();

        //返回值单位为小时
        return timeDif /(1000 * 3600);
    }

    /**
     *
     * @param st1
     * @param st2
     * @param lon1
     * @param lat1
     * @param lon2
     * @param lat2
     * @return speed,返回值为速度，单位为千米/小时
     * @throws ParseException
     */
    public static double aircraftSpeed(String st1,String st2,double lon1, double lat1, double lon2, double lat2) throws ParseException{
        double timeDif = calTimeDif(st1,st2);
        double dis = CalDis.LantitudeLongitudeDist(lon1,lat1,lon2,lat2);
        double speed = dis / timeDif;
        return speed;
    }

    public static List staSpeed(double[][] scArray){
        List speedList = new ArrayList();

        for(int i = 0;i <= scArray.length - 2; i ++){
            double dis = CalDis.LantitudeLongitudeDist(scArray[i][1],scArray[i][0],scArray[i+1][1],scArray[i+1][0]);
            double timeDif = (scArray[i+1][2] - scArray[i][2]) / (1000 * 3600);
            double speed = dis / timeDif;
            speedList.add(speed);
        }
        return speedList;
    }


}
