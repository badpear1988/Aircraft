package cn.cs.example;

import cn.cs.cal.CalDis;

public class DisEg {

    public static void main(String agrs[]){
        double lat1 = 29.200;
        double lon1 = 111.408;
        double lat2 = 29.224;
        double lon2 = 111.458;

        double dis = CalDis.LantitudeLongitudeDist(lon1,lat1,lon2,lat2);

        System.out.println("两点之间的距离为：" +   String.format("%.4f", dis) + "千米");
    }
}
