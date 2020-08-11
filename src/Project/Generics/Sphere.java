package Project.Generics;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Sphere implements Shape, Serializable{
    private double radius;

    public Sphere(double radius){
        this.radius =radius;
    }

    @Override
    //getVolume
    public double getVolume(){
        return  3.14 * radius * radius * radius * 4 / 3 ;
    }

    public String toString(){
        return "Type of shape: Sphere, Radius is: " + radius + ", Volume is: " + getVolume();
    }
    // returns a string which includes the type of shape, the radius, and the volume.


}
