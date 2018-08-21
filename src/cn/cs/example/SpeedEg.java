package cn.cs.example;

import cn.cs.cal.CalSpeed;

import java.text.ParseException;

public class SpeedEg {

    public static void main(String agrs[]) throws ParseException{

        String st1 = "2018-08-20 14:20:00";
        String st2 = "2018-08-20 14:20:09";

        /*double lat1 = 29.200;
        double lon1 = 111.408;
        double lat2 = 29.224;
        double lon2 = 111.458;*/

        double lat1 = 24.826;
        double lon1 = -22.5444;
        double lat2 = 24.8476;
        double lon2 = -22.5227;

        double speed = CalSpeed.aircraftSpeed(st1,st2,lon1,lat1,lon2,lat2);

        System.out.println("飞机的飞行速度为：" + String.format("%.4f", speed) + "千米\\小时");

    }


}
