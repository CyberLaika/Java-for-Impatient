package n10;

import java.util.ArrayList;
import java.util.List;

public class Main10 {
    public static void main(String arg[])
    {
        int NumberOfCities = 6;
        int startCity = 0;
        List<List<Neighbor> > roads = new ArrayList<>();


        for (int i = 0; i < NumberOfCities; i++) {
            List<Neighbor> item = new ArrayList<>();
            roads.add(item);
        }


        roads.get(0).add(new Neighbor(1, 7));
        roads.get(0).add(new Neighbor(2, 9));
        roads.get(0).add(new Neighbor(5, 14));

        roads.get(1).add(new Neighbor(0, 7));
        roads.get(1).add(new Neighbor(2, 10));
        roads.get(1).add(new Neighbor(3, 15));

        roads.get(2).add(new Neighbor(0, 9));
        roads.get(2).add(new Neighbor(1, 10));
        roads.get(2).add(new Neighbor(3, 11));
        roads.get(2).add(new Neighbor(5, 2));

        roads.get(3).add(new Neighbor(1, 11));
        roads.get(3).add(new Neighbor(2, 15));
        roads.get(3).add(new Neighbor(4, 6));

        roads.get(4).add(new Neighbor(3, 6));
        roads.get(4).add(new Neighbor(5, 9));

        roads.get(5).add(new Neighbor(0, 14));
        roads.get(5).add(new Neighbor(2, 2));
        roads.get(5).add(new Neighbor(4, 9));


        Dijkstra dijkstra = new Dijkstra(NumberOfCities);
        dijkstra.dijkstra(roads, startCity);


        System.out.println("The shorted road from city :");
        for (int i = 0; i < dijkstra.dist.length; i++)
            System.out.println(startCity + " to city" + i + " is "
                    + dijkstra.dist[i]);
    }
}
