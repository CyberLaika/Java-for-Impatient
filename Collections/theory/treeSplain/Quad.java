package theory.treeSplain;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Quad implements Spline{

    double a;
    double b;
    double timeDuration;

    public Quad(double a, double b, double timeDuration) {
        this.a = a;
        this.b = b;
        this.timeDuration=timeDuration;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public double getTimeDuration() {
        return timeDuration;
    }

    @Override
    public int getSplineType() {
        return 2;
    }

    @Override
    public String toString() {
        return "Quad{" +
                "a=" + a +
                ", b=" + b +
                ", timeDuration=" + timeDuration +
                '}';
    }
}
