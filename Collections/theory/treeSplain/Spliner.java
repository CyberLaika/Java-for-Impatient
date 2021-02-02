package theory.treeSplain;

import java.util.Map;
import java.util.TreeMap;

public class Spliner {


    public static void changePoint(Map<ControlPoint,Spline> map, ControlPoint oldKey, ControlPoint newKey){
        Spline spline = map.remove(oldKey);
        map.put(newKey, spline);
    }

    public static ControlPoint giveControlPoint(TreeMap<ControlPoint,Spline> map, double x){
        Map.Entry<ControlPoint,Spline> point=map.lowerEntry(new ControlPoint(x,0));
        if(point.getValue().getTimeDuration()+point.getKey().getX()>x)
            return point.getKey();
        else
            return null;
    }

    public static void main(String[] args) {
        TreeMap<ControlPoint,Spline> splines = new TreeMap<>();
        splines.put(new ControlPoint(20,10),new Line(1.5,20));
        splines.put(new ControlPoint(27,5),new Quad(-1,0,10));
        splines.put(new ControlPoint(0,0),new Line(2,5));
        splines.put(new ControlPoint(7,10),new Line(0,10));
        splines.put(new ControlPoint(40,23),new Quad(1.68,-4.2,13));
        splines.put(new ControlPoint(35,15),new Line(4,10));

        for(Map.Entry<ControlPoint,Spline> entry : splines.entrySet()) {
            System.out.println("Point => "+entry.getKey().toString() + " Spline => " + entry.getValue());
        }

        changePoint(splines,new ControlPoint(0,0),new ControlPoint(4,2));
        splines.put(new ControlPoint(0,0),new Quad(4.3,3.1,5));
        changePoint(splines,new ControlPoint(35,15),new ControlPoint(45,15));

        System.out.println();

        for(Map.Entry<ControlPoint,Spline> entry : splines.entrySet()) {
            System.out.println("Point => "+entry.getKey().toString() + " Spline => " + entry.getValue());
        }


        System.out.println("Control Point for x=39 is "+giveControlPoint(splines,39));
        System.out.println("Control Point for x=49 is "+giveControlPoint(splines,49));
    }
}
