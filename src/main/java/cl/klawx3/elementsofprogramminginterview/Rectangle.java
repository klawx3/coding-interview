package cl.klawx3.elementsofprogramminginterview;

public class Rectangle {
 
    public Point buttonLeft;
    public Point topLeft;
    public Point buttonRight;
    public Point topRight;

    public int area;

    public Rectangle(Point buttonLeft,Point topRight){
        this.buttonLeft = buttonLeft;
        this.topRight = topRight;

        this.topLeft = new Point(buttonLeft.x,topRight.y);
        this.buttonRight = new Point(topRight.x,buttonLeft.y);

        this.area = Math.abs(buttonLeft.x - buttonRight.x) * Math.abs(buttonRight.y - topRight.y);
    }


    public int getArea(){
        return area;
    }

    public static Rectangle getNewRectangleIfIntersect(Rectangle r1,Rectangle r2){
        if(isIntersectionV2(r1, r2)){
            Rectangle lowerX = r1.buttonRight.x > r2.buttonRight.x ? r2 : r1;
            Rectangle higherX = r1.buttonRight.x > r2.buttonRight.x ? r1 : r2;

            int diffX = Math.abs(Math.abs(r1.buttonLeft.x - r1.buttonRight.x) - Math.abs(r2.buttonLeft.x - r2.buttonRight.x));
            int x2 = higherX.buttonRight.x - diffX;
            int x1 = x2 - diffX;

            Rectangle lowerY = r1.topRight.y > r2.topRight.y ? r2 : r1;
            Rectangle higherY = r1.topRight.x > r2.topRight.x ? r1 : r2;
            
            int diffY = Math.abs(lowerY.topRight.y - higherY.topRight.y);
            int y2 = higherY.topRight.y - diffY;
            int y1 = y2 - diffY;

            Point buttonLeft = new Point(x1,y1);
            Point topRight = new Point(x2, y2);

            return new Rectangle(buttonLeft, topRight);
        }
        return null;
    }

    public static boolean isIntersection(Rectangle r1,Rectangle r2){
        boolean xAxies = (r2.buttonLeft.x  >= r1.buttonLeft.x && r2.buttonLeft.x  <= r1.buttonRight.x) ||
                         (r2.buttonRight.x >= r1.buttonLeft.x && r2.buttonRight.x <= r1.buttonRight.x) ;
        boolean yAxies = (r2.buttonLeft.y  >= r1.buttonLeft.y && r2.buttonLeft.y  <= r1.topLeft.y) ||
                         (r2.topLeft.y     >= r1.buttonLeft.y && r2.topLeft.y     <= r1.topLeft.y);
        return xAxies && yAxies;
    }

    public static boolean isIntersectionV2(Rectangle r1,Rectangle r2){
        return (r1.buttonLeft.x <= r2.buttonRight.x && r1.buttonRight.x >= r2.buttonLeft.x) &&
               (r1.buttonLeft.y <= r2.topLeft.y && r1.topLeft.y >= r2.buttonLeft.y);
    }

    public static boolean isContained(Rectangle r1,Rectangle r2){
        Rectangle t1 = r1;
        Rectangle t2 = r2;
        if(r1.getArea() < r2.getArea()){
            t1 = r2;
            t2 = r1;
        }
        return t1.buttonLeft.x <= t2.buttonLeft.x && t1.buttonLeft.y <= t2.buttonLeft.y
                && t1.topRight.x >= t2.topRight.x && t1.topRight.y >= t2.topRight.y;
    }

    @Override
    public String toString(){
        return String.format("ButtonLeft : (%d,%d) , TopRight: (%d,%d)",buttonLeft.x,buttonLeft.y,topLeft.x,topLeft.y);
    }


    

}
