package org.hbrs.se1.ws24.exercises.uebung10;

public class MyPrettyRectangle {
    double x1;
    double y1;
    double x2;
    double y2;

    public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean contains(MyPrettyRectangle r) {
        return (r.x1 >= this.x1) && (y1 >= this.y1) && (r.x2 <= this.x2) && (y2 <= this.y2);
    }

    public MyPoint getCenter(MyPrettyRectangle r){
        double x12 = r.x1 + ((r.x2-r.x1)/2);
        double y12 = r.y1 + ((r.y2-r.y1)/2);
        return new MyPoint (x12,y12);
    }

    public double getArea (MyPrettyRectangle r){
        return (r.x2-r.x1)*(r.y2-r.y1);
    }

    public double getPerimeter (MyPrettyRectangle r){
        return 2*(r.x2-r.x1)+2*(r.y2-r.y1);
    }
}
