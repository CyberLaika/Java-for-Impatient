package theory.treeSplain;

public class Line implements Spline{

    double coeffA;
    double timeDuration;

    public Line(double coeffA, double timeDuration) {
        this.coeffA = coeffA;
        this.timeDuration=timeDuration;
    }

    @Override
    public double getTimeDuration() {
        return timeDuration;
    }

    @Override
    public int getSplineType() {
        return 1;
    }

    @Override
    public String toString() {
        return "Line{" +
                "coeffA=" + coeffA +
                ", timeDuration=" + timeDuration +
                '}';
    }
}
