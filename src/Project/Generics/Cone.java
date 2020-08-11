package Project.Generics;

import java.io.Serializable;

@SuppressWarnings("serial") // google later
public class Cone implements Shape, Serializable{

    private double height;
    private double radius;

    public Cone(double height, double radius){
        this.height = height;
        this.radius = radius;
    }

    @Override
    //getVolume
    public double getVolume(){
        return 3.14 * radius * radius * height / 3 ; // this one works
        // 1/3 * 3.14 * r * r *h doesnt work ???
    }

    public String toString(){
        return "Type of shape: Cone, Radius is: " + radius + ", Volume is: " + getVolume();
    }
    // returns a string which includes the type of shape, the radius, and the volume.




}