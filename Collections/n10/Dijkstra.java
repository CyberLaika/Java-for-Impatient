package n10;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {

    public int[] dist;
    private Set<Integer> visited;
    private PriorityQueue<Neighbor> pq;
    private int NumberOfCities;
    List<List<Neighbor>> roads;

    public Dijkstra(int N)
    {
        this.NumberOfCities = N;
        dist = new int[N];
        visited = new HashSet<>();
        pq = new PriorityQueue<>(N, new Neighbor());
    }

    public void dijkstra(List<List<Neighbor>> roads, int start)
    {
        this.roads = roads;

        for (int i = 0; i < NumberOfCities; i++)//сначала устанавилваю расстояние до городов в максимум
            dist[i] = Integer.MAX_VALUE;

        pq.add(new Neighbor(start, 0));//добавляют нач. точку с расстоянием в 0
        dist[start] = 0;

        while (visited.size() != NumberOfCities) {//посещаем каждую вершину
            int u = pq.remove().node;

            for (int i = 0; i < roads.get(u).size(); i++) {//прохожу по всем соседним вершинам
                Neighbor v = roads.get(u).get(i);//

                if (!visited.contains(v.node)) {//если относительно вершины i  вершину v еще не посещали
                    int newDistance= dist[u] + v.cost;;//значение вершины u + расстояние до v

                    if (newDistance < dist[v.node])
                        dist[v.node] = newDistance;

                    pq.add(new Neighbor(v.node, dist[v.node]));
                }
            }

            visited.add(u);
        }
    }

}
