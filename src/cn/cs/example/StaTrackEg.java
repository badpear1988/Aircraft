package cn.cs.example;

import cn.cs.cal.CalTrack;

import java.util.ArrayList;
import java.util.List;

public class StaTrackEg {

    public static void main(String[] args) {
        double[][] trackArray = {{24.826,-22.5444,2.28E7},
                {24.8476,-22.5227,2.2809E7},
                {24.8693,-22.511,2.2827E7},
                {24.8909,-22.4943,2.2836E7},
                {24.9126,-22.4775,2.2854E7},
                {24.9342,-22.4608,2.2863E7},
                {24.9559,-22.4441,2.2872E7},
                {24.9775,-22.4274,2.289E7},
                {24.9992,-22.4107,2.2899E7},
                {25.0208,-22.3939,2.2908E7}};

        double[][] routeArray = {{24.824,-22.5444,2.28E7},
                {24.8477,-22.5227,2.2809E7},
                {24.8695,-22.511,2.2827E7},
                {24.8902,-22.4943,2.2836E7},
                {24.9123,-22.4775,2.2854E7},
                {24.9344,-22.4608,2.2863E7},
                {24.0000,-22.4441,2.2872E7},
                {24.9775,-22.4274,2.289E7},
                {24.9992,-22.4700,2.2899E7},
                {25.0208,-22.3939,2.2908E7}};

        List disRangeList = new ArrayList();
        disRangeList = CalTrack.calTrackDis(trackArray,routeArray);

        for(Object disRange : disRangeList){
            System.out.println("飞机飞行航迹" + disRange);
        }

        List angleRangleList = new ArrayList();
        angleRangleList = CalTrack.calTrackAngle(trackArray,routeArray);

        for(Object angleRange : angleRangleList){
            System.out.println("飞机飞行" + angleRange);
        }
    }
}
