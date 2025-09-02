package study.cert.types;

import java.awt.*;

public class TypeMemoryManagement {

    /**
     * Primitives:
     *      Copies the values
     *  Reference:
     *      Copies the address
     */

    public static void main(String[] args) {
        int x=1;
        int y=3;
        x=4;

        System.out.println(x);
        System.out.println(y);


        Point p1= new Point(1,3);
        Point p2= p1;

        p1.x=4;

        System.out.println(p1);
        System.out.println(p2);

        String s1="jj";
        String s2=s1;

        s1.toUpperCase();

        System.out.println(s1);

        System.out.println(s2);
    }


}
