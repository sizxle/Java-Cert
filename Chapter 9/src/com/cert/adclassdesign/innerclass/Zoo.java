package com.cert.adclassdesign.innerclass;

public class Zoo {
//    public interface Paper{}
    public class Ticket{

        static String name="sizxle";

        public static int number = 0;

    public static String getName() {
        return name;
    }
}

    public static void main(String[] args) {

        Zoo zoo = new Zoo();

        Ticket ticket= zoo.new Ticket();

        System.out.println(ticket.name);

    }
}
