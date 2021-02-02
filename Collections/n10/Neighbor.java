package n10;

import java.util.Comparator;

public class Neighbor implements Comparator<Neighbor> {
        public int node;
        public int cost;

        public Neighbor()
        {
        }

        public Neighbor(int node, int cost)
        {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Neighbor node1, Neighbor node2)
        {
            if (node1.cost < node2.cost)
                return -1;
            if (node1.cost > node2.cost)
                return 1;
            return 0;
        }
    }
