package study.cert.expressions;

import java.text.NumberFormat;

public class Main {


    public static void main(String[] args) {
        int x =1;
//        ++x;
        System.out.println(++x);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println(currency.format(23445.34));
    }
}
