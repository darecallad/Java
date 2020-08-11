package Project.Generics;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Ellipsoid implements Shape, Serializable{
    private double radius1;
    private double radius2;
    private double radius3;


    public Ellipsoid(double radius1, double radius2, double radius3){
        this.radius1 = radius1;
        this.radius2 = radius2;
        this.radius3 = radius3;
    }

    @Override
    //getVolume
    public double getVolume(){
        return 3.14 * radius1 * radius2 * radius3 * 4 / 3;
    }

    public String toString(){
        return "Type of shape: Ellipsoid, Radius 1 is: " + radius1 + " Radius 2 is: " + radius2 + " Radius 3 is: " + radius3 +
                ", Volume is: " + getVolume();
    }
    // returns a string which includes the type of shape, the radius, and the volume.

}