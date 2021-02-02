package theory.tree;

import java.util.*;

public class Internet {

    public static TreeMap<Double,CommunicationTower> getNearestTowers(double x, double y, List<CommunicationTower> towers){
         TreeMap<Double,CommunicationTower> nearestTowers  = new TreeMap<>();
        for(CommunicationTower ct: towers)
            if(ct.inRadius(x,y))
                nearestTowers.put(ct.distance(x,y),ct);
        return nearestTowers;
    }

    public static TreeMap<Double,List<CommunicationTower>> getNearestTowers2(double x, double y, List<CommunicationTower> towers){
        TreeMap<Double,List<CommunicationTower>> nearestTowers  = new TreeMap<>();
        for(CommunicationTower ct: towers)
            if(ct.inRadius(x,y)){
                List<CommunicationTower> arrTow=nearestTowers.getOrDefault(ct.distance(x,y), new ArrayList<>());
                arrTow.add(ct);
                nearestTowers.put(ct.distance(x,y),arrTow);}
        return nearestTowers;
    }


    public static void main(String[] args) {
        ArrayList<CommunicationTower> towers= new ArrayList<>();

        towers.add(  new CommunicationTower(21.135,34.561,10,"BeebLine",11));
        towers.add(  new CommunicationTower(3.851,9.517,12,"MegantoPhone",21));
        towers.add(  new CommunicationTower(15.289,5.956,20,"MGS",31));
        towers.add(  new CommunicationTower(57.682,14.724,5,"KulatkaPhone",41));
        towers.add(  new CommunicationTower(17.224,11.477,15,"Volna",51));
        towers.add(  new CommunicationTower(31.121,2.698,18,"Tele3",61));
        towers.add(  new CommunicationTower(5.124,14.573,10,"BeebLine",12));
        towers.add(  new CommunicationTower(16.521,10.176,18,"Tele3",62));
        towers.add(  new CommunicationTower(11.416,7.320,18,"Tele3",63));
        towers.add(  new CommunicationTower(0,2,18,"Tele3",64));
        towers.add(  new CommunicationTower(2,0,18,"Tele3",65));
        towers.add(  new CommunicationTower(6.224,9.477,15,"Volna",52));


       /* TreeMap<Double,CommunicationTower> nearestTowers=getNearestTowers(9.713,12.451,towers);
        for(Map.Entry<Double,CommunicationTower> tower: nearestTowers.entrySet())
            System.out.println(tower.toString());*/

        System.out.println();
        TreeMap<Double,List<CommunicationTower>> nearestTowers2=getNearestTowers2(0,0,towers);
        double k0=0;
        for(int i=0;i<3;i++) {
            Map.Entry<Double,List<CommunicationTower>> entry= nearestTowers2.higherEntry(k0);
            k0=entry.getKey();
            System.out.println(entry.toString());
        }
        //for(Map.Entry<Double,List<CommunicationTower>> tower: nearestTowers2.entrySet())
           // System.out.println(tower.toString());
    }
}
