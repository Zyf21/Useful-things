import java.awt.*;

public class Rectangle {
    public static void main(String[] args) {

        double test = 0.5;
        Point leftBottom = new Point();
 //       leftBottom.setLocation(51.998971,-4.601693);
        leftBottom.setLocation(0.0,0.0);
        Point rightTop = new Point();
//        rightTop.setLocation(54.320117,-0.284130);
        rightTop.setLocation(10.0,10.0);
        double startX = leftBottom.getX();
        double startY = leftBottom.getY();
        //51.998971, -4.601693
        //54.320117, -0.284130


//        System.out.println("Start " + startX + startY );
//        double y;
//       while (startY < rightTop.getY()){
//            y = startY + test;
//            startY = startY + test;
//            if(startX < rightTop.getX()){
//                double x = startX + test;
//                System.out.println("x=" + x + " y=" + y);
//                startX = startX + test;
//                //System.out.println("finish");
//            }
//            System.out.println(startY);
//        }
//
       double y;
       for( startY = leftBottom.getY();startY < rightTop.getY(); startY = startY+test){
           for(startX = leftBottom.getX();startX < rightTop.getX(); startX = startX+test){
               System.out.println("x=" + startX + " y=" + startY);

           }
       }





    }
}
