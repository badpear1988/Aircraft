package cn.cs.cal;


import cn.cs.entity.Angle;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class CalAngle {
    /**
     * 转化为弧度(rad)
     */
    private static double rad(double d) {

        return d * Math.PI / 180.0;
    }

    /**
     * 将经纬度转换为空间坐标
     * @param lon
     * @param lat
     */
    public static double[] toSpaceCoordinate(double lon, double lat){

        double EARTH_RADIUS = 6378.137; //地球半径，单位为千米

        DecimalFormat df = new DecimalFormat("#.0000");

        double radLon = rad(lon);
        double radLat = rad(lat);

        double temp = EARTH_RADIUS * Math.cos(radLat);
        double x = temp * Math.sin(radLon);
        double y = EARTH_RADIUS * Math.sin(radLat);
        double z = temp * Math.cos(radLon);


        double[] scArray = new double[] {x,y,z};

        return scArray;

    }

    /**
     * 计算向量
     * @param scArray1
     * @param scArray2
     * @return
     */
    public static double[] calVector(double[] scArray1,double[] scArray2){
        double vABX = scArray2[0] -scArray1[0];
        double vABY = scArray2[1] -scArray1[1];
        double vABZ = scArray2[2] -scArray1[2];

        double[] vArray = new double[] {vABX,vABY,vABZ};

        return vArray;
    }

    /**
     * 计算两个向量的夹角
     * @param lonlatArray
     * @return 返回值为角度，单位为度
     */
    public static double calAangle(double[][] lonlatArray){

        //将经纬度转换为空间坐标
        double[] scArrayA = new double[3];
        double[] scArrayB = new double[3];
        double[] scArrayC = new double[3];
        scArrayA = CalAngle.toSpaceCoordinate(lonlatArray[0][0],lonlatArray[0][1]);
        scArrayB = CalAngle.toSpaceCoordinate(lonlatArray[1][0],lonlatArray[1][1]);
        scArrayC = CalAngle.toSpaceCoordinate(lonlatArray[2][0],lonlatArray[2][1]);

        //计算每两个点的向量
        double[] vArrayAB = new double[3];
        double[] vArrayBC = new double[3];
        vArrayAB = CalAngle.calVector(scArrayA,scArrayB);
        vArrayBC = CalAngle.calVector(scArrayB,scArrayC);


        //计算两个向量的夹角
        //分子,两个向量相乘
        double vAmvB = vArrayAB[0] * vArrayBC[0] + vArrayAB[1] * vArrayBC[1] + vArrayAB[2] * vArrayBC[2] ;

        double vA = Math.sqrt(Math.pow(vArrayAB[0],2) + Math.pow(vArrayAB[1],2) + Math.pow(vArrayAB[2],2));
        double vB = Math.sqrt(Math.pow(vArrayBC[0],2) + Math.pow(vArrayBC[1],2) + Math.pow(vArrayBC[2],2));

        double cosAB = vAmvB / vA * vB;

        if(cosAB < -1.0){
            cosAB = -1.0;
        }else if(cosAB > 1.0){
            cosAB = 1.0;
        }

        double vAngle = Math.toDegrees(Math.acos(cosAB));

        return vAngle;

    }

    /**
     *
     * @param scArray
     * @return 返回值为统计该航迹每三个点的转向角
     */
    public static List<Angle> staAangleList(double[][] scArray){

        List<Angle> angleList = new ArrayList<Angle>();

        for(int i = 0;i <= scArray.length - 3; i ++){
            double[] scArrayA = new double[3];
            double[] scArrayB = new double[3];
            double[] scArrayC = new double[3];
            scArrayA = CalAngle.toSpaceCoordinate(scArray[i][0],scArray[i][1]);
            scArrayB = CalAngle.toSpaceCoordinate(scArray[i+1][0],scArray[i+1][1]);
            scArrayC = CalAngle.toSpaceCoordinate(scArray[i+2][0],scArray[i+2][1]);

            //计算每两个点的向量
            double[] vArrayAB = new double[3];
            double[] vArrayBC = new double[3];
            vArrayAB = CalAngle.calVector(scArrayA,scArrayB);
            vArrayBC = CalAngle.calVector(scArrayB,scArrayC);


            //计算两个向量的夹角
            //分子,两个向量相乘
            double vAmvB = vArrayAB[0] * vArrayBC[0] + vArrayAB[1] * vArrayBC[1] + vArrayAB[2] * vArrayBC[2] ;

            double vA = Math.sqrt(Math.pow(vArrayAB[0],2) + Math.pow(vArrayAB[1],2) + Math.pow(vArrayAB[2],2));
            double vB = Math.sqrt(Math.pow(vArrayBC[0],2) + Math.pow(vArrayBC[1],2) + Math.pow(vArrayBC[2],2));

            double cosAB = vAmvB / vA * vB;

            if(cosAB < -1.0){
                cosAB = -1.0;
            }else if(cosAB > 1.0){
                cosAB = 1.0;
            }

            double vAngle = Math.toDegrees(Math.acos(cosAB));
            Angle angle = new Angle();
            angle.setAngle(vAngle);

            angleList.add(angle);
        }
        return angleList;
    }



}
