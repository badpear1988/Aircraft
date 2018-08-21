package cn.cs.example;

import cn.cs.cal.CalAngle;
import cn.cs.entity.Angle;

import java.util.ArrayList;
import java.util.List;

public class StaAangleEg {
    public static void main(String args[]){
        double[][] scArray = {{24.826,-22.5444,2.28E7},
        {24.8476,-22.5227,2.2809E7},
        {24.8693,-22.511,2.2827E7},
        {24.8909,-22.4943,2.2836E7},
        {24.9126,-22.4775,2.2854E7},
        {24.9342,-22.4608,2.2863E7},
        {24.9559,-22.4441,2.2872E7},
        {24.9775,-22.4274,2.289E7},
        {24.9992,-22.4107,2.2899E7},
        {25.0208,-22.3939,2.2908E7}};

        List<Angle> angleList = new ArrayList<Angle>();
        angleList = CalAngle.staAangleList(scArray);

        System.out.println("该航线的转向角为:");
        for(int i = 0;i < angleList.size();i ++){
            System.out.println(angleList.get(i).getAngle() + "°");
        }
    }
}
