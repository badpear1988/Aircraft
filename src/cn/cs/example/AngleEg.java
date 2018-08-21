package cn.cs.example;

import cn.cs.cal.CalAngle;

public class AngleEg {

    public static void main(String args[]){
        double[][] arrayA = {{28.231,111.625},
                {28.236,111,600},
                {28.237,111.584}};

        double angle = CalAngle.calAangle(arrayA);

        System.out.println("目前转向角为：" + angle + "°");

    }
}
