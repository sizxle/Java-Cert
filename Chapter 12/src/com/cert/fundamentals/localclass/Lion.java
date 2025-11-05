package com.cert.fundamentals.localclass;

public class Lion {
        class Cub {}
        static class Den {}
        static void rest() {
            Den den = new Lion.Den();
            boolean b = den instanceof Den;
            System.out.println(b);
        }

        public static void main(String[] args) {
            rest();
        }
}
