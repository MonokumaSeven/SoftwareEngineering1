package org.hbrs.se1.ws24.exercises.uebung10;

public class BoundingBoxFactory {

    public BoundingBoxFactory() {

    }

    public MyPrettyRectangle calcBoundingBox(MyPrettyRectangle[] rectangles){
        MyPrettyRectangle rec;

        if (rectangles == null){
            rec = new MyPrettyRectangle(0, 0, 0, 0);
            return rec;
        }

        double x1 = rectangles[0].x1;
        double y1 = rectangles[0].y1;
        double x2 = rectangles[0].x2;
        double y2 = rectangles[0].y2;

        for(MyPrettyRectangle r : rectangles){
            if (x1>r.x1){
                x1 = r.x1;
            }
            if (y1>r.y1){
                y1 = r.y1;
            }
            if (x2<r.x2){
                x2 = r.x2;
            }
            if (y2<r.y2){
                y2 = r.y2;
            }
        }
        rec = new MyPrettyRectangle(x1, y1, x2, y2);
        return rec;
    }
}
