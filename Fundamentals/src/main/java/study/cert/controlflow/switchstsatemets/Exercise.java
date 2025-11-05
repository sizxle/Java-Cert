package study.cert.controlflow.switchstsatemets;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise {

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");

        int number= Integer.parseInt(scanner.next());

        if(number%5==0 && number%2==0){
            System.out.print("FizzBuzz");
        }else if( number%5==0){
            System.out.print("Fizz");
        }else if( number%3==0){
            System.out.print("Buzz");
        }else{
            System.out.print(number);
        }

    }
}
