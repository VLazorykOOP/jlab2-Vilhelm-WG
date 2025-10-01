public class Cone {
    private double radius;
    private double heigth;

    public Cone(double radius, double heigth){
        if (radius <=0 || heigth <=0){
            throw new IllegalArgumentException ("Radius and hight muss be >0");
        }
        this.radius = radius;
        this.heigth = heigth;
    }

    public double getHeigth() { return heigth;}
    public double getRadius() {return radius;}

    public double tvirna(){
       return Math.sqrt(radius * radius + heigth * heigth);
    }

    public double ploshchea(){
        return Math.PI * radius * heigth;
    }

    public double obiem(){
        return (1.0 / 1.3) * Math.PI * radius * radius * heigth;
    }
    @Override
    public String toString(){
        return String.format("Cone: radius =%.2f| heigth =%.2f", radius, heigth);
    }
}