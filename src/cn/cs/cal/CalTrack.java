package cn.cs.cal;

import cn.cs.entity.Angle;

import java.util.ArrayList;
import java.util.List;



public class CalTrack {

    private static final double DRIFT = 0.100;
    private static final double CLOSE = 0.050;
    private static final double ANGLE = 0.010;

    /**
     * 求航迹与航线的差距
     * @param tracksArray
     * @param routeArray
     * @return 返回值为List，内容为航迹是否偏移
     */
    public static List calTrackDis(double[][] tracksArray,double[][] routeArray){
        List disRangeList = new ArrayList();
        String disRange;
        for(int i = 0;i < tracksArray.length -1;i ++){
            double difDis = CalDis.LantitudeLongitudeDist(tracksArray[i][1],tracksArray[i][0],routeArray[i][1],routeArray[i][0]);
            if(difDis <= CLOSE){
                disRange = "进入固定区域";
            }else if(difDis > CLOSE && difDis <= DRIFT){
                disRange = "靠近固定区域";
            }else{
                disRange = "偏离航线";
            }
            disRangeList.add(disRange);
        }
        return disRangeList;
    }

    public static List calTrackAngle(double[][] tracksArray, double[][] routeArray){

        List angleRangeList = new ArrayList();
        double angleDif;
        String angleRange = null;

        List<Angle> trackList = new ArrayList<Angle>();
        List<Angle> routeList = new ArrayList<Angle>();

        trackList = CalAngle.staAangleList(tracksArray);
        routeList = CalAngle.staAangleList(routeArray);

        for (int i = 0;i < trackList.size(); i ++){
            angleDif = trackList.get(i).getAngle() - routeList.get(i).getAngle();
            if(angleDif > ANGLE || angleDif < -ANGLE){
                angleRange = "航向偏离";
            }else if(angleDif >= -ANGLE && angleDif <= ANGLE){
                angleRange = "航向正常";
            }
            angleRangeList.add(angleRange);
        }
        return angleRangeList;
    }
}
