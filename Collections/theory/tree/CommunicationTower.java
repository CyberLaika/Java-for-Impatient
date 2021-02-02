package theory.tree;

public class CommunicationTower {
    private double x;
    private double y;
    private double radius;
    private String company;
    private int towerId;
    public CommunicationTower(double x, double y,  double radius, String company, int towerId){
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.company=company;
        this.towerId=towerId;
    }

    public String getCompany() {
        return company;
    }

    public int getTowerId() {
        return towerId;
    }
    public double distance(double x, double y){
        return Math.sqrt(Math.pow(this.x-x,2)+Math.pow(this.y-y,2));
    }
    public boolean inRadius(double x, double y){
        return radius >= distance(x, y);
    }

    @Override
    public String toString() {
        return "CommunicationTower{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ", company='" + company + '\'' +
                ", towerId=" + towerId +
                '}';
    }
}
